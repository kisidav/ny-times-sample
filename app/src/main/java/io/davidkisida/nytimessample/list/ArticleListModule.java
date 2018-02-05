package io.davidkisida.nytimessample.list;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ArticleListModule {

    @Binds
    abstract ArticleDataPresenter bindArticleDataPresenter(DefaultArticleDataPresenter presenter);
}
