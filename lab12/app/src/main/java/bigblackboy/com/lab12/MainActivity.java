package bigblackboy.com.lab12;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etAddress, etLatitude, etLongitude;
    Button btnSearch;
    RadioGroup rg;
    RadioButton rbAddress, rbGeo;
    CheckBox chBoxStreet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAddress = findViewById(R.id.etAddress);
        etLatitude = findViewById(R.id.etLatitude);
        etLongitude = findViewById(R.id.etLongitude);
        btnSearch = findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(this);
        rg = findViewById(R.id.rg);
        rbAddress = findViewById(R.id.rbAddress);
        rbAddress.setOnClickListener(this);
        rbGeo = findViewById(R.id.rbGeo);
        rbGeo.setOnClickListener(this);
        chBoxStreet = findViewById(R.id.chBoxStreet);
    }

    @Override
    public void onClick(View v) {
        String lat = etLatitude.getText().toString();
        String lon = etLongitude.getText().toString();
        String addr = etAddress.getText().toString();
        switch (v.getId()) {
            case R.id.btnSearch:
                String uriString = "";
                Uri geo;
                if (chBoxStreet.isChecked()) {
                    uriString = String.format("google.streetview:cbll=%s,%s&cbp=1,99.56,,1,2.0&mz=19", lat, lon);
                }
                else {
                    if(rbAddress.isChecked()) {
                        uriString = String.format("geo:0,0?q=%s", addr);
                    } else {
                        uriString = String.format("geo:%s,%s?z=15", lat, lon);
                    }
                }
                geo = Uri.parse(uriString);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, geo);
                startActivity(mapIntent);
                break;
            case R.id.rbGeo:
                chBoxStreet.setVisibility(View.VISIBLE);
                break;
            case R.id.rbAddress:
                chBoxStreet.setVisibility(View.GONE);
                chBoxStreet.setChecked(false);
                break;
        }
    }
}
