package com.android.camera.petproject;

import android.app.Activity;
import android.app.Application;
import com.android.camera.petproject.activity.BaseActivity;
import com.android.camera.petproject.activity.MainActivity;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by huimingli on 17-2-17.
 */

public class PetApp extends Application {
  // activities容器
  private List<Activity> activityList = new LinkedList<>();
  private static PetApp instance;

  @Override
  public void onCreate() {
    super.onCreate();
    instance = this;
  }

  // 添加Activity到容器当中
  public void addActivity(Activity activity) {
    activityList.add(activity);
  }

  // 移除Activity
  public void removeActivity(Activity activity) {
    if (activityList.contains(activity)) {
      activityList.remove(activity);
    }
  }
  public static PetApp getInstance() {
    return instance;
  }
  // 遍历Activity容器并finish掉
  public void clearActivities(boolean finishRoot) {
    for (Activity activity : activityList) {
      if (activity instanceof BaseActivity) {
        if (!finishRoot && activity instanceof MainActivity) {
          continue;
        }
        ((BaseActivity) activity).superFinish();
      } else {
        activity.finish();
      }
    }
    activityList.clear();
  }
}
