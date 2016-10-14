package com.vivas.quartzjobs;

import com.vivas.services.SMSTCBExport;
import com.vivas.utils.BundleUtils;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by duyot on 9/29/2016.
 */
public class ExportReportWorker {

    Scheduler exportReportScheduler;
    JobDetail exportReportJD;
    Trigger exportReportTrigger;

    public static final String EXPORT_REPORT_CRONTAB = BundleUtils.getkey("export_report_crontab");

    Logger log = LoggerFactory.getLogger(ExportReportWorker.class);

    public ExportReportWorker() {
        try {
            exportReportScheduler = new StdSchedulerFactory().getScheduler();
            initJobDetailAndTrigger();
            exportReportScheduler.scheduleJob(exportReportJD,exportReportTrigger);
        } catch (SchedulerException e) {
            log.error(e.toString());
            e.printStackTrace();
        }
    }

    public void start(){
        try {
            exportReportScheduler.start();
        } catch (SchedulerException e) {
            log.error(e.toString());
            e.printStackTrace();
        }
    }
    public void stop(){
        try {
            exportReportScheduler.shutdown();
        } catch (SchedulerException e) {
            log.error(e.toString());
            e.printStackTrace();
        }
    }

    public void initJobDetailAndTrigger(){
        exportReportJD = JobBuilder.newJob(SMSTCBExport.class)
                .withIdentity("ExportReport", "Report").build();

        exportReportTrigger = TriggerBuilder
                .newTrigger()
                .withIdentity("ReportTrigger", "Report")
                .withSchedule(
                        CronScheduleBuilder
                                .cronSchedule(EXPORT_REPORT_CRONTAB)).build();
    }
}
