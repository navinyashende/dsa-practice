class Solution {
    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();
        
        String []parts = path.split("/");
        
        LinkedList<String> stack = new LinkedList<>();
        
        for(int i=0; i < parts.length; i++) {
            if(!stack.isEmpty() && parts[i].equals("..")) {
                stack.pop();
            }
            else if(!parts[i].equals("") && !parts[i].equals(".") && !parts[i].equals("..")) {
                stack.push(parts[i]);
            }
        }
        
        
        
        if(stack.isEmpty()){
            return "/";
        }
        
        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop()).insert(0, '/');
        }
        
        return sb.toString();
    }
}
