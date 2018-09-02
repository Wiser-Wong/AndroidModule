package com.wiser.androidmodule;

import com.alibaba.android.arouter.launcher.ARouter;
import com.wiser.library.base.WISERActivity;
import com.wiser.library.base.WISERBuilder;

import android.os.Bundle;
import android.view.View;

import butterknife.OnClick;

public class MainActivity extends WISERActivity {

	@Override protected WISERBuilder build(WISERBuilder wiserBuilder) {
		wiserBuilder.layoutId(R.layout.activity_main);
		return wiserBuilder;
	}

	@Override protected void initData(Bundle bundle) {

	}

	@OnClick(value = { R.id.btn_one_module, R.id.btn_two_module }) public void onClickView(View view) {
		switch (view.getId()) {
			case R.id.btn_one_module:
				ARouter.getInstance().build("/com/OneModule").navigation();
				break;
			case R.id.btn_two_module:
				break;
		}
	}

}
