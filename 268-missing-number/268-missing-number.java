class Solution {
   public int missingNumber(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        for (int i = 0; i <= set.size(); i++) {
            if (!set.contains(i)) return i;
        }
        throw new RuntimeException("IMPOSSIBLE!1!");
    }
}