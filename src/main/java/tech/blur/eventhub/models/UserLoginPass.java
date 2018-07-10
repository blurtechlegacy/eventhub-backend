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
    private String pass;

    public int hashCode(){
        return (pass+login).hashCode();
    }

    public boolean equals(Object o){
        if(o instanceof UserLoginPass){
            return pass.equals(((UserLoginPass)o).pass)||login.equals(((UserLoginPass)o).login);
        }
        return false;
    }
}