//Write a program that outputs the string representation of numbers from 1 to n. But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();
        for(int i = 1; i<=n; i++){
            ans.add(output(i));
        }
        return ans;
    }
    public String output(int n){
        String ans = "";
        if(n%3 ==0) ans ="Fizz";
        if(n%5==0) ans+="Buzz";
        if(ans =="") ans = ""+n;
        return ans;
    }
}