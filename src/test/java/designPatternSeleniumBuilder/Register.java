package designPatternSeleniumBuilder;

public class Register {
	private String firstName;
	private String lastName;
	private String email;
	private String telephone;
	private String password;
	private String confirmPassword;

	public Register(RegisterBuilder registerBuilder) {
		this.firstName = registerBuilder.firstName;
		this.lastName = registerBuilder.lastName;
		this.email = registerBuilder.email;
		this.telephone = registerBuilder.telephone;
		this.password = registerBuilder.password;
		this.confirmPassword = registerBuilder.confirmPassword;
	}
	// Getters only not setters

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getTelephone() {
		return telephone;
	}

	public String getPassword() {
		return password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public static class RegisterBuilder {
		private String firstName;
		private String lastName;
		private String email;
		private String telephone;
		private String password;
		private String confirmPassword;
		
		// since all fields are mandatory no need to write constructor
		// setters

		public RegisterBuilder setFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public RegisterBuilder setLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public RegisterBuilder setEmail(String email) {
			this.email = email;
			return this;
		}

		public RegisterBuilder setTelephone(String telephone) {
			this.telephone = telephone;
			return this;
		}

		public RegisterBuilder setPassword(String password) {
			this.password = password;
			return this;
		}

		public RegisterBuilder setConfirmPassword(String confirmPassword) {
			this.confirmPassword = confirmPassword;
			return this;
		}

		public Register build() {
			return new Register(this);
		}
	}
}
