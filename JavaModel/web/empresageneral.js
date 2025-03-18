gx.evt.autoSkip=!1;gx.define("empresageneral",!0,function(n){this.ServerClass="empresageneral";this.PackageName="com.mujermorena";this.ServerFullClass="com.mujermorena.empresageneral";this.setObjectType("web");this.setCmpContext(n);this.ReadonlyForm=!0;this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.AV12IsAuthorized_Update=gx.fn.getControlValue("vISAUTHORIZED_UPDATE");this.AV13IsAuthorized_Delete=gx.fn.getControlValue("vISAUTHORIZED_DELETE");this.AV13IsAuthorized_Delete=gx.fn.getControlValue("vISAUTHORIZED_DELETE");this.AV12IsAuthorized_Update=gx.fn.getControlValue("vISAUTHORIZED_UPDATE")};this.Valid_Empresaid=function(){return this.validCliEvt("Valid_Empresaid",0,function(){try{var n=gx.util.balloon.getNew("EMPRESAID");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.e115n1_client=function(){return this.clearMessages(),this.AV12IsAuthorized_Update?this.call("com.mujermorena.empresa",["UPD",this.A28EmpresaId],null,["Mode","EmpresaId"]):(this.addMessage(gx.getMessage("WWP_ActionNoLongerAvailable")),gx.fn.setCtrlProperty("BTNUPDATE","Visible",!1)),this.refreshOutputs([{ctrl:"BTNUPDATE",prop:"Visible"}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e125n1_client=function(){return this.clearMessages(),this.AV13IsAuthorized_Delete?this.call("com.mujermorena.empresa",["DLT",this.A28EmpresaId],null,["Mode","EmpresaId"]):(this.addMessage(gx.getMessage("WWP_ActionNoLongerAvailable")),gx.fn.setCtrlProperty("BTNDELETE","Visible",!1)),this.refreshOutputs([{ctrl:"BTNDELETE",prop:"Visible"}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e155n2_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e165n2_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];var t=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43];this.GXLastCtrlId=43;t[2]={id:2,fld:"",grid:0};t[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};t[4]={id:4,fld:"",grid:0};t[5]={id:5,fld:"",grid:0};t[6]={id:6,fld:"TABLE",grid:0};t[7]={id:7,fld:"",grid:0};t[8]={id:8,fld:"",grid:0};t[9]={id:9,fld:"TRANSACTIONDETAIL_TABLEATTRIBUTES",grid:0};t[10]={id:10,fld:"",grid:0};t[11]={id:11,fld:"",grid:0};t[12]={id:12,fld:"",grid:0};t[13]={id:13,fld:"",grid:0};t[14]={id:14,lvl:0,type:"int",len:11,dec:0,sign:!1,pic:"ZZZZZZZZZZ9",ro:1,grid:0,gxgrid:null,fnc:this.Valid_Empresaid,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"EMPRESAID",fmt:0,gxz:"Z28EmpresaId",gxold:"O28EmpresaId",gxvar:"A28EmpresaId",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A28EmpresaId=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z28EmpresaId=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("EMPRESAID",gx.O.A28EmpresaId,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A28EmpresaId=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("EMPRESAID",gx.thousandSeparator)},nac:gx.falseFn};this.declareDomainHdlr(14,function(){});t[15]={id:15,fld:"",grid:0};t[16]={id:16,fld:"",grid:0};t[17]={id:17,fld:"",grid:0};t[18]={id:18,lvl:0,type:"char",len:80,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"EMPRESANOMBRE",fmt:0,gxz:"Z121EmpresaNombre",gxold:"O121EmpresaNombre",gxvar:"A121EmpresaNombre",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A121EmpresaNombre=n)},v2z:function(n){n!==undefined&&(gx.O.Z121EmpresaNombre=n)},v2c:function(){gx.fn.setControlValue("EMPRESANOMBRE",gx.O.A121EmpresaNombre,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A121EmpresaNombre=this.val())},val:function(){return gx.fn.getControlValue("EMPRESANOMBRE")},nac:gx.falseFn};this.declareDomainHdlr(18,function(){});t[19]={id:19,fld:"",grid:0};t[20]={id:20,fld:"",grid:0};t[21]={id:21,fld:"",grid:0};t[22]={id:22,fld:"",grid:0};t[23]={id:23,lvl:0,type:"svchar",len:256,dec:0,sign:!1,ro:1,multiline:!0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"EMPRESADIRECCION",fmt:0,gxz:"Z122EmpresaDireccion",gxold:"O122EmpresaDireccion",gxvar:"A122EmpresaDireccion",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A122EmpresaDireccion=n)},v2z:function(n){n!==undefined&&(gx.O.Z122EmpresaDireccion=n)},v2c:function(){gx.fn.setControlValue("EMPRESADIRECCION",gx.O.A122EmpresaDireccion,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A122EmpresaDireccion=this.val())},val:function(){return gx.fn.getControlValue("EMPRESADIRECCION")},nac:gx.falseFn};this.declareDomainHdlr(23,function(){});t[24]={id:24,fld:"",grid:0};t[25]={id:25,fld:"",grid:0};t[26]={id:26,fld:"",grid:0};t[27]={id:27,lvl:0,type:"svchar",len:10,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"EMPRESARUC",fmt:0,gxz:"Z123EmpresaRuc",gxold:"O123EmpresaRuc",gxvar:"A123EmpresaRuc",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A123EmpresaRuc=n)},v2z:function(n){n!==undefined&&(gx.O.Z123EmpresaRuc=n)},v2c:function(){gx.fn.setControlValue("EMPRESARUC",gx.O.A123EmpresaRuc,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A123EmpresaRuc=this.val())},val:function(){return gx.fn.getControlValue("EMPRESARUC")},nac:gx.falseFn};this.declareDomainHdlr(27,function(){});t[28]={id:28,fld:"",grid:0};t[29]={id:29,fld:"",grid:0};t[30]={id:30,fld:"",grid:0};t[31]={id:31,fld:"",grid:0};t[32]={id:32,lvl:0,type:"svchar",len:100,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"EMPRESAEMAIL",fmt:0,gxz:"Z124EmpresaEmail",gxold:"O124EmpresaEmail",gxvar:"A124EmpresaEmail",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A124EmpresaEmail=n)},v2z:function(n){n!==undefined&&(gx.O.Z124EmpresaEmail=n)},v2c:function(){gx.fn.setControlValue("EMPRESAEMAIL",gx.O.A124EmpresaEmail,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A124EmpresaEmail=this.val())},val:function(){return gx.fn.getControlValue("EMPRESAEMAIL")},nac:gx.falseFn};this.declareDomainHdlr(32,function(){gx.fn.setCtrlProperty("EMPRESAEMAIL","Link",gx.fn.getCtrlProperty("EMPRESAEMAIL","Enabled")?"":"mailto:"+this.A124EmpresaEmail)});t[33]={id:33,fld:"",grid:0};t[34]={id:34,fld:"",grid:0};t[35]={id:35,fld:"",grid:0};t[36]={id:36,lvl:0,type:"char",len:25,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"EMPRESATELEFONO",fmt:0,gxz:"Z129EmpresaTelefono",gxold:"O129EmpresaTelefono",gxvar:"A129EmpresaTelefono",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A129EmpresaTelefono=n)},v2z:function(n){n!==undefined&&(gx.O.Z129EmpresaTelefono=n)},v2c:function(){gx.fn.setControlValue("EMPRESATELEFONO",gx.O.A129EmpresaTelefono,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A129EmpresaTelefono=this.val())},val:function(){return gx.fn.getControlValue("EMPRESATELEFONO")},nac:gx.falseFn};this.declareDomainHdlr(36,function(){});t[37]={id:37,fld:"",grid:0};t[38]={id:38,fld:"",grid:0};t[39]={id:39,fld:"",grid:0};t[40]={id:40,fld:"",grid:0};t[41]={id:41,fld:"BTNUPDATE",grid:0,evt:"e115n1_client"};t[42]={id:42,fld:"",grid:0};t[43]={id:43,fld:"BTNDELETE",grid:0,evt:"e125n1_client"};this.A28EmpresaId=0;this.Z28EmpresaId=0;this.O28EmpresaId=0;this.A121EmpresaNombre="";this.Z121EmpresaNombre="";this.O121EmpresaNombre="";this.A122EmpresaDireccion="";this.Z122EmpresaDireccion="";this.O122EmpresaDireccion="";this.A123EmpresaRuc="";this.Z123EmpresaRuc="";this.O123EmpresaRuc="";this.A124EmpresaEmail="";this.Z124EmpresaEmail="";this.O124EmpresaEmail="";this.A129EmpresaTelefono="";this.Z129EmpresaTelefono="";this.O129EmpresaTelefono="";this.A28EmpresaId=0;this.A121EmpresaNombre="";this.A122EmpresaDireccion="";this.A123EmpresaRuc="";this.A124EmpresaEmail="";this.A129EmpresaTelefono="";this.AV12IsAuthorized_Update=!1;this.AV13IsAuthorized_Delete=!1;this.Events={e155n2_client:["ENTER",!0],e165n2_client:["CANCEL",!0],e115n1_client:["'DOUPDATE'",!1],e125n1_client:["'DODELETE'",!1]};this.EvtParms.REFRESH=[[{av:"A28EmpresaId",fld:"EMPRESAID",pic:"ZZZZZZZZZZ9"},{av:"AV12IsAuthorized_Update",fld:"vISAUTHORIZED_UPDATE",pic:"",hsh:!0},{av:"AV13IsAuthorized_Delete",fld:"vISAUTHORIZED_DELETE",pic:"",hsh:!0}],[]];this.EvtParms["'DOUPDATE'"]=[[{av:"AV12IsAuthorized_Update",fld:"vISAUTHORIZED_UPDATE",pic:"",hsh:!0},{av:"A28EmpresaId",fld:"EMPRESAID",pic:"ZZZZZZZZZZ9"}],[{ctrl:"BTNUPDATE",prop:"Visible"}]];this.EvtParms["'DODELETE'"]=[[{av:"AV13IsAuthorized_Delete",fld:"vISAUTHORIZED_DELETE",pic:"",hsh:!0},{av:"A28EmpresaId",fld:"EMPRESAID",pic:"ZZZZZZZZZZ9"}],[{ctrl:"BTNDELETE",prop:"Visible"}]];this.EvtParms.ENTER=[[],[]];this.EvtParms.VALID_EMPRESAID=[[],[]];this.setVCMap("AV12IsAuthorized_Update","vISAUTHORIZED_UPDATE",0,"boolean",4,0);this.setVCMap("AV13IsAuthorized_Delete","vISAUTHORIZED_DELETE",0,"boolean",4,0);this.setVCMap("AV13IsAuthorized_Delete","vISAUTHORIZED_DELETE",0,"boolean",4,0);this.setVCMap("AV12IsAuthorized_Update","vISAUTHORIZED_UPDATE",0,"boolean",4,0);this.Initialize()})