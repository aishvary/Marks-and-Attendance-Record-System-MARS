package mars.com.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.flyco.pageindicator.indicator.FlycoPageIndicaor;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mars.com.R;
import mars.com.adapters.AppInfoSlidingImageAdapter;
import mars.com.ui.button.ButtonPlus;

/**
 * Created by Harsh on 10/4/2016.
 */
public class AppInfoActivity extends AppCompatActivity {

    @Bind(R.id.indicator)
    FlycoPageIndicaor indicaor;
    @Bind(R.id.pager)
    ViewPager pager;
    @Bind(R.id.btnLogin)
    ButtonPlus btnLogin;

    @OnClick(R.id.btnLogin)
    void login() {
        startActivity(new Intent(AppInfoActivity.this, LoginModeActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_info);
        overridePendingTransition(0, 0);
        populate();
    }

    private void populate() {
        ButterKnife.bind(this);

        AppInfoSlidingImageAdapter appInfoSlidingImageAdapter = new AppInfoSlidingImageAdapter(this);
        pager.setAdapter(appInfoSlidingImageAdapter);
        indicaor.setViewPager(pager);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            btnLogin.setBackgroundResource(R.drawable.ripple);
        }
    }
}
