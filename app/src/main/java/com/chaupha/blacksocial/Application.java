package com.chaupha.blacksocial;

import com.chaupha.blacksocial.main.interactors.PostInteractor;

public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ApplicationHelper.initDatabaseHelper(this);
        PostInteractor.getInstance(this).subscribeToNewPosts();
    }
}
