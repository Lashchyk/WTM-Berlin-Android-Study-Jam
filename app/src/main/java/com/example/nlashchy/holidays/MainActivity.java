package com.example.nlashchy.holidays;

import android.content.Intent;
import android.provider.CalendarContract;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import java.util.Calendar;

public class MainActivity extends ActionBarActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Add Toolbar Title
        //toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        // Find the Calendar Button fo the 1st of January
        ImageView calendar1stOfJanuary = (ImageView) findViewById(R.id.calendar1stJanuary);
        if (calendar1stOfJanuary != null) {
            calendar1stOfJanuary.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // title,  day,  month,  year)
                    openCalendarOnDate("New Year's Day", "1", "0");
                }
            });
        }

        // Find the Calendar Button fo the 25th of March
        ImageView calendar25thMarch = (ImageView) findViewById(R.id.calendar25thOfMarch);
        assert calendar25thMarch != null;
        calendar25thMarch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCalendarOnDate("Good Friday", "25", "1");
            }
        });
    }


    private void openCalendarOnDate(String title, String day, String month) {
        Calendar date = Calendar.getInstance();
        date.set(Calendar.MONTH, Integer.parseInt(month));
        date.set(Calendar.YEAR, 2016);
        date.set(Calendar.DAY_OF_MONTH, Integer.parseInt(day));

        Intent intent = new Intent(Intent.ACTION_INSERT)
                .setData(CalendarContract.Events.CONTENT_URI)
                .putExtra(CalendarContract.Events.TITLE, title)
                .putExtra(CalendarContract.Events.EVENT_LOCATION, "Berlin")
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, date.getTime().getTime())
                .putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true);
        //.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, end);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}


    //                Intent calendarIntent = new Intent(Intent.ACTION_MAIN);
//                calendarIntent.addCategory(Intent.CATEGORY_APP_CALENDAR);
//                calendarIntent.putExtra("beginTime", )
//
//                startActivity(calendarIntent);



