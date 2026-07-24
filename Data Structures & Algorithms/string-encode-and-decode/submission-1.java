class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < strs.size();i++){
            int len = strs.get(i).length();
            sb.append(len).append("#").append(strs.get(i));
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while(i < str.length()){
            int j = i;
            while(str.charAt(j) != '#'){
                j++;
            }
            int len = Integer.parseInt(str.substring(i,j));

            int startOfWord = j + 1;
            int endOfWord = startOfWord + len;
            res.add(str.substring(startOfWord,endOfWord));

            i = endOfWord;
        }
        return res;
    }
}
