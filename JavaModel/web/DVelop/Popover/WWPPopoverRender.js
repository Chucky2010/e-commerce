﻿function DVelop_WWPPopover(){this.show=function(){var n,t,r,u,o,f,e;if(!this.updatingHTML){if(this.IsGridItem)WWP_NotifyEmpower(this,"WWP."+this.ControlName.toUpperCase());else if(this.ItemInternalName!="")if(n=$("#span_"+this.ItemInternalName),n.length==0&&(n=$("#"+this.ItemInternalName)),n.length==0&&(n=$("#span_"+this.ItemInternalName+"_0001"),n.length==0&&(n=$("#"+this.ItemInternalName+"_0001")),n.length==1&&(this.IsFSGridItem=!0)),this.IsFSGridItem)for(t=n.attr("id"),t=t.substring(0,t.length-4),r=1;;)if(u="000"+r,n=$("#"+t+u.substring(u.length-4)),n.length==1)this.InitPopovers(n),r++;else break;else n.is("input")?this.InitPopovers(n):(o=this,window.setTimeout(function(){n=$("#"+n.attr("id"));o.InitPopovers(n)},0));if(parseInt(this.PopoverWidth)>0){var f=(this.PopoverWidth+"").trim(),s=$(document.getElementsByTagName("head")[0]),i=document.createElement("style");i.type="text/css";f=(this.PopoverWidth+"").trim();i.innerHTML=".popoverW"+f+" { min-width: "+f+"px; }";e=!1;s.children().each(function(){if(this!=null&&this.type==i.type&&this.innerHTML==i.innerHTML)return e=!0,!1});e||s[0].appendChild(i)}}};this.InitGridPopovers=function(){var n,t,i;if(this.ItemInternalName!=""&&(n=WWP_GetGrid(this).find(">table"),n.length==1&&(n.data("PO_"+this.ControlName)==null||n.data("IS_ProcessedRecords")!=null))){WWP_Debug_Log(!1,"InitGridPopovers");n.data("PO_"+this.ControlName,"");var u=n.find(">tbody"),f=u.children().length,r=1;for(n.data("IS_ProcessedRecords")!=null&&(r=n.data("IS_ProcessedRecords")+1);r<=f;r+=1){if(t="000"+r,t=t.substring(t.length-4),i=u.find("#span_"+this.ItemInternalName+"_"+t),i.length==0)break;i.closest("tbody").parent().find("thead>tr>th:nth-child("+(i.closest("td").index()+2)+")").addClass("EditableGridAuxCol");this.InitPopovers(i)}}};this.InitPopovers=function(n){var u=n,i,t,r;if(n.css("display")!="none"&&(this.TriggerElement=="FontIcon"?n=this.IsGridItem?n.find(".WWPPopoverIcon"):n.closest("td").next().find(".WWPPopoverIcon"):n.addClass("PopoverValue"),this.Trigger=="Click"&&n.addClass("PopoverTriggerClick"),n.attr("data-placement")==null)){if(i=n.is("input"),t=this,n.popover("destroy").attr("data-placement",(WWP_endsWith(n.attr("id"),"_MPAGE")&&n.closest("#TABLEHEADER_MPAGE").length==1?"":"auto ")+this.Position.toLowerCase()).attr("data-html","true").attr("data-trigger",this.Trigger.toLowerCase()).attr("data-content",'<div class="popoverMainDiv'+(parseInt(this.PopoverWidth)>0?" popoverW"+(this.PopoverWidth+"").trim():"")+'">'+this.HTML+"<\/div>").on("show.bs.popover",function(){if(WWP_Debug_Log(!1,"show "+$(this).data("poStatus")),t.Trigger=="Hover"&&(parseInt($(this).data("poStatus"))||0)!=0||!t.OpenIfEmpty&&(i?n.val():n.text())=="")return WWP_Debug_Log(!1,"show return"),!1;if(t.IsGridItem&&$(this).closest("td").css("position")=="absolute"){var r=$(this).closest("td");r.attr("orig-zIndex")==null&&(r.attr("orig-zIndex",r.css("z-index")),r.css("z-index",parseInt(r.css("z-index"))+1))}WWP_Debug_Log(!1,"show end")}).on("shown.bs.popover",function(){if(WWP_Debug_Log(!1,"showw init"),t.Trigger=="Hover"&&(parseInt($(this).data("poStatus"))||0)!=0)return WWP_Debug_Log(!1,"shown end return "+$(this).data("poStatus")),!1;t.Trigger!="Click"||t.KeepOpened||(t.bodyMouseDownHandler=function(t){t.target!=null&&t.target.parentElement!=null&&$(t.target).closest(n.parent()).length==0&&(n.data("forceHide",""),n.popover("hide"))},gx.evt.attach($("body")[0],"mousedown",t.bodyMouseDownHandler));t.PopoverShown(this,!1,u);WWP_Debug_Log(!1,"shown end "+$(this).data("poStatus"))}).on("hide.bs.popover",function(){if(WWP_Debug_Log(!1,"hide init"),t.updatingHTML||i&&t.Trigger=="Click"&&(t.OpenIfEmpty||n.val()!="")&&n.data("forceHide")==null)return!1;n.data("forceHide",null);$(this).data("poStatus",(parseInt($(this).data("poStatus"))||0)+1);t.PopoverHide(this);t.OnClose!=null&&(t.realHide=n.next().is(":visible"));WWP_Debug_Log(!1,"hide end "+$(this).data("poStatus")+" "+t.ControlName)}).on("hidden.bs.popover",function(){if($(this).data("poStatus",(parseInt($(this).data("poStatus"))||0)-1),WWP_Debug_Log(!1,"hidden start "+$(this).data("poStatus")),t.IsGridItem&&$(this).closest("td").attr("orig-zIndex")!=null){var i=$(this).closest("td");i.css("z-index",parseInt(i.attr("orig-zIndex")));i.removeAttr("orig-zIndex")}t.setSectionGridMinHeight(this,!1);t.bodyMouseDownHandler!=null&&(gx.evt.detach($("body")[0],"mousedown",t.bodyMouseDownHandler),t.bodyMouseDownHandler=null);t.OnClose!=null&&t.realHide&&t.OnClose();n.hasClass("AttributeSearch")&&window.setTimeout(function(){$(window).resize()},100);WWP_Debug_Log(!1,"hidden end")}).popover().data("poStatus",null),i&&this.ReloadOnKeyChange)n.on("input",function(t){return function(){t.myT!=null&&clearInterval(t.myT);t.myT=setInterval(function(){if(clearInterval(t.myT),t.OnLoadComponent!=null){n.change();var i=n.val().length>=t.MinimumCharacters;n.next().is(":visible")&&(i||t.OpenIfEmpty)?(t.lastWCLoadedEmpty==null||i||t.lastWCLoadedEmpty!=i+"")&&t.PopoverShown(n[0],!0,u):(i||!t.OpenIfEmpty)&&n.popover(i?"show":"hide")}},300)}}(this));this.Trigger=="Click"&&(r=!0,n.click(function(){return function(){n.next().is(":visible")?r=!0:r&&(r=!1,n.click())}}(this)))}};this.PopoverHide=function(n){this.HTML==""&&WWP_revertWCMoved(this.getWCParentDivName(),this,n,this.Load=="OnEveryTrigger");var t=$(n).next();this.resetBottom&&(t.css("top",t.css("top")),t.css("bottom",""));this.resetRight&&(t.css("left",t.css("left")),t.css("right",""))};this.getWCParentDivName=function(){return"DIV_"+(this.Load=="OnEveryTrigger"?"WWPAUXWC":this.ControlName)};this.forceOpenDirectionLeft=function(n,t){var i=t[0].getBoundingClientRect();return i.left+Math.max(i.width,200)>window.innerWidth};this.PopoverShown=function(n,t,i){var r=$(n).next(),f=r.find(">.arrow"),y,l,e,u,p,o,c,s,a,k;if(f.length==1&&(r.is(".bottom,.top")?f.css("left",f.css("left")):f.css("top",f.css("top"))),r.is(".top")?(this.resetBottom=!0,r.css("bottom",r.css("bottom")),r.css("top","auto")):r.css("bottom",""),r.is(".left")||r.is(".top, .bottom")&&this.forceOpenDirectionLeft(n,r)?(this.resetRight=!0,r.css("right",r.css("right")),r.css("left","auto"),r.is(".top, .bottom")&&f.css({left:"auto",right:f.css("right")})):(r.css("right",""),r.prev().hasClass("AttributeSearch")&&(y=$("body").css("direction")=="rtl",l=WWP_OffsetLeft(y,r.prev())-WWP_OffsetLeft(y,r),(l<-2||l>2)&&r.css("left",parseInt(r.css("left"))+l))),e=r.find(".popover-content"),u=e.find(">div"),u.length==0&&(p=document.createElement("div"),e.append(p),u=$(p)),this.HTML!="")this.OnLoadComponent!=null&&(this.updatingHTML=!0,this.OnLoadComponent(),delete this.updatingHTML),u.html(this.HTML);else{var d=WWP_getWCId(this.getWCParentDivName(),this),s=$("#"+d),w=this.IsGridItem||this.IsFSGridItem||this.Load=="OnEveryTrigger"||this.Load=="OnFirstTrigger"&&s.children().length==0,h=this.ShowLoading&&w;if((w||u.children().length==0)&&(t&&e.css("min-height",e.height()),u.html(""),o=document.createElement("div"),h?($(o).css("display","none"),c=document.createElement("div"),c.innerHTML='<div class="WCD_Loading"><i class="fas fa-spinner fa-spin"><\/i><\/div>',u.append(c),c.appendChild(o),$(c).css("min-height",$(c).height())):u.append(o),s=WWP_moveWCToDiv(d,this,h,o),a=this,h&&window.setTimeout(function(){a.wcLoaded(e,o,s,h)},3e3),w))if(s.html(""),h&&(this.wcRenderHandler=function(n){n.containerControl==s[0]&&a.wcLoaded(e,o,s,h)},gx.fx.obs.addObserver("webcom.render",window,this.wcRenderHandler)),this.IsGridItem)$(n).closest("td").next().find("a,img").click();else if(this.IsFSGridItem){var v=i.attr("id"),g=v.substring(0,v.length-5)+"_POPOVER"+v.substring(v.length-5),b=$("#"+g);b.length==0&&(k="span_"+WWP_getCurrentWCId(a),b=$("#"+k+"v"+g.substring(k.length)));b.click()}else this.OnLoadComponent!=null&&(this.ReloadOnKeyChange&&this.MinimumCharacters>1&&(this.lastWCLoadedEmpty=($(n).val().length>=this.MinimumCharacters)+""),this.OnLoadComponent())}this.setSectionGridMinHeight(n,!0)};this.wcLoaded=function(n,t,i,r){var f,u;$(t).css("display")=="none"&&(WWP_Debug_Log(!1,"wcLoaded"),r&&($(t).parent().find(".WCD_Loading").remove(),i.find(".gxwebcomponent-body").removeClass("Invisible"),f=this,$(t).slideDown(function(){$(this.parentElement).css("min-height","");n.css("min-height","")})),this.wcRenderHandler!=null&&(u=this.wcRenderHandler,delete this.wcRenderHandler,window.setTimeout(function(){gx.fx.obs.deleteObserver("webcom.render",window,u)},1)),WWP_IsIE()&&n.find(".FSResultCategoriesCell")&&window.setTimeout(function(){n.find(".FSResultCategoriesCell").scrollTop(1)},500))};this.setSectionGridMinHeight=function(n,t){var i,r;this.IsGridItem&&(i=$(n).closest("td"),t?i.data("origZIndex")==null&&parseInt(i.css("z-index"))>0&&(r=i.css("z-index"),i.css("z-index",parseInt(r)+10),i.data("origZIndex",r)):(r=i.data("origZIndex"),r!=null&&(i.css("z-index",r),i.data("origZIndex",null))))}};$(window).one('load',function(){WWP_VV([['WWPPopover','15.1.9']]);});