package com.mehmedmaljoki.springstarthere.interface_as_contract.repositories;

import com.mehmedmaljoki.springstarthere.interface_as_contract.model.Comment;

public interface CommentRepository {
    
    void storeComment(Comment comment);
}
