package com.stengg.stee.stelectronics.models;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by Raymond Balingit on 18/9/2015.
 */
@Root
public class Asset
{
    @Element(name = "DIRECTION", required = false)
    private String DIRECTION;

    @Element(name = "STATUSDATE", required = false)
    private String STATUSDATE;

    @Element(name = "PLUSCISMTECLASS", required = false)
    private String PLUSCISMTECLASS;

    @Element(name = "PLUSCPHYLOC", required = false)
    private String PLUSCPHYLOC;

    @Element(name = "PLUSCASSETDEPT", required = false)
    private String PLUSCASSETDEPT;

    @Element(name = "STARTMEASURE", required = false)
    private String STARTMEASURE;

    @Element(name = "ENDMEASURE", required = false)
    private String ENDMEASURE;

    @Element(name = "DEFAULTREPFAC", required = false)
    private String DEFAULTREPFAC;

    @Element(name = "CHILDREN", required = false)
    private String CHILDREN;

    @Element(name = "DISABLED", required = false)
    private String DISABLED;

    @Element(name = "ISCALIBRATION", required = false)
    private String ISCALIBRATION;

    @Element(name = "ORGID", required = false)
    private String ORGID;

    @Element(name = "LOCATIONS", required = false)
    private Locations LOCATIONS;

    @Element(name = "FAILURECODE", required = false)
    private String FAILURECODE;

    @Element(name = "INVCOST", required = false)
    private String INVCOST;

    @Element(name = "TOTUNCHARGEDCOST", required = false)
    private String TOTUNCHARGEDCOST;

    @Element(name = "BINNUM", required = false)
    private String BINNUM;

    @Element(name = "PLUSCSUMDIR", required = false)
    private String PLUSCSUMDIR;

    @Element(name = "PLUSCISCONDESC", required = false)
    private String PLUSCISCONDESC;

    @Element(name = "GLACCOUNT", required = false)
    private String GLACCOUNT;

    @Element(name = "PLUSCOPRGEEU", required = false)
    private String PLUSCOPRGEEU;

    @Element(name = "ASSETUID", required = false)
    private String ASSETUID;

    @Element(name = "USAGE", required = false)
    private String USAGE;

    @Element(name = "PLUSCISINHOUSECAL", required = false)
    private String PLUSCISINHOUSECAL;

    @Element(name = "ISRUNNING", required = false)
    private String ISRUNNING;

    @Element(name = "BUDGETCOST", required = false)
    private String BUDGETCOST;

    @Element(name = "PARENT", required = false)
    private String PARENT;

    @Element(name = "PLUSCLPLOC", required = false)
    private String PLUSCLPLOC;

    @Element(name = "LRM", required = false)
    private String LRM;

    @Element(name = "ASSETNUM", required = false)
    private String ASSETNUM;

    @Element(name = "DESCRIPTION", required = false)
    private String DESCRIPTION;

    @Element(name = "PLUSCSUMSPAN", required = false)
    private String PLUSCSUMSPAN;

    @Element(name = "ASSETCODE", required = false)
    private String ASSETCODE;

    @Element(name = "INSTALLDATE", required = false)
    private String INSTALLDATE;

    @Element(name = "ITEMSETID", required = false)
    private String ITEMSETID;

    @Element(name = "SHIFTNUM", required = false)
    private String SHIFTNUM;

    @Element(name = "RETURNEDTOVENDOR", required = false)
    private String RETURNEDTOVENDOR;

    @Element(name = "ANCESTOR", required = false)
    private String ANCESTOR;

    @Element(name = "MAINTHIERCHY", required = false)
    private String MAINTHIERCHY;

    @Element(name = "CHANGEBY", required = false)
    private String CHANGEBY;

    @Element(name = "PLUSCPMEXTDATE", required = false)
    private String PLUSCPMEXTDATE;

    @Element(name = "UNCHARGEDCOST", required = false)
    private String UNCHARGEDCOST;

    @Element(name = "PLUSCVENDOR", required = false)
    private String PLUSCVENDOR;

    @Element(name = "PLUSCOPRGEFROM", required = false)
    private String PLUSCOPRGEFROM;

    @Element(name = "PLUSCLOOPNUM", required = false)
    private String PLUSCLOOPNUM;

    @Element(name = "ITEMTYPE", required = false)
    private String ITEMTYPE;

    @Element(name = "WARRANTYEXPDATE", required = false)
    private String WARRANTYEXPDATE;

