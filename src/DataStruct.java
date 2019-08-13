import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class DataStruct {

}

//java集合的链表学习测试
class LinkedListTest {
	public static List<String> words = new LinkedList<String>();

	//面向对象的语言都是通过构建类的方法来传递代码块
	static {
		//链表的增加元素
		words.add("刘鑫");
		words.add("李尧");
		words.add("刘娟");
		String st;
		//集合中元素都有一个迭代器方法，生成一个迭代器
		//java的迭代器 Collection接口的iterator方法生成的迭代器
		Iterator<String> iter = words.iterator();
		//迭代器的遍历
		st = iter.next();
		System.out.println("第一个元素:" + st);
		st = iter.next();
		System.out.println("该集合的的元素个数是" + words.size());
		System.out.println("第二个元素:" + st);

		try {
			st = iter.next();
			iter.remove();
		} catch (Exception e1) {
			System.out.println("出现了一个异常" + e1.getClass().getName());
		} finally {
			System.out.println("第三个元素" + st);
		}
		System.out.println("元素遍历");
		words.add("杨师傅");
		int i = 1;
		for (String st1 : words) {
			System.out.println("第" + i + "个元素" + st1);
			i++;
		}
		System.out.println("查看迭代器中的元素");
		i = 1;
		iter = words.iterator();
		while (iter.hasNext()) {
			st = iter.next();
			System.out.println("第" + i + "个元素" + st);
			i++;
		}
		System.out.println("第二次该集合的元素个数是" + words.size());
		words.removeAll(words);
	}
	//ListIterator迭代器的使用练习
	{
		words.add("刘鑫1");
		words.add("李尧1");
		words.add("刘娟1");
		ListIterator<String> iter=words.listIterator();
		String st=iter.next();
		System.out.println("\n\n\n\n-----ListIterator迭代器的使用1");
		System.out.println(st);
		//了解一下ListIterator的add方法增加元素的位置是在什么位置
		iter.add("刘鑫2");
		System.out.println(iter.previous());
	}
	public static void main(String[] args) {
		Object ct = new LinkedListTest();
	}
}