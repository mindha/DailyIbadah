package kukila.dailyibadah.NavbarMenu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import kukila.dailyibadah.Adapter.IbadahSunnahAdapter;
import kukila.dailyibadah.Adapter.IbadahWajibAdapter;
import kukila.dailyibadah.Adapter.InfoAdapter;
import kukila.dailyibadah.Adapter.model.IbadahSunnahModel;
import kukila.dailyibadah.Adapter.model.IbadahWajibModel;
import kukila.dailyibadah.Adapter.model.InfoModel;
import kukila.dailyibadah.R;

/**
 * Created by Mindha on 13/07/2017.
 */

public class Notifikasi extends Fragment {
    View myView;
    private static IbadahSunnahAdapter adapter;
    ArrayList<IbadahSunnahModel> dataModels;
    private static IbadahWajibAdapter adapteribadahwajib;
    ArrayList<IbadahWajibModel> dataModelsWajib;
    ListView listViewIbadahSunnah, listViewIbadahWajib;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_notifikasi, container, false);
        getActivity().setTitle("Notifikasi");
        listViewIbadahSunnah = (ListView) myView.findViewById(R.id.listShalatSunnah);
        listViewIbadahWajib = (ListView) myView.findViewById(R.id.listShalatWajib);
        dummyWajib();
        initAdapterWajib();
        dummySunnah();
        initAdapter();
        return myView;

    }

    public void dummySunnah() {
        dataModels = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            dataModels.add(new IbadahSunnahModel("Shalat Sunnah " + (i + 1)));
        }
    }


    public void initAdapter() {
        adapter = new IbadahSunnahAdapter(dataModels, getActivity().getApplicationContext());
        listViewIbadahSunnah.setAdapter(adapter);
        listViewIbadahSunnah.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                IbadahSunnahModel dataModel = dataModels.get(position);

            }
        });

    }

    public void dummyWajib() {
        dataModelsWajib = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            dataModelsWajib.add(new IbadahWajibModel("Shalat Wajib " + (i + 1)));
        }
    }


    public void initAdapterWajib() {
        adapteribadahwajib = new IbadahWajibAdapter(dataModelsWajib, getActivity().getApplicationContext());
        listViewIbadahWajib.setAdapter(adapteribadahwajib);
        listViewIbadahWajib.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                IbadahWajibModel dataModel = dataModelsWajib.get(position);

            }
        });

    }
}