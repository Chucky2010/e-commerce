gx.evt.autoSkip=!1;gx.define("caja",!1,function(){var n,t;this.ServerClass="caja";this.PackageName="com.mujermorena";this.ServerFullClass="com.mujermorena.caja";this.setObjectType("trn");this.hasEnterEvent=!0;this.skipOnEnter=!1;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.AV7CajaId=gx.fn.getIntegerValue("vCAJAID",gx.thousandSeparator);this.Gx_mode=gx.fn.getControlValue("vMODE");this.AV11TrnContext=gx.fn.getControlValue("vTRNCONTEXT")};this.Valid_Cajaid=function(){return this.validCliEvt("Valid_Cajaid",0,function(){try{var n=gx.util.balloon.getNew("CAJAID");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Cajaasiganacion=function(){return this.validSrvEvt("valid_Cajaasiganacion",0).then(function(n){return n}.closure(this))};this.Validv_Cajausuario=function(){return this.validCliEvt("Validv_Cajausuario",0,function(){try{var n=gx.util.balloon.getNew("vCAJAUSUARIO");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.e120m2_client=function(){return this.executeServerEvent("AFTER TRN",!0,null,!1,!1)};this.e130m23_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e140m23_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];n=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,13,14,15,16,17,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56];this.GXLastCtrlId=56;this.DVPANEL_TABLEATTRIBUTESContainer=gx.uc.getNew(this,18,0,"BootstrapPanel","DVPANEL_TABLEATTRIBUTESContainer","Dvpanel_tableattributes","DVPANEL_TABLEATTRIBUTES");t=this.DVPANEL_TABLEATTRIBUTESContainer;t.setProp("Class","Class","","char");t.setProp("Enabled","Enabled",!0,"boolean");t.setProp("Width","Width","100%","str");t.setProp("Height","Height","100","str");t.setProp("AutoWidth","Autowidth",!1,"bool");t.setProp("AutoHeight","Autoheight",!0,"bool");t.setProp("Cls","Cls","PanelFilled Panel_BaseColor","str");t.setProp("ShowHeader","Showheader",!0,"bool");t.setProp("Title","Title",gx.getMessage("WWP_TemplateDataPanelTitle"),"str");t.setProp("Collapsible","Collapsible",!1,"bool");t.setProp("Collapsed","Collapsed",!1,"bool");t.setProp("ShowCollapseIcon","Showcollapseicon",!1,"bool");t.setProp("IconPosition","Iconposition","Right","str");t.setProp("AutoScroll","Autoscroll",!1,"bool");t.setProp("Visible","Visible",!0,"bool");t.setProp("Gx Control Type","Gxcontroltype","","int");t.setC2ShowFunction(function(n){n.show()});this.setUserControl(t);n[2]={id:2,fld:"",grid:0};n[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};n[4]={id:4,fld:"",grid:0};n[5]={id:5,fld:"",grid:0};n[6]={id:6,fld:"TABLEMAIN",grid:0};n[7]={id:7,fld:"",grid:0};n[8]={id:8,fld:"",grid:0};n[9]={id:9,fld:"TEXTBLOCKTITLE",format:0,grid:0,ctrltype:"textblock"};n[10]={id:10,fld:"",grid:0};n[11]={id:11,fld:"",grid:0};n[13]={id:13,fld:"",grid:0};n[14]={id:14,fld:"",grid:0};n[15]={id:15,fld:"TABLECONTENT",grid:0};n[16]={id:16,fld:"",grid:0};n[17]={id:17,fld:"",grid:0};n[20]={id:20,fld:"TABLEATTRIBUTES",grid:0};n[21]={id:21,fld:"",grid:0};n[22]={id:22,fld:"",grid:0};n[23]={id:23,fld:"",grid:0};n[24]={id:24,fld:"",grid:0};n[25]={id:25,lvl:0,type:"int",len:11,dec:0,sign:!1,pic:"ZZZZZZZZZZ9",ro:0,grid:0,gxgrid:null,fnc:this.Valid_Cajaid,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CAJAID",fmt:0,gxz:"Z25CajaId",gxold:"O25CajaId",gxvar:"A25CajaId",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A25CajaId=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z25CajaId=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("CAJAID",gx.O.A25CajaId,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A25CajaId=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("CAJAID",gx.thousandSeparator)},nac:function(){return!(0==this.AV7CajaId)}};this.declareDomainHdlr(25,function(){});n[26]={id:26,fld:"",grid:0};n[27]={id:27,fld:"",grid:0};n[28]={id:28,fld:"",grid:0};n[29]={id:29,lvl:0,type:"int",len:10,dec:0,sign:!1,pic:"ZZZZZZZZZ9",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CAJANUMERO",fmt:0,gxz:"Z110CajaNumero",gxold:"O110CajaNumero",gxvar:"A110CajaNumero",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A110CajaNumero=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z110CajaNumero=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("CAJANUMERO",gx.O.A110CajaNumero,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A110CajaNumero=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("CAJANUMERO",gx.thousandSeparator)},nac:gx.falseFn};this.declareDomainHdlr(29,function(){});n[30]={id:30,fld:"",grid:0};n[31]={id:31,fld:"",grid:0};n[32]={id:32,fld:"",grid:0};n[33]={id:33,fld:"",grid:0};n[34]={id:34,lvl:0,type:"char",len:80,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CAJANOMBREUSUARIO",fmt:0,gxz:"Z111CajaNombreUsuario",gxold:"O111CajaNombreUsuario",gxvar:"A111CajaNombreUsuario",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A111CajaNombreUsuario=n)},v2z:function(n){n!==undefined&&(gx.O.Z111CajaNombreUsuario=n)},v2c:function(){gx.fn.setControlValue("CAJANOMBREUSUARIO",gx.O.A111CajaNombreUsuario,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A111CajaNombreUsuario=this.val())},val:function(){return gx.fn.getControlValue("CAJANOMBREUSUARIO")},nac:gx.falseFn};this.declareDomainHdlr(34,function(){});n[35]={id:35,fld:"",grid:0};n[36]={id:36,fld:"",grid:0};n[37]={id:37,fld:"",grid:0};n[38]={id:38,lvl:0,type:"char",len:20,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CAJAESTADO",fmt:0,gxz:"Z253CajaEstado",gxold:"O253CajaEstado",gxvar:"A253CajaEstado",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A253CajaEstado=n)},v2z:function(n){n!==undefined&&(gx.O.Z253CajaEstado=n)},v2c:function(){gx.fn.setControlValue("CAJAESTADO",gx.O.A253CajaEstado,0)},c2v:function(){this.val()!==undefined&&(gx.O.A253CajaEstado=this.val())},val:function(){return gx.fn.getControlValue("CAJAESTADO")},nac:gx.falseFn};n[39]={id:39,fld:"",grid:0};n[40]={id:40,fld:"",grid:0};n[41]={id:41,fld:"",grid:0};n[42]={id:42,fld:"",grid:0};n[43]={id:43,lvl:0,type:"char",len:20,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:this.Valid_Cajaasiganacion,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CAJAASIGANACION",fmt:0,gxz:"Z255CajaAsiganacion",gxold:"O255CajaAsiganacion",gxvar:"A255CajaAsiganacion",ucs:[],op:[47],ip:[47,43],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A255CajaAsiganacion=n)},v2z:function(n){n!==undefined&&(gx.O.Z255CajaAsiganacion=n)},v2c:function(){gx.fn.setControlValue("CAJAASIGANACION",gx.O.A255CajaAsiganacion,0)},c2v:function(){this.val()!==undefined&&(gx.O.A255CajaAsiganacion=this.val())},val:function(){return gx.fn.getControlValue("CAJAASIGANACION")},nac:gx.falseFn};n[44]={id:44,fld:"",grid:0};n[45]={id:45,fld:"",grid:0};n[46]={id:46,fld:"",grid:0};n[47]={id:47,lvl:0,type:"char",len:1,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:this.Validv_Cajausuario,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vCAJAUSUARIO",fmt:0,gxz:"ZV13CajaUsuario",gxold:"OV13CajaUsuario",gxvar:"AV13CajaUsuario",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV13CajaUsuario=n)},v2z:function(n){n!==undefined&&(gx.O.ZV13CajaUsuario=n)},v2c:function(){gx.fn.setControlValue("vCAJAUSUARIO",gx.O.AV13CajaUsuario,0)},c2v:function(){this.val()!==undefined&&(gx.O.AV13CajaUsuario=this.val())},val:function(){return gx.fn.getControlValue("vCAJAUSUARIO")},nac:gx.falseFn};n[48]={id:48,fld:"",grid:0};n[49]={id:49,fld:"",grid:0};n[50]={id:50,fld:"",grid:0};n[51]={id:51,fld:"",grid:0};n[52]={id:52,fld:"BTNTRN_ENTER",grid:0,evt:"e130m23_client",std:"ENTER"};n[53]={id:53,fld:"",grid:0};n[54]={id:54,fld:"BTNTRN_CANCEL",grid:0,evt:"e140m23_client"};n[55]={id:55,fld:"",grid:0};n[56]={id:56,fld:"BTNTRN_DELETE",grid:0,evt:"e150m23_client",std:"DELETE"};this.A25CajaId=0;this.Z25CajaId=0;this.O25CajaId=0;this.A110CajaNumero=0;this.Z110CajaNumero=0;this.O110CajaNumero=0;this.A111CajaNombreUsuario="";this.Z111CajaNombreUsuario="";this.O111CajaNombreUsuario="";this.A253CajaEstado="";this.Z253CajaEstado="";this.O253CajaEstado="";this.A255CajaAsiganacion="";this.Z255CajaAsiganacion="";this.O255CajaAsiganacion="";this.AV13CajaUsuario="";this.ZV13CajaUsuario="";this.OV13CajaUsuario="";this.AV8WWPContext={UserId:0,UserName:""};this.AV11TrnContext={CallerObject:"",CallerOnDelete:!1,CallerURL:"",TransactionName:"",Attributes:[]};this.AV7CajaId=0;this.AV12WebSession={};this.A25CajaId=0;this.AV13CajaUsuario="";this.A110CajaNumero=0;this.A111CajaNombreUsuario="";this.A253CajaEstado="";this.A255CajaAsiganacion="";this.Gx_mode="";this.Events={e120m2_client:["AFTER TRN",!0],e130m23_client:["ENTER",!0],e140m23_client:["CANCEL",!0]};this.EvtParms.ENTER=[[{postForm:!0},{av:"Gx_mode",fld:"vMODE",pic:"@!",hsh:!0},{av:"AV7CajaId",fld:"vCAJAID",pic:"ZZZZZZZZZZ9",hsh:!0}],[]];this.EvtParms.REFRESH=[[{av:"Gx_mode",fld:"vMODE",pic:"@!",hsh:!0},{av:"AV11TrnContext",fld:"vTRNCONTEXT",pic:"",hsh:!0},{av:"AV7CajaId",fld:"vCAJAID",pic:"ZZZZZZZZZZ9",hsh:!0}],[]];this.EvtParms["AFTER TRN"]=[[{av:"Gx_mode",fld:"vMODE",pic:"@!",hsh:!0},{av:"AV11TrnContext",fld:"vTRNCONTEXT",pic:"",hsh:!0}],[]];this.EvtParms.VALID_CAJAID=[[],[]];this.EvtParms.VALID_CAJAASIGANACION=[[{av:"A255CajaAsiganacion",fld:"CAJAASIGANACION",pic:""},{av:"AV13CajaUsuario",fld:"vCAJAUSUARIO",pic:""}],[{av:"AV13CajaUsuario",fld:"vCAJAUSUARIO",pic:""}]];this.EvtParms.VALIDV_CAJAUSUARIO=[[],[]];this.EnterCtrl=["BTNTRN_ENTER"];this.setVCMap("AV7CajaId","vCAJAID",0,"int",11,0);this.setVCMap("Gx_mode","vMODE",0,"char",3,0);this.setVCMap("AV11TrnContext","vTRNCONTEXT",0,"WWPBaseObjectsWWPTransactionContext",0,0);this.Initialize()});gx.wi(function(){gx.createParentObj(this.caja)})