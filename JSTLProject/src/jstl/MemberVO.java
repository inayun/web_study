package jstl;

/**
 * @author 310
 *
 */
public class MemberVO {
	
	private String name;
	private String email;
	private int age;
	
	public MemberVO() {
	}
	
	//생성자 함수 : 변수의 초기화
	public MemberVO(String name, String email, int age) {
		this.name = name;
		this.email = email;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
	
}
