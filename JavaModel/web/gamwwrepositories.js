gx.evt.autoSkip=!1;gx.define("gamwwrepositories",!1,function(){var n,i,t,u,r;this.ServerClass="gamwwrepositories";this.PackageName="com.mujermorena";this.ServerFullClass="com.mujermorena.gamwwrepositories";this.setObjectType("web");this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.AV52ManageFiltersExecutionStep=gx.fn.getIntegerValue("vMANAGEFILTERSEXECUTIONSTEP",gx.thousandSeparator);this.AV72Pgmname=gx.fn.getControlValue("vPGMNAME");this.AV65IsAuthorized_Display=gx.fn.getControlValue("vISAUTHORIZED_DISPLAY");this.AV66IsAuthorized_Update=gx.fn.getControlValue("vISAUTHORIZED_UPDATE");this.AV67IsAuthorized_Delete=gx.fn.getControlValue("vISAUTHORIZED_DELETE");this.AV21IsAuthorized_Id=gx.fn.getControlValue("vISAUTHORIZED_ID");this.AV33GridState=gx.fn.getControlValue("vGRIDSTATE");this.AV68IsAuthorized_Insert=gx.fn.getControlValue("vISAUTHORIZED_INSERT");this.AV52ManageFiltersExecutionStep=gx.fn.getIntegerValue("vMANAGEFILTERSEXECUTIONSTEP",gx.thousandSeparator);this.AV72Pgmname=gx.fn.getControlValue("vPGMNAME");this.AV65IsAuthorized_Display=gx.fn.getControlValue("vISAUTHORIZED_DISPLAY");this.AV66IsAuthorized_Update=gx.fn.getControlValue("vISAUTHORIZED_UPDATE");this.AV67IsAuthorized_Delete=gx.fn.getControlValue("vISAUTHORIZED_DELETE");this.AV21IsAuthorized_Id=gx.fn.getControlValue("vISAUTHORIZED_ID")};this.s162_client=function(){this.AV69Search=""};this.e121m2_client=function(){return this.executeServerEvent("GRIDPAGINATIONBAR.CHANGEPAGE",!1,null,!0,!0)};this.e131m2_client=function(){return this.executeServerEvent("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",!1,null,!0,!0)};this.e111m2_client=function(){return this.executeServerEvent("DDO_MANAGEFILTERS.ONOPTIONCLICKED",!1,null,!0,!0)};this.e141m2_client=function(){return this.executeServerEvent("'DOINSERT'",!0,null,!1,!1)};this.e181m2_client=function(){return this.executeServerEvent("ENTER",!0,arguments[0],!1,!1)};this.e191m2_client=function(){return this.executeServerEvent("CANCEL",!0,arguments[0],!1,!1)};this.GXValidFnc=[];n=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,25,28,29,30,31,32,34,35,36,37,38,40,41,42,43,44,45,46,48,49,50];this.GXLastCtrlId=50;this.GridContainer=new gx.grid.grid(this,2,"WbpLvl2",39,"Grid","Grid","GridContainer",this.CmpContext,this.IsMasterPage,"gamwwrepositories",[],!1,1,!1,!0,0,!1,!1,!1,"",0,"px",0,"px",gx.getMessage("GXM_newrow"),!0,!1,!1,null,null,!1,"",!1,[1,1,1,1],!1,0,!0,!1);i=this.GridContainer;i.addSingleLineEdit("Display",40,"vDISPLAY","",gx.getMessage("GXM_display"),"Display","char",0,"px",20,20,"left",null,[],"Display","Display",!0,0,!1,!1,"Attribute",0,"WWIconActionColumn");i.addSingleLineEdit("Update",41,"vUPDATE","",gx.getMessage("GXM_update"),"Update","char",0,"px",20,20,"left",null,[],"Update","Update",!0,0,!1,!1,"Attribute",0,"WWIconActionColumn");i.addSingleLineEdit("Delete",42,"vDELETE","",gx.getMessage("GX_BtnDelete"),"Delete","char",0,"px",20,20,"left",null,[],"Delete","Delete",!0,0,!1,!1,"Attribute",0,"WWIconActionColumn");i.addSingleLineEdit("Id",43,"vID",gx.getMessage("WWP_GAM_Id"),"","Id","int",0,"px",12,12,"right",null,[],"Id","Id",!0,0,!1,!1,"AttributeRealWidth",0,"WWColumn hidden-xs");i.addSingleLineEdit("Name",44,"vNAME",gx.getMessage("WWP_GAM_Name"),"","Name","char",570,"px",254,80,"left",null,[],"Name","Name",!0,0,!1,!1,"AttributeRealWidth",0,"WWColumn");this.GridContainer.emptyText=gx.getMessage("");this.setGrid(i);this.GRIDPAGINATIONBARContainer=gx.uc.getNew(this,47,30,"DVelop_DVPaginationBar","GRIDPAGINATIONBARContainer","Gridpaginationbar","GRIDPAGINATIONBAR");t=this.GRIDPAGINATIONBARContainer;t.setProp("Enabled","Enabled",!0,"boolean");t.setProp("Class","Class","PaginationBar","str");t.setProp("ShowFirst","Showfirst",!1,"bool");t.setProp("ShowPrevious","Showprevious",!0,"bool");t.setProp("ShowNext","Shownext",!0,"bool");t.setProp("ShowLast","Showlast",!1,"bool");t.setProp("PagesToShow","Pagestoshow",5,"num");t.setProp("PagingButtonsPosition","Pagingbuttonsposition","Right","str");t.setProp("PagingCaptionPosition","Pagingcaptionposition","Left","str");t.setProp("EmptyGridClass","Emptygridclass","PaginationBarEmptyGrid","str");t.setProp("SelectedPage","Selectedpage","","char");t.setProp("RowsPerPageSelector","Rowsperpageselector",!0,"bool");t.setDynProp("RowsPerPageSelectedValue","Rowsperpageselectedvalue",10,"num");t.setProp("RowsPerPageOptions","Rowsperpageoptions","5:WWP_Rows5,10:WWP_Rows10,20:WWP_Rows20,50:WWP_Rows50","str");t.setProp("First","First","First","str");t.setProp("Previous","Previous","WWP_PagingPreviousCaption","str");t.setProp("Next","Next","WWP_PagingNextCaption","str");t.setProp("Last","Last","Last","str");t.setProp("Caption","Caption",gx.getMessage("WWP_PagingCaption"),"str");t.setProp("EmptyGridCaption","Emptygridcaption","WWP_PagingEmptyGridCaption","str");t.setProp("RowsPerPageCaption","Rowsperpagecaption","WWP_PagingRowsPerPage","str");t.addV2CFunction("AV59GridCurrentPage","vGRIDCURRENTPAGE","SetCurrentPage");t.addC2VFunction(function(n){n.ParentObject.AV59GridCurrentPage=n.GetCurrentPage();gx.fn.setControlValue("vGRIDCURRENTPAGE",n.ParentObject.AV59GridCurrentPage)});t.addV2CFunction("AV24GridPageCount","vGRIDPAGECOUNT","SetPageCount");t.addC2VFunction(function(n){n.ParentObject.AV24GridPageCount=n.GetPageCount();gx.fn.setControlValue("vGRIDPAGECOUNT",n.ParentObject.AV24GridPageCount)});t.setProp("RecordCount","Recordcount","","str");t.setProp("Page","Page","","str");t.addV2CFunction("AV62GridAppliedFilters","vGRIDAPPLIEDFILTERS","SetAppliedFilters");t.addC2VFunction(function(n){n.ParentObject.AV62GridAppliedFilters=n.GetAppliedFilters();gx.fn.setControlValue("vGRIDAPPLIEDFILTERS",n.ParentObject.AV62GridAppliedFilters)});t.setProp("Visible","Visible",!0,"bool");t.setProp("Gx Control Type","Gxcontroltype","","int");t.setC2ShowFunction(function(n){n.show()});t.addEventHandler("ChangePage",this.e121m2_client);t.addEventHandler("ChangeRowsPerPage",this.e131m2_client);this.setUserControl(t);this.GRID_EMPOWERERContainer=gx.uc.getNew(this,51,30,"WWP_GridEmpowerer","GRID_EMPOWERERContainer","Grid_empowerer","GRID_EMPOWERER");u=this.GRID_EMPOWERERContainer;u.setProp("Class","Class","","char");u.setProp("Enabled","Enabled",!0,"boolean");u.setDynProp("GridInternalName","Gridinternalname","","char");u.setProp("HasCategories","Hascategories",!1,"bool");u.setProp("InfiniteScrolling","Infinitescrolling","False","str");u.setProp("HasTitleSettings","Hastitlesettings",!1,"bool");u.setProp("HasColumnsSelector","Hascolumnsselector",!1,"bool");u.setProp("HasRowGroups","Hasrowgroups",!1,"bool");u.setProp("FixedColumns","Fixedcolumns","","str");u.setProp("PopoversInGrid","Popoversingrid","","str");u.setProp("Visible","Visible",!0,"bool");u.setC2ShowFunction(function(n){n.show()});this.setUserControl(u);this.DDO_MANAGEFILTERSContainer=gx.uc.getNew(this,23,0,"BootstrapDropDownOptions","DDO_MANAGEFILTERSContainer","Ddo_managefilters","DDO_MANAGEFILTERS");r=this.DDO_MANAGEFILTERSContainer;r.setProp("Class","Class","","char");r.setProp("Enabled","Enabled",!0,"boolean");r.setProp("IconType","Icontype","FontIcon","str");r.setProp("Icon","Icon","fas fa-filter","str");r.setProp("Caption","Caption","","str");r.setProp("Tooltip","Tooltip","WWP_ManageFiltersTooltip","str");r.setProp("Cls","Cls","ManageFilters","str");r.setProp("ActiveEventKey","Activeeventkey","","char");r.setProp("TitleControlAlign","Titlecontrolalign","Automatic","str");r.setProp("DropDownOptionsType","Dropdownoptionstype","Regular","str");r.setProp("Visible","Visible",!0,"bool");r.setProp("TitleControlIdToReplace","Titlecontrolidtoreplace","","str");r.addV2CFunction("AV56ManageFiltersData","vMANAGEFILTERSDATA","SetDropDownOptionsData");r.addC2VFunction(function(n){n.ParentObject.AV56ManageFiltersData=n.GetDropDownOptionsData();gx.fn.setControlValue("vMANAGEFILTERSDATA",n.ParentObject.AV56ManageFiltersData)});r.setProp("Gx Control Type","Gxcontroltype","","int");r.setC2ShowFunction(function(n){n.show()});r.addEventHandler("OnOptionClicked",this.e111m2_client);this.setUserControl(r);n[2]={id:2,fld:"",grid:0};n[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};n[4]={id:4,fld:"",grid:0};n[5]={id:5,fld:"",grid:0};n[6]={id:6,fld:"TABLEMAIN",grid:0};n[7]={id:7,fld:"",grid:0};n[8]={id:8,fld:"",grid:0};n[9]={id:9,fld:"TABLEHEADER",grid:0};n[10]={id:10,fld:"",grid:0};n[11]={id:11,fld:"",grid:0};n[12]={id:12,fld:"TABLEACTIONS",grid:0};n[13]={id:13,fld:"",grid:0};n[14]={id:14,fld:"",grid:0};n[15]={id:15,fld:"TEXTBLOCKTITLE",format:0,grid:0,ctrltype:"textblock"};n[16]={id:16,fld:"",grid:0};n[17]={id:17,fld:"",grid:0};n[18]={id:18,fld:"BTNINSERT",format:1,grid:0,evt:"e141m2_client",ctrltype:"textblock"};n[19]={id:19,fld:"",grid:0};n[20]={id:20,fld:"TABLERIGHTHEADER",grid:0};n[25]={id:25,fld:"TABLEFILTERS",grid:0};n[28]={id:28,fld:"",grid:0};n[29]={id:29,fld:"",grid:0};n[30]={id:30,lvl:0,type:"char",len:60,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vSEARCH",fmt:0,gxz:"ZV69Search",gxold:"OV69Search",gxvar:"AV69Search",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV69Search=n)},v2z:function(n){n!==undefined&&(gx.O.ZV69Search=n)},v2c:function(){gx.fn.setControlValue("vSEARCH",gx.O.AV69Search,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.AV69Search=this.val())},val:function(){return gx.fn.getControlValue("vSEARCH")},nac:gx.falseFn};this.declareDomainHdlr(30,function(){});n[31]={id:31,fld:"",grid:0};n[32]={id:32,fld:"",grid:0};n[34]={id:34,fld:"",grid:0};n[35]={id:35,fld:"",grid:0};n[36]={id:36,fld:"GRIDTABLEWITHPAGINATIONBAR",grid:0};n[37]={id:37,fld:"",grid:0};n[38]={id:38,fld:"",grid:0};n[40]={id:40,lvl:2,type:"char",len:20,dec:0,sign:!1,ro:1,isacc:0,grid:39,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vDISPLAY",fmt:1,gxz:"ZV63Display",gxold:"OV63Display",gxvar:"AV63Display",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.AV63Display=n)},v2z:function(n){n!==undefined&&(gx.O.ZV63Display=n)},v2c:function(n){gx.fn.setGridControlValue("vDISPLAY",n||gx.fn.currentGridRowImpl(39),gx.O.AV63Display,1)},c2v:function(n){this.val(n)!==undefined&&(gx.O.AV63Display=this.val(n))},val:function(n){return gx.fn.getGridControlValue("vDISPLAY",n||gx.fn.currentGridRowImpl(39))},nac:gx.falseFn};n[41]={id:41,lvl:2,type:"char",len:20,dec:0,sign:!1,ro:1,isacc:0,grid:39,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vUPDATE",fmt:1,gxz:"ZV64Update",gxold:"OV64Update",gxvar:"AV64Update",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.AV64Update=n)},v2z:function(n){n!==undefined&&(gx.O.ZV64Update=n)},v2c:function(n){gx.fn.setGridControlValue("vUPDATE",n||gx.fn.currentGridRowImpl(39),gx.O.AV64Update,1)},c2v:function(n){this.val(n)!==undefined&&(gx.O.AV64Update=this.val(n))},val:function(n){return gx.fn.getGridControlValue("vUPDATE",n||gx.fn.currentGridRowImpl(39))},nac:gx.falseFn};n[42]={id:42,lvl:2,type:"char",len:20,dec:0,sign:!1,ro:1,isacc:0,grid:39,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vDELETE",fmt:1,gxz:"ZV5Delete",gxold:"OV5Delete",gxvar:"AV5Delete",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.AV5Delete=n)},v2z:function(n){n!==undefined&&(gx.O.ZV5Delete=n)},v2c:function(n){gx.fn.setGridControlValue("vDELETE",n||gx.fn.currentGridRowImpl(39),gx.O.AV5Delete,1)},c2v:function(n){this.val(n)!==undefined&&(gx.O.AV5Delete=this.val(n))},val:function(n){return gx.fn.getGridControlValue("vDELETE",n||gx.fn.currentGridRowImpl(39))},nac:gx.falseFn};n[43]={id:43,lvl:2,type:"int",len:12,dec:0,sign:!1,pic:"ZZZZZZZZZZZ9",ro:1,isacc:0,grid:39,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vID",fmt:0,gxz:"ZV13Id",gxold:"OV13Id",gxvar:"AV13Id",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.AV13Id=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.ZV13Id=gx.num.intval(n))},v2c:function(n){gx.fn.setGridControlValue("vID",n||gx.fn.currentGridRowImpl(39),gx.O.AV13Id,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.AV13Id=gx.num.intval(this.val(n)))},val:function(n){return gx.fn.getGridIntegerValue("vID",n||gx.fn.currentGridRowImpl(39),gx.thousandSeparator)},nac:gx.falseFn};n[44]={id:44,lvl:2,type:"char",len:254,dec:0,sign:!1,ro:1,isacc:0,grid:39,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vNAME",fmt:0,gxz:"ZV14Name",gxold:"OV14Name",gxvar:"AV14Name",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.AV14Name=n)},v2z:function(n){n!==undefined&&(gx.O.ZV14Name=n)},v2c:function(n){gx.fn.setGridControlValue("vNAME",n||gx.fn.currentGridRowImpl(39),gx.O.AV14Name,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.AV14Name=this.val(n))},val:function(n){return gx.fn.getGridControlValue("vNAME",n||gx.fn.currentGridRowImpl(39))},nac:gx.falseFn};n[45]={id:45,fld:"",grid:0};n[46]={id:46,fld:"",grid:0};n[48]={id:48,fld:"",grid:0};n[49]={id:49,fld:"",grid:0};n[50]={id:50,fld:"HTML_BOTTOMAUXILIARCONTROLS",grid:0};this.AV69Search="";this.ZV69Search="";this.OV69Search="";this.ZV63Display="";this.OV63Display="";this.ZV64Update="";this.OV64Update="";this.ZV5Delete="";this.OV5Delete="";this.ZV13Id=0;this.OV13Id=0;this.ZV14Name="";this.OV14Name="";this.AV56ManageFiltersData=[];this.AV69Search="";this.AV59GridCurrentPage=0;this.AV63Display="";this.AV64Update="";this.AV5Delete="";this.AV13Id=0;this.AV14Name="";this.AV52ManageFiltersExecutionStep=0;this.AV72Pgmname="";this.AV65IsAuthorized_Display=!1;this.AV66IsAuthorized_Update=!1;this.AV67IsAuthorized_Delete=!1;this.AV21IsAuthorized_Id=!1;this.AV33GridState={CurrentPage:0,OrderedBy:0,OrderedDsc:!1,HidingSearch:0,PageSize:"",CollapsedRecords:"",GroupBy:"",FilterValues:[],DynamicFilters:[]};this.AV68IsAuthorized_Insert=!1;this.Events={e121m2_client:["GRIDPAGINATIONBAR.CHANGEPAGE",!0],e131m2_client:["GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",!0],e111m2_client:["DDO_MANAGEFILTERS.ONOPTIONCLICKED",!0],e141m2_client:["'DOINSERT'",!0],e181m2_client:["ENTER",!0],e191m2_client:["CANCEL",!0]};this.EvtParms.REFRESH=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{av:"AV52ManageFiltersExecutionStep",fld:"vMANAGEFILTERSEXECUTIONSTEP",pic:"9"},{ctrl:"GRID",prop:"Rows"},{av:"AV72Pgmname",fld:"vPGMNAME",pic:"",hsh:!0},{av:"AV69Search",fld:"vSEARCH",pic:""},{av:"AV65IsAuthorized_Display",fld:"vISAUTHORIZED_DISPLAY",pic:"",hsh:!0},{av:"AV66IsAuthorized_Update",fld:"vISAUTHORIZED_UPDATE",pic:"",hsh:!0},{av:"AV67IsAuthorized_Delete",fld:"vISAUTHORIZED_DELETE",pic:"",hsh:!0},{av:"AV21IsAuthorized_Id",fld:"vISAUTHORIZED_ID",pic:"",hsh:!0},{av:"AV68IsAuthorized_Insert",fld:"vISAUTHORIZED_INSERT",pic:"",hsh:!0}],[{av:"AV52ManageFiltersExecutionStep",fld:"vMANAGEFILTERSEXECUTIONSTEP",pic:"9"},{av:"AV59GridCurrentPage",fld:"vGRIDCURRENTPAGE",pic:"ZZZZZZZZZ9"},{av:"AV62GridAppliedFilters",fld:"vGRIDAPPLIEDFILTERS",pic:""},{av:"AV65IsAuthorized_Display",fld:"vISAUTHORIZED_DISPLAY",pic:"",hsh:!0},{av:'gx.fn.getCtrlProperty("vDISPLAY","Visible")',ctrl:"vDISPLAY",prop:"Visible"},{av:"AV66IsAuthorized_Update",fld:"vISAUTHORIZED_UPDATE",pic:"",hsh:!0},{av:'gx.fn.getCtrlProperty("vUPDATE","Visible")',ctrl:"vUPDATE",prop:"Visible"},{av:"AV67IsAuthorized_Delete",fld:"vISAUTHORIZED_DELETE",pic:"",hsh:!0},{av:'gx.fn.getCtrlProperty("vDELETE","Visible")',ctrl:"vDELETE",prop:"Visible"},{av:"AV68IsAuthorized_Insert",fld:"vISAUTHORIZED_INSERT",pic:"",hsh:!0},{av:'gx.fn.getCtrlProperty("BTNINSERT","Visible")',ctrl:"BTNINSERT",prop:"Visible"},{av:"AV56ManageFiltersData",fld:"vMANAGEFILTERSDATA",pic:""},{av:"AV33GridState",fld:"vGRIDSTATE",pic:""}]];this.EvtParms["GRIDPAGINATIONBAR.CHANGEPAGE"]=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{ctrl:"GRID",prop:"Rows"},{av:"AV52ManageFiltersExecutionStep",fld:"vMANAGEFILTERSEXECUTIONSTEP",pic:"9"},{av:"AV72Pgmname",fld:"vPGMNAME",pic:"",hsh:!0},{av:"AV69Search",fld:"vSEARCH",pic:""},{av:"AV65IsAuthorized_Display",fld:"vISAUTHORIZED_DISPLAY",pic:"",hsh:!0},{av:"AV66IsAuthorized_Update",fld:"vISAUTHORIZED_UPDATE",pic:"",hsh:!0},{av:"AV67IsAuthorized_Delete",fld:"vISAUTHORIZED_DELETE",pic:"",hsh:!0},{av:"AV21IsAuthorized_Id",fld:"vISAUTHORIZED_ID",pic:"",hsh:!0},{av:"AV68IsAuthorized_Insert",fld:"vISAUTHORIZED_INSERT",pic:"",hsh:!0},{av:"this.GRIDPAGINATIONBARContainer.SelectedPage",ctrl:"GRIDPAGINATIONBAR",prop:"SelectedPage"}],[]];this.EvtParms["GRIDPAGINATIONBAR.CHANGEROWSPERPAGE"]=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{ctrl:"GRID",prop:"Rows"},{av:"AV52ManageFiltersExecutionStep",fld:"vMANAGEFILTERSEXECUTIONSTEP",pic:"9"},{av:"AV72Pgmname",fld:"vPGMNAME",pic:"",hsh:!0},{av:"AV69Search",fld:"vSEARCH",pic:""},{av:"AV65IsAuthorized_Display",fld:"vISAUTHORIZED_DISPLAY",pic:"",hsh:!0},{av:"AV66IsAuthorized_Update",fld:"vISAUTHORIZED_UPDATE",pic:"",hsh:!0},{av:"AV67IsAuthorized_Delete",fld:"vISAUTHORIZED_DELETE",pic:"",hsh:!0},{av:"AV21IsAuthorized_Id",fld:"vISAUTHORIZED_ID",pic:"",hsh:!0},{av:"AV68IsAuthorized_Insert",fld:"vISAUTHORIZED_INSERT",pic:"",hsh:!0},{av:"this.GRIDPAGINATIONBARContainer.RowsPerPageSelectedValue",ctrl:"GRIDPAGINATIONBAR",prop:"RowsPerPageSelectedValue"}],[{ctrl:"GRID",prop:"Rows"}]];this.EvtParms["GRID.LOAD"]=[[{ctrl:"GRID",prop:"Rows"},{av:"AV69Search",fld:"vSEARCH",pic:""},{av:"AV65IsAuthorized_Display",fld:"vISAUTHORIZED_DISPLAY",pic:"",hsh:!0},{av:"AV66IsAuthorized_Update",fld:"vISAUTHORIZED_UPDATE",pic:"",hsh:!0},{av:"AV67IsAuthorized_Delete",fld:"vISAUTHORIZED_DELETE",pic:"",hsh:!0},{av:"AV21IsAuthorized_Id",fld:"vISAUTHORIZED_ID",pic:"",hsh:!0}],[{av:"AV24GridPageCount",fld:"vGRIDPAGECOUNT",pic:"ZZZZZZZZZ9"},{av:"AV13Id",fld:"vID",pic:"ZZZZZZZZZZZ9"},{av:"AV14Name",fld:"vNAME",pic:""},{av:"AV63Display",fld:"vDISPLAY",pic:""},{av:'gx.fn.getCtrlProperty("vDISPLAY","Link")',ctrl:"vDISPLAY",prop:"Link"},{av:"AV64Update",fld:"vUPDATE",pic:""},{av:'gx.fn.getCtrlProperty("vUPDATE","Link")',ctrl:"vUPDATE",prop:"Link"},{av:"AV5Delete",fld:"vDELETE",pic:""},{av:'gx.fn.getCtrlProperty("vDELETE","Link")',ctrl:"vDELETE",prop:"Link"},{av:'gx.fn.getCtrlProperty("vID","Link")',ctrl:"vID",prop:"Link"}]];this.EvtParms["DDO_MANAGEFILTERS.ONOPTIONCLICKED"]=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{ctrl:"GRID",prop:"Rows"},{av:"AV52ManageFiltersExecutionStep",fld:"vMANAGEFILTERSEXECUTIONSTEP",pic:"9"},{av:"AV72Pgmname",fld:"vPGMNAME",pic:"",hsh:!0},{av:"AV69Search",fld:"vSEARCH",pic:""},{av:"AV65IsAuthorized_Display",fld:"vISAUTHORIZED_DISPLAY",pic:"",hsh:!0},{av:"AV66IsAuthorized_Update",fld:"vISAUTHORIZED_UPDATE",pic:"",hsh:!0},{av:"AV67IsAuthorized_Delete",fld:"vISAUTHORIZED_DELETE",pic:"",hsh:!0},{av:"AV21IsAuthorized_Id",fld:"vISAUTHORIZED_ID",pic:"",hsh:!0},{av:"AV68IsAuthorized_Insert",fld:"vISAUTHORIZED_INSERT",pic:"",hsh:!0},{av:"this.DDO_MANAGEFILTERSContainer.ActiveEventKey",ctrl:"DDO_MANAGEFILTERS",prop:"ActiveEventKey"},{av:"AV33GridState",fld:"vGRIDSTATE",pic:""}],[{av:"AV52ManageFiltersExecutionStep",fld:"vMANAGEFILTERSEXECUTIONSTEP",pic:"9"},{av:"AV33GridState",fld:"vGRIDSTATE",pic:""},{av:"AV69Search",fld:"vSEARCH",pic:""},{av:"AV59GridCurrentPage",fld:"vGRIDCURRENTPAGE",pic:"ZZZZZZZZZ9"},{av:"AV62GridAppliedFilters",fld:"vGRIDAPPLIEDFILTERS",pic:""},{av:"AV65IsAuthorized_Display",fld:"vISAUTHORIZED_DISPLAY",pic:"",hsh:!0},{av:'gx.fn.getCtrlProperty("vDISPLAY","Visible")',ctrl:"vDISPLAY",prop:"Visible"},{av:"AV66IsAuthorized_Update",fld:"vISAUTHORIZED_UPDATE",pic:"",hsh:!0},{av:'gx.fn.getCtrlProperty("vUPDATE","Visible")',ctrl:"vUPDATE",prop:"Visible"},{av:"AV67IsAuthorized_Delete",fld:"vISAUTHORIZED_DELETE",pic:"",hsh:!0},{av:'gx.fn.getCtrlProperty("vDELETE","Visible")',ctrl:"vDELETE",prop:"Visible"},{av:"AV68IsAuthorized_Insert",fld:"vISAUTHORIZED_INSERT",pic:"",hsh:!0},{av:'gx.fn.getCtrlProperty("BTNINSERT","Visible")',ctrl:"BTNINSERT",prop:"Visible"},{av:"AV56ManageFiltersData",fld:"vMANAGEFILTERSDATA",pic:""}]];this.EvtParms["'DOINSERT'"]=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{ctrl:"GRID",prop:"Rows"},{av:"AV52ManageFiltersExecutionStep",fld:"vMANAGEFILTERSEXECUTIONSTEP",pic:"9"},{av:"AV72Pgmname",fld:"vPGMNAME",pic:"",hsh:!0},{av:"AV69Search",fld:"vSEARCH",pic:""},{av:"AV65IsAuthorized_Display",fld:"vISAUTHORIZED_DISPLAY",pic:"",hsh:!0},{av:"AV66IsAuthorized_Update",fld:"vISAUTHORIZED_UPDATE",pic:"",hsh:!0},{av:"AV67IsAuthorized_Delete",fld:"vISAUTHORIZED_DELETE",pic:"",hsh:!0},{av:"AV21IsAuthorized_Id",fld:"vISAUTHORIZED_ID",pic:"",hsh:!0},{av:"AV68IsAuthorized_Insert",fld:"vISAUTHORIZED_INSERT",pic:"",hsh:!0}],[{av:"AV52ManageFiltersExecutionStep",fld:"vMANAGEFILTERSEXECUTIONSTEP",pic:"9"},{av:"AV59GridCurrentPage",fld:"vGRIDCURRENTPAGE",pic:"ZZZZZZZZZ9"},{av:"AV62GridAppliedFilters",fld:"vGRIDAPPLIEDFILTERS",pic:""},{av:"AV65IsAuthorized_Display",fld:"vISAUTHORIZED_DISPLAY",pic:"",hsh:!0},{av:'gx.fn.getCtrlProperty("vDISPLAY","Visible")',ctrl:"vDISPLAY",prop:"Visible"},{av:"AV66IsAuthorized_Update",fld:"vISAUTHORIZED_UPDATE",pic:"",hsh:!0},{av:'gx.fn.getCtrlProperty("vUPDATE","Visible")',ctrl:"vUPDATE",prop:"Visible"},{av:"AV67IsAuthorized_Delete",fld:"vISAUTHORIZED_DELETE",pic:"",hsh:!0},{av:'gx.fn.getCtrlProperty("vDELETE","Visible")',ctrl:"vDELETE",prop:"Visible"},{av:"AV68IsAuthorized_Insert",fld:"vISAUTHORIZED_INSERT",pic:"",hsh:!0},{av:'gx.fn.getCtrlProperty("BTNINSERT","Visible")',ctrl:"BTNINSERT",prop:"Visible"},{av:"AV56ManageFiltersData",fld:"vMANAGEFILTERSDATA",pic:""},{av:"AV33GridState",fld:"vGRIDSTATE",pic:""}]];this.EvtParms.ENTER=[[],[]];this.setVCMap("AV52ManageFiltersExecutionStep","vMANAGEFILTERSEXECUTIONSTEP",0,"int",1,0);this.setVCMap("AV72Pgmname","vPGMNAME",0,"char",129,0);this.setVCMap("AV65IsAuthorized_Display","vISAUTHORIZED_DISPLAY",0,"boolean",4,0);this.setVCMap("AV66IsAuthorized_Update","vISAUTHORIZED_UPDATE",0,"boolean",4,0);this.setVCMap("AV67IsAuthorized_Delete","vISAUTHORIZED_DELETE",0,"boolean",4,0);this.setVCMap("AV21IsAuthorized_Id","vISAUTHORIZED_ID",0,"boolean",4,0);this.setVCMap("AV33GridState","vGRIDSTATE",0,"WWPBaseObjectsWWPGridState",0,0);this.setVCMap("AV68IsAuthorized_Insert","vISAUTHORIZED_INSERT",0,"boolean",4,0);this.setVCMap("AV52ManageFiltersExecutionStep","vMANAGEFILTERSEXECUTIONSTEP",0,"int",1,0);this.setVCMap("AV72Pgmname","vPGMNAME",0,"char",129,0);this.setVCMap("AV65IsAuthorized_Display","vISAUTHORIZED_DISPLAY",0,"boolean",4,0);this.setVCMap("AV66IsAuthorized_Update","vISAUTHORIZED_UPDATE",0,"boolean",4,0);this.setVCMap("AV67IsAuthorized_Delete","vISAUTHORIZED_DELETE",0,"boolean",4,0);this.setVCMap("AV21IsAuthorized_Id","vISAUTHORIZED_ID",0,"boolean",4,0);this.setVCMap("AV52ManageFiltersExecutionStep","vMANAGEFILTERSEXECUTIONSTEP",0,"int",1,0);this.setVCMap("AV72Pgmname","vPGMNAME",0,"char",129,0);this.setVCMap("AV65IsAuthorized_Display","vISAUTHORIZED_DISPLAY",0,"boolean",4,0);this.setVCMap("AV66IsAuthorized_Update","vISAUTHORIZED_UPDATE",0,"boolean",4,0);this.setVCMap("AV67IsAuthorized_Delete","vISAUTHORIZED_DELETE",0,"boolean",4,0);this.setVCMap("AV21IsAuthorized_Id","vISAUTHORIZED_ID",0,"boolean",4,0);i.addRefreshingParm({rfrProp:"Rows",gxGrid:"Grid"});i.addRefreshingVar({rfrVar:"AV52ManageFiltersExecutionStep"});i.addRefreshingVar({rfrVar:"AV72Pgmname"});i.addRefreshingVar(this.GXValidFnc[30]);i.addRefreshingVar({rfrVar:"AV65IsAuthorized_Display"});i.addRefreshingVar({rfrVar:"AV66IsAuthorized_Update"});i.addRefreshingVar({rfrVar:"AV67IsAuthorized_Delete"});i.addRefreshingVar({rfrVar:"AV21IsAuthorized_Id"});i.addRefreshingVar({rfrVar:"AV68IsAuthorized_Insert"});i.addRefreshingParm({rfrVar:"AV52ManageFiltersExecutionStep"});i.addRefreshingParm({rfrVar:"AV72Pgmname"});i.addRefreshingParm(this.GXValidFnc[30]);i.addRefreshingParm({rfrVar:"AV65IsAuthorized_Display"});i.addRefreshingParm({rfrVar:"AV66IsAuthorized_Update"});i.addRefreshingParm({rfrVar:"AV67IsAuthorized_Delete"});i.addRefreshingParm({rfrVar:"AV21IsAuthorized_Id"});i.addRefreshingParm({rfrVar:"AV68IsAuthorized_Insert"});this.Initialize();this.setSDTMapping("WWPBaseObjects\\WWPGridState",{FilterValues:{sdt:"WWPBaseObjects\\WWPGridState.FilterValue"}});this.setSDTMapping("WWPBaseObjects\\WWPTransactionContext",{Attributes:{sdt:"WWPBaseObjects\\WWPTransactionContext.Attribute"}});this.setSDTMapping("WWPBaseObjects\\DVB_SDTDropDownOptionsTitleSettingsIcons",{Default_fi:{extr:"def"},Filtered_fi:{extr:"fil"},SortedASC_fi:{extr:"asc"},SortedDSC_fi:{extr:"dsc"},FilteredSortedASC_fi:{extr:"fasc"},FilteredSortedDSC_fi:{extr:"fdsc"},OptionSortASC_fi:{extr:"osasc"},OptionSortDSC_fi:{extr:"osdsc"},OptionApplyFilter_fi:{extr:"app"},OptionFilteringData_fi:{extr:"fildata"},OptionCleanFilters_fi:{extr:"cle"},SelectedOption_fi:{extr:"selo"},MultiselOption_fi:{extr:"mul"},MultiselSelOption_fi:{extr:"muls"},TreeviewCollapse_fi:{extr:"tcol"},TreeviewExpand_fi:{extr:"texp"},FixLeft_fi:{extr:"fixl"},FixRight_fi:{extr:"fixr"},OptionGroup_fi:{extr:"og"}})});gx.wi(function(){gx.createParentObj(this.gamwwrepositories)})