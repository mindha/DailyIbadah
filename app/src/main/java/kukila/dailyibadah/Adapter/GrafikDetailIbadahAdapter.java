package kukila.dailyibadah.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

import kukila.dailyibadah.Adapter.model.GrafikDetailIbadahModel;
import kukila.dailyibadah.R;

/**
 * Created by Mindha on 18/06/2017.
 */

public class GrafikDetailIbadahAdapter extends ArrayAdapter<GrafikDetailIbadahModel> {
    private int lastPosition = -1;
    Switch switchButton;
    private ArrayList<GrafikDetailIbadahModel> dataSet;
    Context mContext;
    private static class ViewHolder {
        TextView textJudulIbadah, persen;
        LinearLayout itemIbadah;

    }
    GrafikDetailIbadahAdapter.ViewHolder viewHolder;
    public GrafikDetailIbadahAdapter(ArrayList<GrafikDetailIbadahModel> data, Context context) {
        super(context, R.layout.item_detail_grafik, data);
        this.dataSet = data;
        this.mContext=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        GrafikDetailIbadahModel dataModel = getItem(position);
        final View result;
        if (convertView == null) {
            viewHolder = new GrafikDetailIbadahAdapter.ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.item_detail_grafik, parent, false);
            viewHolder.itemIbadah= (LinearLayout) convertView.findViewById(R.id.item_ibadah_detail);
            viewHolder.textJudulIbadah= (TextView) convertView.findViewById(R.id.title_detail);
            viewHolder.persen= (TextView) convertView.findViewById(R.id.persen_ibadah);

            result=convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (GrafikDetailIbadahAdapter.ViewHolder) convertView.getTag();
            result=convertView;
        }

        lastPosition = position;

        viewHolder.itemIbadah.setVisibility(View.VISIBLE);
        int n = dataModel.getPersen();
        String percent = Integer.toString(n);
        viewHolder.persen.setText(percent);
        viewHolder.textJudulIbadah.setText(dataModel.getJudul());
        return convertView;
    }
}
