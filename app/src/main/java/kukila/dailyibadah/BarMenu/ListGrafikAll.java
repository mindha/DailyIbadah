package kukila.dailyibadah.BarMenu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import kukila.dailyibadah.Adapter.GrafikDetailIbadahAdapter;
import kukila.dailyibadah.Adapter.IbadahAdapter;
import kukila.dailyibadah.Adapter.model.GrafikDetailIbadahModel;
import kukila.dailyibadah.Adapter.model.IbadahWajibModel;
import kukila.dailyibadah.R;

/**
 * Created by Mindha on 24/07/2017.
 */

public class ListGrafikAll extends Fragment {
    View myView;

    private static GrafikDetailIbadahAdapter adapter;
    ArrayList<GrafikDetailIbadahModel> dataModels;
    ListView listViewMessage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.activity_grafik_all,container,false);
        listViewMessage = (ListView) myView.findViewById(R.id.list_detail_semua);
        dummyInfo();
        initAdapter();

        return myView;
    }

    public void dummyInfo() {
        dataModels = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            int n = 80;

            dataModels.add(new GrafikDetailIbadahModel(i, n,"Nama Shalat"));
        }
    }


    public void initAdapter() {
        adapter = new GrafikDetailIbadahAdapter(dataModels, getActivity().getApplicationContext());
        listViewMessage.setAdapter(adapter);
        listViewMessage.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                GrafikDetailIbadahModel dataModel = dataModels.get(position);

            }
        });

    }

}
