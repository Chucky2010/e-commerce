gx.evt.autoSkip=!1;gx.define("usuarioprompt",!1,function(){var i,r,t,n,u;this.ServerClass="usuarioprompt";this.PackageName="com.mujermorena";this.ServerFullClass="com.mujermorena.usuarioprompt";this.setObjectType("web");this.anyGridBaseTable=!0;this.hasEnterEvent=!0;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.AV21Pgmname=gx.fn.getControlValue("vPGMNAME");this.AV10OrderedBy=gx.fn.getIntegerValue("vORDEREDBY",gx.thousandSeparator);this.AV11OrderedDsc=gx.fn.getControlValue("vORDEREDDSC");this.AV8InOutUsuarioId=gx.fn.getIntegerValue("vINOUTUSUARIOID",gx.thousandSeparator);this.AV21Pgmname=gx.fn.getControlValue("vPGMNAME")};this.Valid_Usuarioid=function(){var n=gx.fn.currentGridRowImpl(26);return this.validCliEvt("Valid_Usuarioid",26,function(){try{if(gx.fn.currentGridRowImpl(26)===0)return!0;var n=gx.util.balloon.getNew("USUARIOID",gx.fn.currentGridRowImpl(26));this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Usuarionom=function(){var n=gx.fn.currentGridRowImpl(26);return this.validCliEvt("Valid_Usuarionom",26,function(){try{if(gx.fn.currentGridRowImpl(26)===0)return!0;var n=gx.util.balloon.getNew("USUARIONOM",gx.fn.currentGridRowImpl(26));this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Personaid=function(){var n=gx.fn.currentGridRowImpl(26);return this.validCliEvt("Valid_Personaid",26,function(){try{if(gx.fn.currentGridRowImpl(26)===0)return!0;var n=gx.util.balloon.getNew("PERSONAID",gx.fn.currentGridRowImpl(26));this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Personacorreo=function(){var n=gx.fn.currentGridRowImpl(26);return this.validCliEvt("Valid_Personacorreo",26,function(){try{if(gx.fn.currentGridRowImpl(26)===0)return!0;var n=gx.util.balloon.getNew("PERSONACORREO",gx.fn.currentGridRowImpl(26));this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Deviceid=function(){var n=gx.fn.currentGridRowImpl(26);return this.validCliEvt("Valid_Deviceid",26,function(){try{if(gx.fn.currentGridRowImpl(26)===0)return!0;var n=gx.util.balloon.getNew("DEVICEID",gx.fn.currentGridRowImpl(26));this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Devicetype=function(){var n=gx.fn.currentGridRowImpl(26);return this.validCliEvt("Valid_Devicetype",26,function(){try{if(gx.fn.currentGridRowImpl(26)===0)return!0;var n=gx.util.balloon.getNew("DEVICETYPE",gx.fn.currentGridRowImpl(26));this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.s112_client=function(){this.DDO_GRIDContainer.SortedStatus=gx.text.trim(gx.num.str(this.AV10OrderedBy,4,0))+":"+(this.AV11OrderedDsc?"DSC":"ASC")};this.s122_client=function(){this.AV12FilterFullText=""};this.e11642_client=function(){return this.executeServerEvent("GRIDPAGINATIONBAR.CHANGEPAGE",!1,null,!0,!0)};this.e12642_client=function(){return this.executeServerEvent("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",!1,null,!0,!0)};this.e13642_client=function(){return this.executeServerEvent("DDO_GRID.ONOPTIONCLICKED",!1,null,!0,!0)};this.e18642_client=function(){return this.executeServerEvent("ENTER",!0,arguments[0],!1,!1)};this.e14642_client=function(){return this.executeServerEvent("'DOCLEANFILTERS'",!0,null,!1,!1)};this.e19642_client=function(){return this.executeServerEvent("CANCEL",!0,arguments[0],!1,!1)};this.GXValidFnc=[];i=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,12,13,14,17,19,20,21,22,23,24,25,27,28,29,30,31,32,33,34,35,37,38,39];this.GXLastCtrlId=39;this.GridContainer=new gx.grid.grid(this,2,"WbpLvl2",26,"Grid","Grid","GridContainer",this.CmpContext,this.IsMasterPage,"usuarioprompt",[],!1,1,!1,!0,0,!1,!1,!1,"",0,"px",0,"px",gx.getMessage("GXM_newrow"),!0,!1,!1,null,null,!1,"",!1,[1,1,1,1],!1,0,!0,!1);r=this.GridContainer;r.addSingleLineEdit("Select",27,"vSELECT","",gx.getMessage("GX_BtnSelect"),"Select","char",0,"px",20,20,"left","e18642_client",[],"Select","Select",!0,0,!1,!1,"Attribute",0,"WWIconActionColumn");r.addSingleLineEdit(14,28,"USUARIOID",gx.getMessage("Id"),"","UsuarioId","int",0,"px",11,11,"right",null,[],14,"UsuarioId",!0,0,!1,!1,"AttributeRealWidth",0,"WWColumn");r.addSingleLineEdit(271,29,"USUARIONOM",gx.getMessage("Nom"),"","UsuarioNom","char",0,"px",20,20,"left",null,[],271,"UsuarioNom",!0,0,!1,!1,"AttributeRealWidth",0,"WWColumn hidden-xs");r.addSingleLineEdit(1,30,"PERSONAID",gx.getMessage("Persona Id"),"","PersonaId","int",0,"px",11,11,"right",null,[],1,"PersonaId",!0,0,!1,!1,"AttributeRealWidth",0,"WWColumn hidden-xs");r.addSingleLineEdit(69,31,"PERSONACORREO",gx.getMessage("Persona Correo"),"","PersonaCorreo","svchar",0,"px",100,80,"left",null,[],69,"PersonaCorreo",!0,0,!1,!1,"AttributeRealWidth",0,"WWColumn hidden-xs");r.addSingleLineEdit(16,32,"DEVICEID",gx.getMessage("Device Id"),"","DeviceId","char",0,"px",128,80,"left",null,[],16,"DeviceId",!0,0,!1,!1,"AttributeRealWidth",0,"WWColumn hidden-xs");r.addComboBox(15,33,"DEVICETYPE",gx.getMessage("Device Type"),"DeviceType","int",null,0,!0,!1,0,"px","WWColumn hidden-xs");this.GridContainer.emptyText=gx.getMessage("");this.setGrid(r);this.GRIDPAGINATIONBARContainer=gx.uc.getNew(this,36,20,"DVelop_DVPaginationBar","GRIDPAGINATIONBARContainer","Gridpaginationbar","GRIDPAGINATIONBAR");t=this.GRIDPAGINATIONBARContainer;t.setProp("Enabled","Enabled",!0,"boolean");t.setProp("Class","Class","PaginationBar","str");t.setProp("ShowFirst","Showfirst",!1,"bool");t.setProp("ShowPrevious","Showprevious",!0,"bool");t.setProp("ShowNext","Shownext",!0,"bool");t.setProp("ShowLast","Showlast",!1,"bool");t.setProp("PagesToShow","Pagestoshow",5,"num");t.setProp("PagingButtonsPosition","Pagingbuttonsposition","Right","str");t.setProp("PagingCaptionPosition","Pagingcaptionposition","Left","str");t.setProp("EmptyGridClass","Emptygridclass","PaginationBarEmptyGrid","str");t.setProp("SelectedPage","Selectedpage","","char");t.setProp("RowsPerPageSelector","Rowsperpageselector",!0,"bool");t.setDynProp("RowsPerPageSelectedValue","Rowsperpageselectedvalue",10,"num");t.setProp("RowsPerPageOptions","Rowsperpageoptions","5:WWP_Rows5,10:WWP_Rows10,20:WWP_Rows20,50:WWP_Rows50","str");t.setProp("First","First","First","str");t.setProp("Previous","Previous","WWP_PagingPreviousCaption","str");t.setProp("Next","Next","WWP_PagingNextCaption","str");t.setProp("Last","Last","Last","str");t.setProp("Caption","Caption",gx.getMessage("WWP_PagingCaption"),"str");t.setProp("EmptyGridCaption","Emptygridcaption","WWP_PagingEmptyGridCaption","str");t.setProp("RowsPerPageCaption","Rowsperpagecaption","WWP_PagingRowsPerPage","str");t.addV2CFunction("AV15GridCurrentPage","vGRIDCURRENTPAGE","SetCurrentPage");t.addC2VFunction(function(n){n.ParentObject.AV15GridCurrentPage=n.GetCurrentPage();gx.fn.setControlValue("vGRIDCURRENTPAGE",n.ParentObject.AV15GridCurrentPage)});t.addV2CFunction("AV16GridPageCount","vGRIDPAGECOUNT","SetPageCount");t.addC2VFunction(function(n){n.ParentObject.AV16GridPageCount=n.GetPageCount();gx.fn.setControlValue("vGRIDPAGECOUNT",n.ParentObject.AV16GridPageCount)});t.setProp("RecordCount","Recordcount","","str");t.setProp("Page","Page","","str");t.addV2CFunction("AV17GridAppliedFilters","vGRIDAPPLIEDFILTERS","SetAppliedFilters");t.addC2VFunction(function(n){n.ParentObject.AV17GridAppliedFilters=n.GetAppliedFilters();gx.fn.setControlValue("vGRIDAPPLIEDFILTERS",n.ParentObject.AV17GridAppliedFilters)});t.setProp("Visible","Visible",!0,"bool");t.setProp("Gx Control Type","Gxcontroltype","","int");t.setC2ShowFunction(function(n){n.show()});t.addEventHandler("ChangePage",this.e11642_client);t.addEventHandler("ChangeRowsPerPage",this.e12642_client);this.setUserControl(t);this.DDO_GRIDContainer=gx.uc.getNew(this,40,20,"DDOGridTitleSettingsM","DDO_GRIDContainer","Ddo_grid","DDO_GRID");n=this.DDO_GRIDContainer;n.setProp("Class","Class","","char");n.setProp("Enabled","Enabled",!0,"boolean");n.setProp("IconType","Icontype","Image","str");n.setProp("Icon","Icon","","str");n.setProp("Caption","Caption","","str");n.setProp("Tooltip","Tooltip","","str");n.setProp("Cls","Cls","","str");n.setProp("ActiveEventKey","Activeeventkey","","char");n.setProp("FilteredText_set","Filteredtext_set","","char");n.setProp("FilteredText_get","Filteredtext_get","","char");n.setProp("FilteredTextTo_set","Filteredtextto_set","","char");n.setProp("FilteredTextTo_get","Filteredtextto_get","","char");n.setProp("SelectedValue_set","Selectedvalue_set","","char");n.setProp("SelectedValue_get","Selectedvalue_get","","char");n.setProp("SelectedText_set","Selectedtext_set","","char");n.setProp("SelectedText_get","Selectedtext_get","","char");n.setProp("SelectedColumn","Selectedcolumn","","char");n.setProp("SelectedColumnFixedFilter","Selectedcolumnfixedfilter","","char");n.setProp("GAMOAuthToken","Gamoauthtoken","","char");n.setProp("TitleControlAlign","Titlecontrolalign","","str");n.setProp("Visible","Visible","","str");n.setDynProp("GridInternalName","Gridinternalname","","str");n.setProp("ColumnIds","Columnids","1:UsuarioId|2:UsuarioNom|3:PersonaId|4:PersonaCorreo|5:DeviceId|6:DeviceType","str");n.setProp("ColumnsSortValues","Columnssortvalues","1|2|3|4|5|6","str");n.setProp("IncludeSortASC","Includesortasc","T","str");n.setProp("IncludeSortDSC","Includesortdsc","","str");n.setProp("AllowGroup","Allowgroup","","str");n.setProp("Fixable","Fixable","","str");n.setDynProp("SortedStatus","Sortedstatus","","char");n.setProp("IncludeFilter","Includefilter","","str");n.setProp("FilterType","Filtertype","","str");n.setProp("FilterIsRange","Filterisrange","","str");n.setProp("IncludeDataList","Includedatalist","","str");n.setProp("DataListType","Datalisttype","","str");n.setProp("AllowMultipleSelection","Allowmultipleselection","","str");n.setProp("DataListFixedValues","Datalistfixedvalues","","str");n.setProp("DataListProc","Datalistproc","","str");n.setProp("DataListProcParametersPrefix","Datalistprocparametersprefix","","str");n.setProp("RemoteServicesParameters","Remoteservicesparameters","","str");n.setProp("DataListUpdateMinimumCharacters","Datalistupdateminimumcharacters",0,"num");n.setProp("FixedFilters","Fixedfilters","","str");n.setProp("Format","Format","","str");n.setProp("SelectedFixedFilter","Selectedfixedfilter","","char");n.setProp("SortASC","Sortasc","","str");n.setProp("SortDSC","Sortdsc","","str");n.setProp("AllowGroupText","Allowgrouptext","","str");n.setProp("LoadingData","Loadingdata","","str");n.setProp("CleanFilter","Cleanfilter","","str");n.setProp("RangeFilterFrom","Rangefilterfrom","","str");n.setProp("RangeFilterTo","Rangefilterto","","str");n.setProp("NoResultsFound","Noresultsfound","","str");n.setProp("SearchButtonText","Searchbuttontext","","str");n.addV2CFunction("AV13DDO_TitleSettingsIcons","vDDO_TITLESETTINGSICONS","SetDropDownOptionsTitleSettingsIcons");n.addC2VFunction(function(n){n.ParentObject.AV13DDO_TitleSettingsIcons=n.GetDropDownOptionsTitleSettingsIcons();gx.fn.setControlValue("vDDO_TITLESETTINGSICONS",n.ParentObject.AV13DDO_TitleSettingsIcons)});n.setC2ShowFunction(function(n){n.show()});n.addEventHandler("OnOptionClicked",this.e13642_client);this.setUserControl(n);this.GRID_EMPOWERERContainer=gx.uc.getNew(this,41,20,"WWP_GridEmpowerer","GRID_EMPOWERERContainer","Grid_empowerer","GRID_EMPOWERER");u=this.GRID_EMPOWERERContainer;u.setProp("Class","Class","","char");u.setProp("Enabled","Enabled",!0,"boolean");u.setDynProp("GridInternalName","Gridinternalname","","char");u.setProp("HasCategories","Hascategories",!1,"bool");u.setProp("InfiniteScrolling","Infinitescrolling","False","str");u.setProp("HasTitleSettings","Hastitlesettings",!0,"bool");u.setProp("HasColumnsSelector","Hascolumnsselector",!1,"bool");u.setProp("HasRowGroups","Hasrowgroups",!1,"bool");u.setProp("FixedColumns","Fixedcolumns","","str");u.setProp("PopoversInGrid","Popoversingrid","","str");u.setProp("Visible","Visible",!0,"bool");u.setC2ShowFunction(function(n){n.show()});this.setUserControl(u);i[2]={id:2,fld:"",grid:0};i[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};i[4]={id:4,fld:"",grid:0};i[5]={id:5,fld:"",grid:0};i[6]={id:6,fld:"TABLEMAIN",grid:0};i[7]={id:7,fld:"",grid:0};i[8]={id:8,fld:"",grid:0};i[9]={id:9,fld:"TABLEHEADER",grid:0};i[10]={id:10,fld:"",grid:0};i[11]={id:11,fld:"TABLEHEADERCONTENT",grid:0};i[12]={id:12,fld:"",grid:0};i[13]={id:13,fld:"",grid:0};i[14]={id:14,fld:"TABLEFILTERS",grid:0};i[17]={id:17,fld:"CLEANFILTERS",format:1,grid:0,evt:"e14642_client",ctrltype:"textblock"};i[19]={id:19,fld:"",grid:0};i[20]={id:20,lvl:0,type:"svchar",len:100,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[this.GridContainer],fld:"vFILTERFULLTEXT",fmt:0,gxz:"ZV12FilterFullText",gxold:"OV12FilterFullText",gxvar:"AV12FilterFullText",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV12FilterFullText=n)},v2z:function(n){n!==undefined&&(gx.O.ZV12FilterFullText=n)},v2c:function(){gx.fn.setControlValue("vFILTERFULLTEXT",gx.O.AV12FilterFullText,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.AV12FilterFullText=this.val())},val:function(){return gx.fn.getControlValue("vFILTERFULLTEXT")},nac:gx.falseFn};this.declareDomainHdlr(20,function(){});i[21]={id:21,fld:"",grid:0};i[22]={id:22,fld:"",grid:0};i[23]={id:23,fld:"GRIDTABLEWITHPAGINATIONBAR",grid:0};i[24]={id:24,fld:"",grid:0};i[25]={id:25,fld:"",grid:0};i[27]={id:27,lvl:2,type:"char",len:20,dec:0,sign:!1,ro:0,isacc:0,grid:26,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vSELECT",fmt:1,gxz:"ZV18Select",gxold:"OV18Select",gxvar:"AV18Select",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.AV18Select=n)},v2z:function(n){n!==undefined&&(gx.O.ZV18Select=n)},v2c:function(n){gx.fn.setGridControlValue("vSELECT",n||gx.fn.currentGridRowImpl(26),gx.O.AV18Select,1)},c2v:function(n){this.val(n)!==undefined&&(gx.O.AV18Select=this.val(n))},val:function(n){return gx.fn.getGridControlValue("vSELECT",n||gx.fn.currentGridRowImpl(26))},nac:gx.falseFn,evt:"e18642_client",std:"ENTER"};i[28]={id:28,lvl:2,type:"int",len:11,dec:0,sign:!1,pic:"ZZZZZZZZZZ9",ro:1,isacc:0,grid:26,gxgrid:this.GridContainer,fnc:this.Valid_Usuarioid,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"USUARIOID",fmt:0,gxz:"Z14UsuarioId",gxold:"O14UsuarioId",gxvar:"A14UsuarioId",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.A14UsuarioId=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z14UsuarioId=gx.num.intval(n))},v2c:function(n){gx.fn.setGridControlValue("USUARIOID",n||gx.fn.currentGridRowImpl(26),gx.O.A14UsuarioId,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A14UsuarioId=gx.num.intval(this.val(n)))},val:function(n){return gx.fn.getGridIntegerValue("USUARIOID",n||gx.fn.currentGridRowImpl(26),gx.thousandSeparator)},nac:gx.falseFn};i[29]={id:29,lvl:2,type:"char",len:20,dec:0,sign:!1,ro:1,isacc:0,grid:26,gxgrid:this.GridContainer,fnc:this.Valid_Usuarionom,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"USUARIONOM",fmt:0,gxz:"Z271UsuarioNom",gxold:"O271UsuarioNom",gxvar:"A271UsuarioNom",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.A271UsuarioNom=n)},v2z:function(n){n!==undefined&&(gx.O.Z271UsuarioNom=n)},v2c:function(n){gx.fn.setGridControlValue("USUARIONOM",n||gx.fn.currentGridRowImpl(26),gx.O.A271UsuarioNom,0)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A271UsuarioNom=this.val(n))},val:function(n){return gx.fn.getGridControlValue("USUARIONOM",n||gx.fn.currentGridRowImpl(26))},nac:gx.falseFn};i[30]={id:30,lvl:2,type:"int",len:11,dec:0,sign:!1,pic:"ZZZZZZZZZZ9",ro:1,isacc:0,grid:26,gxgrid:this.GridContainer,fnc:this.Valid_Personaid,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"PERSONAID",fmt:0,gxz:"Z1PersonaId",gxold:"O1PersonaId",gxvar:"A1PersonaId",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.A1PersonaId=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z1PersonaId=gx.num.intval(n))},v2c:function(n){gx.fn.setGridControlValue("PERSONAID",n||gx.fn.currentGridRowImpl(26),gx.O.A1PersonaId,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A1PersonaId=gx.num.intval(this.val(n)))},val:function(n){return gx.fn.getGridIntegerValue("PERSONAID",n||gx.fn.currentGridRowImpl(26),gx.thousandSeparator)},nac:gx.falseFn};i[31]={id:31,lvl:2,type:"svchar",len:100,dec:0,sign:!1,ro:1,isacc:0,grid:26,gxgrid:this.GridContainer,fnc:this.Valid_Personacorreo,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"PERSONACORREO",fmt:0,gxz:"Z69PersonaCorreo",gxold:"O69PersonaCorreo",gxvar:"A69PersonaCorreo",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"email",v2v:function(n){n!==undefined&&(gx.O.A69PersonaCorreo=n)},v2z:function(n){n!==undefined&&(gx.O.Z69PersonaCorreo=n)},v2c:function(n){gx.fn.setGridControlValue("PERSONACORREO",n||gx.fn.currentGridRowImpl(26),gx.O.A69PersonaCorreo,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A69PersonaCorreo=this.val(n))},val:function(n){return gx.fn.getGridControlValue("PERSONACORREO",n||gx.fn.currentGridRowImpl(26))},nac:gx.falseFn};i[32]={id:32,lvl:2,type:"char",len:128,dec:0,sign:!1,ro:1,isacc:0,grid:26,gxgrid:this.GridContainer,fnc:this.Valid_Deviceid,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"DEVICEID",fmt:0,gxz:"Z16DeviceId",gxold:"O16DeviceId",gxvar:"A16DeviceId",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.A16DeviceId=n)},v2z:function(n){n!==undefined&&(gx.O.Z16DeviceId=n)},v2c:function(n){gx.fn.setGridControlValue("DEVICEID",n||gx.fn.currentGridRowImpl(26),gx.O.A16DeviceId,0)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A16DeviceId=this.val(n))},val:function(n){return gx.fn.getGridControlValue("DEVICEID",n||gx.fn.currentGridRowImpl(26))},nac:gx.falseFn};i[33]={id:33,lvl:2,type:"int",len:1,dec:0,sign:!1,pic:"9",ro:1,isacc:0,grid:26,gxgrid:this.GridContainer,fnc:this.Valid_Devicetype,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"DEVICETYPE",fmt:0,gxz:"Z15DeviceType",gxold:"O15DeviceType",gxvar:"A15DeviceType",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"combo",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.A15DeviceType=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z15DeviceType=gx.num.intval(n))},v2c:function(n){gx.fn.setGridComboBoxValue("DEVICETYPE",n||gx.fn.currentGridRowImpl(26),gx.O.A15DeviceType);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A15DeviceType=gx.num.intval(this.val(n)))},val:function(n){return gx.fn.getGridIntegerValue("DEVICETYPE",n||gx.fn.currentGridRowImpl(26),gx.thousandSeparator)},nac:gx.falseFn};i[34]={id:34,fld:"",grid:0};i[35]={id:35,fld:"",grid:0};i[37]={id:37,fld:"",grid:0};i[38]={id:38,fld:"",grid:0};i[39]={id:39,fld:"HTML_BOTTOMAUXILIARCONTROLS",grid:0};this.AV12FilterFullText="";this.ZV12FilterFullText="";this.OV12FilterFullText="";this.ZV18Select="";this.OV18Select="";this.Z14UsuarioId=0;this.O14UsuarioId=0;this.Z271UsuarioNom="";this.O271UsuarioNom="";this.Z1PersonaId=0;this.O1PersonaId=0;this.Z69PersonaCorreo="";this.O69PersonaCorreo="";this.Z16DeviceId="";this.O16DeviceId="";this.Z15DeviceType=0;this.O15DeviceType=0;this.AV12FilterFullText="";this.AV15GridCurrentPage=0;this.AV13DDO_TitleSettingsIcons={Default_fi:"",Filtered_fi:"",SortedASC_fi:"",SortedDSC_fi:"",FilteredSortedASC_fi:"",FilteredSortedDSC_fi:"",OptionSortASC_fi:"",OptionSortDSC_fi:"",OptionApplyFilter_fi:"",OptionFilteringData_fi:"",OptionCleanFilters_fi:"",SelectedOption_fi:"",MultiselOption_fi:"",MultiselSelOption_fi:"",TreeviewCollapse_fi:"",TreeviewExpand_fi:"",FixLeft_fi:"",FixRight_fi:"",OptionGroup_fi:""};this.AV8InOutUsuarioId=0;this.AV18Select="";this.A14UsuarioId=0;this.A271UsuarioNom="";this.A1PersonaId=0;this.A69PersonaCorreo="";this.A16DeviceId="";this.A15DeviceType=0;this.AV21Pgmname="";this.AV10OrderedBy=0;this.AV11OrderedDsc=!1;this.Events={e11642_client:["GRIDPAGINATIONBAR.CHANGEPAGE",!0],e12642_client:["GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",!0],e13642_client:["DDO_GRID.ONOPTIONCLICKED",!0],e18642_client:["ENTER",!0],e14642_client:["'DOCLEANFILTERS'",!0],e19642_client:["CANCEL",!0]};this.EvtParms.REFRESH=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{ctrl:"GRID",prop:"Rows"},{av:"AV12FilterFullText",fld:"vFILTERFULLTEXT",pic:""},{av:"AV21Pgmname",fld:"vPGMNAME",pic:"",hsh:!0}],[{av:"AV15GridCurrentPage",fld:"vGRIDCURRENTPAGE",pic:"ZZZZZZZZZ9"},{av:"AV16GridPageCount",fld:"vGRIDPAGECOUNT",pic:"ZZZZZZZZZ9"},{av:"AV17GridAppliedFilters",fld:"vGRIDAPPLIEDFILTERS",pic:""}]];this.EvtParms["GRIDPAGINATIONBAR.CHANGEPAGE"]=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{ctrl:"GRID",prop:"Rows"},{av:"AV12FilterFullText",fld:"vFILTERFULLTEXT",pic:""},{av:"AV21Pgmname",fld:"vPGMNAME",pic:"",hsh:!0},{av:"this.GRIDPAGINATIONBARContainer.SelectedPage",ctrl:"GRIDPAGINATIONBAR",prop:"SelectedPage"}],[]];this.EvtParms["GRIDPAGINATIONBAR.CHANGEROWSPERPAGE"]=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{ctrl:"GRID",prop:"Rows"},{av:"AV12FilterFullText",fld:"vFILTERFULLTEXT",pic:""},{av:"AV21Pgmname",fld:"vPGMNAME",pic:"",hsh:!0},{av:"this.GRIDPAGINATIONBARContainer.RowsPerPageSelectedValue",ctrl:"GRIDPAGINATIONBAR",prop:"RowsPerPageSelectedValue"}],[{ctrl:"GRID",prop:"Rows"}]];this.EvtParms["DDO_GRID.ONOPTIONCLICKED"]=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{ctrl:"GRID",prop:"Rows"},{av:"AV12FilterFullText",fld:"vFILTERFULLTEXT",pic:""},{av:"AV21Pgmname",fld:"vPGMNAME",pic:"",hsh:!0},{av:"this.DDO_GRIDContainer.ActiveEventKey",ctrl:"DDO_GRID",prop:"ActiveEventKey"},{av:"this.DDO_GRIDContainer.SelectedValue_get",ctrl:"DDO_GRID",prop:"SelectedValue_get"},{av:"AV10OrderedBy",fld:"vORDEREDBY",pic:"ZZZ9"},{av:"AV11OrderedDsc",fld:"vORDEREDDSC",pic:""}],[{av:"AV10OrderedBy",fld:"vORDEREDBY",pic:"ZZZ9"},{av:"AV11OrderedDsc",fld:"vORDEREDDSC",pic:""},{av:"this.DDO_GRIDContainer.SortedStatus",ctrl:"DDO_GRID",prop:"SortedStatus"}]];this.EvtParms["GRID.LOAD"]=[[],[{av:"AV18Select",fld:"vSELECT",pic:""}]];this.EvtParms.ENTER=[[{av:"A14UsuarioId",fld:"USUARIOID",pic:"ZZZZZZZZZZ9",hsh:!0}],[{av:"AV8InOutUsuarioId",fld:"vINOUTUSUARIOID",pic:"ZZZZZZZZZZ9"}]];this.EvtParms["'DOCLEANFILTERS'"]=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{ctrl:"GRID",prop:"Rows"},{av:"AV12FilterFullText",fld:"vFILTERFULLTEXT",pic:""},{av:"AV21Pgmname",fld:"vPGMNAME",pic:"",hsh:!0}],[{av:"AV12FilterFullText",fld:"vFILTERFULLTEXT",pic:""}]];this.EvtParms.VALID_USUARIOID=[[],[]];this.EvtParms.VALID_USUARIONOM=[[],[]];this.EvtParms.VALID_PERSONAID=[[],[]];this.EvtParms.VALID_PERSONACORREO=[[],[]];this.EvtParms.VALID_DEVICEID=[[],[]];this.EvtParms.VALID_DEVICETYPE=[[],[]];this.EnterCtrl=["vSELECT"];this.setVCMap("AV21Pgmname","vPGMNAME",0,"char",129,0);this.setVCMap("AV10OrderedBy","vORDEREDBY",0,"int",4,0);this.setVCMap("AV11OrderedDsc","vORDEREDDSC",0,"boolean",4,0);this.setVCMap("AV8InOutUsuarioId","vINOUTUSUARIOID",0,"int",11,0);this.setVCMap("AV21Pgmname","vPGMNAME",0,"char",129,0);this.setVCMap("AV21Pgmname","vPGMNAME",0,"char",129,0);r.addRefreshingParm({rfrProp:"Rows",gxGrid:"Grid"});r.addRefreshingVar(this.GXValidFnc[20]);r.addRefreshingVar({rfrVar:"AV21Pgmname"});r.addRefreshingParm(this.GXValidFnc[20]);r.addRefreshingParm({rfrVar:"AV21Pgmname"});this.Initialize();this.setSDTMapping("WWPBaseObjects\\DVB_SDTDropDownOptionsTitleSettingsIcons",{Default_fi:{extr:"def"},Filtered_fi:{extr:"fil"},SortedASC_fi:{extr:"asc"},SortedDSC_fi:{extr:"dsc"},FilteredSortedASC_fi:{extr:"fasc"},FilteredSortedDSC_fi:{extr:"fdsc"},OptionSortASC_fi:{extr:"osasc"},OptionSortDSC_fi:{extr:"osdsc"},OptionApplyFilter_fi:{extr:"app"},OptionFilteringData_fi:{extr:"fildata"},OptionCleanFilters_fi:{extr:"cle"},SelectedOption_fi:{extr:"selo"},MultiselOption_fi:{extr:"mul"},MultiselSelOption_fi:{extr:"muls"},TreeviewCollapse_fi:{extr:"tcol"},TreeviewExpand_fi:{extr:"texp"},FixLeft_fi:{extr:"fixl"},FixRight_fi:{extr:"fixr"},OptionGroup_fi:{extr:"og"}})});gx.wi(function(){gx.createParentObj(this.usuarioprompt)})