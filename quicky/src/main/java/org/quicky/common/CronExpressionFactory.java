package org.quicky.common;

public class CronExpressionFactory {
	
	//http://www.cronmaker.com/
	
	/*
	*   *    *    *    *    *   (year optional)
	┬   ┬    ┬    ┬    ┬    ┬
	│   │    │    │    │    │
	│   │    │    │    │    │
	│   │    │    │    │    └───── day of week (0 - 7) (0 or 7 is Sun, or use names)
	│   │    │    │    └────────── month (1 - 12)
	│   │    │    └─────────────── day of month (1 - 31)
	│   │    └──────────────────── hour (0 - 23)
	│   └───────────────────────── min (0 - 59)
	└─────────────────────────      seconds
	*/
	public static final String TOP_OF_EVERY_HOUR_OF_EVERY_DAY = "0 0 * * * *";
	public static final String EVERY_TEN_SECONDS = "*/10 * * * * *";
	public static final String EVERY_MINUTE = "0 0/1 * 1/1 * ?";
	public static final String EVERY_FIVE_MINUTES = "0 0/5 * 1/1 * ?";
	public static final String EVERY_TEN_MINUTES = "0 0/10 * 1/1 * ?";
	
}
