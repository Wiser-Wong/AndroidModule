package com.wiser.twomodule;

import android.content.Intent;
import android.view.View;

import com.wiser.common.provider.IOneModuleProvider;
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
        IOneModuleProvider oneModuleProvider = (IOneModuleProvider) WRouter.create("onemodule/OneModuleProviderProvider").buildProvider();
        if (oneModuleProvider != null) oneModuleProvider.oneModuleHello("twomodule调用onemodule组件中的方法");
        findViewById(R.id.tv_skip).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WRouter.create("app/MainActivity").open(TwoModuleActivity.this);
            }
        });
    }
}
