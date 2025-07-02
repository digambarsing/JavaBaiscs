package ArrayCracking;

import java.util.Scanner;

public class Jagged {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("rows:");
        int r=sc.nextInt();
        int[][]ar=new int[r][];
        for (int i = 0; i < ar.length; i++) {
//            System.out.println("col");
//            int col=sc.nextInt();
            ar[i]=new int[ar.length-i];
        }

        for (int i = 0; i < ar.length ; i++) {
            for (int j = 0; j <ar[i].length ; j++) {
                ar[i][j]=i+j+2;
            }
        }


        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar[i].length; j++) {
                System.out.print(ar[i][j]+" ");
            }
            System.out.println();

        }
    }
}
