package com.wiser.onemodule;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.wiser.library.base.WISERActivity;
import com.wiser.library.base.WISERBuilder;

import org.greenrobot.eventbus.EventBus;

@Route(path = "/OneModule", group = "one")
public class OneModuleActivity extends WISERActivity implements View.OnClickListener {

    TextView tvSkip;

    @Override
    protected WISERBuilder build(WISERBuilder wiserBuilder) {
        wiserBuilder.layoutId(R.layout.activity_one_module);
        wiserBuilder.swipeBack(true);
        return wiserBuilder;
    }

    @Override
    protected void initData(Intent intent) {
        tvSkip = findViewById(R.id.tv_skip);
        tvSkip.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.tv_skip) {
            // Intent intent = new Intent();
            // intent.setClassName(this,"com.wiser.twomodule.TwoModuleActivity");
            // startActivity(intent);
            EventBus.getDefault().postSticky("测试EventBus");
            ARouter.getInstance().build("/two/TwoModule").navigation();
        }
    }
}
