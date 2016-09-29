package com.vivas.dto;

/**
 * Created by duyot on 9/28/2016.
 */
public class SMSTcbRequest {
    public String msgId;
    public String sender;
    public String mobileNumber;
    public String msgText;
    public String msgType;
    public String msgTime;
    public String moId;
    public String priority;
    public String localTime;
    public String extension;
    public String signature;
    public String cpRequestId ;
    public String msgTypeId ;
    public String createDate ;
    public String scheduleTime ;
    public String partitionName ;
    public String agentId;
    public String adserId;
    public String contractId;
    public String contractTypeId;
    public String templateId;
    public String telcoId;
    public String status;
    public String idMod;
    public String finalPriority;
    public String labelId;

    public SMSTcbRequest(String msgId, String sender, String mobileNumber, String msgText, String msgType, String msgTime, String moId, String priority, String localTime, String extendsion, String signature, String cpRequestId, String msgTypeId, String createDate, String scheduleTime, String partitionName, String agentId, String adserId, String contractId, String contractTypeId, String templateId, String telcoId, String status, String idMod, String finalPriority) {
        this.msgId = msgId;
        this.sender = sender;
        this.mobileNumber = mobileNumber;
        this.msgText = msgText;
        this.msgType = msgType;
        this.msgTime = msgTime;
        this.moId = moId;
        this.priority = priority;
        this.localTime = localTime;
        this.extension = extendsion;
        this.signature = signature;
        this.cpRequestId = cpRequestId;
        this.msgTypeId = msgTypeId;
        this.createDate = createDate;
        this.scheduleTime = scheduleTime;
        this.partitionName = partitionName;
        this.agentId = agentId;
        this.adserId = adserId;
        this.contractId = contractId;
        this.contractTypeId = contractTypeId;
        this.templateId = templateId;
        this.telcoId = telcoId;
        this.status = status;
        this.idMod = idMod;
        this.finalPriority = finalPriority;
    }

    public SMSTcbRequest() {
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getMsgText() {
        return msgText;
    }

    public void setMsgText(String msgText) {
        this.msgText = msgText;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getMsgTime() {
        return msgTime;
    }

    public void setMsgTime(String msgTime) {
        this.msgTime = msgTime;
    }

    public String getMoId() {
        return moId;
    }

    public void setMoId(String moId) {
        this.moId = moId;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getLocalTime() {
        return localTime;
    }

    public void setLocalTime(String localTime) {
        this.localTime = localTime;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getCpRequestId() {
        return cpRequestId;
    }

    public void setCpRequestId(String cpRequestId) {
        this.cpRequestId = cpRequestId;
    }

    public String getMsgTypeId() {
        return msgTypeId;
    }

    public void setMsgTypeId(String msgTypeId) {
        this.msgTypeId = msgTypeId;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(String scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public String getPartitionName() {
        return partitionName;
    }

    public void setPartitionName(String partitionName) {
        this.partitionName = partitionName;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getAdserId() {
        return adserId;
    }

    public void setAdserId(String adserId) {
        this.adserId = adserId;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getContractTypeId() {
        return contractTypeId;
    }

    public void setContractTypeId(String contractTypeId) {
        this.contractTypeId = contractTypeId;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getTelcoId() {
        return telcoId;
    }

    public void setTelcoId(String telcoId) {
        this.telcoId = telcoId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIdMod() {
        return idMod;
    }

    public void setIdMod(String idMod) {
        this.idMod = idMod;
    }

    public String getFinalPriority() {
        return finalPriority;
    }

    public void setFinalPriority(String finalPriority) {
        this.finalPriority = finalPriority;
    }

    public String getLabelId() {
        return labelId;
    }

    public void setLabelId(String labelId) {
        this.labelId = labelId;
    }
}
