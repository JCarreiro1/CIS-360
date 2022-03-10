import java.util.Arrays;
import java.util.Random;
import java.lang.Math;

public class Main {
    public static int counter = 0;

    public static void main(String[] args){
        // declare and initialize array of random ints to be sorted
        int[] qs = new int[10];
        int[] test = {6, 12, 3, 8, 2, 7, 5, 1, 9, 4, 10};
        Random rand = new Random();

        for(int i = 0; i < qs.length; i++){
            qs[i] = rand.nextInt(11);
        }

        // find the beginning, middle, and end of the array and put into an array
//        int start = qs[0];
//        int mid = qs[(int)Math.floor(qs.length / 2)];
//        int end = qs[qs.length - 1];

        int start = test[0];
        int mid = test[(int)Math.floor(test.length / 2)];
        int end = test[test .length - 1];

        int[] potential = new int[] {start, mid, end};

        // sort array to take median
        Arrays.sort(potential);

        // Run tests using median value as pivot
//        System.out.println(Arrays.toString(test));
//        quickSort(0, test.length - 1, test, potential[1]);
//        System.out.println(Arrays.toString(test));

        // Run tests using first index as pivot
//        System.out.println(Arrays.toString(qs));
//        quickSort(0, qs.length - 1, qs, 0);
//        System.out.println(Arrays.toString(qs));

//        System.out.println("Number of recursive calls: " + counter);

        System.out.println(Arrays.toString(test));
        System.out.println(Arrays.toString(greedySort(test)));
    }

    /* Function that will partition the array into > the pivot and < the pivot.
       Low is the lower bounds of the array to partition, high is the upper bounds
     */
    public static int partitionStart(int high, int low, int[] arr, int pivotPoint){
        int i, j, pivotItem, temp;

        pivotItem = arr[low];
        j = low;

        for(i = low + 1; i <= high; i++){
            if(arr[i] < pivotItem){
                j++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        pivotPoint = j;
        temp = arr[low];
        arr[low] = arr[pivotPoint];
        arr[pivotPoint] = temp;

        return pivotPoint;
    }

    public static void quickSort(int low, int high, int[] arr, int pp){
        int pivotPoint = pp;

        if(high > low){
            pivotPoint = partitionStart(high, low, arr, pivotPoint);
            quickSort(low, pivotPoint - 1, arr, pivotPoint);
            counter++;
            quickSort(pivotPoint + 1, high, arr, pivotPoint);
            counter++;
        }
    }

    public static int[] greedySort(int[] arr){
        int[] res = new int[arr.length];
        int jobNum = 0;
        int curSmall = 999999;
        int prevSmall = -1;

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                if(arr[j] < curSmall && arr[j] >= prevSmall){
                    jobNum = j + 1;
                    curSmall = arr[j];
                }

            }
            res[i] = jobNum;
            prevSmall = curSmall;
            curSmall = 999999;
        }

        return res;
    }
}
