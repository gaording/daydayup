package javademo;

import java.io.IOException;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-31 17:26
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-31 gaorunding v1.0.0 修改原因
 */
public class Test {
    public static void main(String[] args) throws IOException {
//        Locale[] locales=Locale.getAvailableLocales();
//        for (Locale locale : locales) {
//            System.out.println(locale.getDisplayCountry()+"="+locale.getCountry()+" "
//                    +locale.getDisplayLanguage()+"="+locale.getLanguage());
//        }

        System.out.println(System.getProperties().getProperty("user.language"));

    }
}
