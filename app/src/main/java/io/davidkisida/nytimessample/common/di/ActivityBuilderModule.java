package io.davidkisida.nytimessample.common.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import io.davidkisida.nytimessample.list.ArticleListModule;
import io.davidkisida.nytimessample.list.ui.ArticleListActivityImpl;

@Module
public abstract class ActivityBuilderModule {

    @PerActivity
    @ContributesAndroidInjector(modules = ArticleListModule.class)
    abstract ArticleListActivityImpl bindArticleListActivity();

}
