package com.xiaoqi.virtualapkdemo;

import android.app.Application;
import android.content.Context;

import com.didi.virtualapk.PluginManager;

/**
 * Created by Administrator on 2017/11/10.
 */

public class VitrualAPKApplication extends Application {

	public static int i = 1;

	@Override
	protected void attachBaseContext(Context base) {
		super.attachBaseContext(base);
		PluginManager.getInstance(base).init();
	}
}
