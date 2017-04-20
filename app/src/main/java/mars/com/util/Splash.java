package mars.com.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Dell on 3/15/2016.
 */
public class Splash {
    Context context;

    public boolean isLogin(Context context) {
        this.context = context;
        boolean result = false;
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(((Activity) context).getBaseContext());
        result = sharedPreferences.getBoolean("isLogin", false);
        return result;
    }
}
