package tech.blur.eventhub.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class AssignEvent {
    private String user_id;
    private String event_id;
}
