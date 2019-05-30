package com.chaupha.blacksocial.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.widget.ImageView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.annotation.GlideOption;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.google.firebase.storage.StorageReference;
import com.chaupha.blacksocial.R;
import com.chaupha.blacksocial.enums.UploadImagePrefix;

import java.util.Date;

public class ImageUtil {

    public static final String TAG = ImageUtil.class.getSimpleName();

    public static String generateImageTitle(UploadImagePrefix prefix, String parentId) {
        if (parentId != null) {
            return prefix.toString() + parentId;
        }

        return prefix.toString() + new Date().getTime();
    }

    public static String generatePostImageTitle(String parentId) {
        return generateImageTitle(UploadImagePrefix.POST, parentId) + "_" + new Date().getTime();
    }

    public static void loadImage(Context context, RequestOptions requestOptions, String url, ImageView imageView) {
        loadImage(context, requestOptions, url, imageView, DiskCacheStrategy.ALL);
    }

    public static void loadImage(Context context, RequestOptions requestOptions, String url, ImageView imageView,
                                 DiskCacheStrategy diskCacheStrategy) {
        Glide.with(context)
                .applyDefaultRequestOptions(requestOptions
                        .placeholder(R.drawable.ic_stub)
                        .error(R.drawable.ic_stub)
                        .diskCacheStrategy(diskCacheStrategy))
                .load(url)
                .into(imageView);
    }

    public static void loadImage(Context context, RequestOptions requestOptions, String url, ImageView imageView,
                                 RequestListener<Drawable> listener) {
        Glide.with(context)
                .applyDefaultRequestOptions(requestOptions
                        .placeholder(R.drawable.ic_stub)
                        .error(R.drawable.ic_stub)
                        .diskCacheStrategy(DiskCacheStrategy.DATA))
                .load(url)
                .listener(listener)
                .into(imageView);
    }

    public static void loadImageCenterCrop(Context context, RequestOptions requestOptions, String url,
                                           ImageView imageView, int width, int height) {
        Glide.with(context)
                .applyDefaultRequestOptions(requestOptions
                        .placeholder(R.drawable.ic_stub)
                        .error(R.drawable.ic_stub)
                        .centerCrop()
                        .override(width, height)
                        .diskCacheStrategy(DiskCacheStrategy.ALL))
                .load(url)
                .into(imageView);
    }

    public static void loadImageCenterCrop(Context context, RequestOptions requestOptions, StorageReference imageStorageRef,
                                           ImageView imageView, int width, int height) {
        Glide.with(context)
                .applyDefaultRequestOptions(requestOptions
                        .placeholder(R.drawable.ic_stub)
                        .error(R.drawable.ic_stub)
                        .centerCrop()
                        .override(width, height)
                        .diskCacheStrategy(DiskCacheStrategy.ALL))
                .load(imageStorageRef)
                .into(imageView);
    }

    public static void loadImageCenterCrop(Context context, RequestOptions requestOptions, StorageReference imageStorageRef,
                                           ImageView imageView, int width, int height, RequestListener<Drawable> listener) {
        Glide.with(context)
                .applyDefaultRequestOptions(requestOptions
                        .placeholder(R.drawable.ic_stub)
                        .error(R.drawable.ic_stub)
                        .centerCrop()
                        .override(width, height)
                        .diskCacheStrategy(DiskCacheStrategy.ALL))
                .load(imageStorageRef)
                .listener(listener)
                .into(imageView);
    }

    public static void loadMediumImageCenterCrop(Context context,
                                                 RequestOptions requestOptions,
                                                 StorageReference imageStorageRefMedium,
                                                 StorageReference imageStorageRefOriginal,
                                                 ImageView imageView,
                                                 int width,
                                                 int height,
                                                 RequestListener<Drawable> listener) {
        Glide.with(context)
                .applyDefaultRequestOptions(requestOptions
                        .placeholder(R.drawable.ic_stub)
                        .error(R.drawable.ic_stub)
                        .centerCrop()
                        .override(width, height)
                        .diskCacheStrategy(DiskCacheStrategy.ALL))
                .load(imageStorageRefMedium)
                .listener(listener)
                .error(Glide.with(context).load(imageStorageRefOriginal))
                .into(imageView);
    }

    public static void loadImageCenterCrop(Context context, RequestOptions requestOptions, String url, ImageView imageView,
                                           int width, int height, RequestListener<Drawable> listener) {
        Glide.with(context)
                .applyDefaultRequestOptions(requestOptions
                        .placeholder(R.drawable.ic_stub)
                        .error(R.drawable.ic_stub)
                        .centerCrop()
                        .override(width, height)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        )
                .load(url)
                .listener(listener)
                .into(imageView);
    }

    public static void loadImageCenterCrop(Context context, RequestOptions requestOptions, StorageReference imageStorageRef,
                                           ImageView imageView, RequestListener<Drawable> listener) {
        Glide.with(context)
                .applyDefaultRequestOptions(requestOptions
                        .placeholder(R.drawable.ic_stub)
                        .error(R.drawable.ic_stub)
                        .centerCrop()
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                )
                .load(imageStorageRef)
                .listener(listener)
                .into(imageView);
    }

    public static void loadImageCenterCrop(Context context, RequestOptions requestOptions, String url, ImageView imageView,
                                           RequestListener<Drawable> listener) {
        Glide.with(context)
                .applyDefaultRequestOptions(requestOptions
                        .placeholder(R.drawable.ic_stub)
                        .error(R.drawable.ic_stub)
                        .centerCrop()
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                )
                .load(url)
                .listener(listener)
                .into(imageView);
    }


    @Nullable
    public static Bitmap loadBitmap(Context context, RequestOptions requestOptions, String url, int width, int height) {
        try {
            return Glide.with(context)
                    .applyDefaultRequestOptions(requestOptions
                            .placeholder(R.drawable.ic_stub)
                            .error(R.drawable.ic_stub)
                            .centerCrop()
                            .diskCacheStrategy(DiskCacheStrategy.DATA)
                    )
                    .asBitmap()
                    .load(url)
                    .submit(width, height)
                    .get();
        } catch (Exception e) {
            LogUtil.logError(TAG, "getBitmapfromUrl", e);
            return null;
        }
    }

    public static void loadImageWithSimpleTarget(Context context, RequestOptions requestOptions, String url,
                                                 SimpleTarget<Bitmap> simpleTarget) {
        Glide.with(context)
                .applyDefaultRequestOptions(requestOptions
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .fitCenter()
                )
                .asBitmap()
                .load(url)
                .into(simpleTarget);
    }

    public static void loadImageWithSimpleTarget (Context context, RequestOptions requestOptions,
                                                  StorageReference imageStorageRef, SimpleTarget<Bitmap> simpleTarget) {
        Glide.with(context)
                .applyDefaultRequestOptions(requestOptions
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .fitCenter()
                )
                .asBitmap()
                .load(imageStorageRef)
                .into(simpleTarget);
    }

    public static void loadLocalImage(Context context, RequestOptions requestOptions, Uri uri, ImageView imageView,
                                      RequestListener<Drawable> listener) {
        Glide.with(context)
                .applyDefaultRequestOptions(requestOptions
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .skipMemoryCache(true)
                        .fitCenter()
                )
                .load(uri)
                .listener(listener)
                .into(imageView);
    }

}