    @Element(name = "ENDDESCRIPTION", required = false)
    private String ENDDESCRIPTION;

    @Element(name = "TLOAMHASH", required = false)
    private String TLOAMHASH;

    @Element(name = "TOTALCOST", required = false)
    private String TOTALCOST;

    @Element(name = "PLUSCMODELNUM", required = false)
    private String PLUSCMODELNUM;

    @Element(name = "STARTDESCRIPTION", required = false)
    private String STARTDESCRIPTION;

    @Element(name = "GROUPNAME", required = false)
    private String GROUPNAME;

    @Element(name = "STATUS", required = false)
    private Status STATUS;

    @Element(name = "PLUSCSOLUTION", required = false)
    private String PLUSCSOLUTION;

    @Element(name = "SERIALNUM", required = false)
    private String SERIALNUM;

    @Element(name = "PLUSCSUMREAD", required = false)
    private String PLUSCSUMREAD;

    @Element(name = "PLUSCCLASS", required = false)
    private String PLUSCCLASS;

    @Element(name = "PURCHASEPRICE", required = false)
    private String PURCHASEPRICE;

    @Element(name = "TOOLCONTROLACCOUNT", required = false)
    private String TOOLCONTROLACCOUNT;

    @Element(name = "PLUSCSUMURV", required = false)
    private String PLUSCSUMURV;

    @Element(name = "PLUSCDUEDATE", required = false)
    private String PLUSCDUEDATE;

    @Element(name = "MAINT_OWNER", required = false)
    private String MAINT_OWNER;

    @Element(name = "PLUSCISMTE", required = false)
    private String PLUSCISMTE;

    @Element(name = "TOTDOWNTIME", required = false)
    private String TOTDOWNTIME;

    @Element(name = "SADDRESSCODE", required = false)
    private String SADDRESSCODE;

    @Element(name = "SITEID", required = false)
    private String SITEID;

    @Element(name = "CHANGEDATE", required = false)
    private String CHANGEDATE;

    @Element(name = "MANUFACTURER", required = false)
    private String MANUFACTURER;

    @Element(name = "ITEMNUM", required = false)
    private String ITEMNUM;

    @Element(name = "ASSETID", required = false)
    private String ASSETID;

    @Element(name = "TOOLRATE", required = false)
    private String TOOLRATE;

    @Element(name = "CLASSSTRUCTUREID", required = false)
    private String CLASSSTRUCTUREID;

    @Element(name = "RIORITY", required = false)
    private String PRIORITY;

    @Element(name = "PLUSCSUMEU", required = false)
    private String PLUSCSUMEU;

    @Element(name = "ROTSUSPACCT", required = false)
    private String ROTSUSPACCT;

    @Element(name = "REPLACECOST", required = false)
    private String REPLACECOST;

    @Element(name = "CALNUM", required = false)
    private String CALNUM;

    @Element(name = "TLOAMPARTITION", required = false)
    private String TLOAMPARTITION;

    @Element(name = "PLUSCOPRGETO", required = false)
    private String PLUSCOPRGETO;

    @Element(name = "LOCATION", required = false)
    private String LOCATION;

    @Element(name = "ASSETTAG", required = false)
    private String ASSETTAG;

    @Element(name = "AUTOWOGEN", required = false)
    private String AUTOWOGEN;

    @Element(name = "CONDITIONCODE", required = false)
    private String CONDITIONCODE;

    @Element(name = "DEFAULTREPFACSITEID", required = false)
    private String DEFAULTREPFACSITEID;

    @Element(name = "YTDCOST", required = false)
    private String YTDCOST;

    @Element(name = "ASSETTYPE", required = false)
    private String ASSETTYPE;

    @Element(name = "TEMPLATEID", required = false)
    private String TEMPLATEID;

    @Element(name = "ISLINEAR", required = false)
    private String ISLINEAR;

    @Element(name = "PLUSCISCONTAM", required = false)
    private String PLUSCISCONTAM;

    @Element(name = "MOVED", required = false)
    private String MOVED;

    @Element(name = "VENDOR", required = false)
    private String VENDOR;

    @ElementList(name = "ASSETSPEC", inline = true, required = false)
    private AssetSpec ASSETSPEC;

    @ElementList(name = "WORKORDER", inline = true, required = false)
    private List<WorkOrder> WORKORDER;

