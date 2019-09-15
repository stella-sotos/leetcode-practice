class Solution {
    public int[] sortArrayByParity(int[] A) {
        int s = 0;
        int e = A.length-1;
        while(s<e){
            if(A[s]%2==0) s++;
            else if(A[e]%2==1) e--;
            else{
                int temp = A[s];
                A[s] = A[e];
                A[e] = temp;
                s++;
                e--;
            }
        }
        return A;
    }
}