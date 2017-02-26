import static org.junit.Assert.*;

import java.util.Iterator;
import org.junit.*;


public class StackImplementationTest {
	StackImplementation<Student> StudentStackImplementation;
	
	@Before
	public void setUp() {
		StudentStackImplementation = new StackImplementation<Student>();
	}
	
		@Test //Test for pop()
		public void testPop() {
			Student s=new Student("swapna","revanth");	
			StudentStackImplementation.push(s);
			assertTrue(true);
			assertEquals(s,StudentStackImplementation.pop());
		}
		
		
		@Test //Test for push()
		public void testPush() {
			Student r = new Student("sai","rohanth");	
			StudentStackImplementation.push(r);
			assertTrue(true);
			assertEquals(r,StudentStackImplementation.top());	
		}
		
		@Test // Test for isEmpty()
		public void testIsEmpty() {
			
			assertTrue(StudentStackImplementation.isEmpty());
			
			Student t = new Student("lakshith","kumar");	
			StudentStackImplementation.push(t);
			assertFalse(StudentStackImplementation.isEmpty());	
		}
	 
	@Test 
	public void testStackIterator(){
		Student s1=new Student("sri","nithya");	
		Student s2=new Student("sri","vineela");
		
		
		StudentStackImplementation.push(s1);
		StudentStackImplementation.push(s2);
		
		
     	Iterator<Student> Itr=StudentStackImplementation.iterator();
     	
     	
     	
     	if(Itr.hasNext())
     	{
     		Student record = Itr.next();
     		assertEquals(s2,record);
     	}
     	
     	if(Itr.hasNext())
     	{
     		Student record = Itr.next();
     		assertEquals(s1,record);
     	}
     	if(Itr.hasNext())
     	{
     		assertTrue(false);
     	}
		
	}				
}
