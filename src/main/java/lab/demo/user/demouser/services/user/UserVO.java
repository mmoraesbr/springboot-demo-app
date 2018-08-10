package lab.demo.user.demouser.services.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserVO {
    private Integer id;
    private String name;

    @JsonCreator
    public UserVO(@JsonProperty("name") String name) {
        this.name = name;
    }

    @JsonCreator
    public UserVO(@JsonProperty("id") Integer id,
                  @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
