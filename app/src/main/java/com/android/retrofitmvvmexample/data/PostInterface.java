package com.android.retrofitmvvmexample.data;

import com.android.retrofitmvvmexample.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostInterface {

    @GET("posts")
    public Call<List<Post>> getPosts();
}
