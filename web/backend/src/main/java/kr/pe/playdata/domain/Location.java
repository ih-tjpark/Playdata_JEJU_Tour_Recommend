package kr.pe.playdata.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Location {
    /*
        좌표 VO
     */

    private String type;                    // 타입
    private List<String> coordinates;       // 좌표
}