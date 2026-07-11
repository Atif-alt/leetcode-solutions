class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, nums, new ArrayList<>(), ans);
        return ans;
    }

    public void solve(int index, int[] nums, List<Integer> temp, List<List<Integer>> ans) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        // Include current element
        temp.add(nums[index]);
        solve(index + 1, nums, temp, ans);

        // Exclude current element
        temp.remove(temp.size() - 1);
        solve(index + 1, nums, temp, ans);
    }
}