import java.lang.Math;

public class Main {
    public static int count = 1;
    public static int solutions = 0;
    public static boolean firstSol = true;

    public static void main(String[] args){
        int[] col4 = new int[4];
        int[] col8 = new int[8];
        int[] col10 = new int[10];
        int[] col12 = new int[12];

        queens(-1, col4);
        System.out.println("\nNodes generated: " + count);
        System.out.println("Solutions found: " + solutions);
        System.out.print("\n");
        count = 1;
        solutions = 0;
        firstSol = true;

        queens(-1, col8);
        System.out.println("\nNodes generated: " + count);
        System.out.println("Solutions found: " + solutions);
        System.out.print("\n");
        count = 1;
        solutions = 0;
        firstSol = true;

        queens(-1, col10);
        System.out.println("\nNodes generated: " + count);
        System.out.println("Solutions found: " + solutions);
        System.out.print("\n");
        count = 1;
        solutions = 0;
        firstSol = true;

        queens(-1, col12);
        System.out.println("\nNodes generated: " + count);
        System.out.println("Solutions found: " + solutions);
        count = 1;
        solutions = 0;
        firstSol = true;
    }

    public static void queens(int i, int[] col){
        if(promising(i, col)){
            if(i == col.length - 1){
                solutions++;

                if(firstSol) {
                    for (int j = 0; j < col.length; j++)
                        System.out.print(col[j] + " ");
                    firstSol = false;
                }
            } else{
                for(int j = 0; j < col.length; j++){
                    col[i+1] = j;
                    count ++;
                    queens(i + 1, col);
                }
            }
        }
    }

    public static boolean promising(int i, int[] col){
        int k = 0;
        boolean check = true;

        while(k < i && check){
            if(col[i] == col[k] || Math.abs(col[i] - col[k]) == i - k)
                check = false;
            k++;
        }

        return check;
    }
}
