/**
 * 
 */
package com.Finra.Rokin.Test;

import java.io.Serializable;
import java.util.List;

/**
 * @author rokin.gala
 *
 */
public class PhoneNumberObj  implements Serializable{

	public Integer count;
	public List<String> output;
	public String errorCode;
	public String errorMessage;
	public String stackTrace;
	
	public PhoneNumberObj(){
		
	}
	
	public PhoneNumberObj(Integer count,List<String> output){
		super();
		this.count=count;
		this.output=output;
	}
	public PhoneNumberObj(String code,String message,String stackTrace) {
		this.errorCode = code;
		this.errorMessage = message;
		this.stackTrace = stackTrace;
	}
}
