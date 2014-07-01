package com.andieguo.util;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {
	// �����Ǽ��ֵ���task�ķ�����

	// timer.schedule(task, time);
	// timeΪDate���ͣ���ָ��ʱ��ִ��һ�Ρ�

	// timer.schedule(task, firstTime, period);
	// firstTimeΪDate����,periodΪlong
	// ��firstTimeʱ�̿�ʼ��ÿ��period����ִ��һ�Ρ�

	// timer.schedule(task, delay)
	// delay Ϊlong���ͣ����������delay����ִ��һ��

	// timer.schedule(task, delay, period)
	// delayΪlong,periodΪlong�����������delay�����Ժ�ÿ��period
	// ����ִ��һ�Ρ�
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
		// timer.schedule(task, 5000);//�ӳ�5s��ִ������task
		// timer.schedule(task, 1000, 2000);// �������1���,ÿ��2��ִ������task
		// timer.schedule(task, new Date(), 2000);

		end(timer);
	}

	public static void end(final Timer timer) {
		// ����ʱ
		// ��0���뿪ʼ,ÿ��1������ʾʣ��ʱ��,10���Ժ������ʱ
		final long end = System.currentTimeMillis() + 1000 * 60 ;// end�����ʱ������ʱ��,10�����Ժ��ʱ��

		timer.schedule(new TimerTask() {
			public void run() {
				// show ��ʾʣ��ʱ��
				long show = end - System.currentTimeMillis();
				long h = show / 1000 / 60 / 60;// ȡСʱ
				long m = show / 1000 / 60 % 60;// ȡ����һ��Сʱ�ķ���
				long s = show / 1000 % 60;// ȡ����һ���ӵ���
				long ms = show % 1000;// ȡ����һ��ĺ���
				System.out.println(h + ":" + m + ":" + s + ":" + ms);
			}
		}, 0, 1000);
		// ��ʱ���ֹͣ
		timer.schedule(new TimerTask() {
			public void run() {
				timer.cancel();
			}
		}, new Date(end));
	}
}
