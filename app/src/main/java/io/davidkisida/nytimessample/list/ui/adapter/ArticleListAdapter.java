package io.davidkisida.nytimessample.list.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import io.davidkisida.nytimessample.list.model.ArticleViewModel;

public class ArticleListAdapter extends RecyclerView.Adapter<ArticleItem.ArticleViewHolder> {

    private final List<ArticleItem> items = new ArrayList<>();
    private ArticleItem.OnArticleClickListener listener;

    public ArticleListAdapter(@NonNull ArticleItem.OnArticleClickListener listener) {
        this.listener = listener;
    }

    public void swapItems(@NonNull List<ArticleViewModel> articleViewModelList) {
        items.clear();

        for (ArticleViewModel articleViewModel : articleViewModelList) {
            items.add(new ArticleItem(articleViewModel, listener));
        }

        notifyDataSetChanged();
    }

    private ArticleItem getItem(int position) {
        return items.get(position);
    }

    @Override
    public ArticleItem.ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return ArticleItem.createViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(ArticleItem.ArticleViewHolder holder, int position) {
        getItem(position).bind(holder);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
