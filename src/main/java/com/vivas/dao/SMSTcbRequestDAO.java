package com.vivas.dao;

import com.google.common.collect.Lists;
import com.vivas.dto.SMSTcbRequest;
import com.vivas.utils.DBUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 * Created by duyot on 9/28/2016.
 */
public class SMSTcbRequestDAO {
    Logger log = LoggerFactory.getLogger(SMSTcbRequestDAO.class);
//    public static final String getAllSMSTcbRequestSQL = "SELECT * FROM sms_tcb_request where created_date > sysdate ";
    public static final String getAllSMSTcbRequestSQL = "SELECT * FROM sms_tcb_request ";


    public static void main(String[] args) {
        SMSTcbRequestDAO dao = new SMSTcbRequestDAO();
        System.out.println(dao.getListSMSTCBRequest().size());
    }

    public List<SMSTcbRequest> getListSMSTCBRequest(){
        List<SMSTcbRequest> lstSMSTCBRequest = Lists.newArrayList();

        Connection con = DBUtils.getConnection();
        ResultSet rs = null;
        Statement statement = null;

        if(con == null){
            return lstSMSTCBRequest;
        }

        try {
            statement = con.createStatement();
            rs = statement.executeQuery(getAllSMSTcbRequestSQL);
            while(rs.next()){
                SMSTcbRequest temp = new SMSTcbRequest();

                temp.setMsgId(nvl(rs.getString("MSGID")));
                temp.setSender(nvl(rs.getString("SENDER")));
                temp.setMobileNumber(nvl(rs.getString("MOBINUMBER")));
                temp.setMsgText(nvl(rs.getString("MSGTEXT")));
                temp.setMsgType(nvl(rs.getString("MSGTYPE")));
                temp.setMsgTime(nvl(rs.getString("MSGTIME")));
                temp.setMoId(nvl(rs.getString("MOID")));
                temp.setPriority(nvl(rs.getString("PRIORITY")));
                temp.setLocalTime(nvl(rs.getString("LOCALTIME")));
                temp.setExtension(nvl(rs.getString("EXTENSION")));
                temp.setSignature(nvl(rs.getString("SIGNATURE")));
                temp.setCpRequestId(nvl(rs.getString("CPREQUESTID")));
                temp.setCreateDate(nvl(rs.getString("CREATED_DATE")));
                temp.setScheduleTime(nvl(rs.getString("SCHEDULE_TIME")));
                temp.setPartitionName(nvl(rs.getString("PARTITION_NAME")));
                temp.setAgentId(nvl(rs.getString("AGENT_ID")));
                temp.setAdserId(nvl(rs.getString("ADSER_ID")));
                temp.setContractId(nvl(rs.getString("CONTRACT_ID")));
                temp.setLabelId(nvl(rs.getString("LABEL_ID")));
                temp.setTemplateId(nvl(rs.getString("TEMPLATE_ID")));
                temp.setTelcoId(nvl(rs.getString("TELCO_ID")));
                temp.setStatus(nvl(rs.getString("STATUS")));

                lstSMSTCBRequest.add(temp);
            }

            return lstSMSTCBRequest;
        } catch (Exception e) {
            log.error("Error caused: "+ e.toString());
            e.printStackTrace();
        }finally {
            DBUtils.closeConnection(rs,statement,con);
        }

        return lstSMSTCBRequest;
    }

    private String nvl(String value){
        return value == null ? "":value;
    }
}
