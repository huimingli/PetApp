package com.android.camera.petproject.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import com.android.camera.petproject.R;
import com.android.camera.petproject.domain.RetrofitEntity;
import com.android.camera.petproject.domain.SubjectResulte;
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
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);cd
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
