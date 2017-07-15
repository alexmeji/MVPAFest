package com.alexmejicanos.mvpandroid.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.alexmejicanos.mvpandroid.R;
import com.alexmejicanos.mvpandroid.presenter.LoginPresenter;
import com.alexmejicanos.mvpandroid.rest.model.User;
import com.alexmejicanos.mvpandroid.view.LoginView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginView{

    private static final String TAG = "LoginActivity";
    @BindView(R.id.txtUsername) EditText txtUsername;
    @BindView(R.id.txtPassword) EditText txtPassword;
    @BindView(R.id.btnLogin) Button btnLogin;
    @BindView(R.id.vLoading) View vLoading;


    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        loginPresenter = new LoginPresenter();
        loginPresenter.addView(this);
    }

    //ACTIONS
    @OnClick(R.id.btnLogin)
    public void doLogin(Button sender) {
        Log.e(TAG, "CLICK BUTTON LOGIN");
        loginPresenter.doLogin(txtUsername.getText().toString(), txtPassword.getText().toString());
    }

    //PRESENTER

    @Override
    public void showLoading() {
        vLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        vLoading.setVisibility(View.GONE);
    }

    @Override
    public void successLogin(User user) {
        startActivity(new Intent(this, HomeActivity.class));
    }

    @Override
    public void showMessage(String message) {
        Log.e(TAG, "ERROR");
    }
}
