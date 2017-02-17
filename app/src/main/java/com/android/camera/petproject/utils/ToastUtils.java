package com.android.camera.petproject.utils;

import android.content.Context;
import com.android.camera.petproject.view.ToastView;


public class ToastUtils {

    private static ToastView mToastView = ToastView.getInstance();
    private final static int SHORT_TIME = 2;// 显示2秒
    private final static int LONG_TIME = 3;// 显示3秒

    private ToastUtils(){

        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static boolean isShow = true;

    /**
     * 短时间显示Toast
     * 
     * @param context
     * @param message
     */
    public static void showShort(Context context, CharSequence message){

        if (isShow) {
            // Toast toast = Toast.makeText(context, message,
            // Toast.LENGTH_SHORT);
            // toast.setGravity(Gravity.CENTER, 0, 0);
            // toast.show();
            mToastView.showToast(message, SHORT_TIME);
        }
    }

    /**
     * 短时间显示Toast
     * 
     * @param context
     * @param message
     */
    public static void showShort(Context context, int message){

        if (isShow) {
            // Toast toast = Toast.makeText(context, message,
            // Toast.LENGTH_SHORT);
            // toast.setGravity(Gravity.CENTER, 0, 0);
            // toast.show();

            mToastView.showToast(context.getString(message), SHORT_TIME);

        }
    }

    /**
     * 自定义toastView 资源ID根据错误码显示
     * 
     * @param eCode
     *            错误码
     */
    public static void showToastErrorCode(Context context, int eCode){

        String idStr = "error_" + eCode;
        int redId = context.getResources().getIdentifier(idStr, "string", context.getPackageName());
        showShort(context, redId);
    }

    /**
     * 长时间显示Toast
     * 
     * @param context
     * @param message
     */
    public static void showLong(Context context, CharSequence message){

        if (isShow) {
            // Toast toast = Toast.makeText(context, message,
            // Toast.LENGTH_LONG);
            // toast.setGravity(Gravity.CENTER, 0, 0);
            // toast.show();
            mToastView = ToastView.getInstance();
            mToastView.showToast(message, LONG_TIME);
        }
    }

    /**
     * 长时间显示Toast
     * 
     * @param context
     * @param message
     */
    public static void showLong(Context context, int message){

        if (isShow) {
            // Toast toast = Toast.makeText(context, message,
            // Toast.LENGTH_LONG);
            // toast.setGravity(Gravity.CENTER, 0, 0);
            // toast.show();
            mToastView = ToastView.getInstance();
            mToastView.showToast(context.getString(message), LONG_TIME);
        }
    }

    /**
     * 自定义显示Toast时间
     * 
     * @param context
     * @param message
     * @param duration
     */
    public static void show(Context context, CharSequence message, int duration){

        if (isShow) {
            // Toast toast = Toast.makeText(context, message, duration);
            // toast.setGravity(Gravity.CENTER, 0, 0);
            // toast.show();
            mToastView = ToastView.getInstance();
            mToastView.showToast(message, duration);
        }
    }

    /**
     * 自定义显示Toast时间
     * 
     * @param context
     * @param message
     * @param duration
     */
    public static void show(Context context, int message, int duration){

        if (isShow) {
            // Toast toast = Toast.makeText(context, message, duration);
            // toast.setGravity(Gravity.CENTER, 0, 0);
            // toast.show();
            mToastView = ToastView.getInstance();
            mToastView.showToast(context.getString(message), duration);
        }
    }
}
