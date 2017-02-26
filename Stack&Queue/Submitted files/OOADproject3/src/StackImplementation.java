

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class StackImplementation<E> implements Iterable<E> {	
	
		 private int top;
		  private ArrayList<E> stackList;
		  
		  // Constructor to create an empty stack
		  public StackImplementation() {
		    top = -1;
		    stackList = new ArrayList<E>(); 
		  }
		  
		  // pop() implementation
		// Removes the top element of the stack
		  public E pop(){		
			  try{
				  if (top == -1) 
				    	throw new Exception();  
				 }
				 catch(Exception e)
				 {
					 return null;
				 }
			  
		    E temp= stackList.get(top);
		    stackList.remove(top);
		    top--;
		    return temp; 
		  }
		  
		  // Push() implementation
		  //inserts values on top of the stack
		  public void push(E pushValue){		    				
			  stackList.add(pushValue); 
		    top++;
		   
		  }
		 
		  //top() implementation
		 // returns top elements of the stack
		  public E top(){
			 try{
			  if (top == -1) 
			    	throw new Exception();  
			 }
			 catch(Exception e)
			 {
				 
				 return null;
			 }
			 
			  
			  return stackList.get(top);
			  
			  }
		  
		  //isEmpty() implementation
		  // Checking whether the stack is empty or not
		  public boolean isEmpty()
		  {
			  return stackList.isEmpty();
			  
		  }
		  
		  // iterator() implementation
		  // Iterator to iterate through the given stack
		  public Iterator<E> iterator()
		  
		  {
			  return new Iterator<E>()
					  {
						
						  public boolean hasNext()  { 
							  if (top == -1)
							  {
						
								  return false;
							  }
							  else{
							 
								  return true;
							  }
							  }
						  
					        public void remove(){ 
					        	throw new UnsupportedOperationException(); 
					        	}

					        public E next() {
					            if (!hasNext()) throw new NoSuchElementException();
					            E item =stackList.get(top);					            
					            top--; 
					            return item;
					        }
					  };
					 
			  
		  }
		}


