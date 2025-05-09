package ma.younes.jpayounes.repositories;

import ma.younes.jpayounes.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findUserByUsername(String userName);
}
