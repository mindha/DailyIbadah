package kukila.dailyibadah.BarMenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import kukila.dailyibadah.LoginActivity;
import kukila.dailyibadah.R;

public class DetailsInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_details_info);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.setTitle("Detail Info");
        onBackPressed();

    }


    @Override
    public void onBackPressed() {
        return;
    }

}
