//Design and implement an iterator to flatten a 2d vector. It should support the following operations: next and hasNext.
class Vector2D {
    int i,j;
    int[][] matrix;
    
    public Vector2D(int[][] v) {
        matrix = v;
        i=0;
        j=0;
    }
    public int next() {
        int ans =-1;
        if(hasNext()){
            if(j<matrix[i].length){
                ans= matrix[i][j];
                if(j+1<matrix[i].length) j++;
                else if(i+1<matrix.length) {i++; j = 0;}
                else {i++; j++;}
            }
            else if(i+1<matrix.length){
                j =0;
                ans = matrix[i+1][j];
                i+=2;
            }
        }
        return ans;
    }
    
    public boolean hasNext() {
        if(i<matrix.length && j<matrix[i].length) return true;
        else{
            if(i+1>=matrix.length) return false;
            while(i+1<matrix.length){
                i++;
                if(0<matrix[i].length){
                    j=0;
                    return true;
                }
            }
            return false;
        }
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(v);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */