class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        for(int i=0;i<=num;i++){
            if(sumCal(i,num)) return true;
        }
        return false;
    }
    private boolean sumCal(int num, int target){
        int sum=0;
        int temp=num;
        while(num>0){
            sum = sum*10+num%10;
            num/=10;
        }
        return ((sum+temp)==target);
    }
}