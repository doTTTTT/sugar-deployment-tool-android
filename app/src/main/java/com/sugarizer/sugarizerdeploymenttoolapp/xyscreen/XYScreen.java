package com.sugarizer.sugarizerdeploymenttoolapp.xyscreen;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.sugarizer.sugarizerdeploymenttoolapp.R;
import com.sugarizer.sugarizerdeploymenttoolapp.databinding.ActivityXyscreenBinding;

public class XYScreen extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityXyscreenBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_xyscreen);
        XYScreenViewModel viewModel = new XYScreenViewModel();
        binding.setViewModel(viewModel);

        binding.touch.setOnTouchListener(viewModel);
    }
}
