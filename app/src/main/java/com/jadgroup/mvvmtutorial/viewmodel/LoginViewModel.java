package com.jadgroup.mvvmtutorial.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.jadgroup.mvvmtutorial.model.User;

public class LoginViewModel extends ViewModel {

    private MutableLiveData<User> userObject;

    public LoginViewModel() {
        userObject = new MutableLiveData<>();
    }

    public LiveData<User> getUserObject() {
        return userObject;
    }

    public void doAction() {
        User user = new User();
        user.setEmail("atif.mukhtar1992@gmail.com");
        user.setPassword("1234");
        userObject.setValue(user);
    }

}
