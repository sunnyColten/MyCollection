package hasmap;

public class Test2 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		MyHashMap myHashMap = new MyHashMap<String, String>();
		myHashMap.put("1号", "1号");// 0
		myHashMap.put("2号", "1号");// 1
		myHashMap.put("3号", "1号");// 2
		myHashMap.put("4号", "1号");// 3
		myHashMap.put("5号", "1号");// 4
		myHashMap.put("6号", "1号");// 5
		myHashMap.put("7号", "1号");
		myHashMap.put("14号", "1号");
		myHashMap.put("66号", "66");
		System.out.println("扩容前数据....");
		myHashMap.print();

		myHashMap.put("22号", "1号");
		myHashMap.put("26号", "1号");
		myHashMap.put("27号", "1号");
		myHashMap.put("28号", "1号");
		myHashMap.put("30号", "1号");
		// 修改
		myHashMap.put("66号", "123456");
		myHashMap.put("3号", "3号");
		System.out.println("扩容前数据....");
		myHashMap.print();
	}
}
