package com.zhong.app.server;

import com.zhong.app.entity.LogEntity;
import com.zhong.app.util.LogUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.Future;

/**
 * @author zhuyin
 */
@Component
@Slf4j
public class LogServer {


    @SneakyThrows
    @Async
    public Future<Void>  saveLog(){
        List<LogEntity> logEntityList = LogUtil.parseLog("D:\\Workspace\\javabook03-lesson\\log\\my.log");
        logEntityList.forEach(logEntity -> {
            log.info("logEntity: {}",logEntity);
        });
        return new AsyncResult<>(null);
    }

    @Scheduled(cron = "0 37 15 * * ?")
    public void executeSaveLog(){
        Future<Void> voidFuture = this.saveLog();
        while(voidFuture.isDone()){
            log.warn("定时任务已完成....");
            break;
        }
    }
}
