package com.wiser.common;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.wiser.library.helper.WISERHelper;
import com.wiser.router.WRouter;

public class CommonApplication extends MultiDexApplication {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        WISERHelper.newBind().Inject(this,BuildConfig.DEBUG);
//        ARouter.openLog();
//        ARouter.openDebug();
//        ARouter.init(this);

        WRouter.init(this);
    }
}
