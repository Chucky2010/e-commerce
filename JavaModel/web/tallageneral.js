gx.evt.autoSkip=!1;gx.define("tallageneral",!0,function(n){this.ServerClass="tallageneral";this.PackageName="com.mujermorena";this.ServerFullClass="com.mujermorena.tallageneral";this.setObjectType("web");this.setCmpContext(n);this.ReadonlyForm=!0;this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.AV12IsAuthorized_Update=gx.fn.getControlValue("vISAUTHORIZED_UPDATE");this.AV13IsAuthorized_Delete=gx.fn.getControlValue("vISAUTHORIZED_DELETE");this.AV13IsAuthorized_Delete=gx.fn.getControlValue("vISAUTHORIZED_DELETE");this.AV12IsAuthorized_Update=gx.fn.getControlValue("vISAUTHORIZED_UPDATE")};this.Valid_Tallaid=function(){return this.validCliEvt("Valid_Tallaid",0,function(){try{var n=gx.util.balloon.getNew("TALLAID");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.e116m1_client=function(){return this.clearMessages(),this.AV12IsAuthorized_Update?this.call("com.mujermorena.talla",["UPD",this.A286TallaID],null,["Mode","TallaID"]):(this.addMessage(gx.getMessage("WWP_ActionNoLongerAvailable")),gx.fn.setCtrlProperty("BTNUPDATE","Visible",!1)),this.refreshOutputs([{ctrl:"BTNUPDATE",prop:"Visible"}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e126m1_client=function(){return this.clearMessages(),this.AV13IsAuthorized_Delete?this.call("com.mujermorena.talla",["DLT",this.A286TallaID],null,["Mode","TallaID"]):(this.addMessage(gx.getMessage("WWP_ActionNoLongerAvailable")),gx.fn.setCtrlProperty("BTNDELETE","Visible",!1)),this.refreshOutputs([{ctrl:"BTNDELETE",prop:"Visible"}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e156m2_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e166m2_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];var t=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30];this.GXLastCtrlId=30;t[2]={id:2,fld:"",grid:0};t[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};t[4]={id:4,fld:"",grid:0};t[5]={id:5,fld:"",grid:0};t[6]={id:6,fld:"TABLE",grid:0};t[7]={id:7,fld:"",grid:0};t[8]={id:8,fld:"",grid:0};t[9]={id:9,fld:"TRANSACTIONDETAIL_TABLEATTRIBUTES",grid:0};t[10]={id:10,fld:"",grid:0};t[11]={id:11,fld:"",grid:0};t[12]={id:12,fld:"",grid:0};t[13]={id:13,fld:"",grid:0};t[14]={id:14,lvl:0,type:"int",len:11,dec:0,sign:!1,pic:"ZZZZZZZZZZ9",ro:1,grid:0,gxgrid:null,fnc:this.Valid_Tallaid,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"TALLAID",fmt:0,gxz:"Z286TallaID",gxold:"O286TallaID",gxvar:"A286TallaID",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A286TallaID=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z286TallaID=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("TALLAID",gx.O.A286TallaID,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A286TallaID=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("TALLAID",gx.thousandSeparator)},nac:gx.falseFn};this.declareDomainHdlr(14,function(){});t[15]={id:15,fld:"",grid:0};t[16]={id:16,fld:"",grid:0};t[17]={id:17,fld:"",grid:0};t[18]={id:18,lvl:0,type:"char",len:80,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"TALLANOMBRE",fmt:0,gxz:"Z287TallaNombre",gxold:"O287TallaNombre",gxvar:"A287TallaNombre",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A287TallaNombre=n)},v2z:function(n){n!==undefined&&(gx.O.Z287TallaNombre=n)},v2c:function(){gx.fn.setControlValue("TALLANOMBRE",gx.O.A287TallaNombre,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A287TallaNombre=this.val())},val:function(){return gx.fn.getControlValue("TALLANOMBRE")},nac:gx.falseFn};this.declareDomainHdlr(18,function(){});t[19]={id:19,fld:"",grid:0};t[20]={id:20,fld:"",grid:0};t[21]={id:21,fld:"",grid:0};t[22]={id:22,fld:"",grid:0};t[23]={id:23,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"TALLANUMERO",fmt:0,gxz:"Z288TallaNumero",gxold:"O288TallaNumero",gxvar:"A288TallaNumero",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A288TallaNumero=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z288TallaNumero=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("TALLANUMERO",gx.O.A288TallaNumero,0)},c2v:function(){this.val()!==undefined&&(gx.O.A288TallaNumero=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("TALLANUMERO",gx.thousandSeparator)},nac:gx.falseFn};t[24]={id:24,fld:"",grid:0};t[25]={id:25,fld:"",grid:0};t[26]={id:26,fld:"",grid:0};t[27]={id:27,fld:"",grid:0};t[28]={id:28,fld:"BTNUPDATE",grid:0,evt:"e116m1_client"};t[29]={id:29,fld:"",grid:0};t[30]={id:30,fld:"BTNDELETE",grid:0,evt:"e126m1_client"};this.A286TallaID=0;this.Z286TallaID=0;this.O286TallaID=0;this.A287TallaNombre="";this.Z287TallaNombre="";this.O287TallaNombre="";this.A288TallaNumero=0;this.Z288TallaNumero=0;this.O288TallaNumero=0;this.A286TallaID=0;this.A287TallaNombre="";this.A288TallaNumero=0;this.AV12IsAuthorized_Update=!1;this.AV13IsAuthorized_Delete=!1;this.Events={e156m2_client:["ENTER",!0],e166m2_client:["CANCEL",!0],e116m1_client:["'DOUPDATE'",!1],e126m1_client:["'DODELETE'",!1]};this.EvtParms.REFRESH=[[{av:"A286TallaID",fld:"TALLAID",pic:"ZZZZZZZZZZ9"},{av:"AV12IsAuthorized_Update",fld:"vISAUTHORIZED_UPDATE",pic:"",hsh:!0},{av:"AV13IsAuthorized_Delete",fld:"vISAUTHORIZED_DELETE",pic:"",hsh:!0}],[]];this.EvtParms["'DOUPDATE'"]=[[{av:"AV12IsAuthorized_Update",fld:"vISAUTHORIZED_UPDATE",pic:"",hsh:!0},{av:"A286TallaID",fld:"TALLAID",pic:"ZZZZZZZZZZ9"}],[{ctrl:"BTNUPDATE",prop:"Visible"}]];this.EvtParms["'DODELETE'"]=[[{av:"AV13IsAuthorized_Delete",fld:"vISAUTHORIZED_DELETE",pic:"",hsh:!0},{av:"A286TallaID",fld:"TALLAID",pic:"ZZZZZZZZZZ9"}],[{ctrl:"BTNDELETE",prop:"Visible"}]];this.EvtParms.ENTER=[[],[]];this.EvtParms.VALID_TALLAID=[[],[]];this.setVCMap("AV12IsAuthorized_Update","vISAUTHORIZED_UPDATE",0,"boolean",4,0);this.setVCMap("AV13IsAuthorized_Delete","vISAUTHORIZED_DELETE",0,"boolean",4,0);this.setVCMap("AV13IsAuthorized_Delete","vISAUTHORIZED_DELETE",0,"boolean",4,0);this.setVCMap("AV12IsAuthorized_Update","vISAUTHORIZED_UPDATE",0,"boolean",4,0);this.Initialize()})