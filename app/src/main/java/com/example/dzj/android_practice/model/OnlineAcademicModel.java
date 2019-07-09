package com.example.dzj.android_practice.model;

import java.util.List;

public class OnlineAcademicModel {

    /**
     * companyId : string
     * id : 0
     * name : string
     * participantAmount : 0
     * participantDoctorAmount : 0
     * sampleCount : 0
     * mySampleCount : 0
     * applicationStatus : CREATED
     * onlineAcademicStatus : NOT_STARTED
     * endTime : 2019-06-26T03:50:22.584Z
     * startTime : 2019-06-26T03:50:22.584Z
     * supports : [{"onlineAcademicId":0,"supportId":"string","supportName":"string","type":"INITIATOR","role":"COMPANY","doctorCount":0}]
     * joinMethod : DOCTOR
     * templateCode : string
     * patientUrl : string
     * patientNativeUrl : string
     * doctorUrl : string
     * doctorNativeUrl : string
     * pointBalance : 0
     * pointUserId : string
     * medicineName : string
     * academicPoint : 0
     * remainingDoctorCount : 0
     * doctorCountLimit : 0
     * displayParticipantQuota : true
     * displayCompanyName : true
     * sharedDataConf : {"opened":true}
     * displaySamplePoint : true
     * supportImport : true
     * supportExport : true
     * img : string
     */

    private String companyId;
    private int id;
    private String name;
    private int participantAmount;
    private int participantDoctorAmount;
    private int sampleCount;
    private int mySampleCount;
    private String applicationStatus;
    private String onlineAcademicStatus;
    private String endTime;
    private String startTime;
    private String joinMethod;
    private String templateCode;
    private String patientUrl;
    private String patientNativeUrl;
    private String doctorUrl;
    private String doctorNativeUrl;
    private int pointBalance;
    private String pointUserId;
    private String medicineName;
    private int academicPoint;
    private int remainingDoctorCount;
    private int doctorCountLimit;
    private boolean displayParticipantQuota;
    private boolean displayCompanyName;
    private SharedDataConfBean sharedDataConf;
    private boolean displaySamplePoint;
    private boolean supportImport;
    private boolean supportExport;
    private String img;
    private List<SupportsBean> supports;

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParticipantAmount() {
        return participantAmount;
    }

    public void setParticipantAmount(int participantAmount) {
        this.participantAmount = participantAmount;
    }

    public int getParticipantDoctorAmount() {
        return participantDoctorAmount;
    }

    public void setParticipantDoctorAmount(int participantDoctorAmount) {
        this.participantDoctorAmount = participantDoctorAmount;
    }

    public int getSampleCount() {
        return sampleCount;
    }

    public void setSampleCount(int sampleCount) {
        this.sampleCount = sampleCount;
    }

    public int getMySampleCount() {
        return mySampleCount;
    }

    public void setMySampleCount(int mySampleCount) {
        this.mySampleCount = mySampleCount;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public String getOnlineAcademicStatus() {
        return onlineAcademicStatus;
    }

    public void setOnlineAcademicStatus(String onlineAcademicStatus) {
        this.onlineAcademicStatus = onlineAcademicStatus;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getJoinMethod() {
        return joinMethod;
    }

    public void setJoinMethod(String joinMethod) {
        this.joinMethod = joinMethod;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }

    public String getPatientUrl() {
        return patientUrl;
    }

    public void setPatientUrl(String patientUrl) {
        this.patientUrl = patientUrl;
    }

    public String getPatientNativeUrl() {
        return patientNativeUrl;
    }

    public void setPatientNativeUrl(String patientNativeUrl) {
        this.patientNativeUrl = patientNativeUrl;
    }

    public String getDoctorUrl() {
        return doctorUrl;
    }

    public void setDoctorUrl(String doctorUrl) {
        this.doctorUrl = doctorUrl;
    }

    public String getDoctorNativeUrl() {
        return doctorNativeUrl;
    }

    public void setDoctorNativeUrl(String doctorNativeUrl) {
        this.doctorNativeUrl = doctorNativeUrl;
    }

    public int getPointBalance() {
        return pointBalance;
    }

    public void setPointBalance(int pointBalance) {
        this.pointBalance = pointBalance;
    }

    public String getPointUserId() {
        return pointUserId;
    }

    public void setPointUserId(String pointUserId) {
        this.pointUserId = pointUserId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public int getAcademicPoint() {
        return academicPoint;
    }

    public void setAcademicPoint(int academicPoint) {
        this.academicPoint = academicPoint;
    }

    public int getRemainingDoctorCount() {
        return remainingDoctorCount;
    }

    public void setRemainingDoctorCount(int remainingDoctorCount) {
        this.remainingDoctorCount = remainingDoctorCount;
    }

    public int getDoctorCountLimit() {
        return doctorCountLimit;
    }

    public void setDoctorCountLimit(int doctorCountLimit) {
        this.doctorCountLimit = doctorCountLimit;
    }

    public boolean isDisplayParticipantQuota() {
        return displayParticipantQuota;
    }

    public void setDisplayParticipantQuota(boolean displayParticipantQuota) {
        this.displayParticipantQuota = displayParticipantQuota;
    }

    public boolean isDisplayCompanyName() {
        return displayCompanyName;
    }

    public void setDisplayCompanyName(boolean displayCompanyName) {
        this.displayCompanyName = displayCompanyName;
    }

    public SharedDataConfBean getSharedDataConf() {
        return sharedDataConf;
    }

    public void setSharedDataConf(SharedDataConfBean sharedDataConf) {
        this.sharedDataConf = sharedDataConf;
    }

    public boolean isDisplaySamplePoint() {
        return displaySamplePoint;
    }

    public void setDisplaySamplePoint(boolean displaySamplePoint) {
        this.displaySamplePoint = displaySamplePoint;
    }

    public boolean isSupportImport() {
        return supportImport;
    }

    public void setSupportImport(boolean supportImport) {
        this.supportImport = supportImport;
    }

    public boolean isSupportExport() {
        return supportExport;
    }

    public void setSupportExport(boolean supportExport) {
        this.supportExport = supportExport;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public List<SupportsBean> getSupports() {
        return supports;
    }

    public void setSupports(List<SupportsBean> supports) {
        this.supports = supports;
    }

    public static class SharedDataConfBean {
        /**
         * opened : true
         */

        private boolean opened;

        public boolean isOpened() {
            return opened;
        }

        public void setOpened(boolean opened) {
            this.opened = opened;
        }
    }

    public static class SupportsBean {
        /**
         * onlineAcademicId : 0
         * supportId : string
         * supportName : string
         * type : INITIATOR
         * role : COMPANY
         * doctorCount : 0
         */

        private int onlineAcademicId;
        private String supportId;
        private String supportName;
        private String type;
        private String role;
        private int doctorCount;

        public int getOnlineAcademicId() {
            return onlineAcademicId;
        }

        public void setOnlineAcademicId(int onlineAcademicId) {
            this.onlineAcademicId = onlineAcademicId;
        }

        public String getSupportId() {
            return supportId;
        }

        public void setSupportId(String supportId) {
            this.supportId = supportId;
        }

        public String getSupportName() {
            return supportName;
        }

        public void setSupportName(String supportName) {
            this.supportName = supportName;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public int getDoctorCount() {
            return doctorCount;
        }

        public void setDoctorCount(int doctorCount) {
            this.doctorCount = doctorCount;
        }
    }
}
