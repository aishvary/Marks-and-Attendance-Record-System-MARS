package mars.com.activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mars.com.R;
import mars.com.ui.CustomTitle;
import mars.com.ui.SnackBar;
import mars.com.ui.button.ButtonPlus;

/**
 * Created by Harsh on 3/16/2016.
 */
public class LoginActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.etRollNumber)
    android.widget.EditText etRollNumber;
    @Bind(R.id.btnSubmit)
    ButtonPlus btnSubmit;
    @Bind(R.id.txtLoginMessage)
    TextView txtLoginMessage;
    @Bind(R.id.txtLoginDescMessage)
    TextView txtLoginDescMessage;
    /*@Bind(R.id.txtCollegeCode)
    TextView txtCollegeCode;*/

    @OnClick(R.id.btnSubmit)
    void enter() {
        if (etRollNumber.getText().toString().equals("")) {
            SnackBar.show(this, getString(R.string.no_text));
        } else {
            Intent intent = new Intent(this, DashboardActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        populate();
    }

    private void populate() {
        ButterKnife.bind(this);
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            btnSubmit.setBackgroundResource(R.drawable.ripple);
        }

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(CustomTitle.getTitle(this, getString(R.string.login)));
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtLoginMessage.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/Whitney-Semibold-Bas.otf"));
        txtLoginDescMessage.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/Whitney-Semibold-Bas.otf"));
        //    txtCollegeCode.setTypeface(typeface);
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
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

