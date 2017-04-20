package mars.com.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import mars.com.R;
import mars.com.dto.StudentAttendanceDTO;

/**
 * Created by Harsh on 4/17/2017.
 */
public class StudentListAdapter extends RecyclerView.Adapter<StudentListAdapter.StudentViewHolder> {
    List<StudentAttendanceDTO> studentAttendanceDTOList = Collections.emptyList();
    private LayoutInflater inflater;
    private Context context;
    private StudentListAdapter.OnItemClickListener listener;

    public StudentListAdapter(Context context, List<StudentAttendanceDTO> studentAttendanceDTOList) {
        this.context = context;
        this.studentAttendanceDTOList = studentAttendanceDTOList;
        inflater = LayoutInflater.from(context);
    }

    public StudentListAdapter(Context context, List<StudentAttendanceDTO> studentAttendanceDTOList, StudentListAdapter.OnItemClickListener listener) {
        this.context = context;
        this.studentAttendanceDTOList = studentAttendanceDTOList;
        this.listener = listener;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.student_list_custom_row, parent, false);
        StudentListAdapter.StudentViewHolder holder = new StudentListAdapter.StudentViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(StudentViewHolder holder, int position) {
        //holder.setIsRecyclable(false);
        holder.bind(studentAttendanceDTOList.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return studentAttendanceDTOList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public interface OnItemClickListener {
        void onItemClick(StudentAttendanceDTO dto);
    }

    class StudentViewHolder extends RecyclerView.ViewHolder {

        TextView txtSNo, txtStudentName;
        RadioGroup radioStatus;
        RadioButton btnRadioPresent, btnRadioAbsent;

        public StudentViewHolder(View itemView) {
            super(itemView);
            txtSNo = (TextView) itemView.findViewById(R.id.txtSNo);
            txtStudentName = (TextView) itemView.findViewById(R.id.txtStudentName);
            radioStatus = (RadioGroup) itemView.findViewById(R.id.radioStatus);
            btnRadioPresent = (RadioButton) itemView.findViewById(R.id.btnRadioPresent);
            btnRadioAbsent = (RadioButton) itemView.findViewById(R.id.btnRadioAbsent);
        }

        public void bind(final StudentAttendanceDTO studentAttendanceDTO, final StudentListAdapter.OnItemClickListener listener) {
            txtSNo.setText(String.valueOf(getPosition() + 1));
            txtStudentName.setText(studentAttendanceDTO.getName());
            txtSNo.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Whitney-Book-Bas.otf"));
            txtStudentName.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Whitney-Book-Bas.otf"));
            if (btnRadioAbsent.isChecked()) {
                studentAttendanceDTO.setStatus("A");
            }
            if (btnRadioPresent.isChecked()) {
                studentAttendanceDTO.setStatus("P");
            }
            /*itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (btnRadioAbsent.isChecked()) {
                        studentAttendanceDTO.setStatus("A");
                    }
                    if (btnRadioPresent.isChecked()) {
                        studentAttendanceDTO.setStatus("P");
                    }
                    listener.onItemClick(studentAttendanceDTO);
                }
            });*/
            btnRadioPresent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    studentAttendanceDTO.setStatus("P");
                    listener.onItemClick(studentAttendanceDTO);
                }
            });
            btnRadioAbsent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    studentAttendanceDTO.setStatus("A");
                    listener.onItemClick(studentAttendanceDTO);
                }
            });
        }
    }
}
