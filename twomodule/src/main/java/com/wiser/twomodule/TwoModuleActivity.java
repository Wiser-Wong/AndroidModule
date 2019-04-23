package com.wiser.twomodule;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.wiser.library.base.WISERActivity;
import com.wiser.library.base.WISERBuilder;
import com.wiser.library.helper.WISERHelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

@Route(path = "/two/TwoModule")
public class TwoModuleActivity extends WISERActivity {

    @Override
    protected WISERBuilder build(WISERBuilder wiserBuilder) {
        wiserBuilder.layoutId(R.layout.activity_two_module);
        return wiserBuilder;
    }

    @Override
    protected void initData(Intent intent) {
        if (!EventBus.getDefault().isRegistered(this))
            EventBus.getDefault().register(this);
    }

    // 测试EventBus
    @Subscribe(sticky = true)
    public void testEventBus(String s) {
        WISERHelper.toast().show(s);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (EventBus.getDefault().isRegistered(this))
            EventBus.getDefault().unregister(this);
    }
}
