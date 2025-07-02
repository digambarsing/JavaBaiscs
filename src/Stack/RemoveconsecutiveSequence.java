package Stack;

import java.util.Arrays;
import java.util.Stack;

public class RemoveconsecutiveSequence {
    public static void main(String[] args) {
        int[] ar = {1, 2, 2, 3, 10, 10, 10, 4, 4, 4, 5, 7, 7, 1};
        int[] ans = remove(ar);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] remove(int[] ar) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < ar.length; i++) {
            if (!st.isEmpty() && st.peek() == ar[i]) {
                // Remove consecutive duplicates
                while (i < ar.length && st.peek() == ar[i]) {
                    i++;
                }
                st.pop(); // Remove the last element of the sequence
                i--; // Adjust index after skipping duplicates
            } else {
                st.push(ar[i]);
            }
        }

        // Convert stack to an array in reverse order
        int[] ans = new int[st.size()];
        for (int j = st.size() - 1; j >= 0; j--) {
            ans[j] = st.pop();
        }

        return ans;
    }
}
