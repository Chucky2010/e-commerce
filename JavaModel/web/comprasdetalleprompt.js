gx.evt.autoSkip=!1;gx.define("comprasdetalleprompt",!1,function(){var t,r,i,n,u;this.ServerClass="comprasdetalleprompt";this.PackageName="com.mujermorena";this.ServerFullClass="com.mujermorena.comprasdetalleprompt";this.setObjectType("web");this.anyGridBaseTable=!0;this.hasEnterEvent=!0;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.AV22Pgmname=gx.fn.getControlValue("vPGMNAME");this.AV11OrderedBy=gx.fn.getIntegerValue("vORDEREDBY",gx.thousandSeparator);this.AV12OrderedDsc=gx.fn.getControlValue("vORDEREDDSC");this.AV8InComprasId=gx.fn.getIntegerValue("vINCOMPRASID",gx.thousandSeparator);this.AV9InOutComprasDetalleId=gx.fn.getIntegerValue("vINOUTCOMPRASDETALLEID",gx.thousandSeparator);this.AV8InComprasId=gx.fn.getIntegerValue("vINCOMPRASID",gx.thousandSeparator);this.AV22Pgmname=gx.fn.getControlValue("vPGMNAME")};this.Valid_Articuloid=function(){var n=gx.fn.currentGridRowImpl(26);return this.validCliEvt("Valid_Articuloid",26,function(){try{if(gx.fn.currentGridRowImpl(26)===0)return!0;var n=gx.util.balloon.getNew("ARTICULOID",gx.fn.currentGridRowImpl(26));this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Impuestoporcentaje=function(){var n=gx.fn.currentGridRowImpl(26);return this.validCliEvt("Valid_Impuestoporcentaje",26,function(){try{if(gx.fn.currentGridRowImpl(26)===0)return!0;var n=gx.util.balloon.getNew("IMPUESTOPORCENTAJE",gx.fn.currentGridRowImpl(26));this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Comprascantidad=function(){var n=gx.fn.currentGridRowImpl(26);return this.validCliEvt("Valid_Comprascantidad",26,function(){try{if(gx.fn.currentGridRowImpl(26)===0)return!0;var n=gx.util.balloon.getNew("COMPRASCANTIDAD",gx.fn.currentGridRowImpl(26));this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Comprasdetallepreciocompra=function(){var n=gx.fn.currentGridRowImpl(26);return this.validCliEvt("Valid_Comprasdetallepreciocompra",26,function(){try{if(gx.fn.currentGridRowImpl(26)===0)return!0;var n=gx.util.balloon.getNew("COMPRASDETALLEPRECIOCOMPRA",gx.fn.currentGridRowImpl(26));this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.s112_client=function(){this.DDO_GRIDContainer.SortedStatus=gx.text.trim(gx.num.str(this.AV11OrderedBy,4,0))+":"+(this.AV12OrderedDsc?"DSC":"ASC")};this.s122_client=function(){this.AV13FilterFullText=""};this.e114x2_client=function(){return this.executeServerEvent("GRIDPAGINATIONBAR.CHANGEPAGE",!1,null,!0,!0)};this.e124x2_client=function(){return this.executeServerEvent("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",!1,null,!0,!0)};this.e134x2_client=function(){return this.executeServerEvent("DDO_GRID.ONOPTIONCLICKED",!1,null,!0,!0)};this.e184x2_client=function(){return this.executeServerEvent("ENTER",!0,arguments[0],!1,!1)};this.e144x2_client=function(){return this.executeServerEvent("'DOCLEANFILTERS'",!0,null,!1,!1)};this.e194x2_client=function(){return this.executeServerEvent("CANCEL",!0,arguments[0],!1,!1)};this.GXValidFnc=[];t=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,12,13,14,17,19,20,21,22,23,24,25,27,28,29,30,31,32,33,34,35,36,37,38,39,40,42,43,44];this.GXLastCtrlId=44;this.GridContainer=new gx.grid.grid(this,2,"WbpLvl2",26,"Grid","Grid","GridContainer",this.CmpContext,this.IsMasterPage,"comprasdetalleprompt",[],!1,1,!1,!0,0,!1,!1,!1,"",0,"px",0,"px",gx.getMessage("GXM_newrow"),!0,!1,!1,null,null,!1,"",!1,[1,1,1,1],!1,0,!0,!1);r=this.GridContainer;r.addSingleLineEdit("Select",27,"vSELECT","",gx.getMessage("GX_BtnSelect"),"Select","char",0,"px",20,20,"left","e184x2_client",[],"Select","Select",!0,0,!1,!1,"Attribute",0,"WWIconActionColumn");r.addSingleLineEdit(12,28,"COMPRASDETALLEID",gx.getMessage("Detalle Id"),"","ComprasDetalleId","int",0,"px",11,11,"right",null,[],12,"ComprasDetalleId",!0,0,!1,!1,"AttributeRealWidth",0,"WWColumn");r.addSingleLineEdit(75,29,"COMPRASDETALLECANTIDAD",gx.getMessage("Detalle Cantidad"),"","ComprasDetalleCantidad","int",0,"px",5,5,"right",null,[],75,"ComprasDetalleCantidad",!0,0,!1,!1,"AttributeRealWidth",0,"WWColumn hidden-xs");r.addSingleLineEdit(13,30,"ARTICULOID",gx.getMessage("Articulo Id"),"","ArticuloId","int",0,"px",11,11,"right",null,[],13,"ArticuloId",!0,0,!1,!1,"AttributeRealWidth",0,"WWColumn hidden-xs");r.addSingleLineEdit(76,31,"ARTICULONOMBRE",gx.getMessage("Articulo Nombre"),"","ArticuloNombre","char",0,"px",80,80,"left",null,[],76,"ArticuloNombre",!0,0,!1,!1,"AttributeRealWidth",0,"WWColumn hidden-xs");r.addSingleLineEdit(83,32,"IMPUESTOPORCENTAJE",gx.getMessage("Impuesto Porcentaje"),"","ImpuestoPorcentaje","decimal",0,"px",9,9,"right",null,[],83,"ImpuestoPorcentaje",!0,2,!1,!1,"AttributeRealWidth",0,"WWColumn hidden-xs");r.addSingleLineEdit(82,33,"COMPRASCANTIDAD",gx.getMessage("Cantidad"),"","ComprasCantidad","int",0,"px",5,5,"right",null,[],82,"ComprasCantidad",!0,0,!1,!1,"AttributeRealWidth",0,"WWColumn hidden-xs");r.addSingleLineEdit(80,34,"COMPRASDETALLEPRECIOCOMPRA",gx.getMessage("Precio Compra"),"","ComprasDetallePrecioCompra","decimal",0,"px",21,21,"right",null,[],80,"ComprasDetallePrecioCompra",!0,2,!1,!1,"AttributeRealWidth",0,"WWColumn hidden-xs");r.addSingleLineEdit(291,35,"COMPRASDETALLETALLAID",gx.getMessage("Talla ID"),"","ComprasDetalleTallaID","int",0,"px",11,11,"right",null,[],291,"ComprasDetalleTallaID",!0,0,!1,!1,"AttributeRealWidth",0,"WWColumn hidden-xs");r.addSingleLineEdit(81,36,"COMPRASDETALLEEXENTO",gx.getMessage("Detalle Exento"),"","ComprasDetalleExento","decimal",0,"px",21,21,"right",null,[],81,"ComprasDetalleExento",!0,2,!1,!1,"AttributeRealWidth",0,"WWColumn hidden-xs");r.addSingleLineEdit(85,37,"COMPRASDETALLEIVA5",gx.getMessage("Detalle Iva5"),"","ComprasDetalleIva5","decimal",0,"px",21,21,"right",null,[],85,"ComprasDetalleIva5",!0,2,!1,!1,"AttributeRealWidth",0,"WWColumn hidden-xs");r.addSingleLineEdit(84,38,"COMPRASDETALLEIVA10",gx.getMessage("Detalle Iva10"),"","ComprasDetalleIva10","decimal",0,"px",21,21,"right",null,[],84,"ComprasDetalleIva10",!0,2,!1,!1,"AttributeRealWidth",0,"WWColumn hidden-xs");this.GridContainer.emptyText=gx.getMessage("");this.setGrid(r);this.GRIDPAGINATIONBARContainer=gx.uc.getNew(this,41,20,"DVelop_DVPaginationBar","GRIDPAGINATIONBARContainer","Gridpaginationbar","GRIDPAGINATIONBAR");i=this.GRIDPAGINATIONBARContainer;i.setProp("Enabled","Enabled",!0,"boolean");i.setProp("Class","Class","PaginationBar","str");i.setProp("ShowFirst","Showfirst",!1,"bool");i.setProp("ShowPrevious","Showprevious",!0,"bool");i.setProp("ShowNext","Shownext",!0,"bool");i.setProp("ShowLast","Showlast",!1,"bool");i.setProp("PagesToShow","Pagestoshow",5,"num");i.setProp("PagingButtonsPosition","Pagingbuttonsposition","Right","str");i.setProp("PagingCaptionPosition","Pagingcaptionposition","Left","str");i.setProp("EmptyGridClass","Emptygridclass","PaginationBarEmptyGrid","str");i.setProp("SelectedPage","Selectedpage","","char");i.setProp("RowsPerPageSelector","Rowsperpageselector",!0,"bool");i.setDynProp("RowsPerPageSelectedValue","Rowsperpageselectedvalue",10,"num");i.setProp("RowsPerPageOptions","Rowsperpageoptions","5:WWP_Rows5,10:WWP_Rows10,20:WWP_Rows20,50:WWP_Rows50","str");i.setProp("First","First","First","str");i.setProp("Previous","Previous","WWP_PagingPreviousCaption","str");i.setProp("Next","Next","WWP_PagingNextCaption","str");i.setProp("Last","Last","Last","str");i.setProp("Caption","Caption",gx.getMessage("WWP_PagingCaption"),"str");i.setProp("EmptyGridCaption","Emptygridcaption","WWP_PagingEmptyGridCaption","str");i.setProp("RowsPerPageCaption","Rowsperpagecaption","WWP_PagingRowsPerPage","str");i.addV2CFunction("AV16GridCurrentPage","vGRIDCURRENTPAGE","SetCurrentPage");i.addC2VFunction(function(n){n.ParentObject.AV16GridCurrentPage=n.GetCurrentPage();gx.fn.setControlValue("vGRIDCURRENTPAGE",n.ParentObject.AV16GridCurrentPage)});i.addV2CFunction("AV17GridPageCount","vGRIDPAGECOUNT","SetPageCount");i.addC2VFunction(function(n){n.ParentObject.AV17GridPageCount=n.GetPageCount();gx.fn.setControlValue("vGRIDPAGECOUNT",n.ParentObject.AV17GridPageCount)});i.setProp("RecordCount","Recordcount","","str");i.setProp("Page","Page","","str");i.addV2CFunction("AV18GridAppliedFilters","vGRIDAPPLIEDFILTERS","SetAppliedFilters");i.addC2VFunction(function(n){n.ParentObject.AV18GridAppliedFilters=n.GetAppliedFilters();gx.fn.setControlValue("vGRIDAPPLIEDFILTERS",n.ParentObject.AV18GridAppliedFilters)});i.setProp("Visible","Visible",!0,"bool");i.setProp("Gx Control Type","Gxcontroltype","","int");i.setC2ShowFunction(function(n){n.show()});i.addEventHandler("ChangePage",this.e114x2_client);i.addEventHandler("ChangeRowsPerPage",this.e124x2_client);this.setUserControl(i);this.DDO_GRIDContainer=gx.uc.getNew(this,45,20,"DDOGridTitleSettingsM","DDO_GRIDContainer","Ddo_grid","DDO_GRID");n=this.DDO_GRIDContainer;n.setProp("Class","Class","","char");n.setProp("Enabled","Enabled",!0,"boolean");n.setProp("IconType","Icontype","Image","str");n.setProp("Icon","Icon","","str");n.setProp("Caption","Caption","","str");n.setProp("Tooltip","Tooltip","","str");n.setProp("Cls","Cls","","str");n.setProp("ActiveEventKey","Activeeventkey","","char");n.setProp("FilteredText_set","Filteredtext_set","","char");n.setProp("FilteredText_get","Filteredtext_get","","char");n.setProp("FilteredTextTo_set","Filteredtextto_set","","char");n.setProp("FilteredTextTo_get","Filteredtextto_get","","char");n.setProp("SelectedValue_set","Selectedvalue_set","","char");n.setProp("SelectedValue_get","Selectedvalue_get","","char");n.setProp("SelectedText_set","Selectedtext_set","","char");n.setProp("SelectedText_get","Selectedtext_get","","char");n.setProp("SelectedColumn","Selectedcolumn","","char");n.setProp("SelectedColumnFixedFilter","Selectedcolumnfixedfilter","","char");n.setProp("GAMOAuthToken","Gamoauthtoken","","char");n.setProp("TitleControlAlign","Titlecontrolalign","","str");n.setProp("Visible","Visible","","str");n.setDynProp("GridInternalName","Gridinternalname","","str");n.setProp("ColumnIds","Columnids","1:ComprasDetalleId|2:ComprasDetalleCantidad|3:ArticuloId|4:ArticuloNombre|5:ImpuestoPorcentaje|6:ComprasCantidad|7:ComprasDetallePrecioCompra|8:ComprasDetalleTallaID","str");n.setProp("ColumnsSortValues","Columnssortvalues","1|2|3|4|5|6|7|8","str");n.setProp("IncludeSortASC","Includesortasc","T","str");n.setProp("IncludeSortDSC","Includesortdsc","","str");n.setProp("AllowGroup","Allowgroup","","str");n.setProp("Fixable","Fixable","","str");n.setDynProp("SortedStatus","Sortedstatus","","char");n.setProp("IncludeFilter","Includefilter","","str");n.setProp("FilterType","Filtertype","","str");n.setProp("FilterIsRange","Filterisrange","","str");n.setProp("IncludeDataList","Includedatalist","","str");n.setProp("DataListType","Datalisttype","","str");n.setProp("AllowMultipleSelection","Allowmultipleselection","","str");n.setProp("DataListFixedValues","Datalistfixedvalues","","str");n.setProp("DataListProc","Datalistproc","","str");n.setProp("DataListProcParametersPrefix","Datalistprocparametersprefix","","str");n.setProp("RemoteServicesParameters","Remoteservicesparameters","","str");n.setProp("DataListUpdateMinimumCharacters","Datalistupdateminimumcharacters",0,"num");n.setProp("FixedFilters","Fixedfilters","","str");n.setProp("Format","Format","","str");n.setProp("SelectedFixedFilter","Selectedfixedfilter","","char");n.setProp("SortASC","Sortasc","","str");n.setProp("SortDSC","Sortdsc","","str");n.setProp("AllowGroupText","Allowgrouptext","","str");n.setProp("LoadingData","Loadingdata","","str");n.setProp("CleanFilter","Cleanfilter","","str");n.setProp("RangeFilterFrom","Rangefilterfrom","","str");n.setProp("RangeFilterTo","Rangefilterto","","str");n.setProp("NoResultsFound","Noresultsfound","","str");n.setProp("SearchButtonText","Searchbuttontext","","str");n.addV2CFunction("AV14DDO_TitleSettingsIcons","vDDO_TITLESETTINGSICONS","SetDropDownOptionsTitleSettingsIcons");n.addC2VFunction(function(n){n.ParentObject.AV14DDO_TitleSettingsIcons=n.GetDropDownOptionsTitleSettingsIcons();gx.fn.setControlValue("vDDO_TITLESETTINGSICONS",n.ParentObject.AV14DDO_TitleSettingsIcons)});n.setC2ShowFunction(function(n){n.show()});n.addEventHandler("OnOptionClicked",this.e134x2_client);this.setUserControl(n);this.GRID_EMPOWERERContainer=gx.uc.getNew(this,46,20,"WWP_GridEmpowerer","GRID_EMPOWERERContainer","Grid_empowerer","GRID_EMPOWERER");u=this.GRID_EMPOWERERContainer;u.setProp("Class","Class","","char");u.setProp("Enabled","Enabled",!0,"boolean");u.setDynProp("GridInternalName","Gridinternalname","","char");u.setProp("HasCategories","Hascategories",!1,"bool");u.setProp("InfiniteScrolling","Infinitescrolling","False","str");u.setProp("HasTitleSettings","Hastitlesettings",!0,"bool");u.setProp("HasColumnsSelector","Hascolumnsselector",!1,"bool");u.setProp("HasRowGroups","Hasrowgroups",!1,"bool");u.setProp("FixedColumns","Fixedcolumns","","str");u.setProp("PopoversInGrid","Popoversingrid","","str");u.setProp("Visible","Visible",!0,"bool");u.setC2ShowFunction(function(n){n.show()});this.setUserControl(u);t[2]={id:2,fld:"",grid:0};t[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};t[4]={id:4,fld:"",grid:0};t[5]={id:5,fld:"",grid:0};t[6]={id:6,fld:"TABLEMAIN",grid:0};t[7]={id:7,fld:"",grid:0};t[8]={id:8,fld:"",grid:0};t[9]={id:9,fld:"TABLEHEADER",grid:0};t[10]={id:10,fld:"",grid:0};t[11]={id:11,fld:"TABLEHEADERCONTENT",grid:0};t[12]={id:12,fld:"",grid:0};t[13]={id:13,fld:"",grid:0};t[14]={id:14,fld:"TABLEFILTERS",grid:0};t[17]={id:17,fld:"CLEANFILTERS",format:1,grid:0,evt:"e144x2_client",ctrltype:"textblock"};t[19]={id:19,fld:"",grid:0};t[20]={id:20,lvl:0,type:"svchar",len:100,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[this.GridContainer],fld:"vFILTERFULLTEXT",fmt:0,gxz:"ZV13FilterFullText",gxold:"OV13FilterFullText",gxvar:"AV13FilterFullText",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV13FilterFullText=n)},v2z:function(n){n!==undefined&&(gx.O.ZV13FilterFullText=n)},v2c:function(){gx.fn.setControlValue("vFILTERFULLTEXT",gx.O.AV13FilterFullText,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.AV13FilterFullText=this.val())},val:function(){return gx.fn.getControlValue("vFILTERFULLTEXT")},nac:gx.falseFn};this.declareDomainHdlr(20,function(){});t[21]={id:21,fld:"",grid:0};t[22]={id:22,fld:"",grid:0};t[23]={id:23,fld:"GRIDTABLEWITHPAGINATIONBAR",grid:0};t[24]={id:24,fld:"",grid:0};t[25]={id:25,fld:"",grid:0};t[27]={id:27,lvl:2,type:"char",len:20,dec:0,sign:!1,ro:0,isacc:0,grid:26,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vSELECT",fmt:1,gxz:"ZV19Select",gxold:"OV19Select",gxvar:"AV19Select",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.AV19Select=n)},v2z:function(n){n!==undefined&&(gx.O.ZV19Select=n)},v2c:function(n){gx.fn.setGridControlValue("vSELECT",n||gx.fn.currentGridRowImpl(26),gx.O.AV19Select,1)},c2v:function(n){this.val(n)!==undefined&&(gx.O.AV19Select=this.val(n))},val:function(n){return gx.fn.getGridControlValue("vSELECT",n||gx.fn.currentGridRowImpl(26))},nac:gx.falseFn,evt:"e184x2_client",std:"ENTER"};t[28]={id:28,lvl:2,type:"int",len:11,dec:0,sign:!1,pic:"ZZZZZZZZZZ9",ro:1,isacc:0,grid:26,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"COMPRASDETALLEID",fmt:0,gxz:"Z12ComprasDetalleId",gxold:"O12ComprasDetalleId",gxvar:"A12ComprasDetalleId",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.A12ComprasDetalleId=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z12ComprasDetalleId=gx.num.intval(n))},v2c:function(n){gx.fn.setGridControlValue("COMPRASDETALLEID",n||gx.fn.currentGridRowImpl(26),gx.O.A12ComprasDetalleId,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A12ComprasDetalleId=gx.num.intval(this.val(n)))},val:function(n){return gx.fn.getGridIntegerValue("COMPRASDETALLEID",n||gx.fn.currentGridRowImpl(26),gx.thousandSeparator)},nac:gx.falseFn};t[29]={id:29,lvl:2,type:"int",len:5,dec:0,sign:!1,pic:"ZZZZ9",ro:1,isacc:0,grid:26,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"COMPRASDETALLECANTIDAD",fmt:0,gxz:"Z75ComprasDetalleCantidad",gxold:"O75ComprasDetalleCantidad",gxvar:"A75ComprasDetalleCantidad",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.A75ComprasDetalleCantidad=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z75ComprasDetalleCantidad=gx.num.intval(n))},v2c:function(n){gx.fn.setGridControlValue("COMPRASDETALLECANTIDAD",n||gx.fn.currentGridRowImpl(26),gx.O.A75ComprasDetalleCantidad,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A75ComprasDetalleCantidad=gx.num.intval(this.val(n)))},val:function(n){return gx.fn.getGridIntegerValue("COMPRASDETALLECANTIDAD",n||gx.fn.currentGridRowImpl(26),gx.thousandSeparator)},nac:gx.falseFn};t[30]={id:30,lvl:2,type:"int",len:11,dec:0,sign:!1,pic:"ZZZZZZZZZZ9",ro:1,isacc:0,grid:26,gxgrid:this.GridContainer,fnc:this.Valid_Articuloid,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"ARTICULOID",fmt:0,gxz:"Z13ArticuloId",gxold:"O13ArticuloId",gxvar:"A13ArticuloId",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.A13ArticuloId=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z13ArticuloId=gx.num.intval(n))},v2c:function(n){gx.fn.setGridControlValue("ARTICULOID",n||gx.fn.currentGridRowImpl(26),gx.O.A13ArticuloId,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A13ArticuloId=gx.num.intval(this.val(n)))},val:function(n){return gx.fn.getGridIntegerValue("ARTICULOID",n||gx.fn.currentGridRowImpl(26),gx.thousandSeparator)},nac:gx.falseFn};t[31]={id:31,lvl:2,type:"char",len:80,dec:0,sign:!1,ro:1,isacc:0,grid:26,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"ARTICULONOMBRE",fmt:0,gxz:"Z76ArticuloNombre",gxold:"O76ArticuloNombre",gxvar:"A76ArticuloNombre",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.A76ArticuloNombre=n)},v2z:function(n){n!==undefined&&(gx.O.Z76ArticuloNombre=n)},v2c:function(n){gx.fn.setGridControlValue("ARTICULONOMBRE",n||gx.fn.currentGridRowImpl(26),gx.O.A76ArticuloNombre,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A76ArticuloNombre=this.val(n))},val:function(n){return gx.fn.getGridControlValue("ARTICULONOMBRE",n||gx.fn.currentGridRowImpl(26))},nac:gx.falseFn};t[32]={id:32,lvl:2,type:"decimal",len:9,dec:2,sign:!1,pic:"ZZZZZ9.99",ro:1,isacc:0,grid:26,gxgrid:this.GridContainer,fnc:this.Valid_Impuestoporcentaje,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"IMPUESTOPORCENTAJE",fmt:0,gxz:"Z83ImpuestoPorcentaje",gxold:"O83ImpuestoPorcentaje",gxvar:"A83ImpuestoPorcentaje",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.A83ImpuestoPorcentaje=gx.fn.toDecimalValue(n,",","."))},v2z:function(n){n!==undefined&&(gx.O.Z83ImpuestoPorcentaje=gx.fn.toDecimalValue(n,gx.thousandSeparator,gx.decimalPoint))},v2c:function(n){gx.fn.setGridDecimalValue("IMPUESTOPORCENTAJE",n||gx.fn.currentGridRowImpl(26),gx.O.A83ImpuestoPorcentaje,2,gx.decimalPoint);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A83ImpuestoPorcentaje=this.val(n))},val:function(n){return gx.fn.getGridDecimalValue("IMPUESTOPORCENTAJE",n||gx.fn.currentGridRowImpl(26),gx.thousandSeparator,gx.decimalPoint)},nac:gx.falseFn};t[33]={id:33,lvl:2,type:"int",len:5,dec:0,sign:!1,pic:"ZZZZ9",ro:1,isacc:0,grid:26,gxgrid:this.GridContainer,fnc:this.Valid_Comprascantidad,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"COMPRASCANTIDAD",fmt:0,gxz:"Z82ComprasCantidad",gxold:"O82ComprasCantidad",gxvar:"A82ComprasCantidad",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.A82ComprasCantidad=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z82ComprasCantidad=gx.num.intval(n))},v2c:function(n){gx.fn.setGridControlValue("COMPRASCANTIDAD",n||gx.fn.currentGridRowImpl(26),gx.O.A82ComprasCantidad,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A82ComprasCantidad=gx.num.intval(this.val(n)))},val:function(n){return gx.fn.getGridIntegerValue("COMPRASCANTIDAD",n||gx.fn.currentGridRowImpl(26),gx.thousandSeparator)},nac:gx.falseFn};t[34]={id:34,lvl:2,type:"decimal",len:17,dec:2,sign:!1,pic:"ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99",ro:1,isacc:0,grid:26,gxgrid:this.GridContainer,fnc:this.Valid_Comprasdetallepreciocompra,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"COMPRASDETALLEPRECIOCOMPRA",fmt:0,gxz:"Z80ComprasDetallePrecioCompra",gxold:"O80ComprasDetallePrecioCompra",gxvar:"A80ComprasDetallePrecioCompra",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.A80ComprasDetallePrecioCompra=gx.fn.toDecimalValue(n,",","."))},v2z:function(n){n!==undefined&&(gx.O.Z80ComprasDetallePrecioCompra=gx.fn.toDecimalValue(n,gx.thousandSeparator,gx.decimalPoint))},v2c:function(n){gx.fn.setGridDecimalValue("COMPRASDETALLEPRECIOCOMPRA",n||gx.fn.currentGridRowImpl(26),gx.O.A80ComprasDetallePrecioCompra,2,gx.decimalPoint);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A80ComprasDetallePrecioCompra=this.val(n))},val:function(n){return gx.fn.getGridDecimalValue("COMPRASDETALLEPRECIOCOMPRA",n||gx.fn.currentGridRowImpl(26),gx.thousandSeparator,gx.decimalPoint)},nac:gx.falseFn};t[35]={id:35,lvl:2,type:"int",len:11,dec:0,sign:!1,pic:"ZZZZZZZZZZ9",ro:1,isacc:0,grid:26,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"COMPRASDETALLETALLAID",fmt:0,gxz:"Z291ComprasDetalleTallaID",gxold:"O291ComprasDetalleTallaID",gxvar:"A291ComprasDetalleTallaID",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.A291ComprasDetalleTallaID=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z291ComprasDetalleTallaID=gx.num.intval(n))},v2c:function(n){gx.fn.setGridControlValue("COMPRASDETALLETALLAID",n||gx.fn.currentGridRowImpl(26),gx.O.A291ComprasDetalleTallaID,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A291ComprasDetalleTallaID=gx.num.intval(this.val(n)))},val:function(n){return gx.fn.getGridIntegerValue("COMPRASDETALLETALLAID",n||gx.fn.currentGridRowImpl(26),gx.thousandSeparator)},nac:gx.falseFn};t[36]={id:36,lvl:2,type:"decimal",len:17,dec:2,sign:!1,pic:"ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99",ro:1,isacc:0,grid:26,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"COMPRASDETALLEEXENTO",fmt:0,gxz:"Z81ComprasDetalleExento",gxold:"O81ComprasDetalleExento",gxvar:"A81ComprasDetalleExento",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.A81ComprasDetalleExento=gx.fn.toDecimalValue(n,",","."))},v2z:function(n){n!==undefined&&(gx.O.Z81ComprasDetalleExento=gx.fn.toDecimalValue(n,gx.thousandSeparator,gx.decimalPoint))},v2c:function(n){gx.fn.setGridDecimalValue("COMPRASDETALLEEXENTO",n||gx.fn.currentGridRowImpl(26),gx.O.A81ComprasDetalleExento,2,gx.decimalPoint);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A81ComprasDetalleExento=this.val(n))},val:function(n){return gx.fn.getGridDecimalValue("COMPRASDETALLEEXENTO",n||gx.fn.currentGridRowImpl(26),gx.thousandSeparator,gx.decimalPoint)},nac:gx.falseFn};t[37]={id:37,lvl:2,type:"decimal",len:17,dec:2,sign:!1,pic:"ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99",ro:1,isacc:0,grid:26,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"COMPRASDETALLEIVA5",fmt:0,gxz:"Z85ComprasDetalleIva5",gxold:"O85ComprasDetalleIva5",gxvar:"A85ComprasDetalleIva5",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.A85ComprasDetalleIva5=gx.fn.toDecimalValue(n,",","."))},v2z:function(n){n!==undefined&&(gx.O.Z85ComprasDetalleIva5=gx.fn.toDecimalValue(n,gx.thousandSeparator,gx.decimalPoint))},v2c:function(n){gx.fn.setGridDecimalValue("COMPRASDETALLEIVA5",n||gx.fn.currentGridRowImpl(26),gx.O.A85ComprasDetalleIva5,2,gx.decimalPoint);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A85ComprasDetalleIva5=this.val(n))},val:function(n){return gx.fn.getGridDecimalValue("COMPRASDETALLEIVA5",n||gx.fn.currentGridRowImpl(26),gx.thousandSeparator,gx.decimalPoint)},nac:gx.falseFn};t[38]={id:38,lvl:2,type:"decimal",len:17,dec:2,sign:!1,pic:"ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99",ro:1,isacc:0,grid:26,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"COMPRASDETALLEIVA10",fmt:0,gxz:"Z84ComprasDetalleIva10",gxold:"O84ComprasDetalleIva10",gxvar:"A84ComprasDetalleIva10",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.A84ComprasDetalleIva10=gx.fn.toDecimalValue(n,",","."))},v2z:function(n){n!==undefined&&(gx.O.Z84ComprasDetalleIva10=gx.fn.toDecimalValue(n,gx.thousandSeparator,gx.decimalPoint))},v2c:function(n){gx.fn.setGridDecimalValue("COMPRASDETALLEIVA10",n||gx.fn.currentGridRowImpl(26),gx.O.A84ComprasDetalleIva10,2,gx.decimalPoint);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A84ComprasDetalleIva10=this.val(n))},val:function(n){return gx.fn.getGridDecimalValue("COMPRASDETALLEIVA10",n||gx.fn.currentGridRowImpl(26),gx.thousandSeparator,gx.decimalPoint)},nac:gx.falseFn};t[39]={id:39,fld:"",grid:0};t[40]={id:40,fld:"",grid:0};t[42]={id:42,fld:"",grid:0};t[43]={id:43,fld:"",grid:0};t[44]={id:44,fld:"HTML_BOTTOMAUXILIARCONTROLS",grid:0};this.AV13FilterFullText="";this.ZV13FilterFullText="";this.OV13FilterFullText="";this.ZV19Select="";this.OV19Select="";this.Z12ComprasDetalleId=0;this.O12ComprasDetalleId=0;this.Z75ComprasDetalleCantidad=0;this.O75ComprasDetalleCantidad=0;this.Z13ArticuloId=0;this.O13ArticuloId=0;this.Z76ArticuloNombre="";this.O76ArticuloNombre="";this.Z83ImpuestoPorcentaje=0;this.O83ImpuestoPorcentaje=0;this.Z82ComprasCantidad=0;this.O82ComprasCantidad=0;this.Z80ComprasDetallePrecioCompra=0;this.O80ComprasDetallePrecioCompra=0;this.Z291ComprasDetalleTallaID=0;this.O291ComprasDetalleTallaID=0;this.Z81ComprasDetalleExento=0;this.O81ComprasDetalleExento=0;this.Z85ComprasDetalleIva5=0;this.O85ComprasDetalleIva5=0;this.Z84ComprasDetalleIva10=0;this.O84ComprasDetalleIva10=0;this.AV13FilterFullText="";this.AV16GridCurrentPage=0;this.AV14DDO_TitleSettingsIcons={Default_fi:"",Filtered_fi:"",SortedASC_fi:"",SortedDSC_fi:"",FilteredSortedASC_fi:"",FilteredSortedDSC_fi:"",OptionSortASC_fi:"",OptionSortDSC_fi:"",OptionApplyFilter_fi:"",OptionFilteringData_fi:"",OptionCleanFilters_fi:"",SelectedOption_fi:"",MultiselOption_fi:"",MultiselSelOption_fi:"",TreeviewCollapse_fi:"",TreeviewExpand_fi:"",FixLeft_fi:"",FixRight_fi:"",OptionGroup_fi:""};this.AV8InComprasId=0;this.AV9InOutComprasDetalleId=0;this.A11ComprasId=0;this.A18ImpuestoId=0;this.AV19Select="";this.A12ComprasDetalleId=0;this.A75ComprasDetalleCantidad=0;this.A13ArticuloId=0;this.A76ArticuloNombre="";this.A83ImpuestoPorcentaje=0;this.A82ComprasCantidad=0;this.A80ComprasDetallePrecioCompra=0;this.A291ComprasDetalleTallaID=0;this.A81ComprasDetalleExento=0;this.A85ComprasDetalleIva5=0;this.A84ComprasDetalleIva10=0;this.AV22Pgmname="";this.AV11OrderedBy=0;this.AV12OrderedDsc=!1;this.Events={e114x2_client:["GRIDPAGINATIONBAR.CHANGEPAGE",!0],e124x2_client:["GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",!0],e134x2_client:["DDO_GRID.ONOPTIONCLICKED",!0],e184x2_client:["ENTER",!0],e144x2_client:["'DOCLEANFILTERS'",!0],e194x2_client:["CANCEL",!0]};this.EvtParms.REFRESH=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{ctrl:"GRID",prop:"Rows"},{av:"AV13FilterFullText",fld:"vFILTERFULLTEXT",pic:""},{av:"AV8InComprasId",fld:"vINCOMPRASID",pic:"ZZZZZZZZZZ9"},{av:"AV22Pgmname",fld:"vPGMNAME",pic:"",hsh:!0}],[{av:"AV16GridCurrentPage",fld:"vGRIDCURRENTPAGE",pic:"ZZZZZZZZZ9"},{av:"AV17GridPageCount",fld:"vGRIDPAGECOUNT",pic:"ZZZZZZZZZ9"},{av:"AV18GridAppliedFilters",fld:"vGRIDAPPLIEDFILTERS",pic:""}]];this.EvtParms["GRIDPAGINATIONBAR.CHANGEPAGE"]=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{ctrl:"GRID",prop:"Rows"},{av:"AV13FilterFullText",fld:"vFILTERFULLTEXT",pic:""},{av:"AV8InComprasId",fld:"vINCOMPRASID",pic:"ZZZZZZZZZZ9"},{av:"AV22Pgmname",fld:"vPGMNAME",pic:"",hsh:!0},{av:"this.GRIDPAGINATIONBARContainer.SelectedPage",ctrl:"GRIDPAGINATIONBAR",prop:"SelectedPage"}],[]];this.EvtParms["GRIDPAGINATIONBAR.CHANGEROWSPERPAGE"]=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{ctrl:"GRID",prop:"Rows"},{av:"AV13FilterFullText",fld:"vFILTERFULLTEXT",pic:""},{av:"AV8InComprasId",fld:"vINCOMPRASID",pic:"ZZZZZZZZZZ9"},{av:"AV22Pgmname",fld:"vPGMNAME",pic:"",hsh:!0},{av:"this.GRIDPAGINATIONBARContainer.RowsPerPageSelectedValue",ctrl:"GRIDPAGINATIONBAR",prop:"RowsPerPageSelectedValue"}],[{ctrl:"GRID",prop:"Rows"}]];this.EvtParms["DDO_GRID.ONOPTIONCLICKED"]=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{ctrl:"GRID",prop:"Rows"},{av:"AV13FilterFullText",fld:"vFILTERFULLTEXT",pic:""},{av:"AV8InComprasId",fld:"vINCOMPRASID",pic:"ZZZZZZZZZZ9"},{av:"AV22Pgmname",fld:"vPGMNAME",pic:"",hsh:!0},{av:"this.DDO_GRIDContainer.ActiveEventKey",ctrl:"DDO_GRID",prop:"ActiveEventKey"},{av:"this.DDO_GRIDContainer.SelectedValue_get",ctrl:"DDO_GRID",prop:"SelectedValue_get"},{av:"AV11OrderedBy",fld:"vORDEREDBY",pic:"ZZZ9"},{av:"AV12OrderedDsc",fld:"vORDEREDDSC",pic:""}],[{av:"AV11OrderedBy",fld:"vORDEREDBY",pic:"ZZZ9"},{av:"AV12OrderedDsc",fld:"vORDEREDDSC",pic:""},{av:"this.DDO_GRIDContainer.SortedStatus",ctrl:"DDO_GRID",prop:"SortedStatus"}]];this.EvtParms["GRID.LOAD"]=[[],[{av:"AV19Select",fld:"vSELECT",pic:""}]];this.EvtParms.ENTER=[[{av:"A12ComprasDetalleId",fld:"COMPRASDETALLEID",pic:"ZZZZZZZZZZ9",hsh:!0}],[{av:"AV9InOutComprasDetalleId",fld:"vINOUTCOMPRASDETALLEID",pic:"ZZZZZZZZZZ9"}]];this.EvtParms["'DOCLEANFILTERS'"]=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{ctrl:"GRID",prop:"Rows"},{av:"AV13FilterFullText",fld:"vFILTERFULLTEXT",pic:""},{av:"AV8InComprasId",fld:"vINCOMPRASID",pic:"ZZZZZZZZZZ9"},{av:"AV22Pgmname",fld:"vPGMNAME",pic:"",hsh:!0}],[{av:"AV13FilterFullText",fld:"vFILTERFULLTEXT",pic:""}]];this.EvtParms.VALID_ARTICULOID=[[],[]];this.EvtParms.VALID_IMPUESTOPORCENTAJE=[[],[]];this.EvtParms.VALID_COMPRASCANTIDAD=[[],[]];this.EvtParms.VALID_COMPRASDETALLEPRECIOCOMPRA=[[],[]];this.EnterCtrl=["vSELECT"];this.setVCMap("AV22Pgmname","vPGMNAME",0,"char",129,0);this.setVCMap("AV11OrderedBy","vORDEREDBY",0,"int",4,0);this.setVCMap("AV12OrderedDsc","vORDEREDDSC",0,"boolean",4,0);this.setVCMap("AV8InComprasId","vINCOMPRASID",0,"int",11,0);this.setVCMap("AV9InOutComprasDetalleId","vINOUTCOMPRASDETALLEID",0,"int",11,0);this.setVCMap("AV8InComprasId","vINCOMPRASID",0,"int",11,0);this.setVCMap("AV22Pgmname","vPGMNAME",0,"char",129,0);this.setVCMap("AV8InComprasId","vINCOMPRASID",0,"int",11,0);this.setVCMap("AV22Pgmname","vPGMNAME",0,"char",129,0);r.addRefreshingParm({rfrProp:"Rows",gxGrid:"Grid"});r.addRefreshingVar(this.GXValidFnc[20]);r.addRefreshingVar({rfrVar:"AV8InComprasId"});r.addRefreshingVar({rfrVar:"AV22Pgmname"});r.addRefreshingParm(this.GXValidFnc[20]);r.addRefreshingParm({rfrVar:"AV8InComprasId"});r.addRefreshingParm({rfrVar:"AV22Pgmname"});this.Initialize();this.setSDTMapping("WWPBaseObjects\\DVB_SDTDropDownOptionsTitleSettingsIcons",{Default_fi:{extr:"def"},Filtered_fi:{extr:"fil"},SortedASC_fi:{extr:"asc"},SortedDSC_fi:{extr:"dsc"},FilteredSortedASC_fi:{extr:"fasc"},FilteredSortedDSC_fi:{extr:"fdsc"},OptionSortASC_fi:{extr:"osasc"},OptionSortDSC_fi:{extr:"osdsc"},OptionApplyFilter_fi:{extr:"app"},OptionFilteringData_fi:{extr:"fildata"},OptionCleanFilters_fi:{extr:"cle"},SelectedOption_fi:{extr:"selo"},MultiselOption_fi:{extr:"mul"},MultiselSelOption_fi:{extr:"muls"},TreeviewCollapse_fi:{extr:"tcol"},TreeviewExpand_fi:{extr:"texp"},FixLeft_fi:{extr:"fixl"},FixRight_fi:{extr:"fixr"},OptionGroup_fi:{extr:"og"}})});gx.wi(function(){gx.createParentObj(this.comprasdetalleprompt)})