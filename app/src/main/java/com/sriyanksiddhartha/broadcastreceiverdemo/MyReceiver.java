package com.sriyanksiddhartha.broadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

public class MyReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {

		int a = intent.getIntExtra("a", 0);
		int b = intent.getIntExtra("b", 0);

		int sum = a + b;

		Intent returningIntent = new Intent("my.result.intent");
		returningIntent.putExtra("sum", sum);

		LocalBroadcastManager lbl = LocalBroadcastManager.getInstance(context);
		lbl.sendBroadcast(returningIntent);
	}
}
