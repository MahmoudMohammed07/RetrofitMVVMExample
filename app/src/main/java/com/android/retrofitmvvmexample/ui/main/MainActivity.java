package com.android.retrofitmvvmexample.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.retrofitmvvmexample.R;
import com.android.retrofitmvvmexample.model.Post;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    PostViewModel postViewModel;

    RecyclerView recyclerView;
    PostsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        postViewModel = ViewModelProviders.of(this).get(PostViewModel.class);

        recyclerView = findViewById(R.id.recyclerView);
        adapter = new PostsAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        postViewModel.postsMutableLiveData.observe(this, new Observer<List<Post>>() {
            @Override
            public void onChanged(List<Post> posts) {
                adapter.setPosts(posts);
            }
        });

        postViewModel.getPosts();

    }
}
