import com.zhong.app.ServiceSpringApp;
import com.zhong.app.service.VideoBannerService;
import com.zhong.app.service.VideoOrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhuyin
 */

@Slf4j
@SpringBootTest(classes = ServiceSpringApp.class)
@RunWith(SpringRunner.class)
public class VideoOrderServiceTest {

    @Autowired
    private VideoOrderService videoOrderService;

    /**
     * 测试根据 id 查讯个人信息
     */
    @Test
    public void testSelect(){

        int res = videoOrderService.insert(1, 1);
        if(res == -2){
            log.info("若视频不存在");
        }else if(res == -1){
            log.info("该用户已经购买过该视频,不允许重复购买。");
        }else if(res == 1){
            log.info("下单成功..");
        }
    }

    @Test
    public void testSelectByUserId(){
        log.info("{}",videoOrderService.selectByUserId(3));
    }

}
