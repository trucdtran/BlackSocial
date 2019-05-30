package com.chaupha.blacksocial.main.search.posts;

import com.chaupha.blacksocial.main.base.BaseFragmentView;
import com.chaupha.blacksocial.model.Post;

import java.util.List;

public interface SearchPostsView extends BaseFragmentView {
    void onSearchResultsReady(List<Post> posts);
    void showLocalProgress();
    void hideLocalProgress();
    void showEmptyListLayout();
}
