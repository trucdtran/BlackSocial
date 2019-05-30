package com.chaupha.blacksocial.main.editProfile;

import com.chaupha.blacksocial.main.pickImageBase.PickImageView;

public interface EditProfileView extends PickImageView {
    void setName(String username);

    void setProfilePhoto(String photoUrl);

    String getNameText();

    void setNameError(String string);
}
