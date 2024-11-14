package JavaOopsPloymorphism;

public class A {
	public void method1() {
		System.out.println("method 1 from class A");
	}
	
	public void method1(String name) {
		System.out.println("method 1 " + name);
	}
	public static void main(String[] args) {
		A a = new A();
		a.method1();
		a.method1("somename");
	}
}
