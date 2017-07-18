package kukila.dailyibadah.NavbarMenu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import kukila.dailyibadah.Adapter.InfoAdapter;
import kukila.dailyibadah.Adapter.model.InfoModel;
import kukila.dailyibadah.R;

/**
 * Created by Mindha on 13/07/2017.
 */

public class Info extends Fragment {
    View myView;
    private static InfoAdapter adapter;
    ArrayList<InfoModel> dataModels;
    ListView listViewMessage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_info, container, false);
        getActivity().setTitle("Info");
        listViewMessage = (ListView) myView.findViewById(R.id.listInfo);
        dummyInfo();
        initAdapter();
        return myView;
    }

    public void dummyInfo() {
        dataModels = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            dataModels.add(new InfoModel(i, "Ibadah " + (i + 1)));
        }
    }


    public void initAdapter() {
        adapter = new InfoAdapter(dataModels, getActivity().getApplicationContext());
        listViewMessage.setAdapter(adapter);
        listViewMessage.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                InfoModel dataModel = dataModels.get(position);

            }
        });

    }

}
