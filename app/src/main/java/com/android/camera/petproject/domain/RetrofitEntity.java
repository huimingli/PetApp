package com.android.camera.petproject.domain;

import java.util.List;

/**
 * @author huimingli
 * @Description:
 * @date 17-2-17
 */
public class RetrofitEntity {
  private int ret;
  private String msg;
  private List<SubjectResulte> data;

  public int getRet() {
    return ret;
  }

  public void setRet(int ret) {
    this.ret = ret;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public List<SubjectResulte> getData() {
    return data;
  }

  public void setData(List<SubjectResulte> data) {
    this.data = data;
  }
}
