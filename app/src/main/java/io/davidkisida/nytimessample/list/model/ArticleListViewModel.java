package io.davidkisida.nytimessample.list.model;

import org.parceler.Parcel;

import java.util.List;

@Parcel
public class ArticleListViewModel {

    List<ArticleViewModel> articleViewModelList;

    public List<ArticleViewModel> getArticleViewModelList() {
        return articleViewModelList;
    }

    public void setArticleViewModelList(List<ArticleViewModel> articleViewModelList) {
        this.articleViewModelList = articleViewModelList;
    }
}
