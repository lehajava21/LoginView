package com.telran.mishpahug.view.temp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.telran.mishpahug.R;
import com.telran.mishpahug.presenter.temp.IViewTemp;

public class FragmentTemp extends Fragment implements IViewTemp {

    private static final IViewTemp fragment = (IViewTemp) new FragmentTemp();
    private static IPresenterViewTemp presenter;
    private static AppCompatActivity activity;
    private ProgressBar progressBar;

    public FragmentTemp() {}

    public static IViewTemp getInstance(IPresenterViewTemp presenter, AppCompatActivity activity){
        FragmentTemp.presenter = presenter;
        FragmentTemp.activity = activity;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_temp, container, false);
        progressBar = view.findViewById(R.id.progress);
        return view;
    }

    @Override
    public void onMessage(String title, String content) {
        new AlertDialog.Builder(activity)
                .setTitle(title)
                .setMessage(content)
                .setPositiveButton("Ok",null)
                .create()
                .show();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }
}
