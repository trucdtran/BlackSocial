package com.chaupha.blacksocial.main.pickImageBase;

import android.net.Uri;

import com.chaupha.blacksocial.main.base.BaseView;

public interface PickImageView extends BaseView {
    void hideLocalProgress();

    void loadImageToImageView(Uri imageUri);
}
