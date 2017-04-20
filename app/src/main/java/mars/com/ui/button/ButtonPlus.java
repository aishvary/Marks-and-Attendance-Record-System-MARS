package mars.com.ui.button;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Created by Harsh on 10/4/2016.
 */
public class ButtonPlus extends Button {
    public ButtonPlus(Context context) {
        super(context);
    }

    public ButtonPlus(Context context, AttributeSet attrs) {
        super(context, attrs);
        CustomFontHelper.setCustomFont(this, context, attrs);
    }

    public ButtonPlus(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        CustomFontHelper.setCustomFont(this, context, attrs);
    }

}
