package com.fahimshahrierrasel.mycartoll.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fahimshahrierrasel.mycartoll.R;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {
    private LoginContract.Presenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginPresenter = new LoginPresenter(this);

        Button loginButton = findViewById(R.id.button_login);
        Button registerButton = findViewById(R.id.button_register);
        TextView emailTextview = findViewById(R.id.edittext_email);
        TextView passwordTextview = findViewById(R.id.edittext_password);

        loginButton.setOnClickListener(view ->
                loginPresenter.onLoginClicked(emailTextview, passwordTextview)
        );

        registerButton.setOnClickListener(view ->
                loginPresenter.onRegisterClicked(this)
        );
    }

    @Override
    protected void onResume() {
        super.onResume();
        loginPresenter.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.destroy();
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        loginPresenter = presenter;
    }
}
