package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	 public List<List<Integer>> threeSum(int[] nums) {
         List<List<Integer>> list = new ArrayList<List<Integer>>();
         int length = nums.length;
        
         Arrays.sort(nums);
        
         for(int i=0; i<length-2; i++) {
             int target = -nums[i],
            	 left = i+1,
            	 right = length - 1;
             
             if(i == 0 || nums[i] != nums[i-1]) {
                 while(left < right) {
                     int sum = nums[left] + nums[right];
                     
                     if(target == sum) {
                         list.add(Arrays.asList(-target, nums[left] ,nums[right]));

                         while(left<right && nums[left] == nums[left+1]) left++;
                         while(left<right && nums[right] == nums[right-1]) right--;
                         left++;
                         right--;

                     }else if(target > sum) {
                         left++;
                     }else right--;
                 }
             }

         }

         return list;
    }
}
