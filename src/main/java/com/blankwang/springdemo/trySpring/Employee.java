//domainクラス
//リポジトリ－クラスやサービスクラスなどの間で渡すクラスのこと、ほかにはモデルクラス、DTOの呼び方もあります。

package com.blankwang.springdemo.trySpring;

import lombok.Data;

//@Dataアノテーションを付けると、getter setterなどを自動で作成してくれる
@Data
public class Employee {

    private int employeeId;
    private String employeeName;
    private int age;
}
