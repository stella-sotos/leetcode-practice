class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if(n ==1){
            ans.add("()");
        }
        else{
            for(int i = 1; i< n-i +1; i++){
                List<String> inners = generateParenthesis(n-i);
                List<String> outers = generateParenthesis(i);
                String pre = "", post = "";
                for(int j = 0; j<i; j++){
                    pre+="(";
                    post+=")";
                }
                for(String in: inners){
                    for(String out: outers){
                        ans.add(in + out);
                        ans.add(out + in);
                        ans.add(pre+ in +post);
                    }
                }
            }
        }
        return removeDupes(ans);
    }
    public List<String> removeDupes(List<String> orig){
        List<String> ans = new ArrayList<>();
        for(String s: orig){
            if(!ans.contains(s)) ans.add(s);
        }
        Collections.sort(ans);
        return ans;
    }
}