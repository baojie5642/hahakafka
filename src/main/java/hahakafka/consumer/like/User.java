package hahakafka.consumer.like;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Document
public class User implements Serializable {
	private static final long serialVersionUID = 2017030718254455555L;
	@Id
	private String userId;
	private String userName;
	private String email;
	private String sex;
	private Date birthday;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "[userId : " + userId + ", userName : " + userName + ", email : " + email + ", sex : " + sex
				+ ", birthday : " + birthday + "]";
	}
}