package com.chaupha.blacksocial.main.search.users;

import com.chaupha.blacksocial.main.base.BaseFragmentView;
import com.chaupha.blacksocial.model.Profile;

import java.util.List;

public interface SearchUsersView extends BaseFragmentView {
    void onSearchResultsReady(List<Profile> profiles);

    void showLocalProgress();

    void hideLocalProgress();

    void showEmptyListLayout();

    void updateSelectedItem();
}
