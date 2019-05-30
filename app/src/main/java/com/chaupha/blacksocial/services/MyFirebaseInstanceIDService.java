package com.chaupha.blacksocial.services;

import com.google.firebase.iid.FirebaseInstanceId;
import com.chaupha.blacksocial.main.interactors.ProfileInteractor;
import com.chaupha.blacksocial.utils.LogUtil;
import com.google.firebase.messaging.FirebaseMessagingService;

public class MyFirebaseInstanceIDService extends FirebaseMessagingService {

    private static final String TAG = "MyFirebaseIIDService";

    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        LogUtil.logDebug(TAG, "Refreshed token: " + refreshedToken);
        ProfileInteractor.getInstance(getApplicationContext()).updateRegistrationToken(refreshedToken);
    }

}
