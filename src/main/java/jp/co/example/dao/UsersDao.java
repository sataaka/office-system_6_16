package jp.co.example.dao;




import java.util.List;



import jp.co.example.entity.Users;

public interface UsersDao {
	//ログインIDとPWを検索するメソッド
	public Users findByLogin(String loginId, String passWord);
	
	public List<Users> findByUserId();
}
