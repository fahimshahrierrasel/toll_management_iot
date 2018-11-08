package com.fahimshahrierrasel.mycartoll.login;

import android.content.Context;
import android.widget.TextView;

import com.fahimshahrierrasel.mycartoll.BasePresenter;
import com.fahimshahrierrasel.mycartoll.BaseView;

public interface LoginContract {
    interface Presenter extends BasePresenter {
        void onLoginClicked(TextView email, TextView password);
        void onRegisterClicked(Context context);
    }

    interface View extends BaseView<Presenter> {

    }
}
