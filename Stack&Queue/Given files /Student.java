// Student.java

/** Abstraction of a Student entity */

public class Student {
  private String firstName;
  private String lastName;

  /** Initialize a Student
      @param first firstName
      @param last lastName
    */
  public Student(String first, String last) {
	  firstName = first;
	  lastName = last;
  }

  /** Mutator Method
      @param aName firstName
    */
  public void setFirstName(String aName) {
	  firstName = aName;
  }

  /** Accessor Method
      @return firstName of this Employee
    */
  public String getFirstName() {
	  return firstName;
  }

  /** Mutator Method
      @param aName lastName
    */
  public void setLastName(String aName) {
  	  lastName = aName;
    }

  /** Accessor Method
      @return lastName of this Employee
    */
  public String getLastName() {
  	  return lastName;
  }

  @Override
  public String toString() {
	  String str = "";
	  str += (firstName + " " + lastName);
	  return str;
  }

  /* this version overloads the equals method (note the
     signature of this method).  Overloading this method
     is no use (as we found out in class today) since
     indexOf and contains do not use this method with Student
     as a parameter
   */
  public boolean equals(Student s) {
  	  return ( (this.lastName.equalsIgnoreCase(s.lastName)) &&
  	           (this.firstName.equalsIgnoreCase(s.firstName)));

  }

  /* We need to override this method so indexOf and
     contains methods work.  Both of them use this version
     equals method
   */
  @Override
  public boolean equals(Object obj) {
	     if (!(obj instanceof Student)) return false;
	     else {
			 Student s = (Student) obj;
			 return ( this.equals(s));  // calls the equals(Student) method
	     }
  }
}
