import java.util.*;

class Solution {

    public int kthSmallest(TreeNode root, int k) {

        ArrayList<Integer> arr = new ArrayList<>();

        store(root, arr);

        Collections.sort(arr);

        for (int i = 0; i < arr.size(); i++) {
            if (k == 1) {
                return arr.get(0);
            } else {
                if (i == k - 1) {
                    return arr.get(i);
                }
            }
        }

        return -1;
    }

    public void store(TreeNode root, ArrayList<Integer> arr) {
        if (root == null) {
            return;
        }

        arr.add(root.val);

        store(root.left, arr);
        store(root.right, arr);
    }
}