package com.chaupha.blacksocial.managers.listeners;

import com.chaupha.blacksocial.model.PostListResult;

public interface OnPostListChangedListener<Post> {

    public void onListChanged(PostListResult result);

    void onCanceled(String message);

}
