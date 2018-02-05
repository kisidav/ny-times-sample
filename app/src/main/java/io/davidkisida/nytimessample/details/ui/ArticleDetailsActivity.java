package io.davidkisida.nytimessample.details.ui;

import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

import io.davidkisida.nytimessample.R;

@EActivity(R.layout.activity_details)
public class ArticleDetailsActivity extends RxAppCompatActivity {

    @Extra
    String url;

    @ViewById
    WebView webViewDetails;

    @ViewById
    FrameLayout progressWrapperDetails;

    @AfterViews
    void afterViews() {

        webViewDetails.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressWrapperDetails.setVisibility(View.GONE);
            }
        });
        webViewDetails.loadUrl(url);
    }
}
