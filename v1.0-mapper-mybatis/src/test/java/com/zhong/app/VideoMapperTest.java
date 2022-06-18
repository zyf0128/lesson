package com.zhong.app;

import com.zhong.app.entity.Chapter;
import com.zhong.app.entity.Video;
import com.zhong.app.mapper.VideoMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author zhuyin
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class VideoMapperTest {

    @Autowired
    private VideoMapper videoMapper;

    @Test
    public void testSelectById(){
        log.info("Video{}",videoMapper.selectById(1));
    }
    @Test
    public void testList(){
        log.info("Videos{}",videoMapper.list());
    }
    @Test
    public void testSelectByDetailById(){
        Video video = videoMapper.selectByDetailById(1);
        log.info("video{}",video);
        List<Chapter> chapters = video.getChapters();
        chapters.forEach(chapter -> {
            log.info("chapter:{}",chapter );
            chapter.getEpisodes().forEach(episode -> {
                log.info("\tepisode: {}",episode);
            });
        });
    }




}
