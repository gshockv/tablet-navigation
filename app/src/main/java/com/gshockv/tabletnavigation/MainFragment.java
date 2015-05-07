package com.gshockv.tabletnavigation;

import android.app.Fragment;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        View toolbarShadow = view.findViewById(R.id.toolbar_shadow);
        setShadowDrawable(getResources(), toolbarShadow, R.drawable.actionbar_shadow);
    }

    private void setShadowDrawable(Resources resources, View shadowView, int shadowDrawableId) {
        if (resources == null || shadowView == null) {
            return;
        }
        final BitmapDrawable bg = new BitmapDrawable(resources,
                BitmapFactory.decodeResource(resources, shadowDrawableId));
        bg.setAntiAlias(true);
        bg.setTileModeX(Shader.TileMode.REPEAT);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
            //noinspection deprecation
            shadowView.setBackgroundDrawable(bg);
        } else {
            shadowView.setBackground(bg);
        }
    }
}
