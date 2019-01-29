package cn.tedu;

public class UserActionLogin {

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String execute() {
		System.out.println(user.getName());
		return "success";
	}
}
