
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
    public static void main(String[] args)
    {
        int[] array = {1,6,2,5,10};
        boolean flag = canSortArray(array);
        System.out.println("Sorted: " + flag);
        System.out.println("Array after sorting: " + Arrays.toString(array));
    }
}