    @Element(name = "DOCLINKS", required = false)
    private DocLinks DOCLINKS;

    public String getDIRECTION ()
    {
        return DIRECTION;
    }

    public void setDIRECTION (String DIRECTION)
    {
        this.DIRECTION = DIRECTION;
    }

    public String getSTATUSDATE ()
    {
        return STATUSDATE;
    }

    public void setSTATUSDATE (String STATUSDATE)
    {
        this.STATUSDATE = STATUSDATE;
    }

    public String getPLUSCISMTECLASS ()
    {
        return PLUSCISMTECLASS;
    }

    public void setPLUSCISMTECLASS (String PLUSCISMTECLASS)
    {
        this.PLUSCISMTECLASS = PLUSCISMTECLASS;
    }

    public String getPLUSCPHYLOC ()
    {
        return PLUSCPHYLOC;
    }

    public void setPLUSCPHYLOC (String PLUSCPHYLOC)
    {
        this.PLUSCPHYLOC = PLUSCPHYLOC;
    }

    public String getPLUSCASSETDEPT ()
    {
        return PLUSCASSETDEPT;
    }

    public void setPLUSCASSETDEPT (String PLUSCASSETDEPT)
    {
        this.PLUSCASSETDEPT = PLUSCASSETDEPT;
    }

    public String getSTARTMEASURE ()
    {
        return STARTMEASURE;
    }

    public void setSTARTMEASURE (String STARTMEASURE)
    {
        this.STARTMEASURE = STARTMEASURE;
    }

    public String getENDMEASURE ()
    {
        return ENDMEASURE;
    }

    public void setENDMEASURE (String ENDMEASURE)
    {
        this.ENDMEASURE = ENDMEASURE;
    }

    public String getDEFAULTREPFAC ()
    {
        return DEFAULTREPFAC;
    }

    public void setDEFAULTREPFAC (String DEFAULTREPFAC)
    {
        this.DEFAULTREPFAC = DEFAULTREPFAC;
    }

    public String getCHILDREN ()
    {
        return CHILDREN;
    }

    public void setCHILDREN (String CHILDREN)
    {
        this.CHILDREN = CHILDREN;
    }

    public String getDISABLED ()
    {
        return DISABLED;
    }

    public void setDISABLED (String DISABLED)
    {
        this.DISABLED = DISABLED;
    }

    public String getISCALIBRATION ()
    {
        return ISCALIBRATION;
    }

    public void setISCALIBRATION (String ISCALIBRATION)
    {
        this.ISCALIBRATION = ISCALIBRATION;
    }

    public String getORGID ()
    {
        return ORGID;
    }

    public void setORGID (String ORGID)
    {
        this.ORGID = ORGID;
    }

    public Locations getLOCATIONS ()
    {
        return LOCATIONS;
    }

    public void setLOCATIONS (Locations LOCATIONS)
    {
        this.LOCATIONS = LOCATIONS;
    }

    public String getFAILURECODE ()
    {
        return FAILURECODE;
    }

    public void setFAILURECODE (String FAILURECODE)
    {
        this.FAILURECODE = FAILURECODE;
    }

    public String getINVCOST ()
    {
        return INVCOST;
    }

    public void setINVCOST (String INVCOST)
    {
        this.INVCOST = INVCOST;
    }

    public String getTOTUNCHARGEDCOST ()
    {
        return TOTUNCHARGEDCOST;
    }

    public void setTOTUNCHARGEDCOST (String TOTUNCHARGEDCOST)
    {
        this.TOTUNCHARGEDCOST = TOTUNCHARGEDCOST;
    }

    public String getBINNUM ()
    {
        return BINNUM;
    }

    public void setBINNUM (String BINNUM)
    {
        this.BINNUM = BINNUM;
    }

    public String getPLUSCSUMDIR ()
    {
        return PLUSCSUMDIR;
    }

    public void setPLUSCSUMDIR (String PLUSCSUMDIR)
    {
        this.PLUSCSUMDIR = PLUSCSUMDIR;
    }

    public String getPLUSCISCONDESC ()
    {
        return PLUSCISCONDESC;
    }

    public void setPLUSCISCONDESC (String PLUSCISCONDESC)
    {
        this.PLUSCISCONDESC = PLUSCISCONDESC;
    }

    public String getGLACCOUNT ()
    {
        return GLACCOUNT;
    }

