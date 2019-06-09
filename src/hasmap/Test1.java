package hasmap;

@SuppressWarnings("unchecked")
public class Test1 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		MyMap myHashMap = new MyHashMap<String, String>();
		for (int i = 0; i < 100000; i++) {
			myHashMap.put(i + "", i + "");
		}
		for (int i = 0; i < 100000; i++) {
			myHashMap.get("" + i + "");
			// System.out.println(myHashMap.get("" + i + ""));
		}
		// 70 68 87 75
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		// // 修改3号之后
		// System.out.println(myHashMap.get("3号"));
		// // System.out.println("扩容之前获取数据:" + myHashMap.get("1号"));
		// // myHashMap.print();
		// // System.out.println();
		// // // myHashMap.put(14 + "号", 14 + "号");
		// // // myHashMap.put(1 + "号", "4444号");
		// // System.out.println("扩容之后获取数据:" + myHashMap.get("1号"));

	}
}
