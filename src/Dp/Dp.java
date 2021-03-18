import java.util.*;

public class Dp {
    public static void main(String[] args) {
        // long startTime = System.currentTimeMillis();
        int n = 5;
        int[] strg = new int[n + 1];
        // System.out.println(fibBtr(n,strg));
        // long endTime = System.currentTimeMillis();

        // long timeElapsed = endTime - startTime;
        // System.out.println(timeElapsed);
        // System.out.println(climbDown(n));
        // System.out.println(climbDownMem(n, strg));
        // System.out.println(climbDownTabulation(n));
        System.out.println(countMazePath(2,2));
        System.out.println(countMazePath2(2,2));
    }

    public static int fib(int n) {

        if (n == 1 || n == 2) {
            return n - 1;
        }
        int fbn1 = fib(n - 1);
        int fbn2 = fib(n - 2);

        int fibn = fbn1 + fbn2;
        return fibn;
    }

    public static int fibBtr(int n, int strg[]) {

        if (n == 1 || n == 2) {
            return n - 1;
        }

        if (strg[n] != 0) {
            return strg[n];
        }
        int fbn1 = fibBtr(n - 1, strg);
        int fbn2 = fibBtr(n - 2, strg);

        int fibn = fbn1 + fbn2;
        strg[n] = fibn;
        return fibn;
    }

    public static int climbDown(int n) {
        if (n < 0) {
            return 0;
        }

        if (n == 1 || n == 0) {
            return 1;
        }
        return climbDown(n - 1) + climbDown(n - 2) + climbDown(n - 3);
    }

    public static int climbDownMem(int n, int[] strg) {
        if (n < 0) {
            return 0;
        }

        if (n == 1 || n == 0) {
            return 1;
        }

        if (strg[n] != 0) {
            return strg[n];
        }
        return strg[n] = climbDownMem(n - 1, strg) + climbDownMem(n - 2, strg) + climbDownMem(n - 3, strg);
    }

    public static int climbDownTabulation(int n) {
        int[] strg = new int[n + 1];

        strg[0] = 1;
        strg[1] = 1;
        strg[2] = 2;
        for (int i = 3; i <= n; i++) {
            strg[i] = strg[i - 1] + strg[i - 2] + strg[i - 3];
        }

        return strg[n];
    }

    public static int countMazePath(int dr, int dc) {
        int[][] strg = new int[dr + 1][dc + 1];
        for (int i = dr; i >= 0; i--) {
            for (int j = dc; j >= 0; j--) {
                if (i == dr && j == dc) {
                    strg[dr][dc] = 1;
                } else if (i == dr) {
                    strg[i][j] = strg[i][j + 1];
                } else if (j == dc) {
                    strg[i][j] = strg[i + 1][j];
                } else {
                    strg[i][j] = strg[i + 1][j] + strg[i][j + 1];
                }
            }
        }

        return strg[0][0];
    }

    public static int countMazePath2(int dr,int dc){
        int[][] strg = new int[dr+1][dc+1];
        for(int i=0;i<=dr;i++){
            for(int j=0;j<=dc;j++){
                if(i==0&&j==0){
                    strg[0][0] = 1;
                }else if(i==0){
                    strg[i][j] = strg[i][j-1];
                }else if(j==0){
                    strg[i][j] = strg[i-1][j];
                }else{
                    strg[i][j] = strg[i-1][j]+strg[i][j-1];
                }
            }
        }

        return strg[dr][dc];
    }
}