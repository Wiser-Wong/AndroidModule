package com.wiser.onemodule;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.wiser.androidmodule.onemodule.R;
import com.wiser.library.base.WISERActivity;
import com.wiser.library.base.WISERBuilder;

@Route(path = "/com/OneModule")
public class OneModuleActivity extends WISERActivity {

	@Override protected WISERBuilder build(WISERBuilder wiserBuilder) {
		wiserBuilder.layoutId(R.layout.activity_one_module);
		wiserBuilder.swipeBack(true);
		return wiserBuilder;
	}

	@Override protected void initData(Bundle bundle) {

	}
}
