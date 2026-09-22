class SharedResource {

    private int data;
    private boolean available = false;

    // Producer method
    public synchronized void produce(int value) {

        while (available) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }

        data = value;
        System.out.println("Produced: " + data);

        available = true;
        notify();
    }

    // Consumer method
    public synchronized void consume() {

        while (!available) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }

        System.out.println("Consumed: " + data);

        available = false;
        notify();
    }
}


// Producer class
class Producer implements Runnable {

    private SharedResource resource;

    public Producer(SharedResource resource) {
        this.resource = resource;
    }

    public void run() {

        for (int i = 1; i <= 5; i++) {

            resource.produce(i);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}


// Consumer class
class Consumer implements Runnable {

    private SharedResource resource;

    public Consumer(SharedResource resource) {
        this.resource = resource;
    }

    public void run() {

        for (int i = 1; i <= 5; i++) {

            resource.consume();

            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}


// Main class
public class ProducerConsumerDemo {

    public static void main(String[] args) {

        SharedResource resource = new SharedResource();

        Producer producer = new Producer(resource);
        Consumer consumer = new Consumer(resource);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.setName("ProducerThread");
        consumerThread.setName("ConsumerThread");

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }

        System.out.println("Program completed successfully.");
    }
}
