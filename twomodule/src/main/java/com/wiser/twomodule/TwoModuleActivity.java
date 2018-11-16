package com.wiser.twomodule;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.wiser.library.base.WISERActivity;
import com.wiser.library.base.WISERBuilder;

import android.os.Bundle;

@Route(path = "/two/TwoModule")
public class TwoModuleActivity extends WISERActivity {

	@Override protected WISERBuilder build(WISERBuilder wiserBuilder) {
		wiserBuilder.layoutId(R.layout.activity_two_module);
		return wiserBuilder;
	}

	@Override protected void initData(Bundle bundle) {

	}
}
