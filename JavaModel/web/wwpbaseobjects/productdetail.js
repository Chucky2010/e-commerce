gx.evt.autoSkip=!1;gx.define("wwpbaseobjects.productdetail",!1,function(){var n,r,t,i,u;this.ServerClass="wwpbaseobjects.productdetail";this.PackageName="com.mujermorena";this.ServerFullClass="com.mujermorena.wwpbaseobjects.productdetail";this.setObjectType("web");this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.AV5DVelop_ECommerceCart=gx.fn.getControlValue("vDVELOP_ECOMMERCECART");this.AV9DVelop_ECommerceCartItem=gx.fn.getControlValue("vDVELOP_ECOMMERCECARTITEM");this.AV39Cartimage_GXI=gx.fn.getControlValue("vCARTIMAGE_GXI");this.A13ArticuloId=gx.fn.getIntegerValue("ARTICULOID",gx.thousandSeparator);this.AV14ProductId=gx.fn.getIntegerValue("vPRODUCTID",gx.thousandSeparator);this.A286TallaID=gx.fn.getIntegerValue("TALLAID",gx.thousandSeparator);this.A290ArticuloTallaStock=gx.fn.getIntegerValue("ARTICULOTALLASTOCK",gx.thousandSeparator);this.AV38Mainimage_GXI=gx.fn.getControlValue("vMAINIMAGE_GXI");this.AV9DVelop_ECommerceCartItem=gx.fn.getControlValue("vDVELOP_ECOMMERCECARTITEM");this.AV39Cartimage_GXI=gx.fn.getControlValue("vCARTIMAGE_GXI")};this.Validv_Producttalla=function(){return this.validCliEvt("Validv_Producttalla",0,function(){try{var n=gx.util.balloon.getNew("vPRODUCTTALLA");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.e19281_client=function(){return this.clearMessages(),this.AV16ProductQty=gx.num.trunc(this.AV16ProductQty+1,0),this.refreshOutputs([{av:"AV16ProductQty",fld:"vPRODUCTQTY",pic:"ZZZ9"}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e20281_client=function(){return this.clearMessages(),this.AV16ProductQty>1&&(this.AV16ProductQty=gx.num.trunc(this.AV16ProductQty-1,0)),this.refreshOutputs([{av:"AV16ProductQty",fld:"vPRODUCTQTY",pic:"ZZZ9"}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e12282_client=function(){return this.executeServerEvent("'DOADDTOCART'",!1,null,!1,!1)};this.e11282_client=function(){return this.executeServerEvent("COMBO_PRODUCTTALLA.ONOPTIONCLICKED",!1,null,!0,!0)};this.e14282_client=function(){return this.executeServerEvent("TABLECARD.CLICK",!0,arguments[0],!1,!0)};this.e17282_client=function(){return this.executeServerEvent("VIMAGE.CLICK",!0,arguments[0],!1,!1)};this.e13282_client=function(){return this.executeServerEvent("VPRODUCTTALLA.CONTROLVALUECHANGED",!0,null,!1,!0)};this.e21282_client=function(){return this.executeServerEvent("ENTER",!0,arguments[0],!1,!1)};this.e22282_client=function(){return this.executeServerEvent("CANCEL",!0,arguments[0],!1,!1)};this.GXValidFnc=[];n=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,10,11,12,13,14,15,16,17,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,48,49,51,52,53,54,55,56,57,58,59,60,61,62,63,64,66,67,68,69,70,71,72,73,74,75,76,77,78,80,81,82,83,84,85,86,89,90,92,93,94,95,96,97,98,99,100,101,102,103,106,107,109,110,111,112,114,115,116,117,118];this.GXLastCtrlId=118;this.ImagesContainer=new gx.grid.grid(this,2,"WbpLvl2",18,"Images","Images","ImagesContainer",this.CmpContext,this.IsMasterPage,"wwpbaseobjects.productdetail",[],!0,5,!1,!0,0,!1,!1,!1,"",0,"px",0,"px",gx.getMessage("GXM_newrow"),!1,!1,!1,null,null,!1,"",!0,[5,1,1,1],!1,0,!1,!1);r=this.ImagesContainer;r.startDiv(19,"Unnamedtablefsimages","0px","0px");r.startDiv(20,"","0px","0px");r.startDiv(21,"","0px","0px");r.startDiv(22,"","0px","0px");r.addLabel();r.addBitmap("&Image","vIMAGE",23,0,"",0,"","e17282_client","","","AttributeECommerceSmallImage","");r.endDiv();r.endDiv();r.endDiv();r.endDiv();this.ImagesContainer.emptyText=gx.getMessage("");this.setGrid(r);this.RelatedproductsContainer=new gx.grid.grid(this,3,"WbpLvl3",79,"Relatedproducts","Relatedproducts","RelatedproductsContainer",this.CmpContext,this.IsMasterPage,"wwpbaseobjects.productdetail",[],!0,6,!1,!0,0,!1,!1,!1,"CollWWPBaseObjectsDVelop_ECommerceCart.Item",0,"px",0,"px",gx.getMessage("GXM_newrow"),!1,!1,!1,gx.uc.HorizontalGrid,null,!1,"AV5DVelop_ECommerceCart",!0,[2,4,4,6],!1,0,!1,!1);t=this.RelatedproductsContainer;t.startDiv(80,"Unnamedtablefsrelatedproducts","0px","0px");t.startDiv(81,"","0px","0px");t.startDiv(82,"","0px","0px");t.startDiv(83,"Tablecard","0px","0px");t.startDiv(84,"","0px","0px");t.startDiv(85,"","0px","0px");t.startTable("Tablemergedrelatedproductsmainimage",86,"0px");t.startRow("","","","","","");t.startCell("","","","","","","","","","MergeDataCell");t.startDiv(89,"","0px","0px");t.addLabel();t.addBitmap("&Relatedproductsmainimage","vRELATEDPRODUCTSMAINIMAGE",90,0,"",0,"",null,"","","CardImageAttributePrimaryECommerce CardImageAttributeSmallECommerce ObjectFitCover","");t.endDiv();t.endCell();t.startCell("","","","","","","","","","");t.startDiv(92,"","0px","0px");t.addLabel();t.addBitmap("&Relatedproductssecondaryimage","vRELATEDPRODUCTSSECONDARYIMAGE",93,0,"",0,"",null,"","","CardImageAttributeSecondaryECommerce CardImageAttributeSmallECommerce ObjectFitCover","");t.endDiv();t.endCell();t.endRow();t.endTable();t.endDiv();t.endDiv();t.startDiv(94,"","0px","0px");t.startDiv(95,"","0px","0px");t.startDiv(96,"Tableimage","0px","0px");t.startDiv(97,"","0px","0px");t.startDiv(98,"","0px","0px");t.startDiv(99,"","0px","0px");t.addLabel();t.addMultipleLineEdit("GXV2",100,"DVELOP_ECOMMERCECART__PRODUCTNAME","","ProductName","svchar",80,"chr",3,"row","200",200,"left",null,!0,!1,0,"");t.endDiv();t.endDiv();t.endDiv();t.startDiv(101,"","0px","0px");t.startDiv(102,"","0px","0px");t.startTable("Tablesubtitleinfo",103,"0px");t.startRow("","","","","","");t.startCell("","","","","","","","","","CellAlignBottom");t.startDiv(106,"","0px","0px");t.addLabel();t.addSingleLineEdit("GXV3",107,"DVELOP_ECOMMERCECART__PRODUCTSIM","","","ProductSim","svchar",10,"chr",10,10,"left",null,[],"GXV3","GXV3",!0,0,!1,!1,"CardSubtitleECommercePrefix",0,"");t.endDiv();t.endCell();t.startCell("","","","","","","","","","");t.startDiv(109,"","0px","0px");t.addLabel();t.addSingleLineEdit("GXV4",110,"DVELOP_ECOMMERCECART__PRODUCTPRICE","","","ProductPrice","decimal",9,"chr",9,9,"right",null,[],"GXV4","GXV4",!0,2,!1,!1,"CardSubtitleECommerce",0,"");t.endDiv();t.endCell();t.endRow();t.endTable();t.endDiv();t.endDiv();t.endDiv();t.endDiv();t.endDiv();t.endDiv();t.endDiv();t.endDiv();t.endDiv();this.RelatedproductsContainer.emptyText=gx.getMessage("");t.setRenderProp("Class","Class","FreeStyleGrid","str");t.setRenderProp("Enabled","Enabled",!0,"boolean");t.setRenderProp("Paged","Paged",!0,"bool");t.setRenderDynProp("ShowPageController","Showpagecontroller",!0,"bool");t.setRenderProp("PageControllerClass","Pagecontrollerclass","GridPageController","str");t.setRenderProp("ShowArrows","Showarrows",!0,"bool");t.setRenderProp("Infinite","Infinite",!1,"bool");t.setRenderProp("AutoPlay","Autoplay",!1,"bool");t.setRenderProp("AutoPlaySpeed","Autoplayspeed",3e3,"num");t.setRenderProp("VariableWidth","Variablewidth",!1,"bool");t.setRenderProp("MultiRowsExtraSmall","Multi_rows_xs",1,"num");t.setRenderProp("MultiRowsSmall","Multi_rows_sm",1,"num");t.setRenderProp("MultiRowsMedium","Multi_rows_md",1,"num");t.setRenderProp("MultiRowsLarge","Multi_rows_lg",1,"num");t.setRenderProp("CurrentPage","Currentpage","","int");t.setRenderProp("Visible","Visible",!0,"boolean");this.setGrid(t);this.COMBO_PRODUCTTALLAContainer=gx.uc.getNew(this,65,16,"BootstrapDropDownOptions","COMBO_PRODUCTTALLAContainer","Combo_producttalla","COMBO_PRODUCTTALLA");i=this.COMBO_PRODUCTTALLAContainer;i.setProp("Class","Class","","char");i.setProp("IconType","Icontype","Image","str");i.setProp("Icon","Icon","","str");i.setProp("Caption","Caption","","str");i.setProp("Tooltip","Tooltip","","str");i.setProp("Cls","Cls","ExtendedCombo AttributeECommerceDetailDescription","str");i.setDynProp("SelectedValue_set","Selectedvalue_set","","char");i.setProp("SelectedValue_get","Selectedvalue_get","","char");i.setProp("SelectedText_set","Selectedtext_set","","char");i.setProp("SelectedText_get","Selectedtext_get","","char");i.setProp("GAMOAuthToken","Gamoauthtoken","","char");i.setProp("DDOInternalName","Ddointernalname","","char");i.setProp("TitleControlAlign","Titlecontrolalign","Automatic","str");i.setProp("DropDownOptionsType","Dropdownoptionstype","ExtendedComboBox","str");i.setProp("Enabled","Enabled",!0,"bool");i.setProp("Visible","Visible",!0,"bool");i.setProp("TitleControlIdToReplace","Titlecontrolidtoreplace","","str");i.setProp("DataListType","Datalisttype","Dynamic","str");i.setProp("AllowMultipleSelection","Allowmultipleselection",!1,"bool");i.setProp("DataListFixedValues","Datalistfixedvalues","","char");i.setProp("IsGridItem","Isgriditem",!1,"bool");i.setProp("HasDescription","Hasdescription",!1,"bool");i.setProp("DataListProc","Datalistproc","","str");i.setProp("DataListProcParametersPrefix","Datalistprocparametersprefix","","str");i.setProp("RemoteServicesParameters","Remoteservicesparameters","","str");i.setProp("DataListUpdateMinimumCharacters","Datalistupdateminimumcharacters",0,"num");i.setProp("IncludeOnlySelectedOption","Includeonlyselectedoption",!1,"boolean");i.setProp("IncludeSelectAllOption","Includeselectalloption",!1,"boolean");i.setProp("EmptyItem","Emptyitem",!0,"bool");i.setProp("IncludeAddNewOption","Includeaddnewoption",!1,"bool");i.setProp("HTMLTemplate","Htmltemplate","","str");i.setProp("MultipleValuesType","Multiplevaluestype","Text","str");i.setProp("LoadingData","Loadingdata","","char");i.setProp("NoResultsFound","Noresultsfound","","char");i.setProp("EmptyItemText","Emptyitemtext","Talla","str");i.setProp("OnlySelectedValues","Onlyselectedvalues","","char");i.setProp("SelectAllText","Selectalltext","","char");i.setProp("MultipleValuesSeparator","Multiplevaluesseparator","","char");i.setProp("AddNewOptionText","Addnewoptiontext","","str");i.setProp("DropDownOptionsTitleSettingsIcons","Dropdownoptionstitlesettingsicons","","str");i.addV2CFunction("AV22ProductTalla_Data","vPRODUCTTALLA_DATA","SetDropDownOptionsData");i.addC2VFunction(function(n){n.ParentObject.AV22ProductTalla_Data=n.GetDropDownOptionsData();gx.fn.setControlValue("vPRODUCTTALLA_DATA",n.ParentObject.AV22ProductTalla_Data)});i.setProp("Gx Control Type","Gxcontroltype","","int");i.setC2ShowFunction(function(n){n.show()});i.addEventHandler("OnOptionClicked",this.e11282_client);this.setUserControl(i);this.DVIMAGEZOOMContainer=gx.uc.getNew(this,113,16,"DVelop_DVImageZoom","DVIMAGEZOOMContainer","Dvimagezoom","DVIMAGEZOOM");u=this.DVIMAGEZOOMContainer;u.setProp("Class","Class","","char");u.setProp("Enabled","Enabled",!0,"boolean");u.setDynProp("ImageInternalName","Imageinternalname","","char");u.setDynProp("LargeImage","Largeimage","","str");u.setProp("Visible","Visible",!0,"bool");u.setProp("Gx Control Type","Gxcontroltype","","int");u.setC2ShowFunction(function(n){n.show()});this.setUserControl(u);n[2]={id:2,fld:"",grid:0};n[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};n[4]={id:4,fld:"",grid:0};n[5]={id:5,fld:"",grid:0};n[6]={id:6,fld:"TABLEMAIN",grid:0};n[7]={id:7,fld:"",grid:0};n[8]={id:8,fld:"",grid:0};n[10]={id:10,fld:"",grid:0};n[11]={id:11,fld:"",grid:0};n[12]={id:12,fld:"TABLECONTENT",grid:0};n[13]={id:13,fld:"",grid:0};n[14]={id:14,fld:"",grid:0};n[15]={id:15,fld:"",grid:0};n[16]={id:16,lvl:0,type:"bits",len:1024,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vMAINIMAGE",fmt:0,gxz:"ZV12MainImage",gxold:"OV12MainImage",gxvar:"AV12MainImage",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV12MainImage=n)},v2z:function(n){n!==undefined&&(gx.O.ZV12MainImage=n)},v2c:function(){gx.fn.setMultimediaValue("vMAINIMAGE",gx.O.AV12MainImage,gx.O.AV38Mainimage_GXI)},c2v:function(){gx.O.AV38Mainimage_GXI=this.val_GXI();this.val()!==undefined&&(gx.O.AV12MainImage=this.val())},val:function(){return gx.fn.getBlobValue("vMAINIMAGE")},val_GXI:function(){return gx.fn.getControlValue("vMAINIMAGE_GXI")},gxvar_GXI:"AV38Mainimage_GXI",nac:gx.falseFn};n[17]={id:17,fld:"",grid:0};n[19]={id:19,fld:"UNNAMEDTABLEFSIMAGES",grid:18};n[20]={id:20,fld:"",grid:18};n[21]={id:21,fld:"",grid:18};n[22]={id:22,fld:"",grid:18};n[23]={id:23,lvl:2,type:"bits",len:1024,dec:0,sign:!1,ro:1,isacc:0,grid:18,gxgrid:this.ImagesContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vIMAGE",fmt:0,gxz:"ZV10Image",gxold:"OV10Image",gxvar:"AV10Image",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.AV10Image=n)},v2z:function(n){n!==undefined&&(gx.O.ZV10Image=n)},v2c:function(n){gx.fn.setGridMultimediaValue("vIMAGE",n||gx.fn.currentGridRowImpl(18),gx.O.AV10Image,gx.O.AV41Image_GXI)},c2v:function(n){gx.O.AV41Image_GXI=this.val_GXI();this.val(n)!==undefined&&(gx.O.AV10Image=this.val(n))},val:function(n){return gx.fn.getGridControlValue("vIMAGE",n||gx.fn.currentGridRowImpl(18))},val_GXI:function(n){return gx.fn.getGridControlValue("vIMAGE_GXI",n||gx.fn.currentGridRowImpl(18))},gxvar_GXI:"AV41Image_GXI",nac:gx.falseFn,evt:"e17282_client"};n[24]={id:24,fld:"",grid:0};n[25]={id:25,fld:"TABLEINFO",grid:0};n[26]={id:26,fld:"",grid:0};n[27]={id:27,fld:"",grid:0};n[28]={id:28,fld:"",grid:0};n[29]={id:29,lvl:0,type:"svchar",len:100,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vPRODUCTTITLE",fmt:0,gxz:"ZV17ProductTitle",gxold:"OV17ProductTitle",gxvar:"AV17ProductTitle",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV17ProductTitle=n)},v2z:function(n){n!==undefined&&(gx.O.ZV17ProductTitle=n)},v2c:function(){gx.fn.setControlValue("vPRODUCTTITLE",gx.O.AV17ProductTitle,0)},c2v:function(){this.val()!==undefined&&(gx.O.AV17ProductTitle=this.val())},val:function(){return gx.fn.getControlValue("vPRODUCTTITLE")},nac:gx.falseFn};n[30]={id:30,fld:"",grid:0};n[31]={id:31,fld:"",grid:0};n[32]={id:32,fld:"",grid:0};n[33]={id:33,lvl:0,type:"decimal",len:15,dec:2,sign:!1,pic:"GS. ZZZ,ZZZ,ZZZ,ZZ9.99",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vPRODUCTPRICE",fmt:0,gxz:"ZV15ProductPrice",gxold:"OV15ProductPrice",gxvar:"AV15ProductPrice",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV15ProductPrice=gx.fn.toDecimalValue(n,",","."))},v2z:function(n){n!==undefined&&(gx.O.ZV15ProductPrice=gx.fn.toDecimalValue(n,gx.thousandSeparator,gx.decimalPoint))},v2c:function(){gx.fn.setDecimalValue("vPRODUCTPRICE",gx.O.AV15ProductPrice,2,gx.decimalPoint);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.AV15ProductPrice=this.val())},val:function(){return gx.fn.getDecimalValue("vPRODUCTPRICE",gx.thousandSeparator,gx.decimalPoint)},nac:gx.falseFn};this.declareDomainHdlr(33,function(){});n[34]={id:34,fld:"",grid:0};n[35]={id:35,fld:"",grid:0};n[36]={id:36,fld:"",grid:0};n[37]={id:37,lvl:0,type:"svchar",len:400,dec:0,sign:!1,ro:0,multiline:!0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vPRODUCTDESCRIPTION",fmt:0,gxz:"ZV13ProductDescription",gxold:"OV13ProductDescription",gxvar:"AV13ProductDescription",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV13ProductDescription=n)},v2z:function(n){n!==undefined&&(gx.O.ZV13ProductDescription=n)},v2c:function(){gx.fn.setControlValue("vPRODUCTDESCRIPTION",gx.O.AV13ProductDescription,0)},c2v:function(){this.val()!==undefined&&(gx.O.AV13ProductDescription=this.val())},val:function(){return gx.fn.getControlValue("vPRODUCTDESCRIPTION")},nac:gx.falseFn};n[38]={id:38,fld:"",grid:0};n[39]={id:39,fld:"",grid:0};n[40]={id:40,fld:"TABLESPLITTEDPRODUCTQTY",grid:0};n[41]={id:41,fld:"",grid:0};n[42]={id:42,fld:"",grid:0};n[43]={id:43,fld:"TEXTBLOCKPRODUCTQTY",format:0,grid:0,ctrltype:"textblock"};n[44]={id:44,fld:"",grid:0};n[45]={id:45,fld:"TABLEMERGEDPRODUCTQTY",grid:0};n[48]={id:48,fld:"",grid:0};n[49]={id:49,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vPRODUCTQTY",fmt:0,gxz:"ZV16ProductQty",gxold:"OV16ProductQty",gxvar:"AV16ProductQty",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV16ProductQty=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.ZV16ProductQty=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("vPRODUCTQTY",gx.O.AV16ProductQty,0)},c2v:function(){this.val()!==undefined&&(gx.O.AV16ProductQty=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("vPRODUCTQTY",gx.thousandSeparator)},nac:gx.falseFn};n[51]={id:51,fld:"UNNAMEDTABLE1",grid:0};n[52]={id:52,fld:"",grid:0};n[53]={id:53,fld:"",grid:0};n[54]={id:54,fld:"QTYUP",format:1,grid:0,evt:"e19281_client",ctrltype:"textblock"};n[55]={id:55,fld:"",grid:0};n[56]={id:56,fld:"",grid:0};n[57]={id:57,fld:"QTYDOWN",format:1,grid:0,evt:"e20281_client",ctrltype:"textblock"};n[58]={id:58,fld:"",grid:0};n[59]={id:59,fld:"",grid:0};n[60]={id:60,fld:"TABLESPLITTEDPRODUCTTALLA",grid:0};n[61]={id:61,fld:"",grid:0};n[62]={id:62,fld:"",grid:0};n[63]={id:63,fld:"TEXTBLOCKCOMBO_PRODUCTTALLA",format:0,grid:0,ctrltype:"textblock"};n[64]={id:64,fld:"",grid:0};n[66]={id:66,fld:"",grid:0};n[67]={id:67,fld:"",grid:0};n[68]={id:68,fld:"",grid:0};n[69]={id:69,fld:"",grid:0};n[70]={id:70,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vPRODUCTDISPON",fmt:0,gxz:"ZV26ProductDispon",gxold:"OV26ProductDispon",gxvar:"AV26ProductDispon",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV26ProductDispon=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.ZV26ProductDispon=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("vPRODUCTDISPON",gx.O.AV26ProductDispon,0)},c2v:function(){this.val()!==undefined&&(gx.O.AV26ProductDispon=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("vPRODUCTDISPON",gx.thousandSeparator)},nac:gx.falseFn};n[71]={id:71,fld:"",grid:0};n[72]={id:72,fld:"",grid:0};n[73]={id:73,fld:"BTNADDTOCART",grid:0,evt:"e12282_client"};n[74]={id:74,fld:"",grid:0};n[75]={id:75,fld:"",grid:0};n[76]={id:76,fld:"SUBTITLE",format:0,grid:0,ctrltype:"textblock"};n[77]={id:77,fld:"",grid:0};n[78]={id:78,fld:"",grid:0};n[80]={id:80,fld:"UNNAMEDTABLEFSRELATEDPRODUCTS",grid:79};n[81]={id:81,fld:"",grid:79};n[82]={id:82,fld:"",grid:79};n[83]={id:83,fld:"TABLECARD",grid:79,evt:"e14282_client"};n[84]={id:84,fld:"",grid:79};n[85]={id:85,fld:"",grid:79};n[86]={id:86,fld:"TABLEMERGEDRELATEDPRODUCTSMAINIMAGE",grid:79};n[89]={id:89,fld:"",grid:79};n[90]={id:90,lvl:3,type:"bits",len:1024,dec:0,sign:!1,ro:1,isacc:0,grid:79,gxgrid:this.RelatedproductsContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vRELATEDPRODUCTSMAINIMAGE",fmt:0,gxz:"ZV18RelatedProductsMainImage",gxold:"OV18RelatedProductsMainImage",gxvar:"AV18RelatedProductsMainImage",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.AV18RelatedProductsMainImage=n)},v2z:function(n){n!==undefined&&(gx.O.ZV18RelatedProductsMainImage=n)},v2c:function(n){gx.fn.setGridMultimediaValue("vRELATEDPRODUCTSMAINIMAGE",n||gx.fn.currentGridRowImpl(79),gx.O.AV18RelatedProductsMainImage,gx.O.AV47Relatedproductsmainimage_GXI)},c2v:function(n){gx.O.AV47Relatedproductsmainimage_GXI=this.val_GXI();this.val(n)!==undefined&&(gx.O.AV18RelatedProductsMainImage=this.val(n))},val:function(n){return gx.fn.getGridControlValue("vRELATEDPRODUCTSMAINIMAGE",n||gx.fn.currentGridRowImpl(79))},val_GXI:function(n){return gx.fn.getGridControlValue("vRELATEDPRODUCTSMAINIMAGE_GXI",n||gx.fn.currentGridRowImpl(79))},gxvar_GXI:"AV47Relatedproductsmainimage_GXI",nac:gx.falseFn};n[92]={id:92,fld:"",grid:79};n[93]={id:93,lvl:3,type:"bits",len:1024,dec:0,sign:!1,ro:1,isacc:0,grid:79,gxgrid:this.RelatedproductsContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vRELATEDPRODUCTSSECONDARYIMAGE",fmt:0,gxz:"ZV19RelatedProductsSecondaryImage",gxold:"OV19RelatedProductsSecondaryImage",gxvar:"AV19RelatedProductsSecondaryImage",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.AV19RelatedProductsSecondaryImage=n)},v2z:function(n){n!==undefined&&(gx.O.ZV19RelatedProductsSecondaryImage=n)},v2c:function(n){gx.fn.setGridMultimediaValue("vRELATEDPRODUCTSSECONDARYIMAGE",n||gx.fn.currentGridRowImpl(79),gx.O.AV19RelatedProductsSecondaryImage,gx.O.AV48Relatedproductssecondaryimage_GXI)},c2v:function(n){gx.O.AV48Relatedproductssecondaryimage_GXI=this.val_GXI();this.val(n)!==undefined&&(gx.O.AV19RelatedProductsSecondaryImage=this.val(n))},val:function(n){return gx.fn.getGridControlValue("vRELATEDPRODUCTSSECONDARYIMAGE",n||gx.fn.currentGridRowImpl(79))},val_GXI:function(n){return gx.fn.getGridControlValue("vRELATEDPRODUCTSSECONDARYIMAGE_GXI",n||gx.fn.currentGridRowImpl(79))},gxvar_GXI:"AV48Relatedproductssecondaryimage_GXI",nac:gx.falseFn};n[94]={id:94,fld:"",grid:79};n[95]={id:95,fld:"",grid:79};n[96]={id:96,fld:"TABLEIMAGE",grid:79};n[97]={id:97,fld:"",grid:79};n[98]={id:98,fld:"",grid:79};n[99]={id:99,fld:"",grid:79};n[100]={id:100,lvl:3,type:"svchar",len:200,dec:0,sign:!1,ro:1,isacc:0,multiline:!0,grid:79,gxgrid:this.RelatedproductsContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"DVELOP_ECOMMERCECART__PRODUCTNAME",fmt:0,gxz:"ZV33GXV2",gxold:"OV33GXV2",gxvar:"GXV2",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.GXV2=n)},v2z:function(n){n!==undefined&&(gx.O.ZV33GXV2=n)},v2c:function(n){gx.fn.setGridControlValue("DVELOP_ECOMMERCECART__PRODUCTNAME",n||gx.fn.currentGridRowImpl(79),gx.O.GXV2,0)},c2v:function(n){this.val(n)!==undefined&&(gx.O.GXV2=this.val(n))},val:function(n){return gx.fn.getGridControlValue("DVELOP_ECOMMERCECART__PRODUCTNAME",n||gx.fn.currentGridRowImpl(79))},nac:gx.falseFn};n[101]={id:101,fld:"",grid:79};n[102]={id:102,fld:"",grid:79};n[103]={id:103,fld:"TABLESUBTITLEINFO",grid:79};n[106]={id:106,fld:"",grid:79};n[107]={id:107,lvl:3,type:"svchar",len:10,dec:0,sign:!1,ro:1,isacc:0,grid:79,gxgrid:this.RelatedproductsContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"DVELOP_ECOMMERCECART__PRODUCTSIM",fmt:0,gxz:"ZV34GXV3",gxold:"OV34GXV3",gxvar:"GXV3",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.GXV3=n)},v2z:function(n){n!==undefined&&(gx.O.ZV34GXV3=n)},v2c:function(n){gx.fn.setGridControlValue("DVELOP_ECOMMERCECART__PRODUCTSIM",n||gx.fn.currentGridRowImpl(79),gx.O.GXV3,0)},c2v:function(n){this.val(n)!==undefined&&(gx.O.GXV3=this.val(n))},val:function(n){return gx.fn.getGridControlValue("DVELOP_ECOMMERCECART__PRODUCTSIM",n||gx.fn.currentGridRowImpl(79))},nac:gx.falseFn};n[109]={id:109,fld:"",grid:79};n[110]={id:110,lvl:3,type:"decimal",len:8,dec:2,sign:!1,pic:"ZZ,ZZ9.99",ro:1,isacc:0,grid:79,gxgrid:this.RelatedproductsContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"DVELOP_ECOMMERCECART__PRODUCTPRICE",fmt:0,gxz:"ZV35GXV4",gxold:"OV35GXV4",gxvar:"GXV4",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.GXV4=gx.fn.toDecimalValue(n,",","."))},v2z:function(n){n!==undefined&&(gx.O.ZV35GXV4=gx.fn.toDecimalValue(n,gx.thousandSeparator,gx.decimalPoint))},v2c:function(n){gx.fn.setGridDecimalValue("DVELOP_ECOMMERCECART__PRODUCTPRICE",n||gx.fn.currentGridRowImpl(79),gx.O.GXV4,2,gx.decimalPoint)},c2v:function(n){this.val(n)!==undefined&&(gx.O.GXV4=this.val(n))},val:function(n){return gx.fn.getGridDecimalValue("DVELOP_ECOMMERCECART__PRODUCTPRICE",n||gx.fn.currentGridRowImpl(79),gx.thousandSeparator,gx.decimalPoint)},nac:gx.falseFn};n[111]={id:111,fld:"",grid:0};n[112]={id:112,fld:"",grid:0};n[114]={id:114,fld:"",grid:0};n[115]={id:115,fld:"",grid:0};n[116]={id:116,fld:"HTML_BOTTOMAUXILIARCONTROLS",grid:0};n[117]={id:117,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:0,grid:0,gxgrid:null,fnc:this.Validv_Producttalla,isvalid:null,evt_cvc:"e13282_client",evt_cvcing:null,rgrid:[],fld:"vPRODUCTTALLA",fmt:0,gxz:"ZV21ProductTalla",gxold:"OV21ProductTalla",gxvar:"AV21ProductTalla",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV21ProductTalla=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.ZV21ProductTalla=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("vPRODUCTTALLA",gx.O.AV21ProductTalla,0)},c2v:function(){this.val()!==undefined&&(gx.O.AV21ProductTalla=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("vPRODUCTTALLA",gx.thousandSeparator)},nac:gx.falseFn};n[118]={id:118,lvl:0,type:"vchar",len:2097152,dec:0,sign:!1,ro:0,multiline:!0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vCARTITEMJSON",fmt:0,gxz:"ZV7CartItemJson",gxold:"OV7CartItemJson",gxvar:"AV7CartItemJson",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV7CartItemJson=n)},v2z:function(n){n!==undefined&&(gx.O.ZV7CartItemJson=n)},v2c:function(){gx.fn.setControlValue("vCARTITEMJSON",gx.O.AV7CartItemJson,0)},c2v:function(){this.val()!==undefined&&(gx.O.AV7CartItemJson=this.val())},val:function(){return gx.fn.getControlValue("vCARTITEMJSON")},nac:gx.falseFn};this.AV38Mainimage_GXI="";this.AV12MainImage="";this.ZV12MainImage="";this.OV12MainImage="";this.ZV10Image="";this.OV10Image="";this.AV17ProductTitle="";this.ZV17ProductTitle="";this.OV17ProductTitle="";this.AV15ProductPrice=0;this.ZV15ProductPrice=0;this.OV15ProductPrice=0;this.AV13ProductDescription="";this.ZV13ProductDescription="";this.OV13ProductDescription="";this.AV16ProductQty=0;this.ZV16ProductQty=0;this.OV16ProductQty=0;this.AV26ProductDispon=0;this.ZV26ProductDispon=0;this.OV26ProductDispon=0;this.ZV18RelatedProductsMainImage="";this.OV18RelatedProductsMainImage="";this.ZV19RelatedProductsSecondaryImage="";this.OV19RelatedProductsSecondaryImage="";this.ZV33GXV2="";this.OV33GXV2="";this.ZV34GXV3="";this.OV34GXV3="";this.ZV35GXV4=0;this.OV35GXV4=0;this.AV21ProductTalla=0;this.ZV21ProductTalla=0;this.OV21ProductTalla=0;this.AV7CartItemJson="";this.ZV7CartItemJson="";this.OV7CartItemJson="";this.AV12MainImage="";this.AV17ProductTitle="";this.AV15ProductPrice=0;this.AV13ProductDescription="";this.AV16ProductQty=0;this.AV22ProductTalla_Data=[];this.AV26ProductDispon=0;this.AV21ProductTalla=0;this.AV7CartItemJson="";this.AV14ProductId=0;this.AV10Image="";this.A13ArticuloId=0;this.AV18RelatedProductsMainImage="";this.AV19RelatedProductsSecondaryImage="";this.GXV2="";this.GXV3="";this.GXV4=0;this.A286TallaID=0;this.A290ArticuloTallaStock=0;this.A287TallaNombre="";this.AV5DVelop_ECommerceCart=[];this.AV9DVelop_ECommerceCartItem={ProductId:0,ProductName:"",ProductDescription:"",ProductSim:"",ProductPrice:0,ProductQty:0,ProductTalle:0,Images:[],Images_GXI:[]};this.AV39Cartimage_GXI="";this.AV38Mainimage_GXI="";this.Events={e12282_client:["'DOADDTOCART'",!0],e11282_client:["COMBO_PRODUCTTALLA.ONOPTIONCLICKED",!0],e14282_client:["TABLECARD.CLICK",!0],e17282_client:["VIMAGE.CLICK",!0],e13282_client:["VPRODUCTTALLA.CONTROLVALUECHANGED",!0],e21282_client:["ENTER",!0],e22282_client:["CANCEL",!0],e19281_client:["'DOQTYUP'",!1],e20281_client:["'DOQTYDOWN'",!1]};this.EvtParms.REFRESH=[[{av:"IMAGES_nFirstRecordOnPage"},{av:"IMAGES_nEOF"},{av:"AV9DVelop_ECommerceCartItem",fld:"vDVELOP_ECOMMERCECARTITEM",pic:""},{av:"AV39Cartimage_GXI",fld:"vCARTIMAGE_GXI",pic:""},{av:"RELATEDPRODUCTS_nFirstRecordOnPage"},{av:"RELATEDPRODUCTS_nEOF"},{av:"AV5DVelop_ECommerceCart",fld:"vDVELOP_ECOMMERCECART",grid:79,pic:"",hsh:!0},{av:"nGXsfl_79_idx",ctrl:"GRID",prop:"GridCurrRow",grid:79},{av:"nRC_GXsfl_79",ctrl:"RELATEDPRODUCTS",prop:"GridRC",grid:79},{av:"AV14ProductId",fld:"vPRODUCTID",pic:"ZZZZZ9",hsh:!0}],[]];this.EvtParms["RELATEDPRODUCTS.LOAD"]=[[{av:"AV5DVelop_ECommerceCart",fld:"vDVELOP_ECOMMERCECART",grid:79,pic:"",hsh:!0},{av:"nGXsfl_79_idx",ctrl:"GRID",prop:"GridCurrRow",grid:79},{av:"RELATEDPRODUCTS_nFirstRecordOnPage"},{av:"nRC_GXsfl_79",ctrl:"RELATEDPRODUCTS",prop:"GridRC",grid:79}],[{av:"AV18RelatedProductsMainImage",fld:"vRELATEDPRODUCTSMAINIMAGE",pic:""},{av:"AV19RelatedProductsSecondaryImage",fld:"vRELATEDPRODUCTSSECONDARYIMAGE",pic:""}]];this.EvtParms["IMAGES.LOAD"]=[[{av:"AV9DVelop_ECommerceCartItem",fld:"vDVELOP_ECOMMERCECARTITEM",pic:""},{av:"AV39Cartimage_GXI",fld:"vCARTIMAGE_GXI",pic:""}],[{av:"AV10Image",fld:"vIMAGE",pic:""}]];this.EvtParms["'DOADDTOCART'"]=[[{av:"AV16ProductQty",fld:"vPRODUCTQTY",pic:"ZZZ9"},{av:"AV26ProductDispon",fld:"vPRODUCTDISPON",pic:"ZZZ9"},{av:"AV7CartItemJson",fld:"vCARTITEMJSON",pic:""},{av:"AV21ProductTalla",fld:"vPRODUCTTALLA",pic:"ZZZ9"}],[{av:"AV9DVelop_ECommerceCartItem",fld:"vDVELOP_ECOMMERCECARTITEM",pic:""}]];this.EvtParms["'DOQTYUP'"]=[[{av:"AV16ProductQty",fld:"vPRODUCTQTY",pic:"ZZZ9"}],[{av:"AV16ProductQty",fld:"vPRODUCTQTY",pic:"ZZZ9"}]];this.EvtParms["'DOQTYDOWN'"]=[[{av:"AV16ProductQty",fld:"vPRODUCTQTY",pic:"ZZZ9"}],[{av:"AV16ProductQty",fld:"vPRODUCTQTY",pic:"ZZZ9"}]];this.EvtParms["COMBO_PRODUCTTALLA.ONOPTIONCLICKED"]=[[{av:"this.COMBO_PRODUCTTALLAContainer.SelectedValue_get",ctrl:"COMBO_PRODUCTTALLA",prop:"SelectedValue_get"},{av:"A13ArticuloId",fld:"ARTICULOID",pic:"ZZZZZZZZZZ9"},{av:"AV14ProductId",fld:"vPRODUCTID",pic:"ZZZZZ9",hsh:!0},{av:"A286TallaID",fld:"TALLAID",pic:"ZZZZZZZZZZ9"},{av:"A290ArticuloTallaStock",fld:"ARTICULOTALLASTOCK",pic:"ZZZZZZZZZ9"}],[{av:"AV21ProductTalla",fld:"vPRODUCTTALLA",pic:"ZZZ9"},{av:"AV26ProductDispon",fld:"vPRODUCTDISPON",pic:"ZZZ9"}]];this.EvtParms["TABLECARD.CLICK"]=[[{av:"AV5DVelop_ECommerceCart",fld:"vDVELOP_ECOMMERCECART",grid:79,pic:"",hsh:!0},{av:"nGXsfl_79_idx",ctrl:"GRID",prop:"GridCurrRow",grid:79},{av:"RELATEDPRODUCTS_nFirstRecordOnPage"},{av:"nRC_GXsfl_79",ctrl:"RELATEDPRODUCTS",prop:"GridRC",grid:79}],[]];this.EvtParms["VIMAGE.CLICK"]=[[{av:"AV10Image",fld:"vIMAGE",pic:""},{av:"AV38Mainimage_GXI",fld:"vMAINIMAGE_GXI",pic:""}],[{av:"AV12MainImage",fld:"vMAINIMAGE",pic:""},{av:"this.DVIMAGEZOOMContainer.ImageInternalName",ctrl:"DVIMAGEZOOM",prop:"ImageInternalName"},{av:"this.DVIMAGEZOOMContainer.LargeImage",ctrl:"DVIMAGEZOOM",prop:"LargeImage"}]];this.EvtParms["VPRODUCTTALLA.CONTROLVALUECHANGED"]=[[{av:"A13ArticuloId",fld:"ARTICULOID",pic:"ZZZZZZZZZZ9"},{av:"AV14ProductId",fld:"vPRODUCTID",pic:"ZZZZZ9",hsh:!0},{av:"A286TallaID",fld:"TALLAID",pic:"ZZZZZZZZZZ9"},{av:"AV21ProductTalla",fld:"vPRODUCTTALLA",pic:"ZZZ9"},{av:"A290ArticuloTallaStock",fld:"ARTICULOTALLASTOCK",pic:"ZZZZZZZZZ9"}],[{av:"AV26ProductDispon",fld:"vPRODUCTDISPON",pic:"ZZZ9"}]];this.EvtParms.ENTER=[[],[]];this.EvtParms.VALIDV_PRODUCTTALLA=[[],[]];this.setVCMap("AV5DVelop_ECommerceCart","vDVELOP_ECOMMERCECART",0,"CollWWPBaseObjectsDVelop_ECommerceCart.Item",0,0);this.setVCMap("AV9DVelop_ECommerceCartItem","vDVELOP_ECOMMERCECARTITEM",0,"WWPBaseObjectsDVelop_ECommerceCart.Item",0,0);this.setVCMap("AV39Cartimage_GXI","vCARTIMAGE_GXI",0,"svchar",2048,0);this.setVCMap("A13ArticuloId","ARTICULOID",0,"int",11,0);this.setVCMap("AV14ProductId","vPRODUCTID",0,"int",6,0);this.setVCMap("A286TallaID","TALLAID",0,"int",11,0);this.setVCMap("A290ArticuloTallaStock","ARTICULOTALLASTOCK",0,"int",10,0);this.setVCMap("AV38Mainimage_GXI","vMAINIMAGE_GXI",0,"svchar",2048,0);this.setVCMap("AV9DVelop_ECommerceCartItem","vDVELOP_ECOMMERCECARTITEM",0,"WWPBaseObjectsDVelop_ECommerceCart.Item",0,0);this.setVCMap("AV39Cartimage_GXI","vCARTIMAGE_GXI",0,"svchar",2048,0);this.setVCMap("AV9DVelop_ECommerceCartItem","vDVELOP_ECOMMERCECARTITEM",0,"WWPBaseObjectsDVelop_ECommerceCart.Item",0,0);this.setVCMap("AV39Cartimage_GXI","vCARTIMAGE_GXI",0,"svchar",2048,0);r.addRefreshingVar({rfrVar:"AV9DVelop_ECommerceCartItem"});r.addRefreshingVar({rfrVar:"AV39Cartimage_GXI"});r.addRefreshingVar({rfrVar:"AV5DVelop_ECommerceCart"});r.addRefreshingVar({rfrVar:"AV14ProductId"});r.addRefreshingParm({rfrVar:"AV9DVelop_ECommerceCartItem"});r.addRefreshingParm({rfrVar:"AV39Cartimage_GXI"});r.addRefreshingParm({rfrVar:"AV5DVelop_ECommerceCart"});r.addRefreshingParm({rfrVar:"AV14ProductId"});t.addRefreshingVar({rfrVar:"AV5DVelop_ECommerceCart"});t.addRefreshingVar({rfrVar:"AV14ProductId"});t.addRefreshingParm({rfrVar:"AV5DVelop_ECommerceCart"});t.addRefreshingParm({rfrVar:"AV14ProductId"});this.addGridBCProperty("Dvelop_ecommercecart",["ProductName"],this.GXValidFnc[100],"AV5DVelop_ECommerceCart");this.addGridBCProperty("Dvelop_ecommercecart",["ProductSim"],this.GXValidFnc[107],"AV5DVelop_ECommerceCart");this.addGridBCProperty("Dvelop_ecommercecart",["ProductPrice"],this.GXValidFnc[110],"AV5DVelop_ECommerceCart");this.Initialize();this.setSDTMapping("WWPBaseObjects\\DVB_SDTComboData.Item",{Title:{extr:"T"},Children:{extr:"C"}});this.setSDTMapping("WWPBaseObjects\\DVB_SDTDropDownOptionsTitleSettingsIcons",{Default_fi:{extr:"def"},Filtered_fi:{extr:"fil"},SortedASC_fi:{extr:"asc"},SortedDSC_fi:{extr:"dsc"},FilteredSortedASC_fi:{extr:"fasc"},FilteredSortedDSC_fi:{extr:"fdsc"},OptionSortASC_fi:{extr:"osasc"},OptionSortDSC_fi:{extr:"osdsc"},OptionApplyFilter_fi:{extr:"app"},OptionFilteringData_fi:{extr:"fildata"},OptionCleanFilters_fi:{extr:"cle"},SelectedOption_fi:{extr:"selo"},MultiselOption_fi:{extr:"mul"},MultiselSelOption_fi:{extr:"muls"},TreeviewCollapse_fi:{extr:"tcol"},TreeviewExpand_fi:{extr:"texp"},FixLeft_fi:{extr:"fixl"},FixRight_fi:{extr:"fixr"},OptionGroup_fi:{extr:"og"}})});gx.wi(function(){gx.createParentObj(this.wwpbaseobjects.productdetail)})