    public void setGLACCOUNT (String GLACCOUNT)
    {
        this.GLACCOUNT = GLACCOUNT;
    }

    public String getPLUSCOPRGEEU ()
    {
        return PLUSCOPRGEEU;
    }

    public void setPLUSCOPRGEEU (String PLUSCOPRGEEU)
    {
        this.PLUSCOPRGEEU = PLUSCOPRGEEU;
    }

    public String getASSETUID ()
    {
        return ASSETUID;
    }

    public void setASSETUID (String ASSETUID)
    {
        this.ASSETUID = ASSETUID;
    }

    public String getUSAGE ()
    {
        return USAGE;
    }

    public void setUSAGE (String USAGE)
    {
        this.USAGE = USAGE;
    }

    public String getPLUSCISINHOUSECAL ()
    {
        return PLUSCISINHOUSECAL;
    }

    public void setPLUSCISINHOUSECAL (String PLUSCISINHOUSECAL)
    {
        this.PLUSCISINHOUSECAL = PLUSCISINHOUSECAL;
    }

    public String getISRUNNING ()
    {
        return ISRUNNING;
    }

    public void setISRUNNING (String ISRUNNING)
    {
        this.ISRUNNING = ISRUNNING;
    }

    public String getBUDGETCOST ()
    {
        return BUDGETCOST;
    }

    public void setBUDGETCOST (String BUDGETCOST)
    {
        this.BUDGETCOST = BUDGETCOST;
    }

    public String getPARENT ()
    {
        return PARENT;
    }

    public void setPARENT (String PARENT)
    {
        this.PARENT = PARENT;
    }

    public String getPLUSCLPLOC ()
    {
        return PLUSCLPLOC;
    }

    public void setPLUSCLPLOC (String PLUSCLPLOC)
    {
        this.PLUSCLPLOC = PLUSCLPLOC;
    }

    public String getLRM ()
    {
        return LRM;
    }

    public void setLRM (String LRM)
    {
        this.LRM = LRM;
    }

    public String getASSETNUM ()
    {
        return ASSETNUM;
    }

    public void setASSETNUM (String ASSETNUM)
    {
        this.ASSETNUM = ASSETNUM;
    }

    public String getDESCRIPTION ()
    {
        return DESCRIPTION;
    }

    public void setDESCRIPTION (String DESCRIPTION)
    {
        this.DESCRIPTION = DESCRIPTION;
    }

    public String getPLUSCSUMSPAN ()
    {
        return PLUSCSUMSPAN;
    }

    public void setPLUSCSUMSPAN (String PLUSCSUMSPAN)
    {
        this.PLUSCSUMSPAN = PLUSCSUMSPAN;
    }

    public String getASSETCODE ()
    {
        return ASSETCODE;
    }

    public void setASSETCODE (String ASSETCODE)
    {
        this.ASSETCODE = ASSETCODE;
    }

    public String getINSTALLDATE ()
    {
        return INSTALLDATE;
    }

    public void setINSTALLDATE (String INSTALLDATE)
    {
        this.INSTALLDATE = INSTALLDATE;
    }

    public String getITEMSETID ()
    {
        return ITEMSETID;
    }

    public void setITEMSETID (String ITEMSETID)
    {
        this.ITEMSETID = ITEMSETID;
    }

    public String getSHIFTNUM ()
    {
        return SHIFTNUM;
    }

    public void setSHIFTNUM (String SHIFTNUM)
    {
        this.SHIFTNUM = SHIFTNUM;
    }

    public String getRETURNEDTOVENDOR ()
    {
        return RETURNEDTOVENDOR;
    }

    public void setRETURNEDTOVENDOR (String RETURNEDTOVENDOR)
    {
        this.RETURNEDTOVENDOR = RETURNEDTOVENDOR;
    }

    public String getANCESTOR ()
    {
        return ANCESTOR;
    }

    public void setANCESTOR (String ANCESTOR)
    {
        this.ANCESTOR = ANCESTOR;
    }

    public String getMAINTHIERCHY ()
    {
        return MAINTHIERCHY;
    }

    public void setMAINTHIERCHY (String MAINTHIERCHY)
    {
        this.MAINTHIERCHY = MAINTHIERCHY;
    }

    public String getCHANGEBY ()
    {
        return CHANGEBY;
    }

    public void setCHANGEBY (String CHANGEBY)
    {
        this.CHANGEBY = CHANGEBY;
    }

