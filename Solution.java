
import java.util.Arrays;

public class Solution // viết các hàm trong này
{
    public static boolean canSortArray(int[] nums) // trả về mảng sắp xếp - function check sort: true/false
    {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                // thuật toán bubble sorts // bubble sort
                if (nums[j] > nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        return true;
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while (p1 >= 0 && p2 >= 0) { 
            if (nums1[p1] > nums2[p2])
            {
                nums1[p] = nums1[p1];
                p1--;
            }
            else
            {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
            while (p2 >= 0) {
                nums1[p] = nums2[p2];
                p2--;
                p--;   
            }
        }
    }
    public static void main(String[] args)
    {
        int[] array = {1,6,2,5,10};
        boolean flag = canSortArray(array);
        System.out.println("Sorted: " + flag);
        System.out.println("Array after sorting: " + Arrays.toString(array));

        Solution solution = new Solution();
        int[] nums1 = {1, 3, 5, 0, 0 ,0};
        int m = 3;
        int[] nums2 = {2, 4, 6};
        int n = 3;

        solution.merge(nums1, m, nums2, n);   
        System.out.println("Array after merging: " + Arrays.toString(nums1));
    }
}
