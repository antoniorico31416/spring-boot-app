package com.atom.springboot.web.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atom.springboot.web.app.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{

}
