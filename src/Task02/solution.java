package Task02;

/*
Write a method in Java to find the smallest and second smallest elements of a given array and print it in the console. Use loops and conditionals to develop the algorithm.
 */

import java.util.Scanner;

public class solution {
    public static void main(String[] args) {
        int n; // number of elements to read

        Scanner sc = new Scanner(System.in); // Scanner to read user input from standard input
        System.out.println("Enter the number of elements in the array: ");
        n = sc.nextInt(); // read array length

        // Validate that array length is at least 1, otherwise terminate early
        if (n < 1) {
            System.out.println("The length of the array must be greater than zero");
            return;
        }

        int[] numbers = new int[n]; // allocate array with user-specified size

        // Read n integers from the user and populate the array
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the element " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
        }

        int smallest = Integer.MAX_VALUE;
        int secondSmallest =  Integer.MAX_VALUE;

        // Traverse the array to find the true largest and smallest values
        for (int i = 0; i < n; i++) {
            // Update the smallest element of array.
            if (numbers[i] < smallest) {
                secondSmallest = smallest;
                smallest = numbers[i];
            }

            // Update the second smallest element of array.
            if (numbers[i] < secondSmallest && numbers[i] != smallest) {
                secondSmallest = numbers[i];
            }
        }

        // Output results
        System.out.println("The smallest number is " + smallest);
        System.out.println("The secondSmallest number is " + secondSmallest);
    }
}
