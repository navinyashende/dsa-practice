class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> s2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
    
        Set<Integer> set = new HashSet<>();
        
        for (int i=0; i < nums1.length; i++) {
            if(s1.contains(nums1[i]) && s2.contains(nums1[i])) {
                set.add(nums1[i]);
            }
        }
        
        int []res = set.stream().mapToInt(i -> i).toArray();
        
        return res;
    }
}