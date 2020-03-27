package com.blankwang.springdemo.login.domain.repository.jdbc;

import com.blankwang.springdemo.login.domain.model.User;
import com.blankwang.springdemo.login.domain.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class UserDaoJdbcImpl implements UserDao {

    // JdbcTemplateはSpringが用意しているため、既にBean定義がされている
    // そのため、@Autowiredするだけで使えるようになる
    @Autowired
    JdbcTemplate jdbc;

    // Userテーブルの件数を取得
    @Override
    public int count() throws DataAccessException {

        /**
         * queryForObject
         * カウントの結果や、カラムを１つだけ取得する
         * 第１引数：SQL文
         * 第２引数：戻り値のオブジェクトのclass
         */
        // 全件取得してカウント
        int count = jdbc.queryForObject("SELECT COUNT(*) FROM m_user",
                Integer.class);
        return count;
    }

    // Userテーブルにデータを1件Insert
    @Override
    public int insertOne(User user) throws DataAccessException {

        /**
         * JdbcTemplateクラスを使ってInsert、更新、削除するには、updateメソッドを使う
         * 第1引数にはSQL文を入れる
         * 第2引数以降には、PerparedStatementを使って、中にはSQL文の？部分に入れる変数を引数に設定
         * updateメソッドの戻り値は、Insert、更新、削除したレコード数
         */
        int rowNumber = jdbc.update("INSERT INTO m_user(user_id, "
                        + "password, "
                        + "user_name, "
                        + "birthday, "
                        + "age, "
                        + "marriage, "
                        + "role)"
                        + "VALUES(?, ?, ?, ?, ?, ?, ?)"
                , user.getUserId()
                , user.getPassword()
                , user.getUserName()
                , user.getBirthday()
                , user.getAge()
                , user.isMarriage()
                , user.getRole());

        return rowNumber;
    }

    @Override
    public User selectOne(String userId) throws DataAccessException {
        return null;
    }

    // Userテーブルの全データを取得
    @Override
    public List<User> selectMany() throws DataAccessException {

        // M_USERテーブルのデータを全件取得
        List<Map<String, Object>> getList = jdbc.queryForList("SELECT * FROM m_user");

        // 結果返却用の変数
        List<User> userList = new ArrayList<>();

        // 取得したデータを結果返却用のListに格納する
        for (Map<String, Object> map: getList){

        }

        return null;
    }

    @Override
    public int updateOne(User user) throws DataAccessException {
        return 0;
    }

    @Override
    public int deleteOne(String userId) throws DataAccessException {
        return 0;
    }

    @Override
    public void userCsvOut() throws DataAccessException {

    }
}
