package com.telran.mishpahug.interactor.interfaces;

import com.telran.mishpahug.model.StorageType;

public interface IRepositoryStorage {
    void save(StorageType type, Object object);
    Object losd(StorageType type);
}