    public String getPLUSCPMEXTDATE ()
    {
        return PLUSCPMEXTDATE;
    }

    public void setPLUSCPMEXTDATE (String PLUSCPMEXTDATE)
    {
        this.PLUSCPMEXTDATE = PLUSCPMEXTDATE;
    }

    public String getUNCHARGEDCOST ()
    {
        return UNCHARGEDCOST;
    }

    public void setUNCHARGEDCOST (String UNCHARGEDCOST)
    {
        this.UNCHARGEDCOST = UNCHARGEDCOST;
    }

    public String getPLUSCVENDOR ()
    {
        return PLUSCVENDOR;
    }

    public void setPLUSCVENDOR (String PLUSCVENDOR)
    {
        this.PLUSCVENDOR = PLUSCVENDOR;
    }

    public String getPLUSCOPRGEFROM ()
    {
        return PLUSCOPRGEFROM;
    }

    public void setPLUSCOPRGEFROM (String PLUSCOPRGEFROM)
    {
        this.PLUSCOPRGEFROM = PLUSCOPRGEFROM;
    }

    public String getPLUSCLOOPNUM ()
    {
        return PLUSCLOOPNUM;
    }

    public void setPLUSCLOOPNUM (String PLUSCLOOPNUM)
    {
        this.PLUSCLOOPNUM = PLUSCLOOPNUM;
    }

    public String getITEMTYPE ()
    {
        return ITEMTYPE;
    }

    public void setITEMTYPE (String ITEMTYPE)
    {
        this.ITEMTYPE = ITEMTYPE;
    }

    public String getWARRANTYEXPDATE ()
    {
        return WARRANTYEXPDATE;
    }

    public void setWARRANTYEXPDATE (String WARRANTYEXPDATE)
    {
        this.WARRANTYEXPDATE = WARRANTYEXPDATE;
    }

    public String getENDDESCRIPTION ()
    {
        return ENDDESCRIPTION;
    }

    public void setENDDESCRIPTION (String ENDDESCRIPTION)
    {
        this.ENDDESCRIPTION = ENDDESCRIPTION;
    }

    public String getTLOAMHASH ()
    {
        return TLOAMHASH;
    }

    public void setTLOAMHASH (String TLOAMHASH)
    {
        this.TLOAMHASH = TLOAMHASH;
    }

    public String getTOTALCOST ()
    {
        return TOTALCOST;
    }

    public void setTOTALCOST (String TOTALCOST)
    {
        this.TOTALCOST = TOTALCOST;
    }

    public String getPLUSCMODELNUM ()
    {
        return PLUSCMODELNUM;
    }

    public void setPLUSCMODELNUM (String PLUSCMODELNUM)
    {
        this.PLUSCMODELNUM = PLUSCMODELNUM;
    }

    public String getSTARTDESCRIPTION ()
    {
        return STARTDESCRIPTION;
    }

    public void setSTARTDESCRIPTION (String STARTDESCRIPTION)
    {
        this.STARTDESCRIPTION = STARTDESCRIPTION;
    }

    public String getGROUPNAME ()
    {
        return GROUPNAME;
    }

    public void setGROUPNAME (String GROUPNAME)
    {
        this.GROUPNAME = GROUPNAME;
    }

    public Status getSTATUS ()
    {
        return STATUS;
    }

    public void setSTATUS (Status STATUS)
    {
        this.STATUS = STATUS;
    }

    public String getPLUSCSOLUTION ()
    {
        return PLUSCSOLUTION;
    }

    public void setPLUSCSOLUTION (String PLUSCSOLUTION)
    {
        this.PLUSCSOLUTION = PLUSCSOLUTION;
    }

    public String getSERIALNUM ()
    {
        return SERIALNUM;
    }

    public void setSERIALNUM (String SERIALNUM)
    {
        this.SERIALNUM = SERIALNUM;
    }

    public String getPLUSCSUMREAD ()
    {
        return PLUSCSUMREAD;
    }

    public void setPLUSCSUMREAD (String PLUSCSUMREAD)
    {
        this.PLUSCSUMREAD = PLUSCSUMREAD;
    }

    public String getPLUSCCLASS ()
    {
        return PLUSCCLASS;
    }

    public void setPLUSCCLASS (String PLUSCCLASS)
    {
        this.PLUSCCLASS = PLUSCCLASS;
    }

    public String getPURCHASEPRICE ()
    {
        return PURCHASEPRICE;
    }

