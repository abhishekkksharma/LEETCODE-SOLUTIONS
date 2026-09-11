class Solution {
    public int totalNumbers(int[] digits) {
        // int n=digits.length;
        // HashSet<Integer> set=new HashSet<>();
        // boolean[] used=new boolean[n];
        // return helper(digits,0,0,set,used);
        return count(digits);
    }
    private int count(int[] digits){
        int n=digits.length;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    if(i!=j && i!=k && j!=k){
                        if(digits[i]!=0){
                            if(digits[k]%2==0){
                                int num=digits[i]*100+digits[j]*10+digits[k];
                                set.add(num);
                            }
                        }
                    }
                }
            }
        }
        return set.size();
    }
    private int helper(int[] arr,int num,int count,HashSet<Integer> set,boolean[] used){
        if (count == 3) {
            if (num % 2 == 0 && num >= 100) {
                if (!set.contains(num)) {
                    set.add(num);
                    return 1;
                }
            }
            return 0;
        }
        int ans=0;
        for(int i=0;i<arr.length;i++){
            if(used[i]) continue;

            if(count==0 && arr[i]==0) continue;
            used[i]=true;

            ans += helper(
                arr,
                num * 10 + arr[i],
                count + 1,
                set,
                used
            );
            used[i]=false;
        }
        return ans;
    }
}