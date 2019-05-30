package com.chaupha.blacksocial.adapters.holders;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.request.RequestOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.chaupha.blacksocial.R;
import com.chaupha.blacksocial.enums.FollowState;
import com.chaupha.blacksocial.managers.FollowManager;
import com.chaupha.blacksocial.managers.ProfileManager;
import com.chaupha.blacksocial.managers.listeners.OnObjectChangedListener;
import com.chaupha.blacksocial.managers.listeners.OnObjectChangedListenerSimple;
import com.chaupha.blacksocial.model.Profile;
import com.chaupha.blacksocial.utils.ImageUtil;
import com.chaupha.blacksocial.views.FollowButton;

public class UserViewHolder extends RecyclerView.ViewHolder {
    public static final String TAG = UserViewHolder.class.getSimpleName();

    private Context context;
    private ImageView photoImageView;
    private TextView nameTextView;
    private FollowButton followButton;

    private ProfileManager profileManager;

    private Activity activity;

    public UserViewHolder(View view, final Callback callback, Activity activity) {
        super(view);
        this.context = view.getContext();
        this.activity = activity;
        profileManager = ProfileManager.getInstance(context);

        nameTextView = view.findViewById(R.id.nameTextView);
        photoImageView = view.findViewById(R.id.photoImageView);
        followButton = view.findViewById(R.id.followButton);

        view.setOnClickListener(v -> {
            int position = getAdapterPosition();
            if (callback != null && position != RecyclerView.NO_POSITION) {
                callback.onItemClick(getAdapterPosition(), v);
            }
        });

        followButton.setOnClickListener(v -> {
            if (callback != null) {
                callback.onFollowButtonClick(getAdapterPosition(), followButton);
            }
        });
    }

    public void bindData(String profileId) {
        profileManager.getProfileSingleValue(profileId, createProfileChangeListener());
    }

    public void bindData(Profile profile) {
        fillInProfileFields(profile);
    }

    private OnObjectChangedListener<Profile> createProfileChangeListener() {
        return new OnObjectChangedListenerSimple<Profile>() {
            @Override
            public void onObjectChanged(Profile obj) {
                fillInProfileFields(obj);
            }
        };
    }

    protected void fillInProfileFields(Profile profile) {
        nameTextView.setText(profile.getUsername());

        String currentUserId = FirebaseAuth.getInstance().getUid();
        if (currentUserId != null) {
            if (!currentUserId.equals(profile.getId())) {
                FollowManager.getInstance(context).checkFollowState(currentUserId, profile.getId(), followState -> {
                    followButton.setVisibility(View.VISIBLE);
                    followButton.setState(followState);
                });
            } else {
                followButton.setState(FollowState.MY_PROFILE);
            }
        } else {
            followButton.setState(FollowState.NO_ONE_FOLLOW);
        }

        if (profile.getPhotoUrl() != null) {
            ImageUtil.loadImage(context, new RequestOptions(), profile.getPhotoUrl(), photoImageView);
        }
    }

    public interface Callback {
        void onItemClick(int position, View view);

        void onFollowButtonClick(int position, FollowButton followButton);
    }

}