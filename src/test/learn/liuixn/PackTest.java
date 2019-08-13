package test.learn.liuixn;

import java.util.ArrayList;

public class PackTest {
	public enum e{small,big,high,shortOne};
 	public static void main(String[] args) {
		PackTestTest  pp=new PackTestTest();
		e[] s=e.values();
	    System.out.println(s.toString());
	}
}

class PackTestTest{
	private ArrayList<Integer> list=new ArrayList<Integer>();

	{
		list.add(4);
		list.add(8);
		System.out.println(list.size());
		for(Integer i : list)
			System.out.println(Integer.valueOf(i));
		System.out.println("第0个值为:"+list.get(0).intValue());
		System.out.println("这是对于包装类方法的测试"+Integer.valueOf("10000001001",2));
	}
}