package cn.forgeeks.awesome.springboot.schedul;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Scheduler2Task {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyHH:mm:ss");
    Logger log = LoggerFactory.getLogger(getClass());

    @Scheduled(fixedRate = 5000 * 12 * 2)
    public void reportCurrentTime() {
        // log.info("This is scheduler task runing  [{}]." ,dateFormat.format(new Date()));
    }

}