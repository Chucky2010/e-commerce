gx.evt.autoSkip=!1;gx.define("ciudadgeneral",!0,function(n){this.ServerClass="ciudadgeneral";this.PackageName="com.mujermorena";this.ServerFullClass="com.mujermorena.ciudadgeneral";this.setObjectType("web");this.setCmpContext(n);this.ReadonlyForm=!0;this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.AV12IsAuthorized_Update=gx.fn.getControlValue("vISAUTHORIZED_UPDATE");this.AV13IsAuthorized_Delete=gx.fn.getControlValue("vISAUTHORIZED_DELETE");this.AV13IsAuthorized_Delete=gx.fn.getControlValue("vISAUTHORIZED_DELETE");this.AV12IsAuthorized_Update=gx.fn.getControlValue("vISAUTHORIZED_UPDATE")};this.Valid_Ciudadid=function(){return this.validCliEvt("Valid_Ciudadid",0,function(){try{var n=gx.util.balloon.getNew("CIUDADID");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Departamentoid=function(){return this.validCliEvt("Valid_Departamentoid",0,function(){try{var n=gx.util.balloon.getNew("DEPARTAMENTOID");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.e11441_client=function(){return this.clearMessages(),this.AV12IsAuthorized_Update?this.call("com.mujermorena.ciudad",["UPD",this.A7CiudadId],null,["Mode","CiudadId"]):(this.addMessage(gx.getMessage("WWP_ActionNoLongerAvailable")),gx.fn.setCtrlProperty("BTNUPDATE","Visible",!1)),this.refreshOutputs([{ctrl:"BTNUPDATE",prop:"Visible"}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e12441_client=function(){return this.clearMessages(),this.AV13IsAuthorized_Delete?this.call("com.mujermorena.ciudad",["DLT",this.A7CiudadId],null,["Mode","CiudadId"]):(this.addMessage(gx.getMessage("WWP_ActionNoLongerAvailable")),gx.fn.setCtrlProperty("BTNDELETE","Visible",!1)),this.refreshOutputs([{ctrl:"BTNDELETE",prop:"Visible"}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e15442_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e16442_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];var t=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39];this.GXLastCtrlId=39;t[2]={id:2,fld:"",grid:0};t[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};t[4]={id:4,fld:"",grid:0};t[5]={id:5,fld:"",grid:0};t[6]={id:6,fld:"TABLE",grid:0};t[7]={id:7,fld:"",grid:0};t[8]={id:8,fld:"",grid:0};t[9]={id:9,fld:"TRANSACTIONDETAIL_TABLEATTRIBUTES",grid:0};t[10]={id:10,fld:"",grid:0};t[11]={id:11,fld:"",grid:0};t[12]={id:12,fld:"",grid:0};t[13]={id:13,fld:"",grid:0};t[14]={id:14,lvl:0,type:"int",len:11,dec:0,sign:!1,pic:"ZZZZZZZZZZ9",ro:1,grid:0,gxgrid:null,fnc:this.Valid_Ciudadid,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CIUDADID",fmt:0,gxz:"Z7CiudadId",gxold:"O7CiudadId",gxvar:"A7CiudadId",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A7CiudadId=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z7CiudadId=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("CIUDADID",gx.O.A7CiudadId,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A7CiudadId=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("CIUDADID",gx.thousandSeparator)},nac:gx.falseFn};this.declareDomainHdlr(14,function(){});t[15]={id:15,fld:"",grid:0};t[16]={id:16,fld:"",grid:0};t[17]={id:17,fld:"",grid:0};t[18]={id:18,lvl:0,type:"char",len:80,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CIUDADNOMBRE",fmt:0,gxz:"Z62CiudadNombre",gxold:"O62CiudadNombre",gxvar:"A62CiudadNombre",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A62CiudadNombre=n)},v2z:function(n){n!==undefined&&(gx.O.Z62CiudadNombre=n)},v2c:function(){gx.fn.setControlValue("CIUDADNOMBRE",gx.O.A62CiudadNombre,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A62CiudadNombre=this.val())},val:function(){return gx.fn.getControlValue("CIUDADNOMBRE")},nac:gx.falseFn};this.declareDomainHdlr(18,function(){});t[19]={id:19,fld:"",grid:0};t[20]={id:20,fld:"",grid:0};t[21]={id:21,fld:"",grid:0};t[22]={id:22,fld:"",grid:0};t[23]={id:23,lvl:0,type:"int",len:11,dec:0,sign:!1,pic:"ZZZZZZZZZZ9",ro:1,grid:0,gxgrid:null,fnc:this.Valid_Departamentoid,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"DEPARTAMENTOID",fmt:0,gxz:"Z6DepartamentoId",gxold:"O6DepartamentoId",gxvar:"A6DepartamentoId",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A6DepartamentoId=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z6DepartamentoId=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("DEPARTAMENTOID",gx.O.A6DepartamentoId,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A6DepartamentoId=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("DEPARTAMENTOID",gx.thousandSeparator)},nac:gx.falseFn};this.declareDomainHdlr(23,function(){});t[24]={id:24,fld:"",grid:0};t[25]={id:25,fld:"",grid:0};t[26]={id:26,fld:"",grid:0};t[27]={id:27,lvl:0,type:"char",len:80,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"DEPARTAMENTONOMBRE",fmt:0,gxz:"Z61DepartamentoNombre",gxold:"O61DepartamentoNombre",gxvar:"A61DepartamentoNombre",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A61DepartamentoNombre=n)},v2z:function(n){n!==undefined&&(gx.O.Z61DepartamentoNombre=n)},v2c:function(){gx.fn.setControlValue("DEPARTAMENTONOMBRE",gx.O.A61DepartamentoNombre,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A61DepartamentoNombre=this.val())},val:function(){return gx.fn.getControlValue("DEPARTAMENTONOMBRE")},nac:gx.falseFn};this.declareDomainHdlr(27,function(){});t[28]={id:28,fld:"",grid:0};t[29]={id:29,fld:"",grid:0};t[30]={id:30,fld:"",grid:0};t[31]={id:31,fld:"",grid:0};t[32]={id:32,lvl:0,type:"char",len:80,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"PAISNOMBRE",fmt:0,gxz:"Z60PaisNombre",gxold:"O60PaisNombre",gxvar:"A60PaisNombre",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A60PaisNombre=n)},v2z:function(n){n!==undefined&&(gx.O.Z60PaisNombre=n)},v2c:function(){gx.fn.setControlValue("PAISNOMBRE",gx.O.A60PaisNombre,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A60PaisNombre=this.val())},val:function(){return gx.fn.getControlValue("PAISNOMBRE")},nac:gx.falseFn};this.declareDomainHdlr(32,function(){});t[33]={id:33,fld:"",grid:0};t[34]={id:34,fld:"",grid:0};t[35]={id:35,fld:"",grid:0};t[36]={id:36,fld:"",grid:0};t[37]={id:37,fld:"BTNUPDATE",grid:0,evt:"e11441_client"};t[38]={id:38,fld:"",grid:0};t[39]={id:39,fld:"BTNDELETE",grid:0,evt:"e12441_client"};this.A7CiudadId=0;this.Z7CiudadId=0;this.O7CiudadId=0;this.A62CiudadNombre="";this.Z62CiudadNombre="";this.O62CiudadNombre="";this.A6DepartamentoId=0;this.Z6DepartamentoId=0;this.O6DepartamentoId=0;this.A61DepartamentoNombre="";this.Z61DepartamentoNombre="";this.O61DepartamentoNombre="";this.A60PaisNombre="";this.Z60PaisNombre="";this.O60PaisNombre="";this.A7CiudadId=0;this.A62CiudadNombre="";this.A6DepartamentoId=0;this.A61DepartamentoNombre="";this.A60PaisNombre="";this.A5PaisId=0;this.AV12IsAuthorized_Update=!1;this.AV13IsAuthorized_Delete=!1;this.Events={e15442_client:["ENTER",!0],e16442_client:["CANCEL",!0],e11441_client:["'DOUPDATE'",!1],e12441_client:["'DODELETE'",!1]};this.EvtParms.REFRESH=[[{av:"A7CiudadId",fld:"CIUDADID",pic:"ZZZZZZZZZZ9"},{av:"AV12IsAuthorized_Update",fld:"vISAUTHORIZED_UPDATE",pic:"",hsh:!0},{av:"AV13IsAuthorized_Delete",fld:"vISAUTHORIZED_DELETE",pic:"",hsh:!0},{av:"A6DepartamentoId",fld:"DEPARTAMENTOID",pic:"ZZZZZZZZZZ9"}],[]];this.EvtParms["'DOUPDATE'"]=[[{av:"AV12IsAuthorized_Update",fld:"vISAUTHORIZED_UPDATE",pic:"",hsh:!0},{av:"A7CiudadId",fld:"CIUDADID",pic:"ZZZZZZZZZZ9"}],[{ctrl:"BTNUPDATE",prop:"Visible"}]];this.EvtParms["'DODELETE'"]=[[{av:"AV13IsAuthorized_Delete",fld:"vISAUTHORIZED_DELETE",pic:"",hsh:!0},{av:"A7CiudadId",fld:"CIUDADID",pic:"ZZZZZZZZZZ9"}],[{ctrl:"BTNDELETE",prop:"Visible"}]];this.EvtParms.ENTER=[[],[]];this.EvtParms.VALID_CIUDADID=[[],[]];this.EvtParms.VALID_DEPARTAMENTOID=[[],[]];this.setVCMap("AV12IsAuthorized_Update","vISAUTHORIZED_UPDATE",0,"boolean",4,0);this.setVCMap("AV13IsAuthorized_Delete","vISAUTHORIZED_DELETE",0,"boolean",4,0);this.setVCMap("AV13IsAuthorized_Delete","vISAUTHORIZED_DELETE",0,"boolean",4,0);this.setVCMap("AV12IsAuthorized_Update","vISAUTHORIZED_UPDATE",0,"boolean",4,0);this.Initialize()})