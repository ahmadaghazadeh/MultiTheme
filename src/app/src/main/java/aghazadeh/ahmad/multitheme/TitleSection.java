package aghazadeh.ahmad.multitheme;

import jp.satorufujiwara.binder.Section;

/**
 * Created by 890683 on 1/10/2016.
 */
public enum TitleSection implements Section {
    ThemeSction,
    Line;
    @Override
    public int position() {
        return ordinal();
    }
}
