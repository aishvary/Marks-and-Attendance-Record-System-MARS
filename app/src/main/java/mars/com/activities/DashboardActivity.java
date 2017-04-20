package mars.com.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mingle.entity.MenuEntity;
import com.mingle.sweetpick.DimEffect;
import com.mingle.sweetpick.SweetSheet;
import com.mingle.sweetpick.ViewPagerDelegate;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import mars.com.R;
import mars.com.adapters.DashboardListAdapter;
import mars.com.dto.DashboardListItemsDTO;

/**
 * Created by Harsh on 3/16/2016.
 */
public class DashboardActivity extends AppCompatActivity implements View.OnClickListener {


    @Bind(R.id.txtName)
    TextView txtName;
    @Bind(R.id.txtRollNum)
    TextView txtRollNum;
    @Bind(R.id.txtSem)
    TextView txtSem;
    @Bind(R.id.txtSemester)
    TextView txtSemester;
    @Bind(R.id.fabMenu)
    FloatingActionButton fabMenu;
    @Bind(R.id.ll)
    RelativeLayout ll;
    @Bind(R.id.listItems)
    ListView listItems;
    private SweetSheet sweetSheet;
   /* @Bind(R.id.txtPushMessage)
    TextView txtPushMessage;
    @Bind(R.id.txtRegId)
    TextView txtRegId;

    private static String TAG = DashboardActivity.class.getSimpleName();
    private BroadcastReceiver broadcastReceiver;
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        populate();
    }

    private void populate() {

        ButterKnife.bind(this);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        Typeface tf = Typeface.createFromAsset(this.getAssets(), "fonts/Whitney-Semibold-Bas.otf");
        txtName.setTypeface(tf);
        txtRollNum.setTypeface(tf);
        txtSem.setTypeface(tf);
        txtSemester.setTypeface(tf);

        List<DashboardListItemsDTO> dashboardListItemDTOs = new ArrayList<>();
        DashboardListAdapter dashboardListAdapter = new DashboardListAdapter(DashboardActivity.this, dashboardListItemDTOs);

        DashboardListItemsDTO dashboardListItemDTO = new DashboardListItemsDTO();
        dashboardListItemDTO.setDesc(getResources().getString(R.string.home_desc_1));
        dashboardListItemDTO.setTitle(getResources().getString(R.string.home_title_1));
        dashboardListItemDTO.setImage(R.drawable.attendance);
        dashboardListItemDTOs.add(dashboardListItemDTO);

        dashboardListItemDTO = new DashboardListItemsDTO();
        dashboardListItemDTO.setDesc(getResources().getString(R.string.home_desc_2));
        dashboardListItemDTO.setTitle(getResources().getString(R.string.home_title_2));
        dashboardListItemDTO.setImage(R.drawable.marks);
        dashboardListItemDTOs.add(dashboardListItemDTO);
        listItems.setAdapter(dashboardListAdapter);

        setUpViewPager();
        fabMenu.setOnClickListener(this);


        listItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        startActivity(new Intent(DashboardActivity.this, AttendanceActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(DashboardActivity.this, MarksActivity.class));
                        break;
                }
            }
        });



/*
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals(Config.REGISTRATION_COMPLETE)){
                    FirebaseMessaging.getInstance().subscribeToTopic(Config.TOPIC_GLOBAL);
                    displayFirebaseRegId();
                } else if (intent.getAction().equals(Config.PUSH_NOTIFICATION)){
                    // new push notification is received

                    String message = intent.getStringExtra("message");

                    Toast.makeText(getApplicationContext(), "Push notification: " + message, Toast.LENGTH_LONG).show();

                    txtPushMessage.setText(message);
                }
            }
        };
        displayFirebaseRegId();
    */
    }

    private void setUpViewPager() {
        sweetSheet = new SweetSheet(ll);
        sweetSheet.setMenuList(R.menu.menu_sweet_options);
        sweetSheet.setDelegate(new ViewPagerDelegate());
        sweetSheet.setBackgroundEffect(new DimEffect(0.9f));
        sweetSheet.setOnMenuItemClickListener(new SweetSheet.OnMenuItemClickListener() {
            @Override
            public boolean onItemClick(int position, MenuEntity menuEntity) {
                switch (position) {
                    case 1:
                        startActivity(new Intent(DashboardActivity.this, CalendarActivity.class));
                        break;
                    case 0:
                        startActivity(new Intent(DashboardActivity.this, SyllabusActivity.class));
                        break;
                    case 2:
                        logout();
                        break;
                }
                return true;
            }
        });
    }

    private void logout() {
        AlertDialog.Builder builder = new AlertDialog.Builder(DashboardActivity.this);
        builder.setTitle(getString(R.string.logout));
        builder.setMessage(getString(R.string.logout_message));

        String positiveText = getString(android.R.string.ok);
        builder.setPositiveButton(positiveText,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // positive button logic
                        dialog.dismiss();
                        startActivity(new Intent(DashboardActivity.this, LoginActivity.class));
                        ActivityCompat.finishAffinity(DashboardActivity.this);
                    }
                });

        String negativeText = getString(android.R.string.cancel);
        builder.setNegativeButton(negativeText,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // negative button logic
                        dialog.dismiss();
                    }
                });

        AlertDialog dialog = builder.create();
        // display dialog
        dialog.show();
    }


    // Fetches reg id from shared preferences
    // and displays on the screen
/*
    private void displayFirebaseRegId() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences(Config.SHARED_PREF, 0);
        String regId = pref.getString("regId", null);

        Log.e(TAG, "Firebase reg id: " + regId);

        if (!TextUtils.isEmpty(regId))
            txtRegId.setText("Firebase Reg Id: " + regId);
        else
            txtRegId.setText("Firebase Reg Id is not received yet!");
    }
*/

    @Override
    protected void onResume() {
        super.onResume();
/*
        // register GCM registration complete receiver
        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver,
                new IntentFilter(Config.REGISTRATION_COMPLETE));

        // register new push message receiver
        // by doing this, the activity will be notified each time a new message arrives
        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver,
                new IntentFilter(Config.PUSH_NOTIFICATION));

        // clear the notification area when the app is opened
        Notification.clearNotifications(getApplicationContext());
*/
    }

    /*  @Override
      public boolean onCreateOptionsMenu(Menu menu) {
          getMenuInflater().inflate(R.menu.menu_sweet_options, menu);
          return true;
      }
  */
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.fabMenu:
                sweetSheet.toggle();
        }
    }

    @Override
    public void onBackPressed() {
        if (sweetSheet.isShow()) {
            sweetSheet.dismiss();
        } else {
            super.onBackPressed();
        }
    }
}
