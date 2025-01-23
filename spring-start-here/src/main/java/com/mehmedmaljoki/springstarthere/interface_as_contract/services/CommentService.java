package com.mehmedmaljoki.springstarthere.interface_as_contract.services;

import com.mehmedmaljoki.springstarthere.interface_as_contract.model.Comment;
import com.mehmedmaljoki.springstarthere.interface_as_contract.proxies.CommentNotificationProxy;
import com.mehmedmaljoki.springstarthere.interface_as_contract.repositories.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    private final CommentNotificationProxy commentNotificationProxy;
    
    public CommentService(CommentRepository commentRepository, CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }
    
    public void publishComment(Comment comment) {
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }

}
