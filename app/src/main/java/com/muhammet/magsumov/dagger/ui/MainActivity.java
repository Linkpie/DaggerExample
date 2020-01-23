package com.muhammet.magsumov.dagger.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dagger.R;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
