/*
MIT License

Copyright (c) 2020 FBSQL Team

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

Home:   https://fbsql.github.io
E-Mail: fbsql.team.team@gmail.com
*/

package org.fbsql.servlet;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.fbsql.servlet.Logger.Severity;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Represent a 'job' to be performed.
 */
public class RunnableJob implements Job {

	/**
	 * Key used to store Runnable in JobDataMap
	 */
	public static final String KEY_RUNNABLE = "KEY_RUNNABLE";

	/**
	 * Called by the Scheduler when a Trigger fires that is associated with the Job.
	 */
	@Override
	public void execute(JobExecutionContext jobContext) throws JobExecutionException {
		JobDetail jobDetail = jobContext.getJobDetail();
		Logger.out(Severity.INFO, MessageFormat.format("Scheduler: Job started at: {0}. Next scheduled time: {1}", toIso(jobContext.getFireTime()), toIso(jobContext.getNextFireTime())));
		Runnable runnable = (Runnable) jobDetail.getJobDataMap().get(KEY_RUNNABLE);
		runnable.run();
	}

	/**
	 * Convert Date to ISO-8601 String
	 *
	 * @param date
	 * @return
	 */
	private static String toIso(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX", Locale.US);
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		return sdf.format(date);
	}
}

/*
Please contact FBSQL Team by E-Mail fbsql.team.team@gmail.com
or visit https://fbsql.github.io if you need additional
information or have any questions.
*/

/* EOF */
