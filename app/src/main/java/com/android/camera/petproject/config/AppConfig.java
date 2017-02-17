package com.android.camera.petproject.config;


import com.android.camera.petproject.utils.LogUtils;

/**
 * Class:AppConfig
 * Description:App配置
 * Author:liugz
 * Date:2016/5/11
 */

public class AppConfig {
    public static final String APP_TAG = "PetApp";
     public static final String APP_TAG_PUSH = APP_TAG + "_Push";
    public static final int LOG_DEBUG_LEVEL = LogUtils.LEVEL_ALL;//上线改成false
    public static final long COUNT_DOWN_TIME = 60 * 1000L; //发送验证码倒计时长
    public static final long TIME_INTERVAL = 1000L;// 倒计时间隔
    public static final long SCAN_DELAY = 1500;//扫描时延
    public static final long LANDING_DELAY = 1000L;//启动页延迟
    public static final int IMG_SIZE_LIMIT = 2048;// kb
    public static final int MERCHANDISE_PAGE_SIZE = 10;//页码默认大小
    public static final int EXPRESS_PAGE_SIZE = 10;//页码默认大小
    public static final int LIKE_INFO_PAGE_SIZE = 10;//喜欢商品列表默认大小
    public static final int POINT_PAGE_SIZE = 10;//积分列表默认大小
    public static final int MESSAGE_PAGE_SIZE = 10;//消息中心列表默认分页
    public static final int COMMENT_PAGE_SIZE = 10;//消息中心列表默认分页
    public static final int MAX_ACTION_COUNT = 20;//行为缓存最大数量
    public static final long CONNECT_TIME_OUT = 15L;
    public static final long WRITE_TIME_OUT = 15L;
    public static final long READ_TIME_OUT = 20L;

}