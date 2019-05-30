package com.chaupha.blacksocial.main.search;

import android.app.Activity;

import com.chaupha.blacksocial.main.base.BasePresenter;

class SearchPresenter extends BasePresenter<SearchView> {

    private String currentUserId;
    private Activity activity;

    SearchPresenter(Activity activity) {
        super(activity);
        this.activity = activity;
    }

    public void search(String query) {

    }
}
