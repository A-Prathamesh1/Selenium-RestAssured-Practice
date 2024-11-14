package JavaOops;

public class Encapsulation {
	// class is an example of encapsulation 
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		Encapsulation en = new Encapsulation();
		en.setName("abc");
		System.out.println(en.getClass());
	}

}
