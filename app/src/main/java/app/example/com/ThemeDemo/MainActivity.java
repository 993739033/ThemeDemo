package app.example.com.ThemeDemo;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setT();
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_change).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onChange();
            }
        });
    }
    private void setT() {
        Boolean isDay= getSharedPreferences("theme", MODE_PRIVATE).getBoolean("isday", true);
        if (isDay) {
            setTheme(R.style.Themes_Day);
        }else {
            setTheme(R.style.Themes_Dark);
        }


//        this.setTheme(R.style.Themes_Dark);
    }

    public void onChange() {
       Boolean isDay= getSharedPreferences("theme", MODE_PRIVATE).getBoolean("isday", true);
        SharedPreferences.Editor sp = getSharedPreferences("theme",MODE_PRIVATE).edit();
        sp.putBoolean("isday", !isDay);
        sp.commit();
        recreate();
    }
}
