package io.davidkisida.nytimessample.common.util;

import android.content.res.Resources;

public final class DisplayUtil {

    private DisplayUtil() {
        // utility class
    }

    public static Integer getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }
}
