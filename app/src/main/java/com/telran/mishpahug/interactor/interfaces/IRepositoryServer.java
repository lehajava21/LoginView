package com.telran.mishpahug.interactor.interfaces;

import com.telran.mishpahug.model.RequestType;

public interface IRepositoryServer {
    void request(RequestType type,Object object);
}
