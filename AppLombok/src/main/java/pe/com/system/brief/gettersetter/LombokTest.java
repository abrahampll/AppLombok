package pe.com.system.brief.gettersetter;

public class LombokTest {

	public static void main(String[] args) {
		
		UserLombokModel lombokModel = new UserLombokModel(100, "Jose", "Fernande", 28,"Male");
		System.out.println(lombokModel.toString());
		
		
		UserLombokModel lombokModel1 = new  UserLombokModel();
		
		lombokModel1.setId(100);
		lombokModel1.setFirstName("Jose");
		lombokModel1.setLastName("Fernandez");
		lombokModel1.setAge(28);
		lombokModel1.setGender("Male");
		
		System.out.println(lombokModel1.getId());
		System.out.println(lombokModel1.getFirstName());
		System.out.println(lombokModel1.getLastName());
		System.out.println(lombokModel1.getGender());
		System.out.println(lombokModel1.getAge());
	}
		
	
}


