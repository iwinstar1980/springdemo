-- 従業員テーブルのデータ

INSERT INTO employee (employee_id, employee_name, age)
VALUES (1, '山田太郎', 30);

-- ユーザーマスタのデータ（管理員権限）

INSERT INTO m_user (user_id, password, user_name, birthday, age, marriage, role)
VALUES ('wang@gmail.com', 'password', '王　鴻春', '1990-01-01', 38, false, 'ROLE_ADMIN');