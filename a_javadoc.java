   /**
     * Calculates the median of a sorted array.
     *
     * @param arr           the array of numbers (must be sorted)
     * @param size_of_array the size of the array
     * @return the median of the array
     */
    public static double median_func(double[] arr, int size_of_array) {
        int half = size_of_array / 2;

        // Calculate median based on the array size
        if (size_of_array % 2 == 1) {
            return arr[half];
        } else {
            return (arr[half - 1] + arr[half]) / 2;
        }
    }

    /**
     * Calculates the arithmetic mean of an array.
     *
     * @param arr           the array of numbers
     * @param size_of_array the size of the array
     * @return the arithmetic mean of the array
     */
    public static double arithmetic_mean(double[] arr, int size_of_array) {
        double ans = 0;
        for (int i = 0; i < size_of_array; i++) {
            ans += arr[i];
        }
        return ans / size_of_array;
    }

    /**
     * Calculates the geometric mean of an array.
     *
     * @param arr           the array of numbers
     * @param size_of_array the size of the array
     * @return the geometric mean of the array
     */
    public static double geometric_mean(double[] arr, int size_of_array) {
        double multiple_of_array = 1.0;
        for (int i = 0; i < size_of_array; i++) {
            multiple_of_array *= arr[i];
        }

        return Math.pow(multiple_of_array, 1.0 / size_of_array);
    }

    /**
     * Calculates the harmonic mean of an array recursively.
     *
     * @param arr           the array of numbers
     * @param size_of_array the size of the array
     * @param counter       the current position in the recursion
     * @return the sum of the reciprocals of the array elements from the current position
     */
    public static double harmonic_func(double[] arr, int size_of_array, int counter) {
        if (counter == size_of_array)
            return 0;
        return 1.0 / arr[counter] + harmonic_func(arr, size_of_array, counter + 1);
    }

    /**
     * Calculates and prints various statistical measures of an array.
     *
     * @param arr           the array of numbers
     * @param size_of_array the size of the array
     */
    public static void statistical_func(double[] arr, int size_of_array) {
        flush_terminal();
        Arrays.sort(arr);

        double median = median_func(arr, size_of_array);
        double arithmetic_mean = arithmetic_mean(arr, size_of_array);
        double geometric_mean = geometric_mean(arr, size_of_array);
        double harmonic_func = size_of_array / harmonic_func(arr, size_of_array, 0);

        System.out.println("Median of the array is: " + median);
        System.out.println("Arithmetic Mean of the array is: " + arithmetic_mean);
        System.out.println("Geometric Mean of the array is: " + geometric_mean);
        System.out.println("Harmonic Mean of the array is: " + harmonic_func);
    }
