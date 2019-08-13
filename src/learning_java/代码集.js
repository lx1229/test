体现继承特性的代码

class Creature {
    public Creature() {
        System.out.println("Creature无参数的构造器");
    }}
class Animal extends Creature {
    public Animal(){
        System.out.println("Animal的默认构造函数");
    }
    public Animal(String name) {
    System.out.println("Animal带一个参数的构造器，该动物的name为" + name);
}
public Animal(String name, int age) {
    this(name);
    System.out.println("Animal带两个参数的构造器，其age为" + age);
}}
public class Teat extends Animal {
    public Teat() {
        super("灰太狼", 3);
        System.out.println("Wolf无参数的构造器");
    }
    public static void main(String[] args) {
    new Teat();
}}