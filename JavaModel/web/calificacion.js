gx.evt.autoSkip=!1;gx.define("calificacion",!1,function(){var n,t;this.ServerClass="calificacion";this.PackageName="com.mujermorena";this.ServerFullClass="com.mujermorena.calificacion";this.setObjectType("trn");this.hasEnterEvent=!0;this.skipOnEnter=!1;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.AV7CalificacionId=gx.fn.getIntegerValue("vCALIFICACIONID",gx.thousandSeparator);this.AV13Pgmname=gx.fn.getControlValue("vPGMNAME");this.Gx_mode=gx.fn.getControlValue("vMODE");this.AV11TrnContext=gx.fn.getControlValue("vTRNCONTEXT")};this.Valid_Calificacionid=function(){return this.validCliEvt("Valid_Calificacionid",0,function(){try{var n=gx.util.balloon.getNew("CALIFICACIONID");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Calificacionfechahora=function(){return this.validCliEvt("Valid_Calificacionfechahora",0,function(){try{var n=gx.util.balloon.getNew("CALIFICACIONFECHAHORA");if(this.AnyError=0,!(new gx.date.gxdate("").compare(this.A302CalificacionFechaHora)==0||new gx.date.gxdate(this.A302CalificacionFechaHora).compare(gx.date.ymdhmstot(1753,1,1,0,0,0))>=0))try{n.setError(gx.text.format(gx.getMessage("GXSPC_OutOfRange"),gx.getMessage("Calificacion Fecha Hora"),"","","","","","","",""));this.AnyError=gx.num.trunc(1,0)}catch(t){}}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.e121d2_client=function(){return this.executeServerEvent("AFTER TRN",!0,null,!1,!1)};this.e131d59_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e141d59_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];n=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,13,14,15,16,17,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52];this.GXLastCtrlId=52;this.DVPANEL_TABLEATTRIBUTESContainer=gx.uc.getNew(this,18,0,"BootstrapPanel","DVPANEL_TABLEATTRIBUTESContainer","Dvpanel_tableattributes","DVPANEL_TABLEATTRIBUTES");t=this.DVPANEL_TABLEATTRIBUTESContainer;t.setProp("Class","Class","","char");t.setProp("Enabled","Enabled",!0,"boolean");t.setProp("Width","Width","100%","str");t.setProp("Height","Height","100","str");t.setProp("AutoWidth","Autowidth",!1,"bool");t.setProp("AutoHeight","Autoheight",!0,"bool");t.setProp("Cls","Cls","PanelFilled Panel_BaseColor","str");t.setProp("ShowHeader","Showheader",!0,"bool");t.setProp("Title","Title",gx.getMessage("WWP_TemplateDataPanelTitle"),"str");t.setProp("Collapsible","Collapsible",!1,"bool");t.setProp("Collapsed","Collapsed",!1,"bool");t.setProp("ShowCollapseIcon","Showcollapseicon",!1,"bool");t.setProp("IconPosition","Iconposition","Right","str");t.setProp("AutoScroll","Autoscroll",!1,"bool");t.setProp("Visible","Visible",!0,"bool");t.setProp("Gx Control Type","Gxcontroltype","","int");t.setC2ShowFunction(function(n){n.show()});this.setUserControl(t);n[2]={id:2,fld:"",grid:0};n[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};n[4]={id:4,fld:"",grid:0};n[5]={id:5,fld:"",grid:0};n[6]={id:6,fld:"TABLEMAIN",grid:0};n[7]={id:7,fld:"",grid:0};n[8]={id:8,fld:"",grid:0};n[9]={id:9,fld:"TEXTBLOCKTITLE",format:0,grid:0,ctrltype:"textblock"};n[10]={id:10,fld:"",grid:0};n[11]={id:11,fld:"",grid:0};n[13]={id:13,fld:"",grid:0};n[14]={id:14,fld:"",grid:0};n[15]={id:15,fld:"TABLECONTENT",grid:0};n[16]={id:16,fld:"",grid:0};n[17]={id:17,fld:"",grid:0};n[20]={id:20,fld:"TABLEATTRIBUTES",grid:0};n[21]={id:21,fld:"",grid:0};n[22]={id:22,fld:"",grid:0};n[23]={id:23,fld:"",grid:0};n[24]={id:24,fld:"",grid:0};n[25]={id:25,lvl:0,type:"int",len:11,dec:0,sign:!1,pic:"ZZZZZZZZZZ9",ro:0,grid:0,gxgrid:null,fnc:this.Valid_Calificacionid,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CALIFICACIONID",fmt:0,gxz:"Z298CalificacionId",gxold:"O298CalificacionId",gxvar:"A298CalificacionId",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A298CalificacionId=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z298CalificacionId=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("CALIFICACIONID",gx.O.A298CalificacionId,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A298CalificacionId=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("CALIFICACIONID",gx.thousandSeparator)},nac:function(){return!(0==this.AV7CalificacionId)}};this.declareDomainHdlr(25,function(){});n[26]={id:26,fld:"",grid:0};n[27]={id:27,fld:"",grid:0};n[28]={id:28,fld:"",grid:0};n[29]={id:29,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CALIFICACIONNRO",fmt:0,gxz:"Z299CalificacionNro",gxold:"O299CalificacionNro",gxvar:"A299CalificacionNro",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A299CalificacionNro=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z299CalificacionNro=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("CALIFICACIONNRO",gx.O.A299CalificacionNro,0)},c2v:function(){this.val()!==undefined&&(gx.O.A299CalificacionNro=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("CALIFICACIONNRO",gx.thousandSeparator)},nac:gx.falseFn};n[30]={id:30,fld:"",grid:0};n[31]={id:31,fld:"",grid:0};n[32]={id:32,fld:"",grid:0};n[33]={id:33,fld:"",grid:0};n[34]={id:34,lvl:0,type:"svchar",len:256,dec:0,sign:!1,ro:0,multiline:!0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CALIFICACIONDESC",fmt:0,gxz:"Z300CalificacionDesc",gxold:"O300CalificacionDesc",gxvar:"A300CalificacionDesc",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A300CalificacionDesc=n)},v2z:function(n){n!==undefined&&(gx.O.Z300CalificacionDesc=n)},v2c:function(){gx.fn.setControlValue("CALIFICACIONDESC",gx.O.A300CalificacionDesc,0)},c2v:function(){this.val()!==undefined&&(gx.O.A300CalificacionDesc=this.val())},val:function(){return gx.fn.getControlValue("CALIFICACIONDESC")},nac:gx.falseFn};n[35]={id:35,fld:"",grid:0};n[36]={id:36,fld:"",grid:0};n[37]={id:37,fld:"",grid:0};n[38]={id:38,lvl:0,type:"svchar",len:40,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CALIFICACIONUSUARIO",fmt:0,gxz:"Z301CalificacionUsuario",gxold:"O301CalificacionUsuario",gxvar:"A301CalificacionUsuario",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A301CalificacionUsuario=n)},v2z:function(n){n!==undefined&&(gx.O.Z301CalificacionUsuario=n)},v2c:function(){gx.fn.setControlValue("CALIFICACIONUSUARIO",gx.O.A301CalificacionUsuario,0)},c2v:function(){this.val()!==undefined&&(gx.O.A301CalificacionUsuario=this.val())},val:function(){return gx.fn.getControlValue("CALIFICACIONUSUARIO")},nac:gx.falseFn};n[39]={id:39,fld:"",grid:0};n[40]={id:40,fld:"",grid:0};n[41]={id:41,fld:"",grid:0};n[42]={id:42,fld:"",grid:0};n[43]={id:43,lvl:0,type:"dtime",len:8,dec:5,sign:!1,ro:0,grid:0,gxgrid:null,fnc:this.Valid_Calificacionfechahora,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CALIFICACIONFECHAHORA",fmt:0,gxz:"Z302CalificacionFechaHora",gxold:"O302CalificacionFechaHora",gxvar:"A302CalificacionFechaHora",dp:{f:0,st:!0,wn:!1,mf:!1,pic:"99/99/99 99:99",dec:5},ucs:[],op:[43],ip:[43],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A302CalificacionFechaHora=gx.fn.toDatetimeValue(n))},v2z:function(n){n!==undefined&&(gx.O.Z302CalificacionFechaHora=gx.fn.toDatetimeValue(n))},v2c:function(){gx.fn.setControlValue("CALIFICACIONFECHAHORA",gx.O.A302CalificacionFechaHora,0)},c2v:function(){this.val()!==undefined&&(gx.O.A302CalificacionFechaHora=gx.fn.toDatetimeValue(this.val()))},val:function(){return gx.fn.getDateTimeValue("CALIFICACIONFECHAHORA")},nac:gx.falseFn};n[44]={id:44,fld:"",grid:0};n[45]={id:45,fld:"",grid:0};n[46]={id:46,fld:"",grid:0};n[47]={id:47,fld:"",grid:0};n[48]={id:48,fld:"BTNTRN_ENTER",grid:0,evt:"e131d59_client",std:"ENTER"};n[49]={id:49,fld:"",grid:0};n[50]={id:50,fld:"BTNTRN_CANCEL",grid:0,evt:"e141d59_client"};n[51]={id:51,fld:"",grid:0};n[52]={id:52,fld:"BTNTRN_DELETE",grid:0,evt:"e151d59_client",std:"DELETE"};this.A298CalificacionId=0;this.Z298CalificacionId=0;this.O298CalificacionId=0;this.A299CalificacionNro=0;this.Z299CalificacionNro=0;this.O299CalificacionNro=0;this.A300CalificacionDesc="";this.Z300CalificacionDesc="";this.O300CalificacionDesc="";this.A301CalificacionUsuario="";this.Z301CalificacionUsuario="";this.O301CalificacionUsuario="";this.A302CalificacionFechaHora=gx.date.nullDate();this.Z302CalificacionFechaHora=gx.date.nullDate();this.O302CalificacionFechaHora=gx.date.nullDate();this.AV8WWPContext={UserId:0,UserName:""};this.AV11TrnContext={CallerObject:"",CallerOnDelete:!1,CallerURL:"",TransactionName:"",Attributes:[]};this.AV7CalificacionId=0;this.AV12WebSession={};this.A298CalificacionId=0;this.AV13Pgmname="";this.A299CalificacionNro=0;this.A300CalificacionDesc="";this.A301CalificacionUsuario="";this.A302CalificacionFechaHora=gx.date.nullDate();this.Gx_mode="";this.Events={e121d2_client:["AFTER TRN",!0],e131d59_client:["ENTER",!0],e141d59_client:["CANCEL",!0]};this.EvtParms.ENTER=[[{postForm:!0},{av:"Gx_mode",fld:"vMODE",pic:"@!",hsh:!0},{av:"AV7CalificacionId",fld:"vCALIFICACIONID",pic:"ZZZZZZZZZZ9",hsh:!0}],[]];this.EvtParms.REFRESH=[[{av:"Gx_mode",fld:"vMODE",pic:"@!",hsh:!0},{av:"AV11TrnContext",fld:"vTRNCONTEXT",pic:"",hsh:!0},{av:"AV7CalificacionId",fld:"vCALIFICACIONID",pic:"ZZZZZZZZZZ9",hsh:!0}],[]];this.EvtParms["AFTER TRN"]=[[{av:"Gx_mode",fld:"vMODE",pic:"@!",hsh:!0},{av:"AV11TrnContext",fld:"vTRNCONTEXT",pic:"",hsh:!0}],[]];this.EvtParms.VALID_CALIFICACIONID=[[],[]];this.EvtParms.VALID_CALIFICACIONFECHAHORA=[[{av:"A302CalificacionFechaHora",fld:"CALIFICACIONFECHAHORA",pic:"99/99/99 99:99"}],[{av:"A302CalificacionFechaHora",fld:"CALIFICACIONFECHAHORA",pic:"99/99/99 99:99"}]];this.EnterCtrl=["BTNTRN_ENTER"];this.setVCMap("AV7CalificacionId","vCALIFICACIONID",0,"int",11,0);this.setVCMap("AV13Pgmname","vPGMNAME",0,"char",129,0);this.setVCMap("Gx_mode","vMODE",0,"char",3,0);this.setVCMap("AV11TrnContext","vTRNCONTEXT",0,"WWPBaseObjectsWWPTransactionContext",0,0);this.Initialize()});gx.wi(function(){gx.createParentObj(this.calificacion)})