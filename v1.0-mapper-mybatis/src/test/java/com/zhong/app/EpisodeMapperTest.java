package com.zhong.app;

import com.zhong.app.mapper.EpisodeMapper;
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
@SpringBootTest
@RunWith(SpringRunner.class)
public class EpisodeMapperTest {

    @Autowired
    private EpisodeMapper episodeMapper;


    @Test
    public void testSelectById(){
        log.info("episode{}",episodeMapper.selectFirstEpisodeByVideoId(1));
    }

    @Test
    public void testSelectByChapterId(){
        log.info("episodes{}",episodeMapper.selectByChapterId(1));
    }


}
