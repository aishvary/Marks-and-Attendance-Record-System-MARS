package mars.com.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.joanzapata.pdfview.PDFView;

import butterknife.Bind;
import butterknife.ButterKnife;
import mars.com.R;
import mars.com.ui.CustomTitle;

/**
 * Created by Harsh on 12/24/2016.
 */
public class CalendarActivity extends AppCompatActivity {

    @Bind(R.id.pdfCalendar)
    PDFView pdfCalendar;
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        populate();
    }

    private void populate() {
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(CustomTitle.getTitle(CalendarActivity.this, getString(R.string.calender)));
        pdfCalendar.fromAsset("academic_calendar.pdf").load();

    }
}