    public void setPURCHASEPRICE (String PURCHASEPRICE)
    {
        this.PURCHASEPRICE = PURCHASEPRICE;
    }

    public String getTOOLCONTROLACCOUNT ()
    {
        return TOOLCONTROLACCOUNT;
    }

    public void setTOOLCONTROLACCOUNT (String TOOLCONTROLACCOUNT)
    {
        this.TOOLCONTROLACCOUNT = TOOLCONTROLACCOUNT;
    }

    public String getPLUSCSUMURV ()
    {
        return PLUSCSUMURV;
    }

    public void setPLUSCSUMURV (String PLUSCSUMURV)
    {
        this.PLUSCSUMURV = PLUSCSUMURV;
    }

    public String getPLUSCDUEDATE ()
    {
        return PLUSCDUEDATE;
    }

    public void setPLUSCDUEDATE (String PLUSCDUEDATE)
    {
        this.PLUSCDUEDATE = PLUSCDUEDATE;
    }

    public String getMAINT_OWNER ()
    {
        return MAINT_OWNER;
    }

    public void setMAINT_OWNER (String MAINT_OWNER)
    {
        this.MAINT_OWNER = MAINT_OWNER;
    }

    public String getPLUSCISMTE ()
    {
        return PLUSCISMTE;
    }

    public void setPLUSCISMTE (String PLUSCISMTE)
    {
        this.PLUSCISMTE = PLUSCISMTE;
    }

    public String getTOTDOWNTIME ()
    {
        return TOTDOWNTIME;
    }

    public void setTOTDOWNTIME (String TOTDOWNTIME)
    {
        this.TOTDOWNTIME = TOTDOWNTIME;
    }

    public String getSADDRESSCODE ()
    {
        return SADDRESSCODE;
    }

    public void setSADDRESSCODE (String SADDRESSCODE)
    {
        this.SADDRESSCODE = SADDRESSCODE;
    }

    public String getSITEID ()
    {
        return SITEID;
    }

    public void setSITEID (String SITEID)
    {
        this.SITEID = SITEID;
    }

    public String getCHANGEDATE ()
    {
        return CHANGEDATE;
    }

    public void setCHANGEDATE (String CHANGEDATE)
    {
        this.CHANGEDATE = CHANGEDATE;
    }

    public String getMANUFACTURER ()
    {
        return MANUFACTURER;
    }

    public void setMANUFACTURER (String MANUFACTURER)
    {
        this.MANUFACTURER = MANUFACTURER;
    }

    public String getITEMNUM ()
    {
        return ITEMNUM;
    }

    public void setITEMNUM (String ITEMNUM)
    {
        this.ITEMNUM = ITEMNUM;
    }

    public String getASSETID ()
    {
        return ASSETID;
    }

    public void setASSETID (String ASSETID)
    {
        this.ASSETID = ASSETID;
    }

    public String getTOOLRATE ()
    {
        return TOOLRATE;
    }

    public void setTOOLRATE (String TOOLRATE)
    {
        this.TOOLRATE = TOOLRATE;
    }

    public String getCLASSSTRUCTUREID ()
    {
        return CLASSSTRUCTUREID;
    }

    public void setCLASSSTRUCTUREID (String CLASSSTRUCTUREID)
    {
        this.CLASSSTRUCTUREID = CLASSSTRUCTUREID;
    }

    public String getPRIORITY ()
    {
        return PRIORITY;
    }

    public void setPRIORITY (String PRIORITY)
    {
        this.PRIORITY = PRIORITY;
    }

    public String getPLUSCSUMEU ()
    {
        return PLUSCSUMEU;
    }

    public void setPLUSCSUMEU (String PLUSCSUMEU)
    {
        this.PLUSCSUMEU = PLUSCSUMEU;
    }

    public String getROTSUSPACCT ()
    {
        return ROTSUSPACCT;
    }

    public void setROTSUSPACCT (String ROTSUSPACCT)
    {
        this.ROTSUSPACCT = ROTSUSPACCT;
    }

    public String getREPLACECOST ()
    {
        return REPLACECOST;
    }

    public void setREPLACECOST (String REPLACECOST)
    {
        this.REPLACECOST = REPLACECOST;
    }

    public String getCALNUM ()
    {
        return CALNUM;
    }

    public void setCALNUM (String CALNUM)
    {
        this.CALNUM = CALNUM;
    }

