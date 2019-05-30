package com.chaupha.blacksocial.main.post;

import android.net.Uri;

import com.chaupha.blacksocial.main.pickImageBase.PickImageView;

public interface BaseCreatePostView extends PickImageView {
    void setDescriptionError(String error);

    void setTitleError(String error);

    String getTitleText();

    String getDescriptionText();

    void requestImageViewFocus();

    void onPostSavedSuccess();

    Uri getImageUri();
}

