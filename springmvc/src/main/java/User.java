import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-18 10:32
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-18 gaorunding v1.0.0 修改原因
 */
@Data
@AllArgsConstructor
public class User {
    private String loginName;
    private String password;
}
