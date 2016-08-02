package com.example.nlashchy.holidays;

import android.content.Intent;
import android.provider.CalendarContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Add Toolbar Title
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_homescreen_name);
        setSupportActionBar(toolbar);

        // Open Calendar from Toolbar
        ImageView calendar = (ImageView) findViewById(R.id.calendar);
        assert calendar != null;
        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent calendarIntent = new Intent(Intent.ACTION_MAIN);
                calendarIntent.addCategory(Intent.CATEGORY_APP_CALENDAR);
                startActivity(calendarIntent);
            }
        });

        // Open Imprint from Toolbar
//        ImageView about = (ImageView) findViewById(R.id.about);
//        assert about !=null;
//        about.setOnClickListener(new View.onClickListener() {
//            @Override
//            public void onClick(View v) {
//            }
//        });

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
                openCalendarOnDate("Good Friday", "25", "2");
            }
        });

        // Find the Calendar Button fo the 28th of March
        ImageView calendar28thMarch = (ImageView) findViewById(R.id.calendar28thOfMarch);
        assert calendar28thMarch != null;
        calendar28thMarch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCalendarOnDate("Easter Monday", "28", "2");
            }
        });

        // Find the Calendar Button fo the 01st of May
        ImageView calendar01stMay = (ImageView) findViewById(R.id.calendar01stOfMay);
        assert calendar01stMay != null;
        calendar01stMay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCalendarOnDate("International Workers Day", "01", "4");
            }
        });

        // Find the Calendar Button fo the 05th of May
        ImageView calendar05thMay = (ImageView) findViewById(R.id.calendar05thOfMay);
        assert calendar05thMay != null;
        calendar05thMay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCalendarOnDate("Fathers Day", "05", "4");
            }
        });

        // Find the Calendar Button fo the 15th of May
        ImageView calendar15thMay = (ImageView) findViewById(R.id.calendar15thOfMay);
        assert calendar15thMay != null;
        calendar15thMay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCalendarOnDate("Whit Sunday", "15", "4");
            }
        });

        // Find the Calendar Button fo the 03th of October
        ImageView calendar03thOctober = (ImageView) findViewById(R.id.calendar03thOfOctober);
        assert calendar03thOctober != null;
        calendar03thOctober.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCalendarOnDate("German Unity Day", "03", "9");
            }
        });

        // Find the Calendar Button fo the 31st of October
        ImageView calendar31stOctober = (ImageView) findViewById(R.id.calendar31sthOfOctober);
        assert calendar31stOctober != null;
        calendar31stOctober.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCalendarOnDate("Reformation Day", "31", "9");
            }
        });

        // Find the Calendar Button fo the 25th of December
        ImageView calendar25thDecember = (ImageView) findViewById(R.id.calendar25thOfDecember);
        assert calendar25thDecember != null;
        calendar25thDecember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCalendarOnDate("Christmas Day", "25", "11");
            }
        });

        // Find the Calendar Button fo the 26th of December
        ImageView calendar26thDecember = (ImageView) findViewById(R.id.calendar26thOfDecember);
        assert calendar26thDecember != null;
        calendar26thDecember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCalendarOnDate("St Stephen's Day", "26", "11");
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



