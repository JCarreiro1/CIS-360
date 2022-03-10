import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        Random rand = new Random();
        int[] unsorted = new int[100];
        int[] sorted = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};

        // Populate array with 100 random numbers from 0-1000
        for(int i = 0; i < unsorted.length; i++)
            unsorted[i] = rand.nextInt(1001);

        minMax(unsorted);
        System.out.println("\nDesired value: " + searchThree(sorted, 8));
        //System.out.println(DQLargest(sorted));
    }

    /* Takes in an integer array and finds the min and max by comparing elements two at a time
       and separating them into two sub-arrays.
       Only performs 1.5n comparisons by searching 0.5n three times
     */
    public static void minMax(int[] arr){
        int[] localMins = new int[arr.length / 2];
        int[] localMaxs = new int[arr.length / 2];
        int subPosition = 0, x, y;

        // Splits array into local minimums and maximums by comparing elements two at a time
        for(int i = 0; i < arr.length; i += 2){
            x = arr[i];
            y = arr[(i + 1) % arr.length];

            // Puts the smaller element with minimums and the larger with maximums
            if(x < y){
                localMins[subPosition] = x;
                localMaxs[subPosition] = y;
            } else {
                localMins[subPosition] = y;
                localMaxs[subPosition] = x;
            }
            subPosition++;
        }

        int globalMin = localMins[0], globalMax = localMaxs[0];

        // Searches for the absolute smallest in the minimums and the absolute largest in maximums
        for(int i = 1; i < localMins.length; i++){
            if(localMins[i] < globalMin)
                globalMin = localMins[i];
            if(localMaxs[i] > globalMax)
                globalMax = localMaxs[i];
        }

        System.out.println("Minimum: " + globalMin + "\nMaximum: " + globalMax);
    }

    /* Takes in a sorted array and finds the desired value.
       Uses a divide and conquer approach by splitting the array into three
       sub-arrays of roughly equal size.
     */
    public static int searchThree(int[] arr, int x){
        // Creates marker at 1/3 and 2/3 mark in the array
        int low = (int)Math.floor(arr.length/3);
        int high = (int)Math.floor((arr.length * 2) / 3);

        // Base case if array is size 1
        if(arr.length == 1 && arr[0] == x){
            return arr[0];
        } else if(arr.length == 1 && arr[0] != x){
            return 0;
        }

        // Decides which third of the array may contain the desired value
        if(arr[low] >= x){
            return searchThree(Arrays.copyOfRange(arr, 0, low + 1), x);
        } else if(arr[high] <= x){
            return searchThree(Arrays.copyOfRange(arr, high, arr.length), x);
        } else {
            return searchThree(Arrays.copyOfRange(arr, low + 1, high), x);
        }
    }

    // Used for Homework, Not part of lab
    public static int DQLargest(int[] arr){
        if(arr.length == 1)
            return arr[0];

        int fhLarge, shLarge;
        fhLarge = DQLargest(Arrays.copyOfRange(arr, 0, (int)Math.floor(arr.length / 2)));
        shLarge = DQLargest(Arrays.copyOfRange(arr, (int)Math.floor(arr.length / 2), arr.length));

        if(fhLarge > shLarge)
            return fhLarge;
        else
            return shLarge;
    }
}
