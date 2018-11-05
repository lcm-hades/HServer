package com.game.mybatis;

import com.game.mybatis.entity.User;
import com.game.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.List;

public class db {

    public static void main(String[] args) {
        String resource = "com/game/mybatis/mybatis-config.xml";
        try {
            Resources.setCharset(Charset.forName("UTF-8"));
            Reader inputStream = org.apache.ibatis.io.Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            UserMapper user = sqlSession.getMapper(UserMapper.class);

            User u = new User();
            u.setAge(20);
            u.setName("大da剑");

            if (user.addUser(u)){
                System.out.println("大bao剑");
            }

//            User uu = new User();
//            uu.setId(2);
//            uu.setAge(80);
//            if (user.updateUser(uu))
//                System.out.println("大bao剑");

//            if (user.deleteUserByID(5))
//                System.out.println("大bao剑");

            List<User> users = user.getAllUser();
            for (User user1 : users){
                System.out.println(user1.toString());
            }
            sqlSession.commit();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
