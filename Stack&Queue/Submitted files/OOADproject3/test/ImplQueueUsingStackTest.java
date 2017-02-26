import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;


public class ImplQueueUsingStackTest {
	ImplQueueUsingStack<Student> StudentQueueImplementation;
	
	@Before
	public void setUp() {
		StudentQueueImplementation = new ImplQueueUsingStack<Student>();
	}
	
	@Test // Test for enqueue()
	public void testEnqueue() {
		Student s1 = new Student("jyothi","reddy");
		StudentQueueImplementation.enqueue(s1);
		assertEquals(s1,StudentQueueImplementation.dequeue());	
		
	}
	
	@Test // Test for Dequeue()
	public void testDequeue() {
		Student s2 = new Student("harsha","sonu");
		StudentQueueImplementation.enqueue(s2);
		assertEquals(s2,StudentQueueImplementation.dequeue());		
	}
	
	@Test // Test for front() 
	public void testFront() {
		
		assertEquals(null,StudentQueueImplementation.front());	
		
	}

	@Test // Test for isEmpty()
	public void testIsEmpty() {
		assertTrue(StudentQueueImplementation.isEmpty());
		Student s=new Student("krishna","rao");
		
		StudentQueueImplementation.enqueue(s);
		assertFalse(StudentQueueImplementation.isEmpty());	
		
	}
	
	@Test // Test iterator() 
	public void testQueueIterator(){
		Student s1 = new Student("swathi","bala");	
		Student s2 = new Student("rama","srinu");
		Student s3 = new Student("devi","tinku");
		
		StudentQueueImplementation.enqueue(s1);
		StudentQueueImplementation.enqueue(s2);
		StudentQueueImplementation.enqueue(s3);
		
     	Iterator<Student> Itr =StudentQueueImplementation.iterator();
     	assertTrue(Itr.hasNext());
     	
     		Student record = Itr.next();
     		
     		assertEquals(s1,record);
     		assertTrue(Itr.hasNext());
     		 record = Itr.next();
     		
     		assertEquals(s2,record);
     		assertTrue(Itr.hasNext());
     		 record = Itr.next();
     		assertEquals(s3,record);
     		
     	
     	if(Itr.hasNext())
     	{  		
     		assertTrue(false);
     	}
		
	}	

}
