package lab.demo.user.demouser.services.user;

public interface UserService {
    UserVO findById(Integer id);
    UserVO create(UserVO userVO);
}
