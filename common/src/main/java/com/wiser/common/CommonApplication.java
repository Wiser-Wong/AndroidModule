package com.wiser.common;

import com.alibaba.android.arouter.launcher.ARouter;
import com.wiser.library.helper.WISERHelper;

import android.app.Application;

public class CommonApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        WISERHelper.newBind().Inject(this,BuildConfig.DEBUG);
        ARouter.openLog();
        ARouter.openDebug();
        ARouter.init(this);
    }
}
