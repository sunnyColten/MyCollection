package arraylist;

import java.util.Arrays;

public class Test1 {

	// 1.底层采用数组方式
	// 2.怎么保证集合存放无限大小---数组扩容技术
	public static void main(String[] args) {
		// Object[] objects = { 1, 2 };
		// System.out.println(objects.length);
		// System.out.println("#################################");
		
		//返回新的数组,将原来的数组的长度为2，现在扩容为10,原来本身的数据不变.
		// Object[] copyNewObjects = Arrays.copyOf(objects, 10);
		// System.out.println("copyNewObjects:" + copyNewObjects.length);
		
		int[] fun = { 0, 1, 2, 3, 4, 5, 6 };
		//src原数组, srcPos起始位置, dest目标数组 , destPos目标起始位置 , length 复制长度
		System.arraycopy(fun, 3, fun, 0, 4);
		// 3456456
		for (int i : fun) {
			System.out.print(i);
		}
	}

}
