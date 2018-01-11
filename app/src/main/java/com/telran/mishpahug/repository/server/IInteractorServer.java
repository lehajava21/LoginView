package com.telran.mishpahug.repository.server;

import com.facebook.AccessToken;
import com.telran.mishpahug.model.Message;
import com.telran.mishpahug.model.Profile;

public interface IInteractorServer {
    void onProfile(Profile profile);
    void onProfileMessage(Message message);
}
