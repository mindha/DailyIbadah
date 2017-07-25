package kukila.dailyibadah.BarMenu;

import android.app.Dialog;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
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

import kukila.dailyibadah.Adapter.IbadahAdapter;
import kukila.dailyibadah.Adapter.InfoAdapter;
import kukila.dailyibadah.Adapter.model.IbadahWajibModel;
import kukila.dailyibadah.Adapter.model.InfoModel;
import kukila.dailyibadah.R;

public class ListIbadah extends Fragment {
    View myView;

    private Dialog dialog;
    private static IbadahAdapter adapter;
    ArrayList<IbadahWajibModel> dataModels;
    ListView listViewMessage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.activity_list_ibadah,container,false);
        listViewMessage = (ListView) myView.findViewById(R.id.listIbadahShalat);
        dummyInfo();
        initAdapter();

        FloatingActionButton fab = (FloatingActionButton) myView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogTambahShalat();

            }
        });

        return myView;
    }

    public void dummyInfo() {
        dataModels = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            //public IbadahWajibModel(int id, String namaIbadah, String waktu, String menit)
            dataModels.add(new IbadahWajibModel(i,"Nama Shalat",(i+2)+"0 Menit yang lalu","12.34"));
        }
    }


    public void initAdapter() {
        adapter = new IbadahAdapter(dataModels, getActivity().getApplicationContext());
        listViewMessage.setAdapter(adapter);
        listViewMessage.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                IbadahWajibModel dataModel = dataModels.get(position);

            }
        });
    }

    public void dialogTambahShalat(){
        dialog = new Dialog(getActivity());  // always give context of activity.
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_tambah_shalat);
        ImageView image = (ImageView) dialog.findViewById(R.id.closeaja);

        Spinner spinner_pilih = (Spinner) dialog.findViewById(R.id.pilih_shalat);
        spinner_pilih.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),R.array.pilih_shalat_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_pilih.setAdapter(adapter);

        Spinner spinner_jumlah = (Spinner) dialog.findViewById(R.id.jumlah_rakaat);
        spinner_jumlah.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getActivity(),R.array.rakaat_shalat_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_jumlah.setAdapter(adapter2);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

}

