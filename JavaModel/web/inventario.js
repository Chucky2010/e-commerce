gx.evt.autoSkip=!1;gx.define("inventario",!1,function(){var n,i,t;this.ServerClass="inventario";this.PackageName="com.mujermorena";this.ServerFullClass="com.mujermorena.inventario";this.setObjectType("trn");this.anyGridBaseTable=!0;this.hasEnterEvent=!0;this.skipOnEnter=!1;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.AV7InventarioID=gx.fn.getIntegerValue("vINVENTARIOID",gx.thousandSeparator);this.Gx_mode=gx.fn.getControlValue("vMODE");this.AV11TrnContext=gx.fn.getControlValue("vTRNCONTEXT")};this.Valid_Inventarioid=function(){return this.validCliEvt("Valid_Inventarioid",0,function(){try{var n=gx.util.balloon.getNew("INVENTARIOID");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Inventariofecha=function(){return this.validCliEvt("Valid_Inventariofecha",0,function(){try{var n=gx.util.balloon.getNew("INVENTARIOFECHA");if(this.AnyError=0,!(new gx.date.gxdate("").compare(this.A257InventarioFecha)==0||new gx.date.gxdate(this.A257InventarioFecha).compare(gx.date.ymdtod(1753,1,1))>=0))try{n.setError(gx.text.format(gx.getMessage("GXSPC_OutOfRange"),gx.getMessage("Inventario Fecha"),"","","","","","","",""));this.AnyError=gx.num.trunc(1,0)}catch(t){}}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Inventariodetalleid=function(){var n=gx.fn.currentGridRowImpl(44);return this.validCliEvt("Valid_Inventariodetalleid",44,function(){try{if(gx.fn.currentGridRowImpl(44)===0)return!0;var n=gx.util.balloon.getNew("INVENTARIODETALLEID",gx.fn.currentGridRowImpl(44));this.AnyError=0;this.sMode50=this.Gx_mode;this.Gx_mode=gx.fn.getGridRowMode(50,44);this.standaloneModal1750();this.standaloneNotModal1750();gx.fn.gridDuplicateKey(45)&&(n.setError(gx.text.format(gx.getMessage("GXM_1004"),gx.getMessage("Detalle"),"","","","","","","","")),this.AnyError=gx.num.trunc(1,0))}catch(t){}try{return(this.Gx_mode=this.sMode50,n==null)?!0:n.show()}catch(t){}return!0})};this.Valid_Articuloid=function(){var n=gx.fn.currentGridRowImpl(44);return this.validSrvEvt("valid_Articuloid",44).then(function(n){try{this.sMode50=this.Gx_mode;this.Gx_mode=gx.fn.getGridRowMode(50,44)}finally{this.Gx_mode=this.sMode50}return n}.closure(this))};this.Valid_Articulostock=function(){var n=gx.fn.currentGridRowImpl(44);return this.validCliEvt("Valid_Articulostock",44,function(){try{if(gx.fn.currentGridRowImpl(44)===0)return!0;var n=gx.util.balloon.getNew("ARTICULOSTOCK",gx.fn.currentGridRowImpl(44));this.AnyError=0;this.sMode50=this.Gx_mode;this.Gx_mode=gx.fn.getGridRowMode(50,44)}catch(t){}try{return(this.Gx_mode=this.sMode50,n==null)?!0:n.show()}catch(t){}return!0})};this.Valid_Inventariodetallestockok=function(){var n=gx.fn.currentGridRowImpl(44);return this.validCliEvt("Valid_Inventariodetallestockok",44,function(){try{if(gx.fn.currentGridRowImpl(44)===0)return!0;var n=gx.util.balloon.getNew("INVENTARIODETALLESTOCKOK",gx.fn.currentGridRowImpl(44));this.AnyError=0;this.sMode50=this.Gx_mode;this.Gx_mode=gx.fn.getGridRowMode(50,44);try{this.A260InventarioDetalleDiferencia=gx.num.trunc(this.A79ArticuloStock-this.A261InventarioDetalleStockOk,0)}catch(t){}}catch(t){}try{return(this.Gx_mode=this.sMode50,n==null)?!0:n.show()}catch(t){}return!0})};this.standaloneModal1750=function(){try{gx.text.compare(this.Gx_mode,"INS")!=0?gx.fn.setCtrlProperty("INVENTARIODETALLEID","Enabled",0):gx.fn.setCtrlProperty("INVENTARIODETALLEID","Enabled",1)}catch(n){}};this.standaloneNotModal1750=function(){};this.e12172_client=function(){return this.executeServerEvent("AFTER TRN",!0,null,!1,!1)};this.e131749_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e141749_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];n=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,13,14,15,16,17,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64];this.GXLastCtrlId=64;this.Gridlevel_detalleContainer=new gx.grid.grid(this,50,"Detalle",44,"Gridlevel_detalle","Gridlevel_detalle","Gridlevel_detalleContainer",this.CmpContext,this.IsMasterPage,"inventario",[54],!1,1,!1,!0,5,!1,!1,!1,"",0,"px",0,"px",gx.getMessage("GXM_newrow"),!0,!1,!1,null,null,!1,"",!1,[1,1,1,1],!1,0,!0,!1);i=this.Gridlevel_detalleContainer;i.addSingleLineEdit(54,45,"INVENTARIODETALLEID",gx.getMessage("Inventario Detalle ID"),"","InventarioDetalleID","int",0,"px",11,11,"right",null,[],54,"InventarioDetalleID",!0,0,!1,!1,"AttributeRealWidth",0,"TrnColumn");i.addSingleLineEdit(13,46,"ARTICULOID",gx.getMessage("Articulo Id"),"","ArticuloId","int",0,"px",11,11,"right",null,[],13,"ArticuloId",!0,0,!1,!1,"AttributeRealWidth",0,"TrnColumn");i.addBitmap("prompt_13","PROMPT_13",64,0,"",0,"",null,"","","gx-prompt Image","");i.addSingleLineEdit(76,47,"ARTICULONOMBRE",gx.getMessage("Articulo Nombre"),"","ArticuloNombre","char",0,"px",80,80,"left",null,[],76,"ArticuloNombre",!0,0,!1,!1,"AttributeRealWidth",0,"TrnColumn");i.addSingleLineEdit(79,48,"ARTICULOSTOCK",gx.getMessage("Articulo Stock"),"","ArticuloStock","int",0,"px",10,10,"right",null,[],79,"ArticuloStock",!0,0,!1,!1,"AttributeRealWidth",0,"TrnColumn");i.addSingleLineEdit(259,49,"INVENTARIODETALLESTOCK",gx.getMessage("Detalle Stock"),"","InventarioDetalleStock","int",0,"px",10,10,"right",null,[],259,"InventarioDetalleStock",!0,0,!1,!1,"AttributeRealWidth",0,"TrnColumn");i.addSingleLineEdit(260,50,"INVENTARIODETALLEDIFERENCIA",gx.getMessage("Detalle Diferencia"),"","InventarioDetalleDiferencia","int",0,"px",10,10,"right",null,[],260,"InventarioDetalleDiferencia",!0,0,!1,!1,"AttributeRealWidth",0,"TrnColumn");i.addSingleLineEdit(262,51,"INVENTARIODETALLESTOCK2",gx.getMessage("Detalle Stock2"),"","InventarioDetalleStock2","int",0,"px",10,10,"right",null,[],262,"InventarioDetalleStock2",!0,0,!1,!1,"AttributeRealWidth",0,"TrnColumn");i.addSingleLineEdit(263,52,"INVENTARIODETALLESTOCK3",gx.getMessage("Detalle Stock3"),"","InventarioDetalleStock3","int",0,"px",10,10,"right",null,[],263,"InventarioDetalleStock3",!0,0,!1,!1,"AttributeRealWidth",0,"TrnColumn");i.addSingleLineEdit(264,53,"INVENTARIODETALLESTOCK4",gx.getMessage("Detalle Stock4"),"","InventarioDetalleStock4","int",0,"px",10,10,"right",null,[],264,"InventarioDetalleStock4",!0,0,!1,!1,"AttributeRealWidth",0,"TrnColumn");i.addSingleLineEdit(261,54,"INVENTARIODETALLESTOCKOK",gx.getMessage("Stock Ok"),"","InventarioDetalleStockOk","int",0,"px",10,10,"right",null,[],261,"InventarioDetalleStockOk",!0,0,!1,!1,"AttributeRealWidth",0,"TrnColumn");this.Gridlevel_detalleContainer.emptyText=gx.getMessage("");this.setGrid(i);this.DVPANEL_TABLEATTRIBUTESContainer=gx.uc.getNew(this,18,0,"BootstrapPanel","DVPANEL_TABLEATTRIBUTESContainer","Dvpanel_tableattributes","DVPANEL_TABLEATTRIBUTES");t=this.DVPANEL_TABLEATTRIBUTESContainer;t.setProp("Class","Class","","char");t.setProp("Enabled","Enabled",!0,"boolean");t.setProp("Width","Width","100%","str");t.setProp("Height","Height","100","str");t.setProp("AutoWidth","Autowidth",!1,"bool");t.setProp("AutoHeight","Autoheight",!0,"bool");t.setProp("Cls","Cls","PanelFilled Panel_BaseColor","str");t.setProp("ShowHeader","Showheader",!0,"bool");t.setProp("Title","Title",gx.getMessage("WWP_TemplateDataPanelTitle"),"str");t.setProp("Collapsible","Collapsible",!1,"bool");t.setProp("Collapsed","Collapsed",!1,"bool");t.setProp("ShowCollapseIcon","Showcollapseicon",!1,"bool");t.setProp("IconPosition","Iconposition","Right","str");t.setProp("AutoScroll","Autoscroll",!1,"bool");t.setProp("Visible","Visible",!0,"bool");t.setProp("Gx Control Type","Gxcontroltype","","int");t.setC2ShowFunction(function(n){n.show()});this.setUserControl(t);n[2]={id:2,fld:"",grid:0};n[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};n[4]={id:4,fld:"",grid:0};n[5]={id:5,fld:"",grid:0};n[6]={id:6,fld:"TABLEMAIN",grid:0};n[7]={id:7,fld:"",grid:0};n[8]={id:8,fld:"",grid:0};n[9]={id:9,fld:"TEXTBLOCKTITLE",format:0,grid:0,ctrltype:"textblock"};n[10]={id:10,fld:"",grid:0};n[11]={id:11,fld:"",grid:0};n[13]={id:13,fld:"",grid:0};n[14]={id:14,fld:"",grid:0};n[15]={id:15,fld:"TABLECONTENT",grid:0};n[16]={id:16,fld:"",grid:0};n[17]={id:17,fld:"",grid:0};n[20]={id:20,fld:"TABLEATTRIBUTES",grid:0};n[21]={id:21,fld:"",grid:0};n[22]={id:22,fld:"",grid:0};n[23]={id:23,fld:"",grid:0};n[24]={id:24,fld:"",grid:0};n[25]={id:25,lvl:0,type:"int",len:11,dec:0,sign:!1,pic:"ZZZZZZZZZZ9",ro:0,grid:0,gxgrid:null,fnc:this.Valid_Inventarioid,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[this.Gridlevel_detalleContainer],fld:"INVENTARIOID",fmt:0,gxz:"Z53InventarioID",gxold:"O53InventarioID",gxvar:"A53InventarioID",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A53InventarioID=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z53InventarioID=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("INVENTARIOID",gx.O.A53InventarioID,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A53InventarioID=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("INVENTARIOID",gx.thousandSeparator)},nac:function(){return!(0==this.AV7InventarioID)}};this.declareDomainHdlr(25,function(){});n[26]={id:26,fld:"",grid:0};n[27]={id:27,fld:"",grid:0};n[28]={id:28,fld:"",grid:0};n[29]={id:29,lvl:0,type:"date",len:8,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:this.Valid_Inventariofecha,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"INVENTARIOFECHA",fmt:0,gxz:"Z257InventarioFecha",gxold:"O257InventarioFecha",gxvar:"A257InventarioFecha",dp:{f:0,st:!1,wn:!1,mf:!1,pic:"99/99/99",dec:0},ucs:[],op:[29],ip:[29],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A257InventarioFecha=gx.fn.toDatetimeValue(n))},v2z:function(n){n!==undefined&&(gx.O.Z257InventarioFecha=gx.fn.toDatetimeValue(n))},v2c:function(){gx.fn.setControlValue("INVENTARIOFECHA",gx.O.A257InventarioFecha,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A257InventarioFecha=gx.fn.toDatetimeValue(this.val()))},val:function(){return gx.fn.getControlValue("INVENTARIOFECHA")},nac:gx.falseFn};this.declareDomainHdlr(29,function(){});n[30]={id:30,fld:"",grid:0};n[31]={id:31,fld:"",grid:0};n[32]={id:32,fld:"",grid:0};n[33]={id:33,fld:"",grid:0};n[34]={id:34,lvl:0,type:"svchar",len:80,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"INVENTARIODETALLE",fmt:0,gxz:"Z258InventarioDetalle",gxold:"O258InventarioDetalle",gxvar:"A258InventarioDetalle",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A258InventarioDetalle=n)},v2z:function(n){n!==undefined&&(gx.O.Z258InventarioDetalle=n)},v2c:function(){gx.fn.setControlValue("INVENTARIODETALLE",gx.O.A258InventarioDetalle,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A258InventarioDetalle=this.val())},val:function(){return gx.fn.getControlValue("INVENTARIODETALLE")},nac:gx.falseFn};this.declareDomainHdlr(34,function(){});n[35]={id:35,fld:"",grid:0};n[36]={id:36,fld:"",grid:0};n[37]={id:37,fld:"",grid:0};n[38]={id:38,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"INVENTARIONUMEROPROCESO",fmt:0,gxz:"Z265InventarioNumeroProceso",gxold:"O265InventarioNumeroProceso",gxvar:"A265InventarioNumeroProceso",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A265InventarioNumeroProceso=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z265InventarioNumeroProceso=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("INVENTARIONUMEROPROCESO",gx.O.A265InventarioNumeroProceso,0)},c2v:function(){this.val()!==undefined&&(gx.O.A265InventarioNumeroProceso=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("INVENTARIONUMEROPROCESO",gx.thousandSeparator)},nac:gx.falseFn};n[39]={id:39,fld:"",grid:0};n[40]={id:40,fld:"",grid:0};n[41]={id:41,fld:"TABLELEAFLEVEL_DETALLE",grid:0};n[42]={id:42,fld:"",grid:0};n[43]={id:43,fld:"",grid:0};n[45]={id:45,lvl:50,type:"int",len:11,dec:0,sign:!1,pic:"ZZZZZZZZZZ9",ro:0,isacc:1,grid:44,gxgrid:this.Gridlevel_detalleContainer,fnc:this.Valid_Inventariodetalleid,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"INVENTARIODETALLEID",fmt:0,gxz:"Z54InventarioDetalleID",gxold:"O54InventarioDetalleID",gxvar:"A54InventarioDetalleID",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.A54InventarioDetalleID=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z54InventarioDetalleID=gx.num.intval(n))},v2c:function(n){gx.fn.setGridControlValue("INVENTARIODETALLEID",n||gx.fn.currentGridRowImpl(44),gx.O.A54InventarioDetalleID,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A54InventarioDetalleID=gx.num.intval(this.val(n)))},val:function(n){return gx.fn.getGridIntegerValue("INVENTARIODETALLEID",n||gx.fn.currentGridRowImpl(44),gx.thousandSeparator)},nac:gx.falseFn};n[46]={id:46,lvl:50,type:"int",len:11,dec:0,sign:!1,pic:"ZZZZZZZZZZ9",ro:0,isacc:1,grid:44,gxgrid:this.Gridlevel_detalleContainer,fnc:this.Valid_Articuloid,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"ARTICULOID",fmt:0,gxz:"Z13ArticuloId",gxold:"O13ArticuloId",gxvar:"A13ArticuloId",ucs:[],op:[48,47],ip:[48,47,46],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.A13ArticuloId=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z13ArticuloId=gx.num.intval(n))},v2c:function(n){gx.fn.setGridControlValue("ARTICULOID",n||gx.fn.currentGridRowImpl(44),gx.O.A13ArticuloId,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A13ArticuloId=gx.num.intval(this.val(n)))},val:function(n){return gx.fn.getGridIntegerValue("ARTICULOID",n||gx.fn.currentGridRowImpl(44),gx.thousandSeparator)},nac:gx.falseFn};n[47]={id:47,lvl:50,type:"char",len:80,dec:0,sign:!1,ro:1,isacc:1,grid:44,gxgrid:this.Gridlevel_detalleContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"ARTICULONOMBRE",fmt:0,gxz:"Z76ArticuloNombre",gxold:"O76ArticuloNombre",gxvar:"A76ArticuloNombre",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.A76ArticuloNombre=n)},v2z:function(n){n!==undefined&&(gx.O.Z76ArticuloNombre=n)},v2c:function(n){gx.fn.setGridControlValue("ARTICULONOMBRE",n||gx.fn.currentGridRowImpl(44),gx.O.A76ArticuloNombre,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A76ArticuloNombre=this.val(n))},val:function(n){return gx.fn.getGridControlValue("ARTICULONOMBRE",n||gx.fn.currentGridRowImpl(44))},nac:gx.falseFn};n[48]={id:48,lvl:50,type:"int",len:10,dec:0,sign:!1,pic:"ZZZZZZZZZ9",ro:1,isacc:1,grid:44,gxgrid:this.Gridlevel_detalleContainer,fnc:this.Valid_Articulostock,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"ARTICULOSTOCK",fmt:0,gxz:"Z79ArticuloStock",gxold:"O79ArticuloStock",gxvar:"A79ArticuloStock",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.A79ArticuloStock=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z79ArticuloStock=gx.num.intval(n))},v2c:function(n){gx.fn.setGridControlValue("ARTICULOSTOCK",n||gx.fn.currentGridRowImpl(44),gx.O.A79ArticuloStock,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A79ArticuloStock=gx.num.intval(this.val(n)))},val:function(n){return gx.fn.getGridIntegerValue("ARTICULOSTOCK",n||gx.fn.currentGridRowImpl(44),gx.thousandSeparator)},nac:gx.falseFn};n[49]={id:49,lvl:50,type:"int",len:10,dec:0,sign:!1,pic:"ZZZZZZZZZ9",ro:0,isacc:1,grid:44,gxgrid:this.Gridlevel_detalleContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"INVENTARIODETALLESTOCK",fmt:0,gxz:"Z259InventarioDetalleStock",gxold:"O259InventarioDetalleStock",gxvar:"A259InventarioDetalleStock",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.A259InventarioDetalleStock=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z259InventarioDetalleStock=gx.num.intval(n))},v2c:function(n){gx.fn.setGridControlValue("INVENTARIODETALLESTOCK",n||gx.fn.currentGridRowImpl(44),gx.O.A259InventarioDetalleStock,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A259InventarioDetalleStock=gx.num.intval(this.val(n)))},val:function(n){return gx.fn.getGridIntegerValue("INVENTARIODETALLESTOCK",n||gx.fn.currentGridRowImpl(44),gx.thousandSeparator)},nac:gx.falseFn};n[50]={id:50,lvl:50,type:"int",len:10,dec:0,sign:!1,pic:"ZZZZZZZZZ9",ro:1,isacc:1,grid:44,gxgrid:this.Gridlevel_detalleContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"INVENTARIODETALLEDIFERENCIA",fmt:0,gxz:"Z260InventarioDetalleDiferencia",gxold:"O260InventarioDetalleDiferencia",gxvar:"A260InventarioDetalleDiferencia",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.A260InventarioDetalleDiferencia=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z260InventarioDetalleDiferencia=gx.num.intval(n))},v2c:function(n){gx.fn.setGridControlValue("INVENTARIODETALLEDIFERENCIA",n||gx.fn.currentGridRowImpl(44),gx.O.A260InventarioDetalleDiferencia,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A260InventarioDetalleDiferencia=gx.num.intval(this.val(n)))},val:function(n){return gx.fn.getGridIntegerValue("INVENTARIODETALLEDIFERENCIA",n||gx.fn.currentGridRowImpl(44),gx.thousandSeparator)},nac:gx.falseFn};n[51]={id:51,lvl:50,type:"int",len:10,dec:0,sign:!1,pic:"ZZZZZZZZZ9",ro:0,isacc:1,grid:44,gxgrid:this.Gridlevel_detalleContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"INVENTARIODETALLESTOCK2",fmt:0,gxz:"Z262InventarioDetalleStock2",gxold:"O262InventarioDetalleStock2",gxvar:"A262InventarioDetalleStock2",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.A262InventarioDetalleStock2=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z262InventarioDetalleStock2=gx.num.intval(n))},v2c:function(n){gx.fn.setGridControlValue("INVENTARIODETALLESTOCK2",n||gx.fn.currentGridRowImpl(44),gx.O.A262InventarioDetalleStock2,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A262InventarioDetalleStock2=gx.num.intval(this.val(n)))},val:function(n){return gx.fn.getGridIntegerValue("INVENTARIODETALLESTOCK2",n||gx.fn.currentGridRowImpl(44),gx.thousandSeparator)},nac:gx.falseFn};n[52]={id:52,lvl:50,type:"int",len:10,dec:0,sign:!1,pic:"ZZZZZZZZZ9",ro:0,isacc:1,grid:44,gxgrid:this.Gridlevel_detalleContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"INVENTARIODETALLESTOCK3",fmt:0,gxz:"Z263InventarioDetalleStock3",gxold:"O263InventarioDetalleStock3",gxvar:"A263InventarioDetalleStock3",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.A263InventarioDetalleStock3=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z263InventarioDetalleStock3=gx.num.intval(n))},v2c:function(n){gx.fn.setGridControlValue("INVENTARIODETALLESTOCK3",n||gx.fn.currentGridRowImpl(44),gx.O.A263InventarioDetalleStock3,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A263InventarioDetalleStock3=gx.num.intval(this.val(n)))},val:function(n){return gx.fn.getGridIntegerValue("INVENTARIODETALLESTOCK3",n||gx.fn.currentGridRowImpl(44),gx.thousandSeparator)},nac:gx.falseFn};n[53]={id:53,lvl:50,type:"int",len:10,dec:0,sign:!1,pic:"ZZZZZZZZZ9",ro:0,isacc:1,grid:44,gxgrid:this.Gridlevel_detalleContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"INVENTARIODETALLESTOCK4",fmt:0,gxz:"Z264InventarioDetalleStock4",gxold:"O264InventarioDetalleStock4",gxvar:"A264InventarioDetalleStock4",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.A264InventarioDetalleStock4=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z264InventarioDetalleStock4=gx.num.intval(n))},v2c:function(n){gx.fn.setGridControlValue("INVENTARIODETALLESTOCK4",n||gx.fn.currentGridRowImpl(44),gx.O.A264InventarioDetalleStock4,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A264InventarioDetalleStock4=gx.num.intval(this.val(n)))},val:function(n){return gx.fn.getGridIntegerValue("INVENTARIODETALLESTOCK4",n||gx.fn.currentGridRowImpl(44),gx.thousandSeparator)},nac:gx.falseFn};n[54]={id:54,lvl:50,type:"int",len:10,dec:0,sign:!1,pic:"ZZZZZZZZZ9",ro:0,isacc:1,grid:44,gxgrid:this.Gridlevel_detalleContainer,fnc:this.Valid_Inventariodetallestockok,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"INVENTARIODETALLESTOCKOK",fmt:0,gxz:"Z261InventarioDetalleStockOk",gxold:"O261InventarioDetalleStockOk",gxvar:"A261InventarioDetalleStockOk",ucs:[],op:[50],ip:[50,54,48],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.A261InventarioDetalleStockOk=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z261InventarioDetalleStockOk=gx.num.intval(n))},v2c:function(n){gx.fn.setGridControlValue("INVENTARIODETALLESTOCKOK",n||gx.fn.currentGridRowImpl(44),gx.O.A261InventarioDetalleStockOk,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A261InventarioDetalleStockOk=gx.num.intval(this.val(n)))},val:function(n){return gx.fn.getGridIntegerValue("INVENTARIODETALLESTOCKOK",n||gx.fn.currentGridRowImpl(44),gx.thousandSeparator)},nac:gx.falseFn};n[55]={id:55,fld:"",grid:0};n[56]={id:56,fld:"",grid:0};n[57]={id:57,fld:"",grid:0};n[58]={id:58,fld:"",grid:0};n[59]={id:59,fld:"BTNTRN_ENTER",grid:0,evt:"e131749_client",std:"ENTER"};n[60]={id:60,fld:"",grid:0};n[61]={id:61,fld:"BTNTRN_CANCEL",grid:0,evt:"e141749_client"};n[62]={id:62,fld:"",grid:0};n[63]={id:63,fld:"BTNTRN_DELETE",grid:0,evt:"e151749_client",std:"DELETE"};n[64]={id:64,fld:"PROMPT_13",grid:50};this.A53InventarioID=0;this.Z53InventarioID=0;this.O53InventarioID=0;this.A257InventarioFecha=gx.date.nullDate();this.Z257InventarioFecha=gx.date.nullDate();this.O257InventarioFecha=gx.date.nullDate();this.A258InventarioDetalle="";this.Z258InventarioDetalle="";this.O258InventarioDetalle="";this.A265InventarioNumeroProceso=0;this.Z265InventarioNumeroProceso=0;this.O265InventarioNumeroProceso=0;this.Z54InventarioDetalleID=0;this.O54InventarioDetalleID=0;this.Z13ArticuloId=0;this.O13ArticuloId=0;this.Z76ArticuloNombre="";this.O76ArticuloNombre="";this.Z79ArticuloStock=0;this.O79ArticuloStock=0;this.Z259InventarioDetalleStock=0;this.O259InventarioDetalleStock=0;this.Z260InventarioDetalleDiferencia=0;this.O260InventarioDetalleDiferencia=0;this.Z262InventarioDetalleStock2=0;this.O262InventarioDetalleStock2=0;this.Z263InventarioDetalleStock3=0;this.O263InventarioDetalleStock3=0;this.Z264InventarioDetalleStock4=0;this.O264InventarioDetalleStock4=0;this.Z261InventarioDetalleStockOk=0;this.O261InventarioDetalleStockOk=0;this.A54InventarioDetalleID=0;this.A260InventarioDetalleDiferencia=0;this.A13ArticuloId=0;this.A76ArticuloNombre="";this.A79ArticuloStock=0;this.A259InventarioDetalleStock=0;this.A262InventarioDetalleStock2=0;this.A263InventarioDetalleStock3=0;this.A264InventarioDetalleStock4=0;this.A261InventarioDetalleStockOk=0;this.AV8WWPContext={UserId:0,UserName:""};this.AV11TrnContext={CallerObject:"",CallerOnDelete:!1,CallerURL:"",TransactionName:"",Attributes:[]};this.AV7InventarioID=0;this.AV12WebSession={};this.A53InventarioID=0;this.A257InventarioFecha=gx.date.nullDate();this.A258InventarioDetalle="";this.A265InventarioNumeroProceso=0;this.Gx_mode="";this.Events={e12172_client:["AFTER TRN",!0],e131749_client:["ENTER",!0],e141749_client:["CANCEL",!0]};this.EvtParms.ENTER=[[{postForm:!0},{av:"Gx_mode",fld:"vMODE",pic:"@!",hsh:!0},{av:"AV7InventarioID",fld:"vINVENTARIOID",pic:"ZZZZZZZZZZ9",hsh:!0}],[]];this.EvtParms.REFRESH=[[{av:"Gx_mode",fld:"vMODE",pic:"@!",hsh:!0},{av:"AV11TrnContext",fld:"vTRNCONTEXT",pic:"",hsh:!0},{av:"AV7InventarioID",fld:"vINVENTARIOID",pic:"ZZZZZZZZZZ9",hsh:!0}],[]];this.EvtParms["AFTER TRN"]=[[{av:"Gx_mode",fld:"vMODE",pic:"@!",hsh:!0},{av:"A53InventarioID",fld:"INVENTARIOID",pic:"ZZZZZZZZZZ9"},{av:"AV11TrnContext",fld:"vTRNCONTEXT",pic:"",hsh:!0}],[{av:"A53InventarioID",fld:"INVENTARIOID",pic:"ZZZZZZZZZZ9"}]];this.EvtParms.VALID_INVENTARIOID=[[],[]];this.EvtParms.VALID_INVENTARIOFECHA=[[{av:"A257InventarioFecha",fld:"INVENTARIOFECHA",pic:""}],[{av:"A257InventarioFecha",fld:"INVENTARIOFECHA",pic:""}]];this.EvtParms.VALID_INVENTARIODETALLEID=[[],[]];this.EvtParms.VALID_ARTICULOID=[[{av:"A13ArticuloId",fld:"ARTICULOID",pic:"ZZZZZZZZZZ9"},{av:"A76ArticuloNombre",fld:"ARTICULONOMBRE",pic:""},{av:"A79ArticuloStock",fld:"ARTICULOSTOCK",pic:"ZZZZZZZZZ9"}],[{av:"A76ArticuloNombre",fld:"ARTICULONOMBRE",pic:""},{av:"A79ArticuloStock",fld:"ARTICULOSTOCK",pic:"ZZZZZZZZZ9"}]];this.EvtParms.VALID_ARTICULOSTOCK=[[],[]];this.EvtParms.VALID_INVENTARIODETALLESTOCKOK=[[{av:"A260InventarioDetalleDiferencia",fld:"INVENTARIODETALLEDIFERENCIA",pic:"ZZZZZZZZZ9"},{av:"A261InventarioDetalleStockOk",fld:"INVENTARIODETALLESTOCKOK",pic:"ZZZZZZZZZ9"},{av:"A79ArticuloStock",fld:"ARTICULOSTOCK",pic:"ZZZZZZZZZ9"}],[{av:"A260InventarioDetalleDiferencia",fld:"INVENTARIODETALLEDIFERENCIA",pic:"ZZZZZZZZZ9"}]];this.setPrompt("PROMPT_13",[46]);this.EnterCtrl=["BTNTRN_ENTER"];this.setVCMap("AV7InventarioID","vINVENTARIOID",0,"int",11,0);this.setVCMap("Gx_mode","vMODE",0,"char",3,0);this.setVCMap("AV11TrnContext","vTRNCONTEXT",0,"WWPBaseObjectsWWPTransactionContext",0,0);i.addPostingVar({rfrVar:"Gx_mode"});this.Initialize()});gx.wi(function(){gx.createParentObj(this.inventario)})