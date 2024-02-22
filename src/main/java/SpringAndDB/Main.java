package SpringAndDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Main {

    private static UserController userController;

    @Autowired
    public Main(UserController userController) {
        this.userController = userController;
    }

    @Autowired
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        Main main = new Main(userController);
        main.operations();
    }

    private void operations() {
        createUser();
        updateUser();
        deleteUser();
        getById();
        getAll();
    }

    private void createUser() {
        User user = new User();
        user.setFullName("John Carter");
        userController.createUser(user);
    }

    private void updateUser() {
        User user = new User();
        user.setFullName("Black Betty");
        userController.updateUser(15L, user);
    }

    private void deleteUser() {
        userController.deleteUser(2L);
    }

    private void getById() {
        User userById = userController.getUserById(6L);
        System.out.println(userById);
    }

    private void getAll() {
        List<User> allUsers = userController.getAllUsers();
        System.out.println(allUsers);
    }
}