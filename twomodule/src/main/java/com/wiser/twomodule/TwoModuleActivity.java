package com.wiser.twomodule;

import android.content.Intent;
import android.view.View;

import com.wiser.library.base.WISERActivity;
import com.wiser.library.base.WISERBuilder;
import com.wiser.router.WRouter;
import com.wiser.router_annotation.Router;

@Router(path = "twomodule/TwoModuleActivity")
public class TwoModuleActivity extends WISERActivity {

    @Override
    protected WISERBuilder build(WISERBuilder wiserBuilder) {
        wiserBuilder.layoutId(R.layout.activity_two_module);
        return wiserBuilder;
    }

    @Override
    protected void initData(Intent intent) {
        findViewById(R.id.tv_skip).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WRouter.create("app/MainActivity").open(TwoModuleActivity.this);
            }
        });
    }
}
