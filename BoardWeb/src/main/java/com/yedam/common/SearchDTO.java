package com.yedam.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data // lombok에서 getter setter 해줌 
@AllArgsConstructor // 3개의 값을 모두 가져오는 생성자 
public class SearchDTO {
	private int page;
	private String searchCondition;
	private String keyword;
}
