package ArrayCracking;

public class kadanesAlgo {
    public static void main(String[] args) {
        int[] arr = {2, 3, -8, 7, -1, 2, 3};
        System.out.println(maxSubarraySum(arr));
        System.out.println(maxSubarraySum2(arr));
        System.out.println(maxSubarraySum3(arr));
    }

    private static int maxSubarraySum3(int[] arr) {
       int maxsum=arr[0];
        for (int i = 0; i < arr.length; i++) {
            int currsum=0;
            for (int j = i; j < arr.length; j++) {
                currsum+=arr[j];
                maxsum=Math.max(maxsum,currsum);
            }
        }
        return maxsum;

    }

    private static int maxSubarraySum2(int[] arr) {
        int sum=0;
        int max=Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            max=Math.max(sum,max);

            if (sum<0){
                sum=0;
            }
        }
        return max;
    }

    private static int maxSubarraySum(int[] arr) {

        int sum=arr[0];
        int max=arr[0];

        for(int i=1;i< arr.length;i++){
            sum=Math.max(sum+arr[i],arr[i]);
            max=Math.max(sum,max);
        }

        return max;
    }
}
