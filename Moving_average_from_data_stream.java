// Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

// Example:

// MovingAverage m = new MovingAverage(3);
// m.next(1) = 1
// m.next(10) = (1 + 10) / 2
// m.next(3) = (1 + 10 + 3) / 3
// m.next(5) = (10 + 3 + 5) / 3

class MovingAverage {
    int[] store;
    int filled;
    int max;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        store = new int[size];
        filled=0;
        max = size;
    }
    
    public double next(int val) {
        if(filled<max){
            store[filled]=val;
            filled++;
        } 
        else{
            int move = val;
            for(int i = max-1; i>=0;i--){
                int temp = store[i];
                store[i]=move;
                move = temp;
            }        
        }
        return newAvg();
    }
    public double newAvg(){
        double a = 0;
        for(int i = 0; i<filled;i++){
            a+=store[i];
        }
        return a/((double)(filled));
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */