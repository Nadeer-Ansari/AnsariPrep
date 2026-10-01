package example.spring.mvc.models;

public class UserValidator {
	public static boolean isValid(User currentUser) {
		boolean success = false;
		String currentUserName = currentUser.getUserName();
		String currentPassword = currentUser.getPassword();
		if(
				currentUserName.equals("admin") 
				&& 
				currentPassword.equals("asAdmin")
		  )
			success = true;
		return success;
	}


}
