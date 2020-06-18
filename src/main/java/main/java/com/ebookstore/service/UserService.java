package main.java.com.ebookstore.service;

import main.java.com.ebookstore.dao.UserDao;
import main.java.com.ebookstore.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.RandomAccessFile;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    public ResponseEntity<byte[]> getUsername() throws IOException {
        User user = userDao.findResource(1);
        String username = user.getUsername();
        RandomAccessFile f = new RandomAccessFile(username, "r");
        byte[] b = new byte[(int) f.length()];
        f.readFully(b);
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<byte[]>(b, headers, HttpStatus.CREATED);
    }
}
