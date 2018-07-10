package tech.blur.eventhub.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@NoArgsConstructor
@Data
@AllArgsConstructor
public class UserLoginPass implements Serializable {
    private String login;
    private String password;

    public int hashCode(){
        return (password+login).hashCode();
    }

    public boolean equals(Object o){
        if(o instanceof UserLoginPass){
            return password.equals(((UserLoginPass)o).password)||login.equals(((UserLoginPass)o).login);
        }
        return false;
    }
}