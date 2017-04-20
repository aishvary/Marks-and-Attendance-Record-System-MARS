package mars.com.activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mars.com.R;
import mars.com.ui.CustomTitle;
import mars.com.ui.button.ButtonPlus;

/**
 * Created by Harsh on 4/15/2017.
 */
public class LoginModeActivity extends AppCompatActivity {

    @Bind(R.id.txtWelcome)
    TextView txtWelcome;
    @Bind(R.id.txtWelcomeMsg)
    TextView txtWelcomeMsg;
    @Bind(R.id.btnEnter)
    ButtonPlus btnEnter;
    @Bind(R.id.radioGroup)
    RadioGroup radioGroup;
    @Bind(R.id.checkTeacher)
    RadioButton checkTeacher;
    @Bind(R.id.checkStudent)
    RadioButton checkStudent;
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @OnClick(R.id.btnEnter)
    void enter() {
        if (checkStudent.isChecked()) {
            startActivity(new Intent(this, LoginActivity.class));
        }
        if (checkTeacher.isChecked()) {
            startActivity(new Intent(this, TeacherLoginActivity.class));
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_mode);
        populate();
    }

    private void populate() {
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(CustomTitle.getTitle(LoginModeActivity.this, "Please select your Category"));

        txtWelcome.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/Whitney-Semibold-Bas.otf"));
        txtWelcomeMsg.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/Whitney-Semibold-Bas.otf"));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            btnEnter.setBackgroundResource(R.drawable.ripple);
        }
    }
}
