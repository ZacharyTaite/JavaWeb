package com.teamsun.crud.login;

import com.teamsun.crud.entity.User;
import com.teamsun.crud.service.DoLogin;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String name = scanner.nextLine();
        System.out.println("请输入密码：");
        String pwd = scanner.nextLine();

        DoLogin dl = new DoLogin();
        User user = dl.findUser(name, pwd);
        if (user != null){
            System.out.println("欢迎你："+user.getUsername());
        }else {
            System.out.println("用户名或密码错误！");
        }
    }
}
