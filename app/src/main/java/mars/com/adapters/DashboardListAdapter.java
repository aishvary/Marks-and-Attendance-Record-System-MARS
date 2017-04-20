package mars.com.adapters;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import mars.com.R;
import mars.com.dto.DashboardListItemsDTO;

/**
 * Created by Harsh on 12/23/2016.
 */
public class DashboardListAdapter extends BaseAdapter {

    AssetManager assetManager;
    private Context context;
    private List<DashboardListItemsDTO> items;
    private LayoutInflater inflater;


    public DashboardListAdapter(Context context, List<DashboardListItemsDTO> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.dashboard_list_item_custom_row, null);
        ((TextView) convertView.findViewById(R.id.txtDashboardSingleRowTitle)).setText(items.get(position).getTitle());
        ((TextView) convertView.findViewById(R.id.txtDashboardSingleRowTDisc)).setText(items.get(position).getDesc());
        ((ImageView) convertView.findViewById(R.id.imgDashboardSingleRow)).setImageResource(items.get(position).getImage());

        Typeface tf = Typeface.createFromAsset(context.getAssets(), "fonts/Whitney-Semibold-Bas.otf");
        ((TextView) convertView.findViewById(R.id.txtDashboardSingleRowTitle)).setTypeface(tf);
        ((TextView) convertView.findViewById(R.id.txtDashboardSingleRowTDisc)).setTypeface(tf);
        return convertView;

    }
}
