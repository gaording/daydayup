package crazyjava.annotations.apt;

import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Set;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-23 08:28
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-23 gaorunding v1.0.0 修改原因
 */
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes({"Persistetnt", "Id", "Property"})
public class HibernateAnnotationProcessor {
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnvironment) {
        PrintStream ps = null;
        try {
            for (Element t : roundEnvironment.getElementsAnnotatedWith(Persistent.class)) {
                //获取正在处理的类名
                Name clazzName = t.getSimpleName();
                Persistent per = t.getAnnotation(Persistent.class);
                //创建文件输出流
                ps = new PrintStream(new FileOutputStream(clazzName + ".hbm.xml"));
                //执行输出
                ps.println("<?xml version=\"1.0\"?>");
                ps.println("<!DOCTYPE hibernate-mapping PUBLIC");
                ps.println("    \"-//Hibernate/Hibernate  Mapping DTO 3.0//EN\"");
                ps.println("<hibernate-mapping>");
                ps.print("  <class name=\"" + t);
                //输出per的table()的值
                ps.println("\"table=\"" + per.table() + "\">");
                for (Element enclosedElement : t.getEnclosedElements()) {
                    //只处理成员变量上的注解
                    if (enclosedElement.getKind() == ElementKind.FIELD) {
                        //获取成员变量定义前的@Id注解
                        Id id = enclosedElement.getAnnotation(Id.class);
                        //当@Id注解存在时输出<id.../>元素
                        if (id != null) {
                            ps.println("            <id name=\""
                                    + enclosedElement.getSimpleName()
                                    + "\" column=\"" + id.column()
                                    + "\" type=\"" + id.type()
                                    + "\">"
                            );
                        }
                        //获取成员变量定义前的@Prooperty注解
                        Property p = enclosedElement.getAnnotation(Property.class);
                        //当@Property注解存在时输出<Property ..../>元素
                        if (p != null) {
                            ps.println("    <property name=\""
                                    + enclosedElement.getSimpleName()
                                    + "\" column=\"" + p.column()
                                    + "\" type=\"" + p.type()
                                    + "\"/>"
                            );
                        }
                        ps.println("    </class>");
                        ps.println("</hibernatte-mapping>");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
        return true;
    }
}
