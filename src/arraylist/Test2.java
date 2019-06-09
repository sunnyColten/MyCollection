package arraylist;

import arraylist.MyArrayList;

public class Test2 {

	public static void main(String[] args) {
		// 1.jdk 1.7之后 数组默认数据大小代码存放在add方法 (JDK1.6的时候 默认构造函数初始化elementData大小)
		// 2.arraylist底层采用数组实现 数组名称elementData
		// 3.arraylist底层数组默认初始化为10
		// myArrayList myArrayList = new myArrayList();
		// myArrayList.get(index)
		// 原来本身elementData容量大小 2
		// int oldCapacity = 1;
		// 新数据容量大小 (oldCapacity >> 1)=oldCapacity
		// int newCapacity = oldCapacity + (oldCapacity >> 1);
		// System.out.println(newCapacity);

		// ArrayList arrayList = new ArrayList<String>();
		//// arrayList.get("");
		// arrayList.add("")
		// myArrayList myArrayList = new myArrayList(2);
		// myArrayList.add("张三");
		// myArrayList.add("李四");
		// myArrayList.add("王武");
		// System.out.println(myArrayList.get(0));
		MyArrayList myArrayList = new MyArrayList(1);
		myArrayList.add("11");
		myArrayList.add("5444");
		myArrayList.add("789");
		System.out.println(myArrayList.get(0));
	}

}