    public String getTLOAMPARTITION ()
    {
        return TLOAMPARTITION;
    }

    public void setTLOAMPARTITION (String TLOAMPARTITION)
    {
        this.TLOAMPARTITION = TLOAMPARTITION;
    }

    public String getPLUSCOPRGETO ()
    {
        return PLUSCOPRGETO;
    }

    public void setPLUSCOPRGETO (String PLUSCOPRGETO)
    {
        this.PLUSCOPRGETO = PLUSCOPRGETO;
    }

    public String getLOCATION ()
    {
        return LOCATION;
    }

    public void setLOCATION (String LOCATION)
    {
        this.LOCATION = LOCATION;
    }

    public String getASSETTAG ()
    {
        return ASSETTAG;
    }

    public void setASSETTAG (String ASSETTAG)
    {
        this.ASSETTAG = ASSETTAG;
    }

    public String getAUTOWOGEN ()
    {
        return AUTOWOGEN;
    }

    public void setAUTOWOGEN (String AUTOWOGEN)
    {
        this.AUTOWOGEN = AUTOWOGEN;
    }

    public String getCONDITIONCODE ()
    {
        return CONDITIONCODE;
    }

    public void setCONDITIONCODE (String CONDITIONCODE)
    {
        this.CONDITIONCODE = CONDITIONCODE;
    }

    public String getDEFAULTREPFACSITEID ()
    {
        return DEFAULTREPFACSITEID;
    }

    public void setDEFAULTREPFACSITEID (String DEFAULTREPFACSITEID)
    {
        this.DEFAULTREPFACSITEID = DEFAULTREPFACSITEID;
    }

    public String getYTDCOST ()
    {
        return YTDCOST;
    }

    public void setYTDCOST (String YTDCOST)
    {
        this.YTDCOST = YTDCOST;
    }

    public String getASSETTYPE ()
    {
        return ASSETTYPE;
    }

    public void setASSETTYPE (String ASSETTYPE)
    {
        this.ASSETTYPE = ASSETTYPE;
    }

    public String getTEMPLATEID ()
    {
        return TEMPLATEID;
    }

    public void setTEMPLATEID (String TEMPLATEID)
    {
        this.TEMPLATEID = TEMPLATEID;
    }

    public String getISLINEAR ()
    {
        return ISLINEAR;
    }

    public void setISLINEAR (String ISLINEAR)
    {
        this.ISLINEAR = ISLINEAR;
    }

    public String getPLUSCISCONTAM ()
    {
        return PLUSCISCONTAM;
    }

    public void setPLUSCISCONTAM (String PLUSCISCONTAM)
    {
        this.PLUSCISCONTAM = PLUSCISCONTAM;
    }

    public String getMOVED ()
    {
        return MOVED;
    }

    public void setMOVED (String MOVED)
    {
        this.MOVED = MOVED;
    }

    public String getVENDOR ()
    {
        return VENDOR;
    }

