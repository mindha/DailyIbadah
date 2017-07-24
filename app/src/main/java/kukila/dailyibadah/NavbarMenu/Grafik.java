package kukila.dailyibadah.NavbarMenu;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import kukila.dailyibadah.BarMenu.Puasa;
import kukila.dailyibadah.BarMenu.Sedekah;
import kukila.dailyibadah.R;

import kukila.dailyibadah.BarMenu.ListGrafikAll;

/**
 * Created by Mindha on 13/07/2017.
 */

public class Grafik extends Fragment {
    View myView;
    TabLayout tabLayout;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_grafik,container,false);
        getActivity().setTitle("Grafik Ibadah");


        mSectionsPagerAdapter = new SectionsPagerAdapter(getChildFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) myView.findViewById(R.id.content_grafik);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        tabLayout = (TabLayout) myView.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.setBackgroundColor(getResources().getColor(R.color.grey));
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorPrimary));
        tabLayout.setTabTextColors(getResources().getColor(R.color.abuSedang), getResources().getColor(R.color.colorPrimary));

        return myView;
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    ListGrafikAll tab1 = new ListGrafikAll();
                    return tab1;
                case 1:
                    Puasa tab2 = new Puasa();
                    return tab2;
                case 2:
                    Sedekah tab3 = new Sedekah();
                    return tab3;
                case 3:
                    Sedekah tab4 = new Sedekah();
                    return tab4;
                default:
                    return null;
            }
        }
        @Override
        public int getCount() {
            // Show 3 total pages.
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Semua";
                case 1:
                    return "Ibadah";
                case 2:
                    return "Puasa";
                case 3:
                    return "Sedekah";
            }
            return null;
        }
    }
}
