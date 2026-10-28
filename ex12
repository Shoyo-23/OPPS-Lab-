import java.util.ArrayList;
import java.util.Scanner;

// ---------------- PATIENT CLASS ----------------
class Patient {
    int id;
    String name;
    int age;
    String gender;
    String disease;

    Patient(int id, String name, int age, String gender, String disease) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.disease = disease;
    }

    void display() {
        System.out.println("----------------------------------");
        System.out.println("Patient ID : " + id);
        System.out.println("Name       : " + name);
        System.out.println("Age        : " + age);
        System.out.println("Gender     : " + gender);
        System.out.println("Disease    : " + disease);
        System.out.println("----------------------------------");
    }
}

// ---------------- BILL CLASS ----------------
class Bill {
    int billNo;
    Patient patient;

    double roomCharge;
    double doctorCharge;
    double medicineCharge;
    double testCharge;
    double discount;

    Bill(int billNo, Patient patient) {
        this.billNo = billNo;
        this.patient = patient;
    }

    double getSubtotal() {
        return roomCharge + doctorCharge
                + medicineCharge + testCharge;
    }

    double getDiscountAmount() {
        return getSubtotal() * discount / 100;
    }

    double getGST() {
        double amountAfterDiscount =
                getSubtotal() - getDiscountAmount();

        return amountAfterDiscount * 0.05;
    }

    double getFinalBill() {
        return getSubtotal()
                - getDiscountAmount()
                + getGST();
    }

    void printBill() {

        System.out.println("\n========================================");
        System.out.println("             HOSPITAL BILL");
        System.out.println("========================================");

        System.out.println("Bill Number : " + billNo);
        System.out.println("Patient ID  : " + patient.id);
        System.out.println("Patient     : " + patient.name);
        System.out.println("Age         : " + patient.age);
        System.out.println("Gender      : " + patient.gender);
        System.out.println("Disease     : " + patient.disease);

        System.out.println("----------------------------------------");

        System.out.printf("Room Charges       : %.2f%n", roomCharge);
        System.out.printf("Doctor Charges     : %.2f%n", doctorCharge);
        System.out.printf("Medicine Charges   : %.2f%n", medicineCharge);
        System.out.printf("Test Charges       : %.2f%n", testCharge);

        System.out.println("----------------------------------------");

        System.out.printf("Subtotal           : %.2f%n",
                getSubtotal());

        System.out.printf("Discount (%.1f%%)   : %.2f%n",
                discount, getDiscountAmount());

        System.out.printf("GST (5%%)           : %.2f%n",
                getGST());

        System.out.println("----------------------------------------");

        System.out.printf("TOTAL BILL         : %.2f%n",
                getFinalBill());

        System.out.println("========================================");
    }
}

// ---------------- MAIN CLASS ----------------
public class HospitalBillingSystem {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Patient> patients =
            new ArrayList<>();

    static ArrayList<Bill> bills =
            new ArrayList<>();

    static int patientId = 1001;
    static int billNumber = 5001;


    // -------- REGISTER PATIENT --------
    static void registerPatient() {

        System.out.println("\n========== PATIENT REGISTRATION ==========");

        System.out.print("Enter patient name: ");
        String name = sc.nextLine();

        System.out.print("Enter age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter gender: ");
        String gender = sc.nextLine();

        System.out.print("Enter disease: ");
        String disease = sc.nextLine();

        Patient p = new Patient(
                patientId,
                name,
                age,
                gender,
                disease
        );

        patients.add(p);

        System.out.println("\nPatient registered successfully!");
        System.out.println("Patient ID: " + patientId);

        patientId++;
    }


    // -------- VIEW PATIENTS --------
    static void viewPatients() {

        System.out.println("\n========== PATIENT LIST ==========");

        if (patients.isEmpty()) {
            System.out.println("No patients registered.");
            return;
        }

        for (Patient p : patients) {
            p.display();
        }
    }


    // -------- SEARCH PATIENT --------
    static Patient searchPatient() {

        System.out.print("\nEnter Patient ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Patient p : patients) {

            if (p.id == id) {
                return p;
            }
        }

        return null;
    }


    // -------- CREATE BILL --------
    static void createBill() {

        System.out.println("\n========== CREATE BILL ==========");

        if (patients.isEmpty()) {
            System.out.println("No patients available.");
            return;
        }

        Patient p = searchPatient();

        if (p == null) {
            System.out.println("Patient not found.");
            return;
        }

        Bill bill = new Bill(billNumber, p);

        System.out.println("\nEnter billing details:");

        // Room
        System.out.print("Enter number of days stayed: ");
        int days = sc.nextInt();

        System.out.print("Enter room charge per day: ");
        double roomPerDay = sc.nextDouble();

        bill.roomCharge = days * roomPerDay;


        // Doctor
        System.out.print("Enter doctor consultation charge: ");
        bill.doctorCharge = sc.nextDouble();


        // Medicine
        System.out.print("Enter medicine charges: ");
        bill.medicineCharge = sc.nextDouble();


        // Tests
        System.out.print("Enter laboratory test charges: ");
        bill.testCharge = sc.nextDouble();


        // Discount
        System.out.print("Enter discount percentage: ");
        bill.discount = sc.nextDouble();

        bills.add(bill);

        System.out.println("\nBill generated successfully!");

        bill.printBill();

        billNumber++;
    }


    // -------- VIEW BILL --------
    static void viewBill() {

        System.out.println("\n========== BILL LIST ==========");

        if (bills.isEmpty()) {
            System.out.println("No bills generated.");
            return;
        }

        System.out.print("Enter Bill Number: ");
        int number = sc.nextInt();

        for (Bill b : bills) {

            if (b.billNo == number) {
                b.printBill();
                return;
            }
        }

        System.out.println("Bill not found.");
    }


    // -------- MAIN MENU --------
    static void menu() {

        while (true) {

            System.out.println("\n");
            System.out.println("========================================");
            System.out.println("       HOSPITAL BILLING SYSTEM");
            System.out.println("========================================");

            System.out.println("1. Register Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Search Patient");
            System.out.println("4. Generate Bill");
            System.out.println("5. View Bill");
            System.out.println("6. Exit");

            System.out.println("========================================");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    registerPatient();
                    break;

                case 2:
                    viewPatients();
                    break;

                case 3:

                    Patient p = searchPatient();

                    if (p != null) {
                        System.out.println("\nPatient Found!");
                        p.display();
                    } else {
                        System.out.println("Patient not found.");
                    }

                    break;

                case 4:
                    createBill();
                    break;

                case 5:
                    viewBill();
                    break;

                case 6:

                    System.out.println(
                            "\nThank you for using Hospital Billing System!"
                    );

                    sc.close();
                    return;

                default:
                    System.out.println(
                            "Invalid choice. Please try again."
                    );
            }
        }
    }


    // -------- MAIN METHOD --------
    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("      WELCOME TO CITY HOSPITAL");
        System.out.println("       BILLING MANAGEMENT SYSTEM");
        System.out.println("========================================");

        menu();
    }
}
