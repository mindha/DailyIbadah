package kukila.dailyibadah.NavbarMenu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kukila.dailyibadah.BarMenu.ListIbadah;
import kukila.dailyibadah.BarMenu.Puasa;
import kukila.dailyibadah.BarMenu.Sedekah;
import kukila.dailyibadah.R;

/**
 * Created by Mindha on 13/07/2017.
 */

public class Ibadah extends Fragment {
    View v;

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_ibadah, container, false);
        getActivity().setTitle("Ibadah");

        mSectionsPagerAdapter = new SectionsPagerAdapter(getChildFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) v.findViewById(R.id.containers);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) v.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        return v;
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    ListIbadah tab1 = new ListIbadah();
                    return tab1;
                case 1:
                    Puasa tab2 = new Puasa();
                    return tab2;
                case 2:
                    Sedekah tab3 = new Sedekah();
                    return tab3;
                default:
                    return null;
            }
        }
        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Ibadah";
                case 1:
                    return "Puasa";
                case 2:
                    return "Sedekah";
            }
            return null;
        }
    }



}
