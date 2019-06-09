package hasmap;

public interface MyMap<K, V> {

	// 向集合中插入数据
	public V put(K k, V v);

	// 根据k 从Map集合中查询元素
	public V get(K k);

	// 获取集合元素个数
	public int size();

	// Entry的作用 === Node节点
	interface Entry<K, V> {
		K getKey();

		V getValue();

		V setValue(V value);
	}
}
