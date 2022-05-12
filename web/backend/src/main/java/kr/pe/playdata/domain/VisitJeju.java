package kr.pe.playdata.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection ="visitJeju")
public class VisitJeju {
	/*
	 * 	관광지에 대한 정보를 담고 있는 DAO(공공데이터 + visitJeju 데이터)
	 */
	
	@Id
	private String id;				// id
	private String source;			// 관광지 이름
	private String address;			// 주소
	private String sub_title;		// 부제목, 관광지에 대한 짧은 설명
	private String tag_prev;		// 비짓제주 태그
	private String tag_next;		// 비짓제주 태그
	private String img;				// 이미지 링크
	private String score;			// 별점
	private String call;			// 관광지 전화번호
	private String detail_content;	// 세부 내용, (주차, 이용연령 등의 세부내용들)
	private String useable_time;	// 평일 주말 사용 가능 시간, 운영시간
	private String charge; 			// 비용
	private String space_property; 	// 실/내외 활동
	private String purpose;			// 관광지에서 할수 있는 체험들
	private String purpose_etc; 	// 관광 이름
	private String time_required; 	// 관광 시간
	private String difficult;		// 관광 난이도
	private String convenience;		// 편의 시설
	private String etc_property;	// 기타 상세(ex.유네스코 지정)
	private String content;			// 소개글
	private Location location;      // 좌표
}