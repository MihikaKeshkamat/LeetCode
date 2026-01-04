class Solution {
    public int sumFourDivisors(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i=0;i<n;i++){
            int num = nums[i];
            int sumOfDivisors = 0;
             int count = 0;
            int limit = (int) Math.sqrt(num);
            for(int j=1;j<=limit;j++){
                if(num % j == 0){
                    if(j * j == num){
                        count++;
                        sumOfDivisors += j;
                    }else{
                        count+=2;
                        sumOfDivisors += (j + (num/j));
                    }
                }
            }
            if(count == 4){
                sum += sumOfDivisors;
            }
        }
        return sum;
    }
}