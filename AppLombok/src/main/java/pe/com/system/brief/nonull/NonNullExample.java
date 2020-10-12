package pe.com.system.brief.nonull;

import pe.com.system.brief.User;

public class NonNullExample {
	private String name;

	public NonNullExample(User user) {
		if (user == null) {
			throw new NullPointerException("person is marked @NonNull but is null");
		}
		this.name = user.getFirstName();
	}
	
	public static void main(String[] args) {
		NonNullExample example = new NonNullExample(null);
	}
}
