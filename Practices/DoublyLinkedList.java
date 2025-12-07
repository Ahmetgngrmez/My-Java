public class DoublyLinkedList<E> {

    // -------------------------------------------------------------------------
    // 1. NESTED NODE CLASS (Düğüm Sınıfı - Sayfa 28)
    // -------------------------------------------------------------------------
    private static class Node<E> {
        private E element;      // Düğümdeki veri
        private Node<E> prev;   // Önceki düğüm referansı
        private Node<E> next;   // Sonraki düğüm referansı

        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }

        // Getter ve Setter Metotları
        public E getElement() { return element; }
        public Node<E> getPrev() { return prev; }
        public Node<E> getNext() { return next; }
        public void setPrev(Node<E> p) { prev = p; }
        public void setNext(Node<E> n) { next = n; }
    }
    // -------------------------------------------------------------------------

    // 2. INSTANCE VARIABLES (Sınıf Değişkenleri - Sayfa 29)
    // -------------------------------------------------------------------------
    private Node<E> header;     // Başlangıç kukla düğümü
    private Node<E> trailer;    // Bitiş kukla düğümü
    private int size = 0;       // Eleman sayısı

    // 3. CONSTRUCTOR (Yapıcı Metot - Sayfa 29)
    // -------------------------------------------------------------------------
    public DoublyLinkedList() {
        // Başlangıçta boş bir liste oluşturuyoruz (sadece kuklalar var)
        header = new Node<>(null, null, null);      // Header oluştur
        trailer = new Node<>(null, header, null);   // Trailer oluştur, öncesi header olsun
        header.setNext(trailer);                    // Header'ın sonrası trailer olsun
    }

    // 4. ACCESS METHODS (Erişim Metotları - Sayfa 29)
    // -------------------------------------------------------------------------
    public int size() { return size; }  //

    public boolean isEmpty() { return size == 0; } //

    public E first() {
        if (isEmpty()) return null;
        return header.getNext().getElement(); // İlk eleman header'dan sonrakidir
    }

    public E last() {
        if (isEmpty()) return null;
        return trailer.getPrev().getElement(); // Son eleman trailer'dan öncekidir
    }

    // 5. PUBLIC UPDATE METHODS (Güncelleme Metotları - Sayfa 30)
    // -------------------------------------------------------------------------
    public void addFirst(E e) {
        addBetween(e, header, header.getNext()); // Header ile sonrasının arasına ekle
    }

    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer); // Trailer ile öncesinin arasına ekle
    }

    public E removeFirst() {
        if (isEmpty()) return null;
        return remove(header.getNext()); // Header'dan sonrakini sil
    }

    public E removeLast() {
        if (isEmpty()) return null;
        return remove(trailer.getPrev()); // Trailer'dan öncekini sil
    }

    // 6. PRIVATE HELPER METHODS (Yardımcı Metotlar - Sayfa 31)
    // Bu metotlar asıl işi yapan "sihirli" kısımlardır.
    // -------------------------------------------------------------------------
    
    // İki düğüm arasına yeni eleman ekler
    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        // Yeni düğümü oluştur, önü ve arkasını bağla
        Node<E> newest = new Node<>(e, predecessor, successor);
        
        predecessor.setNext(newest); // Öndekinin next'ini güncelle
        successor.setPrev(newest);   // Arkadakinin prev'ini güncelle
        size++;                      // Boyutu arttır
    }

    // Verilen düğümü listeden siler
    private E remove(Node<E> node) {
        Node<E> predecessor = node.getPrev(); // Silineceğin önündeki
        Node<E> successor = node.getNext();   // Silineceğin arkasındaki
        
        predecessor.setNext(successor);       // Öndekini arkadakine bağla
        successor.setPrev(predecessor);       // Arkadakini öndekine bağla
        size--;                               // Boyutu azalt
        
        return node.getElement();             // Silinen veriyi döndür
    }
}