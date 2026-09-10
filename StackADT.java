class MyStack {
    private int[] stack;
    private int top;
    private int size;

    // Constructor
    MyStack(int size) {
        this.size = size;
        stack = new int[size];
        top = -1;
    }

    // Push an element
    void push(int value) {
        if (top == size - 1) {
            System.out.println("Stack Overflow");
        } else {
            stack[++top] = value;
            System.out.println(value + " pushed into stack");
        }
    }

    // Pop an element
    int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        } else {
            return stack[top--];
        }
    }

    // Peek at the top element
    int peek() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            return stack[top];
        }
    }

    // Display stack
    void display() {
        if (top == -1) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Stack elements:");
            for (int i = top; i >= 0; i--) {
                System.out.println(stack[i]);
            }
        }
    }
}

public class StackADT {
    public static void main(String[] args) {
        MyStack s = new MyStack(5);

        s.push(10);
        s.push(20);
        s.push(30);

        s.display();

        System.out.println("Top element: " + s.peek());
        System.out.println("Popped element: " + s.pop());

        s.display();
    }
}
