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
            int startword = j+1;
            int endword = startword + len;
            i = endword;
            res.add(str.substring(startword,endword));
        }
        return res;
    }
}
