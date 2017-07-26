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

import kukila.dailyibadah.Adapter.model.IbadahSunnahModel;
import kukila.dailyibadah.R;

/**
 * Created by Mindha on 18/06/2017.
 */

public class ShalatSunnahAdapter extends ArrayAdapter<IbadahSunnahModel> {
    private int lastPosition = -1;
    Switch switchButton;
    private ArrayList<IbadahSunnahModel> dataSet;
    Context mContext;
    private static class ViewHolder {
        TextView textJudulIbadahSunnah,menit,waktu;
        LinearLayout itemIbadah;

    }
    ShalatSunnahAdapter.ViewHolder viewHolder;
    public ShalatSunnahAdapter(ArrayList<IbadahSunnahModel> data, Context context) {
        super(context, R.layout.item_ibadah, data);
        this.dataSet = data;
        this.mContext=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        IbadahSunnahModel dataModel = getItem(position);
        final View result;
        if (convertView == null) {
            viewHolder = new ShalatSunnahAdapter.ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.item_ibadah, parent, false);
            viewHolder.itemIbadah= (LinearLayout) convertView.findViewById(R.id.item_ibadah_list);
            viewHolder.textJudulIbadahSunnah= (TextView) convertView.findViewById(R.id.nama_ibadah);
            viewHolder.menit= (TextView) convertView.findViewById(R.id.waktu_ibadah);
            viewHolder.waktu= (TextView) convertView.findViewById(R.id.time_ibadah);

            result=convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ShalatSunnahAdapter.ViewHolder) convertView.getTag();
            result=convertView;
        }

        lastPosition = position;

        viewHolder.itemIbadah.setVisibility(View.VISIBLE);
        viewHolder.textJudulIbadahSunnah.setText(dataModel.getNamaIbadah());
        viewHolder.menit.setText(dataModel.getWaktu());
        viewHolder.waktu.setText(dataModel.getMenit());



        return convertView;
    }
}
