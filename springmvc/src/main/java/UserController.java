import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-18 09:46
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-18 gaorunding v1.0.0 修改原因
 */
@RestController
@RequestMapping("/user")
public class UserController {
//    @InitBinder
//    public void initBinder(WebDataBinder binder){
//
//    }
    @Autowired
    private UserValidator userValidator;

    @GetMapping("/login")
    public String login(@RequestParam String loginnamme, @RequestParam String password, Errors errors){
        System.out.println(loginnamme);
        System.out.println(password);
        userValidator.validate(new User(loginnamme,password),errors);
        if (errors.hasErrors()){
            return errors.toString();
        }
        return "success";
    }


}
