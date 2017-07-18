package kukila.dailyibadah.NavbarMenu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kukila.dailyibadah.R;

/**
 * Created by Mindha on 13/07/2017.
 */

public class Ibadah extends Fragment {
    View myView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_ibadah,container,false);
        getActivity().setTitle("Ibadah");
        return myView;

    }


}
