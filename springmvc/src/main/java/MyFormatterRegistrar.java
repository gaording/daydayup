import org.springframework.format.FormatterRegistrar;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-18 10:22
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-18 gaorunding v1.0.0 修改原因
 */
public class MyFormatterRegistrar implements FormatterRegistrar {

    private DateFormatter dateFormatter;

    public void setDateTimeFormatter(DateFormatter dateFormatter){
        this.dateFormatter=dateFormatter;
    }

    @Override
    public void registerFormatters(FormatterRegistry formatterRegistry) {
        formatterRegistry.addFormatter(dateFormatter);
    }
}
