public class OffByN implements CharacterComparator{
    private int n;
    @Override
    public boolean equalChars(char x, char y){
        if((int)x >(int)y){
            if((x-y) == this.n) return true;
        }else{
            if((y-x) == this.n) return true;
        }
        return false;
    }

    public OffByN(int n){
        this.n = n;
    }
}
