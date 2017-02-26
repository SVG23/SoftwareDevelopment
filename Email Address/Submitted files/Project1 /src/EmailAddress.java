import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

 
public class EmailAddress {
	private String completeNameOfUser;
	private String address;
	
	// A constructor EmailAddress() taking two arguments 
	public EmailAddress(String completeNameOfUser,String address) 
	{
		
		this.completeNameOfUser = completeNameOfUser;
		this.address = address;
		
	}
	
	// A constructor EmailAddress() taking no arguments 
     public EmailAddress() 
     {
		
		completeNameOfUser = null;
		address = null;
		
	}
  
	// A method setnameOfUser() to set the name of the user
	public void setnameOfUser(String name) 
	{
		  
		completeNameOfUser = name;
	}

	// A method getnameOfUser() to retrieve the name of the user
	public String getnameOfUser() 
	{
		  
		  return completeNameOfUser;
	}
	
	// A method setAddress() to set the email address
  public void setAddress(String userEmail) 
  {
	  
	  address = userEmail;
  }
  
  	//A method getAddress() to get the email address
  public String getAddress() 
  {
	  
	  return address;
  }

// A method isValid() to check whether the given string is a valid email address or not.
   public boolean isValid()
   {
	   Pattern emailAddressPtrn = Pattern.compile(
  		    "^[_A-Za-z-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");  // email regular expression pattern
	   Matcher mtch = emailAddressPtrn.matcher(address);
	   if(mtch.matches())
	   {
		   return true;    
	   }
       return false;
  }
   
}


