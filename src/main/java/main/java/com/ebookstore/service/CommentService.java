package main.java.com.ebookstore.service;


import main.java.com.ebookstore.model.Comment;

import java.util.List;

public interface CommentService
{
    void addComment(Comment comment);

    Comment getCommentById(int commentId);

    List<Comment> getCommentList(int productId);

    void deleteComment(Comment comment);

    void editComment(Comment comment);
}
