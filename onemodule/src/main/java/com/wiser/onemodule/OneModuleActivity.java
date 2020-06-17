package com.wiser.onemodule;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.wiser.library.base.WISERActivity;
import com.wiser.library.base.WISERBuilder;
import com.wiser.router_annotation.Router;

@Router(path = "onemodule/OneModuleActivity")
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
//            WRouter.create("app/MainActivity").open(this);
            Intent intent = new Intent();
            intent.putExtra("key","我回来了");
            setResult(RESULT_OK,intent);
            finish();
        }
    }
}
