package stack_queue;

public class Circular_Queue {

	static int front;
	static int rear;
	static final int capacity = 5;
	int arr[];
	
	Circular_Queue(){
		arr = new int[capacity];
		front = rear = -1;
	}
	
	public static void main(String[] args) {
		Circular_Queue q = new Circular_Queue();
		
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
		q.print();
		System.out.println(" deleted element : " + q.dequeue());
		System.out.println(" deleted element : " + q.dequeue());
		System.out.println(" deleted element : " + q.dequeue());
		System.out.println(" deleted element : " + q.dequeue());
		System.out.println(" deleted element : " + q.dequeue());
		q.enqueue(55);
		q.print();
	}

	private void print() {
		for(int i = front ; i <= rear ; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private void enqueue(int i) {
		if(isFull()) {
			System.out.println(" cant insert, queue is full ... ");
		} else {
			rear = (rear+1)%capacity;
			arr[rear] = i;
			if(front == -1) {
				front = 0;
			}
		}
	}

	private boolean isFull() {
		if(front == (rear+1)%capacity )
			return true;
		return false;
	}

	private int dequeue() {
		if(isEmpty()) {
			System.out.println("cant delete, queue is empty ... ");
			return -1;
		} else {
			int element = arr[front];
			if(front == rear)
				front = rear = -1;
			else
				front = (front + 1)%capacity;
			
			return element;
		}
	}

	private boolean isEmpty() {
		if(front == -1) 
			return true;
		return false;
	}

}
