package aghazadeh.ahmad.multitheme;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.text.style.TtsSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import aghazadeh.ahmad.multitheme.databinding.CardThemeBinding;
import jp.satorufujiwara.binder.recycler.RecyclerBinder;

public class CardTheme extends RecyclerBinder<CardViewType>   {
    private ThemeData themeData;
    public CardTheme(Activity activity, ThemeData themeData) {
        super(activity, CardViewType.Theme);
        this.themeData = themeData;
    }
   @Override
    public int layoutResId() {
        return R.layout.card_theme;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(View parent) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(layoutResId(), (ViewGroup) parent, false);
        BindingHolder holder = new BindingHolder(v);
        return holder;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        final BindingHolder holder = (BindingHolder) viewHolder;
        holder.binding.setData(themeData);
        holder.binding.cardHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context=holder.binding.cardHolder.getContext();
                Utility.setTheme(context, themeData.getColor());

                Intent intent=new Intent("ACTION_CHANGE_THEME");
                context.sendBroadcast(intent);

            }
        });
    }



    public static class BindingHolder extends RecyclerView.ViewHolder {
        CardThemeBinding binding;
        public BindingHolder(View view) {
            super(view);
            binding = DataBindingUtil.bind(view);
        }
    }
}
