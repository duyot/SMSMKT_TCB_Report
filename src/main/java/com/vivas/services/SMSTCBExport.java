package com.vivas.services;

import com.vivas.dao.SMSTcbRequestDAO;
import com.vivas.dto.SMSTcbRequest;
import com.vivas.utils.BundleUtils;
import com.vivas.utils.DateTimeUtils;
import net.sf.jxls.transformer.Configuration;
import net.sf.jxls.transformer.XLSTransformer;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by duyot on 9/28/2016.
 */
public class SMSTCBExport implements Job{
    SMSTcbRequestDAO smsTcbRequestDAO;
    public final String TEMPLATE_PATH = BundleUtils.getkey("template_path");
    public final String REPORT_PATH   = BundleUtils.getkey("report_path");

    Logger log = LoggerFactory.getLogger(SMSTcbRequest.class);

    public SMSTCBExport() {
        this.smsTcbRequestDAO = new SMSTcbRequestDAO();
    }

    public static void main(String[] args) {
        SMSTCBExport smstcbExport = new SMSTCBExport();
        smstcbExport.exportExcelReport();
    }

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        exportExcelReport();
    }

    public String initFilePath(){
        try {
            return REPORT_PATH + "smsmkt_tcb_report_out_"+ DateTimeUtils.getSysDateTimeForFileName()+".xlsx";
        } catch (Exception e) {
            e.printStackTrace();
            return REPORT_PATH + "smsmkt_tcb_report_out"+".xlsx";
        }
    }

    public void exportExcelReport(){
        List<SMSTcbRequest> lstRequest = smsTcbRequestDAO.getListSMSTCBRequest();

        log.info("Number of TCB request: "+ lstRequest.size());

        File file = new File(TEMPLATE_PATH);
        String templatePath = file.getAbsolutePath();

        Map<String, Object> beans = new HashMap<String, Object>();
        beans.put("items", lstRequest);

        Configuration config = new Configuration();
        XLSTransformer transformer = new XLSTransformer(config);

        String reportFullPath = initFilePath();
        try {
            transformer.transformXLS(templatePath, beans, reportFullPath);
            log.info("Finish export report file in "+ reportFullPath);
        } catch (InvalidFormatException e) {
            e.printStackTrace();
            log.error(e.toString());
        } catch (IOException e) {
            e.printStackTrace();
            log.error(e.toString());
        }
    }


}
