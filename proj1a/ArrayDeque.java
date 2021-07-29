public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int first;
    private int last;
    private int cap;

    public ArrayDeque() {
        cap = 8;
        first = cap - 1;
        last = 0;
        size = 0;
        items = (T[]) new Object[cap];
    }

    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
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
        first = cap - 1;
        items = a;
    }

    public ArrayDeque(ArrayDeque other) {
        this.cap = 8;
        this.first = cap - 1;
        this.last = 0;
        this.size = 0;
        this.items = (T[]) new Object[cap];
        int t = other.size;
        int i = 0;
        while (t-- > 0) {
            this.addLast((T) other.get(i++));
        }
    }

    public boolean isFull() {
        return (size == cap);
    }

    public void addFirst(T item) {
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

    public void addLast(T item) {
        if (isFull()) {
            resize(cap * 2);
            cap *= 2;
        }
        items[last++] = item;
        if (last == cap) last = 0;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size();
    }

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

    public T removeFirst() {
        first++;
        if (first >= cap) first = 0;
        T t = items[first];
        items[first] = null;
        size--;
        if (size <= (cap * 0.25) && cap >= 16) {
            resize((int) cap / 2);
            cap = (int) (cap / 2);
        }
        return t;
    }

    public T removeLast() {
        last++;
        if (last >= cap) last = 0;
        T t = items[last];
        items[last] = null;
        size--;
        if (size <= cap * 0.25 && cap >= 16) {
            resize((int) cap / 2);
            cap = (int) (cap / 2);
        }
        return t;
    }

    public T get(int index) {
        int t = index + first;
        if (t >= cap) {
            t %= cap;
        }
        return items[t];
    }
}
