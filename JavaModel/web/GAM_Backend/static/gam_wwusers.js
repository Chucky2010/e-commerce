/*!   GeneXus Java 17_0_11-163677 on August 31, 2022 2:5:18.76
*/
gx.evt.autoSkip=!1;gx.define("gam_wwusers",!1,function(){var n,t;this.ServerClass="gam_wwusers";this.PackageName="genexus.security.backend";this.ServerFullClass="genexus.security.backend.gam_wwusers";this.setObjectType("web");this.setOnAjaxSessionTimeout("Warn");this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.SetStandaloneVars=function(){this.AV26SearchFilter=gx.fn.getControlValue("vSEARCHFILTER");this.AV26SearchFilter=gx.fn.getControlValue("vSEARCHFILTER")};this.Validv_Filusergender=function(){return this.validCliEvt("Validv_Filusergender",0,function(){try{var n=gx.util.balloon.getNew("vFILUSERGENDER");if(this.AnyError=0,!(gx.text.compare(this.AV18FilUserGender,"N")==0||gx.text.compare(this.AV18FilUserGender,"F")==0||gx.text.compare(this.AV18FilUserGender,"M")==0||gx.text.compare("",this.AV18FilUserGender)==0))try{n.setError(gx.text.format(gx.getMessage("GXSPC_OutOfRange"),gx.getMessage("Filter User Gender"),"","","","","","","",""));this.AnyError=gx.num.trunc(1,0)}catch(t){}}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.e12071_client=function(){return this.clearMessages(),this.call("genexus.security.backend.gam_userentry",["INS",""],null,["Mode","UserId"]),this.refreshOutputs([]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e11071_client=function(){return this.clearMessages(),gx.text.compare(gx.fn.getCtrlProperty("FILTERSCONTAINER","Class"),"AdvancedContainer")==0?(gx.fn.setCtrlProperty("FILTERSCONTAINER","Class","AdvancedContainer AdvancedContainerVisible"),gx.fn.setCtrlProperty("HIDE","Caption",gx.getMessage("HIDE FILTERS")),gx.fn.setCtrlProperty("HIDE","Class","HideFiltersButton"),gx.fn.setCtrlProperty("GRIDCELL","Class","WWGridCell")):(gx.fn.setCtrlProperty("FILTERSCONTAINER","Class","AdvancedContainer"),gx.fn.setCtrlProperty("HIDE","Caption",gx.getMessage("SHOW FILTERS")),gx.fn.setCtrlProperty("HIDE","Class","ShowFiltersButton"),gx.fn.setCtrlProperty("GRIDCELL","Class","WWGridCellExpanded")),this.refreshOutputs([{av:'gx.fn.getCtrlProperty("FILTERSCONTAINER","Class")',ctrl:"FILTERSCONTAINER",prop:"Class"},{ctrl:"HIDE",prop:"Caption"},{ctrl:"HIDE",prop:"Class"},{av:'gx.fn.getCtrlProperty("GRIDCELL","Class")',ctrl:"GRIDCELL",prop:"Class"}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e19072_client=function(){return this.clearMessages(),this.call("genexus.security.backend.gam_userentry",["DSP",this.AV28UserId],null,["Mode","UserId"]),this.refreshOutputs([{av:"AV28UserId",fld:"vUSERID",pic:""}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e20072_client=function(){return this.clearMessages(),this.call("genexus.security.backend.gam_userentry",["UPD",this.AV28UserId],null,["Mode","UserId"]),this.refreshOutputs([{av:"AV28UserId",fld:"vUSERID",pic:""}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e13071_client=function(){return this.clearMessages(),this.AV10CurrentPage=gx.num.trunc(1,0),gx.fn.setCtrlProperty("TBFIRST","Class","SelectedPagingText"),gx.fn.setCtrlProperty("TBPREV","Class","SelectedPagingText"),gx.fn.setCtrlProperty("TBFIRST","Enabled",!1),gx.fn.setCtrlProperty("TBPREV","Enabled",!1),this.refreshOutputs([{av:"AV10CurrentPage",fld:"vCURRENTPAGE",pic:"ZZZ9"},{av:'gx.fn.getCtrlProperty("TBFIRST","Class")',ctrl:"TBFIRST",prop:"Class"},{av:'gx.fn.getCtrlProperty("TBPREV","Class")',ctrl:"TBPREV",prop:"Class"},{av:'gx.fn.getCtrlProperty("TBFIRST","Enabled")',ctrl:"TBFIRST",prop:"Enabled"},{av:'gx.fn.getCtrlProperty("TBPREV","Enabled")',ctrl:"TBPREV",prop:"Enabled"}]),this.refreshGrid("Gridww"),this.refreshOutputs([{av:"AV10CurrentPage",fld:"vCURRENTPAGE",pic:"ZZZ9"},{av:'gx.fn.getCtrlProperty("TBFIRST","Class")',ctrl:"TBFIRST",prop:"Class"},{av:'gx.fn.getCtrlProperty("TBPREV","Class")',ctrl:"TBPREV",prop:"Class"},{av:'gx.fn.getCtrlProperty("TBFIRST","Enabled")',ctrl:"TBFIRST",prop:"Enabled"},{av:'gx.fn.getCtrlProperty("TBPREV","Enabled")',ctrl:"TBPREV",prop:"Enabled"}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e14071_client=function(){return this.clearMessages(),this.AV10CurrentPage>1&&(this.AV10CurrentPage=gx.num.trunc(this.AV10CurrentPage-1,0)),this.AV10CurrentPage==1&&(gx.fn.setCtrlProperty("TBFIRST","Class","SelectedPagingText"),gx.fn.setCtrlProperty("TBPREV","Class","SelectedPagingText"),gx.fn.setCtrlProperty("TBFIRST","Enabled",!1),gx.fn.setCtrlProperty("TBPREV","Enabled",!1)),this.refreshOutputs([{av:"AV10CurrentPage",fld:"vCURRENTPAGE",pic:"ZZZ9"},{av:'gx.fn.getCtrlProperty("TBFIRST","Class")',ctrl:"TBFIRST",prop:"Class"},{av:'gx.fn.getCtrlProperty("TBPREV","Class")',ctrl:"TBPREV",prop:"Class"},{av:'gx.fn.getCtrlProperty("TBFIRST","Enabled")',ctrl:"TBFIRST",prop:"Enabled"},{av:'gx.fn.getCtrlProperty("TBPREV","Enabled")',ctrl:"TBPREV",prop:"Enabled"}]),this.refreshGrid("Gridww"),this.refreshOutputs([{av:"AV10CurrentPage",fld:"vCURRENTPAGE",pic:"ZZZ9"},{av:'gx.fn.getCtrlProperty("TBFIRST","Class")',ctrl:"TBFIRST",prop:"Class"},{av:'gx.fn.getCtrlProperty("TBPREV","Class")',ctrl:"TBPREV",prop:"Class"},{av:'gx.fn.getCtrlProperty("TBFIRST","Enabled")',ctrl:"TBFIRST",prop:"Enabled"},{av:'gx.fn.getCtrlProperty("TBPREV","Enabled")',ctrl:"TBPREV",prop:"Enabled"}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e15071_client=function(){return this.clearMessages(),this.AV10CurrentPage==1&&(gx.fn.setCtrlProperty("TBFIRST","Class","PagingText"),gx.fn.setCtrlProperty("TBPREV","Class","PagingText"),gx.fn.setCtrlProperty("TBFIRST","Enabled",!0),gx.fn.setCtrlProperty("TBPREV","Enabled",!0)),this.AV10CurrentPage=gx.num.trunc(this.AV10CurrentPage+1,0),this.refreshOutputs([{av:'gx.fn.getCtrlProperty("TBFIRST","Class")',ctrl:"TBFIRST",prop:"Class"},{av:'gx.fn.getCtrlProperty("TBPREV","Class")',ctrl:"TBPREV",prop:"Class"},{av:'gx.fn.getCtrlProperty("TBFIRST","Enabled")',ctrl:"TBFIRST",prop:"Enabled"},{av:'gx.fn.getCtrlProperty("TBPREV","Enabled")',ctrl:"TBPREV",prop:"Enabled"},{av:"AV10CurrentPage",fld:"vCURRENTPAGE",pic:"ZZZ9"}]),this.refreshGrid("Gridww"),this.refreshOutputs([{av:'gx.fn.getCtrlProperty("TBFIRST","Class")',ctrl:"TBFIRST",prop:"Class"},{av:'gx.fn.getCtrlProperty("TBPREV","Class")',ctrl:"TBPREV",prop:"Class"},{av:'gx.fn.getCtrlProperty("TBFIRST","Enabled")',ctrl:"TBFIRST",prop:"Enabled"},{av:'gx.fn.getCtrlProperty("TBPREV","Enabled")',ctrl:"TBPREV",prop:"Enabled"},{av:"AV10CurrentPage",fld:"vCURRENTPAGE",pic:"ZZZ9"}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e21072_client=function(){return this.executeServerEvent("ENTER",!0,arguments[0],!1,!1)};this.e22072_client=function(){return this.executeServerEvent("CANCEL",!0,arguments[0],!1,!1)};this.GXValidFnc=[];n=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,58,59,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84];this.GXLastCtrlId=84;this.GridwwContainer=new gx.grid.grid(this,2,"WbpLvl2",60,"Gridww","Gridww","GridwwContainer",this.CmpContext,this.IsMasterPage,"gam_wwusers",[],!1,1,!1,!0,0,!1,!1,!1,"",0,"px",0,"px",gx.getMessage("GXM_newrow"),!1,!1,!1,null,null,!1,"",!1,[1,1,1,1],!1,0,!0,!1);t=this.GridwwContainer;t.addSingleLineEdit("Name",61,"vNAME",gx.getMessage("User Name"),"","Name","char",0,"px",120,80,"left","e19072_client",[],"Name","Name",!0,0,!1,!1,"",1,"WWColumn");t.addSingleLineEdit("Firstname",62,"vFIRSTNAME",gx.getMessage("First Name"),"","FirstName","char",0,"px",120,80,"left",null,[],"Firstname","FirstName",!0,0,!1,!1,"",1,"WWColumn WWOptionalColumn");t.addSingleLineEdit("Lastname",63,"vLASTNAME",gx.getMessage("Last Name"),"","LastName","char",0,"px",120,80,"left",null,[],"Lastname","LastName",!0,0,!1,!1,"",1,"WWColumn WWOptionalColumn");t.addSingleLineEdit("Authenticationtypename",64,"vAUTHENTICATIONTYPENAME",gx.getMessage("Authentication"),"","AuthenticationTypeName","char",0,"px",60,60,"left",null,[],"Authenticationtypename","AuthenticationTypeName",!0,0,!1,!1,"",1,"WWColumn WWOptionalColumn");t.addSingleLineEdit("Btnupd",65,"vBTNUPD","","","BtnUpd","char",0,"px",20,20,"left","e20072_client",[],"Btnupd","BtnUpd",!0,0,!1,!1,"TextActionAttribute TextLikeLink",1,"WWTextActionColumn");t.addSingleLineEdit("Userid",66,"vUSERID",gx.getMessage("GUID"),"","UserId","char",0,"px",40,40,"left",null,[],"Userid","UserId",!1,0,!1,!1,"Attribute",1,"");this.GridwwContainer.emptyText=gx.getMessage("");this.setGrid(t);n[2]={id:2,fld:"",grid:0};n[3]={id:3,fld:"MAINTABLE",grid:0};n[4]={id:4,fld:"",grid:0};n[5]={id:5,fld:"",grid:0};n[6]={id:6,fld:"TABLE2",grid:0};n[7]={id:7,fld:"",grid:0};n[8]={id:8,fld:"",grid:0};n[9]={id:9,fld:"TABLE3",grid:0};n[10]={id:10,fld:"",grid:0};n[11]={id:11,fld:"",grid:0};n[12]={id:12,fld:"HIDE",grid:0,evt:"e11071_client"};n[13]={id:13,fld:"",grid:0};n[14]={id:14,fld:"TEXTBLOCK3",format:0,grid:0,ctrltype:"textblock"};n[15]={id:15,fld:"",grid:0};n[16]={id:16,fld:"ADDNEW",grid:0,evt:"e12071_client"};n[17]={id:17,fld:"",grid:0};n[18]={id:18,fld:"",grid:0};n[19]={id:19,lvl:0,type:"svchar",len:100,dec:60,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vSEARCH",fmt:0,gxz:"ZV25Search",gxold:"OV25Search",gxvar:"AV25Search",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV25Search=n)},v2z:function(n){n!==undefined&&(gx.O.ZV25Search=n)},v2c:function(){gx.fn.setControlValue("vSEARCH",gx.O.AV25Search,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.AV25Search=this.val())},val:function(){return gx.fn.getControlValue("vSEARCH")},nac:gx.falseFn};this.declareDomainHdlr(19,function(){});n[20]={id:20,fld:"",grid:0};n[21]={id:21,fld:"CELLFILTERS",grid:0};n[22]={id:22,fld:"FILTERSCONTAINER",grid:0};n[23]={id:23,fld:"",grid:0};n[24]={id:24,fld:"",grid:0};n[25]={id:25,fld:"TABLE4",grid:0};n[26]={id:26,fld:"",grid:0};n[27]={id:27,fld:"",grid:0};n[28]={id:28,fld:"TEXTBLOCK1",format:0,grid:0,ctrltype:"textblock"};n[29]={id:29,fld:"",grid:0};n[30]={id:30,fld:"",grid:0};n[31]={id:31,fld:"",grid:0};n[32]={id:32,lvl:0,type:"char",len:1,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:this.Validv_Filusergender,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vFILUSERGENDER",fmt:0,gxz:"ZV18FilUserGender",gxold:"OV18FilUserGender",gxvar:"AV18FilUserGender",ucs:[],op:[32],ip:[32],nacdep:[],ctrltype:"combo",v2v:function(n){n!==undefined&&(gx.O.AV18FilUserGender=n)},v2z:function(n){n!==undefined&&(gx.O.ZV18FilUserGender=n)},v2c:function(){gx.fn.setComboBoxValue("vFILUSERGENDER",gx.O.AV18FilUserGender);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.AV18FilUserGender=this.val())},val:function(){return gx.fn.getControlValue("vFILUSERGENDER")},nac:gx.falseFn};this.declareDomainHdlr(32,function(){});n[33]={id:33,fld:"",grid:0};n[34]={id:34,fld:"",grid:0};n[35]={id:35,fld:"TABLE5",grid:0};n[36]={id:36,fld:"",grid:0};n[37]={id:37,fld:"",grid:0};n[38]={id:38,fld:"TEXTBLOCK2",format:0,grid:0,ctrltype:"textblock"};n[39]={id:39,fld:"",grid:0};n[40]={id:40,fld:"",grid:0};n[41]={id:41,fld:"",grid:0};n[42]={id:42,lvl:0,type:"char",len:60,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vFILAUTTYPE",fmt:0,gxz:"ZV13FilAutType",gxold:"OV13FilAutType",gxvar:"AV13FilAutType",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"combo",v2v:function(n){n!==undefined&&(gx.O.AV13FilAutType=n)},v2z:function(n){n!==undefined&&(gx.O.ZV13FilAutType=n)},v2c:function(){gx.fn.setComboBoxValue("vFILAUTTYPE",gx.O.AV13FilAutType);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.AV13FilAutType=this.val())},val:function(){return gx.fn.getControlValue("vFILAUTTYPE")},nac:gx.falseFn};this.declareDomainHdlr(42,function(){});n[43]={id:43,fld:"",grid:0};n[44]={id:44,fld:"",grid:0};n[45]={id:45,fld:"TABLE8",grid:0};n[46]={id:46,fld:"",grid:0};n[47]={id:47,fld:"",grid:0};n[48]={id:48,fld:"TEXTBLOCK4",format:0,grid:0,ctrltype:"textblock"};n[49]={id:49,fld:"",grid:0};n[50]={id:50,fld:"",grid:0};n[51]={id:51,fld:"",grid:0};n[52]={id:52,lvl:0,type:"int",len:12,dec:0,sign:!1,pic:"ZZZZZZZZZZZ9",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vFILROL",fmt:0,gxz:"ZV14FilRol",gxold:"OV14FilRol",gxvar:"AV14FilRol",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"combo",v2v:function(n){n!==undefined&&(gx.O.AV14FilRol=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.ZV14FilRol=gx.num.intval(n))},v2c:function(){gx.fn.setComboBoxValue("vFILROL",gx.O.AV14FilRol);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.AV14FilRol=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("vFILROL",gx.thousandSeparator)},nac:gx.falseFn};this.declareDomainHdlr(52,function(){});n[53]={id:53,fld:"GRIDCELL",grid:0};n[54]={id:54,fld:"TABLE1",grid:0};n[55]={id:55,fld:"",grid:0};n[56]={id:56,fld:"",grid:0};n[58]={id:58,fld:"",grid:0};n[59]={id:59,fld:"",grid:0};n[61]={id:61,lvl:2,type:"char",len:120,dec:0,sign:!1,ro:0,isacc:0,grid:60,gxgrid:this.GridwwContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vNAME",fmt:0,gxz:"ZV21Name",gxold:"OV21Name",gxvar:"AV21Name",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.AV21Name=n)},v2z:function(n){n!==undefined&&(gx.O.ZV21Name=n)},v2c:function(n){gx.fn.setGridControlValue("vNAME",n||gx.fn.currentGridRowImpl(60),gx.O.AV21Name,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.AV21Name=this.val(n))},val:function(n){return gx.fn.getGridControlValue("vNAME",n||gx.fn.currentGridRowImpl(60))},nac:gx.falseFn,evt:"e19072_client"};n[62]={id:62,lvl:2,type:"char",len:120,dec:0,sign:!1,ro:0,isacc:0,grid:60,gxgrid:this.GridwwContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vFIRSTNAME",fmt:0,gxz:"ZV19FirstName",gxold:"OV19FirstName",gxvar:"AV19FirstName",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.AV19FirstName=n)},v2z:function(n){n!==undefined&&(gx.O.ZV19FirstName=n)},v2c:function(n){gx.fn.setGridControlValue("vFIRSTNAME",n||gx.fn.currentGridRowImpl(60),gx.O.AV19FirstName,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.AV19FirstName=this.val(n))},val:function(n){return gx.fn.getGridControlValue("vFIRSTNAME",n||gx.fn.currentGridRowImpl(60))},nac:gx.falseFn};n[63]={id:63,lvl:2,type:"char",len:120,dec:0,sign:!1,ro:0,isacc:0,grid:60,gxgrid:this.GridwwContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vLASTNAME",fmt:0,gxz:"ZV20LastName",gxold:"OV20LastName",gxvar:"AV20LastName",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.AV20LastName=n)},v2z:function(n){n!==undefined&&(gx.O.ZV20LastName=n)},v2c:function(n){gx.fn.setGridControlValue("vLASTNAME",n||gx.fn.currentGridRowImpl(60),gx.O.AV20LastName,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.AV20LastName=this.val(n))},val:function(n){return gx.fn.getGridControlValue("vLASTNAME",n||gx.fn.currentGridRowImpl(60))},nac:gx.falseFn};n[64]={id:64,lvl:2,type:"char",len:60,dec:0,sign:!1,ro:0,isacc:0,grid:60,gxgrid:this.GridwwContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vAUTHENTICATIONTYPENAME",fmt:0,gxz:"ZV6AuthenticationTypeName",gxold:"OV6AuthenticationTypeName",gxvar:"AV6AuthenticationTypeName",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.AV6AuthenticationTypeName=n)},v2z:function(n){n!==undefined&&(gx.O.ZV6AuthenticationTypeName=n)},v2c:function(n){gx.fn.setGridControlValue("vAUTHENTICATIONTYPENAME",n||gx.fn.currentGridRowImpl(60),gx.O.AV6AuthenticationTypeName,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.AV6AuthenticationTypeName=this.val(n))},val:function(n){return gx.fn.getGridControlValue("vAUTHENTICATIONTYPENAME",n||gx.fn.currentGridRowImpl(60))},nac:gx.falseFn};n[65]={id:65,lvl:2,type:"char",len:20,dec:0,sign:!1,ro:0,isacc:0,grid:60,gxgrid:this.GridwwContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vBTNUPD",fmt:0,gxz:"ZV8BtnUpd",gxold:"OV8BtnUpd",gxvar:"AV8BtnUpd",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.AV8BtnUpd=n)},v2z:function(n){n!==undefined&&(gx.O.ZV8BtnUpd=n)},v2c:function(n){gx.fn.setGridControlValue("vBTNUPD",n||gx.fn.currentGridRowImpl(60),gx.O.AV8BtnUpd,0)},c2v:function(n){this.val(n)!==undefined&&(gx.O.AV8BtnUpd=this.val(n))},val:function(n){return gx.fn.getGridControlValue("vBTNUPD",n||gx.fn.currentGridRowImpl(60))},nac:gx.falseFn,evt:"e20072_client"};n[66]={id:66,lvl:2,type:"char",len:40,dec:0,sign:!1,ro:0,isacc:0,grid:60,gxgrid:this.GridwwContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vUSERID",fmt:0,gxz:"ZV28UserId",gxold:"OV28UserId",gxvar:"AV28UserId",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.AV28UserId=n)},v2z:function(n){n!==undefined&&(gx.O.ZV28UserId=n)},v2c:function(n){gx.fn.setGridControlValue("vUSERID",n||gx.fn.currentGridRowImpl(60),gx.O.AV28UserId,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.AV28UserId=this.val(n))},val:function(n){return gx.fn.getGridControlValue("vUSERID",n||gx.fn.currentGridRowImpl(60))},nac:gx.falseFn};n[67]={id:67,fld:"",grid:0};n[68]={id:68,fld:"",grid:0};n[69]={id:69,fld:"TABLE6",grid:0};n[70]={id:70,fld:"",grid:0};n[71]={id:71,fld:"",grid:0};n[72]={id:72,fld:"TBFIRST",format:0,grid:0,evt:"e13071_client",ctrltype:"textblock"};n[73]={id:73,fld:"",grid:0};n[74]={id:74,fld:"TB1",format:0,grid:0,ctrltype:"textblock"};n[75]={id:75,fld:"",grid:0};n[76]={id:76,fld:"TBPREV",format:0,grid:0,evt:"e14071_client",ctrltype:"textblock"};n[77]={id:77,fld:"",grid:0};n[78]={id:78,fld:"TB2",format:0,grid:0,ctrltype:"textblock"};n[79]={id:79,fld:"",grid:0};n[80]={id:80,fld:"TBNEXT",format:0,grid:0,evt:"e15071_client",ctrltype:"textblock"};n[81]={id:81,fld:"",grid:0};n[82]={id:82,fld:"",grid:0};n[83]={id:83,fld:"",grid:0};n[84]={id:84,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vCURRENTPAGE",fmt:0,gxz:"ZV10CurrentPage",gxold:"OV10CurrentPage",gxvar:"AV10CurrentPage",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV10CurrentPage=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.ZV10CurrentPage=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("vCURRENTPAGE",gx.O.AV10CurrentPage,0)},c2v:function(){this.val()!==undefined&&(gx.O.AV10CurrentPage=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("vCURRENTPAGE",gx.thousandSeparator)},nac:gx.falseFn};this.AV25Search="";this.ZV25Search="";this.OV25Search="";this.AV18FilUserGender="";this.ZV18FilUserGender="";this.OV18FilUserGender="";this.AV13FilAutType="";this.ZV13FilAutType="";this.OV13FilAutType="";this.AV14FilRol=0;this.ZV14FilRol=0;this.OV14FilRol=0;this.ZV21Name="";this.OV21Name="";this.ZV19FirstName="";this.OV19FirstName="";this.ZV20LastName="";this.OV20LastName="";this.ZV6AuthenticationTypeName="";this.OV6AuthenticationTypeName="";this.ZV8BtnUpd="";this.OV8BtnUpd="";this.ZV28UserId="";this.OV28UserId="";this.AV10CurrentPage=0;this.ZV10CurrentPage=0;this.OV10CurrentPage=0;this.AV25Search="";this.AV18FilUserGender="";this.AV13FilAutType="";this.AV14FilRol=0;this.AV10CurrentPage=0;this.AV21Name="";this.AV19FirstName="";this.AV20LastName="";this.AV6AuthenticationTypeName="";this.AV8BtnUpd="";this.AV28UserId="";this.AV26SearchFilter="";this.Events={e21072_client:["ENTER",!0],e22072_client:["CANCEL",!0],e12071_client:["'ADDNEW'",!1],e11071_client:["'HIDE'",!1],e19072_client:["VNAME.CLICK",!1],e20072_client:["'UPDATE'",!1],e13071_client:["'FIRST'",!1],e14071_client:["'PREVIOUS'",!1],e15071_client:["'NEXT'",!1]};this.EvtParms.REFRESH=[[{av:"GRIDWW_nFirstRecordOnPage"},{av:"GRIDWW_nEOF"},{ctrl:"vFILUSERGENDER"},{av:"AV18FilUserGender",fld:"vFILUSERGENDER",pic:""},{ctrl:"vFILAUTTYPE"},{av:"AV13FilAutType",fld:"vFILAUTTYPE",pic:""},{av:"AV10CurrentPage",fld:"vCURRENTPAGE",pic:"ZZZ9"},{av:"AV25Search",fld:"vSEARCH",pic:""},{ctrl:"vFILROL"},{av:"AV14FilRol",fld:"vFILROL",pic:"ZZZZZZZZZZZ9"},{av:"AV26SearchFilter",fld:"vSEARCHFILTER",pic:"",hsh:!0}],[]];this.EvtParms["GRIDWW.LOAD"]=[[{ctrl:"vFILUSERGENDER"},{av:"AV18FilUserGender",fld:"vFILUSERGENDER",pic:""},{ctrl:"vFILAUTTYPE"},{av:"AV13FilAutType",fld:"vFILAUTTYPE",pic:""},{av:"AV10CurrentPage",fld:"vCURRENTPAGE",pic:"ZZZ9"},{av:"AV25Search",fld:"vSEARCH",pic:""},{av:"AV26SearchFilter",fld:"vSEARCHFILTER",pic:"",hsh:!0},{ctrl:"vFILROL"},{av:"AV14FilRol",fld:"vFILROL",pic:"ZZZZZZZZZZZ9"}],[{av:"AV8BtnUpd",fld:"vBTNUPD",pic:""},{av:'gx.fn.getCtrlProperty("vNAME","Class")',ctrl:"vNAME",prop:"Class"},{av:'gx.fn.getCtrlProperty("vFIRSTNAME","Class")',ctrl:"vFIRSTNAME",prop:"Class"},{av:'gx.fn.getCtrlProperty("vLASTNAME","Class")',ctrl:"vLASTNAME",prop:"Class"},{av:'gx.fn.getCtrlProperty("vAUTHENTICATIONTYPENAME","Class")',ctrl:"vAUTHENTICATIONTYPENAME",prop:"Class"},{av:"AV6AuthenticationTypeName",fld:"vAUTHENTICATIONTYPENAME",pic:""},{av:"AV28UserId",fld:"vUSERID",pic:""},{av:"AV21Name",fld:"vNAME",pic:""},{av:"AV19FirstName",fld:"vFIRSTNAME",pic:""},{av:"AV20LastName",fld:"vLASTNAME",pic:""},{av:'gx.fn.getCtrlProperty("vBTNUPD","Visible")',ctrl:"vBTNUPD",prop:"Visible"},{av:'gx.fn.getCtrlProperty("TBNEXT","Class")',ctrl:"TBNEXT",prop:"Class"}]];this.EvtParms["'ADDNEW'"]=[[],[]];this.EvtParms["'HIDE'"]=[[{av:'gx.fn.getCtrlProperty("FILTERSCONTAINER","Class")',ctrl:"FILTERSCONTAINER",prop:"Class"}],[{av:'gx.fn.getCtrlProperty("FILTERSCONTAINER","Class")',ctrl:"FILTERSCONTAINER",prop:"Class"},{ctrl:"HIDE",prop:"Caption"},{ctrl:"HIDE",prop:"Class"},{av:'gx.fn.getCtrlProperty("GRIDCELL","Class")',ctrl:"GRIDCELL",prop:"Class"}]];this.EvtParms["VNAME.CLICK"]=[[{av:"AV28UserId",fld:"vUSERID",pic:""}],[{av:"AV28UserId",fld:"vUSERID",pic:""}]];this.EvtParms["'UPDATE'"]=[[{av:"AV28UserId",fld:"vUSERID",pic:""}],[{av:"AV28UserId",fld:"vUSERID",pic:""}]];this.EvtParms["'FIRST'"]=[[{av:"GRIDWW_nFirstRecordOnPage"},{av:"GRIDWW_nEOF"},{ctrl:"vFILUSERGENDER"},{av:"AV18FilUserGender",fld:"vFILUSERGENDER",pic:""},{ctrl:"vFILAUTTYPE"},{av:"AV13FilAutType",fld:"vFILAUTTYPE",pic:""},{av:"AV10CurrentPage",fld:"vCURRENTPAGE",pic:"ZZZ9"},{av:"AV25Search",fld:"vSEARCH",pic:""},{av:"AV26SearchFilter",fld:"vSEARCHFILTER",pic:"",hsh:!0},{ctrl:"vFILROL"},{av:"AV14FilRol",fld:"vFILROL",pic:"ZZZZZZZZZZZ9"}],[{av:"AV10CurrentPage",fld:"vCURRENTPAGE",pic:"ZZZ9"},{av:'gx.fn.getCtrlProperty("TBFIRST","Class")',ctrl:"TBFIRST",prop:"Class"},{av:'gx.fn.getCtrlProperty("TBPREV","Class")',ctrl:"TBPREV",prop:"Class"},{av:'gx.fn.getCtrlProperty("TBFIRST","Enabled")',ctrl:"TBFIRST",prop:"Enabled"},{av:'gx.fn.getCtrlProperty("TBPREV","Enabled")',ctrl:"TBPREV",prop:"Enabled"}]];this.EvtParms["'PREVIOUS'"]=[[{av:"GRIDWW_nFirstRecordOnPage"},{av:"GRIDWW_nEOF"},{ctrl:"vFILUSERGENDER"},{av:"AV18FilUserGender",fld:"vFILUSERGENDER",pic:""},{ctrl:"vFILAUTTYPE"},{av:"AV13FilAutType",fld:"vFILAUTTYPE",pic:""},{av:"AV10CurrentPage",fld:"vCURRENTPAGE",pic:"ZZZ9"},{av:"AV25Search",fld:"vSEARCH",pic:""},{av:"AV26SearchFilter",fld:"vSEARCHFILTER",pic:"",hsh:!0},{ctrl:"vFILROL"},{av:"AV14FilRol",fld:"vFILROL",pic:"ZZZZZZZZZZZ9"}],[{av:"AV10CurrentPage",fld:"vCURRENTPAGE",pic:"ZZZ9"},{av:'gx.fn.getCtrlProperty("TBFIRST","Class")',ctrl:"TBFIRST",prop:"Class"},{av:'gx.fn.getCtrlProperty("TBPREV","Class")',ctrl:"TBPREV",prop:"Class"},{av:'gx.fn.getCtrlProperty("TBFIRST","Enabled")',ctrl:"TBFIRST",prop:"Enabled"},{av:'gx.fn.getCtrlProperty("TBPREV","Enabled")',ctrl:"TBPREV",prop:"Enabled"}]];this.EvtParms["'NEXT'"]=[[{av:"GRIDWW_nFirstRecordOnPage"},{av:"GRIDWW_nEOF"},{ctrl:"vFILUSERGENDER"},{av:"AV18FilUserGender",fld:"vFILUSERGENDER",pic:""},{ctrl:"vFILAUTTYPE"},{av:"AV13FilAutType",fld:"vFILAUTTYPE",pic:""},{av:"AV10CurrentPage",fld:"vCURRENTPAGE",pic:"ZZZ9"},{av:"AV25Search",fld:"vSEARCH",pic:""},{av:"AV26SearchFilter",fld:"vSEARCHFILTER",pic:"",hsh:!0},{ctrl:"vFILROL"},{av:"AV14FilRol",fld:"vFILROL",pic:"ZZZZZZZZZZZ9"}],[{av:'gx.fn.getCtrlProperty("TBFIRST","Class")',ctrl:"TBFIRST",prop:"Class"},{av:'gx.fn.getCtrlProperty("TBPREV","Class")',ctrl:"TBPREV",prop:"Class"},{av:'gx.fn.getCtrlProperty("TBFIRST","Enabled")',ctrl:"TBFIRST",prop:"Enabled"},{av:'gx.fn.getCtrlProperty("TBPREV","Enabled")',ctrl:"TBPREV",prop:"Enabled"},{av:"AV10CurrentPage",fld:"vCURRENTPAGE",pic:"ZZZ9"}]];this.EvtParms.ENTER=[[],[]];this.EvtParms.VALIDV_FILUSERGENDER=[[],[]];this.setVCMap("AV26SearchFilter","vSEARCHFILTER",0,"svchar",100,60);this.setVCMap("AV26SearchFilter","vSEARCHFILTER",0,"svchar",100,60);this.setVCMap("AV26SearchFilter","vSEARCHFILTER",0,"svchar",100,60);t.addRefreshingVar(this.GXValidFnc[32]);t.addRefreshingVar(this.GXValidFnc[42]);t.addRefreshingVar(this.GXValidFnc[84]);t.addRefreshingVar(this.GXValidFnc[19]);t.addRefreshingVar({rfrVar:"AV26SearchFilter"});t.addRefreshingVar(this.GXValidFnc[52]);t.addRefreshingParm(this.GXValidFnc[32]);t.addRefreshingParm(this.GXValidFnc[42]);t.addRefreshingParm(this.GXValidFnc[84]);t.addRefreshingParm(this.GXValidFnc[19]);t.addRefreshingParm({rfrVar:"AV26SearchFilter"});t.addRefreshingParm(this.GXValidFnc[52]);this.Initialize()});gx.wi(function(){gx.createParentObj(this.gam_wwusers)})