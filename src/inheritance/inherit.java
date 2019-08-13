package inheritance;

interface book{
	void printName(String name);
	void printPrize(int prize);
}

class english implements book{

	public void printName(String name){
		System.out.println("这是english书"+"嘿嘿嘿"+name);
	}
	public void printPrize(int prize){
		System.out.println("english book is 10$"+"好便宜"+prize);
	}
}

class math implements book{
public void printName(String name){
		System.out.println("这是math书"+"哈哈哈"+name);
		}

public void printPrize(int prize){
		System.out.println("math book is 20$"+"好贵的数学书"+prize);
		}
		}
public class inherit{
	private String str1="刘鑫要买书";
	private String str2="李尧要买书";
	Integer a=100;
	{
		english e1=new english();
		math m1=new math();
		e1.printName(str1);
		m1.printName(str2);
		e1.printPrize(120);
		m1.printPrize(200);


		if(e1 instanceof english){
			System.out.println("\n\n\n\n  e1是English类");
		}
		if(e1 instanceof Object){
			System.out.println("\n\n\n\n  e1是Object类");
		}
	}
	public static void main(String[] args){
		inherit i1=new inherit();
	}
}
