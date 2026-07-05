class Solution {
    public String foreignDictionary(String[] words) {
      List<List<Integer>> adj = new ArrayList<>();
      for(int i = 0;i < 26;i++){
            adj.add(new ArrayList<>());
      }
        int[] inDegree = new int[26];
        boolean[] exist = new boolean[26];
        int uniqueChar = 0;

        for(String word : words){
            for(char c : word.toCharArray()){
                if(!exist[c-'a']){
                    exist[c-'a'] = true;
                    uniqueChar++;
                }
            }
        }

      for(int i = 0;i < words.length-1;i++){
        String s1 = words[i];
        String s2 = words[i+1];

        if(s1.length() > s2.length() && s1.startsWith(s2)){
            return "";
        }

        int len = Math.min(s1.length(),s2.length());

        for(int j = 0;j < len;j++){
            if(s1.charAt(j) != s2.charAt(j)){
                adj.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
                inDegree[s2.charAt(j)-'a']++;
                break;
            }
        }
      }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i < 26;i++){
            if(exist[i] && inDegree[i] == 0){
                queue.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            int u = queue.poll();
            sb.append((char)(u+'a'));
            for(int v : adj.get(u)){
                inDegree[v]--;
                if(inDegree[v] == 0){
                    queue.offer(v);
                }
            }
        }
        if(sb.length() != uniqueChar) return "";
        return sb.toString();
    }
}
