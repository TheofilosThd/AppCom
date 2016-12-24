package com.example.teo.appcom;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import static android.R.id.message;

public class EmergencyActivity extends AppCompatActivity {

    private ImageButton police_btn;
    private ImageButton fire_btn;
    private ImageButton amb_button;
    private ImageButton torch_btn;
    private ImageButton home_btn;

    private Camera camera;
    private boolean isFlashOn;
    private boolean hasFlash;
    Camera.Parameters params;
    private String sos_phone = "2";
    private String sos_message = "HELP!!!";

    private TextView dateTime ;

    Handler handler=new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_datetime);
        //getSupportActionBar().setTitle((Html.fromHtml("<font color=\"#000000\" >" +currentDate + "</font>")));

        getSupportActionBar().setDisplayShowHomeEnabled(true);

        View view =getSupportActionBar().getCustomView();
        handler.post(updateTextRunnable);
       // getSupportActionBar().setTitle("");
        dateTime = (TextView) findViewById(R.id.datetime);
        police_btn = (ImageButton) findViewById(R.id.police_btn);
        fire_btn = (ImageButton) findViewById(R.id.fire_btn);
        amb_button = (ImageButton) findViewById(R.id.amb_btn);
        torch_btn = (ImageButton) findViewById(R.id.torch_btn);


        clickBtn(police_btn, "1000");
        clickBtn(fire_btn, "1999");
        clickBtn(amb_button, "1666");
        clickBtn(amb_button, "1666");

/*
        hasFlash = getApplicationContext().getPackageManager()
                .hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);

        if (!hasFlash) {
            // device doesn't support flash
            // Show alert message and close the application
            AlertDialog alert = new AlertDialog.Builder(EmergencyActivity.this)
                    .create();
            alert.setTitle("Error");
            alert.setMessage("Sorry, your device doesn't support flash light!");
            alert.setButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // closing the application
                    finish();
                }
            });
            alert.show();
            return;
        }

        getCamera();
*/
        torch_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //if (isFlashOn) {
                    // turn off flash
                   // turnOffFlash();
                //} else {
                    // turn on flash
                   // turnOnFlash();
                    android.telephony.SmsManager smsManager = android.telephony.SmsManager.getDefault();
                    String loc = myLoc();
                    sos_message = "ΚΙΝΔΥΝΕΥΩ!!! Βρίσκομαι στην τοποθεσία : "+loc;
                    smsManager.sendTextMessage(sos_phone, null, sos_message, null, null);
                    Toast.makeText(getApplicationContext(), "ΣΤΑΛΘΗΚΕ ΣΗΜΑ ΚΙΝΔΥΝΟΥ.", Toast.LENGTH_LONG).show();

               // }


            }
        });


    }


    public void makeCall(String telephone) {
        String number = telephone;
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        startActivity(intent);
    }

    public void clickBtn(ImageButton btn, final String tel) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeCall(tel);
            }
        });
    }

    private void getCamera() {
        if (camera == null) {
            try {
                camera = Camera.open();
                params = camera.getParameters();
            } catch (RuntimeException e) {
                Log.e("Eror: ", e.getMessage());
            }
        }
    }

    private void turnOnFlash() {
        if (!isFlashOn) {
            if (camera == null || params == null) {
                return;
            }


            params = camera.getParameters();
            params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
            camera.setParameters(params);
            camera.startPreview();
            isFlashOn = true;


        }

    }

    private void turnOffFlash() {
        if (isFlashOn) {
            if (camera == null || params == null) {
                return;
            }


            params = camera.getParameters();
            params.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
            camera.setParameters(params);
            camera.stopPreview();
            isFlashOn = false;


        }
    }

    public void sos() {

        String myString = "111000111";
        Handler handler = new Handler();


        for (int x = 0; x < myString.length(); x++) {
            if (myString.charAt(x) == '1') {
                handler.postDelayed(new Runnable() {
                    public void run() {
                        params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                        camera.setParameters(params);
                        camera.startPreview();
                    }
                }, 1000);

            } else {

                handler.postDelayed(new Runnable() {
                    public void run() {
                        params.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                        camera.setParameters(params);
                    }
                }, 1000);

            }


            handler.postDelayed(new Runnable() {
                public void run() {
                    params.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                    camera.setParameters(params);
                }
            }, 1000);
        }


    params.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
    camera.setParameters(params);
}


    public  String myLoc(){
        LocationManager locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 10, new LocationListener() {
            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {}
            @Override
            public void onProviderEnabled(String s) {}
            @Override
            public void onProviderDisabled(String s) {}
            @Override
            public void onLocationChanged(final Location location) {}
        });
        Location myLocation = locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);
        double longitude = myLocation.getLongitude();
        double latitude = myLocation.getLatitude();
        String message="https://www.google.co.id/maps/@"+latitude+","+longitude;
        return message;
    }

    Runnable updateTextRunnable=new Runnable(){
        public void run() {
            Calendar c = Calendar.getInstance(TimeZone.getTimeZone("GMT"), Locale.getDefault());
            SimpleDateFormat df = new SimpleDateFormat("  dd/MM/yyyy HH:mm ");
            String currentDate = df.format(c.getTime());
            dateTime.setText(currentDate);
            dateTime.setTextSize(25);
            handler.postDelayed(this, 1000);
        }
    };

}
