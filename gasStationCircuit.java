class Solution {
    
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i = 0; i< gas.length; i++){
            if(canStart(gas, cost, i)) return i;
        }
        return -1;
    }
    public boolean canStart(int[] gas, int[] cost, int index){
        int i = index;
        int tank = gas[i];
        boolean started = false;
        while(tank>=cost[i]){
            started =true;
            tank -= cost[i];
            i++;
            i= i%gas.length;
            tank+= gas[i];
            if(i== index) break;
        }
        if(i == index && started) return true;
        return false;
    }
}