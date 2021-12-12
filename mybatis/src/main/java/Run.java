import com.example.mybatis.entity.Student;
import com.example.mybatis.mapper.StudentMapper;
import com.example.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-19 14:47
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-19 gaorunding v1.0.0 修改原因
 */
public class Run {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        //1.
//        System.out.println( userMapper.selectUserById(2));
//        System.out.println("---------------------");
//        userMapper.deleteUserById(1);
//        session.commit();
//        System.out.println("---------------------");
//        System.out.println( userMapper.selectUserById(2));
//        System.out.println("---------------------");
//        session.close();
//        session=sqlSessionFactory.openSession();
//        userMapper= session.getMapper(UserMapper.class);
//        System.out.println(userMapper.selectUserById(2));
//        session.close();
        //2.
//        User user=new User();
//        user.setName("grd");
//        user.setAge(27);
//        user.setSex("男");
//        userMapper.saveUser(user);
//        System.out.println(user.getId());
//        session.commit();
        //3.
//        PersonMapper personMapper=session.getMapper(PersonMapper.class);
//        Person person = personMapper.selectPersonById(1);
//        System.out.println(person);
//        System.out.println(person.getCard());
//        session.close();
        //4.
//        ClazzMapper clazzMapper=session.getMapper(ClazzMapper.class);
//        Clazz clazz=clazzMapper.selectClazzById(1);
//        System.out.println(clazz.getId());
//        System.out.println(clazz.getStudents());
//        session.close();
        //5.
//        ShopOrderMapper shopOrderMapper=session.getMapper(ShopOrderMapper.class);
//        ShopOrder shopOrder = shopOrderMapper.selectById(1);
//        System.out.println(shopOrder.getId()+":"+shopOrder.getCode()+":"+shopOrder.getTotal());
//        System.out.println(shopOrder.getUser());
//        System.out.println(shopOrder.getArticles());
//        session.close();
        //6.
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        Student student = new Student();
        student.setId(1);
        List<Student> students = studentMapper.selectStudents(student);
        System.out.println(students);
        session.close();

    }
}
