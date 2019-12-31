package leetcode.month09;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: DuanTong
 * @Date: 2019/9/13 11:36
 *
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 */
public class Solution0913 {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        System.out.println(cache.get(2));
        cache.put(2, 6);
        System.out.println(cache.get(1));
        cache.put(1,5);
        cache.put(1,2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }

}

class LRUCache {

    private int capacity;
    private Map<Integer,Integer> cacheMap = new HashMap<>();
    private int pass = Integer.MIN_VALUE;
    private List<Integer> cacheList = new ArrayList<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (cacheList.size() == capacity && cacheMap.get(key) == null)
            return -1;
        if (cacheList.contains(key)){
            cacheList.remove(cacheList.indexOf(key));
            cacheList.add(key);
        }else if (cacheList.size() < capacity) {
            cacheList.add(key);
        }else if (cacheList.size() == capacity){
            cacheList.remove(cacheList.indexOf(pass));
            cacheList.add(key);
        }
        pass = cacheList.get(0);
        return cacheMap.get(key) == null ? -1 : cacheMap.get(key);
    }

    public void put(int key, int value) {
        if (cacheMap.size() < capacity || cacheMap.get(key) != null){
            cacheMap.put(key,value);
        }
        else{
            cacheMap.remove(pass);
            cacheMap.put(key,value);
        }
        get(key);
    }
}
