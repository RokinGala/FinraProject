package com.Finra.Rokin.Test;


/**
 * @author rokin.gala
 *
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhoneNumberController {

	@RequestMapping(value ="/getAllMapping" , method=RequestMethod.GET ,produces = "application/json")
	public PhoneNumberObj getAllMapping(@RequestParam(value = "phoneNumber", required = true)String phoneNumber){
		List<String> mappings = new ArrayList<String>();
		
		if(phoneNumber.length()!=7 || phoneNumber.length()!=10){
			return new PhoneNumberObj("Failed","Incorrect Phone Number","Entered phone number is not correct.");
		}
		
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
       
        if(digits.isEmpty()){
            return result;
        }
        result.add("");
        // Iterating over the length of the phone number
        for(int i=digits.length()-1;i>=0;i--){
            String[] arr=getMapping(digits.charAt(i));
            
            String num=digits;

            // This is loop running over the getting all the strings for each number and then replacing 
            // The number with all combinations of the letters.
                for(String str:result){
                    for(String arrStr:arr){
                        String s=arrStr+str;
                        temp.add(s);
                    }
                }
                // Adding complete String
                result=temp;
                temp=new ArrayList<String>();
    
        }
    
       Collections.sort(result);
       
      return result;
    }
/**
 * The Method returns the string mapping of digits.
 * Have included the digits also to achieve all possible Alpha numeric combination
 * @param digit
 * @return
 */
	 public String[]  getMapping(char digit){
	        
	        switch(digit){
	                
	            case '2': return new String[]{"2","a","b","c"};
	            case '3': return new String[]{"3","d","e","f"};
	            case '4': return new String[]{"4","g","h","i"};
	            case '5': return new String[]{"5","j","k","l"};
	            case '6': return new String[]{"6","m","n","o"};
	            case '7': return new String[]{"7","p","q","r","s"};
	            case '8': return new String[]{"8","t","u","v"};
	            case '9': return new String[]{"9","w","x","y","z"};
	            case '1': return new String[]{"1"};
	            case '0': return new String[]{"0"};
	                
	        }
	        return null;
	    }
}
