class Solution {
    
    Map<String, List<String>> adj = new HashMap<>();
    Set<String> visited = new HashSet<>();
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        // Create an adjancency map of emails (considering email as vertex)
        for(List<String> account : accounts) {
            String accountFirstEmail = account.get(1);
            
            int accountSize = account.size();
            
            adj.putIfAbsent(accountFirstEmail, new ArrayList<>());
            
            for(int i=2; i < accountSize; i++) {
                
                adj.get(accountFirstEmail).add(account.get(i));
                
                adj.putIfAbsent(account.get(i), new ArrayList<>());
                
                adj.get(account.get(i)).add(accountFirstEmail);
            }
        }
        
        List<List<String>> mergedAccounts = new ArrayList<>();
        
        for(List<String> account: accounts) {
            
            String accountName = account.get(0);
            
            String accountFirstEmail = account.get(1);
            
            // if you have not visited the email
            if(visited.contains(accountFirstEmail) == false) {
                List<String> mergedAccount = new ArrayList<>();
                
                mergedAccount.add(accountName);
                
                dfs(mergedAccount, accountFirstEmail);
                
                Collections.sort(mergedAccount.subList(1, mergedAccount.size()));
                
                mergedAccounts.add(mergedAccount);
            }
        }
        
        return mergedAccounts;
    }
    
    public void dfs(List<String> mergedAccount, String email) {
        
        // mark current node as visited
        visited.add(email);
        
        // add current email to merged account
        mergedAccount.add(email);
        
        if(adj.containsKey(email) == false) {
            return;
        }
        
        for(String nei : adj.get(email)) {
            if(!visited.contains(nei)) {
                dfs(mergedAccount, nei);
            }
        }
    }
}