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
import kukila.dailyibadah.Adapter.InfoAdapter;
import kukila.dailyibadah.Adapter.model.IbadahSunnahModel;
import kukila.dailyibadah.Adapter.model.InfoModel;
import kukila.dailyibadah.R;

/**
 * Created by Mindha on 13/07/2017.
 */

public class Notifikasi extends Fragment {
    View myView;
    private static IbadahSunnahAdapter adapter;
    ArrayList<IbadahSunnahModel> dataModels;
    ListView listViewMessage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_notifikasi, container, false);
        getActivity().setTitle("Notifikasi");
        listViewMessage = (ListView) myView.findViewById(R.id.listShalatSunnah);
        shalatWajib();
        dummySunnah();
        initAdapter();

        return myView;

    }

    public void shalatWajib() {
        String[] listArray = {"Subuh", "Dhuhur", "Ashar", "Maghrib", "Isya"};

        ArrayAdapter adapter = new ArrayAdapter(getActivity(), R.layout.item_shalat_wajib, listArray);

        ListView listView = (ListView) myView.findViewById(R.id.listShalatWajib);
        listView.setAdapter(adapter);
    }

    public void dummySunnah() {
        dataModels = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            dataModels.add(new IbadahSunnahModel("Shalat Sunnah " + (i + 1)));
        }
    }


    public void initAdapter() {
        adapter = new IbadahSunnahAdapter(dataModels, getActivity().getApplicationContext());
        listViewMessage.setAdapter(adapter);
        listViewMessage.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                IbadahSunnahModel dataModel = dataModels.get(position);

            }
        });

    }
}