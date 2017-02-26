import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

     public class QueueImplementation<E> implements Iterable<E> {

        private ArrayList<E> arr = new ArrayList<E>();
        int front;
        int rear;
        
      //constructor to create an empty queue
        public QueueImplementation() {
        	front = 0;
        	rear = -1;
        	arr = new ArrayList<E>(); 
		  }
        
        //enqueue() implementation
      //inserts element at the end of queue
        public void enqueue(E ob) {           
        	arr.add(ob);        
           rear++;
        }
        
        //dequeue() implementation
      //removes element from the front of queue
        public E dequeue() {
        	try{
        		
  			  if (isEmpty()) 
  			    	throw new Exception();  
  			 }
  			 catch(Exception e)
  			 {
  				
  				 return null;
  			 }  	
           return arr.remove(front);
          
        }
        
       // front() implementation 
      //returns the element from front
       public E front()
       {  
    	   try {
			  if (isEmpty()) 
				  
			    	throw new Exception();  
			 }
    	   
			 catch(Exception e)
			 {
				
				 return null;
			 }
    	   return arr.get(front);
       }
       
       //isEmpty() implementation
   //  checking if the queue is empty or not.
       public boolean isEmpty() {
            
          return arr.isEmpty();
       }
       
       //iterator() implementation
    // Iterator to iterate through the given queue
       public Iterator<E> iterator()
		  {
			  return new Iterator<E>()
					  { 
				  
						  public boolean hasNext()  { 
							  if((front >= arr.size()) )
							      {
								      return false;
							      }
								  else
							     {
							          return true;  
								 }
									  
							  
							  }
					        public void remove()      { 
					        	throw new UnsupportedOperationException();  
					        	}

					        public E next() {
					            if (!hasNext()) throw new NoSuchElementException();
					            E item =arr.get(front);
					        
					            front++; 
					            return item;
					        }
					  };
					 
			  
		  }
     } 
