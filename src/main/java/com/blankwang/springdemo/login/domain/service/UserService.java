package com.blankwang.springdemo.login.domain.service;

import com.blankwang.springdemo.login.domain.model.User;
import com.blankwang.springdemo.login.domain.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao dao;

    // insert用メソッド
    public boolean insert(User user) {

        // insert実行
        int rowNumber = dao.insertOne(user);

        // 判定用変数
        boolean result = false;

        if (rowNumber > 0) {
            // insert成功
            result = true;
        }

        return result;
    }

    // カウント用メソッド
    public int count() {
        return dao.count();
    }

    // 全件取得用メソッド
    public List<User> selectMany() {
        return dao.selectMany();
    }
}
