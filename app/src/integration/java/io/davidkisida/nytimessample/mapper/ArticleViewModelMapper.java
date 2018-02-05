package io.davidkisida.nytimessample.mapper;

import android.support.annotation.Nullable;

import io.davidkisida.nytimessample.api.model.ArticleApiModel;
import io.davidkisida.nytimessample.api.model.MediaApiModel;
import io.davidkisida.nytimessample.api.model.MediaMetadataApiModel;
import io.davidkisida.nytimessample.common.util.DisplayUtil;
import io.davidkisida.nytimessample.list.model.ArticleViewModel;

public final class ArticleViewModelMapper {

    private static final String TYPE = "image";
    private static final Integer MINIMUM_IMAGE_WIDTH = DisplayUtil.getScreenWidth() / 2;

    private ArticleViewModelMapper() {
        // utility class
    }

    public static ArticleViewModel from(ArticleApiModel apiModel) {
        ArticleViewModel viewModel = new ArticleViewModel();
        viewModel.setImageUrl(getImageUrl(apiModel));
        viewModel.setTitle(apiModel.getTitle());
        viewModel.setSubTitle(apiModel.getAAbstract());
        viewModel.setPublishDate(apiModel.getPublishedDate());
        viewModel.setByline(apiModel.getByline());
        viewModel.setLinkUrl(apiModel.getUrl());

        return viewModel;
    }

    @Nullable
    private static String getImageUrl(ArticleApiModel apiModel) {
        if (apiModel.getMediaList() == null || apiModel.getMediaList().isEmpty()) {
            return null;
        }

        for (MediaApiModel mediaApiModel : apiModel.getMediaList()) {
            if (TYPE.equals(mediaApiModel.getType())) {
                return getLargestImageUrl(mediaApiModel);
            }
        }

        return null;
    }

    @Nullable
    private static String getLargestImageUrl(MediaApiModel mediaApiModel) {
        if (mediaApiModel.getMediaMetadata() == null || mediaApiModel.getMediaMetadata().isEmpty()) {
            return null;
        }

        for (MediaMetadataApiModel mediaMetadataApiModel : mediaApiModel.getMediaMetadata()) {
            if (MINIMUM_IMAGE_WIDTH.compareTo(mediaMetadataApiModel.getWidth()) > 0) {
                return mediaMetadataApiModel.getUrl();
            }
        }

        return null;
    }
}
