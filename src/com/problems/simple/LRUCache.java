package com.problems.simple;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
	class Node {
		int key;
		int value;
		Node prevNode;
		Node nextNode;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
			prevNode = null; // previously Accessed node
			nextNode = null; // the node that is accessed next (after this node)
		}
	}

	// Map<Integer, Integer> cache;
	Map<Integer, Node> dupCache;
	int capacity;
	Node head, tempNode, tail;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		// cache = new HashMap<Integer, Integer>();
		dupCache = new HashMap<Integer, Node>();
		head = null;
		tempNode = null;
		tail = null;
	}

	public int get(int key) {
		if (dupCache.get(key) == null)
			return -1;
		else {
			setRecent(key);
			return dupCache.get(key).value;
		}
	}

	public void put(int key, int value) {
		if (dupCache.get(key) != null) {
			dupCache.get(key).value = value;
			setRecent(key);
		} else if (dupCache.size() < capacity) {

			addNode(key, value);

		} else {
			removeOldestEntry();
			addNode(key, value);
		}
	}

	private void removeOldestEntry() {
		if (tail != null) {
			dupCache.remove(tail.key);
			tempNode = tail.prevNode;
			tail = null;
			tail = tempNode;
			if (tail != null)
				tail.nextNode = null;
		}
	}

	private void addNode(int key, int value) {
		if (head == null) {
			head = new Node(key, value);
			tail = head;
			dupCache.put(key, head);
		} else {
			tempNode = head;
			head = new Node(key, value);
			head.nextNode = tempNode;
			tempNode.prevNode = head;
			dupCache.put(key, head);
		}
	}

	private void setRecent(int key) {
		Node recNode = dupCache.get(key);
		if (recNode.key == head.key) {
			return;
		}
		if (recNode.key == tail.key) {
			tail = tail.prevNode;
			tail.nextNode = null;
		} else {
			tempNode = recNode.prevNode;
			tempNode.nextNode = recNode.nextNode;
			recNode.nextNode.prevNode = tempNode;
		}
		recNode.nextNode = head;
		recNode.prevNode = null;
		head.prevNode = recNode;
		head = recNode;
	}

	public static void main(String[] args) {
		LRUCache lru = new LRUCache(3);
		lru.put(1, 1);
		lru.put(2, 2);
		lru.put(3, 3);
		lru.put(4, 4);

		System.out.println(lru.get(4) == 4);
		System.out.println(lru.get(3) == 3);
		System.out.println(lru.get(2) == 2);
		System.out.println(lru.get(1) == -1);
		lru.put(5, 5);
		System.out.println(lru.get(1) == -1);
		System.out.println(lru.get(2) == 2);
		System.out.println(lru.get(3) == 3);
		System.out.println(lru.get(4) == -1);
		System.out.println(lru.get(5) == 5);

		LRUCache lru2 = new LRUCache(1);
		lru2.put(2, 1);
		System.out.println(lru2.get(2) == 1);
		lru2.put(3, 2);
		System.out.println(lru2.get(2) == -1);
		System.out.println(lru2.get(3) == 2);
	}
}