package kr.pe.playdata.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection ="insta")
public class InstaRank {
    /*
       인스타 키워드의 순위를 나타내는 VO
     */

    @Id
    private String id;                  // id
    private String keyword;             // 키워드
    private String date;                // 날짜
}
