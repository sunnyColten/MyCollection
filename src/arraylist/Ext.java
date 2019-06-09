package arraylist;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

public class Ext {
	private Map<String, Integer> score;

	public static void main(String[] args) throws NoSuchFieldException, SecurityException {
		Class<Ext> clazz = Ext.class;
		Field f = clazz.getDeclaredField("score");

		Class<?> a = f.getType();
		System.out.println("score类型是：" + a);
		Type eType = f.getGenericType();

		if (eType instanceof ParameterizedType) {
			ParameterizedType pType = (ParameterizedType) eType;
			Type rType = pType.getRawType();
			Type[] tArgs = pType.getActualTypeArguments();
			for (int i = 0; i < tArgs.length; i++) {
				System.out.println("第" + i + "泛型类型是：" + tArgs[i]);
			}
		}
	}
}