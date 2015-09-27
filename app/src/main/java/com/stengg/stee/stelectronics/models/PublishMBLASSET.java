package com.stengg.stee.stelectronics.models;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

/**
 * Created by Raymond Balingit on 24/9/2015.
 */
public class PublishMBLASSET {

    @Attribute(required = false)
    private String creationDateTime;

    @Attribute(required = false)
    private String messageID;

    @Attribute(required = false)
    private String transLanguage;

    @Attribute(required = false)
    private String event;

    @Attribute(required = false)
    private String baseLanguage;

    @Element(name = "MBLASSETSet")
    private MblAssetSet MBLASSETSet;

    @Attribute(required = false)
    private String xmlns;

    @Attribute(required = false)
    private String maximoVersion;

    public String getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(String creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public String getMessageID() {
        return messageID;
    }

    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }

    public String getTransLanguage() {
        return transLanguage;
    }

    public void setTransLanguage(String transLanguage) {
        this.transLanguage = transLanguage;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getBaseLanguage() {
        return baseLanguage;
    }

    public void setBaseLanguage(String baseLanguage) {
        this.baseLanguage = baseLanguage;
    }

    public MblAssetSet getMBLASSETSet() {
        return MBLASSETSet;
    }

    public void setMBLASSETSet(MblAssetSet MBLASSETSet) {
        this.MBLASSETSet = MBLASSETSet;
    }

    public String getXmlns() {
        return xmlns;
    }

    public void setXmlns(String xmlns) {
        this.xmlns = xmlns;
    }

    public String getMaximoVersion() {
        return maximoVersion;
    }

    public void setMaximoVersion(String maximoVersion) {
        this.maximoVersion = maximoVersion;
    }

    @Override
    public String toString() {
        return "ClassPojo [creationDateTime = " + creationDateTime + ", messageID = " + messageID + ", transLanguage = " + transLanguage + ", event = " + event + ", baseLanguage = " + baseLanguage + ", MBLASSETSet = " + MBLASSETSet + ", xmlns = " + xmlns + ", maximoVersion = " + maximoVersion + "]";
    }
}

