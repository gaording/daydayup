springmvc默认不支持文件处理，需要在xml中配置multipartresolver。还有一个springmvc拦截器intercepter的配置。然后就是mybatis的配置。

mybatis配置文件相关：

```plain
InputStream inputStream= Resources.getResourceAsStream("mybatis-config.xml");
SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
SqlSession session=sqlSessionFactory.openSession();
com.example.mybatis.entity.User user=new com.example.mybatis.entity.User();
session.insert("",user);
session.commit();
session.close();
```
这段代码其实就是一段读取xml文件然后配置加载的过程，把xml文件流转化成xmlConfigBuilder对象，再将builder对象转化成configuration对象，根据configuration对象创建一个DefaultSessionFactory对象，供客户端使用。
properties配置项可以读取另外的properties文件，然后mybatis-config.xml的相关property（数据库相关的driver、url、username、password）就可以在配置文件中动态替换。

settings配置项可以配置缓存、分页、驼峰转换等的开关，一般用默认就行。

typeAliases是为java类型设置的一个短的名字，之前用过。

typeHandlers类处理器，preparedStatement设置参数，或是从结果集中取出一个值时，都会用类型处理器将获取的值以合适的方式转换成java类型。

objectFactory对象工厂，创建结果对象的新实例时使用，可以自己实现，覆盖默认的构造方法。

environments配置环境，多个数据源的配置。用了spring的，就不必配置环境中的事务管理器。spring模块会用自带的管理器来覆盖前面的配置。

mapper映射器，可以用resource、url、class、或者<package/>标签配置mapper文件路径。

select元素的配置，flushcache、usecache和缓存相关，statementType和jdbc中的statement、preparedStatement或callableStatement相关。insert、update、delete配置项类似，特有的属性描述有：useGeneratedKeys、keyProperty、keyColumn。能自增主键的mysql，mybatis只需设置useGeneratedKeys={true}即可。不能自增主键的oracle，mysql可指定<selectKey/>语句。还有<sql/>元素，之前也用过，但是<sql/>元素可以指定传参的，<sql id="userColumn"> ${alias}.id,${alias}.usernamme,${alias}.password</sql>，用的时候就是<include refid="userColumns"><property name="alias" value="t1"/></include>。

参数parameters的配置，resultMaps的配置，resultMap中之前有疑问的一个东西是关联映射，没有用出来。代码如下：

```plain
<resultMap id="studentResultMap" type="org.fkit.domain.Student">
    <id property="id" colummn="id"/>
    <result property="name" column="name"/>
    <result property="sex" column="sex"/>
    <result peoperty="age" column="age"/>
    <!--关联映射-->
    <association property="clazz" column="clazz_id" javaType="org.fkit.domain.Clazz" select="selectClazzWithId"/>
</resultMap>
<!--根据班级id查询班级>
<select id="selectClazzWithId" resultType="org.fkit.domain.Clazz">
   select * from TB_CLAZZ where id = #{id}
</select>
<!--查询所有学生信息-->
<select id="selectStudent" resultMap="studentResultMap">
    select * from TB_STUDENT
</select>
```
如果是一个集合属性（一个班级中的学生列表），那么代码如下:
```
<resultMap id="clazzResultMap" type=""org.fkit.domain.Clazz>
    <id property="id" colummn="id"/>
    <result property="code" column="code"/>
    <!--一个班级中的学生列表-->
    <collection property="students" javaType="ArrayList" column="id" ofType="org.fkit.domain.Student" select="selectStudentWithId"/>
</resultMap>
<!--根据班级id查询学生-->
<select id="selectStudentWithId" resultType="org.fkit.domain.Student">
    select * from tb_student where clazz_id = #{id}
</select>
<!--查询所有班级信息-->
<select id="selectClazz" resultMap="clazzResultMap">
  select * from TB_CLAZZ
</select> 
```
这里还涉及到查询一对多时的懒加载问题，设置<collection>的fetchType为“lazy”，可以保证在访问集合属性元素时才去查询。延迟懒加载需要settings中配置lazyLoadingEnabled和aggressiveLazyLoading为true。
动态sql：if、choose（when、otherwise）、where、set、foreach、bind。bind之前没用过，可以创建一个变量，demo中使用的是like查询，这个我一直用的是concat动态拼接的方式。

