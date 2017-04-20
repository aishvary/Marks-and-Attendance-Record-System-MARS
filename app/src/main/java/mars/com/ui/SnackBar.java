package mars.com.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;

import com.nispok.snackbar.Snackbar;
import com.nispok.snackbar.SnackbarManager;
import com.nispok.snackbar.enums.SnackbarType;
import com.nispok.snackbar.listeners.ActionClickListener;

import mars.com.R;

/**
 * Created by Harsh on 10/4/2016.
 */
public class SnackBar {
    public static void show(Context context, String message) {

        try {
            Typeface tf = Typeface.createFromAsset(context.getAssets(), "fonts/roboto_light.ttf");

            Snackbar snackbar = Snackbar.with(context)
                    .text(message)
                    .textColor(Color.parseColor("#ffffffff"))
                    .color(Color.parseColor("#ffCA1523"))
                    .textTypeface(tf)
                    .type(SnackbarType.MULTI_LINE)
                    .actionLabel(context.getResources().getString(R.string.ok))
                    .actionColor(Color.parseColor("#ffffffff"))
                    .actionListener(new ActionClickListener() {
                        @Override
                        public void onActionClicked(Snackbar snackbar) {

                        }
                    });

            snackbar.setPadding(5, 5, 5, 5);

            SnackbarManager.show(snackbar.duration(Snackbar.SnackbarDuration.LENGTH_SHORT));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void success(Context context, String message) {

        try {
            Typeface tf = Typeface.createFromAsset(context.getAssets(), "fonts/roboto_light.ttf");

            Snackbar snackbar = Snackbar.with(context)
                    .text(message)
                    .textColor(Color.parseColor("#ffffffff"))
                    .color(Color.parseColor("#ff1ca59a"))
                    .textTypeface(tf)
                    .type(SnackbarType.MULTI_LINE)
                    .actionLabel(context.getString(R.string.ok))
                    .actionColor(Color.parseColor("#ffffffff"))
                    .actionListener(new ActionClickListener() {
                        @Override
                        public void onActionClicked(Snackbar snackbar) {

                        }
                    });

            snackbar.setPadding(5, 5, 5, 5);

            SnackbarManager.show(snackbar.duration(Snackbar.SnackbarDuration.LENGTH_SHORT));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void noInternet(Context context) {

        try {


            Typeface tf = Typeface.createFromAsset(context.getAssets(), "fonts/roboto_light.ttf");

            Snackbar snackbar = Snackbar.with(context)
                    .text(context.getResources().getString(R.string.no_internet))
                    .textColor(Color.parseColor("#ffffffff"))
                    .color(Color.parseColor("#fff18080"))
                    .textTypeface(tf)
                    .type(SnackbarType.MULTI_LINE)
                    .actionLabel(context.getResources().getString(R.string.ok))
                    .actionColor(Color.parseColor("#ffffffff"))
                    .actionListener(new ActionClickListener() {
                        @Override
                        public void onActionClicked(Snackbar snackbar) {

                        }
                    });

            snackbar.setPadding(5, 5, 5, 5);

            SnackbarManager.show(snackbar.duration(Snackbar.SnackbarDuration.LENGTH_SHORT));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
