class Solution {
public:
    int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        int delayed = 0;
        delayed = arrivalTime+delayedTime;
        if(delayed>=24) return delayed-24;
        return delayed;
    }
};