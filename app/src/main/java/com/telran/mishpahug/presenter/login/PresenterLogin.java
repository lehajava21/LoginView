package com.telran.mishpahug.presenter.login;

import android.support.v7.app.AppCompatActivity;

import com.telran.mishpahug.R;
import com.telran.mishpahug.interactor.interfaces.IPresenterInteractorLoginr;
import com.telran.mishpahug.model.Message;
import com.telran.mishpahug.model.Token;
import com.telran.mishpahug.view.login.FragmentLogin;
import com.telran.mishpahug.view.login.IPresenterViewLogin;

public class PresenterLogin implements IPresenterInteractorLoginr,IPresenterViewLogin {

    private static final IPresenterInteractorLoginr presenter = new PresenterLogin();
    private static IInteractorPresenterLogin interactor;
    private static AppCompatActivity activity;
    private static IViewtLogin fragment;

    private PresenterLogin() {
    }

    public static IPresenterInteractorLoginr getInstance(IInteractorPresenterLogin interactor,
                                                         AppCompatActivity activity){
        PresenterLogin.interactor = interactor;
        PresenterLogin.activity = activity;
        fragment = FragmentLogin.getInstance((IPresenterViewLogin) presenter,activity);
        return presenter;
    }

    @Override
    public void show() {
        activity.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, (FragmentLogin)fragment)
                .commit();
    }

    @Override
    public void onMessage(Message message) {
        fragment.onMessage(message.getTitle(), message.getContent());
    }

    @Override
    public void onFbToken(String token) {
        Token fbToken = new Token(token);
        interactor.onFbToken(fbToken);
    }
}
