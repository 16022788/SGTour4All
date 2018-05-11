package com.wordpress.yinghengsite.sgtour4all;

import android.app.Dialog;
import android.content.Intent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

public class Detailss extends AppCompatActivity{

    ImageView pic;
    EditText etDes;
    Button btnNextBk;

    private static final String TAG = "MainActivity";

    private static final int ERROR_DIALOG_REQUEST = 9001;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailss);

        etDes = (EditText)findViewById(R.id.editTextDescription);
        btnNextBk = (Button)findViewById(R.id.buttonNextBack);
        pic = (ImageView)findViewById(R.id.pic);


        Intent mIntent = getIntent();
        if(mIntent.hasExtra("picAttractions")){
            int picValue = mIntent.getIntExtra("picAttractions", 0);
            int desValue = mIntent.getIntExtra("descriptionAttractions", 0);
            int loctValue = mIntent.getIntExtra("locationAttractions", 0);
            pic.setImageResource(R.drawable.chillicrab);

            etDes.setText(desValue);



        }else if(mIntent.hasExtra("picHotel")){
            // Do something else
            int picValue = mIntent.getIntExtra("picHotel", 0);
            int desValue = mIntent.getIntExtra("descriptionHotel", 0);
            int loctValue = mIntent.getIntExtra("locationHotel", 0);
        }else{
            int picValue = mIntent.getIntExtra("picFood", 0);
            int desValue = mIntent.getIntExtra("descriptionFood", 0);
            int loctValue = mIntent.getIntExtra("locationFood", 0);

        }


        if(isServicesOK()){
            init();
        }

    }

    private void init(){
        Button btnMap = (Button)findViewById(R.id.btnMap);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Detailss.this,MapActivity.class);
                startActivity(intent);
            }
        });
    }


    public boolean isServicesOK(){
        Log.d(TAG,"isServicesOK:checking google services version");

        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(Detailss.this);

        if(available == ConnectionResult.SUCCESS){
            Log.d(TAG,"isServicesOK: Google Play Services is working");
            return true;

        }
        else if(GoogleApiAvailability.getInstance().isUserResolvableError(available)){
            //an error occured but we can resolve it
            Log.d(TAG,"isServicesOk: an error occured but we can fix it");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(Detailss.this,available,ERROR_DIALOG_REQUEST);
            dialog.show();
        }else{
            Toast.makeText(this,"you can't make map requests",Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}
