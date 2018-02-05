package io.davidkisida.nytimessample.common;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.Excludes;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.integration.okhttp3.OkHttpLibraryGlideModule;
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.AppGlideModule;

import java.io.InputStream;

import javax.inject.Inject;

import io.davidkisida.nytimessample.NYTimesSampleApplication;
import okhttp3.OkHttpClient;

@Excludes(OkHttpLibraryGlideModule.class)
@GlideModule
public class DefaultGlideModule extends AppGlideModule {

    @Inject
    OkHttpClient httpClient;

    public DefaultGlideModule() {
        NYTimesSampleApplication.getInstance().getComponent().inject(this);
    }

    @Override
    public boolean isManifestParsingEnabled() {
        return false;
    }

    @Override
    public void registerComponents(Context context, Glide glide, Registry registry) {
        registry.replace(GlideUrl.class, InputStream.class, new OkHttpUrlLoader.Factory(httpClient));
    }
}