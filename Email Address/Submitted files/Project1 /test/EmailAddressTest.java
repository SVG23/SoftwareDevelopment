import org.junit.*;
import static org.junit.Assert.*;


public class EmailAddressTest {

  private EmailAddress address;

  
  @Test // To check if it accepts the email address "john@cs.edu"
  public void shouldAcceptJohnAtCsDotEdu() {
	  EmailAddress ea = new EmailAddress("john","john@cs.edu" );
	  assertTrue( ea.isValid() ); //Test should be true since the identifier starting with an alphabet.
  }

  @Test // To check if it accepts the email address "jane.smith@gmail.com"
  public void shouldAcceptJaneDotSmithAtGmailDotCom() {
	  EmailAddress ea = new EmailAddress("jane smith","jane.smith@gmail.com" );
	  assertTrue( ea.isValid() ); //Test should be true since the identifier starting with an alphabet.
  }
  
  @Test // To check if it accepts the email address "sri.garapati23@gmail.com"
  public void shouldAcceptSriDotGarapati23AtGmailDotCom() {
	  EmailAddress ea = new EmailAddress("sri garapati","sri.garapati23@gmail.com" );
	  assertTrue( ea.isValid() ); 
  }
  
  @Test // To check if it accepts the email address "123@cs.edu". 
  public void shouldNotAccept123AtCsDotEdu() {
    EmailAddress ea = new EmailAddress("xyz","123@cs.edu");
    assertFalse( ea.isValid() ); //It should not accept since the identifier starting with a digit.
  }
 
  @Test // To check if it accepts the email address "john.cs.edu". 
  public void shouldNotAcceptJohnDotCsDotEdu() {
    EmailAddress ea = new EmailAddress(" John123","john.cs.edu");
    assertFalse( ea.isValid() ); //It should not accept since there is not @ symbol before edu.
}
  
  @Test // To check if it accepts the email address "Jane.smith.@gmail.com"
  public void shouldNotAcceptJaneDotSmithDotAtGmailDotCom() {
    EmailAddress ea = new EmailAddress("Smith ","Jane.smith.@gmail.com");
    assertFalse( ea.isValid() ); //It should not accept since email's last character can not end up with dot "."
}
  
  @Test // To check if it accepts the email address "john@cs-edu"
  public void shouldNotAcceptJohnAtCsDashEdu() {
    EmailAddress ea = new EmailAddress("Smith ","john@cs-edu");
    assertFalse( ea.isValid() ); //It should not accept since there is  "-" symbol before edu.
}
  
  @Test // To check if it accepts the email address "vinya..123@gmail.com"
  public void shouldNotAcceptVinyaDotDot123AtGmailDotCom() {
    EmailAddress ea = new EmailAddress("sri ","vinya..123@gmail.com");
    assertFalse( ea.isValid() ); //It should not accept since double dots are not allowed
}
  
  @Test // To check if it accepts the email address "ravi@sri@gmail.com"
  public void shouldNotAcceptVinyaAtSriAtGmailDotCom() {
    EmailAddress ea = new EmailAddress("sri ","ravi@sri@gmail.com");
    assertFalse( ea.isValid() ); //It should not accept since double "@" is not allowed
}
  
  @Test // To check if it accepts the email address "   "
  public void shouldNotAcceptNull() {
    EmailAddress ea = new EmailAddress("smith ","   ");
    assertFalse( ea.isValid()); //It should not accept since the identifier is null.
}
  
  @Test // To check if it accepts the email address "shankar()*@gmail.com"
  public void shouldNotAcceptShankarStarAtGmailDotCom() {
    EmailAddress ea = new EmailAddress("shankar","shankar()*@gmail.com");
    assertFalse( ea.isValid()); //It should not accept since email's allow only character,digit,underscore and dash.
}
  
  @Test // To check setAddress()
  public void testSetAddress() {
    EmailAddress ea = new EmailAddress();
    ea.setAddress("vinya.godavarthy@gnail.com");
    assertEquals("vinya.godavarthy@gnail.com", ea.getAddress() ); 
}
  
  @Test // To check setNameOfUser()
  public void testSetNameOfUser() {
    EmailAddress ea = new EmailAddress();
    ea.setnameOfUser("vinya");
  assertEquals("vinya", ea.getnameOfUser());
}
  
  @Test // To check getAddress()
  public void testGetAddress() {
    EmailAddress ea = new EmailAddress("Smith ","john@cs-edu");
    assertEquals("john@cs-edu", ea.getAddress() ); 
}
  
  @Test // To check getNameOfUser()
  public void testGetNameOfUser() {
    EmailAddress ea = new EmailAddress("Smith ","john@cs-edu");
    assertEquals("Smith ", ea.getnameOfUser()); 
}
  
  
}