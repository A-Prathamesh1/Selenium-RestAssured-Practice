package interviewTask;

class Animal {
	public void eat() {
		System.out.println("eats");
	}
}

class Dog extends Animal {
	@Override
	public void eat() {
		System.out.println("dog eats");
	}

	public static void main(String[] args) {
		Animal a = new Dog();
		a.eat();
		Dog d = new Dog();
		d.eat();
	}
}
