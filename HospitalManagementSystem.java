import java.util.ArrayList;
import java.util.Scanner;

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
        System.out.println("ID       : " + id);
        System.out.println("Name     : " + name);
        System.out.println("Age      : " + age);
        System.out.println("Gender   : " + gender);
        System.out.println("Disease  : " + disease);
        System.out.println("-----------------------------");
    }
}

class Doctor {
    int id;
    String name;
    String specialization;

    Doctor(int id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }

    void display() {
        System.out.println("ID             : " + id);
        System.out.println("Name           : " + name);
        System.out.println("Specialization : " + specialization);
        System.out.println("-----------------------------");
    }
}

class Appointment {
    int appointmentId;
    int patientId;
    int doctorId;
    String date;

    Appointment(int appointmentId, int patientId, int doctorId, String date) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
    }

    void display() {
        System.out.println("Appointment ID : " + appointmentId);
        System.out.println("Patient ID     : " + patientId);
        System.out.println("Doctor ID      : " + doctorId);
        System.out.println("Date           : " + date);
        System.out.println("-----------------------------");
    }
}

public class HospitalManagementSystem {

    static ArrayList<Patient> patients = new ArrayList<>();
    static ArrayList<Doctor> doctors = new ArrayList<>();
    static ArrayList<Appointment> appointments = new ArrayList<>();

    static Scanner scanner = new Scanner(System.in);

    static int patientId = 1;
    static int doctorId = 1;
    static int appointmentId = 1;

    // Add Patient
    static void addPatient() {
        System.out.println("\n--- Add Patient ---");

        System.out.print("Enter patient name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter gender: ");
        String gender = scanner.nextLine();

        System.out.print("Enter disease: ");
        String disease = scanner.nextLine();

        Patient patient = new Patient(
                patientId++,
                name,
                age,
                gender,
                disease
        );

        patients.add(patient);

        System.out.println("Patient added successfully!");
    }

    // Add Doctor
    static void addDoctor() {
        System.out.println("\n--- Add Doctor ---");

        System.out.print("Enter doctor name: ");
        String name = scanner.nextLine();

        System.out.print("Enter specialization: ");
        String specialization = scanner.nextLine();

        Doctor doctor = new Doctor(
                doctorId++,
                name,
                specialization
        );

        doctors.add(doctor);

        System.out.println("Doctor added successfully!");
    }

    // Display Patients
    static void displayPatients() {
        System.out.println("\n--- Patient List ---");

        if (patients.isEmpty()) {
            System.out.println("No patients found.");
            return;
        }

        for (Patient patient : patients) {
            patient.display();
        }
    }

    // Display Doctors
    static void displayDoctors() {
        System.out.println("\n--- Doctor List ---");

        if (doctors.isEmpty()) {
            System.out.println("No doctors found.");
            return;
        }

        for (Doctor doctor : doctors) {
            doctor.display();
        }
    }

    // Book Appointment
    static void bookAppointment() {
        System.out.println("\n--- Book Appointment ---");

        if (patients.isEmpty() || doctors.isEmpty()) {
            System.out.println(
                    "Please add at least one patient and one doctor first."
            );
            return;
        }

        displayPatients();

        System.out.print("Enter patient ID: ");
        int pId = scanner.nextInt();

        boolean patientFound = false;

        for (Patient patient : patients) {
            if (patient.id == pId) {
                patientFound = true;
                break;
            }
        }

        if (!patientFound) {
            System.out.println("Patient not found.");
            return;
        }

        displayDoctors();

        System.out.print("Enter doctor ID: ");
        int dId = scanner.nextInt();
        scanner.nextLine();

        boolean doctorFound = false;

        for (Doctor doctor : doctors) {
            if (doctor.id == dId) {
                doctorFound = true;
                break;
            }
        }

        if (!doctorFound) {
            System.out.println("Doctor not found.");
            return;
        }

        System.out.print("Enter appointment date (DD-MM-YYYY): ");
        String date = scanner.nextLine();

        Appointment appointment = new Appointment(
                appointmentId++,
                pId,
                dId,
                date
        );

        appointments.add(appointment);

        System.out.println("Appointment booked successfully!");
    }

    // Display Appointments
    static void displayAppointments() {
        System.out.println("\n--- Appointment List ---");

        if (appointments.isEmpty()) {
            System.out.println("No appointments found.");
            return;
        }

        for (Appointment appointment : appointments) {
            appointment.display();
        }
    }

    // Main Menu
    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n================================");
            System.out.println("   HOSPITAL MANAGEMENT SYSTEM");
            System.out.println("================================");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. View Patients");
            System.out.println("4. View Doctors");
            System.out.println("5. Book Appointment");
            System.out.println("6. View Appointments");
            System.out.println("7. Exit");
            System.out.println("================================");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    addPatient();
                    break;

                case 2:
                    addDoctor();
                    break;

                case 3:
                    displayPatients();
                    break;

                case 4:
                    displayDoctors();
                    break;

                case 5:
                    bookAppointment();
                    break;

                case 6:
                    displayAppointments();
                    break;

                case 7:
                    System.out.println(
                            "Thank you for using the Hospital Management System!"
                    );
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 7);

        scanner.close();
    }
}
