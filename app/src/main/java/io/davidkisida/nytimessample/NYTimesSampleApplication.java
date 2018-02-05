package io.davidkisida.nytimessample;

import android.app.Activity;
import android.app.Application;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class NYTimesSampleApplication extends Application implements HasActivityInjector {

    private static NYTimesSampleApplication instance;

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        component = DaggerApplicationComponent.builder()
                .application(this)
                .context(this)
                .build();
        component.inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }

    public ApplicationComponent getComponent() {
        return component;
    }

    public static NYTimesSampleApplication getInstance() {
        return instance;
    }
}
