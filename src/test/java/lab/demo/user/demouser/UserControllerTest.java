package lab.demo.user.demouser;

import lab.demo.user.demouser.domain.User;
import lab.demo.user.demouser.repositories.UserRepository;
import lab.demo.user.demouser.services.user.UserService;
import lab.demo.user.demouser.services.user.UserVO;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class UserControllerTest extends AbstractIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void notFound() {
        given().request()
                .get("/xxx")
                .then().statusCode(404);
    }

    @Test
    public void foundById() {
        UserVO userVO = given().request()
                .get("/users/1")
                .then().statusCode(200)
                .extract().as(UserVO.class);

        User user = userRepository.findById(1).get();
        assertThat(userVO, notNullValue());
        assertThat(userVO.getId(), is(user.getId()));
        assertThat(userVO.getName(), is(user.getName()));
    }

}
