/**   
 * 文件名：HttpUtil.java 
 * 类名称：HttpUtil   
 * 类描述：      
 * 创建人：诸葛飞扬。JJ   
 * 创建时间：2014-1-24 下午1:14:18  
 * Copyright 诸葛飞扬。JJ Corporation 2014 版权所有     
 * 版本信息：    
 * 修改人：jj   
 * 修改时间：2014-1-24 下午1:14:18   
 * 修改备注：   
 */
package com.wanqin.ktv.utils;

import org.apache.http.client.params.ClientPNames;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.BinaryHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.MySSLSocketFactory;
import com.loopj.android.http.RequestParams;

/**
 * @ClassName: HttpUtil
 * @Description: TODO(封装AsyncHttpClient的方法)
 * @author 诸葛飞扬。JJ
 * @date 2014-1-24 下午1:14:18
 * 
 */
public class HttpUtil {
	private static String BASE_URL = "";
	

	private static AsyncHttpClient httpclient;
	static
	{
		getSameHttpClient().setTimeout(10000); // 设置链接超时，如果不设置，默认为10s

	}
	public static void setBASE_URL(String bASE_URL) {
		BASE_URL = bASE_URL;
	}
	private synchronized static AsyncHttpClient getSameHttpClient() {
		if (httpclient == null) {
			
			 SSLSocketFactory sf = MySSLSocketFactory.getFixedSocketFactory();  
			//从android-async-http包中取得SSLSocketFactory的对象。静态方法getFixedSocketFactory中已经设置允许所以服务器证书
			  SchemeRegistry schReg = new SchemeRegistry();
			  schReg.register(new Scheme("https", sf, 443));
			  schReg.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
			//设置SchemeRegistry为httpclient提供http和https选项。。这里未设置http



			httpclient = new AsyncHttpClient(schReg);
			httpclient.setSSLSocketFactory(sf);
			httpclient.getHttpClient().getParams().setParameter(ClientPNames.ALLOW_CIRCULAR_REDIRECTS, true);
			httpclient.addHeader("Accept", "application/x-ms-application, image/jpeg, application/xaml+xml, image/gif, image/pjpeg, application/x-ms-xbap, */*");
			httpclient.addHeader("Accept-Language", "zh-CN");
			httpclient.addHeader("Accept-Encoding", "gzip, deflate");
			httpclient.setUserAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/38.0.2125.122 Safari/537.36");
			httpclient.addHeader("x-requested-with", "XMLHttpRequest");
	//		httpclient.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
			//httpclient.setCookieStore(cookieStore)
		//	PersistentCookieStore cookieStore=
		//	((AbstractHttpClient)(httpclient.getHttpClient())).setc.getCookieStore().getCookies().
		
			return httpclient;
		}
		return httpclient;
	}
	
	public static void get(String url, AsyncHttpResponseHandler responseHandler) {
		getSameHttpClient().get(getAbsoluteUrl(url), responseHandler);
	}

	public static void get(String url, RequestParams params,
			AsyncHttpResponseHandler responseHandler) {
		getSameHttpClient().get(getAbsoluteUrl(url), params, responseHandler);
	}
	/**
	 * @Description: TODO(不带参数，获取json对象或者数组)
	 * @author 诸葛飞扬。JJ
	 * @date 2014-1-24 下午1:36:49
	 * @param urlString
	 * @param res
	 */
	public static void get(String urlString,JsonHttpResponseHandler res)   //不带参数，获取json对象或者数组
    {
		getSameHttpClient().get(urlString, res);
    }
	public static void get(AsyncHttpClient httpClient,String urlString,JsonHttpResponseHandler res)   //不带参数，获取json对象或者数组
    {
		httpClient.getHttpClient().getParams().setParameter(ClientPNames.ALLOW_CIRCULAR_REDIRECTS, true);
		httpClient.get(urlString, res);
    }
    /**
     * @Description: TODO(带参数，获取json对象或者数组)
     * @author 诸葛飞扬。JJ
     * @date 2014-1-24 下午1:36:38
     * @param urlString
     * @param params
     * @param res
     */
    public static void get(String urlString,RequestParams params,JsonHttpResponseHandler res)   //带参数，获取json对象或者数组
    {
    	getSameHttpClient().get(urlString, params,res);
    }
    
    /**
     * @Description: TODO(下载数据使用，会返回byte数据)
     * @author 诸葛飞扬。JJ
     * @date 2014-1-24 下午1:36:30
     * @param uString
     * @param bHandler
     */
    public static void get(String uString, BinaryHttpResponseHandler bHandler)   //下载数据使用，会返回byte数据
    {
    	getSameHttpClient().get(uString, bHandler);
    }
	public static void post(String url, RequestParams params,
			AsyncHttpResponseHandler responseHandler) {
		
		getSameHttpClient().post(getAbsoluteUrl(url), params, responseHandler);
	}

	private static String getAbsoluteUrl(String relativeUrl) {
		return BASE_URL + relativeUrl;
	}
	public static void clear(){
		if(httpclient!=null){
			httpclient.delete("", null);
			httpclient=new AsyncHttpClient();
		}
	}
}
