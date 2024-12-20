import java.util.Arrays;
import java.util.List;

public class main {
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        int[] array = {1,6,2,5,10};
        // test canSortArray
        boolean flag = solution.canSortArray(array);
        System.out.println("Sorted: " + flag);
        System.out.println("Array after sorting: " + Arrays.toString(array));
        
        // test Merge
        int[] nums1 = {1, 3, 5, 0, 0 ,0};
        int m = 3;
        int[] nums2 = {2, 4, 6};
        int n = 3;
        int[] merges = {};
        merges = nums1;

        solution.merge(nums1, m, nums2, n);   
        System.out.println("Array after merging: " + Arrays.toString(merges));


        // test inorderTraversal
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        System.out.println("Tree node root: " + solution.inorderTraversal(root1));


        // test tree same 
        // create 2 tree have value same
        TreeNode p = new TreeNode(1); // p tree
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        TreeNode q = new TreeNode(1); // q tree
        q.left =  new TreeNode(2);
        q.right = new TreeNode(3);

        boolean areSame = solution.isSameTree(p, q);
        System.out.println("Compare 2 tree this are: " + areSame);


        // create 2 tree not same value
        TreeNode p1 = new TreeNode(1); // p tree
        p1.left = new TreeNode(2);
        p1.right = new TreeNode(3);
        TreeNode q1 = new TreeNode(1); // q tree
        q1.left =  new TreeNode(3);
        q1.right = new TreeNode(2);

        boolean areSame1 = solution.isSameTree(p1, q1);
        System.out.println("Compare 2 tree this are: " + areSame1);

        // test symmetric
        System.out.println("This tree symmetric is: " + solution.isSymmetric(root1));
        // create null tree
        root1 = null;
        System.out.println("This tree symmetric is: " + solution.isSymmetric(root1));
        root1 = new TreeNode(1); // just having root only
        System.out.println("This tree symmetric is: " + solution.isSymmetric(root1));

        // test single numer
        int[] arr = {1, 3, 1, 5 ,5};
        System.out.println("Element single in array: " + solution.singleNumber(arr));

        // test generate
        List<List<Integer>> triangle = solution.generate(4);
        System.out.println("Pacal's Triangle: " + triangle);
            
    }
}
