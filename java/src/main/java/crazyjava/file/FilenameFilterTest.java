package crazyjava.file;

import java.io.File;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-25 17:32
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-25 gaorunding v1.0.0 修改原因
 */
public class FilenameFilterTest {
    public static void main(String[] args) {
        var file = new File(".");
        String[] list = file.list(((dir, name) -> name.endsWith(".java") || new File(name).isDirectory()));
        for (String s : list) {
            System.out.println(s);
        }

    }
}
