package first.api.flightcatalog.model;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class User {
    private Integer id;
    private String fullName;
    private String email;
    private String password;

    @Id
    public Integer getId() {
        return id;
    }

    public User updateWith(User user) {
        return new User(
            this.id,
            user.fullName,
            user.email,
            user.password
        );

    }

}
