package tech.blur.eventhub.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * Lombok (https://projectlombok.org/) инструмент, позволяющий не писать геттеры-сеттеры, конструкторы и тд. Они генерируются автоматом.
 * Его использование не является обязательным, но во многих ситуациях заметно упрощает разработку.
 * Так же его использование не отменяет осознанного подхода к инкапсуляции, а именно необходимости открывать доступ к полям (геттеры-сеттеры).
 * Для dto-классов обычно это не распространяется, т.к. они требуют наличия этих методов, а так же equals/hashCode и конструктора
 */

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Event implements Serializable{

    private String id;
    private Integer host;
    private String name;
    private String description;
    private String place;
    private List<Integer> tags;
    private List<Integer> guests;
    private String start;
    private String end;

}
