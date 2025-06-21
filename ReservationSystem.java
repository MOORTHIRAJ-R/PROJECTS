package system;
import java.util.ArrayList;
		import java.util.List;
		import java.util.Scanner;


		

		public class ReservationSystem {
		    private List<Train> trains;

		    public ReservationSystem() {
		        trains = new ArrayList<>();
		        trains.add(new Train("12345", "Express Train", 50));
		        trains.add(new Train("67890", "Superfast Train", 30));
		    }

		    public void viewTrains() {
		        for (Train train : trains) {
		            System.out.println("Train Number: " + train.getTrainNumber());
		            System.out.println("Train Name: " + train.getTrainName());
		            System.out.println("Available Seats: " + train.getAvailableSeats());
		            System.out.println();
		        }
		    }

		    public void bookTicket(String trainNumber) {
		        for (Train train : trains) {
		            if (train.getTrainNumber().equals(trainNumber)) {
		                train.bookTicket();
		                System.out.println("Ticket booked successfully on train -" + train.getTrainName());
		                return;
		            }
		        }
		        System.out.println("Train not found . ");
		    }

		    public static void main(String[] args) {
		        Scanner scanner = new Scanner(System.in);
		        ReservationSystem system = new ReservationSystem();
		        while (true) {
		            System.out.println("1. View Trains");
		            System.out.println("2. Book Ticket");
		            System.out.println("3. Exit");
		            System.out.print  ("Enter your choice: ");
		            int choice = scanner.nextInt();
		            scanner.nextLine();  // Consume newline

		            switch (choice) {
		                case 1:
		                    system.viewTrains();
		                    break;
		                case 2:
		                    System.out.print("Enter train number to book: ");
		                    String trainNumber = scanner.nextLine();
		                    system.bookTicket(trainNumber);
		                    break;
		                case 3:
		                    System.out.println("Exiting...");
		                    return;
		                default:
		                    System.out.println("Invalid choice, please try again.");
		            }
		        }
		    }
		

	}


