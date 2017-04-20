package mars.com.util;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Harsh on 4/17/2017.
 */
public class CompositeOnClickListener implements View.OnClickListener {
    List<View.OnClickListener> listeners;

    public CompositeOnClickListener() {
        listeners = new ArrayList<View.OnClickListener>();
    }

    public void addOnClickListener(View.OnClickListener listener) {
        listeners.add(listener);
    }

    @Override
    public void onClick(View v) {
        for (View.OnClickListener listener : listeners) {
            listener.onClick(v);
        }
    }
}
