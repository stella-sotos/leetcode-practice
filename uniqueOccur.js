/**
 * @param {number[]} arr
 * @return {boolean}
 */
var uniqueOccurrences = function(arr) {
    arr.sort(function(a,b){return a-b});
    var curCount = 1;
    var cur = arr[0];
    var i;
    var counts =[];
    for(i=1;i<arr.length;i++){
        if(arr[i]==cur)curCount++;
        else{
            cur=arr[i];
            counts.push(curCount);
            curCount = 1;
        }
    }
    counts.push(curCount);
    counts.sort(function(a,b){return a-b});
    var last = counts[0];
    for(i =1; i<counts.length;i++){
        if(counts[i]==last)return false;
        else last = counts[i];
    }
    return true;
};