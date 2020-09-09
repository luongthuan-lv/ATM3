package com.luongthuan.atm3.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.luongthuan.atm3.R;
import com.luongthuan.atm3.databinding.ActivityMainBinding;
import com.luongthuan.atm3.listener.OnTextChangeListener;
import com.luongthuan.testsdk.SdkActivity;
import com.luongthuan.testsdk.ToasterMess;

public class MainActivity extends AppCompatActivity {
    public ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.data.setOnTextChangedListener(new OnTextChangeListener() {
            @Override
            public void onTexChangeListener() {
                if (binding.data.getInputValue().trim().length()==0) {
                    binding.data.setEnabled(false);
                    binding.data.setVisible(View.VISIBLE);
                    binding.data.setBackground(getResources().getDrawable(R.drawable.button1));
                } else {
                    binding.data.setEnabled(true);
                    binding.data.setVisible(View.INVISIBLE);
                    binding.data.setBackground(getResources().getDrawable(R.drawable.button2));
                }
            }
        });

        binding.data.setOnClick("Hello bạn nhỏ");
        binding.data.setLanguage();
    }
}