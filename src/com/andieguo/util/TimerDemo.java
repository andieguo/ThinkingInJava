package com.andieguo.util;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {
	// 以下是几种调度task的方法：

	// timer.schedule(task, time);
	// time为Date类型：在指定时间执行一次。

	// timer.schedule(task, firstTime, period);
	// firstTime为Date类型,period为long
	// 从firstTime时刻开始，每隔period毫秒执行一次。

	// timer.schedule(task, delay)
	// delay 为long类型：从现在起过delay毫秒执行一次

	// timer.schedule(task, delay, period)
	// delay为long,period为long：从现在起过delay毫秒以后，每隔period
	// 毫秒执行一次。
	public static void main(String[] args) {
		final Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			int i = 0;

			@Override
			public void run() {
				i++;
				System.out.println(i + "start");
			}
		};
		// timer.schedule(task, 5000);//延迟5s后执行任务task
		// timer.schedule(task, 1000, 2000);// 便可以在1秒后,每隔2秒执行任务task
		// timer.schedule(task, new Date(), 2000);

		end(timer);
	}

	public static void end(final Timer timer) {
		// 倒计时
		// 从0毫秒开始,每隔1秒钟显示剩余时间,10秒以后结束计时
		final long end = System.currentTimeMillis() + 1000 * 60 ;// end代表计时结束的时刻,10分钟以后的时刻

		timer.schedule(new TimerTask() {
			public void run() {
				// show 表示剩余时间
				long show = end - System.currentTimeMillis();
				long h = show / 1000 / 60 / 60;// 取小时
				long m = show / 1000 / 60 % 60;// 取不够一个小时的分钟
				long s = show / 1000 % 60;// 取不够一分钟的秒
				long ms = show % 1000;// 取不够一秒的毫秒
				System.out.println(h + ":" + m + ":" + s + ":" + ms);
			}
		}, 0, 1000);
		// 到时间后停止
		timer.schedule(new TimerTask() {
			public void run() {
				timer.cancel();
			}
		}, new Date(end));
	}
}
