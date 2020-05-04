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
	
	public PhoneNumberObj(){
		
	}
	
	public PhoneNumberObj(Integer count,List<String> output){
		super();
		this.count=count;
		this.output=output;
	}
}
