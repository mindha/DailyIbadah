package kukila.dailyibadah.BarMenu;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
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
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.ArrayList;

import kukila.dailyibadah.Adapter.IbadahAdapter;
import kukila.dailyibadah.Adapter.InfoAdapter;
import kukila.dailyibadah.Adapter.ShalatSunnahAdapter;
import kukila.dailyibadah.Adapter.model.IbadahSunnahModel;
import kukila.dailyibadah.Adapter.model.IbadahWajibModel;
import kukila.dailyibadah.Adapter.model.InfoModel;
import kukila.dailyibadah.R;

public class ListIbadah extends Fragment {
    View myView;

    private Dialog dialog;
    private RadioGroup rg,rg1;

    private static IbadahAdapter adapter;
    ArrayList<IbadahWajibModel> dataModels;

    private static ShalatSunnahAdapter adapterSunnah;
    ArrayList<IbadahSunnahModel> dataModelSunnah;
    ListView listViewMessage, listViewSunnah;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.activity_list_ibadah,container,false);
        listViewMessage = (ListView) myView.findViewById(R.id.listIbadahShalat);
        listViewSunnah = (ListView) myView.findViewById(R.id.listIbadahShalatSunnah);
        dummyInfo();
        initAdapter();
        dummyIbadahSunnah();
        AdapterSunnah();



        ImageView fab = (ImageView) myView.findViewById(R.id.add_ibadah);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogTambah();
            }
        });

        return myView;
    }

    public void dummyInfo() {
        dataModels = new ArrayList<>();
        dataModels.add(new IbadahWajibModel(0,"Shalat Subuh","7 jam 16 menit yang lalu","04.23","wajib"));
        dataModels.add(new IbadahWajibModel(1,"Shalat Dzuhur","Beberapa Menit yang lalu","11.39","wajib"));
        dataModels.add(new IbadahWajibModel(2,"Shalat Ashar","3 jam 27 menit lagi","14.59","wajib"));
        dataModels.add(new IbadahWajibModel(3,"Shalat Maghrib","6 jam 7 menit lagi","17.32","wajib"));
        dataModels.add(new IbadahWajibModel(4,"Shalat Isya","7 jam 20 menit lagi","18.44","wajib"));

    }


    public void initAdapter() {
        adapter = new IbadahAdapter(dataModels, getActivity().getApplicationContext());
        listViewMessage.setAdapter(adapter);
        listViewMessage.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                IbadahWajibModel dataModel = dataModels.get(position);
                if(position == 2) {
                    createAndShowAlertDialog(dataModel.getKategori());
                }

            }
        });
    }

    public void dummyIbadahSunnah() {
        dataModelSunnah = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            //public IbadahWajibModel(int id, String namaIbadah, String waktu, String menit)
            dataModelSunnah.add(new IbadahSunnahModel(i,"Shalat Sunnah",(i+2)+"0 Menit yang lalu","12.34","sunah"));
        }

    }


    public void AdapterSunnah() {
        adapterSunnah = new ShalatSunnahAdapter(dataModelSunnah, getActivity().getApplicationContext());
        listViewSunnah.setAdapter(adapterSunnah);
        listViewSunnah.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                IbadahSunnahModel dataModel = dataModelSunnah.get(position);
                createAndShowAlertDialog(dataModel.getKategori());

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
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_jumlah.setAdapter(adapter2);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }


    private void dialogLaporanShalatSunnah(){
        dialog = new Dialog(getActivity());  // always give context of activity.
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_laporan_shalat_sunah);
        ImageView image = (ImageView) dialog.findViewById(R.id.closeaja);

        Spinner spinner_jenis = (Spinner) dialog.findViewById(R.id.jenis_shalat);
        spinner_jenis.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),R.array.jenis_shalat_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_jenis.setAdapter(adapter);

        Spinner spinner_tempat = (Spinner) dialog.findViewById(R.id.tempat_shalat);
        spinner_tempat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getActivity(),R.array.tempat_shalat_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_tempat.setAdapter(adapter2);


        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    private void dialogSholatWajib(){
        dialog = new Dialog(getActivity());  // always give context of activity.
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_laporan_shalat_wajib);
        ImageView image = (ImageView) dialog.findViewById(R.id.closeaja);

        Spinner spinner_jenis = (Spinner) dialog.findViewById(R.id.jenis_shalat);
        spinner_jenis.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),R.array.jenis_shalat_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_jenis.setAdapter(adapter);

        Spinner spinner_tempat = (Spinner) dialog.findViewById(R.id.tempat_shalat);
        spinner_tempat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getActivity(),R.array.tempat_shalat_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_tempat.setAdapter(adapter2);

        rg = (RadioGroup) dialog.findViewById(R.id.shalat_badiyah);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.ya_badiyah:
                        // do operations specific to this selection
                        break;
                    case R.id.tidak_badiyah:
                        // do operations specific to this selection
                        break;
                }
            }
        });


        rg1 = (RadioGroup) dialog.findViewById(R.id.shalat_qabliyah);
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.ya_qabliyah:
                        // do operations specific to this selection
                        break;
                    case R.id.tidak_qabliyah:
                        // do operations specific to this selection
                        break;
                }
            }
        });



        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    private void createAndShowAlertDialog(final String kategori) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Apakah Anda sudah melakukan ibadah sholat?");
        builder.setPositiveButton("Iya", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //TODO
                if(kategori == "wajib"){
                    dialogSholatWajib();
                }else {
                    dialogLaporanShalatSunnah();
                }
            }
        });
        builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //TODO
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void DialogTambah() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Apakah Anda ingin menambahkan ibadah sunnah?");
        builder.setPositiveButton("Iya", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                    dialogTambahShalat();

            }
        });
        builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //TODO
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}

