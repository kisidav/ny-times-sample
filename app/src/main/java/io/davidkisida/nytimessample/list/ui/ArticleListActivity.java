package io.davidkisida.nytimessample.list.ui;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;

import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.InstanceState;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.ColorRes;
import org.androidannotations.annotations.res.DimensionPixelSizeRes;

import javax.inject.Inject;

import io.davidkisida.nytimessample.R;
import io.davidkisida.nytimessample.common.BaseActivity;
import io.davidkisida.nytimessample.common.ErrorDialogFragment;
import io.davidkisida.nytimessample.common.ErrorDialogFragmentImpl;
import io.davidkisida.nytimessample.details.ui.ArticleDetailsActivityImpl;
import io.davidkisida.nytimessample.list.ArticleDataPresenter;
import io.davidkisida.nytimessample.list.model.ArticleListViewModel;
import io.davidkisida.nytimessample.list.model.ArticleViewModel;
import io.davidkisida.nytimessample.list.ui.adapter.ArticleItem;
import io.davidkisida.nytimessample.list.ui.adapter.ArticleListAdapter;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

@EActivity(R.layout.activity_list)
public class ArticleListActivity extends BaseActivity implements ArticleItem.OnArticleClickListener {

    @ViewById
    SwipeRefreshLayout swipeRefreshArticleList;

    @ViewById
    RecyclerView recyclerViewArticleList;

    @ViewById
    FrameLayout progressWrapperList;

    @Inject
    ArticleDataPresenter presenter;

    @InstanceState
    ArticleListViewModel viewModel;

    @DimensionPixelSizeRes
    int articleItemDividerSize;

    @ColorRes
    int articleItemDividerColor;

    private ArticleListAdapter adapter;

    @AfterViews
    void afterViews() {
        adapter = new ArticleListAdapter(this);
        recyclerViewArticleList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerViewArticleList.setHasFixedSize(true);
        recyclerViewArticleList.addItemDecoration(new HorizontalDividerItemDecoration.Builder(this)
                .size(articleItemDividerSize)
                .color(articleItemDividerColor)
                .build());
        recyclerViewArticleList.setAdapter(adapter);

        swipeRefreshArticleList.setOnRefreshListener(this::refreshArticles);
        swipeRefreshArticleList.setColorSchemeResources(R.color.colorAccent);

        if (viewModel == null) {
            progressWrapperList.setVisibility(View.VISIBLE);
            refreshArticles();
        } else {
            progressWrapperList.setVisibility(View.GONE);
            initFromViewModel(viewModel);
        }
    }

    private void refreshArticles() {
        presenter.loadArticles()
                .compose(applyTransformers())
                .subscribe(viewModel -> {
                    this.viewModel = viewModel;
                    initFromViewModel(viewModel);
                }, Timber::d);
    }

    private void initFromViewModel(ArticleListViewModel viewModel) {
        adapter.swapItems(viewModel.getArticleViewModelList());
    }

    private <T> ObservableTransformer<T, T> applyTransformers() {
        return observable -> observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(showErrorDialog())
                .doOnTerminate(() -> {
                    progressWrapperList.setVisibility(View.GONE);
                    swipeRefreshArticleList.setRefreshing(false);
                });
    }

    private Consumer<Throwable> showErrorDialog() {
        return throwable -> ErrorDialogFragmentImpl.builder()
                .build()
                .show(getSupportFragmentManager(), ErrorDialogFragment.class.getSimpleName());
    }

    @Override
    public void onArticleClicked(ArticleViewModel viewModel) {
        ArticleDetailsActivityImpl.intent(this).url(viewModel.getLinkUrl()).start();
    }
}
