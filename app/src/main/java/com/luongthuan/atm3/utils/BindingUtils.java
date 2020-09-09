package com.luongthuan.atm3.utils;

import android.graphics.drawable.Drawable;

import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;
import androidx.databinding.InverseBindingListener;

import com.luongthuan.atm3.listener.OnTextChangeListener;
import com.luongthuan.atm3.view.CustomView;

public class BindingUtils {

    @BindingAdapter("title")
    public static void setTitle(CustomView customView, String title) {
        customView.setTitle(title);
    }

    @BindingAdapter("inputValue")
    public static void setInputValue(CustomView customView, String inputValue) {
        customView.setInputValue(inputValue);
    }

    @InverseBindingAdapter(attribute = "inputValue")
    public static String getInputValue(CustomView customView) {
        return customView.getInputValue();
    }

    @BindingAdapter(value = "inputValueAttrChanged")
    public static void setListener(CustomView customView, final InverseBindingListener listener) {
        customView.setOnTextChangedListener(new OnTextChangeListener() {
            @Override
            public void onTexChangeListener() {
                listener.onChange();
            }
        });
    }

    @BindingAdapter("enabled")
    public static void setEnabled(CustomView customView, boolean enabled) {
        customView.setEnabled(enabled);
    }

    @BindingAdapter("onclick")
    public static void setOnClick(CustomView customView, String mess) {
        customView.setOnClick(mess);
    }

    @BindingAdapter("visible")
    public static void setVisible(CustomView customView, int visible) {
        customView.setVisible(visible);
    }

    @BindingAdapter("background")
    public static void setBackground(CustomView customView, Drawable drawable) {
        customView.setBackground(drawable);
    }
}
