package genericparadigm;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-04 10:09
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-04 gaorunding v1.0.0 修改原因
 */
public class MyUtils {

    public static <T> T copy(Collection<? super T> dest, Collection<T> src) {
        T last = null;
        for (T t : src) {
            last = t;
            dest.add(t);
        }
        return last;
    }

    public static void main(String[] args) {
        var ln = new ArrayList<Number>();
        var li = new ArrayList<Integer>();
        Integer last = copy(ln, li);
        System.out.println(ln);
    }
}
