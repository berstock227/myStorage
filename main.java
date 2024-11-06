import java.util.Arrays;

public class main {
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        int[] array = {1,6,2,5,10};
        boolean flag = solution.canSortArray(array);
        System.out.println("Sorted: " + flag);
        System.out.println("Array after sorting: " + Arrays.toString(array));

        int[] nums1 = {1, 3, 5, 0, 0 ,0};
        int m = 3;
        int[] nums2 = {2, 4, 6};
        int n = 3;
        int[] merges = {};
        merges = nums1;

        solution.merge(nums1, m, nums2, n);   
        System.out.println("Array after merging: " + Arrays.toString(merges));
    }
}
