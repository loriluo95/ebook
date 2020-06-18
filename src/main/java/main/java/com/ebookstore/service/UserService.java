package main.java.com.ebookstore.service;

import main.java.com.ebookstore.model.User;
import main.java.com.ebookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;
    //    public ResponseEntity<byte[]> getUsername() throws IOException {
//        User user = userDao.findResource(1);
//        String username = user.getUsername();
//        RandomAccessFile f = new RandomAccessFile(username, "r");
//        byte[] b = new byte[(int) f.length()];
//        f.readFully(b);
//        final HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        return new ResponseEntity<byte[]>(b, headers, HttpStatus.CREATED);
//    }
    public List<User> listAll() {
        return userRepository.findAll();
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public User get(Integer userId) {
        return userRepository.findById(userId).get();
    }

    public void delete(Integer userId) {
        userRepository.deleteById(userId);
    }
}
