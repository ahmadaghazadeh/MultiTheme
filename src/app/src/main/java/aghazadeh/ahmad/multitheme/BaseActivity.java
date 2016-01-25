package aghazadeh.ahmad.multitheme;

import android.os.Build;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import android.view.WindowManager;

public class BaseActivity extends AppCompatActivity {

    private final static int THEME_BLUE = 1;
    private final static int THEME_RED = 2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        updateTheme();
    }

    public void updateTheme() {

        String color=Utility.getTheme(getApplication());
        int themeID=getResources().getIdentifier("AppTheme."+color,"style", getPackageName());
        if(themeID==0)
            themeID=R.style.AppTheme_blue_grey;
        setTheme(themeID);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            int colorId=  getResources().getIdentifier("primaryColorDark_"+color,"color",getPackageName());
            getWindow().setStatusBarColor(getResources().getColor(colorId));
        }

    }


}
