package es.ulpgc.fitmanager.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class VideoList {
    private Integer id;
    private String title;
}
