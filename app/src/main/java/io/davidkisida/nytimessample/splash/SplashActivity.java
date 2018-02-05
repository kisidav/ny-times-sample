package io.davidkisida.nytimessample.splash;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import org.androidannotations.annotations.EActivity;

import java.util.concurrent.TimeUnit;

import io.davidkisida.nytimessample.list.ui.ArticleListActivityImpl;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import timber.log.Timber;

@EActivity
public class SplashActivity extends RxAppCompatActivity {

    public static final int SPLASH_DELAY = 1500;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Observable.timer(SPLASH_DELAY, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(l -> startApplication(), Timber::d);
    }

    private void startApplication() {
        ArticleListActivityImpl.intent(this).start();
        finish();
    }
}
