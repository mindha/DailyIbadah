package kukila.dailyibadah.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import kukila.dailyibadah.Adapter.model.InfoModel;
import kukila.dailyibadah.R;

import java.util.ArrayList;

/**
 * Created by Mindha on 18/06/2017.
 */

public class InfoAdapter extends ArrayAdapter<InfoModel> {
    private int lastPosition = -1;
    private ArrayList<InfoModel> dataSet;
    Context mContext;
    private static class ViewHolder {
        TextView textJudul;
        LinearLayout itemInfo;

    }
    InfoAdapter.ViewHolder viewHolder;
    public InfoAdapter(ArrayList<InfoModel> data, Context context) {
        super(context, R.layout.item_info, data);
        this.dataSet = data;
        this.mContext=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        InfoModel dataModel = getItem(position);
        final View result;
        if (convertView == null) {
            viewHolder = new InfoAdapter.ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.item_info, parent, false);
            viewHolder.itemInfo= (LinearLayout) convertView.findViewById(R.id.itemInfo);
            viewHolder.textJudul= (TextView) convertView.findViewById(R.id.judul_info);

            result=convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (InfoAdapter.ViewHolder) convertView.getTag();
            result=convertView;
        }

        lastPosition = position;

        viewHolder.itemInfo.setVisibility(View.VISIBLE);
        viewHolder.textJudul.setText(dataModel.getJudul());

        return convertView;
    }
}
