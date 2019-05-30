package com.chaupha.blacksocial.adapters.holders;

import android.view.View;

import com.chaupha.blacksocial.main.base.BaseActivity;
import com.chaupha.blacksocial.managers.listeners.OnPostChangedListener;
import com.chaupha.blacksocial.model.FollowingPost;
import com.chaupha.blacksocial.model.Post;
import com.chaupha.blacksocial.utils.LogUtil;

public class FollowPostViewHolder extends PostViewHolder {


    public FollowPostViewHolder(View view, OnClickListener onClickListener, BaseActivity activity) {
        super(view, onClickListener, activity);
    }

    public FollowPostViewHolder(View view, OnClickListener onClickListener, BaseActivity activity, boolean isAuthorNeeded) {
        super(view, onClickListener, activity, isAuthorNeeded);
    }

    public void bindData(FollowingPost followingPost) {
        postManager.getSinglePostValue(followingPost.getPostId(), new OnPostChangedListener() {
            @Override
            public void onObjectChanged(Post obj) {
                bindData(obj);
            }

            @Override
            public void onError(String errorText) {
                LogUtil.logError(TAG, "bindData", new RuntimeException(errorText));
            }
        });
    }

}
