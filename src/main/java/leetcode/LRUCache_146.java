package leetcode;

import java.util.HashMap;

/**
 * 146. LRU缓存机制
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * <p>
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * <p>
 *  
 * <p>
 * 进阶:
 * <p>
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * LRUCache cache = new LRUCache( 2 /* 缓存容量);
 * <p>
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // 返回  1
 * cache.put(3,3);    // 该操作会使得密钥 2 作废
 * cache.get(2);       // 返回 -1 (未找到)
 * cache.put(4,4);    // 该操作会使得密钥 1 作废
 * cache.get(1);       // 返回 -1 (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 */

public class LRUCache_146 {
    HashMap<Integer, Node> map;
    DoubleList cache;
    int capacity;

    public LRUCache_146(int capacity) {
        this.capacity = capacity;
        cache = new DoubleList();
        map = new HashMap<Integer, Node>();
    }

    public int get(int key) {
        Node node = map.get(key);
        //不存在
        if (node == null) {
            return -1;
        }
        //存在，更新到双链表头部
        cache.removeNode(node);
        cache.addFirstNode(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        //存在
        if (node != null) {
            cache.removeNode(node);
            //更新链表中值
            node.value = value;
            cache.addFirstNode(node);
            //更新map中值
            map.put(key, node);
        }
        //不存在
        else {
            Node newNode = new Node(key, value);
            //已达到容量上限
            if (cache.getSize() == capacity) {
                //删除尾部
                Node last = cache.removeLastNode();
                map.remove(last.key);
            }
            //添加到头部
            cache.addFirstNode(newNode);
            map.put(key, newNode);
        }
    }
}
