class Solution {
    public double average(int[] salary) {
        double maxSalary = Integer.MIN_VALUE;
        double minSalary = Integer.MAX_VALUE;
        double sum = 0;
        for(int i=0;i<salary.length;i++){
            if(salary[i]<minSalary) minSalary=salary[i];
            if(salary[i]>maxSalary) maxSalary=salary[i];
            sum+=salary[i];
        }
        double result = (sum-maxSalary-minSalary)/(salary.length-2);
        return result;
    }
}