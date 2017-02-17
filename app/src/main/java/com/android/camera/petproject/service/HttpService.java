package com.android.camera.petproject.service;

import com.android.camera.petproject.domain.RetrofitEntity;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * @author huimingli
 * @Description:
 * @date 17-2-17
 */
public interface HttpService {
  @POST("AppFiftyToneGraph/videoLink")
  Observable<RetrofitEntity> getAllVedioBy(@Body boolean once_no);
}
