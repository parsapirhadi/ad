package com.example.myapplication.V.Activity;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import androidx.annotation.NonNull;

import com.example.myapplication.R;

public class SettingDialog  {
    Context context;
    Dialog dialog;
    public SettingDialog(Context context) {

        this.context=context;
        init();
    }

    private void init() {
        dialog=new Dialog(context);
        dialog.setContentView(R.layout.settings);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

    }
    public void show(){
        dialog.show();
    }

}
