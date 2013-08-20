package com.bluedigm.funnylab.oauth.provider.dao;

import com.bluedigm.funnylab.oauth.provider.model.ProviderList;

public interface ProviderDao {

	ProviderList selectProviderList(ProviderList providerList);
}
