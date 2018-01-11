package com.telran.mishpahug.repository.server;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;

import com.telran.mishpahug.interactor.interfaces.IRepositoryServer;
import com.telran.mishpahug.model.Message;
import com.telran.mishpahug.model.RequestType;

public class RepositoryServer implements IRepositoryServer{

    private static final RepositoryServer server = new RepositoryServer();
    private static IInteractorServer interactor;
    private static AppCompatActivity activity;

    private RepositoryServer(){}

    public static IRepositoryServer getInstance(IInteractorServer interactor,
                                                AppCompatActivity activity){
        RepositoryServer.interactor = interactor;
        RepositoryServer.activity = activity;
        return server;
    }

    @Override
    public void request(RequestType type, Object object) {
//      TEST
        new AsyncTask(){
            @Override
            protected Object doInBackground(Object[] objects) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {}
                return null;
            }
            @Override
            protected void onPostExecute(Object o) {
                interactor.onProfileMessage(new Message("Error!","123456789"));
            }
        }.execute();
//
    }
}
