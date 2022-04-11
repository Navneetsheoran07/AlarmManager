package com.sheoran.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity2 extends AppCompatActivity {
    DatePicker datePicker;
    TimePicker timePicker;
    Button button ;
    int t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        datePicker = findViewById(R.id.datepicker);
        timePicker = findViewById(R.id.timepickers);

        button = findViewById(R.id.submitbtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth(),
                        timePicker.getCurrentHour(), timePicker.getCurrentMinute(), 0);
                long time = calendar.getTimeInMillis();

                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                PendingIntent pi = PendingIntent.getActivity(MainActivity2.this, 1, intent, 0);

                AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
//                am.set(AlarmManager.RTC_WAKEUP, time, pi);
                am.setRepeating(AlarmManager.RTC_WAKEUP, time, 60000, pi);
            }
        });


    }


}