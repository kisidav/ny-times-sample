package io.davidkisida.nytimessample;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import io.davidkisida.nytimessample.common.DefaultGlideModule;
import io.davidkisida.nytimessample.common.di.ActivityBuilderModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class, ActivityBuilderModule.class})
public interface ApplicationComponent extends BaseApplicationComponent {

    void inject(DefaultGlideModule defaultGlideModule);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        @BindsInstance
        Builder context(Context context);

        ApplicationComponent build();
    }

}
