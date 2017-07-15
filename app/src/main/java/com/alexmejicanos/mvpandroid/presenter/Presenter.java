package com.alexmejicanos.mvpandroid.presenter;

/**
 * Created by alexmejicanos on 15/07/17.
 */

public interface Presenter<T> {
    void addView(T View);
    void removeView();
}
