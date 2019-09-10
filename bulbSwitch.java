/*
** There are n bulbs that are initially off. You first turn on all the bulbs. 
** Then, you turn off every second bulb. On the third round, you toggle every third 
** bulb (turning on if it's off or turning off if it's on). For the i-th round, you 
** toggle every i bulb. For the n-th round, you only toggle the last bulb. Find how 
** many bulbs are on after n rounds.
*/
class Solution {
    public int bulbSwitch(int n) {
        if(n<=1) return n;
        int[] hits = new int[n];
        int ans = 0;
        for(int i = 2; i<n; i++){ 
           for(int j = i-1; j<n; j+=i)
              hits[j] = hits[j]+1;      
        }
        for(int j = 0; j<n; j++){
            if(j==n-1) hits[j] = hits[j]+1;
            if(hits[j]%2==0) ans++;
        }
        return ans;
    }
}