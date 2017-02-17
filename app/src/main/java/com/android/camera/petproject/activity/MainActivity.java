package com.android.camera.petproject.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.android.camera.petproject.R;
import com.android.camera.petproject.domain.RetrofitEntity;
import com.android.camera.petproject.service.HttpService;
import com.android.camera.petproject.utils.ToastUtils;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends BaseActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    //手动创建一个OkHttpClient并设置超时时间
    okhttp3.OkHttpClient.Builder builder = new OkHttpClient.Builder();
    builder.connectTimeout(5, TimeUnit.SECONDS);

    Retrofit retrofit = new Retrofit.Builder()
        .client(builder.build())
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .baseUrl("")
        .build();
    Observable<RetrofitEntity> observable = retrofit.create(HttpService.class)
        .getAllVedioBy(true);
    observable.subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io()).observeOn(
        AndroidSchedulers.mainThread())
        .subscribe(
            new Subscriber<RetrofitEntity>() {
              @Override
              public void onCompleted() {
                dismissLoadingDialog();
              }

              @Override
              public void onError(Throwable e) {
                dismissLoadingDialog();
              }

              @Override
              public void onNext(RetrofitEntity retrofitEntity) {
//                tvMsg.setText("无封装：\n" + retrofitEntity.getData().toString());
              }

              @Override
              public void onStart() {
                super.onStart();
                showLoadingDialog();
              }
            }

        );
    findViewById(R.id.hello).setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        ToastUtils.show(MainActivity.this, "ddssd", Toast.LENGTH_SHORT);
      }
    });
  }

  @Override
  public void initVariables() {

  }

  @Override
  public void initViews() {

  }

  @Override
  public void getData() {

  }

}
