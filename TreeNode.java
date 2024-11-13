
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true; // 1. if tree null => symmetric

        // 2. create queue
        Queue<TreeNode> queue = new LinkedList<>(); 

        // add node right and node left to Queue.
        // Start the symmetry comparison process from the 2nd tier of the tree.
        queue.offer(root.left);
        queue.offer(root.right);

        // 3. Browse by width (BFS) using queues
        while (!queue.isEmpty()) {
            // 4. Take 2 node from queue
            TreeNode leftNode = queue.poll(); // take and delete first element
            TreeNode rightNode = queue.poll(); // take and delete second element 

            // 5. check null
            if (leftNode == null && rightNode == null) continue; // continue do loop

            if (leftNode == null || rightNode == null) return false; // if just one return false => not symmetric

            // 6. compare value of 2 node
            if (leftNode.val !=rightNode.val) return false; // if not same value => not symmetric

            // 7. Add child nodes to the queue (order)
            queue.offer(leftNode.left); // child node left of leftNode
            queue.offer(rightNode.right); // child node right of rightNode

            queue.offer(leftNode.right); // child node right of leftNode
            queue.offer(rightNode.left); // child node left of rightNode

            /*
             Adding order very important to ensure symmetric. Next loop, leftnode.left will compare with rightnode.right 
             and the like.
             */
        }
        return true;
    }
    public int singleNumber(int[] nums) {
        int[] array = nums.clone();
        Arrays.sort(array);

        for (int i = 0; i < array.length - 1; i+=2) // step 2 to compare
        {
            if (array[i] != array[i+1]) return array[i]; // compare value couple and return value first not same
        }
        return array[array.length - 1]; // return last array element
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList();

        // row first all 1
        if (numRows >= 1)
        {
            triangle.add(List.of(1));
        }

        // create continue row
        for (int i = 1; i < numRows; i++)
        {
            List<Integer> row = new ArrayList<>();
            List<Integer> preRow = triangle.get(i - 1); // before rowing


            // element of row always 1
            row.add(1);

            // calculator element mid
            for (int j = 1; j < i;j++)
            {
                int result = preRow.get(j-1) + preRow.get(j);
                row.add(result);
            }

            // element tail always 1
            row.add(1);

            triangle.add(row);
        }
        return triangle;
    }
    public int Greedy_Test(int[] nums1, int[] nums2, int m) {
        int n = nums1.length;
        Integer[] indices = new Integer[n];

        // 1. Tạo mảng chỉ số
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // 2. Sắp xếp sử dụng Comparator riêng
        Arrays.sort(indices, new Comparator<Integer>() {
            //@Override
            public int compare(Integer i1, Integer i2) {
                double ratio1 = (nums1[i1] == 0) ? Double.MAX_VALUE : (double) nums2[i1] / nums1[i1];
                double ratio2 = (nums1[i2] == 0) ? Double.MAX_VALUE : (double) nums2[i2] / nums1[i2];
                return Double.compare(ratio2, ratio1); // Sắp xếp giảm dần
            }
        });

        // 3. Tham lam (giữ nguyên)
        int totalValue = 0;
        int remainingCapacity = m;

        for (int i : indices) {
            while (remainingCapacity >= nums1[i] && nums1[i] > 0) {
                totalValue += nums2[i];
                remainingCapacity -= nums1[i];
            }
        }

        return totalValue;
    }
}