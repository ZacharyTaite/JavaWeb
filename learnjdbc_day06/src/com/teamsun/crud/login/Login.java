package com.teamsun.crud.login;

import com.teamsun.crud.entity.User;
import com.teamsun.crud.service.DoLogin;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("�������û�����");
        String name = scanner.nextLine();
        System.out.println("���������룺");
        String pwd = scanner.nextLine();

        DoLogin dl = new DoLogin();
        User user = dl.findUser(name, pwd);
        if (user != null){
            System.out.println("��ӭ�㣺"+user.getUsername());
        }else {
            System.out.println("�û������������");
        }
    }
}
