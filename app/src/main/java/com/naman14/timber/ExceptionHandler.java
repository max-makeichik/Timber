package com.naman14.timber;

import com.crashlytics.android.Crashlytics;

import java.lang.Thread.UncaughtExceptionHandler;

/**
 * Created by Max Makeichik on 08.01.18.
 */

public class ExceptionHandler implements UncaughtExceptionHandler {
    public static final String TAG = ExceptionHandler.class.getSimpleName();

    UncaughtExceptionHandler handler;

    public ExceptionHandler() {
        handler = Thread.getDefaultUncaughtExceptionHandler();
    }

    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        Crashlytics.logException(throwable);
        if (handler != null) {
            handler.uncaughtException(thread, throwable);
        }
    }
}
