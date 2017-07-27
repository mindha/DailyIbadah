package kukila.dailyibadah.NavbarMenu;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;

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

    private Dialog dialog;
    View myView;
    private static IbadahSunnahAdapter adapter;
    ArrayList<IbadahSunnahModel> dataModels;
    private static IbadahWajibAdapter adapteribadahwajib;
    ArrayList<IbadahWajibModel> dataModelsWajib;
    ListView listViewIbadahSunnah, listViewIbadahWajib;

    private ImageView time;
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

        time = (ImageView)myView.findViewById(R.id.time);

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogLaporanShalatSunnah();
            }
        });

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

    private void dialogLaporanShalatSunnah(){
        dialog = new Dialog(getActivity());  // always give context of activity.
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_time);

        Spinner spinner_jenis = (Spinner) dialog.findViewById(R.id.time_awal);
        spinner_jenis.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),R.array.time_awal, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_jenis.setAdapter(adapter);

        Spinner spinner_tempat = (Spinner) dialog.findViewById(R.id.time_akhir);
        spinner_tempat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getActivity(),R.array.time_akhir, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_tempat.setAdapter(adapter2);


        dialog.show();
    }
}