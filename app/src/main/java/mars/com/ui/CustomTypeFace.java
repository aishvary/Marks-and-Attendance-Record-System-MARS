package mars.com.ui;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by Harsh on 10/4/2016.
 */
public class CustomTypeFace {
    public static Typeface getTypeface(Context context) {
        Typeface face = Typeface.createFromAsset(context.getAssets(), "fonts/Whitney-Book-Bas.otf");
        return face;
    }

    public static Typeface getBoldTypeface(Context context) {
        Typeface face = Typeface.createFromAsset(context.getAssets(), "fonts/Whitney-Semibold-Bas.otf");
        return face;
    }

}
