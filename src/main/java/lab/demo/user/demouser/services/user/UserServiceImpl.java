package lab.demo.user.demouser.services.user;

import lab.demo.user.demouser.domain.User;
import lab.demo.user.demouser.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserVO findById(Integer id) {
        return userRepository.findById(id).map(user -> {
            return new UserVO(user.getId(), user.getName());
        }).orElseThrow(NotFoundException::new);
    }

    @Override
    public UserVO create(UserVO userVO) {
        User user = new User().setName(userVO.getName());
        user = userRepository.save(user);
        return new UserVO(user.getId(), user.getName());
    }
}
