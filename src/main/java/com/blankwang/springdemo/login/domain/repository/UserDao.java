package com.blankwang.springdemo.login.domain.repository;

import com.blankwang.springdemo.login.domain.model.User;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface UserDao {

    // DB操作で例外が発生した場合、Springが提供しているDataAccessExceptionを投げる
    // Userテーブルの件数取得
    public int count() throws DataAccessException;

    // Userテーブルにデータを1件Insert
    public int insertOne(User user) throws DataAccessException;

    // Userテーブルのデータを1件取得
    public User selectOne(String userId) throws DataAccessException;

    // Userテーブルのデータを全件取得
    public List<User> selectMany() throws DataAccessException;

    // Userテーブルのデータを1件更新
    public int updateOne(User user) throws DataAccessException;

    // Userテーブルのデータを1件削除
    public int deleteOne(String userId) throws DataAccessException;

    // SQL取得結果をサーバーにCSVで保存
    public void userCsvOut() throws DataAccessException;
}
