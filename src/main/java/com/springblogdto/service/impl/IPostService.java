package com.springblogdto.service.impl;

import com.springblogdto.entity.Post;
import com.springblogdto.repository.PostRepo;
import com.springblogdto.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IPostService implements PostService {

    private PostRepo postRepo;

    @Override
    public Post createPost(Post post) {
       return postRepo.save(post);
    }

    @Override
    public Post updatePost(Post post, Integer id) {
        Optional<Post> post1 = postRepo.findById(id);
        if(post1.isPresent()){
            Post post2 = post1.get();
            post2.setTitle(post.getTitle());
            post2.setUser(post.getUser());
            post2.setText((post.getText()));
            post2.setComments(post.getComments());
            return postRepo.save(post2);
        }
        return null;
    }

    @Override
    public Optional<Post> getPostById(Integer id) {
        return postRepo.findById(id);
    }

    @Override
    public List<Post> getAllPosts() {
        return (List<Post>) postRepo.findAll();
    }

    @Override
    public void deletePostById(Integer id) {
        postRepo.deleteById(id);
    }
}
