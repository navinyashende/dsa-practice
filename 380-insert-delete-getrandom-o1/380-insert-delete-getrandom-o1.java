class RandomizedSet {
    
    Map<Integer, Integer> map;
    
    ArrayList<Integer> list;
    
    Random rand;

    
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) {
            return false;
        }
        
        list.add(val);
        
        map.put(val, list.size() - 1);
        
        return true;            
    }
    
    public boolean remove(int val) {
       
        if(!map.containsKey(val)) {
            return false;
        }
        
        int idx = map.get(val);
        
        int size = list.size();
        
        if(idx < size - 1) {
            int last = list.get(size - 1);
            list.set(idx, last);
            map.put(last, idx);
        }
        
        map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }
    
    public int getRandom() {
        int idx = rand.nextInt(list.size());
        int val = list.get(idx);
        return val;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */