package ArrayCracking;

// Java Code to Merge two sorted arrays a[] and b[] without
// extra space using insert of insertion sort

import java.util.Arrays;

class GfG {

    static void mergeArrays(int[] a, int[] b) {

        // Traverse b[] starting from the last element
        for (int i = b.length - 1; i >= 0; i--) {

            // If b[i] is smaller than the largest element of a[]
            if (a[a.length - 1] > b[i]) {

                // Place b[i] in the correct position in a[],
                // and move last element of a[] to b[]
                int last = a[a.length - 1];
                int j = a.length - 2;
                while (j >= 0 && a[j] > b[i]) {
                    a[j + 1] = a[j];
                    j--;
                }
                a[j + 1] = b[i];
                b[i] = last;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 5, 9, 10, 15, 20};
        int[] b = {2, 3, 8, 13};

        mergeArrays(a, b);

        for (int ele : a)
            System.out.print(ele + " ");
        System.out.println();
        for (int ele : b)
            System.out.print(ele + " ");
    }
}
