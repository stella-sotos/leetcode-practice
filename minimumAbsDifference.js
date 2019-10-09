/**
 * @param {number[]} arr
 * @return {number[][]}
 */
var minimumAbsDifference = function(arr) {
    arr.sort(function(a, b){return a-b});
    var ans;
    var i;
    var minDif = 9999;
    for (i = 1; i < arr.length; i++) {
        var thisDif = arr[i]-arr[i-1];
        if(thisDif<minDif){
            minDif = thisDif;
            var thisPair = [arr[i-1],arr[i]];
            ans = [];
            ans.push(thisPair);
        }
        else if(thisDif ==minDif){
            var pair = [arr[i-1],arr[i]];
            ans.push(pair);
        }
    }
    return ans;
};