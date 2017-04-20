package mars.com.activities;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import mars.com.R;
import mars.com.adapters.StudentListAdapter;
import mars.com.dto.StudentAttendanceDTO;
import mars.com.ui.CustomTitle;
import mars.com.ui.button.ButtonPlus;

/**
 * Created by Harsh on 4/17/2017.
 */
public class UpdateAttendanceActivity extends AppCompatActivity {

    final List<StudentAttendanceDTO> studentAttendanceDTOList = new ArrayList<>();
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.listStudents)
    RecyclerView listStudents;
    @Bind(R.id.btnSubmitAttendance)
    ButtonPlus btnSubmitAttendance;
    StudentListAdapter adapter;
    int count = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_attendance);
        getData();
        populate();
    }

    private void populate() {
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(CustomTitle.getTitle(UpdateAttendanceActivity.this, "List Of Students"));
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            btnSubmitAttendance.setBackgroundResource(R.drawable.ripple);
        }
        adapter = new StudentListAdapter(UpdateAttendanceActivity.this, studentAttendanceDTOList, new StudentListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(StudentAttendanceDTO dto) {
                Toast.makeText(UpdateAttendanceActivity.this, dto.getStatus(), Toast.LENGTH_SHORT).show();
            }
        });

        listStudents.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        listStudents.invalidate();
        listStudents.setLayoutManager(new LinearLayoutManager(UpdateAttendanceActivity.this));

        btnSubmitAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < studentAttendanceDTOList.size(); i++){
                    if (studentAttendanceDTOList.get(i).getStatus().equals("A"))
                        count++;
                }
                new MaterialDialog.Builder(UpdateAttendanceActivity.this)
                        .title("Total Absent")
                        .content("No. of Students Absent: " + count)
                        .positiveText("Ok")
                        .show();
                count=0;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    public List<StudentAttendanceDTO> getData() {
        StudentAttendanceDTO dto = new StudentAttendanceDTO();
        dto.setName("Aayushi");
        dto.setStatus("P");
        studentAttendanceDTOList.add(dto);

        dto = new StudentAttendanceDTO();
        dto.setName("Aishvary Pratap Singh");
        dto.setStatus("P");
        studentAttendanceDTOList.add(dto);

        dto = new StudentAttendanceDTO();
        dto.setName("Harsh Deep Singh");
        //dto.setStatus("P");
        studentAttendanceDTOList.add(dto);

        dto = new StudentAttendanceDTO();
        dto.setName("Aishvary Pratap Singh");
        dto.setStatus("P");
        studentAttendanceDTOList.add(dto);

        dto = new StudentAttendanceDTO();
        dto.setName("Aishvary Pratap Singh");
        dto.setStatus("P");
        studentAttendanceDTOList.add(dto);

        dto = new StudentAttendanceDTO();
        dto.setName("Aishvary Pratap Singh");
        dto.setStatus("P");
        studentAttendanceDTOList.add(dto);

        dto = new StudentAttendanceDTO();
        dto.setName("Aayushi");
        dto.setStatus("P");
        studentAttendanceDTOList.add(dto);

        dto = new StudentAttendanceDTO();
        dto.setName("Aishvary Pratap Singh");
        dto.setStatus("P");
        studentAttendanceDTOList.add(dto);

        dto = new StudentAttendanceDTO();
        dto.setName("Aishvary Pratap Singh");
        dto.setStatus("P");
        studentAttendanceDTOList.add(dto);

        dto = new StudentAttendanceDTO();
        dto.setName("Aishvary Pratap Singh");
        dto.setStatus("P");
        studentAttendanceDTOList.add(dto);

        dto = new StudentAttendanceDTO();
        dto.setName("Aishvary Pratap Singh");
        dto.setStatus("P");
        studentAttendanceDTOList.add(dto);

        dto = new StudentAttendanceDTO();
        dto.setName("Aishvary Pratap Singh");
        dto.setStatus("P");
        studentAttendanceDTOList.add(dto);

        dto = new StudentAttendanceDTO();
        dto.setName("Aishvary Pratap Singh");
        dto.setStatus("P");
        studentAttendanceDTOList.add(dto);

        dto = new StudentAttendanceDTO();
        dto.setName("Aishvary Pratap Singh");
        dto.setStatus("P");
        studentAttendanceDTOList.add(dto);

        dto = new StudentAttendanceDTO();
        dto.setName("Aishvary Pratap Singh");
        dto.setStatus("P");
        studentAttendanceDTOList.add(dto);

        dto = new StudentAttendanceDTO();
        dto.setName("Aishvary Pratap Singh");
        dto.setStatus("P");
        studentAttendanceDTOList.add(dto);

        dto = new StudentAttendanceDTO();
        dto.setName("Aishvary Pratap Singh");
        dto.setStatus("P");
        studentAttendanceDTOList.add(dto);

        dto = new StudentAttendanceDTO();
        dto.setName("Aishvary Pratap Singh");
        dto.setStatus("P");
        studentAttendanceDTOList.add(dto);

        dto = new StudentAttendanceDTO();
        dto.setName("Aayushi");
        dto.setStatus("P");
        studentAttendanceDTOList.add(dto);

        dto = new StudentAttendanceDTO();
        dto.setName("Aishvary Pratap Singh");
        dto.setStatus("P");
        studentAttendanceDTOList.add(dto);

        dto = new StudentAttendanceDTO();
        dto.setName("Aayushi");
        dto.setStatus("P");
        studentAttendanceDTOList.add(dto);

        dto = new StudentAttendanceDTO();
        dto.setName("Aishvary Pratap Singh");
        dto.setStatus("P");
        studentAttendanceDTOList.add(dto);

        return studentAttendanceDTOList;
    }
}