    public void setVENDOR (String VENDOR)
    {
        this.VENDOR = VENDOR;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [DIRECTION = "+DIRECTION+", STATUSDATE = "+STATUSDATE+", PLUSCISMTECLASS = "+PLUSCISMTECLASS+", PLUSCPHYLOC = "+PLUSCPHYLOC+", PLUSCASSETDEPT = "+PLUSCASSETDEPT+", STARTMEASURE = "+STARTMEASURE+", ENDMEASURE = "+ENDMEASURE+", DEFAULTREPFAC = "+DEFAULTREPFAC+", CHILDREN = "+CHILDREN+", DISABLED = "+DISABLED+", ISCALIBRATION = "+ISCALIBRATION+", ORGID = "+ORGID+", LOCATIONS = "+LOCATIONS+", FAILURECODE = "+FAILURECODE+", INVCOST = "+INVCOST+", TOTUNCHARGEDCOST = "+TOTUNCHARGEDCOST+", BINNUM = "+BINNUM+", PLUSCSUMDIR = "+PLUSCSUMDIR+", PLUSCISCONDESC = "+PLUSCISCONDESC+", GLACCOUNT = "+GLACCOUNT+", PLUSCOPRGEEU = "+PLUSCOPRGEEU+", ASSETUID = "+ASSETUID+", USAGE = "+USAGE+", PLUSCISINHOUSECAL = "+PLUSCISINHOUSECAL+", ISRUNNING = "+ISRUNNING+", BUDGETCOST = "+BUDGETCOST+", PARENT = "+PARENT+", PLUSCLPLOC = "+PLUSCLPLOC+", LRM = "+LRM+", ASSETNUM = "+ASSETNUM+", DESCRIPTION = "+DESCRIPTION+", PLUSCSUMSPAN = "+PLUSCSUMSPAN+", ASSETCODE = "+ASSETCODE+", INSTALLDATE = "+INSTALLDATE+", ITEMSETID = "+ITEMSETID+", SHIFTNUM = "+SHIFTNUM+", RETURNEDTOVENDOR = "+RETURNEDTOVENDOR+", ANCESTOR = "+ANCESTOR+", MAINTHIERCHY = "+MAINTHIERCHY+", CHANGEBY = "+CHANGEBY+", PLUSCPMEXTDATE = "+PLUSCPMEXTDATE+", UNCHARGEDCOST = "+UNCHARGEDCOST+", PLUSCVENDOR = "+PLUSCVENDOR+", PLUSCOPRGEFROM = "+PLUSCOPRGEFROM+", PLUSCLOOPNUM = "+PLUSCLOOPNUM+", ITEMTYPE = "+ITEMTYPE+", WARRANTYEXPDATE = "+WARRANTYEXPDATE+", ENDDESCRIPTION = "+ENDDESCRIPTION+", TLOAMHASH = "+TLOAMHASH+", TOTALCOST = "+TOTALCOST+", PLUSCMODELNUM = "+PLUSCMODELNUM+", STARTDESCRIPTION = "+STARTDESCRIPTION+", GROUPNAME = "+GROUPNAME+", STATUS = "+STATUS+", PLUSCSOLUTION = "+PLUSCSOLUTION+", SERIALNUM = "+SERIALNUM+", PLUSCSUMREAD = "+PLUSCSUMREAD+", PLUSCCLASS = "+PLUSCCLASS+", PURCHASEPRICE = "+PURCHASEPRICE+", TOOLCONTROLACCOUNT = "+TOOLCONTROLACCOUNT+", PLUSCSUMURV = "+PLUSCSUMURV+", PLUSCDUEDATE = "+PLUSCDUEDATE+", MAINT_OWNER = "+MAINT_OWNER+", PLUSCISMTE = "+PLUSCISMTE+", TOTDOWNTIME = "+TOTDOWNTIME+", SADDRESSCODE = "+SADDRESSCODE+", SITEID = "+SITEID+", CHANGEDATE = "+CHANGEDATE+", MANUFACTURER = "+MANUFACTURER+", ITEMNUM = "+ITEMNUM+", ASSETID = "+ASSETID+", TOOLRATE = "+TOOLRATE+", CLASSSTRUCTUREID = "+CLASSSTRUCTUREID+", PRIORITY = "+PRIORITY+", PLUSCSUMEU = "+PLUSCSUMEU+", ROTSUSPACCT = "+ROTSUSPACCT+", REPLACECOST = "+REPLACECOST+", CALNUM = "+CALNUM+", TLOAMPARTITION = "+TLOAMPARTITION+", PLUSCOPRGETO = "+PLUSCOPRGETO+", LOCATION = "+LOCATION+", ASSETTAG = "+ASSETTAG+", AUTOWOGEN = "+AUTOWOGEN+", CONDITIONCODE = "+CONDITIONCODE+", DEFAULTREPFACSITEID = "+DEFAULTREPFACSITEID+", YTDCOST = "+YTDCOST+", ASSETTYPE = "+ASSETTYPE+", TEMPLATEID = "+TEMPLATEID+", ISLINEAR = "+ISLINEAR+", PLUSCISCONTAM = "+PLUSCISCONTAM+", MOVED = "+MOVED+", VENDOR = "+VENDOR+"]";
    }

    public AssetSpec getASSETSPEC() {
        return ASSETSPEC;
    }

    public void setASSETSPEC(AssetSpec ASSETSPEC) {
        this.ASSETSPEC = ASSETSPEC;
    }

    public List<WorkOrder> getWORKORDER() {
        return WORKORDER;
    }

    public void setWORKORDER(List<WorkOrder> WORKORDER) {
        this.WORKORDER = WORKORDER;
    }

    public DocLinks getDOCLINKS() {
        return DOCLINKS;
    }

    public void setDOCLINKS(DocLinks DOCLINKS) {
        this.DOCLINKS = DOCLINKS;
    }
}