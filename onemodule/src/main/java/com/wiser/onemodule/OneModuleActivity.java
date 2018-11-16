package com.wiser.onemodule;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.wiser.library.base.WISERActivity;
import com.wiser.library.base.WISERBuilder;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

@Route(path = "/one/OneModule")
public class OneModuleActivity extends WISERActivity implements View.OnClickListener{

	TextView tvSkip;

	@Override protected WISERBuilder build(WISERBuilder wiserBuilder) {
		wiserBuilder.layoutId(R.layout.activity_one_module);
		wiserBuilder.swipeBack(true);
		return wiserBuilder;
	}

	@Override protected void initData(Bundle bundle) {
		tvSkip = findViewById(R.id.tv_skip);
		tvSkip.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		int i = v.getId();
		if (i == R.id.tv_skip) {
//			Intent intent = new Intent();
//			intent.setClassName(this,"com.wiser.twomodule.TwoModuleActivity");
//			startActivity(intent);
			ARouter.getInstance().build("/two/TwoModule").navigation();
		}
	}
}
