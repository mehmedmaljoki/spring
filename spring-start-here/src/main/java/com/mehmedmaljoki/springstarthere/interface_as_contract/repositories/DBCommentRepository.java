package com.mehmedmaljoki.springstarthere.interface_as_contract.repositories;

import com.mehmedmaljoki.springstarthere.interface_as_contract.model.Comment;
import org.springframework.stereotype.Repository;

@Repository
public class DBCommentRepository implements CommentRepository {
    
    @Override
    public void storeComment(Comment comment) {
        System.out.println("Storing comment in database: " + comment);
    }
}
