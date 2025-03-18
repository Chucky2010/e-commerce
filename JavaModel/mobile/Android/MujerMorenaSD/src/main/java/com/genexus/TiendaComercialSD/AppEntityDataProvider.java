package com.genexus.TiendaComercialSD;

import com.genexus.android.core.providers.EntityDataProvider;

public class AppEntityDataProvider extends EntityDataProvider
{
	public AppEntityDataProvider()
	{
		EntityDataProvider.AUTHORITY = "com.genexus.TiendaComercialSD.appentityprovider";
		EntityDataProvider.URI_MATCHER = buildUriMatcher();
	}
}
