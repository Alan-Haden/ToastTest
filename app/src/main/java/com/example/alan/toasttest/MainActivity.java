package com.example.alan.toasttest;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button normalToastBtn;
    Button customTextToastBtn;
    Button fullCustomToastBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        normalToastBtn = (Button)findViewById(R.id.nToast);
        customTextToastBtn = (Button)findViewById(R.id.ctToast);
        fullCustomToastBtn = (Button)findViewById(R.id.fcToast);

        normalToastBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, getString(R.string.normalText), Toast.LENGTH_SHORT).show();
            }
        });

       customTextToastBtn.setOnClickListener(new View.OnClickListener() {
           @Override
       public void onClick(View v) {
               Toast toast = Toast.makeText(getApplicationContext(),getString(R.string.customText), Toast.LENGTH_SHORT);
               //toast.setGravity(Gravity.CENTER, 0, 0);
               //toast.getView().setPadding(10, 10, 10, 10);
               toast.getView().setBackgroundColor(Color.RED);
               TextView text = (TextView) toast.getView().findViewById(android.R.id.message);
               text.setTextColor(Color.WHITE);
               //text.setTextSize(14);
               toast.show();
           }
       });

        fullCustomToastBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get the LayoutInflater and inflate the custom_toast layout
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.custom_toast, (ViewGroup)
                        findViewById(R.id.toast_layout_root));

                //get the TextView from the custom_toast layout
                TextView text = (TextView) layout.findViewById(R.id.toastText);
                text.setText(getString(R.string.fullCustomText));

                //create the toast object, set display duration,
                //set the view as layout that's inflated above and then call show()
                Toast t = new Toast(getApplicationContext());
                t.setDuration(Toast.LENGTH_LONG);
                t.setGravity(Gravity.CENTER, 0, 0);
                t.setView(layout);
                t.show();
            }
        });
    }
}
