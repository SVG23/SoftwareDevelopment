
import java.util.Iterator;


public class ImplStackUsingQueue<E> implements Iterable<E>{
	private QueueImplementation<E> Queue1 ;
	private QueueImplementation<E> Queue2 ;
	 
	 // Constructor for creating an empty stack
	 ImplStackUsingQueue()
	 {
		 Queue1 = new QueueImplementation<E>();
		 Queue2 = new QueueImplementation<E>();
	 }
	 
	 // pushes an elements onto the top of the stack
	 public void push(E ob) {
		 if(Queue1.isEmpty()) {
			 Queue1.enqueue(ob); 
			}
		 else {
				while(!Queue1.isEmpty()) {
					
					E temp = Queue1.dequeue();
					Queue2.enqueue(temp); 
				}
		 
				Queue1.enqueue(ob);
				
				while(!Queue2.isEmpty()) {
					E temp = Queue2.dequeue();
					Queue1.enqueue(temp); 
				}
			}
   }
	 // removes top elements of the stack
	 public E pop() {
		 try{
 			  if (isEmpty()) 
 			    	throw new Exception();  
 			 }
 			 catch(Exception e)
 			 {
 				 return null;
 			 } 
		 return Queue1.dequeue();
		 
    }
	 
	 //Returns the top elements
	 public E top() {
		 try{
			  if (isEmpty()) 
			    	throw new Exception();  
			 }
			 catch(Exception e)
			 {
				 
				 return null;
			 }
		 return Queue1.front();
		 
    }
	 
	
	 public boolean isEmpty()
	  {
		  return Queue1.isEmpty();
		  
	  }
	 
	 
	 public Iterator<E> iterator()
	  {
		 return Queue1.iterator();
		 			 	  
	  }
}

