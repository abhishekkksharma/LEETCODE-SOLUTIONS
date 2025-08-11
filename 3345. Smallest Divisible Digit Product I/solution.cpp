class Solution {
private:
    int productOfDigits(int n){
        if(n<10) return n;
        return n%10 * productOfDigits(n/10);
    }
public:
    int smallestNumber(int n, int t) {
        bool found=false;
        while(!found){
            if(productOfDigits(n)%t==0){
                return n;
                found=true;
            } 
            else{
                n++;
            }
        }
        return -1;
    }
};