package kukila.dailyibadah.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

import kukila.dailyibadah.Adapter.model.IbadahWajibModel;
import kukila.dailyibadah.R;

/**
 * Created by Mindha on 18/06/2017.
 */

public class IbadahAdapter extends ArrayAdapter<IbadahWajibModel> {
    private int lastPosition = -1;
    Switch switchButton;
    private ArrayList<IbadahWajibModel> dataSet;
    Context mContext;
    private static class ViewHolder {
        TextView textJudulIbadahWajib,menit,waktu;
        LinearLayout itemIbadah;

    }
    IbadahAdapter.ViewHolder viewHolder;
    public IbadahAdapter(ArrayList<IbadahWajibModel> data, Context context) {
        super(context, R.layout.item_ibadah, data);
        this.dataSet = data;
        this.mContext=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        IbadahWajibModel dataModel = getItem(position);
        final View result;
        if (convertView == null) {
            viewHolder = new IbadahAdapter.ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.item_ibadah, parent, false);
            viewHolder.itemIbadah= (LinearLayout) convertView.findViewById(R.id.item_ibadah_list);
            viewHolder.textJudulIbadahWajib= (TextView) convertView.findViewById(R.id.nama_ibadah);
            viewHolder.menit= (TextView) convertView.findViewById(R.id.waktu_ibadah);
            viewHolder.waktu= (TextView) convertView.findViewById(R.id.time_ibadah);

            result=convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (IbadahAdapter.ViewHolder) convertView.getTag();
            result=convertView;
        }

        lastPosition = position;

        viewHolder.itemIbadah.setVisibility(View.VISIBLE);
        viewHolder.textJudulIbadahWajib.setText(dataModel.getNamaIbadah());
        viewHolder.menit.setText(dataModel.getWaktu());
        viewHolder.waktu.setText(dataModel.getMenit());



        return convertView;
    }
}
