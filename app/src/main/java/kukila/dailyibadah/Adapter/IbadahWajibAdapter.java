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

public class IbadahWajibAdapter extends ArrayAdapter<IbadahWajibModel> {
    private int lastPosition = -1;
    Switch switchButton;
    private ArrayList<IbadahWajibModel> dataSet;
    Context mContext;
    private static class ViewHolder {
        TextView textJudulIbadahWajib;
        LinearLayout itemIbadahWajib;

    }
    IbadahWajibAdapter.ViewHolder viewHolder;
    public IbadahWajibAdapter(ArrayList<IbadahWajibModel> data, Context context) {
        super(context, R.layout.item_shalat_wajib, data);
        this.dataSet = data;
        this.mContext=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        IbadahWajibModel dataModel = getItem(position);
        final View result;
        if (convertView == null) {
            viewHolder = new IbadahWajibAdapter.ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.item_shalat_wajib, parent, false);
            viewHolder.itemIbadahWajib= (LinearLayout) convertView.findViewById(R.id.item_ibadah_wajib);
            viewHolder.textJudulIbadahWajib= (TextView) convertView.findViewById(R.id.judul_ibadah_wajib);

            result=convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (IbadahWajibAdapter.ViewHolder) convertView.getTag();
            result=convertView;
        }

        lastPosition = position;

        viewHolder.itemIbadahWajib.setVisibility(View.VISIBLE);
        viewHolder.textJudulIbadahWajib.setText(dataModel.getNamaIbadah());

        switchButton = (Switch) convertView.findViewById(R.id.switchButtonWajib);
//        textView = (TextView) convertView.findViewById(R.id.textView);

        switchButton.setChecked(true);
        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {
//                if (bChecked) {
//                    textView.setText(switchOn);
//                } else {
//                    textView.setText(switchOff);
//                }
            }
        });

//        if (switchButton.isChecked()) {
//            textView.setText(switchOn);
//        } else {
//            textView.setText(switchOff);
//        }

        return convertView;
    }
}
