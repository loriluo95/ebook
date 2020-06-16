package main.java.com.ebookstore.service.impl;

import main.java.com.ebookstore.dao.CommentDao;
import main.java.com.ebookstore.model.Comment;
import main.java.com.ebookstore.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService
{

    @Autowired
    private CommentDao commentDao;

    public void addComment(Comment comment) {
        commentDao.addComment(comment);
    }

    public Comment getCommentById(int commentId) {
        return commentDao.getCommentById(commentId);
    }

    public List<Comment> getCommentList(int productId) {
        return commentDao.getCommentListByProduct(productId);
    }

    public void deleteComment(Comment comment) {
        commentDao.deleteComment(comment);
    }

    public void editComment(Comment comment) {
        commentDao.editComment(comment);
    }
}
