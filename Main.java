import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

// Class Date for representing dates
class Date implements Comparable<Date> {
    private int day;
    private int month;
    private int year;

    // Constructor: initializes a Date object after checking validity
    public Date(int day, int month, int year) {
        if (isValidDate(day, month, year)) {
            this.day = day;
            this.month = month;
            this.year = year;
        } else {
            throw new IllegalArgumentException("Error: Invalid date!");
        }
    }

    // Checks if a date is valid
    public boolean isValidDate(int day, int month, int year) {
        if (month < 1 || month > 12 || day < 1) return false; // Month must be 1-12, day >= 1

        // Days in each month (non-leap year)
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // In a leap year, February has 29 days
        if (isLeapYear(year)) {
            daysInMonth[1] = 29;
        }

        return day <= daysInMonth[month - 1]; // Check if the day is valid for the month
    }

    // Checks if a year is a leap year
    public boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Returns the day of the week (e.g., "Monday")
    public String getDayOfWeek() {
        LocalDate date = LocalDate.of(year, month, day);
        return date.getDayOfWeek().toString();
    }

    // Calculates the difference in days between two dates
    public long calculateDifference(Date otherDate) {
        LocalDate currentDate = LocalDate.of(year, month, day);
        LocalDate other = LocalDate.of(otherDate.year, otherDate.month, otherDate.day);
        return ChronoUnit.DAYS.between(currentDate, other);
    }

    // Prints the date in a readable format (e.g., "15 August 2022")
    public void printDate() {
        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        System.out.println(day + " " + months[month - 1] + " " + year);
    }

    // Compares two dates for sorting (by year, then month, then day)
    @Override
    public int compareTo(Date other) {
        if (this.year != other.year) return this.year - other.year;
        if (this.month != other.month) return this.month - other.month;
        return this.day - other.day;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner for user input
        List<Date> dates = new ArrayList<>(); // List to store dates

        try {
            // Ask for the number of dates
            System.out.print("Enter the number of dates to process: ");
            int numDates = scanner.nextInt();

            // Ensure at least one date is entered
            if (numDates <= 0) {
                throw new IllegalArgumentException("Error: Number of dates must be greater than zero.");
            }

            // Input multiple dates
            for (int i = 1; i <= numDates; i++) {
                System.out.println("\nEnter date " + i + ":");
                System.out.print("Day: ");
                int day = scanner.nextInt();
                System.out.print("Month: ");
                int month = scanner.nextInt();
                System.out.print("Year: ");
                int year = scanner.nextInt();

                // Create a Date object and add it to the list
                Date date = new Date(day, month, year);
                dates.add(date);
            }

            // Print entered dates
            System.out.println("\nEntered dates:");
            for (Date d : dates) {
                d.printDate();
            }

            // Compute differences between the first date and others
            if (dates.size() > 1) {
                System.out.println("\nDay of the week for the first date: " + dates.get(0).getDayOfWeek());

                for (int i = 1; i < dates.size(); i++) {
                    System.out.println("Difference in days between date 1 and date " + (i + 1) + ": " +
                            dates.get(0).calculateDifference(dates.get(i)));
                }
            }

            // Sort the dates in ascending order (earliest first)
            Collections.sort(dates);
            System.out.println("\nSorted dates:");
            for (Date d : dates) {
                d.printDate();
            }

        } catch (Exception e) { // Handle errors (e.g., invalid input)
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close(); // Close scanner to prevent resource leaks
            System.out.println("Program completed.");
        }
    }
}