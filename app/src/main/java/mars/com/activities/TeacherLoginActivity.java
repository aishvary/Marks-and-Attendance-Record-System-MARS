package mars.com.activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mars.com.R;
import mars.com.ui.CustomTitle;
import mars.com.ui.SnackBar;
import mars.com.ui.button.ButtonPlus;

/**
 * Created by Harsh on 4/15/2017.
 */
public class TeacherLoginActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.etTeacherId)
    EditText etTeacherId;
    @Bind(R.id.txtTeacherLoginMessage)
    TextView txtTeacherLoginMessage;
    @Bind(R.id.txtTeacherLoginDescMessage)
    TextView txtTeacherLoginDescMessage;
    @Bind(R.id.btnSubmit)
    ButtonPlus btnSubmit;

    @OnClick(R.id.btnSubmit)
    void login(){
        if (etTeacherId.getText().toString().equals("")){
            SnackBar.show(this, getString(R.string.no_text));
            return;
        }
        startActivity(new Intent(this, TeacherDashboardActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_login);
        populate();
    }

    private void populate() {
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(CustomTitle.getTitle(TeacherLoginActivity.this, "Enter your Faculty Id"));
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtTeacherLoginMessage.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/Whitney-Semibold-Bas.otf"));
        txtTeacherLoginDescMessage.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/Whitney-Semibold-Bas.otf"));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            btnSubmit.setBackgroundResource(R.drawable.ripple);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
