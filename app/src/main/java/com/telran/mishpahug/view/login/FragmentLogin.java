package com.telran.mishpahug.view.login;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.telran.mishpahug.R;
import com.telran.mishpahug.presenter.login.IViewtLogin;

public class FragmentLogin extends Fragment implements IViewtLogin {

    private static final IViewtLogin fragment = new FragmentLogin();
    private static IPresenterViewLogin presenter;
    private static AppCompatActivity activity;
    CallbackManager callbackManager;

    public FragmentLogin() {}

    public static IViewtLogin getInstance(IPresenterViewLogin presenter, AppCompatActivity activity){
        FragmentLogin.presenter =  presenter;
        FragmentLogin.activity = activity;
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        LoginButton loginButton = view.findViewById(R.id.login_button);
        loginButton.setFragment(this);
        callbackManager = CallbackManager.Factory.create();
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {

            @Override
            public void onSuccess(LoginResult loginResult) {
                LoginManager.getInstance().logOut();
                presenter.onFbToken(loginResult.getAccessToken().getToken());
            }

            @Override
            public void onCancel() {
            }

            @Override
            public void onError(FacebookException exception) {
                onMessage("Error!",exception.toString());
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
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

}
