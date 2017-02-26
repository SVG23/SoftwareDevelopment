import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;


public class QueueImplementationTest {

	QueueImplementation<Student> StudentQ;
	
	@Before
	public void setUp() {
		StudentQ = new QueueImplementation<Student>();
	}
	
	
	@Test // Test for enqueue()
	public void testEnqueue() {
		Student s1 = new Student("vinya","garapati");
		StudentQ.enqueue(s1);
		assertEquals(s1,StudentQ.dequeue());	
		
	}
	
	
	@Test // Test for Dequeue()
	public void testDequeue() {
		Student s1 = new Student("vinya","godavarthi");
		StudentQ.enqueue(s1);
		assertEquals(s1,StudentQ.dequeue());	
		
	}
	
	@Test // test Dequeue() when empty
	public void testDequeueWhenEmpty() {
		
		assertEquals(null,StudentQ.dequeue());	
		
	}
	
	
	@Test // Test for isEmpty() 
	public void testIsEmpty() {
		assertTrue(StudentQ.isEmpty());
		Student s1=new Student("vinya","sri");		
		StudentQ.enqueue(s1);
		assertFalse(StudentQ.isEmpty());	
		
	}
	
	@Test // test for front() 
	public void testFront() {
		
		Student s1=new Student("sri","vinya");		
		StudentQ.enqueue(s1);
     	assertEquals(s1,StudentQ.front());
		
		
	}
	
	@Test // test for front() when empty
	public void testFrontWhenEmpty() {
		
		assertEquals(null,StudentQ.front());	
		
	}
	
	
	@Test // Test iterator() method
	public void testQueueIterator(){
		
		Student s1=new Student("sri","vinya");	
		Student s2=new Student("garapati","godavarthi");
		
		StudentQ.enqueue(s1);
		StudentQ.enqueue(s2);
		
     	Iterator<Student> QueueItr=StudentQ.iterator();
     	assertTrue(QueueItr.hasNext());   	
     		Student record=QueueItr.next();
     		
     		assertEquals(s1,record);     	
     		assertTrue(QueueItr.hasNext());    	
     		 record=QueueItr.next();
     		
     		
     		assertEquals(s2,record);
     	
     	if(QueueItr.hasNext())
     	{  		
     		assertTrue(false);
     	}
     	
		
	}
	
}

