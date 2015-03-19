package org.quicky.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quicky.common.CronExpressionFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(cron = CronExpressionFactory.EVERY_TEN_MINUTES)
    public void reportCurrentTime() {
        System.out.println("The time is now " + dateFormat.format(new Date()));
    }
}
