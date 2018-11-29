package com.mikk.common_base.base;

import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;

/**
 * @author mikk
 */
public abstract class BaseHandler<T> extends Handler {
    private WeakReference<T> mReference;

    public BaseHandler(T reference) {
        mReference = new WeakReference<T>(reference);
    }

    @Override
    public void handleMessage(Message msg) {
        if (mReference.get() == null) {
            return;
        }
        handleMessage(mReference.get(), msg);
    }

    protected abstract void handleMessage(T reference, Message msg);


}
