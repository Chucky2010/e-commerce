/*!   GeneXus Java 17_0_11-163677 on August 31, 2022 2:8:8.52
*/
gx.evt.autoSkip=!1;gx.define("gam_userroleselect",!1,function(){var n,t;this.ServerClass="gam_userroleselect";this.PackageName="genexus.security.backend";this.ServerFullClass="genexus.security.backend.gam_userroleselect";this.setObjectType("web");this.setOnAjaxSessionTimeout("Warn");this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.SetStandaloneVars=function(){this.AV23UserId=gx.fn.getControlValue("vUSERID");this.AV21SearchFilter=gx.fn.getControlValue("vSEARCHFILTER");this.AV17isOK=gx.fn.getControlValue("vISOK");this.AV23UserId=gx.fn.getControlValue("vUSERID");this.AV21SearchFilter=gx.fn.getControlValue("vSEARCHFILTER")};this.e112f1_client=function(){return this.clearMessages(),gx.text.compare(gx.fn.getCtrlProperty("FILTERSCONTAINER","Class"),"AdvancedContainer")==0?(gx.fn.setCtrlProperty("FILTERSCONTAINER","Class","AdvancedContainer AdvancedContainerVisible"),gx.fn.setCtrlProperty("HIDE","Caption",gx.getMessage("HIDE FILTERS")),gx.fn.setCtrlProperty("HIDE","Class","HideFiltersButton"),gx.fn.setCtrlProperty("GRIDCELL","Class","WWGridCell")):(gx.fn.setCtrlProperty("FILTERSCONTAINER","Class","AdvancedContainer"),gx.fn.setCtrlProperty("HIDE","Caption",gx.getMessage("SHOW FILTERS")),gx.fn.setCtrlProperty("HIDE","Class","ShowFiltersButton"),gx.fn.setCtrlProperty("GRIDCELL","Class","WWGridCellExpanded")),this.refreshOutputs([{av:'gx.fn.getCtrlProperty("FILTERSCONTAINER","Class")',ctrl:"FILTERSCONTAINER",prop:"Class"},{ctrl:"HIDE",prop:"Caption"},{ctrl:"HIDE",prop:"Class"},{av:'gx.fn.getCtrlProperty("GRIDCELL","Class")',ctrl:"GRIDCELL",prop:"Class"}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e122f1_client=function(){return this.clearMessages(),this.AV7CurrentPage=gx.num.trunc(1,0),gx.fn.setCtrlProperty("TBFIRST","Class","SelectedPagingText"),gx.fn.setCtrlProperty("TBPREV","Class","SelectedPagingText"),gx.fn.setCtrlProperty("TBFIRST","Enabled",!1),gx.fn.setCtrlProperty("TBPREV","Enabled",!1),this.refreshOutputs([{av:"AV7CurrentPage",fld:"vCURRENTPAGE",pic:"ZZZ9"},{av:'gx.fn.getCtrlProperty("TBFIRST","Class")',ctrl:"TBFIRST",prop:"Class"},{av:'gx.fn.getCtrlProperty("TBPREV","Class")',ctrl:"TBPREV",prop:"Class"},{av:'gx.fn.getCtrlProperty("TBFIRST","Enabled")',ctrl:"TBFIRST",prop:"Enabled"},{av:'gx.fn.getCtrlProperty("TBPREV","Enabled")',ctrl:"TBPREV",prop:"Enabled"}]),this.refreshGrid("Gridww"),this.refreshOutputs([{av:"AV7CurrentPage",fld:"vCURRENTPAGE",pic:"ZZZ9"},{av:'gx.fn.getCtrlProperty("TBFIRST","Class")',ctrl:"TBFIRST",prop:"Class"},{av:'gx.fn.getCtrlProperty("TBPREV","Class")',ctrl:"TBPREV",prop:"Class"},{av:'gx.fn.getCtrlProperty("TBFIRST","Enabled")',ctrl:"TBFIRST",prop:"Enabled"},{av:'gx.fn.getCtrlProperty("TBPREV","Enabled")',ctrl:"TBPREV",prop:"Enabled"}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e132f1_client=function(){return this.clearMessages(),this.AV7CurrentPage>1&&(this.AV7CurrentPage=gx.num.trunc(this.AV7CurrentPage-1,0)),this.AV7CurrentPage==1&&(gx.fn.setCtrlProperty("TBFIRST","Class","SelectedPagingText"),gx.fn.setCtrlProperty("TBPREV","Class","SelectedPagingText"),gx.fn.setCtrlProperty("TBFIRST","Enabled",!1),gx.fn.setCtrlProperty("TBPREV","Enabled",!1)),this.refreshOutputs([{av:"AV7CurrentPage",fld:"vCURRENTPAGE",pic:"ZZZ9"},{av:'gx.fn.getCtrlProperty("TBFIRST","Class")',ctrl:"TBFIRST",prop:"Class"},{av:'gx.fn.getCtrlProperty("TBPREV","Class")',ctrl:"TBPREV",prop:"Class"},{av:'gx.fn.getCtrlProperty("TBFIRST","Enabled")',ctrl:"TBFIRST",prop:"Enabled"},{av:'gx.fn.getCtrlProperty("TBPREV","Enabled")',ctrl:"TBPREV",prop:"Enabled"}]),this.refreshGrid("Gridww"),this.refreshOutputs([{av:"AV7CurrentPage",fld:"vCURRENTPAGE",pic:"ZZZ9"},{av:'gx.fn.getCtrlProperty("TBFIRST","Class")',ctrl:"TBFIRST",prop:"Class"},{av:'gx.fn.getCtrlProperty("TBPREV","Class")',ctrl:"TBPREV",prop:"Class"},{av:'gx.fn.getCtrlProperty("TBFIRST","Enabled")',ctrl:"TBFIRST",prop:"Enabled"},{av:'gx.fn.getCtrlProperty("TBPREV","Enabled")',ctrl:"TBPREV",prop:"Enabled"}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e142f1_client=function(){return this.clearMessages(),this.AV7CurrentPage==1&&(gx.fn.setCtrlProperty("TBFIRST","Class","PagingText"),gx.fn.setCtrlProperty("TBPREV","Class","PagingText"),gx.fn.setCtrlProperty("TBFIRST","Enabled",!0),gx.fn.setCtrlProperty("TBPREV","Enabled",!0)),this.AV7CurrentPage=gx.num.trunc(this.AV7CurrentPage+1,0),this.refreshOutputs([{av:'gx.fn.getCtrlProperty("TBFIRST","Class")',ctrl:"TBFIRST",prop:"Class"},{av:'gx.fn.getCtrlProperty("TBPREV","Class")',ctrl:"TBPREV",prop:"Class"},{av:'gx.fn.getCtrlProperty("TBFIRST","Enabled")',ctrl:"TBFIRST",prop:"Enabled"},{av:'gx.fn.getCtrlProperty("TBPREV","Enabled")',ctrl:"TBPREV",prop:"Enabled"},{av:"AV7CurrentPage",fld:"vCURRENTPAGE",pic:"ZZZ9"}]),this.refreshGrid("Gridww"),this.refreshOutputs([{av:'gx.fn.getCtrlProperty("TBFIRST","Class")',ctrl:"TBFIRST",prop:"Class"},{av:'gx.fn.getCtrlProperty("TBPREV","Class")',ctrl:"TBPREV",prop:"Class"},{av:'gx.fn.getCtrlProperty("TBFIRST","Enabled")',ctrl:"TBFIRST",prop:"Enabled"},{av:'gx.fn.getCtrlProperty("TBPREV","Enabled")',ctrl:"TBPREV",prop:"Enabled"},{av:"AV7CurrentPage",fld:"vCURRENTPAGE",pic:"ZZZ9"}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e152f2_client=function(){return this.executeServerEvent("'ADDSELECTED'",!1,null,!1,!1)};this.e182f2_client=function(){return this.executeServerEvent("'ADDROLE'",!0,arguments[0],!1,!1)};this.e192f2_client=function(){return this.executeServerEvent("ENTER",!0,arguments[0],!1,!1)};this.e202f1_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];n=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,48,49,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72];this.GXLastCtrlId=72;this.GridwwContainer=new gx.grid.grid(this,2,"WbpLvl2",50,"Gridww","Gridww","GridwwContainer",this.CmpContext,this.IsMasterPage,"gam_userroleselect",[],!1,1,!1,!0,0,!1,!1,!1,"",0,"px",0,"px",gx.getMessage("GXM_newrow"),!1,!1,!0,null,null,!1,"",!1,[1,1,1,1],!1,0,!0,!1);t=this.GridwwContainer;t.addCheckBox("Select",51,"vSELECT",gx.getMessage("Select"),"","Select","boolean","true","false",null,!0,!1,0,"px","WWActionColumn");t.addSingleLineEdit("Name",52,"vNAME",gx.getMessage("Role"),"","Name","char",0,"px",254,80,"left",null,[],"Name","Name",!0,0,!1,!1,"Attribute",1,"WWColumn");t.addSingleLineEdit("Id",53,"vID",gx.getMessage("Key Numeric Long"),"","Id","int",0,"px",12,12,"right",null,[],"Id","Id",!1,0,!1,!1,"Attribute",1,"");t.addSingleLineEdit("Btnaddrole",54,"vBTNADDROLE","","","BtnAddRole","char",0,"px",20,20,"left","e182f2_client",[],"Btnaddrole","BtnAddRole",!0,0,!1,!1,"TextActionAttribute TextLikeLink",1,"WWTextActionColumn");this.GridwwContainer.emptyText=gx.getMessage("");this.setGrid(t);n[2]={id:2,fld:"",grid:0};n[3]={id:3,fld:"MAINTABLE",grid:0};n[4]={id:4,fld:"",grid:0};n[5]={id:5,fld:"",grid:0};n[6]={id:6,fld:"TABLE3",grid:0};n[7]={id:7,fld:"",grid:0};n[8]={id:8,fld:"",grid:0};n[9]={id:9,fld:"TABLE5",grid:0};n[10]={id:10,fld:"",grid:0};n[11]={id:11,fld:"",grid:0};n[12]={id:12,fld:"HIDE",grid:0,evt:"e112f1_client"};n[13]={id:13,fld:"",grid:0};n[14]={id:14,fld:"TEXTBLOCK2",format:0,grid:0,ctrltype:"textblock"};n[15]={id:15,fld:"",grid:0};n[16]={id:16,fld:"TABLE1",grid:0};n[17]={id:17,fld:"",grid:0};n[18]={id:18,fld:"",grid:0};n[19]={id:19,fld:"BACK",grid:0,evt:"e202f1_client"};n[20]={id:20,fld:"",grid:0};n[21]={id:21,fld:"ADDSELECTED",grid:0,evt:"e152f2_client"};n[22]={id:22,fld:"",grid:0};n[23]={id:23,fld:"",grid:0};n[24]={id:24,lvl:0,type:"char",len:254,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vFILNAME",fmt:0,gxz:"ZV12FilName",gxold:"OV12FilName",gxvar:"AV12FilName",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV12FilName=n)},v2z:function(n){n!==undefined&&(gx.O.ZV12FilName=n)},v2c:function(){gx.fn.setControlValue("vFILNAME",gx.O.AV12FilName,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.AV12FilName=this.val())},val:function(){return gx.fn.getControlValue("vFILNAME")},nac:gx.falseFn};this.declareDomainHdlr(24,function(){});n[25]={id:25,fld:"",grid:0};n[26]={id:26,fld:"CELLFILTERS",grid:0};n[27]={id:27,fld:"FILTERSCONTAINER",grid:0};n[28]={id:28,fld:"",grid:0};n[29]={id:29,fld:"",grid:0};n[30]={id:30,fld:"TABLE4",grid:0};n[31]={id:31,fld:"",grid:0};n[32]={id:32,fld:"",grid:0};n[33]={id:33,fld:"TEXTBLOCK1",format:0,grid:0,ctrltype:"textblock"};n[34]={id:34,fld:"",grid:0};n[35]={id:35,fld:"",grid:0};n[36]={id:36,fld:"",grid:0};n[37]={id:37,lvl:0,type:"char",len:254,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vFILEXTERNALID",fmt:0,gxz:"ZV11FilExternalId",gxold:"OV11FilExternalId",gxvar:"AV11FilExternalId",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV11FilExternalId=n)},v2z:function(n){n!==undefined&&(gx.O.ZV11FilExternalId=n)},v2c:function(){gx.fn.setControlValue("vFILEXTERNALID",gx.O.AV11FilExternalId,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.AV11FilExternalId=this.val())},val:function(){return gx.fn.getControlValue("vFILEXTERNALID")},nac:gx.falseFn};this.declareDomainHdlr(37,function(){});n[38]={id:38,fld:"GRIDCELL",grid:0};n[39]={id:39,fld:"GRIDTABLE",grid:0};n[40]={id:40,fld:"",grid:0};n[41]={id:41,fld:"",grid:0};n[42]={id:42,fld:"",grid:0};n[43]={id:43,fld:"",grid:0};n[44]={id:44,lvl:0,type:"char",len:120,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vUSERNAME",fmt:0,gxz:"ZV24UserName",gxold:"OV24UserName",gxvar:"AV24UserName",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV24UserName=n)},v2z:function(n){n!==undefined&&(gx.O.ZV24UserName=n)},v2c:function(){gx.fn.setControlValue("vUSERNAME",gx.O.AV24UserName,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.AV24UserName=this.val())},val:function(){return gx.fn.getControlValue("vUSERNAME")},nac:gx.falseFn};this.declareDomainHdlr(44,function(){});n[45]={id:45,fld:"",grid:0};n[46]={id:46,fld:"",grid:0};n[48]={id:48,fld:"",grid:0};n[49]={id:49,fld:"",grid:0};n[51]={id:51,lvl:2,type:"boolean",len:4,dec:0,sign:!1,ro:0,isacc:0,grid:50,gxgrid:this.GridwwContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vSELECT",fmt:0,gxz:"ZV22Select",gxold:"OV22Select",gxvar:"AV22Select",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"checkbox",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.AV22Select=gx.lang.booleanValue(n))},v2z:function(n){n!==undefined&&(gx.O.ZV22Select=gx.lang.booleanValue(n))},v2c:function(n){gx.fn.setGridCheckBoxValue("vSELECT",n||gx.fn.currentGridRowImpl(50),gx.O.AV22Select,!0)},c2v:function(n){this.val(n)!==undefined&&(gx.O.AV22Select=gx.lang.booleanValue(this.val(n)))},val:function(n){return gx.fn.getGridControlValue("vSELECT",n||gx.fn.currentGridRowImpl(50))},nac:gx.falseFn,values:["true","false"]};n[52]={id:52,lvl:2,type:"char",len:254,dec:0,sign:!1,ro:0,isacc:0,grid:50,gxgrid:this.GridwwContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vNAME",fmt:0,gxz:"ZV18Name",gxold:"OV18Name",gxvar:"AV18Name",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.AV18Name=n)},v2z:function(n){n!==undefined&&(gx.O.ZV18Name=n)},v2c:function(n){gx.fn.setGridControlValue("vNAME",n||gx.fn.currentGridRowImpl(50),gx.O.AV18Name,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.AV18Name=this.val(n))},val:function(n){return gx.fn.getGridControlValue("vNAME",n||gx.fn.currentGridRowImpl(50))},nac:gx.falseFn};n[53]={id:53,lvl:2,type:"int",len:12,dec:0,sign:!1,pic:"ZZZZZZZZZZZ9",ro:0,isacc:0,grid:50,gxgrid:this.GridwwContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vID",fmt:0,gxz:"ZV16Id",gxold:"OV16Id",gxvar:"AV16Id",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.AV16Id=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.ZV16Id=gx.num.intval(n))},v2c:function(n){gx.fn.setGridControlValue("vID",n||gx.fn.currentGridRowImpl(50),gx.O.AV16Id,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.AV16Id=gx.num.intval(this.val(n)))},val:function(n){return gx.fn.getGridIntegerValue("vID",n||gx.fn.currentGridRowImpl(50),gx.thousandSeparator)},nac:gx.falseFn};n[54]={id:54,lvl:2,type:"char",len:20,dec:0,sign:!1,ro:0,isacc:0,grid:50,gxgrid:this.GridwwContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vBTNADDROLE",fmt:0,gxz:"ZV5BtnAddRole",gxold:"OV5BtnAddRole",gxvar:"AV5BtnAddRole",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.AV5BtnAddRole=n)},v2z:function(n){n!==undefined&&(gx.O.ZV5BtnAddRole=n)},v2c:function(n){gx.fn.setGridControlValue("vBTNADDROLE",n||gx.fn.currentGridRowImpl(50),gx.O.AV5BtnAddRole,0)},c2v:function(n){this.val(n)!==undefined&&(gx.O.AV5BtnAddRole=this.val(n))},val:function(n){return gx.fn.getGridControlValue("vBTNADDROLE",n||gx.fn.currentGridRowImpl(50))},nac:gx.falseFn,evt:"e182f2_client"};n[55]={id:55,fld:"",grid:0};n[56]={id:56,fld:"",grid:0};n[57]={id:57,fld:"TABLE6",grid:0};n[58]={id:58,fld:"",grid:0};n[59]={id:59,fld:"",grid:0};n[60]={id:60,fld:"TBFIRST",format:0,grid:0,evt:"e122f1_client",ctrltype:"textblock"};n[61]={id:61,fld:"",grid:0};n[62]={id:62,fld:"TB1",format:0,grid:0,ctrltype:"textblock"};n[63]={id:63,fld:"",grid:0};n[64]={id:64,fld:"TBPREV",format:0,grid:0,evt:"e132f1_client",ctrltype:"textblock"};n[65]={id:65,fld:"",grid:0};n[66]={id:66,fld:"TB2",format:0,grid:0,ctrltype:"textblock"};n[67]={id:67,fld:"",grid:0};n[68]={id:68,fld:"TBNEXT",format:0,grid:0,evt:"e142f1_client",ctrltype:"textblock"};n[69]={id:69,fld:"",grid:0};n[70]={id:70,fld:"",grid:0};n[71]={id:71,fld:"",grid:0};n[72]={id:72,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vCURRENTPAGE",fmt:0,gxz:"ZV7CurrentPage",gxold:"OV7CurrentPage",gxvar:"AV7CurrentPage",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV7CurrentPage=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.ZV7CurrentPage=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("vCURRENTPAGE",gx.O.AV7CurrentPage,0)},c2v:function(){this.val()!==undefined&&(gx.O.AV7CurrentPage=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("vCURRENTPAGE",gx.thousandSeparator)},nac:gx.falseFn};this.AV12FilName="";this.ZV12FilName="";this.OV12FilName="";this.AV11FilExternalId="";this.ZV11FilExternalId="";this.OV11FilExternalId="";this.AV24UserName="";this.ZV24UserName="";this.OV24UserName="";this.ZV22Select=!1;this.OV22Select=!1;this.ZV18Name="";this.OV18Name="";this.ZV16Id=0;this.OV16Id=0;this.ZV5BtnAddRole="";this.OV5BtnAddRole="";this.AV7CurrentPage=0;this.ZV7CurrentPage=0;this.OV7CurrentPage=0;this.AV12FilName="";this.AV11FilExternalId="";this.AV24UserName="";this.AV7CurrentPage=0;this.AV23UserId="";this.AV22Select=!1;this.AV18Name="";this.AV16Id=0;this.AV5BtnAddRole="";this.AV21SearchFilter="";this.AV17isOK=!1;this.Events={e152f2_client:["'ADDSELECTED'",!0],e182f2_client:["'ADDROLE'",!0],e192f2_client:["ENTER",!0],e202f1_client:["CANCEL",!0],e112f1_client:["'HIDE'",!1],e122f1_client:["'FIRST'",!1],e132f1_client:["'PREVIOUS'",!1],e142f1_client:["'NEXT'",!1]};this.EvtParms.REFRESH=[[{av:"GRIDWW_nFirstRecordOnPage"},{av:"GRIDWW_nEOF"},{av:"AV12FilName",fld:"vFILNAME",pic:""},{av:"AV11FilExternalId",fld:"vFILEXTERNALID",pic:""},{av:"AV7CurrentPage",fld:"vCURRENTPAGE",pic:"ZZZ9"},{av:"AV21SearchFilter",fld:"vSEARCHFILTER",pic:"",hsh:!0},{av:"AV23UserId",fld:"vUSERID",pic:"",hsh:!0}],[]];this.EvtParms["GRIDWW.LOAD"]=[[{av:"AV23UserId",fld:"vUSERID",pic:"",hsh:!0},{av:"AV12FilName",fld:"vFILNAME",pic:""},{av:"AV21SearchFilter",fld:"vSEARCHFILTER",pic:"",hsh:!0},{av:"AV11FilExternalId",fld:"vFILEXTERNALID",pic:""},{av:"AV7CurrentPage",fld:"vCURRENTPAGE",pic:"ZZZ9"}],[{av:"AV5BtnAddRole",fld:"vBTNADDROLE",pic:""},{av:"AV22Select",fld:"vSELECT",pic:""},{av:"AV16Id",fld:"vID",pic:"ZZZZZZZZZZZ9",hsh:!0},{av:"AV18Name",fld:"vNAME",pic:""},{av:'gx.fn.getCtrlProperty("TBNEXT","Class")',ctrl:"TBNEXT",prop:"Class"}]];this.EvtParms["'ADDSELECTED'"]=[[{av:"GRIDWW_nFirstRecordOnPage"},{av:"GRIDWW_nEOF"},{av:"AV23UserId",fld:"vUSERID",pic:"",hsh:!0},{av:"AV12FilName",fld:"vFILNAME",pic:""},{av:"AV21SearchFilter",fld:"vSEARCHFILTER",pic:"",hsh:!0},{av:"AV11FilExternalId",fld:"vFILEXTERNALID",pic:""},{av:"AV7CurrentPage",fld:"vCURRENTPAGE",pic:"ZZZ9"},{av:"AV22Select",fld:"vSELECT",grid:50,pic:""},{av:"nRC_GXsfl_50",ctrl:"GRIDWW",grid:50,prop:"GridRC",grid:50},{av:"AV16Id",fld:"vID",grid:50,pic:"ZZZZZZZZZZZ9",hsh:!0},{av:"AV17isOK",fld:"vISOK",pic:""}],[{av:"AV17isOK",fld:"vISOK",pic:""}]];this.EvtParms["'ADDROLE'"]=[[{av:"GRIDWW_nFirstRecordOnPage"},{av:"GRIDWW_nEOF"},{av:"AV23UserId",fld:"vUSERID",pic:"",hsh:!0},{av:"AV12FilName",fld:"vFILNAME",pic:""},{av:"AV21SearchFilter",fld:"vSEARCHFILTER",pic:"",hsh:!0},{av:"AV11FilExternalId",fld:"vFILEXTERNALID",pic:""},{av:"AV7CurrentPage",fld:"vCURRENTPAGE",pic:"ZZZ9"},{av:"AV16Id",fld:"vID",pic:"ZZZZZZZZZZZ9",hsh:!0}],[{av:"AV17isOK",fld:"vISOK",pic:""}]];this.EvtParms["'HIDE'"]=[[{av:'gx.fn.getCtrlProperty("FILTERSCONTAINER","Class")',ctrl:"FILTERSCONTAINER",prop:"Class"}],[{av:'gx.fn.getCtrlProperty("FILTERSCONTAINER","Class")',ctrl:"FILTERSCONTAINER",prop:"Class"},{ctrl:"HIDE",prop:"Caption"},{ctrl:"HIDE",prop:"Class"},{av:'gx.fn.getCtrlProperty("GRIDCELL","Class")',ctrl:"GRIDCELL",prop:"Class"}]];this.EvtParms["'FIRST'"]=[[{av:"GRIDWW_nFirstRecordOnPage"},{av:"GRIDWW_nEOF"},{av:"AV23UserId",fld:"vUSERID",pic:"",hsh:!0},{av:"AV12FilName",fld:"vFILNAME",pic:""},{av:"AV21SearchFilter",fld:"vSEARCHFILTER",pic:"",hsh:!0},{av:"AV11FilExternalId",fld:"vFILEXTERNALID",pic:""},{av:"AV7CurrentPage",fld:"vCURRENTPAGE",pic:"ZZZ9"}],[{av:"AV7CurrentPage",fld:"vCURRENTPAGE",pic:"ZZZ9"},{av:'gx.fn.getCtrlProperty("TBFIRST","Class")',ctrl:"TBFIRST",prop:"Class"},{av:'gx.fn.getCtrlProperty("TBPREV","Class")',ctrl:"TBPREV",prop:"Class"},{av:'gx.fn.getCtrlProperty("TBFIRST","Enabled")',ctrl:"TBFIRST",prop:"Enabled"},{av:'gx.fn.getCtrlProperty("TBPREV","Enabled")',ctrl:"TBPREV",prop:"Enabled"}]];this.EvtParms["'PREVIOUS'"]=[[{av:"GRIDWW_nFirstRecordOnPage"},{av:"GRIDWW_nEOF"},{av:"AV23UserId",fld:"vUSERID",pic:"",hsh:!0},{av:"AV12FilName",fld:"vFILNAME",pic:""},{av:"AV21SearchFilter",fld:"vSEARCHFILTER",pic:"",hsh:!0},{av:"AV11FilExternalId",fld:"vFILEXTERNALID",pic:""},{av:"AV7CurrentPage",fld:"vCURRENTPAGE",pic:"ZZZ9"}],[{av:"AV7CurrentPage",fld:"vCURRENTPAGE",pic:"ZZZ9"},{av:'gx.fn.getCtrlProperty("TBFIRST","Class")',ctrl:"TBFIRST",prop:"Class"},{av:'gx.fn.getCtrlProperty("TBPREV","Class")',ctrl:"TBPREV",prop:"Class"},{av:'gx.fn.getCtrlProperty("TBFIRST","Enabled")',ctrl:"TBFIRST",prop:"Enabled"},{av:'gx.fn.getCtrlProperty("TBPREV","Enabled")',ctrl:"TBPREV",prop:"Enabled"}]];this.EvtParms["'NEXT'"]=[[{av:"GRIDWW_nFirstRecordOnPage"},{av:"GRIDWW_nEOF"},{av:"AV23UserId",fld:"vUSERID",pic:"",hsh:!0},{av:"AV12FilName",fld:"vFILNAME",pic:""},{av:"AV21SearchFilter",fld:"vSEARCHFILTER",pic:"",hsh:!0},{av:"AV11FilExternalId",fld:"vFILEXTERNALID",pic:""},{av:"AV7CurrentPage",fld:"vCURRENTPAGE",pic:"ZZZ9"}],[{av:'gx.fn.getCtrlProperty("TBFIRST","Class")',ctrl:"TBFIRST",prop:"Class"},{av:'gx.fn.getCtrlProperty("TBPREV","Class")',ctrl:"TBPREV",prop:"Class"},{av:'gx.fn.getCtrlProperty("TBFIRST","Enabled")',ctrl:"TBFIRST",prop:"Enabled"},{av:'gx.fn.getCtrlProperty("TBPREV","Enabled")',ctrl:"TBPREV",prop:"Enabled"},{av:"AV7CurrentPage",fld:"vCURRENTPAGE",pic:"ZZZ9"}]];this.EvtParms.ENTER=[[],[]];this.setVCMap("AV23UserId","vUSERID",0,"char",40,0);this.setVCMap("AV21SearchFilter","vSEARCHFILTER",0,"char",254,0);this.setVCMap("AV17isOK","vISOK",0,"boolean",4,0);this.setVCMap("AV23UserId","vUSERID",0,"char",40,0);this.setVCMap("AV21SearchFilter","vSEARCHFILTER",0,"char",254,0);this.setVCMap("AV23UserId","vUSERID",0,"char",40,0);this.setVCMap("AV21SearchFilter","vSEARCHFILTER",0,"char",254,0);t.addRefreshingVar({rfrVar:"AV23UserId"});t.addRefreshingVar(this.GXValidFnc[24]);t.addRefreshingVar({rfrVar:"AV21SearchFilter"});t.addRefreshingVar(this.GXValidFnc[37]);t.addRefreshingVar(this.GXValidFnc[72]);t.addRefreshingParm({rfrVar:"AV23UserId"});t.addRefreshingParm(this.GXValidFnc[24]);t.addRefreshingParm({rfrVar:"AV21SearchFilter"});t.addRefreshingParm(this.GXValidFnc[37]);t.addRefreshingParm(this.GXValidFnc[72]);this.Initialize()});gx.wi(function(){gx.createParentObj(this.gam_userroleselect)})