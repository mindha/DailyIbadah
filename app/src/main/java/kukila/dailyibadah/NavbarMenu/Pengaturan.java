package kukila.dailyibadah.NavbarMenu;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import kukila.dailyibadah.R;

/**
 * Created by Mindha on 13/07/2017.
 */

public class Pengaturan extends Fragment {
    View myView;
    LinearLayout loc;

    private Dialog dialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_pengaturan,container,false);
        getActivity().setTitle("Pengaturan");
        kalkulasi();
        juristik();

        loc = (LinearLayout)myView.findViewById(R.id.loc);
        ImageView im_kal =(ImageView)myView.findViewById(R.id.ask_kalkulasi);
        ImageView im_jur =(ImageView)myView.findViewById(R.id.ask_juristik);

        im_kal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popUpKalkulasi();
            }
        });

        im_jur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popUpJuristik();
            }
        });

        loc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popUplokasi();
            }
        });

        return myView;

    }

    public void kalkulasi(){
        String[] listArray={"Ithna Ashari", "University of Islamic Science", "Islamic Society of North America (ISNA)", "World Moslem League (WML)", "Umma Al-Qura, Makkah"};

        ArrayAdapter adapter = new ArrayAdapter(getActivity(),R.layout.item_kalkulasi,listArray);

        ListView listView = (ListView) myView.findViewById(R.id.listKalkulasi);
        listView.setAdapter(adapter);
    }

    public void juristik(){
        String[] listArray={ "Imam Syafi’i","Imam Hanafi", "Imam Malik", "Imam Hambali"};

        ArrayAdapter adapter = new ArrayAdapter(getActivity(),R.layout.item_juristik,listArray);

        ListView listView = (ListView) myView.findViewById(R.id.listJuristik);
        listView.setAdapter(adapter);
    }



    public void popUplokasi(){
        dialog = new Dialog(getActivity());  // always give context of activity.
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_ubah_lokasi);
        ImageView image = (ImageView) dialog.findViewById(R.id.closeaja);


        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    public void popUpKalkulasi(){
        dialog = new Dialog(getActivity());  // always give context of activity.
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_info_metode_kalkulasi);
        ImageView image = (ImageView) dialog.findViewById(R.id.closeaja);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    public void popUpJuristik(){
        dialog = new Dialog(getActivity());  // always give context of activity.
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_info_metode_juristik);
        ImageView image = (ImageView) dialog.findViewById(R.id.closeaja);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
