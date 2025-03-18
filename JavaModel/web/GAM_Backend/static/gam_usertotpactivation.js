/*!   GeneXus Java 17_0_11-163677 on August 31, 2022 2:10:16.7
*/
gx.evt.autoSkip=!1;gx.define("gam_usertotpactivation",!1,function(){this.ServerClass="gam_usertotpactivation";this.PackageName="genexus.security.backend";this.ServerFullClass="genexus.security.backend.gam_usertotpactivation";this.setObjectType("web");this.setOnAjaxSessionTimeout("Warn");this.hasEnterEvent=!0;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.SetStandaloneVars=function(){this.AV15UserId=gx.fn.getControlValue("vUSERID")};this.e12332_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e14331_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];var n=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45];this.GXLastCtrlId=45;n[2]={id:2,fld:"",grid:0};n[3]={id:3,fld:"MAINTABLE",grid:0};n[4]={id:4,fld:"",grid:0};n[5]={id:5,fld:"",grid:0};n[6]={id:6,fld:"TBLMAIN",grid:0};n[7]={id:7,fld:"",grid:0};n[8]={id:8,fld:"",grid:0};n[10]={id:10,fld:"",grid:0};n[11]={id:11,fld:"",grid:0};n[12]={id:12,fld:"TEXTBLOCK2",format:0,grid:0,ctrltype:"textblock"};n[13]={id:13,fld:"",grid:0};n[14]={id:14,fld:"",grid:0};n[15]={id:15,fld:"TABLE2",grid:0};n[16]={id:16,fld:"",grid:0};n[17]={id:17,fld:"",grid:0};n[18]={id:18,fld:"",grid:0};n[19]={id:19,fld:"",grid:0};n[20]={id:20,lvl:0,type:"svchar",len:100,dec:60,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vUSERNAME",fmt:0,gxz:"ZV16UserName",gxold:"OV16UserName",gxvar:"AV16UserName",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV16UserName=n)},v2z:function(n){n!==undefined&&(gx.O.ZV16UserName=n)},v2c:function(){gx.fn.setControlValue("vUSERNAME",gx.O.AV16UserName,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.AV16UserName=this.val())},val:function(){return gx.fn.getControlValue("vUSERNAME")},nac:gx.falseFn};this.declareDomainHdlr(20,function(){});n[21]={id:21,fld:"",grid:0};n[22]={id:22,fld:"",grid:0};n[23]={id:23,fld:"",grid:0};n[24]={id:24,fld:"",grid:0};n[25]={id:25,lvl:0,type:"svchar",len:100,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vUSEREMAIL",fmt:0,gxz:"ZV14UserEmail",gxold:"OV14UserEmail",gxvar:"AV14UserEmail",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV14UserEmail=n)},v2z:function(n){n!==undefined&&(gx.O.ZV14UserEmail=n)},v2c:function(){gx.fn.setControlValue("vUSEREMAIL",gx.O.AV14UserEmail,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.AV14UserEmail=this.val())},val:function(){return gx.fn.getControlValue("vUSEREMAIL")},nac:gx.falseFn};this.declareDomainHdlr(25,function(){});n[26]={id:26,fld:"",grid:0};n[27]={id:27,fld:"",grid:0};n[28]={id:28,fld:"QRIMAGE",format:1,grid:0,ctrltype:"textblock"};n[29]={id:29,fld:"",grid:0};n[30]={id:30,fld:"",grid:0};n[31]={id:31,fld:"",grid:0};n[32]={id:32,fld:"",grid:0};n[33]={id:33,lvl:0,type:"svchar",len:256,dec:0,sign:!1,ro:0,multiline:!0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vSECRETKEY",fmt:0,gxz:"ZV12SecretKey",gxold:"OV12SecretKey",gxvar:"AV12SecretKey",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV12SecretKey=n)},v2z:function(n){n!==undefined&&(gx.O.ZV12SecretKey=n)},v2c:function(){gx.fn.setControlValue("vSECRETKEY",gx.O.AV12SecretKey,0)},c2v:function(){this.val()!==undefined&&(gx.O.AV12SecretKey=this.val())},val:function(){return gx.fn.getControlValue("vSECRETKEY")},nac:gx.falseFn};n[34]={id:34,fld:"",grid:0};n[35]={id:35,fld:"",grid:0};n[36]={id:36,fld:"",grid:0};n[37]={id:37,fld:"",grid:0};n[38]={id:38,lvl:0,type:"svchar",len:8,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vTOTPCODE",fmt:0,gxz:"ZV13TOTPCode",gxold:"OV13TOTPCode",gxvar:"AV13TOTPCode",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV13TOTPCode=n)},v2z:function(n){n!==undefined&&(gx.O.ZV13TOTPCode=n)},v2c:function(){gx.fn.setControlValue("vTOTPCODE",gx.O.AV13TOTPCode,0)},c2v:function(){this.val()!==undefined&&(gx.O.AV13TOTPCode=this.val())},val:function(){return gx.fn.getControlValue("vTOTPCODE")},nac:gx.falseFn};n[39]={id:39,fld:"",grid:0};n[40]={id:40,fld:"",grid:0};n[41]={id:41,fld:"",grid:0};n[42]={id:42,fld:"",grid:0};n[43]={id:43,fld:"BTNBACK",grid:0,evt:"e14331_client"};n[44]={id:44,fld:"",grid:0};n[45]={id:45,fld:"BTNVALIDATECODE",grid:0,evt:"e12332_client",std:"ENTER"};this.AV16UserName="";this.ZV16UserName="";this.OV16UserName="";this.AV14UserEmail="";this.ZV14UserEmail="";this.OV14UserEmail="";this.AV12SecretKey="";this.ZV12SecretKey="";this.OV12SecretKey="";this.AV13TOTPCode="";this.ZV13TOTPCode="";this.OV13TOTPCode="";this.AV16UserName="";this.AV14UserEmail="";this.AV12SecretKey="";this.AV13TOTPCode="";this.AV15UserId="";this.Events={e12332_client:["ENTER",!0],e14331_client:["CANCEL",!0]};this.EvtParms.REFRESH=[[{av:"AV15UserId",fld:"vUSERID",pic:"",hsh:!0},{av:"AV12SecretKey",fld:"vSECRETKEY",pic:""}],[]];this.EvtParms.ENTER=[[{av:"AV15UserId",fld:"vUSERID",pic:"",hsh:!0},{av:"AV13TOTPCode",fld:"vTOTPCODE",pic:""}],[{ctrl:"BTNVALIDATECODE",prop:"Visible"}]];this.EnterCtrl=["BTNVALIDATECODE"];this.setVCMap("AV15UserId","vUSERID",0,"char",40,0);this.Initialize()});gx.wi(function(){gx.createParentObj(this.gam_usertotpactivation)})