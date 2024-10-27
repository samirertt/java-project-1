import java.util.Scanner;
import java.util.Arrays;

public class A {
    
    // This section initializes the scanner and components of the statistical information of the array and also prints out the results of the computations for the statistical information on the array
    public static void main(String[] args) {
        
        Scanner userInput = new Scanner(System.in); //uses java.util.Scanner in order to get user inputs
        int[] array; //Initializes the array

            array = arrayInput(userInput); 
        
        // Initializing the statistical information operations
        double median = Median(array);
        double arithmeticMean = arithmeticMean(array);
        double geometricMean = geometricMean(array);
        double harmonicMean = harmonicMean(array);
        
        //This part prints out the statistical information about the array
        System.out.println("Median of the array is: " + median);
        System.out.println("Arithmetic Mean of the array is: " + arithmeticMean);
        System.out.println("Geometric Mean of the array is: " + geometricMean);
        System.out.println("Harmonic Mean of the array is: " + harmonicMean);

        userInput.close();
    }

    // This section uses java.util.Scanner commands to get user input and return the array
    public static int[] arrayInput(Scanner scanner) {
        int arrayLength = 0;

        // This while condition validates the user input and makes sure no invalid data type is entered
        while (true) {
            System.out.print("Enter the length of the array: ");
            try {
                arrayLength = scanner.nextInt();
                if (arrayLength <= 0) {
                    System.out.println("Invalid input. Please enter the correct data type.");
                    continue; // As long as the value is not a positive integer, the program keeps asking for a valid input
                }
                break; // If the correct data type which is a positive integer is entered, the program will exit the loop
                } 
                // This part checks for rest of the exceptions which are data types other than integer
                catch (Exception all) {
                System.out.println("Invalid input. Please enter the correct data type.");
                scanner.next(); 
            }
        }
        
        // This part gets the array elements as user inputs and validates it
        int[] array = new int[arrayLength];
        System.out.println("Enter " + arrayLength + " array elements:");

        // Input array elements with validation
        for (int i = 0; i < arrayLength; i++) {
            while (true) {
                System.out.print("Element " + (i + 1) + ": ");
                try {
                    array[i] = scanner.nextInt();
                    break; // If the correct data type is entered, the program will exit the loop
                } 
                // This part checks for all exceptions which are data types other than integer
                catch (Exception all) {
                    System.out.println("Invalid input. Please enter an integer.");
                    scanner.next(); 
                }
            }
        }
        return array;
    }

    // This part calculates and returns the Median of the array
    public static double Median(int[] array) {
        Arrays.sort(array);
        int mid = array.length / 2; // Finds the element in the middle of the array
        // With this if condition we are checking if the array length is even or odd
        if (array.length % 2 == 0) {
            return (array[array.length / 2 - 1] + array[array.length / 2]) / 2.0; // In even sized arrays we need the average of the two elements in the middle, this operation provides that
        } else {
            return array[mid]; // With odd array length, we can simply use the value in the middle 
        }
    }

    // This part calculates and returns the Arithmetic Mean of the array
    public static double arithmeticMean(int[] array) {
        int sum = 0; // Initializing sum for the arithmetic mean operation
        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i]; // Finding the sum of array elements
        }
        return (double) sum / array.length; // Arithmetic mean of an array is the sum of all array elements divided by the length of the array
    }

    // This part calculates and returns the Geometric Mean of the array
    public static double geometricMean(int[] array) {
        double insideRoot = 1.0; // Initializing the value for the array elements' multiplication inside the root
        for (int i = 0; i < array.length; i++) {
            insideRoot = insideRoot * array[i]; // Finding the value of the array elements' multiplication
        }
        return (double) Math.pow(insideRoot, 1.0 / array.length); // We used math.pow in order to find the geometric mean, We first found the value of the array elements multiplied and ran the operation of insideRoot to the power of 1/n where n means array length
    }

    // Function to calculate the harmonic mean
    public static double harmonicMean(int[] array) {
        double harmonicSerie = 0.0; // Initializing the value for the harmonic serie
        for (int i = 0; i < array.length; i++) {
            harmonicSerie = harmonicSerie + (1.0 / array[i]); // Finding the value of harmonic serie which is the sum of all 1/array elements
        }
        return (double) (array.length) * Math.pow(harmonicSerie,-1.0); // In order to find the harmonic mean we multiplied array length and harmonic serie to the power of -1 instead of dividing array length by harmonic serie which is correct as well
    }
}