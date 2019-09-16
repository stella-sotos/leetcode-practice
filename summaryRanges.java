class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if(nums.length==0)return ans;
        int lastStart = nums[0];
        for(int i = 1; i<nums.length; i++){
            String range;
            if(nums[i]==nums[i-1]+1){
                if(i+1 == nums.length){
                    range = lastStart +"->"+nums[i];
                    ans.add(range);
                }
            }
            else{
                if(lastStart == nums[i-1]) range = ""+lastStart;
                else range = lastStart +"->"+nums[i-1];
                lastStart = nums[i];
                ans.add(range);
            }
        }
        if(lastStart == nums[nums.length-1])ans.add(""+lastStart);
        return ans;
    }
}