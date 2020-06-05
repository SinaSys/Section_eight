package com.sriyanksiddhartha.broadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

/**
 * 		Author: Sriyank Siddhartha
 *
 * 		Module 6: Working with Local BroadcastReceiver
 *
 * 			"AFTER" project
 * */
public class MainActivity extends AppCompatActivity {

	private static final String TAG = MainActivity.class.getSimpleName();

	private LocalBroadcastManager mLocalBRManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mLocalBRManager = LocalBroadcastManager.getInstance(this);
	}

	public void sendNormalBroadcast(View view) {

		Intent intent = new Intent(this, MyReceiver.class);

		intent.putExtra("a", 10);
		intent.putExtra("b", 20);

		sendBroadcast(intent);
	}

	@Override
	protected void onResume() {
		super.onResume();

		IntentFilter intentFilter = new IntentFilter("my.result.intent");
		mLocalBRManager.registerReceiver(resultReceiver, intentFilter);
	}

	@Override
	protected void onPause() {
		super.onPause();

		mLocalBRManager.unregisterReceiver(resultReceiver);
	}

	private BroadcastReceiver resultReceiver = new BroadcastReceiver() {

		@Override
		public void onReceive(Context context, Intent intent) {

			int sum = intent.getIntExtra("sum", 0);
			Toast.makeText(context, "Sum is " + sum, Toast.LENGTH_LONG).show();
		}
	};
}
