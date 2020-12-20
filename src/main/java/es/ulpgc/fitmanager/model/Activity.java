package es.ulpgc.fitmanager.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

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
}
