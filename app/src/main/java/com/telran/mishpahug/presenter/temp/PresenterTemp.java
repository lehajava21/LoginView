package com.telran.mishpahug.presenter.temp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;

import com.telran.mishpahug.R;
import com.telran.mishpahug.interactor.interfaces.IPresenterInteractorTemp;
import com.telran.mishpahug.model.Message;
import com.telran.mishpahug.view.temp.FragmentTemp;
import com.telran.mishpahug.view.temp.IPresenterViewTemp;

public class PresenterTemp implements IPresenterInteractorTemp,IPresenterViewTemp {

    private static final IPresenterInteractorTemp presenter = new PresenterTemp();
    private static IInteractorPresenterTemp interactor;
    private static AppCompatActivity activity;
    private static IViewTemp fragment;

    public static IPresenterInteractorTemp getInstance(IInteractorPresenterTemp interactor,
                                                        AppCompatActivity activity){
        PresenterTemp.interactor = interactor;
        PresenterTemp.activity = activity;
        fragment = FragmentTemp.getInstance((IPresenterViewTemp) presenter,activity);
        return presenter;
    }

    @Override
    public void show() {
        activity.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, (FragmentTemp) fragment)
                .commit();
    }

    @Override
    public void onMessage(final Message message) {
        fragment.onMessage(message.getTitle(),message.getContent());
        hideProgress();
    }

    private void showProgess(){
        new AsyncTask(){
            @Override
            protected Object doInBackground(Object[] objects) {return null;}
            @Override
            protected void onPostExecute(Object o) {fragment.showProgress();}
        }.execute();
    }

    private void hideProgress(){
        new AsyncTask(){
            @Override
            protected Object doInBackground(Object[] objects) {return null;}
            @Override
            protected void onPostExecute(Object o) {fragment.hideProgress();}
        }.execute();
    }

}
