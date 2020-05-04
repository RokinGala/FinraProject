package com.Finra.Rokin.Test;


/**
 * @author rokin.gala
 *
 */
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhoneNumberController {

	@RequestMapping(value ="/getAllMapping" , method=RequestMethod.GET ,produces = "application/json")
	public PhoneNumberObj getAllMapping(@RequestParam(value = "phoneNumber", required = true)String phoneNumber){
		List<String> mappings = new ArrayList<String>();
		
		
		//mappings.add(phoneNumber);
		mappings=letterCombinations(phoneNumber);
		PhoneNumberObj outputObj= new PhoneNumberObj(mappings.size(),mappings); 
		
		return outputObj;
	}
	
/*
 * This Method is used to generate a list of Alpha numeric value for the given phone number.
 * 
 */
public List<String> letterCombinations(String digits) {
        
        List<String> result= new ArrayList<String>();
        List<String> temp= new ArrayList<String>();
        List<String> eachLetter = new ArrayList<String>();
        if(digits.isEmpty()){
            return result;
        }
        result.add("");
        // Iterating over the length of the phone number
        for(int i=digits.length()-1;i>=0;i--){
            String[] arr=getMapping(digits.charAt(i));
            
            String num=digits;
            // Loop to replace indivdiual digits with Letter;
            for(String arrStr:arr){
        	String oneStr=num.substring(0,i)+ arrStr+(num.substring(i+1,digits.length()));
        	 eachLetter.add(oneStr);	
        	 
            }
            // This is loop running over the getting all the strings for each number and then replacing 
            // The number with all combinations of the letters.
                for(String str:result){
                	if(!str.isEmpty()){
                		int j= num.length()-str.length();
                		String replace= num.substring(0,j)+str;
                		eachLetter.add(replace);
                	}
                    for(String arrStr:arr){
                        String s=arrStr+str;
                        temp.add(s);
                    }
                }
                // Adding complete String
                result=temp;
                temp=new ArrayList<String>();
           
            
            
            
        }
        result.addAll(eachLetter);
      return result;
    }
	 public String[]  getMapping(char digit){
	        
	        switch(digit){
	                
	            case '2': return new String[]{"a","b","c"};
	            case '3': return new String[]{"d","e","f"};
	            case '4': return new String[]{"g","h","i"};
	            case '5': return new String[]{"j","k","l"};
	            case '6': return new String[]{"m","n","o"};
	            case '7': return new String[]{"p","q","r","s"};
	            case '8': return new String[]{"t","u","v"};
	            case '9': return new String[]{"w","x","y","z"};
	            case '1': return new String[]{"1"};
	            case '0': return new String[]{"0"};
	                
	        }
	        return null;
	    }
}
