package com.genexus.TiendaComercialSD;
import android.content.Context;
import androidx.multidex.MultiDex;

import com.artech.base.services.AndroidContext;
import com.artech.base.services.IGxProcedure;

import com.genexus.android.ContextImpl;
import com.genexus.android.core.application.MyApplication;
import com.genexus.android.core.base.metadata.GenexusApplication;
import com.genexus.android.core.base.services.Services;
import com.genexus.android.core.providers.EntityDataProvider;

import com.genexus.Application;
import com.genexus.ClientContext;

public class MainApplication extends MyApplication
{
	@Override
	public final void onCreate()
	{
		GenexusApplication application = new GenexusApplication();
		application.setName("mujer_morena");
		application.setAPIUri("http://192.168.100.123:8080/Mujer_MorenaJavaEnvironment/");
		application.setAppEntry("MujerMorenaSD");
		application.setMajorVersion(1);
		application.setMinorVersion(0);

		// Extensibility Point for Logging
 

		// Security
		application.setIsSecure(true);
		application.setEnableAnonymousUser(false);
		application.setClientId("1320a53bfd124d8c9da4a20d916087bb");
		application.setLoginObject("GAMSDLogin");
		application.setNotAuthorizedObject("GAMSDNotAuthorized");
		application.setChangePasswordObject("GAMSDChangePassword");
		//application.setCompleteUserDataObject("");

		application.setAllowWebViewExecuteJavascripts(true);
		application.setAllowWebViewExecuteLocalFiles(true);

		application.setShareSessionToWebView(false);

		// Dynamic Url		
		application.setUseDynamicUrl(false);
		application.setDynamicUrlAppId("Mujer_Morena");
		application.setDynamicUrlPanel("");

		// Notifications
		application.setUseNotification(true);
		application.setNotificationSenderId("767579121751");
		application.setNotificationRegistrationHandler("NotificationsRegistrationHandler");

		setApp(application);

		registerModule(new com.genexus.android.ui.animation.AnimationModule());

		registerModule(new com.genexus.android.core.externalobjects.CoreExternalObjectsModule());

		registerModule(new com.genexus.android.core.usercontrols.CoreUserControlsModule());

		registerModule(new com.genexus.android.controls.maps.google.GoogleMapsModule());

		registerModule(new com.genexus.android.location.LocationModule());

		registerModule(new com.genexus.android.notifications.onesignal.OneSignalModule());

		registerModule(new com.genexus.android.controls.grids.smart.SmartGridModule());

		registerModule(new com.genexus.android.controls.ViewPagersModule());

		registerModule(new com.workwithplus.WorkWithPlusModule());


	

		super.onCreate();

		

    }

	@Override
	public Class<? extends com.genexus.android.core.services.EntityService> getEntityServiceClass()
	{
		return AppEntityService.class;
	}

	@Override
	public EntityDataProvider getProvider()
	{
		return new AppEntityDataProvider();
	}

	@Override
	protected void attachBaseContext(Context base)
	{
		super.attachBaseContext(base);
		MultiDex.install(this);
	}

}
