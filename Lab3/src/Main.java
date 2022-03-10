import java.util.Arrays;
import java.lang.Math;

public class Main {
    public static void main (String[] args){
        int[] test = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        int[] param = new int[] {10, 4, 2, 7, 9, 1, 3, 6, 8, 5};
//        long duration, startTime, endTime;
//
//        System.out.println(Arrays.toString(findSmallest(param, 6)));

//        startTime = System.nanoTime();
//        recFib(60);
//        endTime = System.nanoTime();
//
//        duration = endTime - startTime;
//        System.out.println(duration);

//        startTime = System.nanoTime();
//        itFib(1000000);
//        endTime = System.nanoTime();
//
//        duration = endTime - startTime;
//        System.out.println(duration);

        System.out.println(homework(test, -100));
    }

    public static int[] findSmallest(int[] N, int m){
        int[] mins = new int[m];
        int prevMin = -1000000;
        int minimum;

        for(int i = 0; i < m; i++)
        {
            minimum = 1000000;
            for(int j = 0; j < N.length; j++)
                if (N[j] < minimum && N[j] > prevMin)
                    minimum = N[j];
            mins[i] = minimum;
            prevMin = minimum;
        }
        return mins;
    }

    public static int recFib(int n){
        if(n <= 1)
            return n;
        else
            return recFib(n - 1) + recFib(n - 2);
    }

    public static int itFib(int n){
        int[] fib = new int[n];

        fib[0] = 0;
        if(n> 0){
            fib[1] = 0;
            for(int i = 2; i < n; i++)
                fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n-1];
    }

    public static int homework(int[] arr, int x){
        int low = (int)Math.floor(arr.length/3);
        int high = (int)Math.floor((arr.length * 2) / 3);

        if(arr.length == 1 && arr[0] == x){
            return arr[0];
        } else if(arr.length == 1 && arr[0] != x){
            return 0;
        }

        if(arr[low] >= x){
            return homework(Arrays.copyOfRange(arr, 0, low + 1), x);
        } else if(arr[high] <= x){
            return homework(Arrays.copyOfRange(arr, high, arr.length), x);
        } else {
            return homework(Arrays.copyOfRange(arr, low + 1, high), x);
        }
    }
}
