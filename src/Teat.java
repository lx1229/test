import java.util.*;
//包中的公共类名必须与文件的名字相同
//一个源文件不一定要有公共类

/**
 * public class Teat {
 * public static void main(String[] args) throws Exception {
 * //继承测试类
 * SuperClass ha=new SubClass(23,"刘鑫","男",2013);
 * <p>
 * System.out.println("哈哈哈\n"+ha.getName());
 * }
 * }
 */
class Test {
	public Test() {
		int[] a = {1, 4, 2, 6, 3, 0};
		//快速排序
		System.out.println("数组的排序输出");
		Arrays.sort(a);
		//数组字符串格式输出
		System.out.println(Arrays.toString(a));//a数组并没有改变成为字符串
		System.out.println("\n\n数组的快速查找：");
		//数组的二分查找法
		System.out.println(Arrays.binarySearch(a, 2, 4, 1));//返回一个负数

		//数组的复制

		System.out.println("\n数组的复制");
		int[] b = Arrays.copyOf(a, 2 * a.length);
		System.out.println(Arrays.toString(b));
		//设计数组的值的方法
		System.out.println("\nfill的用法");
		Arrays.fill(b, 88);
		System.out.println(Arrays.toString(b));

	}
}

//初始化块的作用的使用测试
class OOPTest {
	private int age;
	private String name;

	public OOPTest(String name) {
		this.name = name;
		this.age = 110;
	}

	public OOPTest(String name, int age) {
		this(name);
		this.age = age;
	}

	public String getName() {
		return this.name;
	}

	public int getAge() {
		return this.age;
	}
}

//感受一下两者的不同
class OOPHaha {
	static {
		System.out.println("\n初始化块的作用可以作为初始化的方法，在对象创建时就可以执行\n");
		OOPTest test = new OOPTest("刘鑫");
		System.out.println("年龄:" + test.getAge());
		System.out.println("姓名：" + test.getName());
	}

}

//构造器的初始化属性
class OOPHaha1 {
	public OOPHaha1() {
		System.out.println("\n构造器方法来促使类在创建时执行一些代码\n");
		OOPTest test = new OOPTest("刘鑫");
		System.out.println("年龄:" + test.getAge());
		System.out.println("姓名：" + test.getName());
	}

}

//类的继承
//继承就是“子类通过继承父类的方式获得父类的protected变量和方法使用权”的一个东西。
class SuperClass {
	private int age;
	private String name;
	private static String gene;

	public SuperClass(int aage, String aname, String agene) {
		this.age = aage;
		this.name = aname;
	}

	public int getAge() {
		return this.age;
	}

	public String getName() {
		return this.name;
	}
}

class SubClass extends SuperClass {
	private int year;
	private String nameSub;

	public SubClass(int aage, String aname, String agene, int ayear) {
		super(aage, aname, agene);
		this.year = ayear;
		//子类只能通过调用父类的方法去查看，不然无法访问，所以继承一定要设置超类的公共接口让子类访问属性
		//因为属性为父类私有，所以想查看子类对象的属性必须通过调用的超类的方法来查看属性
		System.out.println("名字是" + super.getName());
		System.out.println("年龄是" + super.getAge());
	}

}

//编写继承的测试类
class SubTest {
	{
		SubClass liu = new SubClass(23, "刘鑫", "男", 2013);
	}


}

//多态性的体会
class Person {
	private int age;
	private String name;
	private boolean man;

	public Person() {
		this.age = 23;
		this.name = "刘鑫";
		this.man = true;
	}

	public Person(String aname) {
		this();
		this.name = aname;
	}

	public Person(String name, int age) {
		this(name);
		this.age = age;
	}

	public Person(String name, int age, boolean manOrNot) {
		this(name);
		this.age = age;
		this.man = manOrNot;
	}

	public void eat() {
		System.out.println("人都要吃饭");
	}

	public int getAge() {
		return this.age;
	}

	public String getName() {
		return this.name;
	}

	public boolean getMan() {
		return this.man;
	}

	public void setMan(boolean aman) {
		this.man = aman;
	}

}

class Man extends Person {
	private boolean strong = true;

	public Man(String name, int age, boolean astrong) {
		super(name, age);
		super.setMan(true);
		this.strong = astrong;
	}

	public boolean getStrong() {

		return this.strong;
	}
}

class PersonTest {
	public static void H(String[] args) {
		Person liu = new Man("刘鑫", 23, true);
		System.out.println("这个人很强壮：" + ((Man) liu).getStrong());//向下转型 调用子类中特有的方法
		System.out.println("姓名：" + liu.getName());
	}
}

//重载解析类型转换的测试
//重载解析的过程中，
class overLoadTest {
	public void returnAge(double a) {
		System.out.println("这是double类型的返回值" + a);
	}

	//@overload
	public void returnAge(float b) {
		System.out.println("这是float类型的返回值" + b);
	}
}

