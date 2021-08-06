public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        ArrayDeque<Character> ans = new ArrayDeque<Character>();
        for(int i=0;i<word.length();i++){
            ans.addLast(word.charAt(i));
        }
        return ans;
    }
    public boolean isPalindrome(String word){
        ArrayDeque<Character> temp ;
        temp = (ArrayDeque<Character>) wordToDeque(word);
        int i=0;
        for(;i<=temp.size() / 2;i++){
            if(temp.size() > 1){
                if(temp.removeFirst() != temp.removeLast()){
                    return false;
                }
            }else{
                return true;
            }
        }
        return true;
    }
    public boolean isPalindrome(String word, CharacterComparator cc){
        if(word.length()<=1) return true;
        ArrayDeque<Character> temp ;
        temp = (ArrayDeque<Character>) wordToDeque(word);
        int i=0;
        for(;i<=temp.size();i++){
            if(temp.size() > 1){
                if(!cc.equalChars(temp.removeFirst(),temp.removeLast())){
                    return false;
                }
            }else{
                return true;
            }
        }
        return true;
    }

}
