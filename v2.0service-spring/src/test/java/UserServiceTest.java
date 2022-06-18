import com.zhong.app.ServiceSpringApp;
import com.zhong.app.entity.User;
import com.zhong.app.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author zhuyin
 */
@Slf4j
@SpringBootTest(classes = ServiceSpringApp.class)
@RunWith(SpringRunner.class)
public class UserServiceTest{

    @Autowired
    private UserService userService;
    /**
     * 测试注册
     */
    @Test
    public void testRegister(){
        User user = new User();
        user.setUsername("dsw");
        user.setPassword("dsw");
        user.setGender(0);
        user.setPhone("18574235726");
        user.setRealName("dsww");
        user.setAvatar("dsw.jpg");
        user.setCreateTime(new Date());
        int register = userService.register(user);

        if(register == -1){
            log.info("参数异常...");
        }else if(register == 0){
            log.info("注册失败");
        }else{
            log.info("注册成功");
        }
    }

    @Test
    public void testLogin(){
        log.info("user: {}" ,userService.login(null,"dsw"));
//        log.info("user: {}" ,userService.login("d","dsw"));
//        log.info("user: {}" ,userService.login("dsw","d"));
    }

    /**
     * 测试根据 id 查讯个人信息
     */
    @Test
    public void testSelect(){
        log.info("user: {}" ,userService.selectById(null));
    }


}
