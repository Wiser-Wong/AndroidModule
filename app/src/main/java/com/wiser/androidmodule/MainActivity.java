package com.wiser.androidmodule;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.wiser.library.base.WISERActivity;
import com.wiser.library.base.WISERBuilder;
import com.wiser.router.WRouter;
import com.wiser.router_annotation.Router;

import butterknife.OnClick;

@Router(path = "app/MainActivity")
public class MainActivity extends WISERActivity {

    @Override
    protected WISERBuilder build(WISERBuilder wiserBuilder) {
        wiserBuilder.layoutId(R.layout.activity_main);
        return wiserBuilder;
    }

    @Override
    protected void initData(Intent intent) {

    }

    @OnClick(value = {R.id.btn_one_module, R.id.btn_two_module})
    public void onClickView(View view) {
        switch (view.getId()) {
            case R.id.btn_one_module:
                WRouter.create("onemodule/OneModuleActivity").open(this,100);
                break;
            case R.id.btn_two_module:
                WRouter.create("twomodule/TwoModuleActivity").open(this);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100){
            Toast.makeText(this,data != null ? data.getStringExtra("key") : "回传数据",Toast.LENGTH_SHORT).show();
        }
    }
}
