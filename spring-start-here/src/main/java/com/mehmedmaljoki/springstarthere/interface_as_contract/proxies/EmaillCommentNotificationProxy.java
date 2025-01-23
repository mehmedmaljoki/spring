package com.mehmedmaljoki.springstarthere.interface_as_contract.proxies;

import org.springframework.stereotype.Repository;

@Repository
public class EmaillCommentNotificationProxy implements CommentNotificationProxy {
    
    @Override
    public void sendComment(Object comment) {
        System.out.println("Sending email notification: " + comment);
    }
}
