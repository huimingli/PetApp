package com.android.camera.petproject.fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.camera.petproject.utils.LogUtils;


/**
 * Class:BaseFragment Description: Fragment 基类 Author:liugz Date:2016/5/12
 */

public abstract class BaseFragment extends Fragment {

    private final String classNameRaw = getClass().getName().toString();
    private final String className = classNameRaw.substring(classNameRaw.lastIndexOf(".") + 1, classNameRaw.length());
    private static final String STATE_SAVE_IS_HIDDEN = "STATE_SAVE_IS_HIDDEN";

    /**
     * 视图是否已经初初始化
     */
    protected boolean isInit = false;
    protected boolean isLoad = false;
    protected final String TAG = "LazyLoadFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        isInit = true;
        LogUtils.d(className + ":onCreateView");
        /**初始化的时候去加载数据**/
        isCanLoadData();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        LogUtils.d(className + ":setUserVisibleHint");
        super.setUserVisibleHint(isVisibleToUser);
        isCanLoadData();
    }

    /**
     * 是否可以加载数据 可以加载数据的条件： 1.视图已经初始化 2.视图对用户可见
     */
    private void isCanLoadData() {
        LogUtils.d(className + ":isCanLoadData called");
        if (!isInit) {
            return;
        }
        if (getUserVisibleHint() && !isLoad) {
            LogUtils.d(className + ":lazyLoad called");
            lazyLoad();
            isLoad = true;
        } else {
            if (isLoad) {
                stopLoad();
            }
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //内存重启时恢复Fragment显示状态
        if (savedInstanceState != null) {
            boolean isSupportHidden = savedInstanceState.getBoolean(STATE_SAVE_IS_HIDDEN);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            if (isSupportHidden) {
                ft.hide(this);
            } else {
                ft.show(this);
            }
            ft.commit();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

//    /**
//     * 检查是否登录
//     */
//    boolean checkIsLogin() {
//        boolean isLogin = Hawk.get(Constants.KEY_IS_LOGIN, false);
//        if (!isLogin) {
//            ToastUtils.showShort(getActivity().getApplicationContext(), getResources().getString(R.string.please_login_first));
//        }
//        return isLogin;
//    }

//    /**
//     * 检查是否登录
//     */
//    boolean checkIsLogin(boolean needHint) {
//        boolean isLogin = Hawk.get(Constants.KEY_IS_LOGIN, false);
//        if (!isLogin && needHint) {
//            ToastUtils.showShort(getActivity().getApplicationContext(), getResources().getString(R.string.please_login_first));
//        }
//        return isLogin;
//    }

//    /**
//     * 跳转到登录界面
//     */
//    void toLogin() {
//        Intent intent = new Intent(getActivity(), WXLoginActivity_.class);
//        startActivity(intent);
//    }



    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(STATE_SAVE_IS_HIDDEN, isHidden());
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        /**
         * 视图销毁的时候讲Fragment是否初始化的状态变为false
         */
        isInit = false;
        isLoad = false;
    }

    /**
     * 当视图初始化并且对用户可见的时候去真正的加载数据
     */
    protected abstract void lazyLoad();

    /**
     * 当视图已经对用户不可见并且加载过数据，如果需要在切换到其他页面时停止加载数据，可以覆写此方法
     */
    protected void stopLoad() {
    }
}
