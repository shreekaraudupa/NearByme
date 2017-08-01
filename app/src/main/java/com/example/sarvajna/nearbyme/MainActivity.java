package com.example.sarvajna.nearbyme;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etPlace;
    Spinner spnOptions;
    Button btnSearch;;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPlace= (EditText) findViewById(R.id.etPlace);
        spnOptions= (Spinner) findViewById(R.id.spnOptions);
        btnSearch= (Button) findViewById(R.id.btnSearch);


        final ArrayList<String> op=new ArrayList<>();
        op.add("Restaurants");
        op.add("Petrol Station");
        op.add("Chemist");
        op.add("ATM");
        op.add("Banks");

        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_spinner_item,op);

        spnOptions.setAdapter(adapter);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String  place=etPlace.getText().toString();
                String option=op.get(spnOptions.getSelectedItemPosition());

                Intent i =new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("geo:0,0?q=" +place+","+option));
                startActivity(i);



            }
        });


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select action");
        menu.a
    }
}
