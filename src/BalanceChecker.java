import java.io.File;
import java.io.FileNotFoundException;
import java.util.EmptyStackException;
import java.util.Scanner;

public class BalanceChecker {
	
	String _s;
	File _f;
	
	public BalanceChecker(String newS) {
		_s = cleanStr(newS);
		
	}
	
	public BalanceChecker(File newFile) {
		_f = newFile;
		try {
			String result = "";
			Scanner s = new Scanner(_f);
			while(s.hasNextLine()) {
				result += this.cleanStr(s.nextLine());
			}
			_s = result;
	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	private class MyStack<E> implements AStack<E> {

		
		E[] stack;
		int size;
		public MyStack() {
			stack = (E[]) new Object[100];
			size = -1;
		}
		
		public boolean isEmpty() {
			return size == -1;
		}

		
		public void push(E element) {
			size++;
			stack[size] = element;		
		}

		public E peek() throws EmptyStackException {
			if(!this.isEmpty()) {
				return stack[size];
			} else {
				throw new EmptyStackException();
			}
		}

	
		public E pop() throws EmptyStackException {
			if(!this.isEmpty()) {
				E temp = stack[size];
				stack[size] = null;
				size--;
				return temp;
			}
			throw new EmptyStackException();
		}
		
	}
	
	public boolean checkBalance() {
		MyStack<Character> stack = new MyStack<Character>();
		int index = 0;
		
		if(_s.length() < 2 || !isClosing(_s.charAt(_s.length()-1)) ) return false;
	
			while((index < _s.length())) {
				char currentChar = _s.charAt(index);
				if(!isClosing(currentChar)) {
					System.out.println("Opening" + currentChar);
					stack.push(currentChar);
					index++;
				} else {
					if(stack.isEmpty() || inverseChar(currentChar) != stack.peek()) {
						return false;
					}
					System.out.println("Closing" + currentChar);
					stack.pop();	
					index++;
				}
			
			
		}
		
		
		return true;
		
	}
	
	private char inverseChar(char c) {
		if(c == ')') {
			return '(';
		} else if(c == '}') {
			return '{';
		} else if(c == ']') {
			return '[';
		} else if(c == '>') {
			return '<';
		}
		
		
		return ' ';
	}
	
	private boolean isClosing(char c) {
		if(c == ')' || c == '}' || c == ']' || c == '>') {
			return true;
		} else {
			return false;
		}
	}
	public String cleanStr(String s) {
		String result = "";
		for(int i = 0; i < s.length(); i++) {
			if(isClosing(s.charAt(i)) || s.charAt(i) == '(' || s.charAt(i) == '{' 
					|| s.charAt(i) == '[' || s.charAt(i) == '<') {
				result += s.charAt(i);
			}
		}
		
		
		return result;
		
	}
	
	public void set(String s) {
		_s = cleanStr(s);
	}

	public static void main(String[] args) {
		
				File file = new File("test.txt");
				BalanceChecker b = new BalanceChecker(file);
				System.out.println(b.checkBalance());
				
				
				
		/*
		BalanceChecker b = new BalanceChecker("(<>())");
		//b.set("<a[b{c(d)e}f]>");
		//b.set("()<>{}[]");
		//b.set("(((())))");
		//b.set("function blah() {return \"\";}");
		System.out.println(b.checkBalance());
		*/
	}
}

