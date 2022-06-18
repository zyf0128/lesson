import com.zhong.app.ServiceSpringApp;
import com.zhong.app.entity.User;
import com.zhong.app.service.UserService;
import com.zhong.app.service.VideoBannerService;
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
public class VideoBannerServiceTest {

    @Autowired
    private VideoBannerService videoBannerService;

    /**
     * 测试根据 id 查讯个人信息
     */
    @Test
    public void testSelect(){

        log.info("lists: {}" ,videoBannerService.list());
    }


}
