package vip.lop1992.timTask;


import com.zjiecode.wxpusher.client.WxPusher;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class SaticScheduleTask {
    private static String USERID ="a";

        @Scheduled(cron = "1 40 8 * * 1-5")
        private void up() {
            WxPusher.send("上班打卡",USERID);
            System.out.println(1);
        }
    @Scheduled(cron = "1 5 18 * * 1-5")
        private void down() {
            WxPusher.send("下班打卡",USERID);
            System.out.println(1);
        }
    @Scheduled(cron = "1 40 16 * * 1-5")
        private void charge() {
            WxPusher.send("充电",USERID);
            System.out.println(1);
        }


}
