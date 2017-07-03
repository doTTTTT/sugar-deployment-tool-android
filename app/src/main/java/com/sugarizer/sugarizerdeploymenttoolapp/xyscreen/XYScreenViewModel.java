package com.sugarizer.sugarizerdeploymenttoolapp.xyscreen;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.view.MotionEvent;
import android.view.View;

public class XYScreenViewModel extends BaseObservable implements View.OnTouchListener {
    private ObservableField<Float> x;
    private ObservableField<Float> y;

    public XYScreenViewModel(){
        x = new ObservableField<>(0f);
        y = new ObservableField<>(0f);
    }

    public String getX() {
        return x.get().toString();
    }

    public String getY() {
        return y.get().toString();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        x.set(event.getX());
        y.set(event.getY());

        x.notifyChange();
        y.notifyChange();
        notifyChange();

        return true;
    }
}
