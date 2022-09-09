class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, index = 0;
        int size = Math.min(nums1.length, nums2.length);
        int []result = new int[size];
        while ( i < nums1.length && j < nums2.length) {
            if(nums1[i] < nums2[j]) {
                i++;
            }
            else if(nums1[i] > nums2[j]){
                j++;
            }
            else {
                result[index++] = nums1[i];
                i++;
                j++;
            }
        }
        result = Arrays.copyOfRange(result,0,index);
        return result;
    }
}