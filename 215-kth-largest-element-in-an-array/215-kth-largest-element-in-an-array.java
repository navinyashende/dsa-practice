class Solution {
    public int findKthLargest(int[] nums, int k) {
       int low = 0, high = nums.length -1;
       
       int ans = Integer.MIN_VALUE;
       while(true) {
           int idx = partition(nums, low, high);
           if(idx == k - 1) {
               ans = nums[idx];
               break;
           }
           else if(idx < k-1) {
               low = idx + 1;
           }
           else {
               high = idx - 1;
           }
       }
        
       return ans;
    }
    
    private int partition(int []nums, int left, int right) {
        int pivot = nums[left], l = left + 1, r = right;
        
        while(l <= r) {
            if(nums[l] < pivot && nums[r] > pivot) {
                swap(nums,l,r);
                l++;
                r--;
            }
            else if(nums[l] >= pivot) {
                l++;
            }
            else if(nums[r] <= pivot){
                r--;
            }
        }
        swap(nums,left,r);
        return r;
    }
    
    private void swap(int []nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}