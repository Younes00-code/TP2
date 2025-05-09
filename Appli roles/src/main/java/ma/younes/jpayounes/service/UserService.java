package ma.younes.jpayounes.service;

import ma.younes.jpayounes.entities.Role;
import ma.younes.jpayounes.entities.User;

public interface UserService {
    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByUserName(String userName);
    Role findRoleByRoleName(String roleName);
    void addRoleToUser(String username,String RoleName);
    User authenticate(String userName, String password);

}
