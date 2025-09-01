package Task01;

/*
Task: Write a method in Java to get the difference between the largest and smallest values in an array of integers. The length of the array must be 1 and above. Use loops and conditionals to develop the algorithm.
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

        // Initialize both largest and smallest with the first element
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;

        // Traverse the array to find the true largest and smallest values
        for (int i = 0; i < n; i++) {
            // Update largest if the current element is greater
            if (numbers[i] > largest) {
                largest = numbers[i];
            }

            // Update smallest if the current element is smaller
            if (numbers[i] < smallest) {
                smallest = numbers[i];
            }
        }

        // Output the results
        System.out.println("The largest number is " + largest);
        System.out.println("The smallest number is " + smallest);
        System.out.println("The difference between largest and smallest is " + (largest - smallest));
    }
}
