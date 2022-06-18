package com.zhong.app;

import com.zhong.app.entity.PlayRecord;
import com.zhong.app.entity.User;
import com.zhong.app.mapper.PlayRecordMapper;
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
public class PlayRecordMapperTest {


    @Autowired
    private PlayRecordMapper playRecordMapper;
    /**
     * 测试插入一条PlayRecord记录
     */
    @Test
    public void testInsert(){
        PlayRecord playRecord = new PlayRecord();
        playRecord.setUserId(1);
        playRecord.setCurrentNum(1);
        playRecord.setEpisodeId(1);
        playRecord.setVideoId(1);
        log.info(playRecordMapper.insert(playRecord) > 0 ? "插入成功{}"+playRecord : "插入失败");
    }

    @Test
    public void testDeleteById(){
        log.info(playRecordMapper.deleteById(1) > 0 ? "删除成功" : "删除失败");
    }

}
