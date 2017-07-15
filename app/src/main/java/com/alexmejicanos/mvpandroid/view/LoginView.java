package com.alexmejicanos.mvpandroid.view;

import com.alexmejicanos.mvpandroid.rest.model.User;

/**
 * Created by alexmejicanos on 15/07/17.
 */

public interface LoginView {
    void showLoading();
    void hideLoading();
    void successLogin(User user);
    void showMessage(String message);
}
