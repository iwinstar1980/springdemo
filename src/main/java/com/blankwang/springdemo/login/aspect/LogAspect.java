package com.blankwang.springdemo.login.aspect;

import ch.qos.logback.core.encoder.EchoEncoder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


// AOPクラスには、@Aspectアノテーションを付ける
// 同時にDIコンテナへBean定義をするため、@Componentアノテーションを付ける
@Aspect
@Component
public class LogAspect {

    // Pointcut（実行場所）指定方法１：execution
    // execution(<戻り値> <パッケージ名>.<クラス名>.<メソッド名>(<引数>))

    /**
     * 正規表現の使い方
     * （* アスタリスク）：任意の文字列を表す。パッケージでは１階層のパッケージ名、めっそーど引数では１つの引数になる。
     * （.. ドット２文字）：任意（０以上）のパッケージまたは引数になる。
     * （+ プラス）：クラス名の後ろに指定すると、指定クラスのサブクラス／実装クラスが含まれる。
     */

//    // @Before @Afterの使い方
//    @Before("execution(* *..*.*Controller.*(..))")
//    public void startLog(JoinPoint jp) {
//        System.out.println("メソッド開始：" + jp.getSignature());
//    }
//
//    @After("execution(* *..*.*Controller.*(..))")
//    public void endLog(JoinPoint jp) {
//        System.out.println("メソッド終了：" + jp.getSignature());
//    }

    // @Aroundの使い方
    @Around("execution(* *..*.*Controller.*(..))")
    public Object startLog(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("メソッド開始：" + jp.getSignature());

        try {
            Object result = jp.proceed();
            System.out.println("メソッド終了：" + jp.getSignature());
            return result;
        } catch (Exception e) {
            System.out.println("メソッド異常終了：" + jp.getSignature());
            e.printStackTrace();
            throw e;
        }
    }

    // UserDaoクラスのログ出力
    @Around("execution(* *..*.*UserDao*.*(..))")
    public Object daoLog(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("メソッド開始：" + jp.getSignature());

        try {
            Object result = jp.proceed();
            System.out.println("メソッド終了：" + jp.getSignature());
            return result;
        } catch (Exception e) {
            System.out.println("メソッド異常終了：" + jp.getSignature());
            e.printStackTrace();
            throw e;
        }
    }

    // Pointcut（実行場所）のその他指定方法：
    // １）Bean名で指定：DIに登録されているBean名でAOPの対象を指定できる　
//    @Around("bean(*Controller)")
//    public Object startLog(ProceedingJoinPoint jp) throws Throwable {
//        System.out.println("メソッド開始：" + jp.getSignature());
//
//        try {
//            Object result = jp.proceed();
//            System.out.println("メソッド終了：" + jp.getSignature());
//            return result;
//        } catch (Exception e) {
//            System.out.println("メソッド異常終了：" + jp.getSignature());
//            e.printStackTrace();
//            throw e;
//        }
//    }

//    ２）アノテーション付くメソッドを指定　
//    @Around("@annotation(org.springframework.web.bind.annotation.GetMapping)")
//    public Object startLog(ProceedingJoinPoint jp) throws Throwable {
//        System.out.println("メソッド開始：" + jp.getSignature());
//
//        try {
//            Object result = jp.proceed();
//            System.out.println("メソッド終了：" + jp.getSignature());
//            return result;
//        } catch (Exception e) {
//            System.out.println("メソッド異常終了：" + jp.getSignature());
//            e.printStackTrace();
//            throw e;
//        }
//    }

//    // ３）アノテーションが付くクラスの全メソッドを指定
//    @Around("@within(org.springframework.stereotype.Controller)")
//    public Object startLog(ProceedingJoinPoint jp) throws Throwable {
//        System.out.println("メソッド開始：" + jp.getSignature());
//
//        try {
//            Object result = jp.proceed();
//            System.out.println("メソッド終了：" + jp.getSignature());
//            return result;
//        } catch (Exception e) {
//            System.out.println("メソッド異常終了：" + jp.getSignature());
//            e.printStackTrace();
//            throw e;
//        }
//    }

}
