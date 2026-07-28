class WordDictionary {
    class TrieNode{
        TrieNode[] children;
        boolean isEndOfWord;
        TrieNode(){
            children = new TrieNode[26];
            isEndOfWord = false;
        }
    }

    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode crawler = root;
        for(int i = 0;i < word.length();i++){
            int index = word.charAt(i) - 'a';
            if(crawler.children[index] == null){
                crawler.children[index] = new TrieNode();
            }
            crawler = crawler.children[index];
        }
        crawler.isEndOfWord = true;
    }

    public boolean search(String word) {
        return searchUtil(root,word,0);
    }

    public boolean searchUtil(TrieNode crawler,String word,int startIndex){
        for(int i = startIndex;i < word.length();i++){
            char ch = word.charAt(i);
            if(ch == '.'){
                for(int j = 0;j < 26;j++){
                    if(crawler.children[j] != null){
                        if(searchUtil(crawler.children[j],word,i+1)){
                            return true;
                        }
                    }
                }
                return false;
            }
            else{
                int index = ch - 'a';
                if(crawler.children[index] == null) return false;
                crawler = crawler.children[index];
            }
        }
        return crawler != null && crawler.isEndOfWord;
    }
}
