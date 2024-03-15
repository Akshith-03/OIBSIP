import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
class OnlineReservation {
    private static boolean[] seats = new boolean[10]; 
    private static Map<String, String> users = new HashMap<>(); 
    private static Map<String, String> reservations = new HashMap<>(); 
     public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. View Seat Map");
            System.out.println("4. Reserve Seat");
            System.out.println("5. Cancel Reservation");
            System.out.println("6. Exit");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    login(scanner);
                    break;

                case 2:
                    register(scanner);
                    break;

                case 3:
                    viewSeatMap();
                    break;

                case 4:
                    reserveSeat(scanner);
                    break;

                case 5:
                    cancelReservation(scanner);
                    break;

                case 6:
                    System.exit(0); 

                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private static void viewSeatMap() {
        System.out.println("\nCurrent Seat Map:");
        for (int i = 0; i < seats.length; i++) {
            if (seats[i]) {
                System.out.print("X "); 
            } else {
                System.out.print((i + 1) + " "); 
            }
        }
        System.out.println();
    }

    private static void reserveSeat(Scanner scanner) {
        System.out.println("\nEnter passenger details:");
        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("Source: ");
        String source = scanner.next();
        System.out.print("Destination: ");
        String destination = scanner.next();

        System.out.print("\nEnter seat number (1-10): ");
        int seatNumber = scanner.nextInt();
        if (seatNumber < 1 || seatNumber > 10) {
            System.out.println("Invalid seat number!");
        } else if (seats[seatNumber - 1]) {
            System.out.println("Seat already reserved!");
        } else {
            seats[seatNumber - 1] = true; 
            reservations.put(name, "Seat: " + seatNumber + ", Source: " + source + ", Destination: " + destination);
            System.out.println("Seat reserved!");
        }
    }

    private static void cancelReservation(Scanner scanner) {
        System.out.print("\nEnter passenger name: ");
        String name = scanner.next();
        if (!reservations.containsKey(name)) {
            System.out.println("Passenger does not have any reservation!");
        } else {
            String reservationDetails = reservations.get(name);
            String[] parts = reservationDetails.split(", ");
            String seat = parts[0].split(": ")[1];
            seats[Integer.parseInt(seat) - 1] = false; 
            reservations.remove(name); 
            System.out.println("Reservation canceled for " + name + "!");
        }
    }

    private static void login(Scanner scanner) {
        System.out.println("\nLogin:");
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();

        if (users.containsKey(username) && users.get(username).equals(password)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid username or password!");
        }
    }

    private static void register(Scanner scanner) {
        System.out.println("\nRegister:");
        System.out.print("Enter username: ");
        String username = scanner.next();

        if (users.containsKey(username)) {
            System.out.println("Username already exists!");
            return;
        }

        System.out.print("Enter password: ");
        String password = scanner.next();
        users.put(username, password);
        System.out.println("Registration successful!");
    }
}
