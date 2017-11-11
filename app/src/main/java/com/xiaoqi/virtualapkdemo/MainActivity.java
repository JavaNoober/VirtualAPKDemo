package com.xiaoqi.virtualapkdemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.didi.virtualapk.PluginManager;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

	/**
	 * 跳转到插件
	 */
	private Button btnInto;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		PluginManager pluginManager = PluginManager.getInstance(this);
		File apk = new File(Environment.getExternalStorageDirectory(), "plugin.apk");
		if (apk.exists()) {
			try {
				pluginManager.loadPlugin(apk);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}


	}

	private void initView() {
		btnInto = (Button) findViewById(R.id.btn_into);
		btnInto.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.btn_into:
				VitrualAPKApplication.i = 222;
				String packageName = "com.xiaoqi.vitrualapkplugin";
				if (PluginManager.getInstance(this).getLoadedPlugin(packageName) == null) {
					Toast.makeText(this, "plugin [com.xiaoqi.vitrualapkplugin] not loaded", Toast.LENGTH_SHORT).show();
					return;
				}else {
					Intent intent = new Intent();
					intent.setClassName("com.xiaoqi.vitrualapkplugin", "com.xiaoqi.vitrualapkplugin.MainActivity");
					startActivity(intent);
				}
				break;
		}
	}
}
