package hw_37;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public void printUsers() {
        List<User> allUsers = userRepository.findAllUsers();
        allUsers.forEach(System.out::println);
    }


}
