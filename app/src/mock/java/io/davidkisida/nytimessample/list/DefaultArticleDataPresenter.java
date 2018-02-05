package io.davidkisida.nytimessample.list;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Date;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.davidkisida.nytimessample.list.model.ArticleListViewModel;
import io.davidkisida.nytimessample.list.model.ArticleViewModel;
import io.reactivex.Observable;

@Singleton
public class DefaultArticleDataPresenter implements ArticleDataPresenter {

    @Inject
    DefaultArticleDataPresenter() {
        // Dagger needs an injectable constructor
    }

    @Override
    public Observable<ArticleListViewModel> loadArticles() {
        ArrayList<ArticleViewModel> articleViewModels = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            articleViewModels.add(createArticleViewModel(i));
        }
        ArticleListViewModel articleListViewModel = new ArticleListViewModel();
        articleListViewModel.setArticleViewModelList(articleViewModels);
        return Observable.just(articleListViewModel);
    }

    @NonNull
    private ArticleViewModel createArticleViewModel(int position) {
        ArticleViewModel articleViewModel = new ArticleViewModel();
        articleViewModel.setTitle("A Sprinkle, a Snapshot, a Sensation: My Dinner With Salt Bae #" + position);
        articleViewModel.setImageUrl("https://static01.logo.com/images/2012/11/14/dining/14REST1_SPAN/14REST1_SPAN-superJumbo.jpg");
        articleViewModel.setSubTitle("Pete Wells submits to the meme, and the copious meat, at a Turkish steakhouse where the chef is world-famous for his salt-flicking technique.");
        articleViewModel.setPublishDate(new Date());
        articleViewModel.setByline("By PETE WELLS");
        articleViewModel.setLinkUrl("http://www.nytimes.com/2012/11/14/dining/reviews/restaurant-review-guys-american-kitchen-bar-in-times-square.html");
        return articleViewModel;
    }
}
