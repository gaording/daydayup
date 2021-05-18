import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-18 10:53
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-18 gaorunding v1.0.0 修改原因
 */
@Repository("userValidator")
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors,"loginname",null,"登录名不能为空");
        ValidationUtils.rejectIfEmpty(errors,"password",null,"密码不能为空");
        User user= (User) o;
        if (user.getLoginName().length()>10){
            errors.rejectValue("loginname",null,"用户名不能超过10个字符");
        }
        if (user.getPassword().length()<6){
            errors.rejectValue("password",null,"密码不能小于6位");
        }
    }
}
