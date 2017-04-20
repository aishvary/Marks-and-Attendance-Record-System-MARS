package mars.com.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.GravityEnum;
import com.afollestad.materialdialogs.MaterialDialog;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import mars.com.R;
import mars.com.ui.CustomTitle;

/**
 * Created by Harsh on 4/15/2017.
 */
public class TeacherDashboardActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.txtTeacherDashboardInfo)
    TextView txtTeacherDashboardInfo;
    @Bind(R.id.listClasses)
    ListView listClasses;
    ArrayList<String> values = new ArrayList<String>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_dashboard);
        populate();
    }

    private void populate() {
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(CustomTitle.getTitle(TeacherDashboardActivity.this, "Home"));
        txtTeacherDashboardInfo.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/Whitney-Book-Bas.otf"));

        values.add(0, "2-A");
        values.add(1, "2-B");
        values.add(2, "4-A");
        values.add(3, "4-C");
        values.add(4, "6-A");
        values.add(5, "6-A");
        values.add(6, "6-B");
        values.add(7, "8-A");
        values.add(8, "8-C");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.teacher_dashboard_list_custom_row, R.id.txtSemName, values) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View v = convertView;
                if (v == null) {
                    LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    v = inflater.inflate(R.layout.teacher_dashboard_list_custom_row, null);
                }
                TextView txtSemName = (TextView) v.findViewById(R.id.txtSemName);
                txtSemName.setText(values.get(position));
                txtSemName.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/Whitney-Book-Bas.otf"));
                return v;
            }
        };
        listClasses.setAdapter(adapter);

        listClasses.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                new MaterialDialog.Builder(TeacherDashboardActivity.this)
                        .title("Choose One")
                        .titleGravity(GravityEnum.CENTER)
                        .content("What do you want to do?")
                        .contentGravity(GravityEnum.CENTER)
                        .buttonsGravity(GravityEnum.CENTER)
                        .positiveText("Update Attendance")
                        .negativeText("Enter Marks")
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                startActivity(new Intent(TeacherDashboardActivity.this, UpdateAttendanceActivity.class));
                            }
                        })
                        .onNegative(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {

                            }
                        })
                        .typeface("Whitney-Book-Bas.otf", "Whitney-Book-Bas.otf")
                        .show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.logout:
                onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
