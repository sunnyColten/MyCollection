package hasmap;

public class MyHashMap<K, V> implements MyMap<K, V> {

	// 1.定义table 存放HasMap 数组元素 默认是没有初始化容器 懒加载
	Node<K, V>[] table = null;
	// 2. 实际用到table 存储容量 大小
	int size;
	// 3.HashMap默认负载因子，负载因子越小，hash冲突机率越低
	float DEFAULT_LOAD_FACTOR = 0.5f;
	// 4.table默认初始大小 16
	static int DEFAULT_INITIAL_CAPACITY = 16; // 16

	public V put(K key, V value) {
		// 1.判断table 数组大小是否为空（如果为空的情况下 ，做初始化操作）
		if (table == null) {
			table = new Node[DEFAULT_INITIAL_CAPACITY];
		}
		
		// 2.判断是否需要扩容
		// 实际存储大小=负载因子*初始容量=DEFAULT_LOAD_FACTOR0.75*DEFAULT_INITIAL_CAPACITY16=12
		// 如果size>12的时候就需要开始扩容数组,扩容数组大小之前两倍
		if (size > (DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY)) {
			// 需要开始对table进行属数组扩容
			resize();
		}

		// 3.取出hash值指定下标位置对应的那个Node
		int index = getIndex(key, DEFAULT_INITIAL_CAPACITY);
		Node<K, V> indexNode = table[index];
		Node<K, V> newNode = null;
		
		// 4.没有发生hash冲突(index冲突)问题
		if (indexNode == null) {
			
			newNode = new Node<K, V>(key, value, null);
			size++;
			
		// 5.发生hash冲突(index冲突)问题
		} else {
			Node<K, V> curNode = indexNode;
			//遍历链表的元素
			while (curNode != null) {
				// 1.key相同，修改值
				//这里即用到了equals和==是因为 k有可能被重写hashCode方法，并且k有可能是基本数据类型(用==比较)。
				//equals和==位置不能调换，因为如果k被重写hashCode，假如==在前，比较的是对象的地址
				if (curNode.getKey().equals(key) || curNode.getKey() == key) {
					return curNode.setValue(value);
					
				//2 key不同，添加到链表末尾
				//		两种情况: 1.hascode不同但取模余数相同  2.或者hashCode 相同
				} else if (curNode.next == null){
					
					// 说明遍历到最后一个node且该操作不是修改值。创建新的node，下一个结点为indexNode
						newNode = new Node<K, V>(key, value, indexNode);
						size++;
				}
				//取链表下一个node
				curNode = curNode.next;
			}
		}
		//将新创建的node放在table[index]
		table[index] = newNode;
		return null;
	}

	// 对table进行扩容
	private void resize() {

		// 1.生成新的table 是之前的两倍的大小 DEFAULT_INITIAL_CAPACITY*2
		Node<K, V>[] newTable = new Node[DEFAULT_INITIAL_CAPACITY << 1];
		// 2.重新计算index索引,存放在新的table里面
		for (int i = 0; i < table.length; i++) {
			//存放在之前的table的Node
			Node<K, V> oldNode = table[i];
			//遍历该链表，将oldTable的值一个个放进新的table中
			while (oldNode != null) {
				//table[i] = null;// 赋值为null---为了垃圾回收机制能够回收 将之前的node删除

				//1.重新计算该Node在新table的index
				K oldK = oldNode.key;
				int newIndex = getIndex(oldK, newTable.length);
				
				//2.这里记录oldNext，因为下面将oldNodex.next指向新table的结点
				Node<K, V> oldNext = oldNode.next;
				
				//3.oldNode每次都插入newTable[newIndex]，如果newTable[newIndex]已经有值，则形成链表
					oldNode.next = newTable[newIndex];
					newTable[newIndex] = oldNode;
				
				//4.继续取oldNext
				oldNode = oldNext;
			}
		}
		// 3.将newtable赋值给老的table
		table = newTable;
		DEFAULT_INITIAL_CAPACITY = newTable.length;
		newTable = null;// 赋值为null---为了垃圾回收机制能够回收
	}
	
	public int getIndex(K k, int length) {
		int hashCode = k.hashCode();
		int index = hashCode % length;
		return index;
	}

	public V get(K k) {

		Node<K, V> node = getNode(table[getIndex(k, DEFAULT_INITIAL_CAPACITY)], k);
		return node == null ? null : node.value;
	}

	public Node<K, V> getNode(Node<K, V> node, K k) {
		while (node != null) {
			if (node.getKey().equals(k)) {
				return node;
			}
			node = node.next;
		}
		return null;
	}

	public int size() {

		return size;
	}
	
	// 测试方法.打印所有的链表元素
	void print() {

		for (int i = 0; i < table.length; i++) {
			Node<K, V> node = table[i];
			System.out.print("下标位置[" + i + "]");
			while (node != null) {
				System.out.print("[ key:" + node.getKey() + ",value:" + node.getValue() + "]");
				node = node.next;
				// if (node.next != null) {
				// node = node.next;
				// } else {
				// // 结束循环
				// node = null;
				// }
			}
			System.out.println();
		}
	}
	
	// 定义节点
	class Node<K, V> implements Entry<K, V> {
		// 存放Map 集合 key
		private K key;
		// 存放Map 集合 value
		private V value;
		// 下一个节点Node
		private Node<K, V> next;

		public Node(K key, V value, Node<K, V> next) {
			super();
			this.key = key;
			this.value = value;
			this.next = next;
		}

		public K getKey() {
			return this.key;
		}

		public V getValue() {
			return this.value;
		}

		public V setValue(V value) {
			// 设置新值的返回老的 值
			V oldValue = this.value;
			this.value = value;
			return oldValue;
		}

	}

}
