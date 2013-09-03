package com.bluedigm.funnylab.oauth.common.util;

public interface ConstantResource {

	public final int PAGEINDEX = 1;
	public final int PAGESIZE = 10;
	public final int RECODEPERPAGE = 10;
	public final int FIRSTINDEX = 1;
	public final int LASTINDEX = 1;
	
	public final String USE_Y = "Y";
	public final String USE_N = "N";
	
	public final String SCOPE_WRITE = "write";
	public final String SCOPE_READ = "read";
	
	public final String GRANT_IM = "implicit";
	public final String GRANT_AU = "authorization_code";
	public final String GRANT_CC = "client_credentials ";
	
	public final String REFRESH_TOKEN = "refresh_token";
}
