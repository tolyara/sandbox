package interview;

public class CompositionAgregation {
	
	public static void main(String[] args) {
		
		Role role = new Role();
		role.setTitle("ADMIN");
		role.setDescription("admin");
		
		User1 user1 = new User1();
		user1.setLogin("login");
		user1.setEmail("email");
		user1.setPassword("1234");
		user1.setRole(role);
		
	}

}

class User1 {
	
	private String login;
	private String email;
	private String password;
	private Role role; //composition or agregation
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}

class Role {
	
	private String title;
	private String description;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}













