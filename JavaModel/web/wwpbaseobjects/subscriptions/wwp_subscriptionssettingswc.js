gx.evt.autoSkip=!1;gx.define("wwpbaseobjects.subscriptions.wwp_subscriptionssettingswc",!0,function(n){var i,t,r;this.ServerClass="wwpbaseobjects.subscriptions.wwp_subscriptionssettingswc";this.PackageName="com.mujermorena";this.ServerFullClass="com.mujermorena.wwpbaseobjects.subscriptions.wwp_subscriptionssettingswc";this.setObjectType("web");this.setCmpContext(n);this.ReadonlyForm=!0;this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.AV32Pgmname=gx.fn.getControlValue("vPGMNAME");this.A33WWPEntityId=gx.fn.getIntegerValue("WWPENTITYID",gx.thousandSeparator);this.AV16WWPEntityId=gx.fn.getIntegerValue("vWWPENTITYID",gx.thousandSeparator);this.A156WWPNotificationDefinitionAllow=gx.fn.getControlValue("WWPNOTIFICATIONDEFINITIONALLOW");this.A35WWPNotificationDefinitionId=gx.fn.getIntegerValue("WWPNOTIFICATIONDEFINITIONID",gx.thousandSeparator);this.A154WWPNotificationDefinitionDescr=gx.fn.getControlValue("WWPNOTIFICATIONDEFINITIONDESCR");this.A32WWPUserExtendedId=gx.fn.getControlValue("WWPUSEREXTENDEDID");this.AV31Udparg1=gx.fn.getControlValue("vUDPARG1");this.A152WWPSubscriptionSubscribed=gx.fn.getControlValue("WWPSUBSCRIPTIONSUBSCRIBED");this.A149WWPSubscriptionRoleId=gx.fn.getControlValue("WWPSUBSCRIPTIONROLEID");this.A34WWPSubscriptionId=gx.fn.getIntegerValue("WWPSUBSCRIPTIONID",gx.thousandSeparator);this.A155WWPNotificationDefinitionAppli=gx.fn.getIntegerValue("WWPNOTIFICATIONDEFINITIONAPPLI",gx.thousandSeparator);this.A151WWPSubscriptionEntityRecordId=gx.fn.getControlValue("WWPSUBSCRIPTIONENTITYRECORDID");this.A153WWPSubscriptionEntityRecordDes=gx.fn.getControlValue("WWPSUBSCRIPTIONENTITYRECORDDES");this.AV12NotifShowOnlySubscribedEvents=gx.fn.getControlValue("vNOTIFSHOWONLYSUBSCRIBEDEVENTS");this.AV32Pgmname=gx.fn.getControlValue("vPGMNAME");this.A33WWPEntityId=gx.fn.getIntegerValue("WWPENTITYID",gx.thousandSeparator);this.AV16WWPEntityId=gx.fn.getIntegerValue("vWWPENTITYID",gx.thousandSeparator);this.A156WWPNotificationDefinitionAllow=gx.fn.getControlValue("WWPNOTIFICATIONDEFINITIONALLOW");this.A35WWPNotificationDefinitionId=gx.fn.getIntegerValue("WWPNOTIFICATIONDEFINITIONID",gx.thousandSeparator);this.A154WWPNotificationDefinitionDescr=gx.fn.getControlValue("WWPNOTIFICATIONDEFINITIONDESCR");this.A32WWPUserExtendedId=gx.fn.getControlValue("WWPUSEREXTENDEDID");this.AV31Udparg1=gx.fn.getControlValue("vUDPARG1");this.A152WWPSubscriptionSubscribed=gx.fn.getControlValue("WWPSUBSCRIPTIONSUBSCRIBED");this.A149WWPSubscriptionRoleId=gx.fn.getControlValue("WWPSUBSCRIPTIONROLEID");this.A34WWPSubscriptionId=gx.fn.getIntegerValue("WWPSUBSCRIPTIONID",gx.thousandSeparator);this.A155WWPNotificationDefinitionAppli=gx.fn.getIntegerValue("WWPNOTIFICATIONDEFINITIONAPPLI",gx.thousandSeparator);this.A151WWPSubscriptionEntityRecordId=gx.fn.getControlValue("WWPSUBSCRIPTIONENTITYRECORDID");this.A153WWPSubscriptionEntityRecordDes=gx.fn.getControlValue("WWPSUBSCRIPTIONENTITYRECORDDES");this.AV12NotifShowOnlySubscribedEvents=gx.fn.getControlValue("vNOTIFSHOWONLYSUBSCRIBEDEVENTS")};this.e113o2_client=function(){return this.executeServerEvent("TABLESUBSCRIPTIONITEM.CLICK",!0,arguments[0],!1,!0)};this.e153o2_client=function(){return this.executeServerEvent("ENTER",!0,arguments[0],!1,!1)};this.e163o2_client=function(){return this.executeServerEvent("CANCEL",!0,arguments[0],!1,!1)};this.GXValidFnc=[];i=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,11,15,16,17,18,19,20,21,22,23,24,25,26,27,30,31,33,34,36,37,39,40];this.GXLastCtrlId=40;this.GridContainer=new gx.grid.grid(this,2,"WbpLvl2",14,"Grid","Grid","GridContainer",this.CmpContext,this.IsMasterPage,"wwpbaseobjects.subscriptions.wwp_subscriptionssettingswc",[],!0,1,!1,!0,0,!0,!1,!1,"",0,"px",0,"px",gx.getMessage("GXM_newrow"),!0,!1,!0,null,null,!1,"",!0,[1,1,1,1],!1,0,!1,!1);t=this.GridContainer;t.startDiv(15,"Unnamedtablefsgrid","0px","0px");t.startDiv(16,"","0px","0px");t.startDiv(17,"","0px","0px");t.startDiv(18,"Tablesubscriptionitem","0px","0px");t.startDiv(19,"","0px","0px");t.startDiv(20,"","0px","0px");t.addLabel();t.addCheckBox("Includenotification",21,"vINCLUDENOTIFICATION","","","IncludeNotification","boolean","true","false",null,!0,!1,4,"chr","");t.endDiv();t.endDiv();t.startDiv(22,"","0px","0px");t.startDiv(23,"","0px","0px");t.addLabel();t.addMultipleLineEdit("Wwpnotificationdescription",24,"vWWPNOTIFICATIONDESCRIPTION","","WWPNotificationDescription","svchar",80,"chr",3,"row","200",200,"left",null,!0,!1,0,"");t.endDiv();t.endDiv();t.endDiv();t.endDiv();t.endDiv();t.startDiv(25,"","0px","0px");t.startDiv(26,"","0px","0px");t.startTable("Unnamedtablecontentfsgrid",27,"0px");t.startRow("","","","","","");t.startCell("","","","","","","","","","");t.startDiv(30,"","0px","0px");t.addLabel();t.addSingleLineEdit("Wwpnotificationdefinitionid",31,"vWWPNOTIFICATIONDEFINITIONID","","","WWPNotificationDefinitionId","int",10,"chr",10,10,"right",null,[],"Wwpnotificationdefinitionid","WWPNotificationDefinitionId",!0,0,!1,!1,"Attribute",0,"");t.endDiv();t.endCell();t.startCell("","","","","","","","","","");t.startDiv(33,"","0px","0px");t.addLabel();t.addSingleLineEdit("Wwpsubscriptionid",34,"vWWPSUBSCRIPTIONID","","","WWPSubscriptionId","int",10,"chr",10,10,"right",null,[],"Wwpsubscriptionid","WWPSubscriptionId",!0,0,!1,!1,"Attribute",0,"");t.endDiv();t.endCell();t.startCell("","","","","","","","","","");t.startDiv(36,"","0px","0px");t.addLabel();t.addMultipleLineEdit("Wwpsubscriptionentityrecordid",37,"vWWPSUBSCRIPTIONENTITYRECORDID","","WWPSubscriptionEntityRecordId","svchar",80,"chr",10,"row","2000",2e3,"left",null,!0,!1,0,"");t.endDiv();t.endCell();t.startCell("","","","","","","","","","");t.startDiv(39,"","0px","0px");t.addLabel();t.addMultipleLineEdit("Wwpsubscriptionentityrecorddescription",40,"vWWPSUBSCRIPTIONENTITYRECORDDESCRIPTION","","WWPSubscriptionEntityRecordDescription","svchar",80,"chr",3,"row","200",200,"left",null,!0,!1,0,"");t.endDiv();t.endCell();t.endRow();t.endTable();t.endDiv();t.endDiv();t.endDiv();this.GridContainer.emptyText=gx.getMessage("");this.setGrid(t);this.DVPANEL_UNNAMEDTABLE1Container=gx.uc.getNew(this,9,0,"BootstrapPanel",this.CmpContext+"DVPANEL_UNNAMEDTABLE1Container","Dvpanel_unnamedtable1","DVPANEL_UNNAMEDTABLE1");r=this.DVPANEL_UNNAMEDTABLE1Container;r.setProp("Class","Class","","char");r.setProp("Enabled","Enabled",!0,"boolean");r.setProp("Width","Width","100%","str");r.setProp("Height","Height","100","str");r.setProp("AutoWidth","Autowidth",!1,"bool");r.setProp("AutoHeight","Autoheight",!0,"bool");r.setProp("Cls","Cls","PanelNoHeader","str");r.setProp("ShowHeader","Showheader",!0,"bool");r.setProp("Title","Title","","str");r.setProp("Collapsible","Collapsible",!0,"bool");r.setProp("Collapsed","Collapsed",!1,"bool");r.setProp("ShowCollapseIcon","Showcollapseicon",!1,"bool");r.setProp("IconPosition","Iconposition","Right","str");r.setProp("AutoScroll","Autoscroll",!1,"bool");r.setProp("Visible","Visible",!0,"bool");r.setProp("Gx Control Type","Gxcontroltype","","int");r.setC2ShowFunction(function(n){n.show()});this.setUserControl(r);i[2]={id:2,fld:"",grid:0};i[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};i[4]={id:4,fld:"",grid:0};i[5]={id:5,fld:"",grid:0};i[6]={id:6,fld:"TABLEMAIN",grid:0};i[7]={id:7,fld:"",grid:0};i[8]={id:8,fld:"",grid:0};i[11]={id:11,fld:"UNNAMEDTABLE1",grid:0};i[15]={id:15,fld:"UNNAMEDTABLEFSGRID",grid:14};i[16]={id:16,fld:"",grid:14};i[17]={id:17,fld:"",grid:14};i[18]={id:18,fld:"TABLESUBSCRIPTIONITEM",grid:14,evt:"e113o2_client"};i[19]={id:19,fld:"",grid:14};i[20]={id:20,fld:"",grid:14};i[21]={id:21,lvl:2,type:"boolean",len:4,dec:0,sign:!1,ro:0,isacc:0,grid:14,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vINCLUDENOTIFICATION",fmt:0,gxz:"ZV11IncludeNotification",gxold:"OV11IncludeNotification",gxvar:"AV11IncludeNotification",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"checkbox",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.AV11IncludeNotification=gx.lang.booleanValue(n))},v2z:function(n){n!==undefined&&(gx.O.ZV11IncludeNotification=gx.lang.booleanValue(n))},v2c:function(n){gx.fn.setGridCheckBoxValue("vINCLUDENOTIFICATION",n||gx.fn.currentGridRowImpl(14),gx.O.AV11IncludeNotification,!0)},c2v:function(n){this.val(n)!==undefined&&(gx.O.AV11IncludeNotification=gx.lang.booleanValue(this.val(n)))},val:function(n){return gx.fn.getGridControlValue("vINCLUDENOTIFICATION",n||gx.fn.currentGridRowImpl(14))},nac:gx.falseFn,values:["true","false"]};i[22]={id:22,fld:"",grid:14};i[23]={id:23,fld:"",grid:14};i[24]={id:24,lvl:2,type:"svchar",len:200,dec:0,sign:!1,ro:0,isacc:0,multiline:!0,grid:14,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vWWPNOTIFICATIONDESCRIPTION",fmt:0,gxz:"ZV17WWPNotificationDescription",gxold:"OV17WWPNotificationDescription",gxvar:"AV17WWPNotificationDescription",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.AV17WWPNotificationDescription=n)},v2z:function(n){n!==undefined&&(gx.O.ZV17WWPNotificationDescription=n)},v2c:function(n){gx.fn.setGridControlValue("vWWPNOTIFICATIONDESCRIPTION",n||gx.fn.currentGridRowImpl(14),gx.O.AV17WWPNotificationDescription,0)},c2v:function(n){this.val(n)!==undefined&&(gx.O.AV17WWPNotificationDescription=this.val(n))},val:function(n){return gx.fn.getGridControlValue("vWWPNOTIFICATIONDESCRIPTION",n||gx.fn.currentGridRowImpl(14))},nac:gx.falseFn};i[25]={id:25,fld:"",grid:14};i[26]={id:26,fld:"",grid:14};i[27]={id:27,fld:"UNNAMEDTABLECONTENTFSGRID",grid:14};i[30]={id:30,fld:"",grid:14};i[31]={id:31,lvl:2,type:"int",len:10,dec:0,sign:!1,pic:"ZZZZZZZZZ9",ro:0,isacc:0,grid:14,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vWWPNOTIFICATIONDEFINITIONID",fmt:0,gxz:"ZV5WWPNotificationDefinitionId",gxold:"OV5WWPNotificationDefinitionId",gxvar:"AV5WWPNotificationDefinitionId",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.AV5WWPNotificationDefinitionId=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.ZV5WWPNotificationDefinitionId=gx.num.intval(n))},v2c:function(n){gx.fn.setGridControlValue("vWWPNOTIFICATIONDEFINITIONID",n||gx.fn.currentGridRowImpl(14),gx.O.AV5WWPNotificationDefinitionId,0)},c2v:function(n){this.val(n)!==undefined&&(gx.O.AV5WWPNotificationDefinitionId=gx.num.intval(this.val(n)))},val:function(n){return gx.fn.getGridIntegerValue("vWWPNOTIFICATIONDEFINITIONID",n||gx.fn.currentGridRowImpl(14),gx.thousandSeparator)},nac:gx.falseFn};i[33]={id:33,fld:"",grid:14};i[34]={id:34,lvl:2,type:"int",len:10,dec:0,sign:!1,pic:"ZZZZZZZZZ9",ro:0,isacc:0,grid:14,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vWWPSUBSCRIPTIONID",fmt:0,gxz:"ZV7WWPSubscriptionId",gxold:"OV7WWPSubscriptionId",gxvar:"AV7WWPSubscriptionId",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.AV7WWPSubscriptionId=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.ZV7WWPSubscriptionId=gx.num.intval(n))},v2c:function(n){gx.fn.setGridControlValue("vWWPSUBSCRIPTIONID",n||gx.fn.currentGridRowImpl(14),gx.O.AV7WWPSubscriptionId,0)},c2v:function(n){this.val(n)!==undefined&&(gx.O.AV7WWPSubscriptionId=gx.num.intval(this.val(n)))},val:function(n){return gx.fn.getGridIntegerValue("vWWPSUBSCRIPTIONID",n||gx.fn.currentGridRowImpl(14),gx.thousandSeparator)},nac:gx.falseFn};i[36]={id:36,fld:"",grid:14};i[37]={id:37,lvl:2,type:"svchar",len:2e3,dec:0,sign:!1,ro:0,isacc:0,multiline:!0,grid:14,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vWWPSUBSCRIPTIONENTITYRECORDID",fmt:0,gxz:"ZV19WWPSubscriptionEntityRecordId",gxold:"OV19WWPSubscriptionEntityRecordId",gxvar:"AV19WWPSubscriptionEntityRecordId",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.AV19WWPSubscriptionEntityRecordId=n)},v2z:function(n){n!==undefined&&(gx.O.ZV19WWPSubscriptionEntityRecordId=n)},v2c:function(n){gx.fn.setGridControlValue("vWWPSUBSCRIPTIONENTITYRECORDID",n||gx.fn.currentGridRowImpl(14),gx.O.AV19WWPSubscriptionEntityRecordId,0)},c2v:function(n){this.val(n)!==undefined&&(gx.O.AV19WWPSubscriptionEntityRecordId=this.val(n))},val:function(n){return gx.fn.getGridControlValue("vWWPSUBSCRIPTIONENTITYRECORDID",n||gx.fn.currentGridRowImpl(14))},nac:gx.falseFn};i[39]={id:39,fld:"",grid:14};i[40]={id:40,lvl:2,type:"svchar",len:200,dec:0,sign:!1,ro:0,isacc:0,multiline:!0,grid:14,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vWWPSUBSCRIPTIONENTITYRECORDDESCRIPTION",fmt:0,gxz:"ZV6WWPSubscriptionEntityRecordDescription",gxold:"OV6WWPSubscriptionEntityRecordDescription",gxvar:"AV6WWPSubscriptionEntityRecordDescription",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.AV6WWPSubscriptionEntityRecordDescription=n)},v2z:function(n){n!==undefined&&(gx.O.ZV6WWPSubscriptionEntityRecordDescription=n)},v2c:function(n){gx.fn.setGridControlValue("vWWPSUBSCRIPTIONENTITYRECORDDESCRIPTION",n||gx.fn.currentGridRowImpl(14),gx.O.AV6WWPSubscriptionEntityRecordDescription,0)},c2v:function(n){this.val(n)!==undefined&&(gx.O.AV6WWPSubscriptionEntityRecordDescription=this.val(n))},val:function(n){return gx.fn.getGridControlValue("vWWPSUBSCRIPTIONENTITYRECORDDESCRIPTION",n||gx.fn.currentGridRowImpl(14))},nac:gx.falseFn};this.ZV11IncludeNotification=!1;this.OV11IncludeNotification=!1;this.ZV17WWPNotificationDescription="";this.OV17WWPNotificationDescription="";this.ZV5WWPNotificationDefinitionId=0;this.OV5WWPNotificationDefinitionId=0;this.ZV7WWPSubscriptionId=0;this.OV7WWPSubscriptionId=0;this.ZV19WWPSubscriptionEntityRecordId="";this.OV19WWPSubscriptionEntityRecordId="";this.ZV6WWPSubscriptionEntityRecordDescription="";this.OV6WWPSubscriptionEntityRecordDescription="";this.AV16WWPEntityId=0;this.AV12NotifShowOnlySubscribedEvents=!1;this.AV11IncludeNotification=!1;this.AV17WWPNotificationDescription="";this.AV5WWPNotificationDefinitionId=0;this.AV7WWPSubscriptionId=0;this.AV19WWPSubscriptionEntityRecordId="";this.AV6WWPSubscriptionEntityRecordDescription="";this.A35WWPNotificationDefinitionId=0;this.A155WWPNotificationDefinitionAppli=0;this.A156WWPNotificationDefinitionAllow=!1;this.A33WWPEntityId=0;this.A154WWPNotificationDefinitionDescr="";this.A149WWPSubscriptionRoleId="";this.A152WWPSubscriptionSubscribed=!1;this.A32WWPUserExtendedId="";this.A34WWPSubscriptionId=0;this.A151WWPSubscriptionEntityRecordId="";this.A153WWPSubscriptionEntityRecordDes="";this.AV32Pgmname="";this.AV31Udparg1="";this.Events={e113o2_client:["TABLESUBSCRIPTIONITEM.CLICK",!0],e153o2_client:["ENTER",!0],e163o2_client:["CANCEL",!0]};this.EvtParms.REFRESH=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{av:'gx.fn.getCtrlProperty("vWWPNOTIFICATIONDEFINITIONID","Visible")',ctrl:"vWWPNOTIFICATIONDEFINITIONID",prop:"Visible"},{av:'gx.fn.getCtrlProperty("vWWPSUBSCRIPTIONID","Visible")',ctrl:"vWWPSUBSCRIPTIONID",prop:"Visible"},{av:'gx.fn.getCtrlProperty("vWWPSUBSCRIPTIONENTITYRECORDID","Visible")',ctrl:"vWWPSUBSCRIPTIONENTITYRECORDID",prop:"Visible"},{av:'gx.fn.getCtrlProperty("vWWPSUBSCRIPTIONENTITYRECORDDESCRIPTION","Visible")',ctrl:"vWWPSUBSCRIPTIONENTITYRECORDDESCRIPTION",prop:"Visible"},{av:"A33WWPEntityId",fld:"WWPENTITYID",pic:"ZZZZZZZZZ9"},{av:"AV16WWPEntityId",fld:"vWWPENTITYID",pic:"ZZZZZZZZZ9"},{av:"A156WWPNotificationDefinitionAllow",fld:"WWPNOTIFICATIONDEFINITIONALLOW",pic:""},{av:"A35WWPNotificationDefinitionId",fld:"WWPNOTIFICATIONDEFINITIONID",pic:"ZZZZZZZZZ9"},{av:"A154WWPNotificationDefinitionDescr",fld:"WWPNOTIFICATIONDEFINITIONDESCR",pic:""},{av:"A32WWPUserExtendedId",fld:"WWPUSEREXTENDEDID",pic:""},{av:"A152WWPSubscriptionSubscribed",fld:"WWPSUBSCRIPTIONSUBSCRIBED",pic:""},{av:"A149WWPSubscriptionRoleId",fld:"WWPSUBSCRIPTIONROLEID",pic:""},{av:"A34WWPSubscriptionId",fld:"WWPSUBSCRIPTIONID",pic:"ZZZZZZZZZ9"},{av:"A155WWPNotificationDefinitionAppli",fld:"WWPNOTIFICATIONDEFINITIONAPPLI",pic:"9"},{av:"A151WWPSubscriptionEntityRecordId",fld:"WWPSUBSCRIPTIONENTITYRECORDID",pic:""},{av:"A153WWPSubscriptionEntityRecordDes",fld:"WWPSUBSCRIPTIONENTITYRECORDDES",pic:""},{av:"AV12NotifShowOnlySubscribedEvents",fld:"vNOTIFSHOWONLYSUBSCRIBEDEVENTS",pic:""},{av:"sPrefix"},{ctrl:"GRID",prop:"Rows"},{av:"AV32Pgmname",fld:"vPGMNAME",pic:"",hsh:!0},{av:"AV31Udparg1",fld:"vUDPARG1",pic:"",hsh:!0}],[]];this.EvtParms["GRID.LOAD"]=[[{av:"A33WWPEntityId",fld:"WWPENTITYID",pic:"ZZZZZZZZZ9"},{av:"AV16WWPEntityId",fld:"vWWPENTITYID",pic:"ZZZZZZZZZ9"},{av:"A156WWPNotificationDefinitionAllow",fld:"WWPNOTIFICATIONDEFINITIONALLOW",pic:""},{av:"A35WWPNotificationDefinitionId",fld:"WWPNOTIFICATIONDEFINITIONID",pic:"ZZZZZZZZZ9"},{av:"A154WWPNotificationDefinitionDescr",fld:"WWPNOTIFICATIONDEFINITIONDESCR",pic:""},{av:"A32WWPUserExtendedId",fld:"WWPUSEREXTENDEDID",pic:""},{av:"AV31Udparg1",fld:"vUDPARG1",pic:"",hsh:!0},{av:"A152WWPSubscriptionSubscribed",fld:"WWPSUBSCRIPTIONSUBSCRIBED",pic:""},{av:"A149WWPSubscriptionRoleId",fld:"WWPSUBSCRIPTIONROLEID",pic:""},{av:"A34WWPSubscriptionId",fld:"WWPSUBSCRIPTIONID",pic:"ZZZZZZZZZ9"},{av:"A155WWPNotificationDefinitionAppli",fld:"WWPNOTIFICATIONDEFINITIONAPPLI",pic:"9"},{av:"A151WWPSubscriptionEntityRecordId",fld:"WWPSUBSCRIPTIONENTITYRECORDID",pic:""},{av:"A153WWPSubscriptionEntityRecordDes",fld:"WWPSUBSCRIPTIONENTITYRECORDDES",pic:""},{av:"AV12NotifShowOnlySubscribedEvents",fld:"vNOTIFSHOWONLYSUBSCRIBEDEVENTS",pic:""},{ctrl:"GRID",prop:"Rows"}],[{av:"AV5WWPNotificationDefinitionId",fld:"vWWPNOTIFICATIONDEFINITIONID",pic:"ZZZZZZZZZ9"},{av:"AV17WWPNotificationDescription",fld:"vWWPNOTIFICATIONDESCRIPTION",pic:""},{av:"AV11IncludeNotification",fld:"vINCLUDENOTIFICATION",pic:""},{av:"AV7WWPSubscriptionId",fld:"vWWPSUBSCRIPTIONID",pic:"ZZZZZZZZZ9"},{av:"AV6WWPSubscriptionEntityRecordDescription",fld:"vWWPSUBSCRIPTIONENTITYRECORDDESCRIPTION",pic:""},{av:"AV19WWPSubscriptionEntityRecordId",fld:"vWWPSUBSCRIPTIONENTITYRECORDID",pic:""}]];this.EvtParms["TABLESUBSCRIPTIONITEM.CLICK"]=[[{av:"AV11IncludeNotification",fld:"vINCLUDENOTIFICATION",grid:14,pic:""},{av:"GRID_nFirstRecordOnPage"},{av:"nRC_GXsfl_14",ctrl:"GRID",grid:14,prop:"GridRC",grid:14},{av:"AV7WWPSubscriptionId",fld:"vWWPSUBSCRIPTIONID",grid:14,pic:"ZZZZZZZZZ9"},{av:"AV5WWPNotificationDefinitionId",fld:"vWWPNOTIFICATIONDEFINITIONID",grid:14,pic:"ZZZZZZZZZ9"},{av:"AV19WWPSubscriptionEntityRecordId",fld:"vWWPSUBSCRIPTIONENTITYRECORDID",grid:14,pic:""},{av:"AV6WWPSubscriptionEntityRecordDescription",fld:"vWWPSUBSCRIPTIONENTITYRECORDDESCRIPTION",grid:14,pic:""}],[{av:"AV11IncludeNotification",fld:"vINCLUDENOTIFICATION",pic:""},{av:"AV7WWPSubscriptionId",fld:"vWWPSUBSCRIPTIONID",pic:"ZZZZZZZZZ9"}]];this.EvtParms.ENTER=[[],[]];this.EvtParms.GRID_FIRSTPAGE=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{av:'gx.fn.getCtrlProperty("vWWPNOTIFICATIONDEFINITIONID","Visible")',ctrl:"vWWPNOTIFICATIONDEFINITIONID",prop:"Visible"},{av:'gx.fn.getCtrlProperty("vWWPSUBSCRIPTIONID","Visible")',ctrl:"vWWPSUBSCRIPTIONID",prop:"Visible"},{av:'gx.fn.getCtrlProperty("vWWPSUBSCRIPTIONENTITYRECORDID","Visible")',ctrl:"vWWPSUBSCRIPTIONENTITYRECORDID",prop:"Visible"},{av:'gx.fn.getCtrlProperty("vWWPSUBSCRIPTIONENTITYRECORDDESCRIPTION","Visible")',ctrl:"vWWPSUBSCRIPTIONENTITYRECORDDESCRIPTION",prop:"Visible"},{av:"A33WWPEntityId",fld:"WWPENTITYID",pic:"ZZZZZZZZZ9"},{av:"AV16WWPEntityId",fld:"vWWPENTITYID",pic:"ZZZZZZZZZ9"},{av:"A156WWPNotificationDefinitionAllow",fld:"WWPNOTIFICATIONDEFINITIONALLOW",pic:""},{av:"A35WWPNotificationDefinitionId",fld:"WWPNOTIFICATIONDEFINITIONID",pic:"ZZZZZZZZZ9"},{av:"A154WWPNotificationDefinitionDescr",fld:"WWPNOTIFICATIONDEFINITIONDESCR",pic:""},{av:"A32WWPUserExtendedId",fld:"WWPUSEREXTENDEDID",pic:""},{av:"AV31Udparg1",fld:"vUDPARG1",pic:"",hsh:!0},{av:"A152WWPSubscriptionSubscribed",fld:"WWPSUBSCRIPTIONSUBSCRIBED",pic:""},{av:"A149WWPSubscriptionRoleId",fld:"WWPSUBSCRIPTIONROLEID",pic:""},{av:"A34WWPSubscriptionId",fld:"WWPSUBSCRIPTIONID",pic:"ZZZZZZZZZ9"},{av:"A155WWPNotificationDefinitionAppli",fld:"WWPNOTIFICATIONDEFINITIONAPPLI",pic:"9"},{av:"A151WWPSubscriptionEntityRecordId",fld:"WWPSUBSCRIPTIONENTITYRECORDID",pic:""},{av:"A153WWPSubscriptionEntityRecordDes",fld:"WWPSUBSCRIPTIONENTITYRECORDDES",pic:""},{av:"AV12NotifShowOnlySubscribedEvents",fld:"vNOTIFSHOWONLYSUBSCRIBEDEVENTS",pic:""},{av:"sPrefix"},{av:"AV32Pgmname",fld:"vPGMNAME",pic:"",hsh:!0},{ctrl:"GRID",prop:"Rows"}],[]];this.EvtParms.GRID_PREVPAGE=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{av:'gx.fn.getCtrlProperty("vWWPNOTIFICATIONDEFINITIONID","Visible")',ctrl:"vWWPNOTIFICATIONDEFINITIONID",prop:"Visible"},{av:'gx.fn.getCtrlProperty("vWWPSUBSCRIPTIONID","Visible")',ctrl:"vWWPSUBSCRIPTIONID",prop:"Visible"},{av:'gx.fn.getCtrlProperty("vWWPSUBSCRIPTIONENTITYRECORDID","Visible")',ctrl:"vWWPSUBSCRIPTIONENTITYRECORDID",prop:"Visible"},{av:'gx.fn.getCtrlProperty("vWWPSUBSCRIPTIONENTITYRECORDDESCRIPTION","Visible")',ctrl:"vWWPSUBSCRIPTIONENTITYRECORDDESCRIPTION",prop:"Visible"},{av:"A33WWPEntityId",fld:"WWPENTITYID",pic:"ZZZZZZZZZ9"},{av:"AV16WWPEntityId",fld:"vWWPENTITYID",pic:"ZZZZZZZZZ9"},{av:"A156WWPNotificationDefinitionAllow",fld:"WWPNOTIFICATIONDEFINITIONALLOW",pic:""},{av:"A35WWPNotificationDefinitionId",fld:"WWPNOTIFICATIONDEFINITIONID",pic:"ZZZZZZZZZ9"},{av:"A154WWPNotificationDefinitionDescr",fld:"WWPNOTIFICATIONDEFINITIONDESCR",pic:""},{av:"A32WWPUserExtendedId",fld:"WWPUSEREXTENDEDID",pic:""},{av:"AV31Udparg1",fld:"vUDPARG1",pic:"",hsh:!0},{av:"A152WWPSubscriptionSubscribed",fld:"WWPSUBSCRIPTIONSUBSCRIBED",pic:""},{av:"A149WWPSubscriptionRoleId",fld:"WWPSUBSCRIPTIONROLEID",pic:""},{av:"A34WWPSubscriptionId",fld:"WWPSUBSCRIPTIONID",pic:"ZZZZZZZZZ9"},{av:"A155WWPNotificationDefinitionAppli",fld:"WWPNOTIFICATIONDEFINITIONAPPLI",pic:"9"},{av:"A151WWPSubscriptionEntityRecordId",fld:"WWPSUBSCRIPTIONENTITYRECORDID",pic:""},{av:"A153WWPSubscriptionEntityRecordDes",fld:"WWPSUBSCRIPTIONENTITYRECORDDES",pic:""},{av:"AV12NotifShowOnlySubscribedEvents",fld:"vNOTIFSHOWONLYSUBSCRIBEDEVENTS",pic:""},{av:"sPrefix"},{av:"AV32Pgmname",fld:"vPGMNAME",pic:"",hsh:!0},{ctrl:"GRID",prop:"Rows"}],[]];this.EvtParms.GRID_NEXTPAGE=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{av:'gx.fn.getCtrlProperty("vWWPNOTIFICATIONDEFINITIONID","Visible")',ctrl:"vWWPNOTIFICATIONDEFINITIONID",prop:"Visible"},{av:'gx.fn.getCtrlProperty("vWWPSUBSCRIPTIONID","Visible")',ctrl:"vWWPSUBSCRIPTIONID",prop:"Visible"},{av:'gx.fn.getCtrlProperty("vWWPSUBSCRIPTIONENTITYRECORDID","Visible")',ctrl:"vWWPSUBSCRIPTIONENTITYRECORDID",prop:"Visible"},{av:'gx.fn.getCtrlProperty("vWWPSUBSCRIPTIONENTITYRECORDDESCRIPTION","Visible")',ctrl:"vWWPSUBSCRIPTIONENTITYRECORDDESCRIPTION",prop:"Visible"},{av:"A33WWPEntityId",fld:"WWPENTITYID",pic:"ZZZZZZZZZ9"},{av:"AV16WWPEntityId",fld:"vWWPENTITYID",pic:"ZZZZZZZZZ9"},{av:"A156WWPNotificationDefinitionAllow",fld:"WWPNOTIFICATIONDEFINITIONALLOW",pic:""},{av:"A35WWPNotificationDefinitionId",fld:"WWPNOTIFICATIONDEFINITIONID",pic:"ZZZZZZZZZ9"},{av:"A154WWPNotificationDefinitionDescr",fld:"WWPNOTIFICATIONDEFINITIONDESCR",pic:""},{av:"A32WWPUserExtendedId",fld:"WWPUSEREXTENDEDID",pic:""},{av:"AV31Udparg1",fld:"vUDPARG1",pic:"",hsh:!0},{av:"A152WWPSubscriptionSubscribed",fld:"WWPSUBSCRIPTIONSUBSCRIBED",pic:""},{av:"A149WWPSubscriptionRoleId",fld:"WWPSUBSCRIPTIONROLEID",pic:""},{av:"A34WWPSubscriptionId",fld:"WWPSUBSCRIPTIONID",pic:"ZZZZZZZZZ9"},{av:"A155WWPNotificationDefinitionAppli",fld:"WWPNOTIFICATIONDEFINITIONAPPLI",pic:"9"},{av:"A151WWPSubscriptionEntityRecordId",fld:"WWPSUBSCRIPTIONENTITYRECORDID",pic:""},{av:"A153WWPSubscriptionEntityRecordDes",fld:"WWPSUBSCRIPTIONENTITYRECORDDES",pic:""},{av:"AV12NotifShowOnlySubscribedEvents",fld:"vNOTIFSHOWONLYSUBSCRIBEDEVENTS",pic:""},{av:"sPrefix"},{av:"AV32Pgmname",fld:"vPGMNAME",pic:"",hsh:!0},{ctrl:"GRID",prop:"Rows"}],[]];this.EvtParms.GRID_LASTPAGE=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{av:'gx.fn.getCtrlProperty("vWWPNOTIFICATIONDEFINITIONID","Visible")',ctrl:"vWWPNOTIFICATIONDEFINITIONID",prop:"Visible"},{av:'gx.fn.getCtrlProperty("vWWPSUBSCRIPTIONID","Visible")',ctrl:"vWWPSUBSCRIPTIONID",prop:"Visible"},{av:'gx.fn.getCtrlProperty("vWWPSUBSCRIPTIONENTITYRECORDID","Visible")',ctrl:"vWWPSUBSCRIPTIONENTITYRECORDID",prop:"Visible"},{av:'gx.fn.getCtrlProperty("vWWPSUBSCRIPTIONENTITYRECORDDESCRIPTION","Visible")',ctrl:"vWWPSUBSCRIPTIONENTITYRECORDDESCRIPTION",prop:"Visible"},{av:"A33WWPEntityId",fld:"WWPENTITYID",pic:"ZZZZZZZZZ9"},{av:"AV16WWPEntityId",fld:"vWWPENTITYID",pic:"ZZZZZZZZZ9"},{av:"A156WWPNotificationDefinitionAllow",fld:"WWPNOTIFICATIONDEFINITIONALLOW",pic:""},{av:"A35WWPNotificationDefinitionId",fld:"WWPNOTIFICATIONDEFINITIONID",pic:"ZZZZZZZZZ9"},{av:"A154WWPNotificationDefinitionDescr",fld:"WWPNOTIFICATIONDEFINITIONDESCR",pic:""},{av:"A32WWPUserExtendedId",fld:"WWPUSEREXTENDEDID",pic:""},{av:"AV31Udparg1",fld:"vUDPARG1",pic:"",hsh:!0},{av:"A152WWPSubscriptionSubscribed",fld:"WWPSUBSCRIPTIONSUBSCRIBED",pic:""},{av:"A149WWPSubscriptionRoleId",fld:"WWPSUBSCRIPTIONROLEID",pic:""},{av:"A34WWPSubscriptionId",fld:"WWPSUBSCRIPTIONID",pic:"ZZZZZZZZZ9"},{av:"A155WWPNotificationDefinitionAppli",fld:"WWPNOTIFICATIONDEFINITIONAPPLI",pic:"9"},{av:"A151WWPSubscriptionEntityRecordId",fld:"WWPSUBSCRIPTIONENTITYRECORDID",pic:""},{av:"A153WWPSubscriptionEntityRecordDes",fld:"WWPSUBSCRIPTIONENTITYRECORDDES",pic:""},{av:"AV12NotifShowOnlySubscribedEvents",fld:"vNOTIFSHOWONLYSUBSCRIBEDEVENTS",pic:""},{av:"sPrefix"},{av:"AV32Pgmname",fld:"vPGMNAME",pic:"",hsh:!0},{ctrl:"GRID",prop:"Rows"}],[]];this.setVCMap("AV32Pgmname","vPGMNAME",0,"char",129,0);this.setVCMap("A33WWPEntityId","WWPENTITYID",0,"int",10,0);this.setVCMap("AV16WWPEntityId","vWWPENTITYID",0,"int",10,0);this.setVCMap("A156WWPNotificationDefinitionAllow","WWPNOTIFICATIONDEFINITIONALLOW",0,"boolean",4,0);this.setVCMap("A35WWPNotificationDefinitionId","WWPNOTIFICATIONDEFINITIONID",0,"int",10,0);this.setVCMap("A154WWPNotificationDefinitionDescr","WWPNOTIFICATIONDEFINITIONDESCR",0,"svchar",200,0);this.setVCMap("A32WWPUserExtendedId","WWPUSEREXTENDEDID",0,"char",40,0);this.setVCMap("AV31Udparg1","vUDPARG1",0,"char",40,0);this.setVCMap("A152WWPSubscriptionSubscribed","WWPSUBSCRIPTIONSUBSCRIBED",0,"boolean",4,0);this.setVCMap("A149WWPSubscriptionRoleId","WWPSUBSCRIPTIONROLEID",0,"char",40,0);this.setVCMap("A34WWPSubscriptionId","WWPSUBSCRIPTIONID",0,"int",10,0);this.setVCMap("A155WWPNotificationDefinitionAppli","WWPNOTIFICATIONDEFINITIONAPPLI",0,"int",1,0);this.setVCMap("A151WWPSubscriptionEntityRecordId","WWPSUBSCRIPTIONENTITYRECORDID",0,"svchar",2e3,0);this.setVCMap("A153WWPSubscriptionEntityRecordDes","WWPSUBSCRIPTIONENTITYRECORDDES",0,"svchar",200,0);this.setVCMap("AV12NotifShowOnlySubscribedEvents","vNOTIFSHOWONLYSUBSCRIBEDEVENTS",0,"boolean",4,0);this.setVCMap("AV32Pgmname","vPGMNAME",0,"char",129,0);this.setVCMap("A33WWPEntityId","WWPENTITYID",0,"int",10,0);this.setVCMap("AV16WWPEntityId","vWWPENTITYID",0,"int",10,0);this.setVCMap("A156WWPNotificationDefinitionAllow","WWPNOTIFICATIONDEFINITIONALLOW",0,"boolean",4,0);this.setVCMap("A35WWPNotificationDefinitionId","WWPNOTIFICATIONDEFINITIONID",0,"int",10,0);this.setVCMap("A154WWPNotificationDefinitionDescr","WWPNOTIFICATIONDEFINITIONDESCR",0,"svchar",200,0);this.setVCMap("A32WWPUserExtendedId","WWPUSEREXTENDEDID",0,"char",40,0);this.setVCMap("AV31Udparg1","vUDPARG1",0,"char",40,0);this.setVCMap("A152WWPSubscriptionSubscribed","WWPSUBSCRIPTIONSUBSCRIBED",0,"boolean",4,0);this.setVCMap("A149WWPSubscriptionRoleId","WWPSUBSCRIPTIONROLEID",0,"char",40,0);this.setVCMap("A34WWPSubscriptionId","WWPSUBSCRIPTIONID",0,"int",10,0);this.setVCMap("A155WWPNotificationDefinitionAppli","WWPNOTIFICATIONDEFINITIONAPPLI",0,"int",1,0);this.setVCMap("A151WWPSubscriptionEntityRecordId","WWPSUBSCRIPTIONENTITYRECORDID",0,"svchar",2e3,0);this.setVCMap("A153WWPSubscriptionEntityRecordDes","WWPSUBSCRIPTIONENTITYRECORDDES",0,"svchar",200,0);this.setVCMap("AV12NotifShowOnlySubscribedEvents","vNOTIFSHOWONLYSUBSCRIBEDEVENTS",0,"boolean",4,0);this.setVCMap("AV32Pgmname","vPGMNAME",0,"char",129,0);this.setVCMap("A33WWPEntityId","WWPENTITYID",0,"int",10,0);this.setVCMap("AV16WWPEntityId","vWWPENTITYID",0,"int",10,0);this.setVCMap("A156WWPNotificationDefinitionAllow","WWPNOTIFICATIONDEFINITIONALLOW",0,"boolean",4,0);this.setVCMap("A35WWPNotificationDefinitionId","WWPNOTIFICATIONDEFINITIONID",0,"int",10,0);this.setVCMap("A154WWPNotificationDefinitionDescr","WWPNOTIFICATIONDEFINITIONDESCR",0,"svchar",200,0);this.setVCMap("A32WWPUserExtendedId","WWPUSEREXTENDEDID",0,"char",40,0);this.setVCMap("AV31Udparg1","vUDPARG1",0,"char",40,0);this.setVCMap("A152WWPSubscriptionSubscribed","WWPSUBSCRIPTIONSUBSCRIBED",0,"boolean",4,0);this.setVCMap("A149WWPSubscriptionRoleId","WWPSUBSCRIPTIONROLEID",0,"char",40,0);this.setVCMap("A34WWPSubscriptionId","WWPSUBSCRIPTIONID",0,"int",10,0);this.setVCMap("A155WWPNotificationDefinitionAppli","WWPNOTIFICATIONDEFINITIONAPPLI",0,"int",1,0);this.setVCMap("A151WWPSubscriptionEntityRecordId","WWPSUBSCRIPTIONENTITYRECORDID",0,"svchar",2e3,0);this.setVCMap("A153WWPSubscriptionEntityRecordDes","WWPSUBSCRIPTIONENTITYRECORDDES",0,"svchar",200,0);this.setVCMap("AV12NotifShowOnlySubscribedEvents","vNOTIFSHOWONLYSUBSCRIBEDEVENTS",0,"boolean",4,0);t.addRefreshingParm({rfrProp:"Rows",gxGrid:"Grid"});t.addRefreshingVar({rfrVar:"AV32Pgmname"});t.addRefreshingVar({rfrVar:"AV5WWPNotificationDefinitionId",rfrProp:"Visible",gxAttId:"Wwpnotificationdefinitionid"});t.addRefreshingVar({rfrVar:"AV7WWPSubscriptionId",rfrProp:"Visible",gxAttId:"Wwpsubscriptionid"});t.addRefreshingVar({rfrVar:"AV19WWPSubscriptionEntityRecordId",rfrProp:"Visible",gxAttId:"Wwpsubscriptionentityrecordid"});t.addRefreshingVar({rfrVar:"AV6WWPSubscriptionEntityRecordDescription",rfrProp:"Visible",gxAttId:"Wwpsubscriptionentityrecorddescription"});t.addRefreshingVar({rfrVar:"A33WWPEntityId"});t.addRefreshingVar({rfrVar:"AV16WWPEntityId"});t.addRefreshingVar({rfrVar:"A156WWPNotificationDefinitionAllow"});t.addRefreshingVar({rfrVar:"A35WWPNotificationDefinitionId"});t.addRefreshingVar({rfrVar:"A154WWPNotificationDefinitionDescr"});t.addRefreshingVar({rfrVar:"A32WWPUserExtendedId"});t.addRefreshingVar({rfrVar:"AV31Udparg1"});t.addRefreshingVar({rfrVar:"A152WWPSubscriptionSubscribed"});t.addRefreshingVar({rfrVar:"A149WWPSubscriptionRoleId"});t.addRefreshingVar({rfrVar:"A34WWPSubscriptionId"});t.addRefreshingVar({rfrVar:"A155WWPNotificationDefinitionAppli"});t.addRefreshingVar({rfrVar:"A151WWPSubscriptionEntityRecordId"});t.addRefreshingVar({rfrVar:"A153WWPSubscriptionEntityRecordDes"});t.addRefreshingVar({rfrVar:"AV12NotifShowOnlySubscribedEvents"});t.addRefreshingParm({rfrVar:"AV32Pgmname"});t.addRefreshingParm({rfrVar:"AV5WWPNotificationDefinitionId",rfrProp:"Visible",gxAttId:"Wwpnotificationdefinitionid"});t.addRefreshingParm({rfrVar:"AV7WWPSubscriptionId",rfrProp:"Visible",gxAttId:"Wwpsubscriptionid"});t.addRefreshingParm({rfrVar:"AV19WWPSubscriptionEntityRecordId",rfrProp:"Visible",gxAttId:"Wwpsubscriptionentityrecordid"});t.addRefreshingParm({rfrVar:"AV6WWPSubscriptionEntityRecordDescription",rfrProp:"Visible",gxAttId:"Wwpsubscriptionentityrecorddescription"});t.addRefreshingParm({rfrVar:"A33WWPEntityId"});t.addRefreshingParm({rfrVar:"AV16WWPEntityId"});t.addRefreshingParm({rfrVar:"A156WWPNotificationDefinitionAllow"});t.addRefreshingParm({rfrVar:"A35WWPNotificationDefinitionId"});t.addRefreshingParm({rfrVar:"A154WWPNotificationDefinitionDescr"});t.addRefreshingParm({rfrVar:"A32WWPUserExtendedId"});t.addRefreshingParm({rfrVar:"AV31Udparg1"});t.addRefreshingParm({rfrVar:"A152WWPSubscriptionSubscribed"});t.addRefreshingParm({rfrVar:"A149WWPSubscriptionRoleId"});t.addRefreshingParm({rfrVar:"A34WWPSubscriptionId"});t.addRefreshingParm({rfrVar:"A155WWPNotificationDefinitionAppli"});t.addRefreshingParm({rfrVar:"A151WWPSubscriptionEntityRecordId"});t.addRefreshingParm({rfrVar:"A153WWPSubscriptionEntityRecordDes"});t.addRefreshingParm({rfrVar:"AV12NotifShowOnlySubscribedEvents"});this.Initialize()})