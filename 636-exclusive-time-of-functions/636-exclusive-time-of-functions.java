class Fun {
    
    Integer id;
    Integer start;
    Integer end;
    
    Fun(Integer _id, Integer _start) {
        id = _id;
        start = _start;
    }
}

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        
        int []res = new int[n];
        
        LinkedList<Fun> callStack = new LinkedList<>();
        
        for(String log : logs) {
            String []arr = log.split(":");
            Integer fId = Integer.parseInt(arr[0]);
            String op = arr[1];
            Integer time = Integer.parseInt(arr[2]);
            
            if(op.equals("start")) {
                Fun f = new Fun(fId, time);
                callStack.push(f);
            }
            else {
               Fun f = callStack.pop();
               res[f.id] += (time - f.start + 1);
               if(!callStack.isEmpty()) {
                   Fun top = callStack.peek();
                   res[top.id] -= (time - f.start + 1);
               } 
            }
        }
        
        return res;
    }
}