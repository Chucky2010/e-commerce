gx.evt.autoSkip=!1;gx.define("tipopersonaview",!1,function(){var n,t;this.ServerClass="tipopersonaview";this.PackageName="com.mujermorena";this.ServerFullClass="com.mujermorena.tipopersonaview";this.setObjectType("web");this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.AV11LoadAllTabs=gx.fn.getControlValue("vLOADALLTABS");this.AV12SelectedTabCode=gx.fn.getControlValue("vSELECTEDTABCODE");this.AV10TipoPersonaId=gx.fn.getIntegerValue("vTIPOPERSONAID",gx.thousandSeparator);this.AV8TabCode=gx.fn.getControlValue("vTABCODE");this.AV10TipoPersonaId=gx.fn.getIntegerValue("vTIPOPERSONAID",gx.thousandSeparator);this.AV11LoadAllTabs=gx.fn.getControlValue("vLOADALLTABS");this.AV12SelectedTabCode=gx.fn.getControlValue("vSELECTEDTABCODE")};this.s112_client=function(){(this.AV11LoadAllTabs||gx.text.compare(this.AV12SelectedTabCode,"")==0||gx.text.compare(this.AV12SelectedTabCode,"General")==0)&&this.createWebComponent("Generalwc","TipoPersonaGeneral",[this.AV10TipoPersonaId])};this.e133t1_client=function(){return this.clearMessages(),this.AV12SelectedTabCode=this.TABSContainer.ActivePageControlName,this.AV11LoadAllTabs=!1,this.s112_client(),this.refreshOutputs([{av:"AV12SelectedTabCode",fld:"vSELECTEDTABCODE",pic:""},{av:"AV11LoadAllTabs",fld:"vLOADALLTABS",pic:""},{ctrl:"GENERALWC"}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e143t2_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e153t2_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];n=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,25,26,28,29,30];this.GXLastCtrlId=30;this.TABSContainer=gx.uc.getNew(this,23,0,"gx.ui.controls.Tab","TABSContainer","Tabs","TABS");t=this.TABSContainer;t.setProp("Enabled","Enabled",!0,"boolean");t.setProp("ActivePage","Activepage","","int");t.setDynProp("ActivePageControlName","Activepagecontrolname","","char");t.setProp("PageCount","Pagecount",1,"num");t.setProp("Class","Class","ViewTab Tab","str");t.setProp("HistoryManagement","Historymanagement",!0,"bool");t.setProp("Visible","Visible",!0,"bool");t.setC2ShowFunction(function(n){n.show()});t.addEventHandler("TabChanged",this.e133t1_client);this.setUserControl(t);n[2]={id:2,fld:"",grid:0};n[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};n[4]={id:4,fld:"",grid:0};n[5]={id:5,fld:"",grid:0};n[6]={id:6,fld:"TABLEMAIN",grid:0};n[7]={id:7,fld:"",grid:0};n[8]={id:8,fld:"",grid:0};n[9]={id:9,fld:"HEADER",grid:0};n[10]={id:10,fld:"",grid:0};n[11]={id:11,fld:"TABLETITLE",grid:0};n[12]={id:12,fld:"",grid:0};n[13]={id:13,fld:"VIEWTITLE",format:0,grid:0,ctrltype:"textblock"};n[14]={id:14,fld:"",grid:0};n[15]={id:15,fld:"TABLEVIEWRIGHTITEMS",grid:0};n[16]={id:16,fld:"",grid:0};n[17]={id:17,fld:"WORKWITHLINK",format:0,grid:0,ctrltype:"textblock"};n[18]={id:18,fld:"",grid:0};n[19]={id:19,fld:"",grid:0};n[20]={id:20,fld:"UNNAMEDTABLEVIEWCONTAINER",grid:0};n[21]={id:21,fld:"",grid:0};n[22]={id:22,fld:"",grid:0};n[25]={id:25,fld:"GENERAL_TITLE",format:0,grid:0,ctrltype:"textblock"};n[26]={id:26,fld:"",grid:0};n[28]={id:28,fld:"UNNAMEDTABLEGENERAL",grid:0};n[29]={id:29,fld:"",grid:0};n[30]={id:30,fld:"",grid:0};this.AV10TipoPersonaId=0;this.AV8TabCode="";this.A2TipoPersonaId=0;this.AV11LoadAllTabs=!1;this.AV12SelectedTabCode="";this.Events={e143t2_client:["ENTER",!0],e153t2_client:["CANCEL",!0],e133t1_client:["TABS.TABCHANGED",!1]};this.EvtParms.REFRESH=[[{av:"AV10TipoPersonaId",fld:"vTIPOPERSONAID",pic:"ZZZZZZZZZZ9",hsh:!0},{av:"AV8TabCode",fld:"vTABCODE",pic:"",hsh:!0}],[]];this.EvtParms["TABS.TABCHANGED"]=[[{av:"this.TABSContainer.ActivePageControlName",ctrl:"TABS",prop:"ActivePageControlName"},{av:"AV11LoadAllTabs",fld:"vLOADALLTABS",pic:""},{av:"AV12SelectedTabCode",fld:"vSELECTEDTABCODE",pic:""},{av:"AV10TipoPersonaId",fld:"vTIPOPERSONAID",pic:"ZZZZZZZZZZ9",hsh:!0}],[{av:"AV12SelectedTabCode",fld:"vSELECTEDTABCODE",pic:""},{av:"AV11LoadAllTabs",fld:"vLOADALLTABS",pic:""},{ctrl:"GENERALWC"}]];this.EvtParms.ENTER=[[],[]];this.setVCMap("AV11LoadAllTabs","vLOADALLTABS",0,"boolean",4,0);this.setVCMap("AV12SelectedTabCode","vSELECTEDTABCODE",0,"char",50,0);this.setVCMap("AV10TipoPersonaId","vTIPOPERSONAID",0,"int",11,0);this.setVCMap("AV8TabCode","vTABCODE",0,"char",50,0);this.setVCMap("AV10TipoPersonaId","vTIPOPERSONAID",0,"int",11,0);this.setVCMap("AV11LoadAllTabs","vLOADALLTABS",0,"boolean",4,0);this.setVCMap("AV12SelectedTabCode","vSELECTEDTABCODE",0,"char",50,0);this.Initialize();this.setComponent({id:"GENERALWC",GXClass:null,Prefix:"W0031",lvl:1})});gx.wi(function(){gx.createParentObj(this.tipopersonaview)})