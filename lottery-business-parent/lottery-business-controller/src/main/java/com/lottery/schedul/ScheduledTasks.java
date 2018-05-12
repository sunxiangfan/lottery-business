package com.lottery.schedul;

import com.lottery.common.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ScheduledTasks {

    private static String periods = "000";
    private static String periodsDate;
    private static boolean b = true;

    @Scheduled(cron = "*/5 * * * * ?")
    public void ChongqQingOftenLottery() {
        String numbersLottery = String.valueOf((int)((Math.random() * 9 + 1) * 10000));
        String now = DateUtils.getDate();
        if (b) {
            periodsDate = now;
            b = false;
        }
        if (!periodsDate.equals(now)) {
            periodsDate = now;
            periods = "000";
        }
        int s = Integer.parseInt(periods);
        s = ++s;
        s = s == 1000 ? 1 : s;
        String reslut = s >= 10 ? (s >= 100 ? s + "" : "0" + s) : "00" + s;
        periods = reslut;
        log.info("============第" + periodsDate + reslut + "期开奖号码：" + numbersLottery + "============");
    }
}