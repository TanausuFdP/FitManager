package es.ulpgc.fitmanager.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Video {
    private Integer id;
    private String title;
    private Double length;
    private String url;
    private Integer categoryId;
    private Integer videoListId;
    
    @Override
    public String toString(){
        return this.title + " " + this.length;
    }
}
