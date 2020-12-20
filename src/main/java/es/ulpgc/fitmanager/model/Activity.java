package es.ulpgc.fitmanager.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Builder
@AllArgsConstructor
public class Activity {
    private Integer id;
    private String name;
    private String description;
    private Integer capacity;
    private Integer duration;
    private LocalDateTime date;
    private Boolean weekly;
    private Boolean room;
    private Integer monitorId;
    
    @Override
    public String toString(){
        return name + ": " + date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
    }
}
