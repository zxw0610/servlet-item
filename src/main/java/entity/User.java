package entity;


import java.io.Serializable;
import java.util.Date;

import util.DateUtil;

/**
 * User实体类
 * 现在没有框架，所以你没有感觉
 * JavaBean：
 *    1）建议现实序列化接口
 *    2）实体类应该有缺省的构造器（显示的）
 *    3）对属性要有get和set方法
 *    4)重写toString方法
 *    5)重写equals方法和hasshCode方法
 *      TreeSet
 * @author Administrator
 *
 */
public class User implements Serializable {
	public static final long serialVersionUID = 1L;
	
	private int id;   //自然主键
	private String name;
	private String pwd;
	private int age;
	private Date birth;
	
	public User(){}
	
	public User(String name, String pwd, int age, Date birth) {
		super();
		this.name = name;
		this.pwd = pwd;
		this.age = age;
		this.birth = birth;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirth() {
		return birth;
	}
	//可以改造
	public void setBirth(String birth) {
		this.birth = DateUtil.toDate("yyyy-MM-dd",birth);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name="
	           + name + ", pwd=" + pwd + ", age=" 
			   + age + ", birth=" + DateUtil.dateToString("yyyy-MM-dd", birth) + "]";
	}
	/**
	 * 为什么重写equals方法的时候要重写hashCode
	 *   equals方法和地址没有任何关系
	 *   重写equals方法的时候不一定重写hashCode方法
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((birth == null) ? 0 : birth.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)     //自反性
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())  //丢不是同一类型
			return false;
		User other = (User) obj;  //同类
		if (age != other.age)
			return false;
		if (birth == null) {
			if (other.birth != null)
				return false;
		} else if (!birth.equals(other.birth))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pwd == null) {
			if (other.pwd != null)
				return false;
		} else if (!pwd.equals(other.pwd))
			return false;
		return true;
	}	
	
	
}
