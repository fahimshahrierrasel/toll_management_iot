package com.fahimshahrierrasel.mycartoll.login;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

public class LoginPresenter implements LoginContract.Presenter {
    private LoginContract.View loginView;

    LoginPresenter(LoginContract.View loginView) {
        this.loginView = loginView;
        this.loginView.setPresenter(this);
    }

    @Override
    public void onLoginClicked(TextView email, TextView password) {

    }

    @Override
    public void onRegisterClicked(Context context) {
        Toast.makeText(context, "No Registration Option Now", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void start() {
    }

    @Override
    public void destroy() {
        loginView = null;
    }
}
