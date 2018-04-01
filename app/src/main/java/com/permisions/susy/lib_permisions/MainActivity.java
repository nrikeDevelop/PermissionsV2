package com.permisions.susy.lib_permisions;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context=this;

        requestPermissions(new String[] {Manifest.permission.GET_ACCOUNTS,
                Manifest.permission.READ_CALENDAR,
                Manifest.permission.READ_SMS});


    }

    //PERMISIONS
    final private int REQUEST_PERMISSIONS = 101;
    private void requestPermissions(String[] permissions) {
        ActivityCompat.requestPermissions(this,permissions,
                REQUEST_PERMISSIONS);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode){
            case REQUEST_PERMISSIONS:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //granted
                    Toast.makeText(this,
                            "All permits accepted",
                            Toast.LENGTH_SHORT).show();

                } else {
                    //not granted
                    Toast.makeText(this,
                            "Missing permissions to accept",
                            Toast.LENGTH_SHORT).show();
                }
                break;
        }


        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
