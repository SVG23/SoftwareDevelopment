import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;


public class ImplStackUsingQueueTest {

	ImplStackUsingQueue<Student> StudentStackImplementation;
	
	@Before
	public void setUp() {
		StudentStackImplementation = new ImplStackUsingQueue<Student>();
	}

	
		@Test //Test for push()
		public void testPush() {
			Student s1 = new Student("ravi","shankar");	
			StudentStackImplementation.push(s1);
			assertTrue(true);
			assertEquals(s1,StudentStackImplementation.top());	
		}
		
		 
		@Test //Test for pop()
		public void testPop() {
			Student s4 = new Student("keerthi","reddy");	
			StudentStackImplementation.push(s4);
			assertTrue(true);	
			assertEquals(s4,StudentStackImplementation.pop());
		}
	
		
		
		@Test // Test for isEmpty()
		public void testIsEmpty() {
			
			assertTrue(StudentStackImplementation.isEmpty());
			Student s = new Student("sudeep","reddy");	
			StudentStackImplementation.push(s);
			assertFalse(StudentStackImplementation.isEmpty());	
		}
		
		 
		@Test // Test Get() method
		public void testStackIterator(){
			Student s1=new Student("ravi","vinya");	
			Student s2=new Student("abhilash","garapati");
			Student s3=new Student("bala","padma");
			
			StudentStackImplementation.push(s1);
			StudentStackImplementation.push(s2);
			StudentStackImplementation.push(s3);
			
	     	Iterator<Student> Itr = StudentStackImplementation.iterator();
	     	assertTrue(Itr.hasNext());
	     	
	     		Student record = Itr.next();
	     		assertEquals(s3,record);
	     	
	     		assertTrue(Itr.hasNext());
	     		 record = Itr.next();
	     		assertEquals(s2,record);
	     	
	     		assertTrue(Itr.hasNext());
	     	
	     		 record = Itr.next();
	     		assertEquals(s1,record);
	     	
	     	if(Itr.hasNext())
	     	{
	     		
	     		assertTrue(false);
	     	}			
		}	
}
