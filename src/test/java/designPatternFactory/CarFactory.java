package designPatternFactory;

public class CarFactory {
	public Car getCar(String carType) {
		if (carType == null) {
			return null;
		}

		if (carType == "SUV") {
			return new SUV();
		} else if (carType == "SEDAN") {
			return new SEDAN();
		} else if (carType == "MINI") {
			return new MINI();
		}
		return null;
	}

}
