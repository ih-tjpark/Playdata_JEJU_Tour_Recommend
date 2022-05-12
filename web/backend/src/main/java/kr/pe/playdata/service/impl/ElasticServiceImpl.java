package kr.pe.playdata.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.stereotype.Service;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;
import kr.pe.playdata.domain.SearchLog;
import kr.pe.playdata.domain.TourClickLog;
import kr.pe.playdata.repository.ClickLogElasticRepo;
import kr.pe.playdata.repository.SearchLogElasticRepo;
import kr.pe.playdata.service.ElasticService;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor  
//초기화 되지않은 final필드나, @NonNull이 붙은 필드에 생성자를 생성해 줌 / DI 편의성을 위해 사용
public class ElasticServiceImpl implements ElasticService{
	

	private final SearchLogElasticRepo searchLogElasticRepo;
	private final ClickLogElasticRepo clickLlogElasticRepo;
	
	public SearchLog insertSearchLog(String search,String logClass) {	
		
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    	
    	SearchLog searchLog = new SearchLog(search,sdf.format(new Date()),logClass);
    	
		searchLogElasticRepo.save(searchLog);	
		return searchLog;
	};
	
	public List<SearchLog> insertKeywordListLog(String keywords){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		
		String[] key_inputs = keywords.split(",");
		List<SearchLog> keyList = new ArrayList<>();
		
		for(String key : key_inputs) {
			keyList.add(new SearchLog(key,sdf.format(new Date()),"chatbotLog"));
		}
		
		searchLogElasticRepo.saveAll(keyList);
		return keyList;
	}
	
	public TourClickLog insertClickLog(String tourName, String longitute, String latitute) {
		
//		List<Double> coordinates =Arrays.asList(Double.parseDouble(longitute),Double.parseDouble(latitute));
//		Map<String, Object> location = new HashMap<>();
//		location.put("coordinates", coordinates);
//		location.put("type","Point");
		GeoPoint geopoint = new GeoPoint(Double.parseDouble(longitute),Double.parseDouble(latitute));

		
		TourClickLog tourClickLog = new TourClickLog();
		tourClickLog.setTourName(tourName);
		tourClickLog.setLocation(geopoint);
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    	tourClickLog.setLogDate(sdf.format(new Date()));
    	System.out.println(tourClickLog);
    	clickLlogElasticRepo.save(tourClickLog);	
		
		return tourClickLog;
	};
		
}
