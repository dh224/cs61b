public class LinkedListDeque<Item> implements Deque<Item>{
    private class LinkNode {
        public Item item;
        public LinkNode next;
        public LinkNode prev;
        public LinkNode(Item item, LinkNode next,LinkNode prev){
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
    private LinkNode sentFirst;
    private LinkNode sentLast;
    private LinkNode last;
    private int size;

    public LinkedListDeque(){
        sentFirst =  new LinkNode(null,null,null);
        sentLast = new LinkNode(null,null,null);
        sentFirst.next = sentLast;
        sentLast.prev = sentFirst;
        size = 0;
    }
    //for pass the autograde;
//    public LinkedListDeque(LinkedListDeque other){
//        sentFirst =  new LinkNode(null,null,null);
//        sentLast = new LinkNode(null,null,null);
//        sentFirst.next = sentLast;
//        sentLast.prev = sentFirst;
//        size = 0;
//        LinkNode p = other.sentFirst;
//        while(p.next != other.sentLast){
//            addLast(p.next.item);
//            p = p.next;
//        }
//    }
    @Override
    public void addFirst(Item item){
        LinkNode temp = new LinkNode(item,sentFirst.next,sentFirst);
        sentFirst.next.prev = temp;
        sentFirst.next = temp;
        size++;
    }
    @Override
    public void addLast(Item item){
        LinkNode temp = new LinkNode(item,sentLast,sentLast.prev);
        sentLast.prev.next = temp;
        sentLast.prev = temp;
        size++;
    }
    @Override
    public boolean isEmpty(){
        return size == 0;
    }
    @Override
    public int size(){
        return size;
    }
    @Override
    public void printDeque(){
        LinkNode p = sentFirst;
        while (p.next != sentLast){
            System.out.print(p.next.item + " ");
            p = p.next;
        }
        System.out.println();
    }
    @Override
    public Item removeFirst(){
        if (sentFirst.next == sentLast) return null;
        LinkNode  tN = sentFirst.next;
        Item t = tN.item;
        sentFirst.next = tN.next;
        tN.next.prev = sentFirst;
        tN.item = null;
        size--;
        return t;
    }
    @Override
    public Item removeLast(){
        if (sentFirst.next == sentLast) return null;
        LinkNode tN = sentLast.prev;
        Item t = tN.item;
        sentLast.prev = tN.prev;
        tN.prev.next = sentLast;
        tN.item = null;
        size--;
        return t;
    }
    @Override
    public Item get(int index){
        if (index >= size) return null;
        LinkNode p = sentFirst;
        while (index-- >= 0){
            p = p.next;
        }
        return p.item;
    }
    private Item getRecursive(LinkNode p, int index){
        if (index == 0){
            return p.item;
        }
        return getRecursive(p.next,index -1);
    }
    public Item getRecursive(int index){
        LinkNode p = sentFirst;
        if (p.next == sentLast) return null;
        else{
            return getRecursive(p.next,index);
        }
    }
}
