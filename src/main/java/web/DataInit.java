package web;

import web.model.Role;
import web.model.User;
import web.service.RoleService;
import web.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
public class DataInit {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public DataInit(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    private void init() {

        Role role0 = new Role("ADMIN");
        roleService.saveRole(role0);
        Role role1 = new Role("USER");
        roleService.saveRole(role1);

        User user0 = new User();
        user0.setEmail("admin");
        user0.setPassword("admin");
        user0.setName("admin");
        user0.setSurname("admin");
        user0.setAge((byte) 1);
        user0.addRole(role0);
        userService.save(user0);

        User user1 = new User();
        user1.setEmail("user");
        user1.setPassword("user");
        user1.setName("user");
        user1.setSurname("user");
        user1.setAge((byte) 1);
        user1.addRole(role1);
        userService.save(user1);

    }
}