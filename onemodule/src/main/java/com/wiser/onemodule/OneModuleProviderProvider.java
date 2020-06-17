package com.wiser.onemodule;

import android.content.Context;

import com.wiser.common.provider.IOneModuleProvider;
import com.wiser.library.helper.WISERHelper;
import com.wiser.router_annotation.Router;

/**
 * @author Wiser
 */
@Router(provider = "onemodule/OneModuleProviderProvider")
public class OneModuleProviderProvider implements IOneModuleProvider {
    @Override
    public void oneModuleHello(String hello) {
        System.out.println("----------oneModule---->>"+hello);
        WISERHelper.toast().show(hello);
    }

    @Override
    public void init(Context context) {

    }
}
