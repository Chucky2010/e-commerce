gx.evt.autoSkip=!1;gx.define("wwpbaseobjects.wizardstepsprogresswc",!0,function(n){var i,t;this.ServerClass="wwpbaseobjects.wizardstepsprogresswc";this.PackageName="com.mujermorena";this.ServerFullClass="com.mujermorena.wwpbaseobjects.wizardstepsprogresswc";this.setObjectType("web");this.setCmpContext(n);this.ReadonlyForm=!0;this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.AV8StepNumber=gx.fn.getIntegerValue("vSTEPNUMBER",gx.thousandSeparator);this.AV7SelectedStepNumber=gx.fn.getIntegerValue("vSELECTEDSTEPNUMBER",gx.thousandSeparator);this.AV9WizardSteps=gx.fn.getControlValue("vWIZARDSTEPS");this.AV6CurrentStep=gx.fn.getControlValue("vCURRENTSTEP");this.AV8StepNumber=gx.fn.getIntegerValue("vSTEPNUMBER",gx.thousandSeparator);this.AV7SelectedStepNumber=gx.fn.getIntegerValue("vSELECTEDSTEPNUMBER",gx.thousandSeparator)};this.e132m2_client=function(){return this.executeServerEvent("ENTER",!0,arguments[0],!1,!1)};this.e142m2_client=function(){return this.executeServerEvent("CANCEL",!0,arguments[0],!1,!1)};this.GXValidFnc=[];i=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,12,13,14,16];this.GXLastCtrlId=16;this.GridwizardstepsContainer=new gx.grid.grid(this,2,"WbpLvl2",15,"Gridwizardsteps","Gridwizardsteps","GridwizardstepsContainer",this.CmpContext,this.IsMasterPage,"wwpbaseobjects.wizardstepsprogresswc",[],!0,1,!1,!0,0,!1,!1,!1,"",0,"px",0,"px",gx.getMessage("GXM_newrow"),!1,!1,!1,gx.grid.flexGrid,null,!1,"",!0,[0,0,0,0],!1,0,!1,!1);t=this.GridwizardstepsContainer;t.startDiv(16,"Unnamedtablefsgridwizardsteps","0px","0px");t.endDiv();this.GridwizardstepsContainer.emptyText=gx.getMessage("");t.setRenderProp("Class","Class","FreeStyleStepsProgress","str");t.setRenderProp("Enabled","Enabled",!0,"boolean");t.setRenderProp("FlexDirection","Flexdirection","row","str");t.setRenderProp("FlexWrap","Flexwrap","nowrap","str");t.setRenderProp("JustifyContent","Justifycontent","flex-start","str");t.setRenderProp("AlignItems","Alignitems","stretch","str");t.setRenderProp("AlignContent","Aligncontent","stretch","str");t.setRenderProp("Visible","Visible",!0,"boolean");this.setGrid(t);i[2]={id:2,fld:"",grid:0};i[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};i[4]={id:4,fld:"",grid:0};i[5]={id:5,fld:"",grid:0};i[6]={id:6,fld:"TABLEMAIN",grid:0};i[7]={id:7,fld:"",grid:0};i[8]={id:8,fld:"",grid:0};i[9]={id:9,fld:"WIZARDSTEPTITLE",format:0,grid:0,ctrltype:"textblock"};i[10]={id:10,fld:"",grid:0};i[11]={id:11,fld:"WIZARDSTEPDESCRIPTIONCELL",grid:0};i[12]={id:12,fld:"WIZARDSTEPDESCRIPTION",format:0,grid:0,ctrltype:"textblock"};i[13]={id:13,fld:"",grid:0};i[14]={id:14,fld:"",grid:0};i[16]={id:16,fld:"UNNAMEDTABLEFSGRIDWIZARDSTEPS",grid:15};this.AV9WizardSteps=[];this.AV6CurrentStep="";this.AV8StepNumber=0;this.AV7SelectedStepNumber=0;this.Events={e132m2_client:["ENTER",!0],e142m2_client:["CANCEL",!0]};this.EvtParms.REFRESH=[[{av:"GRIDWIZARDSTEPS_nFirstRecordOnPage"},{av:"GRIDWIZARDSTEPS_nEOF"},{av:"sPrefix"},{av:"AV8StepNumber",fld:"vSTEPNUMBER",pic:"ZZZ9",hsh:!0},{av:"AV7SelectedStepNumber",fld:"vSELECTEDSTEPNUMBER",pic:"ZZZ9",hsh:!0}],[]];this.EvtParms["GRIDWIZARDSTEPS.LOAD"]=[[{av:"AV8StepNumber",fld:"vSTEPNUMBER",pic:"ZZZ9",hsh:!0},{av:"AV7SelectedStepNumber",fld:"vSELECTEDSTEPNUMBER",pic:"ZZZ9",hsh:!0}],[{av:'gx.fn.getCtrlProperty("UNNAMEDTABLEFSGRIDWIZARDSTEPS","Class")',ctrl:"UNNAMEDTABLEFSGRIDWIZARDSTEPS",prop:"Class"},{av:"AV8StepNumber",fld:"vSTEPNUMBER",pic:"ZZZ9",hsh:!0}]];this.EvtParms.ENTER=[[],[]];this.setVCMap("AV8StepNumber","vSTEPNUMBER",0,"int",4,0);this.setVCMap("AV7SelectedStepNumber","vSELECTEDSTEPNUMBER",0,"int",4,0);this.setVCMap("AV9WizardSteps","vWIZARDSTEPS",0,"CollWWPBaseObjectsWizardSteps.WizardStepsItem",0,0);this.setVCMap("AV6CurrentStep","vCURRENTSTEP",0,"svchar",40,0);this.setVCMap("AV8StepNumber","vSTEPNUMBER",0,"int",4,0);this.setVCMap("AV7SelectedStepNumber","vSELECTEDSTEPNUMBER",0,"int",4,0);this.setVCMap("AV8StepNumber","vSTEPNUMBER",0,"int",4,0);this.setVCMap("AV7SelectedStepNumber","vSELECTEDSTEPNUMBER",0,"int",4,0);t.addRefreshingVar({rfrVar:"AV8StepNumber"});t.addRefreshingVar({rfrVar:"AV7SelectedStepNumber"});t.addRefreshingParm({rfrVar:"AV8StepNumber"});t.addRefreshingParm({rfrVar:"AV7SelectedStepNumber"});this.Initialize()})