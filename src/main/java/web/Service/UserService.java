package web.Service;

import web.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void saveUser(User user);

    void removeUserById(int id);

    User getUserByUserName(String userName);

    User getUserById(int id);
}
