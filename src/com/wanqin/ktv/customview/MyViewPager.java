/**   
* �ļ�����MyViewPager.java 
* �����ƣ�MyViewPager   
* ��������      
* �����ˣ������JJ   
* ����ʱ�䣺2014-4-30 ����9:05:21  
* Copyright �����JJ Corporation 2014 ��Ȩ����     
* �汾��Ϣ��    
* �޸��ˣ�jj   
* �޸�ʱ�䣺2014-4-30 ����9:05:21   
* �޸ı�ע��   
*/ 
package com.wanqin.ktv.customview;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

/**
 * @ClassName: MyViewPager
 * @Description: TODO(*)
 * @author �����JJ
 * @date 2014-4-30 ����9:05:21
 * 
 */
public class MyViewPager extends ViewPager {
	private boolean isCanScroll = false;  
	/**
	 * @param context
	 */
	public MyViewPager(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	public MyViewPager(Context context, AttributeSet attrs) {  
        super(context, attrs);  
    }  
	public void setScanScroll(boolean isCanScroll) {  
        this.isCanScroll = isCanScroll;  
    }  
  
    @Override  
    public void scrollTo(int x, int y) {  
    	//if (isCanScroll) {
    		 super.scrollTo(x, y);  
		//}
           
    }  
 /*   @Override
    protected boolean canScroll(View v, boolean checkV, int dx,   
    		  
    		int x, int y) {
    	 if (v instanceof LinearLayout) {  
    		   
             return true;  

     }  

     return super.canScroll(v, checkV, dx, x, y);  

}  */
    
 /*   @Override  
    public boolean onTouchEvent(MotionEvent arg0) {  
        // TODO Auto-generated method stub  
    	if (isCanScroll) {
			return true;
		}else {
			 return false;//super.onTouchEvent(arg0);  
		}
       
    } */

 /*   @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
    	if (isCanScroll) {
			return true;
		}else {
			 return false;//super.onTouchEvent(arg0);  
		}
    }*/
    @Override  
    public void setCurrentItem(int item, boolean smoothScroll) {  
        // TODO Auto-generated method stub  
        super.setCurrentItem(item, smoothScroll);  
    }  
  
    @Override  
    public void setCurrentItem(int item) {  
        // TODO Auto-generated method stub  
        super.setCurrentItem(item);  
    }  
}
