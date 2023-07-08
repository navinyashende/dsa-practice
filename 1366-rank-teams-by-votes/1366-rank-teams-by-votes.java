class Solution {
    public String rankTeams(String[] votes) {
        Map<Character, int []> teamsMap = new HashMap<>();
        int n = votes[0].length();
        
        for(String vote: votes) {
            for(int i = 0; i < n; i++) {
                Character team = vote.charAt(i);
                teamsMap.put(team, teamsMap.getOrDefault(team, new int[n]));
                teamsMap.get(team)[i]++;
            }    
        }
        List<Character> resList = new ArrayList<>(teamsMap.keySet());
        Collections.sort(resList, (a, b) -> {
            for(int i = 0; i < n; i++) {
                if(teamsMap.get(a)[i] != teamsMap.get(b)[i]) {
                    return teamsMap.get(b)[i] -teamsMap.get(a)[i];
                }
            }
            return a - b;
        });
        StringBuilder sb = new StringBuilder();            
        for(Character c:resList) {
            sb.append(c);
        }
        return sb.toString();
    }
}