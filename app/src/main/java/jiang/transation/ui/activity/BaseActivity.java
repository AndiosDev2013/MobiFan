package jiang.transation.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import jiang.transation.R;

public abstract class BaseActivity extends FragmentActivity {

	// UI
//	public MyProgressDialog dlg_progress;
	// Data
	public boolean isErrorOccured = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

//		dlg_progress = new MyProgressDialog(this);
	}

	@Override
	public void startActivity(Intent intent) {
		super.startActivity(intent);
		overridePendingTransition(R.anim.in_left, R.anim.out_left);
	}

	@Override
	public void startActivityForResult(Intent intent, int requestCode) {
		super.startActivityForResult(intent, requestCode);
		overridePendingTransition(R.anim.in_left, R.anim.out_left);
	}

	@Override
	protected void onResume() {
		super.onResume();

//		if (!DeviceUtil.isNetworkAvailable(this)) {
//			isErrorOccured = true;
//			ErrorNetworkActivity.OpenMe();
//		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
//		if (dlg_progress != null)
//			dlg_progress.dismiss();
	}

	@Override
	public void onBackPressed() {
		finish();
		overridePendingTransition(R.anim.in_right, R.anim.out_right);
	}
}

