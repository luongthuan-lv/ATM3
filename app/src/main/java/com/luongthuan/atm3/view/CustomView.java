package com.luongthuan.atm3.view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.adapters.TextViewBindingAdapter;

import com.luongthuan.atm3.R;
import com.luongthuan.atm3.databinding.CustomViewBinding;
import com.luongthuan.atm3.listener.OnTextChangeListener;
import com.luongthuan.atm3.viewmodel.LocaleHelper;

public class CustomView extends ConstraintLayout {
    public Context mContext;
    public CustomViewBinding mBinding;
    public Resources resources;

    public CustomView(@NonNull Context context) {
        super(context);
        initUI(context);
    }

    public CustomView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initUI(context);

    }

    public CustomView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initUI(context);
    }

    public CustomView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initUI(context);
    }

    private void initUI(Context context) {
        mContext = context;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mBinding = CustomViewBinding.inflate(inflater, this, true);

    }

    public void setTitle(String title) {
        if (mBinding != null) {
            mBinding.textView.setText(title);
        }
    }

    public void setInputValue(String inputValue) {
        if (mBinding != null) {
            mBinding.edtNumber.setText(inputValue);
        }
    }

    public void setEnabled(boolean enabled) {
        if (mBinding != null) {
            mBinding.btnTest.setEnabled(enabled);
        }
    }

    public void setVisible(int visible) {
        if (mBinding != null) {
            mBinding.image.setVisibility(visible);
        }
    }


    public void setBackground(Drawable background) {
        if (mBinding != null) {
            mBinding.btnTest.setBackground(background);
        }
    }

    public void setOnClick(final String mess) {
        if (mBinding != null) {
            mBinding.btnTest.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext, mess, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }


    public void setLanguage() {
        if (mBinding != null) {
            mBinding.button.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    final String[] Language = getResources().getStringArray(R.array.language_names);
                    AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                    builder.setTitle("Chọn ngôn ngữ")
                            .setItems(R.array.language_names, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    if (Language[i].equals("Việt Nam")) {
                                        resources = LocaleHelper.setLocale(mContext, "vi").getResources();
                                        mBinding.textView.setText(resources.getString(R.string.title));
                                        mBinding.edtNumber.setHint(resources.getString(R.string.hint));
                                        mBinding.button.setText(resources.getString(R.string.textbtn));
                                        mBinding.btnTest.setText(resources.getString(R.string.test));
                                        Toast.makeText(mContext, Language[i], Toast.LENGTH_SHORT).show();
                                        dialogInterface.dismiss();
                                    }

                                    if (Language[i].equals("English")) {
                                        resources = LocaleHelper.setLocale(mContext, "en").getResources();
                                        mBinding.textView.setText(resources.getString(R.string.title));
                                        mBinding.edtNumber.setHint(resources.getString(R.string.hint));
                                        mBinding.button.setText(resources.getString(R.string.textbtn));
                                        mBinding.btnTest.setText(resources.getString(R.string.test));
                                        Toast.makeText(mContext, Language[i], Toast.LENGTH_SHORT).show();
                                        dialogInterface.dismiss();
                                    }
                                }
                            });
                    builder.create().show();
                }
            });
        }
    }

    public String getInputValue() {
        if (mBinding != null) {
            return TextUtils.isEmpty(mBinding.edtNumber.getText()) ? "" : mBinding.edtNumber.getText().toString().trim();
        } else {
            return "";
        }
    }

    public void setOnTextChangedListener(final OnTextChangeListener listener) {
        if (mBinding != null) {
            mBinding.edtNumber.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    if (listener != null) {
                        listener.onTexChangeListener();
                    }
                }
            });
        }

    }
}
