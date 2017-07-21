package kukila.dailyibadah.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import java.util.ArrayList;

import kukila.dailyibadah.Adapter.model.DateHeaderModel;

/**
 * Created by Mindha on 21/07/2017.
 */

public class DateHeaderAdapter extends FragmentStatePagerAdapter{

    private ArrayList<DateHeaderModel> dateHeaderModels;
    private DateHeaderAdapter(FragmentManager fm, ArrayList<DateHeaderModel> dateHeaderModelsArrayList){
        super(fm);
        Log.i("gitsDate","Adapter called");
        this.dateHeaderModels = dateHeaderModelsArrayList;
    }

    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
