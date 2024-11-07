
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


class TreeNode { // nút cây
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {} // constructor

    TreeNode(int val) {this.val = val;}

    TreeNode (int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution // viết các hàm trong này
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
    public void merge(int[] nums1, int m, int[] nums2, int n) // nối 2 mảng lại với nhau
    {
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.empty()) {
            // 1. Đi xuống hết cỡ bên trái, đẩy các nút vào stack
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            // 2. Lấy nút từ stack, thêm giá trị vào kết quả
            current = stack.pop();
            result.add(current.val);

            // 3. di chuyển cây con sang trái
            current = current.right;
        }
        return result;
    }
    public boolean isSameTree(TreeNode p, TreeNode q)
    {
        //Use Stack to simulate recursion
        Stack<TreeNode> StackP = new Stack<>();
        Stack<TreeNode> StackQ = new Stack<>();
        // push node root if exsist
        if (p != null) StackP.push(p);
        if (q != null) StackQ.push(q);

        // looping to 2 stack empty
        while (!StackP.empty() && !StackQ.empty()) {
            // take node current from stack each
            TreeNode nodeP = StackP.pop();
            TreeNode nodeQ = StackQ.pop();

            // return false if value different
            if (nodeP.val != nodeQ.val) return false;
            

            // process node right. Push to stack if exist
            if (nodeP.right != null) StackP.push(nodeP.right);
            if (nodeQ.right != null) StackQ.push(nodeQ.right);

            // check size stack after pushing node right. if different => structure different => return false
            if (StackQ.size() != StackP.size()) return false;

            // process node left. Push to stack if exist
            if (nodeP.left != null) StackP.push(nodeP.left);
            if (nodeQ.left != null) StackQ.push(nodeQ.left);

            // check size stack after pushing node right. if different => structure different => return false
            if (StackQ.size() != StackP.size()) return false;
        }
        // if stack same => 2 tree this same
        return StackP.empty() && StackQ.empty();
    }
    
}