package pe.com.system.brief.nonull;

import lombok.NonNull;
import pe.com.system.brief.User;

public class NonNullLombokExample {

	private String name;

	public NonNullLombokExample(@NonNull User person) {
		this.name = person.getFirstName();
	}
	
	public static void main(String[] args) {
		NonNullLombokExample example = new NonNullLombokExample(null);
	}
}
