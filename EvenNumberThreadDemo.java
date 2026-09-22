import java.util.Scanner;


class Even implements Runnable {

    private int start;
    private int end;

    
    Even(int start, int end) {
        this.start = start;
        this.end = end;
    }

    
    public void run() {

        int count = 0;
        int sum = 0;

        System.out.println("\nThread Name: " +
                Thread.currentThread().getName());

        System.out.println("Even numbers from " + start + " to " + end + ":");

        for (int i = start; i <= end; i++) {

            if (i % 2 == 0) {
                System.out.println(i);

                count++;
                sum = sum + i;

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted");
                }
            }
        }

        System.out.println("\nTotal even numbers = " + count);
        System.out.println("Sum of even numbers = " + sum);
    }
}


public class EvenNumberThreadDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("       EVEN NUMBER PROGRAM       ");
        System.out.println("================================");

        System.out.print("Enter starting number: ");
        int start = sc.nextInt();

        System.out.print("Enter ending number: ");
        int end = sc.nextInt();

    
        Even evenObject = new Even(start, end);

        
        Thread t1 = new Thread(evenObject);

        
        t1.setName("EvenNumberThread");

        System.out.println("\nStarting thread...");

        
        t1.start();

        
        try {
            t1.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }

        System.out.println("\n================================");
        System.out.println("Program completed successfully.");
        System.out.println("================================");

        sc.close();
    }
}
