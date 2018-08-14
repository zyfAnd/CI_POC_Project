package com.citi.service;



import java.io.StringReader;

import com.citi.model.InputData;
import com.citi.util.Constant;
import com.citi.util.HttpUtil;

public class ApplicationService {

	public static  InputData getApp(InputData data) {
		
		System.out.println("entry==applicaitonService");
		if(data!=null) {
			System.out.println("data:"+data.toString());
		}

		String resJson = HttpUtil.httpGet(Constant.CREDITANALYSIS_CIFME);
//		
//		System.out.println(resJson);	
//		SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
//		requestFactory.setConnectTimeout(1000);
//		requestFactory.setReadTimeout(1000);
//		RestTemplate restTemplate = new RestTemplate(requestFactory);
//		String resJson  = restTemplate.getForObject((Constant.BASE_HOST+Constant.CREDITANALYSIS) ,String.class);
		System.out.println(resJson);
		return new InputData(data.getApplicationId()+resJson,data.getStage()+"@");
	}
	
	public static InputData getInfo(String url) {
		
		System.out.println("entry[====getInfo"+url);
		
		return new InputData("234","45");
	}
	
	public static void internal() {
		String res = HttpUtil.httpGet(Constant.INETERNAL_ACCOUNTPULL);
		System.out.println("internal account pull "+res);
	}
	public static void ness() {
		String res = HttpUtil.httpGet(Constant.NESS);
		System.out.println("ness "+res);
	}
}
