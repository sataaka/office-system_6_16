package jp.co.example.dao;




import java.util.List;



import jp.co.example.entity.Users;

public interface UsersDao {
	//ログインIDとPWを検索するメソッド
	public Users findByLogin(String loginId, String passWord);
	//Usersテーブルの全ての情報を確認するメソッド
	public List<Users> findByUserId();
}
