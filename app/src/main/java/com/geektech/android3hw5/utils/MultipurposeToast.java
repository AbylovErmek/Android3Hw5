package com.geektech.android3hw5.utils;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

public class MultipurposeToast {

    public static void show(Context context, String msg){
        Toast toast = Toast.makeText(context,msg,Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP,Gravity.CENTER,50);
        toast.show();
    }

}
