package com.telran.mishpahug.repository.storage;

import android.support.v7.app.AppCompatActivity;

import com.telran.mishpahug.model.StorageType;
import com.telran.mishpahug.interactor.interfaces.IRepositoryStorage;

public class RepositoryStorage implements IRepositoryStorage{

    private static final IRepositoryStorage storage = new RepositoryStorage();
    private static IInteractorStorage interactor;
    private static AppCompatActivity activity;

    private RepositoryStorage(){}

    public static IRepositoryStorage getInstance(IInteractorStorage interactor,
                                                 AppCompatActivity activity){
        RepositoryStorage.interactor = interactor;
        RepositoryStorage.activity = activity;
        return storage;
    }

    @Override
    public void save(StorageType type, Object object) {

    }

    @Override
    public Object losd(StorageType type) {
        return null;
    }
}
