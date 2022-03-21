package kr.pe.playdata.domain;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class SentiRes {
	/*
	 * 특정 키워드에 대한 감정 분석 결과를 담은 객체
	 */
	
	@Id
	private String id;          // id
	private boolean sentiment;  // 긍정,부정을 나타냄
	private String keyword;		// 키워드
}
