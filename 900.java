class RLEIterator {
    int pointer;
    int remainder;
    int[] A;
    public RLEIterator(int[] A) {
        this.pointer = 0;
        this.remainder = A[0];
        this.A = A;
    }
    
    public int next(int n) {
        if (pointer >= A.length) {
            return -1;
        }
        while (n > 0) {
            if (remainder > n) {
                remainder -= n;
                n = 0;
                return A[pointer+1];
            } else if (remainder == n) {
                int res = A[pointer+1];
                pointer += 2;
                remainder = A[pointer];
                return res;
            } else {
                n -= remainder;
                pointer += 2;
                if (pointer >= A.length) return -1;
                remainder = A[pointer];
            }
        }
        return -1;
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(A);
 * int param_1 = obj.next(n);
 */