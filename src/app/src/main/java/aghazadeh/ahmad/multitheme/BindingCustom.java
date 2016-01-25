package aghazadeh.ahmad.multitheme;

import android.databinding.BindingAdapter;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

/**
 * Created by 890683 on 1/24/2016.
 */
public class BindingCustom {

    @BindingAdapter("backgroundColor")
    public static void setBackgrandColor(View view, @Nullable String color) {
       int colorId= view.getResources().getIdentifier(color,"color",view.getContext().getPackageName());
       view.setBackgroundColor(view.getResources().getColor(colorId));
    }
}
