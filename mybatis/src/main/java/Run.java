import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
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
        InputStream inputStream= Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session=sqlSessionFactory.openSession();
        User user=new User();
        session.insert("",user);
        session.commit();
        session.close();
    }
}
