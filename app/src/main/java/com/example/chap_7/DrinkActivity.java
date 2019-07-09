package com.example.chap_7;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class DrinkActivity extends AppCompatActivity {
    public static final String EXTRA_DRINKID = "drinkId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
        int id = getIntent().getExtras().getInt(EXTRA_DRINKID);
        try {
            StarbuzzDatabaseHelper starbuzzDatabaseHelper = new StarbuzzDatabaseHelper(this);
            SQLiteDatabase sqLiteDatabase = starbuzzDatabaseHelper.getReadableDatabase();
            Cursor cursor = sqLiteDatabase.query("DRINK", new String[]{"NAME", "DESCRIPTION", "IMAGE_RESOURCE_ID"}, "_id=?", new String[]{Integer.toString(id)}, null, null, null);
            if (cursor.moveToFirst()) {
                String name = cursor.getString(0);
                String description = cursor.getString(1);
                int imageID = cursor.getInt(2);
                TextView nameText = findViewById(R.id.name);
                nameText.setText(name);
                TextView descriptionText = findViewById(R.id.description);
                descriptionText.setText(description);
                ImageView imageView = findViewById(R.id.photo);
                imageView.setImageResource(imageID);
            }
            cursor.close();
            sqLiteDatabase.close();

        } catch (SQLiteException e) {
            Toast toast = Toast.makeText(this, "Error", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
