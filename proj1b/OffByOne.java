public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y){
        if((int)x >(int)y){
            if((x-y) == 1) return true;
        }else{
            if((y-x) == 1) return true;
        }
        return false;
    }

}
