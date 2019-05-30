package com.chaupha.blacksocial.managers.listeners;

import com.chaupha.blacksocial.model.Post;

public interface OnPostChangedListener {

    public void onObjectChanged(Post obj);

    public void onError(String errorText);

}
