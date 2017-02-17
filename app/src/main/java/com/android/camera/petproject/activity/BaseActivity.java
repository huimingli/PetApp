package com.android.camera.petproject.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.android.camera.petproject.PetApp;
import com.android.camera.petproject.R;
import com.android.camera.petproject.utils.ToastUtils;

/**
 * Created by huimingli on 17-2-17.
 */

public abstract class BaseActivity extends AppCompatActivity {

  public abstract void initVariables();

  public abstract void initViews();

  public abstract void getData();

  ProgressDialog loadingDialog;
  @Override
  public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
    super.onCreate(savedInstanceState, persistentState);
    initVariables();
    getData();
    initViews();
    loadingDialog = new ProgressDialog(this);
    loadingDialog.setCanceledOnTouchOutside(false);
    loadingDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
    loadingDialog.setMessage(getResources().getString(R.string.loading));
  }
  public void onBackClick(View view) {
    finish();
  }

  public void showFailedMsg() {
    dismissLoadingDialog();
    ToastUtils.showShort(this, getResources().getString(R.string.request_failed));
  }

  public void showErrorMsg() {
    dismissLoadingDialog();
    ToastUtils.showShort(this, getResources().getString(R.string.request_error));
  }
  public void showLoadingDialog() {
    runOnUiThread(new Runnable() {
      @Override
      public void run() {
        if ((!isFinishing()) && (!loadingDialog.isShowing())) {
          loadingDialog.show();
        }
      }
    });

  }
  public void dismissLoadingDialog() {
    if ((!isFinishing()) && loadingDialog.isShowing()) {
      loadingDialog.dismiss();
    }
  }
  @Override
  public void finish() {
    PetApp.getInstance().removeActivity(this);
    super.finish();
  }


  public void superFinish() {
    super.finish();
  }
}
