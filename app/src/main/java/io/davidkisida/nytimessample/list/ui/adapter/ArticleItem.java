package io.davidkisida.nytimessample.list.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.text.SimpleDateFormat;

import io.davidkisida.nytimessample.R;
import io.davidkisida.nytimessample.list.model.ArticleViewModel;

public class ArticleItem {

    private final ArticleViewModel viewModel;
    private final OnArticleClickListener listener;

    public ArticleItem(ArticleViewModel articleViewModel, OnArticleClickListener listener) {
        this.viewModel = articleViewModel;
        this.listener = listener;
    }

    public static ArticleViewHolder createViewHolder(ViewGroup parent) {
        return new ArticleViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_article, parent, false));
    }

    public void bind(ArticleViewHolder holder) {
        holder.titleItemArticle.setText(viewModel.getTitle());
        holder.subTitleItemArticle.setText(viewModel.getSubTitle());
        holder.bylineItemArticle.setText(viewModel.getByline());
        holder.publishDateItemArticle.setText(SimpleDateFormat.getDateInstance().format(viewModel.getPublishDate()));

        Glide.with(holder.itemView)
                .load(viewModel.getImageUrl())
                .apply(RequestOptions.centerCropTransform())
                .apply(RequestOptions.placeholderOf(R.drawable.image_placeholder))
                .into(holder.imageItemArticle);

        holder.itemView.setOnClickListener(v -> {
            listener.onArticleClicked(viewModel);
        });
    }

    public static class ArticleViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageItemArticle;
        private final TextView titleItemArticle;
        private final TextView subTitleItemArticle;
        private final TextView bylineItemArticle;
        private final TextView publishDateItemArticle;

        ArticleViewHolder(View itemView) {
            super(itemView);

            imageItemArticle = itemView.findViewById(R.id.imageItemArticle);
            titleItemArticle = itemView.findViewById(R.id.titleItemArticle);
            subTitleItemArticle = itemView.findViewById(R.id.subTitleItemArticle);
            bylineItemArticle = itemView.findViewById(R.id.bylineItemArticle);
            publishDateItemArticle = itemView.findViewById(R.id.publishDateItemArticle);
        }
    }

    public interface OnArticleClickListener {
        void onArticleClicked(ArticleViewModel viewModel);
    }
}
