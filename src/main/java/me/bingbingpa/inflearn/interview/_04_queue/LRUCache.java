package me.bingbingpa.inflearn.interview._04_queue;

public class LRUCache {
    private int cacheSize;

    public LRUCache(int cacheSize) {
        this.cacheSize = cacheSize;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.query(1);
        lruCache.query(2);
        lruCache.query(3);
        lruCache.query(1);
        lruCache.query(4);
        lruCache.query(5);
        lruCache.query(2);
        lruCache.query(2);
        lruCache.query(1);
        lruCache.print();
    }

    /**
     * TODO 문제. LRU 캐시를 구현하라
     *  최대 n개 만큼의 가장 최근에 접근한 데이터를 캐싱하는 LRU (least recently used) 캐시를 구현하라.
     *  입력값 number는 1부터 100까지의 숫자가 랜덤하게 입력된다. 그 중에 최대 n (1보다 크고 9보다 작은)개 만큼의 데이터만 캐시할 수 있다. n개를 넘는 새로운 값이 들어오면 그 중에서 가장 오래전에 접근한 데이터를 삭제하고 number를 캐시에 추가한다.
     *  다음 오퍼레이션을 구현하라.
     *  query(int number): number에 해당하는 입력값을 캐시에 추가한다.
     *  print() 현재 캐시하고 있는 데이터를 출력한다.
     */
    private void query(int number) {
    }

    private void print() {

    }
}
