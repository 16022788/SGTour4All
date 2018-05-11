package com.wordpress.yinghengsite.sgtour4all;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spSelect;
    Button btnGO;
    String record = "";
    private static final String TAG = "MainActivity";

    ArrayList<String>descriptionFood;
    ArrayList<String>descriptionHotel;
    ArrayList<String>descriptionAttractions;

    ArrayList<Integer>picFood;
    ArrayList<Integer>picHotel;
    ArrayList<Integer>picAttractions;

    ArrayList<String>locationFood;
    ArrayList<String>locationHotel;
    ArrayList<String>locationAttractions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//DESCRIPTION ARRAY
        descriptionFood = new ArrayList<String>();

        descriptionFood.add("Despite its name, chilli crab is not a very spicy dish. It is listed at number 35 on the World's 50 most delicious foods compiled by CNN Go in 2011.");
        descriptionFood.add("Instead, the core ingredients of the cake are rice flour and white radish which some call white carrot. The mixture is steamed, then cut into cubes and fried with garlic, eggs and preserved radish");
        descriptionFood.add("various types of steamed buns, rice or wheat dumplings and rice noodle rolls, which contain a range of ingredients, including beef, chicken, pork, prawns, and vegetarian options.");
        descriptionFood.add("traditional fruit and vegetable salad dish commonly found in Indonesia, Malaysia and Singapore.");

        descriptionHotel = new ArrayList<String>();

        descriptionHotel.add("Fullerton Hotel Singapore is a five-star luxury hotel located near the mouth of the Singapore River, in the Downtown Core of the Central Area, Singapore.");
        descriptionHotel.add("Redefining luxury living for its guests with world-class facilities and finishing, as well as rare Singapore commodity, space; The Club Residences by Capella Singapore is one of the most delux serviced apartments in Singpaore.");
        descriptionHotel.add("Situated near Marina Bay and at the crossroads of the Kampong Glam, Little India and Bras Basah Bugis cultural districts, with their intimate shophouse-filled alleyways and atmospheric colours, textures and flavours, Andaz Singapore hotel aims to spark off a sense of discovery of the rich culture of Singapore, and inspire guests to experience the city through fresh perspectives.");
        descriptionHotel.add("Imagine yourself at the floor-to-ceiling windows of your 5-star hotel room, drinking in magnificent views of Singapore’s glittering city district or picture-perfect Gardens by the Bay.");

        descriptionAttractions = new ArrayList<String>();

        descriptionAttractions.add("The Singapore River is the most well-known river in Singapore and an important aspect of its history. The river spans about 3.2 km from the sea to Kim Seng Road. The mouth of the river has been dammed and it now flows into the Marina Reservoir");
        descriptionAttractions.add("Marina Bay Sands is an integrated resort fronting Marina Bay in Singapore. At its opening in 2010, it was billed as the world's most expensive standalone casino property at S$8 billion, including the land cost.");
        descriptionAttractions.add("Singapore’s historic Chinatown is a bustling mix of old and new, filled with traditional shops and markets as well as cool stores and cafes.");
        descriptionAttractions.add("At a height of 165m, Singapore Flyer is one of the world's largest Giant Observation Wheel and also one of Asia's biggest tourist attractions. Singapore Flyer was conceived and designed by Dr. Kisho Kurokawa and DP Architects, Singapore");
//END OF DESCRIPTION ARRAY

//PICS ARRAY
        picFood = new ArrayList<Integer>();
        //items
        picFood.add(R.drawable.chillicrab);
        picFood.add(R.drawable.friedcarrotcake);
        picFood.add(R.drawable.dimsum);
        picFood.add(R.drawable.rojak);

        picHotel = new ArrayList<Integer>();
        //items
        picHotel.add(R.drawable.fullertonbayhotel);
        picHotel.add(R.drawable.clubresidencesatcapella);
        picHotel.add(R.drawable.andaz);
        picHotel.add(R.drawable.marinabaysandshotel);

        picAttractions = new ArrayList<Integer>();
        //items
        picAttractions.add(R.drawable.singaporeriver);
        picAttractions.add(R.drawable.marinabay);
        picAttractions.add(R.drawable.chinatown);
        picAttractions.add(R.drawable.singaporeflyer);
//END PICS ARRAY

//location array
        locationFood = new ArrayList<String>();

        locationFood.add("1° 15' 0.3996'' N,103° 49' 51.3588'' E");
        locationFood.add("1.343807, 103.737918");
        locationFood.add("1.304247, 103.860222");
        locationFood.add("1.281492, 103.844844");

        locationHotel = new ArrayList<String>();

        locationHotel.add("1.2839° N, 103.8535° E");
        locationHotel.add("1.249528, 103.824635");
        locationHotel.add("1.2995° N, 103.8576° E");
        locationHotel.add("1.2834° N, 103.8607° E");

        locationAttractions = new ArrayList<String>();

        locationAttractions.add("1°17'21.3\"N, 103°50'23.73\"E");
        locationAttractions.add("1.2834° N, 103.8607° E");
        locationAttractions.add("1.2848° N, 103.8439° E");
        locationAttractions.add("1.2893° N, 103.8631° E");
//END OF LOCATION ARRAY

        spSelect = (Spinner) findViewById(R.id.spinnerSelections);
        btnGO = (Button) findViewById(R.id.buttonGo);


        spSelect.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, final int position, long id) {
                switch(position){
                    case 0:
                        record = "Attractions";
                        break;
                    case 1:
                        record = "Hotel";
                        break;
                    case 2:
                        record = "Food";
                        break;

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }

        });


        btnGO.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(record.equals("Attractions")){
                    //setContentView(R.layout.activity_attractions);
                    Intent intent = new Intent(MainActivity.this, Detailss.class);
                    intent.putExtra("picAttractions", picAttractions);
                    intent.putExtra("descriptionAttractions",descriptionAttractions);
                    intent.putExtra("locationAttractions", locationAttractions);
                    startActivity(intent);

                } else if(record.equals("Hotel")){
                    //setContentView(R.layout.activity_hotel);
                    Intent intent = new Intent(MainActivity.this, Detailss.class);
                    intent.putExtra("picHotel", picHotel);
                    intent.putExtra("descriptionHotel", descriptionHotel);
                    intent.putExtra("locationHotel",locationHotel);
                    startActivity(intent);
                }else{
                    //setContentView(R.layout.activity_food);
                    Intent intent = new Intent(MainActivity.this, Detailss.class);
                    intent.putExtra("picFood",picFood);
                    intent.putExtra("descriptionFood", descriptionFood);
                    intent.putExtra("locationFood",
                            locationFood);
                    startActivity(intent);
                }
            }
        });


    }


}

