package ma.younes.jpayounes.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import ma.younes.jpayounes.entities.Role;
import ma.younes.jpayounes.entities.User;
import ma.younes.jpayounes.repositories.RoleRepository;
import ma.younes.jpayounes.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;



    @Override
    public User addNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role){
            return roleRepository.save(role);
    }

    @Override
    public User findUserByUserName(String userName) {
        return userRepository.findUserByUsername(userName);
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return roleRepository.findRoleByRoleName(roleName);
    }

    @Override
    public void addRoleToUser(String username, String RoleName) {
        User user = findUserByUserName(username);
        Role role = findRoleByRoleName(RoleName);
        if(user.getRoles()!=null) {
            user.getRoles().add(role);
            role.getUsers().add(user);
        }
    }

    @Override
    public User authenticate(String userName, String password) {
        User user=userRepository.findUserByUsername(userName);
        if(user==null) throw new RuntimeException("Bad credentials");
        if(user.getPassword().equals(password)) {
            return user;
        }
        throw new RuntimeException("Bad credentials");
    }
}
