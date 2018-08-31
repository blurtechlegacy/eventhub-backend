package tech.blur.eventhub.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class User implements Serializable{

    private String id;
    private String login;
    private String password;
    private String name;
    private String birthday;
    private Integer sex;

}
