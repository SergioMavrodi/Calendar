# Date Class Implementation in Java

This Java program implements a `Date` class to represent and manipulate dates, along with a `Main` class to demonstrate its functionality. The program allows users to input dates, validate them, perform operations like calculating differences between dates, and sort a list of dates.

## Overview

The program consists of two main components:
- **Date Class**: Represents a date with day, month, and year attributes, implementing the `Comparable<Date>` interface for sorting.
- **Main Class**: Provides a user interface to input dates, test the `Date` class functionality, and display results.

## Features

1. **Date Validation**:
   - Checks if a date is valid, considering month ranges (1-12), day ranges (1-31 based on the month), and leap years (February 29 is valid only in leap years).
   - Throws an `IllegalArgumentException` for invalid dates.

2. **Leap Year Handling**:
   - Determines if a year is a leap year using the rule: a year is divisible by 4 but not 100, or divisible by 400.

3. **Day of the Week**:
   - Uses `LocalDate` to compute the day of the week (e.g., "MONDAY") for a given date.

4. **Difference Between Dates**:
   - Calculates the difference in days between two dates using `ChronoUnit.DAYS.between`.

5. **Date Formatting**:
   - Prints dates in a readable format, such as "15 March 2023".

6. **Sorting Dates**:
   - Implements `compareTo` to sort dates in ascending order, prioritizing year, then month, then day.
   - Uses `Collections.sort` to sort a list of `Date` objects.

7. **User Interaction**:
   - Prompts the user to input the number of dates and their details (day, month, year).
   - Displays entered dates, the day of the week for the first date, differences between the first date and others, and sorted dates.

## How It Works

1. **Date Class**:
   - **Constructor**: Initializes a `Date` object after validating the input.
   - **Methods**:
     - `isValidDate`: Validates day, month, and year, accounting for leap years.
     - `isLeapYear`: Checks if a year is a leap year.
     - `getDayOfWeek`: Returns the day of the week.
     - `calculateDifference`: Computes the day difference between two dates.
     - `printDate`: Outputs the date in a human-readable format.
     - `compareTo`: Enables sorting by comparing dates.

2. **Main Class**:
   - Uses a `Scanner` to collect user input.
   - Creates a list of `Date` objects based on user input.
   - Demonstrates functionality by:
     - Printing all entered dates.
     - Showing the day of the week for the first date.
     - Calculating differences between the first date and others (if multiple dates are entered).
     - Sorting and displaying the dates in ascending order.
   - Handles errors (e.g., invalid input) with try-catch blocks and closes the scanner to prevent resource leaks.

## Usage

- Run the program and enter the number of dates to process.
- For each date, input the day, month, and year when prompted.
- The program will validate inputs, display the entered dates, show the day of the week for the first date, calculate differences (if applicable), and output the sorted dates.
- Invalid inputs (e.g., 29 February 2023 or negative dates) trigger error messages.

## Error Handling

- Invalid dates or non-positive date counts throw `IllegalArgumentException` with descriptive messages.
- General input errors (e.g., non-numeric input) are caught and displayed as errors.
- The program ensures the scanner is closed in a `finally` block.

## Dependencies

- Java Standard Library (`java.time` for `LocalDate` and `ChronoUnit`, `java.util` for `ArrayList`, `Collections`, and `Scanner`).

This implementation is robust, user-friendly, and suitable for educational purposes or as a foundation for more complex date-related applications.
