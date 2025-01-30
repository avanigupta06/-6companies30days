class DataStream {
    private int val, k, count;
        public DataStream(int value, int k) {
            this.val = value;
            this.k = k;
            this.count = 0;
        }
    
        public boolean consec(int num) {
            // if num == val, increment the streak else set it to 0
            count = (num == val)? count + 1 : 0;
            return count >= k;
            
        }
    }
    
    /**
     * Your DataStream object will be instantiated and called as such:
     * DataStream obj = new DataStream(value, k);
     * boolean param_1 = obj.consec(num);
     */
// Time Complexity: O(k)let k be the number of calls made to consec()
// Space Complexity: O(1)