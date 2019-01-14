package stack_queue;

public class Stack {

	static final int MAX = 1000;
	int top ;
	int array[] = new int[MAX];

	Stack() {
		top = -1;
	}

	public static void main(String[] args) {
		Stack s = new Stack();
		s.push(10);
		s.push(20);
		s.push(30);
		s.print();
		System.out.println();
		System.out.print(" Popped item " + s.pop());
		System.out.println();
		s.print();
	}
	private void print() {
		for(int i = 0 ; i <= top ; i++) {
			System.out.print(array[i] + " ");
		}
	}

	private int pop() {
		if(underflow()) {
			return 0;
		} else {
			int p = array[top--];
			return p;
		}
	}
	
	private void push(int i) {
		if(overflow()) {
			System.out.println("Cant insert, overflow ...");
			return;
		} else {
			array[++top] = i;
		}
	}

	private boolean overflow() {
		if(top >= (MAX-1) ) {
			return true;
		}	else {
			return false;
		}
	}
	private boolean underflow() {
		if(top < 0) {
			return true;
		}	else {
			return false;
		}
	}
}
