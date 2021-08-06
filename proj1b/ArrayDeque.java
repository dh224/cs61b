public class ArrayDeque<Item> implements Deque<Item>{
    private Item[] items;
    private int size;
    private int first;
    private int last;
    private int cap;

    public ArrayDeque() {
        cap = 8;
        first = cap - 1;
        last = 0;
        size = 0;
        items = (Item[]) new Object[cap];
    }

    private void resize(int capacity) {
        Item[] a = (Item[]) new Object[capacity];
        int f = first;
        int t = size;
        int i = 0;
        f++;
        if (f >= cap) {
            f = 0;
        }
        while (t-- > 0) {
            if (f >= cap) f = 0;
            a[i++] = items[f++];
        }
        last = size;
        first = capacity - 1;
        items = a;
    }
    //for pass the autograde ;
//    public ArrayDeque(ArrayDeque other) {
//        this.cap = 8;
//        this.first = cap - 1;
//        this.last = 0;
//        this.size = 0;
//        this.items = (T[]) new Object[cap];
//        int t = other.size;
//        int i = 0;
//        while (t-- > 0) {
//            this.addLast((T) other.get(i++));
//        }
//    }

    private boolean isFull() {
        return (size == cap);
    }
    @Override
    public void addFirst(Item item) {
        if (isFull()) {
            resize(cap * 2);
            cap *= 2;
        }
        items[first--] = item;
        if (first < 0) {
            first = cap - 1;
        }
        size++;
    }
    @Override
    public void addLast(Item item) {
        if (isFull()) {
            resize(cap * 2);
            cap *= 2;
        }
        items[last++] = item;
        if (last == cap) last = 0;
        size++;
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public void printDeque() {
        int f = first;
        int t = size;
        f++;
        if (f >= cap) {
            f = 0;
        }
        while (t-- > 0) {
            if (f >= cap) f = 0;
            System.out.print(items[f++] + " ");
        }
        System.out.println();
    }
    @Override
    public Item removeFirst() {
        if(isEmpty()) return null;
        first++;
        if (first >= cap) first = 0;
        Item t = items[first];
        items[first] = null;
        size--;
        if (size <= (cap * 0.25) && cap >= 16) {
            resize((int) cap / 2);
            cap = (int) (cap / 2);
        }
        return t;
    }
    @Override
    public Item removeLast() {
        if(isEmpty()) return null;
        last--;
        if (last <0) last = cap -1;
        Item t = items[last];
        items[last] = null;
        size--;
        if (size <= cap * 0.25 && cap >= 16) {
            resize(cap / 2);
            cap = (cap / 2);
        }
        return t;
    }
    @Override
    public Item get(int index) {
        int t = index + first + 1;
        if (t >= cap) {
            t %= cap;
        }
        return items[t];
    }
}
