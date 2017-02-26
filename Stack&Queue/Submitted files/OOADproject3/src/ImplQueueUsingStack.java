import java.util.Iterator;


public class ImplQueueUsingStack<E>{
	 private StackImplementation<E> backStack ;
	 private StackImplementation<E> frontStack ;
	 
	 ImplQueueUsingStack()
	 {
		 backStack = new StackImplementation<E>();
		 frontStack = new StackImplementation<E>();
	 }
	 // to add an item to back of queue.
	 public void enqueue(E ob) {   
		 if(backStack.isEmpty()){
			 backStack.push(ob);
	        }
		 else{
	            while(!backStack.isEmpty()){
	            	frontStack.push(backStack.pop());
	            }
	 
	            backStack.push(ob);
	 
	            while(!frontStack.isEmpty()){
	            	backStack.push(frontStack.pop());
	            }    
	        }        
    }
	 // to remove an item from front of queue.
	 public E dequeue() {
		 E front = null;	 
			 try{
				 if(backStack.isEmpty()&& frontStack.isEmpty()) 
	  			    	throw new Exception();  
	  			 }
	  			 catch(Exception e)
	  			 {
	  				 
	  				 return front;
	  			 }  
       	
			 front = backStack.pop();
       return front;    
    }
	 
	 // To return front element
	 public E front() {
		 E front=null;
		 try{
			 if(backStack.isEmpty()) 
  			    	throw new Exception();  
  			 }
  			 catch(Exception e)
  			 {
  				
  				 return front;
  			 }      
		 front=backStack.top();	 
             	
       return front;  
       }
	 
	 // Test if the queue is empty.
	 public boolean isEmpty() 
	 {
        if(backStack.isEmpty() && frontStack.isEmpty())
        	return true;
        else 
        	return false;       
    }
	 
	 // to iterate through the given queue
	 public Iterator<E> iterator()
	  {
		
		 return backStack.iterator();
		  				 		  
	  }
}
