package com.sugarizer.sugarizerdeploymenttoolapp;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.view.WindowManager;

public class ProgressDialog extends AlertDialog {

    public ProgressDialog(@NonNull Context context) {
        super(context);
        getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        setContentView(R.layout.dialog_progress);
    }
}
