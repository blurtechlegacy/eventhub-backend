package tech.blur.eventhub.models;

import lombok.*;

import java.io.Serializable;
import java.util.List;



@NoArgsConstructor
@Data
@AllArgsConstructor
public class Tag implements Serializable{

    private String id;
    private String name;
    private Integer event_count;

}
