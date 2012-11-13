import java.util.EmptyStackException;

public interface AStack<E> {
	
	public boolean isEmpty();
	
	public void push(E element);
	
	public E peek() throws EmptyStackException;
	
	public E pop() throws EmptyStackException;
	
}