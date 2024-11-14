package JavaOopsPloymorphism;

public class B extends A {

	@Override
	public void method1() {
		System.out.println("this is method 1 from class B");
	}

	public static void main(String[] args) {
		B b = new B();
		b.method1();
		A a = new A();
		a.method1();
		
		A a1 = new B(); // polymorphic assignment
		a1.method1(); // runtime polymorphism 
	}
	// what do you mean by compiler decides run time which method to call
}
