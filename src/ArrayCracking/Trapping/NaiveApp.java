package ArrayCracking.Trapping;

public class NaiveApp {
    public static void main(String[] args) {
        int[] arr = { 2, 1, 5, 3, 1, 0, 4 };
        System.out.println(maxWater(arr));
        System.out.println(maxWater2(arr));
    }

    private static int maxWater2(int[] arr) {
        int n=arr.length;
        int[]l=new int[n];
        int []r=new int[n];
        int ans=0;
        l[0]=arr[0];
        for (int i = 1; i < n; i++) {
            l[i]=Math.max(l[i-1],arr[i]);
        }
        r[n-1]=arr[n-1];
        for (int i = n-2; i >=0 ; i--) {
            r[i]=Math.max(r[i+1],arr[i]);
        }

        for (int i = 1; i <n-1 ; i++) {
            int min=Math.min(l[i-1],r[i+1] );
            if (min>arr[i]){
                ans+=min-arr[i];

            }
        }
        return ans;
    }

    private static int maxWater(int[] arr) {
        int ans=0;

        for (int i = 1; i < arr.length-1 ; i++) {

            int left=arr[i];
            for (int j = 0; j < i; j++) {
                left=Math.max(arr[j],left);
            }
            int right=arr[i];

            for (int j = i+1; j < arr.length; j++) {
                right=Math.max(right,arr[j]);
            }

            ans+=Math.min(left,right)-arr[i];
        }
        return ans;
    }
}
