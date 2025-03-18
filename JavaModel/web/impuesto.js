gx.evt.autoSkip=!1;gx.define("impuesto",!1,function(){var n,t;this.ServerClass="impuesto";this.PackageName="com.mujermorena";this.ServerFullClass="com.mujermorena.impuesto";this.setObjectType("trn");this.hasEnterEvent=!0;this.skipOnEnter=!1;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.AV7ImpuestoId=gx.fn.getIntegerValue("vIMPUESTOID",gx.thousandSeparator);this.Gx_mode=gx.fn.getControlValue("vMODE");this.AV11TrnContext=gx.fn.getControlValue("vTRNCONTEXT")};this.Valid_Impuestoid=function(){return this.validCliEvt("Valid_Impuestoid",0,function(){try{var n=gx.util.balloon.getNew("IMPUESTOID");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.e120g2_client=function(){return this.executeServerEvent("AFTER TRN",!0,null,!1,!1)};this.e130g44_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e140g44_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];n=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,13,14,15,16,17,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47];this.GXLastCtrlId=47;this.DVPANEL_TABLEATTRIBUTESContainer=gx.uc.getNew(this,18,0,"BootstrapPanel","DVPANEL_TABLEATTRIBUTESContainer","Dvpanel_tableattributes","DVPANEL_TABLEATTRIBUTES");t=this.DVPANEL_TABLEATTRIBUTESContainer;t.setProp("Class","Class","","char");t.setProp("Enabled","Enabled",!0,"boolean");t.setProp("Width","Width","100%","str");t.setProp("Height","Height","100","str");t.setProp("AutoWidth","Autowidth",!1,"bool");t.setProp("AutoHeight","Autoheight",!0,"bool");t.setProp("Cls","Cls","PanelFilled Panel_BaseColor","str");t.setProp("ShowHeader","Showheader",!0,"bool");t.setProp("Title","Title",gx.getMessage("WWP_TemplateDataPanelTitle"),"str");t.setProp("Collapsible","Collapsible",!1,"bool");t.setProp("Collapsed","Collapsed",!1,"bool");t.setProp("ShowCollapseIcon","Showcollapseicon",!1,"bool");t.setProp("IconPosition","Iconposition","Right","str");t.setProp("AutoScroll","Autoscroll",!1,"bool");t.setProp("Visible","Visible",!0,"bool");t.setProp("Gx Control Type","Gxcontroltype","","int");t.setC2ShowFunction(function(n){n.show()});this.setUserControl(t);n[2]={id:2,fld:"",grid:0};n[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};n[4]={id:4,fld:"",grid:0};n[5]={id:5,fld:"",grid:0};n[6]={id:6,fld:"TABLEMAIN",grid:0};n[7]={id:7,fld:"",grid:0};n[8]={id:8,fld:"",grid:0};n[9]={id:9,fld:"TEXTBLOCKTITLE",format:0,grid:0,ctrltype:"textblock"};n[10]={id:10,fld:"",grid:0};n[11]={id:11,fld:"",grid:0};n[13]={id:13,fld:"",grid:0};n[14]={id:14,fld:"",grid:0};n[15]={id:15,fld:"TABLECONTENT",grid:0};n[16]={id:16,fld:"",grid:0};n[17]={id:17,fld:"",grid:0};n[20]={id:20,fld:"TABLEATTRIBUTES",grid:0};n[21]={id:21,fld:"",grid:0};n[22]={id:22,fld:"",grid:0};n[23]={id:23,fld:"",grid:0};n[24]={id:24,fld:"",grid:0};n[25]={id:25,lvl:0,type:"int",len:11,dec:0,sign:!1,pic:"ZZZZZZZZZZ9",ro:0,grid:0,gxgrid:null,fnc:this.Valid_Impuestoid,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"IMPUESTOID",fmt:0,gxz:"Z18ImpuestoId",gxold:"O18ImpuestoId",gxvar:"A18ImpuestoId",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A18ImpuestoId=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z18ImpuestoId=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("IMPUESTOID",gx.O.A18ImpuestoId,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A18ImpuestoId=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("IMPUESTOID",gx.thousandSeparator)},nac:function(){return!(0==this.AV7ImpuestoId)}};this.declareDomainHdlr(25,function(){});n[26]={id:26,fld:"",grid:0};n[27]={id:27,fld:"",grid:0};n[28]={id:28,fld:"",grid:0};n[29]={id:29,lvl:0,type:"svchar",len:100,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"IMPUESTODESCRIPCION",fmt:0,gxz:"Z223ImpuestoDescripcion",gxold:"O223ImpuestoDescripcion",gxvar:"A223ImpuestoDescripcion",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A223ImpuestoDescripcion=n)},v2z:function(n){n!==undefined&&(gx.O.Z223ImpuestoDescripcion=n)},v2c:function(){gx.fn.setControlValue("IMPUESTODESCRIPCION",gx.O.A223ImpuestoDescripcion,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A223ImpuestoDescripcion=this.val())},val:function(){return gx.fn.getControlValue("IMPUESTODESCRIPCION")},nac:gx.falseFn};this.declareDomainHdlr(29,function(){});n[30]={id:30,fld:"",grid:0};n[31]={id:31,fld:"",grid:0};n[32]={id:32,fld:"",grid:0};n[33]={id:33,fld:"",grid:0};n[34]={id:34,lvl:0,type:"decimal",len:9,dec:2,sign:!1,pic:"ZZZZZ9.99",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"IMPUESTOPORCENTAJE",fmt:0,gxz:"Z83ImpuestoPorcentaje",gxold:"O83ImpuestoPorcentaje",gxvar:"A83ImpuestoPorcentaje",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A83ImpuestoPorcentaje=gx.fn.toDecimalValue(n,",","."))},v2z:function(n){n!==undefined&&(gx.O.Z83ImpuestoPorcentaje=gx.fn.toDecimalValue(n,gx.thousandSeparator,gx.decimalPoint))},v2c:function(){gx.fn.setDecimalValue("IMPUESTOPORCENTAJE",gx.O.A83ImpuestoPorcentaje,2,gx.decimalPoint);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A83ImpuestoPorcentaje=this.val())},val:function(){return gx.fn.getDecimalValue("IMPUESTOPORCENTAJE",gx.thousandSeparator,gx.decimalPoint)},nac:gx.falseFn};this.declareDomainHdlr(34,function(){});n[35]={id:35,fld:"",grid:0};n[36]={id:36,fld:"",grid:0};n[37]={id:37,fld:"",grid:0};n[38]={id:38,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"IMPUESTODIVISOR",fmt:0,gxz:"Z224ImpuestoDivisor",gxold:"O224ImpuestoDivisor",gxvar:"A224ImpuestoDivisor",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A224ImpuestoDivisor=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z224ImpuestoDivisor=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("IMPUESTODIVISOR",gx.O.A224ImpuestoDivisor,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A224ImpuestoDivisor=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("IMPUESTODIVISOR",gx.thousandSeparator)},nac:gx.falseFn};this.declareDomainHdlr(38,function(){});n[39]={id:39,fld:"",grid:0};n[40]={id:40,fld:"",grid:0};n[41]={id:41,fld:"",grid:0};n[42]={id:42,fld:"",grid:0};n[43]={id:43,fld:"BTNTRN_ENTER",grid:0,evt:"e130g44_client",std:"ENTER"};n[44]={id:44,fld:"",grid:0};n[45]={id:45,fld:"BTNTRN_CANCEL",grid:0,evt:"e140g44_client"};n[46]={id:46,fld:"",grid:0};n[47]={id:47,fld:"BTNTRN_DELETE",grid:0,evt:"e150g44_client",std:"DELETE"};this.A18ImpuestoId=0;this.Z18ImpuestoId=0;this.O18ImpuestoId=0;this.A223ImpuestoDescripcion="";this.Z223ImpuestoDescripcion="";this.O223ImpuestoDescripcion="";this.A83ImpuestoPorcentaje=0;this.Z83ImpuestoPorcentaje=0;this.O83ImpuestoPorcentaje=0;this.A224ImpuestoDivisor=0;this.Z224ImpuestoDivisor=0;this.O224ImpuestoDivisor=0;this.AV8WWPContext={UserId:0,UserName:""};this.AV11TrnContext={CallerObject:"",CallerOnDelete:!1,CallerURL:"",TransactionName:"",Attributes:[]};this.AV7ImpuestoId=0;this.AV12WebSession={};this.A18ImpuestoId=0;this.A223ImpuestoDescripcion="";this.A83ImpuestoPorcentaje=0;this.A224ImpuestoDivisor=0;this.Gx_mode="";this.Events={e120g2_client:["AFTER TRN",!0],e130g44_client:["ENTER",!0],e140g44_client:["CANCEL",!0]};this.EvtParms.ENTER=[[{postForm:!0},{av:"Gx_mode",fld:"vMODE",pic:"@!",hsh:!0},{av:"AV7ImpuestoId",fld:"vIMPUESTOID",pic:"ZZZZZZZZZZ9",hsh:!0}],[]];this.EvtParms.REFRESH=[[{av:"Gx_mode",fld:"vMODE",pic:"@!",hsh:!0},{av:"AV11TrnContext",fld:"vTRNCONTEXT",pic:"",hsh:!0},{av:"AV7ImpuestoId",fld:"vIMPUESTOID",pic:"ZZZZZZZZZZ9",hsh:!0}],[]];this.EvtParms["AFTER TRN"]=[[{av:"Gx_mode",fld:"vMODE",pic:"@!",hsh:!0},{av:"AV11TrnContext",fld:"vTRNCONTEXT",pic:"",hsh:!0}],[]];this.EvtParms.VALID_IMPUESTOID=[[],[]];this.EnterCtrl=["BTNTRN_ENTER"];this.setVCMap("AV7ImpuestoId","vIMPUESTOID",0,"int",11,0);this.setVCMap("Gx_mode","vMODE",0,"char",3,0);this.setVCMap("AV11TrnContext","vTRNCONTEXT",0,"WWPBaseObjectsWWPTransactionContext",0,0);this.Initialize()});gx.wi(function(){gx.createParentObj(this.impuesto)})