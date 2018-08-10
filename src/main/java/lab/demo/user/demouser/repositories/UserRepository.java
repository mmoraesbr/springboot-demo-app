package lab.demo.user.demouser.repositories;

import lab.demo.user.demouser.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
