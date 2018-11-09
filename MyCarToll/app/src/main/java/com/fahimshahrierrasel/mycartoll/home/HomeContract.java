package com.fahimshahrierrasel.mycartoll.home;

import com.fahimshahrierrasel.mycartoll.BasePresenter;
import com.fahimshahrierrasel.mycartoll.BaseView;
import com.fahimshahrierrasel.mycartoll.data.model.Driver;

public interface HomeContract {
    interface Presenter extends BasePresenter {
        void getDriverInfo();
        void getUserInfo();
        void setCurrentBalance();
    }

    interface View extends BaseView<HomeContract.Presenter> {
        void populateDriverInfo(Driver driver);
        void setDriverCurrentBalance(String balance);
        void stopSwipRefreshing();
    }
}
