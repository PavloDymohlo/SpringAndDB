package SpringAndDB;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        log.info("Creating user: {}", user);
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user) {
        log.info("Updating user with id {}: {}", id, user);
        user.setId(id);
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        log.info("Deleting user with id {}", id);
        userRepository.deleteById(id);
    }

    public User getUserById(Long id) {
        log.info("Getting user with id {}", id);
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElse(null);
    }

    public List<User> getAllUsers() {
        log.info("Retrieving all users");
        return userRepository.findAll();
    }
}