//异常测试测代码
class ExceptionTest {
	private int number;
	Scanner in = new Scanner(System.in);
	//方法中的执行代码都得放在代码块中执行

	public void testException() {
		int flag = 0;
		System.out.print("测试输入环节:\n-");
		try {
			number = in.nextInt();
			System.out.println("\n\n可以执行\n\n");
		} catch (InputMismatchException e1) {
			flag = 1;
			System.out.println("发现了输入的异常，请重新输入");

		} finally {
			//finally 这个是限定在异常捕获程序时结果一定会执行的
			System.out.println("\nfinally执行\n\n李尧真是个可爱的孩子\n");
			new overLoadTest().returnAge(1000000000);
			//可在这里反复的调用异常捕获的程序使异常捕获一直执行
			//或者添加调用的条件使这个异常捕获的对象反复执行
			//设置一个标记flag判断异常是否捕获
			//通过标记法来标记一段代码的执行真的很有用
			if (flag == 1) {
				new ExceptionTest().testException();
				flag = 0;
			}
		}

	}

	//public static void main(String[] args) {
	//		new ExceptionTest().testException();
	//	}
}

//测试异常之后代码的执行

/**
 * 要始终牢记类中只有成员变量和方法还有代码块部分，
 * 不能将执行语句放在类中，要用代码块来包含进去
 * >代码只要出现异常的话，后面的代码都会正常执行
 * >>>java的异常处理很厉害，要好好学
 */
//异常调用Exception子类方法的实现
class TestException {
	private int i = 10;

	{
		try {
			System.out.println(i / 0);
		} catch (ArithmeticException e1) {
			System.out.println("可爱的尧尧提醒你:\n你这个出现运行时异常了");
			//下面的两个方法就是java代码报告错误的方法
			//System.out.println(e1.getMessage());
			//e1.printStackTrace();
			System.out.println(e1.getClass().getName());
			System.out.println(e1.getMessage().toString());
			/**
			 * 注意在捕获异常时，子类异常必须放在父类异常的前面，不然捕捉不到异常,代码会报错
			 */
		} catch (Exception e3) {
			System.out.println("可爱的尧尧提醒你,这是捕获的Exception");

		}
	}

	//编写运行的主main方法

}

//手动抛出异常测试
class UnknownException extends Exception {

	private int i;
	private Scanner in = new Scanner(System.in);

	public void run() {
		try {
			System.out.println("请输入测试的1");
			i = in.nextInt();
			if (i == 1) {
				//匿名对象的创建，根据定义好的构造函数来构建对象的实体
				throw new UnknownException("这是一个异常的测试代码");
			}

		} catch (Exception e1) {
			System.out.println(e1.getMessage());
			System.out.println("这是一个"+e1.getClass().getName()+"的对象");
			System.out.println("自定义异常捕获成功");
		}
	}

	//自定义的异常构造器是调用父类的构造器
	public UnknownException() {
		super("这是一个自己定义的异常定义好的异常");
	}

	public UnknownException(String s) {
		super(s);
	}

	//定义主main方法来只执行测试程序
	//public static void main(String[] args) {
	//		UnknownException u1 = new UnknownException();
	//		u1.run();
	//	}

}
//测试instanceOf的用法
class InstanceOfTest{
	int i;
	Integer iNum=new Integer(13);
	{

		System.out.println(iNum instanceof Integer);
		System.out.println("iNum的值为："+Integer.valueOf(iNum));
		System.out.println("iNum的函数测试为："+Integer.valueOf("2345"));
	}
	//Integer函数的测试
	//public static void main(String[] args){
	//		InstanceOfTest t=new InstanceOfTest();
	//	}
}

// lambda表达式的测试
class LambdaTest {
	private String name="刘鑫";
	private String nameLi="李尧";
	//关于main方法的编写测试
	//	public static void main(String[] args) {
	//		LambdaTest lt=new LambdaTest();
	//	}
}
//关于Date类的学习测试
//System系统类中方法的使用
class DateTest{
	static
	{
		Date time=new Date();
		System.out.println("时间是"+time.toString());
		System.out.println("java的版本是---"+System.getProperty("java.version"));
		System.out.println("java的运行时该系统的版本为"+System.getProperty("os.version"));
	}

	private String[] st;

	public static void main(String[] args){
		DateTest dT=new DateTest();
		//模版学习测试
		if (dT != null) {
			System.out.println("李尧真是个大笨猪");
			System.out.println("DateTest.main");
			System.out.println("dT = " + dT);
			System.out.println("刘鑫");
			System.out.println(dT);

			String[] st={"刘鑫","李尧","刘娟"};

			//所谓模板就是IDEA中关键字快捷输入代码
			for (int i = 0; i <st.length ; i++) {
				System.out.println(st[i]);
			}
			for (String s : st) {
				System.out.println(st);
			}
			List<String> s=Arrays.asList(st);
			for (String s1 : s) {
				System.out.println("这是"+s1);
			}
		}
	}
}
