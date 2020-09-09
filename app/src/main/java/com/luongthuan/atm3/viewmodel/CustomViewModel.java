package com.luongthuan.atm3.viewmodel;

import android.content.Context;

import androidx.databinding.ObservableField;

public class CustomViewModel {
    private Context mContext;

    public ObservableField<String> card;

    public CustomViewModel(Context context){
        mContext=context;
        initData();
    }

    private void initData() {
        card=new ObservableField<>();

    }
}
