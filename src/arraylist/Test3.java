package arraylist;

import arraylist.MyArrayList;
import arraylist.MyList;

public class Test3 {

	public static void main(String[] args) {

		// MyArrayList MyArrayList = new MyArrayList();
		// MyArrayList.add("a");
		// MyArrayList.add("b");
		// MyArrayList.add("c");
		// MyArrayList.add("d");
		// MyArrayList.add("e");
		// MyArrayList.remove("d");
		// // MyArrayList.remove(4);
		// for (int i = 0; i < MyArrayList.getSize(); i++) {
		// System.out.println(MyArrayList.get(i));
		// }
		// 反射机制 不能够获取泛型类型
		MyList<String> MyArrayList = new MyArrayList<String>();
		MyArrayList.add("a");
		MyArrayList.add("b");
		MyArrayList.add("c");
		MyArrayList.add("d");
		MyArrayList.add("e");
		for (int i = 0; i < MyArrayList.getSize(); i++) {
			System.out.println(MyArrayList.get(i));
		}
	}
}
