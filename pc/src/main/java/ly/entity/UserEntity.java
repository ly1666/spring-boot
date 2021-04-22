package ly.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ly
 */
@Setter
@Getter
@ToString
public class UserEntity {

    private int id;

    private String name;

    private String password;

    private String userId;

    private int role;

    private int del;
}
