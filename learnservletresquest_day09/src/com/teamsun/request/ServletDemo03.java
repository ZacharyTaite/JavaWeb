package com.teamsun.request;

import com.teamsun.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Map;

public class ServletDemo03 extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");//只能解决post方式的乱码
        System.out.println("==================");
        test1(request);
        System.out.println("==================");
        test2(request);
        System.out.println("==================");
        test3(request);
    }

    private void test3(HttpServletRequest request) {
        try {
            User u = new User();
            System.out.println("封装数据前："+u);
            //获取表单数据
            Map<String,String[]> map = request.getParameterMap();

            for (Map.Entry<String, String[]> m : map.entrySet()) {
                String name = m.getKey();
                String[] value = m.getValue();

                //创建一属性描述器
                PropertyDescriptor pd = new PropertyDescriptor(name, User.class);
                //得到setter属性
                Method setter = pd.getWriteMethod();

                if(value.length==1){
                    setter.invoke(u, value[0]);//给一个值的变量赋值
                }else{
                    setter.invoke(u, (Object)value);//相关于给复选框赋值
                }
            }

            System.out.println("封装数据后："+u);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void test2(HttpServletRequest request) {
        //获取所有的表单name的名子
        Enumeration names = request.getParameterNames();
        while(names.hasMoreElements()){
            String name = (String) names.nextElement();//得到每一个name名
            String[] values = request.getParameterValues(name);//根据name名，得到value值
            for (int i = 0;values!=null && i < values.length; i++) {
                System.out.println(name+"\t"+values[i]);
            }
        }
    }

    private void test1(HttpServletRequest request) throws UnsupportedEncodingException {
        //获取表单数据

        //根据表单中name属性的名，获取value属性的值方法
        String userName = request.getParameter("userName");
        String pwd = request.getParameter("pwd");
        String sex = request.getParameter("sex");
        String[] hobbys = request.getParameterValues("hobby");

        String city = request.getParameter("city");

        userName = new String(userName.getBytes("iso-8859-1"),"UTF-8");
        System.out.println(userName);
        System.out.println(pwd);
        System.out.println(sex);

        for (int i = 0;hobbys!=null && i < hobbys.length; i++) {
            System.out.print(hobbys[i]+"\t");
        }
        System.out.println();

        System.out.println(city);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
