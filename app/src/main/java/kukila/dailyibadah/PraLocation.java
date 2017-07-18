package kukila.dailyibadah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PraLocation extends AppCompatActivity {
    private Button btn_location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pra_location);

        btn_location = (Button)findViewById(R.id.btn_manual);

        btn_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                location();
            }
        });
    }

    public void location(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }




}
