package cn.six.espresso.location;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import cn.six.espresso.aut.R;

@SuppressWarnings("MissingPermission")
public class AndroidLocationDemo extends Activity {
    private TextView tv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_btn);
        tv = (TextView)findViewById(R.id.tv_simple);

        LocationManager locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        String lastLocation = "latitude  = " + location.getLatitude() + " ; longitude = " + location.getLongitude();
        System.out.println("szw location = " + lastLocation);

    }

    public void onClickSimpleButton(View v) {
    }

    public void onClickSimpleButton2(View v) {
    }
}
