package com.vivas.servlet;

import com.vivas.quartzjobs.ExportReportWorker;
import com.vivas.services.SMSTCBExport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;

/**
 * Created by duyot on 9/29/2016.
 */
@WebListener
public class AppListener implements ServletContextListener {
    Logger log = LoggerFactory.getLogger(AppListener.class);
    ExportReportWorker exportReportWorker;

    public AppListener() {
        exportReportWorker = new ExportReportWorker();
    }

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        exportReportWorker.start();
        log.info("Starting report worker...");

    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        exportReportWorker.stop();
        log.info("Stopping report worker...");
    }
}
