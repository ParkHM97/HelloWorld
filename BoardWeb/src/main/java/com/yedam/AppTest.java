package com.yedam;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.jdbc.ReplyDAO;

public class AppTest {
	public static void main(String[] args) {
		ReplyDAO rdao = new ReplyDAO();
		List<Map<String, Object>> result = rdao.chartData();
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(result);
		
		System.out.println(json);
	}
}