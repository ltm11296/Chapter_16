package com.example.chap_7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DrinkActivity extends AppCompatActivity {
  public static final String EXTRA_DRINKID = "drinkId";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
        int id = getIntent().getExtras().getInt(EXTRA_DRINKID);
        Drinks drink = Drinks.drink[id];
        TextView textview = findViewById(R.id.name);
        textview.setText(drink.getName());
        TextView tv = findViewById(R.id.description);
        tv.setText(drink.getDescription());
        ImageView img = findViewById(R.id.photo);
        img.setImageResource(drink.getImageResourceId());
        img.setContentDescription(drink.getDescription());
    }
}
