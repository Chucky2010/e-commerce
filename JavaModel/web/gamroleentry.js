gx.evt.autoSkip=!1;gx.define("gamroleentry",!1,function(){var n,t;this.ServerClass="gamroleentry";this.PackageName="com.mujermorena";this.ServerFullClass="com.mujermorena.gamroleentry";this.setObjectType("web");this.hasEnterEvent=!0;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.AV8Id=gx.fn.getIntegerValue("vID",gx.thousandSeparator);this.Gx_mode=gx.fn.getControlValue("vMODE")};this.e12362_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e14361_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];n=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,10,11,12,13,14,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51];this.GXLastCtrlId=51;this.DVPANEL_TABLEATTRIBUTESContainer=gx.uc.getNew(this,15,0,"BootstrapPanel","DVPANEL_TABLEATTRIBUTESContainer","Dvpanel_tableattributes","DVPANEL_TABLEATTRIBUTES");t=this.DVPANEL_TABLEATTRIBUTESContainer;t.setProp("Class","Class","","char");t.setProp("Enabled","Enabled",!0,"boolean");t.setProp("Width","Width","100%","str");t.setProp("Height","Height","100","str");t.setProp("AutoWidth","Autowidth",!1,"bool");t.setProp("AutoHeight","Autoheight",!0,"bool");t.setProp("Cls","Cls","PanelFilled Panel_BaseColor","str");t.setProp("ShowHeader","Showheader",!0,"bool");t.setProp("Title","Title",gx.getMessage("WWP_GAM_Role"),"str");t.setProp("Collapsible","Collapsible",!1,"bool");t.setProp("Collapsed","Collapsed",!1,"bool");t.setProp("ShowCollapseIcon","Showcollapseicon",!1,"bool");t.setProp("IconPosition","Iconposition","Right","str");t.setProp("AutoScroll","Autoscroll",!1,"bool");t.setProp("Visible","Visible",!0,"bool");t.setProp("Gx Control Type","Gxcontroltype","","int");t.setC2ShowFunction(function(n){n.show()});this.setUserControl(t);n[2]={id:2,fld:"",grid:0};n[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};n[4]={id:4,fld:"",grid:0};n[5]={id:5,fld:"",grid:0};n[6]={id:6,fld:"TABLEMAIN",grid:0};n[7]={id:7,fld:"",grid:0};n[8]={id:8,fld:"",grid:0};n[10]={id:10,fld:"",grid:0};n[11]={id:11,fld:"",grid:0};n[12]={id:12,fld:"TABLECONTENT",grid:0};n[13]={id:13,fld:"",grid:0};n[14]={id:14,fld:"",grid:0};n[17]={id:17,fld:"TABLEATTRIBUTES",grid:0};n[18]={id:18,fld:"",grid:0};n[19]={id:19,fld:"",grid:0};n[20]={id:20,fld:"",grid:0};n[21]={id:21,fld:"",grid:0};n[22]={id:22,lvl:0,type:"int",len:12,dec:0,sign:!1,pic:"ZZZZZZZZZZZ9",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vROLEID",fmt:0,gxz:"ZV12RoleId",gxold:"OV12RoleId",gxvar:"AV12RoleId",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV12RoleId=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.ZV12RoleId=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("vROLEID",gx.O.AV12RoleId,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.AV12RoleId=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("vROLEID",gx.thousandSeparator)},nac:gx.falseFn};this.declareDomainHdlr(22,function(){});n[23]={id:23,fld:"",grid:0};n[24]={id:24,fld:"",grid:0};n[25]={id:25,fld:"",grid:0};n[26]={id:26,lvl:0,type:"char",len:40,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vROLEGUID",fmt:0,gxz:"ZV13RoleGUID",gxold:"OV13RoleGUID",gxvar:"AV13RoleGUID",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV13RoleGUID=n)},v2z:function(n){n!==undefined&&(gx.O.ZV13RoleGUID=n)},v2c:function(){gx.fn.setControlValue("vROLEGUID",gx.O.AV13RoleGUID,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.AV13RoleGUID=this.val())},val:function(){return gx.fn.getControlValue("vROLEGUID")},nac:gx.falseFn};this.declareDomainHdlr(26,function(){});n[27]={id:27,fld:"",grid:0};n[28]={id:28,fld:"",grid:0};n[29]={id:29,fld:"",grid:0};n[30]={id:30,fld:"",grid:0};n[31]={id:31,lvl:0,type:"char",len:254,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vROLENAME",fmt:0,gxz:"ZV14RoleName",gxold:"OV14RoleName",gxvar:"AV14RoleName",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV14RoleName=n)},v2z:function(n){n!==undefined&&(gx.O.ZV14RoleName=n)},v2c:function(){gx.fn.setControlValue("vROLENAME",gx.O.AV14RoleName,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.AV14RoleName=this.val())},val:function(){return gx.fn.getControlValue("vROLENAME")},nac:gx.falseFn};this.declareDomainHdlr(31,function(){});n[32]={id:32,fld:"",grid:0};n[33]={id:33,fld:"",grid:0};n[34]={id:34,fld:"",grid:0};n[35]={id:35,lvl:0,type:"char",len:254,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vROLEDESCRIPTION",fmt:0,gxz:"ZV15RoleDescription",gxold:"OV15RoleDescription",gxvar:"AV15RoleDescription",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV15RoleDescription=n)},v2z:function(n){n!==undefined&&(gx.O.ZV15RoleDescription=n)},v2c:function(){gx.fn.setControlValue("vROLEDESCRIPTION",gx.O.AV15RoleDescription,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.AV15RoleDescription=this.val())},val:function(){return gx.fn.getControlValue("vROLEDESCRIPTION")},nac:gx.falseFn};this.declareDomainHdlr(35,function(){});n[36]={id:36,fld:"",grid:0};n[37]={id:37,fld:"",grid:0};n[38]={id:38,fld:"",grid:0};n[39]={id:39,fld:"",grid:0};n[40]={id:40,lvl:0,type:"svchar",len:100,dec:60,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vROLEEXTERNALID",fmt:0,gxz:"ZV16RoleExternalId",gxold:"OV16RoleExternalId",gxvar:"AV16RoleExternalId",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV16RoleExternalId=n)},v2z:function(n){n!==undefined&&(gx.O.ZV16RoleExternalId=n)},v2c:function(){gx.fn.setControlValue("vROLEEXTERNALID",gx.O.AV16RoleExternalId,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.AV16RoleExternalId=this.val())},val:function(){return gx.fn.getControlValue("vROLEEXTERNALID")},nac:gx.falseFn};this.declareDomainHdlr(40,function(){});n[41]={id:41,fld:"",grid:0};n[42]={id:42,fld:"",grid:0};n[43]={id:43,fld:"",grid:0};n[44]={id:44,lvl:0,type:"int",len:9,dec:0,sign:!1,pic:"ZZZZZZZZ9",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vROLESECURITYPOLICYID",fmt:0,gxz:"ZV17RoleSecurityPolicyId",gxold:"OV17RoleSecurityPolicyId",gxvar:"AV17RoleSecurityPolicyId",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"combo",v2v:function(n){n!==undefined&&(gx.O.AV17RoleSecurityPolicyId=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.ZV17RoleSecurityPolicyId=gx.num.intval(n))},v2c:function(){gx.fn.setComboBoxValue("vROLESECURITYPOLICYID",gx.O.AV17RoleSecurityPolicyId);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.AV17RoleSecurityPolicyId=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("vROLESECURITYPOLICYID",gx.thousandSeparator)},nac:gx.falseFn};this.declareDomainHdlr(44,function(){});n[45]={id:45,fld:"",grid:0};n[46]={id:46,fld:"",grid:0};n[47]={id:47,fld:"",grid:0};n[48]={id:48,fld:"",grid:0};n[49]={id:49,fld:"BTNENTER",grid:0,evt:"e12362_client",std:"ENTER"};n[50]={id:50,fld:"",grid:0};n[51]={id:51,fld:"BTNCANCEL",grid:0,evt:"e14361_client"};this.AV12RoleId=0;this.ZV12RoleId=0;this.OV12RoleId=0;this.AV13RoleGUID="";this.ZV13RoleGUID="";this.OV13RoleGUID="";this.AV14RoleName="";this.ZV14RoleName="";this.OV14RoleName="";this.AV15RoleDescription="";this.ZV15RoleDescription="";this.OV15RoleDescription="";this.AV16RoleExternalId="";this.ZV16RoleExternalId="";this.OV16RoleExternalId="";this.AV17RoleSecurityPolicyId=0;this.ZV17RoleSecurityPolicyId=0;this.OV17RoleSecurityPolicyId=0;this.AV12RoleId=0;this.AV13RoleGUID="";this.AV14RoleName="";this.AV15RoleDescription="";this.AV16RoleExternalId="";this.AV17RoleSecurityPolicyId=0;this.AV8Id=0;this.Gx_mode="";this.Events={e12362_client:["ENTER",!0],e14361_client:["CANCEL",!0]};this.EvtParms.REFRESH=[[{av:"AV8Id",fld:"vID",pic:"ZZZZZZZZZZZ9",hsh:!0},{av:"Gx_mode",fld:"vMODE",pic:"@!",hsh:!0}],[]];this.EvtParms.ENTER=[[{av:"AV8Id",fld:"vID",pic:"ZZZZZZZZZZZ9",hsh:!0},{av:"Gx_mode",fld:"vMODE",pic:"@!",hsh:!0},{av:"AV14RoleName",fld:"vROLENAME",pic:""},{av:"AV15RoleDescription",fld:"vROLEDESCRIPTION",pic:""},{av:"AV16RoleExternalId",fld:"vROLEEXTERNALID",pic:""},{ctrl:"vROLESECURITYPOLICYID"},{av:"AV17RoleSecurityPolicyId",fld:"vROLESECURITYPOLICYID",pic:"ZZZZZZZZ9"}],[]];this.EnterCtrl=["BTNENTER"];this.setVCMap("AV8Id","vID",0,"int",12,0);this.setVCMap("Gx_mode","vMODE",0,"char",3,0);this.Initialize()});gx.wi(function(){gx.createParentObj(this.gamroleentry)})