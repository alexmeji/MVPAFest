package com.alexmejicanos.mvpandroid.presenter;

import com.alexmejicanos.mvpandroid.rest.ApiClient;
import com.alexmejicanos.mvpandroid.rest.model.User;
import com.alexmejicanos.mvpandroid.view.LoginView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by alexmejicanos on 15/07/17.
 */

public class LoginPresenter implements Presenter<LoginView> {
    private static String TAG = "LoginPresenter";
    private LoginView loginView;

    public LoginPresenter() {}

    public void doLogin(String username, String password) {
        loginView.showLoading();
        Call<User> call = ApiClient.getMyApiClient().doLogin(username, password);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                loginView.hideLoading();
                if (response.isSuccessful()) {
                    loginView.successLogin(response.body());
                } else {
                    loginView.showMessage("Error Login");
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                loginView.hideLoading();
                loginView.showMessage(t.getMessage());
            }
        });
    }

    @Override
    public void addView(LoginView view) {
        this.loginView = view;
    }

    @Override
    public void removeView() {
        this.loginView = null;
    }
}
