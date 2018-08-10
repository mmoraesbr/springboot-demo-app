package lab.demo.user.demouser;

import lab.demo.user.demouser.services.user.UserService;
import lab.demo.user.demouser.services.user.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users/{id}")
    public UserVO get(@PathVariable("id") Integer id) {
        return userService.findById(id);
    }

    @PostMapping("/users")
    public UserVO create(@RequestBody UserVO userVO) {
        return userService.create(userVO);
    }

}
