package kukila.dailyibadah.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import kukila.dailyibadah.Adapter.model.IbadahSunnahModel;
import kukila.dailyibadah.R;

/**
 * Created by Mindha on 18/06/2017.
 */

public class IbadahSunnahAdapter extends ArrayAdapter<IbadahSunnahModel> {
    private int lastPosition = -1;
    private ArrayList<IbadahSunnahModel> dataSet;
    Context mContext;
    private static class ViewHolder {
        TextView textJudulIbadahSunah;
        LinearLayout itemIbadahSunnah;

    }
    IbadahSunnahAdapter.ViewHolder viewHolder;
    public IbadahSunnahAdapter(ArrayList<IbadahSunnahModel> data, Context context) {
        super(context, R.layout.item_shalat_sunnah, data);
        this.dataSet = data;
        this.mContext=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        IbadahSunnahModel dataModel = getItem(position);
        final View result;
        if (convertView == null) {
            viewHolder = new IbadahSunnahAdapter.ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.item_shalat_sunnah, parent, false);
            viewHolder.itemIbadahSunnah= (LinearLayout) convertView.findViewById(R.id.item_ibadah_sunnah);
            viewHolder.textJudulIbadahSunah= (TextView) convertView.findViewById(R.id.judul_ibadah_sunnah);

            result=convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (IbadahSunnahAdapter.ViewHolder) convertView.getTag();
            result=convertView;
        }

        lastPosition = position;

        viewHolder.itemIbadahSunnah.setVisibility(View.VISIBLE);
        viewHolder.textJudulIbadahSunah.setText(dataModel.getNamaIbadah());

        return convertView;
    }
}
