package CGB1808;

public class product {
	private String studentId;
	private String banji;
	private String name;
	private String gender;
	private String job;
	private String phone;
	private String qq;
	private String email;
	private String username;
	private String password;
	public String getStudentId() {
		return studentId;
	}
	
	public product(String studentId, String banji, String name, String gender, String job, String phone, String qq,String email,
			String username, String password) {
		super();
		this.studentId = studentId;
		this.banji = banji;
		this.name = name;
		this.gender = gender;
		this.job = job;
		this.phone = phone;
		this.qq = qq;
		this.email = email;
		this.username = username;
		this.password = password;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getBanji() {
		return banji;
	}
	public void setBanji(String banji) {
		this.banji = banji;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "product [studentId=" + studentId + ", banji=" + banji + ", name=" + name + ", gender=" + gender
				+ ", job=" + job + ", phone=" + phone + ", qq=" + qq + ", email=" + email + ", username=" + username + ", password="
				+ password + "]";
	}
}
