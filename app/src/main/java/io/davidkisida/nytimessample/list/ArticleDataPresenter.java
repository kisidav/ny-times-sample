package io.davidkisida.nytimessample.list;

import io.davidkisida.nytimessample.list.model.ArticleListViewModel;
import io.reactivex.Observable;

public interface ArticleDataPresenter {

    Observable<ArticleListViewModel> loadArticles();
}
