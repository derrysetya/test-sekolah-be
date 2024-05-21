package com.derrysetya.testsekolah.utils;

import org.springframework.http.HttpStatus;

import com.derrysetya.testsekolah.constants.AppConstants;
import com.derrysetya.testsekolah.response.ApiResponse;

public class ResponseUtils {
	
	public static ApiResponse getSuccess() {
		ApiResponse resp = new ApiResponse();
		
		resp.setStatus(HttpStatus.OK.value());
		resp.setMessage(AppConstants.RESPONSE_MESSAGE_SUCCESS);
		
		return resp;
	}
	
	public static ApiResponse getFailed() {
		ApiResponse resp = new ApiResponse();
		
		resp.setStatus(AppConstants.RESPONSE_CODE_ERROR);
		resp.setMessage(AppConstants.RESPONSE_MESSAGE_FAILED);
		
		return resp;
	}

}
