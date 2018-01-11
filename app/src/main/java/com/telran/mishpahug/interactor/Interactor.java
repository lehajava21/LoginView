package com.telran.mishpahug.interactor;

import android.support.v7.app.AppCompatActivity;

import com.telran.mishpahug.interactor.interfaces.IPresenterInteractorLoginr;
import com.telran.mishpahug.interactor.interfaces.IPresenterInteractorTemp;
import com.telran.mishpahug.interactor.interfaces.IRepositoryServer;
import com.telran.mishpahug.interactor.interfaces.IRepositoryStorage;
import com.telran.mishpahug.model.Message;
import com.telran.mishpahug.model.Profile;
import com.telran.mishpahug.model.RequestType;
import com.telran.mishpahug.model.StorageType;
import com.telran.mishpahug.model.Token;
import com.telran.mishpahug.presenter.login.IInteractorPresenterLogin;
import com.telran.mishpahug.presenter.login.PresenterLogin;
import com.telran.mishpahug.presenter.temp.IInteractorPresenterTemp;
import com.telran.mishpahug.presenter.temp.PresenterTemp;
import com.telran.mishpahug.repository.server.IInteractorServer;
import com.telran.mishpahug.repository.server.RepositoryServer;
import com.telran.mishpahug.repository.storage.IInteractorStorage;
import com.telran.mishpahug.repository.storage.RepositoryStorage;

public class Interactor implements IInteractorPresenterLogin, IInteractorServer,
        IInteractorStorage,IInteractorPresenterTemp {

    private static final Interactor interactor = new Interactor();
    private static AppCompatActivity activity;
    private static IRepositoryServer repositoryServer;
    private static IRepositoryStorage repositoryStorage;
    private static IPresenterInteractorLoginr presenterLogin;
    private static IPresenterInteractorTemp presenterTemp;

    private Interactor() {
    }

    public static void instance(AppCompatActivity activity){
        Interactor.activity = activity;
        Interactor.presenterLogin = PresenterLogin.getInstance(interactor,activity);
        Interactor.presenterTemp = PresenterTemp.getInstance(interactor,activity);
        Interactor.repositoryServer = RepositoryServer.getInstance(interactor,activity);
        Interactor.repositoryStorage = RepositoryStorage.getInstance(interactor,activity);
        presenterLogin.show();
    }

    @Override
    public void onFbToken(Token token) {
        repositoryStorage.save(StorageType.FB_TOKEN,token);
        repositoryServer.request(RequestType.PROFILE,token);
    }

    @Override
    public void onProfile(Profile profile) {

    }

    @Override
    public void onProfileMessage(Message message) {
//      TEST
        presenterTemp.onMessage(message);
//
    }
}
