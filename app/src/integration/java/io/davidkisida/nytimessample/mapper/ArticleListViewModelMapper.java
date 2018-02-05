package io.davidkisida.nytimessample.mapper;

import java.util.ArrayList;

import io.davidkisida.nytimessample.api.model.ArticleApiModel;
import io.davidkisida.nytimessample.api.model.MostViewedApiModel;
import io.davidkisida.nytimessample.list.model.ArticleListViewModel;
import io.davidkisida.nytimessample.list.model.ArticleViewModel;

public final class ArticleListViewModelMapper {

    private ArticleListViewModelMapper() {
        // utility class
    }

    public static ArticleListViewModel from(MostViewedApiModel apiModel) {
        ArticleListViewModel viewModel = new ArticleListViewModel();


        ArrayList<ArticleViewModel> articleViewModels = new ArrayList<>();
        for (ArticleApiModel articleApiModel : apiModel.getResults()) {
            articleViewModels.add(ArticleViewModelMapper.from(articleApiModel));
        }
        viewModel.setArticleViewModelList(articleViewModels);

        return viewModel;
    }

}
