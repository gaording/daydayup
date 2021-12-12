import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-18 09:46
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-18 gaorunding v1.0.0 修改原因
 */
public class DateEditor extends PropertyEditorSupport {
    DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        LocalDate localDate=LocalDate.parse(text,dateTimeFormatter);
        setValue(localDate);
    }
}
