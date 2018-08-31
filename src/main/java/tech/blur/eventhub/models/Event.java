package tech.blur.eventhub.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Event implements Serializable{

    private String id;
    private String host;
    private String host_name;
    private String name;
    private String description;
    private String place;
    private List<String> tags;
    private List<String> guests;
    private String start;
    private String end;

}
