package arraylist;

import java.util.Arrays;

public class MyArrayList<E> implements MyList<E> {
	//ArrayList底层采用数组存放
	private Object[] elementData;
	//默认数组容量
	private static final int DEFAULT_CAPACITY = 10;
	//记录实际ArrayList大小
	private int size;

	public MyArrayList(int initialCapacity) {
		if (initialCapacity < 0) {
			throw new IllegalArgumentException("初始容量不能小于0");
		}
		elementData = new Object[initialCapacity];
	}

	// 默认初始化容量为10;
	public MyArrayList() {
		this(DEFAULT_CAPACITY);
	}

	public void add(E e) {
		// 1.判断实际存放的数据容量是否大于elementData容量
		ensureExplicitCapacity(size + 1);
		// 2.使用下标进行赋值
		elementData[size++] = e;
	}

	public void add(int index, Object object) {
		//1.容量检查，如需要扩容则进行扩容。
		ensureExplicitCapacity(size + 1);
		System.arraycopy(elementData, index, elementData, index + 1, size - index);
		elementData[index] = object;
		size++;
	}

	//minCapacity为扩容时最少需要的容量  
	private void ensureExplicitCapacity(int minCapacity) {
		if (size == elementData.length) {
			//获取当前数组的容量
			int oldCapacity = elementData.length;
			
			//需要扩容的容量。新容量=当前容量+当前容量/2,即将当前容量增加一半
			int newCapacity = oldCapacity + (oldCapacity >> 1);
			
			//如果newCapacity还是小于扩容时最少需要的容量 ，将newCapacity设置为扩容时最少需要的容量。
			//	这么做的原因是因为如果初始容量为1的时候,经过上面扩容后newCapacity还是1,相当于没扩容，会出问题
			if (newCapacity - minCapacity < 0)
				newCapacity = minCapacity;
			
			elementData = Arrays.copyOf(elementData, newCapacity);
		}
	}

	// 使用下标获取数组元素
	public E get(int index) {
		rangeCheck(index);
		return elementData(index);
	}

	E elementData(int index) {
		return (E) elementData[index];
	}

	//通过索引删除操作原理:
	//1.如果删除指定位置的元素后面还要元素，则将后面的元素向前移动，再将移动后多出来的那个数据置null
	//2.如果后面没有元素，则直接将删除元素置为null
	public E remove(int index) {
		// 1.返回要删除的元素(get(index)包括了下标检查)
		E object = get(index);
		// 删除元素后，需要左移的元素个数
		int numMoved = size - index - 1;
		// 如果有需要左移的元素，就移动(移动后，该删除元素就被覆盖了)
		if (numMoved > 0)
			System.arraycopy(elementData, index + 1, elementData, index, numMoved);
		//size减1，为了让GC起作用，必须显示的将不再存数据的那个位置置为null
		elementData[--size] = null;// 将最后一个元素变为空
		//返回删除的元素
		return object;
	}

	//删除相同元素删除第一个
	public boolean remove(Object object) {
		for (int i = 0; i < elementData.length; i++) {
			Object value = elementData[i];
			if (value.equals(object)) {
				remove(i);
				return true;
			}
		}
		return false;
	}

	private void rangeCheck(int index) {
		if (index >= size)
			throw new IndexOutOfBoundsException("越界啦!");
	}

	public int getSize() {
		return size;
	}

}
