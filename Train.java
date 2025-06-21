package system;

public class Train {

	
		    private String trainNumber;
		    private String trainName;
		    private int availableSeats;

		    public Train(String trainNumber, String trainName, int availableSeats) {
		        this.trainNumber = trainNumber;
		        this.trainName = trainName;
		        this.availableSeats = availableSeats;
		    }

		    public String getTrainNumber() {
		        return trainNumber;
		    }

		    public String getTrainName() {
		        return trainName;
		    }

		    public int getAvailableSeats() {
		        return availableSeats;
		    }

		    public void bookTicket() {
		        if (availableSeats > 0) {
		            availableSeats--;
		        } else {
		            System.out.println("No seats available.");
		        }
		    }
		

		// ReservationSystem.java
		

	}


