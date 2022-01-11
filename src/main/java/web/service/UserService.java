package web.service;

import web.model.User;
import java.util.List;

public interface UserService {

    void save(User user);

    void update(User updatedUser);

    void delete(Long id);

    List<User> getAllUsers();

    User getById(Long id);

    User getByLogin(String email);


}