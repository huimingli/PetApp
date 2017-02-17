package com.android.camera.petproject.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.IBinder;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.camera.petproject.PetApp;
import java.io.InputStream;

/**
 * @author 黄木华
 */
public class UIUtils {

    /**
     * 得到上下文
     */
    public static Context getContext() {

        return PetApp.getInstance().getApplicationContext();
    }

    /**
     * 得到Resouce对象
     */
    public static Resources getResource() {

        return getContext().getResources();
    }

    /**
     * 得到String.xml中的字符串
     */
    public static String getString(int resId) {

        return getResource().getString(resId);
    }

    public static float getDimesion(int resId) {

        return getResource().getDimension(resId);
    }

    // public static int getResId(String idStr, String type){
    //
    // return getResource().getIdentifier(idStr, type, getPackageName());
    // }

    /**
     * 得到String.xml中的字符串数组
     */
    public static String[] getStringArr(int resId) {

        return getResource().getStringArray(resId);
    }

    public static int[] getIntArr(int resId) {

        return getResource().getIntArray(resId);
    }

    /**
     * 得到colors.xml中的颜色
     */
    public static int getColor(int colorId) {

        return getResource().getColor(colorId);
    }

    /**
     * 得到应用程序的包名
     */
    public static String getPackageName() {

        return getContext().getPackageName();
    }

    public static void setTextSafely(Activity activity, int id, int resId) {

        if (activity != null) {
            setTextSafely((TextView) activity.findViewById(id), resId);
        }
    }

    public static void setTextSafely(View parent, int id, String text) {

        if (parent != null) {
            setTextSafely((TextView) parent.findViewById(id), text);
        }
    }

    private static void setTextSafely(TextView textView, String text) {

        if (textView != null) {
            if (text == null) {
                text = "--";
            }
            textView.setText(text);
        }
    }

    /**
     * @author 00012927 获取text
     */
    public static String getTextSafely(TextView textView) {

        if (textView != null) {
            return textView.getText().toString().trim();
        }
        return "";
    }

    public static String getTextSafely(Activity activity, int id) {

        if (activity != null) {
            return getTextSafely((TextView) activity.findViewById(id));
        }
        return "";
    }

    /**
     * @author 00012927 获取text
     */
    public static String getTextSafely(View parent, int id) {

        if (parent != null) {
            return getTextSafely((TextView) parent.findViewById(id));
        }
        return "";
    }

    public static void setTextSafely(Activity activity, int id, String text) {

        if (activity != null) {
            setTextSafely((TextView) activity.findViewById(id), text);
        }
    }

    /**
     * @author 00012927 设置Text
     */
    public static void setTextSafely(TextView textView, int resId) {

        if (textView != null) {
            textView.setText(resId);
        }
    }

    /**
     * @author 00012927 设置Text
     */
    public static void setTextSafely(View parent, int id, int resId) {

        if (parent != null) {
            setTextSafely((TextView) parent.findViewById(id), resId);
        }
    }

    /**
     * @author 00012927 设置Image
     */
    public static void setImageSafely(ImageView imageView, int resId) {

        if (imageView != null) {
            imageView.setImageResource(resId);
        }
    }

    public static void setImageSafely(Activity activity, int id, int resId) {

        if (activity != null) {
            setImageSafely((ImageView) activity.findViewById(id), resId);
        }
    }

    /**
     * @author 00012927 设置Image
     */
    public static void setImageSafely(View parent, int id, int resId) {

        if (parent != null) {
            setImageSafely((ImageView) parent.findViewById(id), resId);
        }
    }

    /**
     * 设置view的显示状态
     */
    public static void setVisibilitySafe(View view, int visibility) {

        if (view != null && view.getVisibility() != visibility) {
            view.setVisibility(visibility);
        }
    }

    public static void setVisibilitySafe(Activity activity, int id, int visibility) {

        if (activity != null) {
            setVisibilitySafe(activity.findViewById(id), visibility);
        }
    }

    /**
     * 设置view的显示状态
     */
    public static void setVisibilitySafe(View parent, int id, int visibility) {

        if (parent != null) {
            setVisibilitySafe(parent.findViewById(id), visibility);
        }
    }

    public static void setPressedSafe(View view, boolean pressed) {

        if (view != null && view.isPressed() != pressed) {
            view.setPressed(pressed);
        }
    }

    public static void setEnabledSafe(View parent, int id, boolean enabled) {

        if (parent != null) {
            View view = parent.findViewById(id);
            if (view != null) {
                view.setEnabled(enabled);
            }
        }
    }

    public static void setOnClickListenerSafely(View parent, int id, OnClickListener l) {

        if (parent != null) {
            View view = parent.findViewById(id);
            if (view != null) {
                view.setOnClickListener(l);
            }
        }
    }

    public static void setOnClickListenerSafely(Activity activity, int id, OnClickListener l) {

        if (activity != null) {
            View view = activity.findViewById(id);
            if (view != null) {
                view.setOnClickListener(l);
            }
        }
    }

    public static void requestFocus(View view) {

        if (view != null) {
            view.setFocusable(true);
            view.setFocusableInTouchMode(true);
            view.requestFocus();
        }
    }

    public static boolean isEditTextEmpty(EditText edit) {

        return edit.getText() == null || edit.getText().toString().trim().length() <= 0;
    }

    public static boolean hideInputMethod(Activity activity) {

        return hideInputMethod(activity, activity.getWindow().getDecorView().getWindowToken());
    }

    public static boolean hideInputMethod(Dialog dialog) {

        return hideInputMethod(dialog.getContext(), dialog.getWindow().getDecorView().getWindowToken());
    }

    public static boolean hideInputMethod(Context context, IBinder iBinder) {

        InputMethodManager im = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        return im.hideSoftInputFromWindow(iBinder, 0);
    }

    public static void checkBackgroudThread() {

        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IllegalStateException("It must run in backgroud thread.");
        }
    }

    public static void cancelAsyncTask(AsyncTask<?, ?, ?> task) {

        if (task != null) {
            task.cancel(true);
        }
    }

    public static void clearBitmapInImageView(ImageView v) {

        if (v != null) {
            clearBitmapInDrawable(v.getDrawable());
        }
    }

    public static void clearBackgroundBitmapInView(View v) {

        if (v != null) {
            clearBitmapInDrawable(v.getBackground());
        }
    }

    public static void clearBitmapInDrawable(Drawable d) {

        if (d != null && d instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) d).getBitmap();
            if (bitmap != null) {
                bitmap.recycle();
            }
        }
    }

    public static Bitmap decodeResourceBitmap(Context context, int resId) {

        InputStream is = context.getResources().openRawResource(resId);
        return BitmapFactory.decodeStream(is);
    }

    public static void setViewsVisible(View... views) {
        setViewsVisibility(View.VISIBLE, views);
    }

    public static void setViewsInvisible(View... views) {
        setViewsVisibility(View.INVISIBLE, views);
    }

    public static void setViewsGone(View... views) {
        setViewsVisibility(View.GONE, views);
    }

    private static void setViewsVisibility(int visibility, View... views) {
        for (View view : views) {
            if (null != view && view.getVisibility() != visibility) {
                view.setVisibility(visibility);
            }
        }
    }


}
