package com.chaupha.blacksocial.main.search.posts;

import android.content.Context;

import com.chaupha.blacksocial.main.base.BasePresenter;
import com.chaupha.blacksocial.managers.PostManager;
import com.chaupha.blacksocial.model.Post;
import com.chaupha.blacksocial.utils.LogUtil;

import java.util.List;

public class SearchPostsPresenter extends BasePresenter<SearchPostsView> {
    public static final int LIMIT_POSTS_FILTERED_BY_LIKES = 10;
    private Context context;
    private PostManager postManager;

    public SearchPostsPresenter(Context context) {
        super(context);
        this.context = context;
        postManager = PostManager.getInstance(context);
    }

    public void search() {
        search("");
    }

    public void search(String searchText) {
        if (checkInternetConnection()) {
            if (searchText.isEmpty()) {
                filterByLikes();
            } else {
                ifViewAttached(SearchPostsView::showLocalProgress);
                postManager.searchByTitle(searchText, this::handleSearchResult);
            }

        } else {
            ifViewAttached(SearchPostsView::hideLocalProgress);
        }
    }

    private void filterByLikes() {
        if (checkInternetConnection()) {
            ifViewAttached(SearchPostsView::showLocalProgress);
            postManager.filterByLikes(LIMIT_POSTS_FILTERED_BY_LIKES, this::handleSearchResult);
        } else {
            ifViewAttached(SearchPostsView::hideLocalProgress);
        }
    }

    private void handleSearchResult(List<Post> list) {
        ifViewAttached(view -> {
            view.hideLocalProgress();
            view.onSearchResultsReady(list);

            if (list.isEmpty()) {
                view.showEmptyListLayout();
            }

            LogUtil.logDebug(TAG, "found items count: " + list.size());
        });
    }
}
