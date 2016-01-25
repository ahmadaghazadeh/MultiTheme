package aghazadeh.ahmad.multitheme;


import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Locale;

import butterknife.ButterKnife;
import butterknife.InjectView;
import jp.satorufujiwara.binder.recycler.RecyclerBinderAdapter;

/**
 * Created by 890683 on 1/24/2016.
 */
public class FragmentTheme extends Fragment {

    public static  FragmentTheme newInstance() {
        return new  FragmentTheme();
    }

    @InjectView(R.id.recycler_view_main)
    RecyclerView recyclerView;
    private StaggeredGridLayoutManager mStaggeredLayoutManager;
    private final RecyclerBinderAdapter<TitleSection, CardViewType> adapter
            = new RecyclerBinderAdapter<>();

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_theme, container, false);
        ButterKnife.inject(this, v);
        return v;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mStaggeredLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mStaggeredLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        String[] themeList = getResources().getStringArray(R.array.ThemeList);

        Resources standardResources = getResources();
        AssetManager assets = standardResources.getAssets();
        DisplayMetrics metrics = standardResources.getDisplayMetrics();
        Configuration config = new Configuration(standardResources.getConfiguration());
        config.locale = Locale.getDefault();
        Resources defaultResources = new Resources(assets, metrics, config);

        String[] themeListEng = defaultResources.getStringArray(R.array.ThemeList);
        for (int i = 0; i < themeList.length; i++) {
           ThemeData themeData=new ThemeData(themeList[i],themeListEng[i]);
           CardTheme cardTheme=new CardTheme(getActivity(),themeData);
           adapter.add(TitleSection.ThemeSction, cardTheme);
        }





    }
}
