package io.davidkisida.nytimessample.list;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.davidkisida.nytimessample.BuildConfig;
import io.davidkisida.nytimessample.api.ApiClient;
import io.davidkisida.nytimessample.list.model.ArticleListViewModel;
import io.davidkisida.nytimessample.mapper.ArticleListViewModelMapper;
import io.reactivex.Observable;

@Singleton
public class DefaultArticleDataPresenter implements ArticleDataPresenter {
    private static final String SECTION = "all-sections";
    private static final int TIME_PERIOD = 7;
    private final ApiClient apiClient;

    @Inject
    DefaultArticleDataPresenter(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    @Override
    public Observable<ArticleListViewModel> loadArticles() {
        return apiClient.mostViewed(SECTION, TIME_PERIOD, BuildConfig.API_KEY)
                .map(ArticleListViewModelMapper::from);
    }
}
