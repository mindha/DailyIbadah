package kukila.dailyibadah.BarMenu;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

import kukila.dailyibadah.Adapter.GrafikDetailIbadahAdapter;
import kukila.dailyibadah.Adapter.IbadahAdapter;
import kukila.dailyibadah.Adapter.model.GrafikDetailIbadahModel;
import kukila.dailyibadah.Adapter.model.IbadahWajibModel;
import kukila.dailyibadah.R;

/**
 * Created by Mindha on 24/07/2017.
 */

public class ListGrafikAll extends Fragment {
    View myView;

    private static GrafikDetailIbadahAdapter adapter;
    ArrayList<GrafikDetailIbadahModel> dataModels;
    ListView listViewMessage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.activity_grafik_all,container,false);
        listViewMessage = (ListView) myView.findViewById(R.id.list_detail_semua);
        dropdownList();
        graphIbadah();
        dummyInfo();
        initAdapter();

        ScrollView sv = (ScrollView)myView.findViewById(R.id.sc_scroll);
        LinearLayout ln = (LinearLayout)myView.findViewById(R.id.sc_linier);
        sv.scrollTo(0,ln.getTop());

        return myView;
    }

    public void graphIbadah(){
        GraphView graphView = (GraphView)myView.findViewById(R.id.graph);

        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(getDataPoint());
        graphView.addSeries(series);

        series.setColor(getResources().getColor(R.color.colorPrimary));
        series.setThickness(10);
        series.setDrawBackground(true);
        series.setBackgroundColor(Color.argb(60,95,226,156));
        series.setDrawDataPoints(true);
        series.setDataPointsRadius(16);
    }
    public void generateGraph(){
        GraphView graphView = (GraphView)myView.findViewById(R.id.graph);
        graphView.removeAllSeries();
        graphView.setBackgroundColor(getResources().getColor(android.R.color.white));

        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(getDataPoint());
        graphView.addSeries(series);

        series.setColor(getResources().getColor(R.color.colorPrimary));
        series.setThickness(10);
        series.setDrawBackground(true);
        series.setBackgroundColor(Color.argb(60,95,226,156));
        series.setDrawDataPoints(true);
        series.setDataPointsRadius(16);
    }
    private DataPoint[] getDataPoint() {
        DataPoint[] dp = new DataPoint[]
                {
                        new DataPoint((int )(Math.random() * 5 + 1),(int )(Math.random() * 8 + 5)),
                        new DataPoint((int )(Math.random() * 11 + 8),(int )(Math.random() * 14 + 11)),
                        new DataPoint((int )(Math.random() * 17 + 14),(int )(Math.random() * 20 + 17)),
                        new DataPoint((int )(Math.random() * 23 + 20),(int )(Math.random() * 26 + 23)),
                        new DataPoint((int )(Math.random() * 29 + 26),(int )(Math.random() * 32 + 29))
                };
        return (dp);
    }

    public void dummyInfo() {
        dataModels = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            int n = 80;

            dataModels.add(new GrafikDetailIbadahModel(i, n,"Nama Shalat"));
        }
    }


    public void initAdapter() {
        adapter = new GrafikDetailIbadahAdapter(dataModels, getActivity().getApplicationContext());
        listViewMessage.setAdapter(adapter);
        listViewMessage.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                GrafikDetailIbadahModel dataModel = dataModels.get(position);
            }
        });

    }

    public void dropdownList(){
        Spinner spinner_jumlah = (Spinner) myView.findViewById(R.id.periode);
        spinner_jumlah.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
//                Toast.makeText(getActivity().getApplicationContext(), String.valueOf(position), Toast.LENGTH_SHORT).show();
                generateGraph();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getActivity(),R.array.periode_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_jumlah.setAdapter(adapter2);
    }

}
