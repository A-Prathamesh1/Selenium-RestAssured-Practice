package JavaOopsInheritance;

/*
 * this is multilevel inheritance where grandparents is extended by parent,
 * and parent is extended by child. child inherits from parent directly and from grandparents indirectly  
 * */
public class MultiLevelChildInheritance extends Parents {

	public void hasJob() {
		System.out.println("has a great job");
	}

	public void hasBike() {
		System.out.println("has a bike");
	}

	public static void main(String[] args) {
		MultiLevelChildInheritance c = new MultiLevelChildInheritance();
		c.hasFarms();
		c.hasBunglow();
		c.hasCar();
		c.hasBike();
		c.hasJob();
	}
}
