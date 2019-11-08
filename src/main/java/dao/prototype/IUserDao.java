package dao.prototype;

import java.util.List;
import entity.User;

/**
 * UserDao接口类
 *    用于持久化用户数据
 * @author Administrator
 * @version JDK8
 */
public interface IUserDao {
	void save(User u);
	void delete(int id);
	void modify(User u);
	User find(int id);
	List<User>findAll();
	
}
