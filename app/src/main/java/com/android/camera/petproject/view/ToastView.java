package com.android.camera.petproject.view;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.android.camera.petproject.R;
import com.android.camera.petproject.utils.UIUtils;


/**
 * 自定义吐司
 */
public class ToastView {

    private Toast mToast;
    private TextView tvView;
    private View mView;
    
    private static ToastView mInstance;

    public static synchronized ToastView getInstance(){

        if (null == mInstance) {
            mInstance = new ToastView(UIUtils.getContext());
        }
        return mInstance;
    }

    public ToastView(Context context){

        init(context);
    }

    private void init(Context context){

        mView = LayoutInflater.from(context).inflate(R.layout.view_toast, null);
        tvView = (TextView) mView.findViewById(R.id.tv_toast);
        mToast = new Toast(context);
        mToast.setView(mView);
    }

    public void showToast(CharSequence text, int showtime){

        if (text.length() != 0) {
            tvView.setText(text);//设置显示的内容
            mToast.setDuration(showtime);//设置展示的时间
            mToast.setGravity(Gravity.CENTER, 0, 0);// 距离底部0dp
            mToast.show();
        }
    }

}
