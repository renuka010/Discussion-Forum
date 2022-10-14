package com.odforum.forum.validation;

import org.springframework.stereotype.Component;

@Component
public class Validator {

	public boolean validatePassword(String new1) {
		
		boolean uletter=false, lletter=false, number=false, symbol=false;
		
		if(new1.length()<8)
			return false;
		
		for(int i=0; i<new1.length(); i++) {
			char c=new1.charAt(i);
			if(c>='0' && c<='9')
				number=true;
			else if(c>='a' && c<='z')
				lletter=true;
			else if(c>='A' && c<='Z')
				uletter=true;
			else if((c>='!' && c<='/')||(c>=':' && c<='@')||(c>='[' && c<='`')||(c>='{' && c<='~'))
				symbol=true;
			
			if(number && lletter && uletter && symbol)
				return true;
		}
		
		return false;
	}

	public boolean validateUsername(String username) {
		
		char c=username.charAt(0);
		if(!(c>='a' && c<='z')) {
			return false;
		}
		if(username.length()<6)
			return false;
		for(int i=1; i<username.length(); i++) {
			c=username.charAt(i);
			if(!((c>='0'&& c<='9')||(c>='a' && c<='z')||c=='_')) {
				return false;
			}
		}
		return true;
	}

}
