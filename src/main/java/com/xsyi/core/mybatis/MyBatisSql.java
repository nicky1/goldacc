/**
 * 
 */
package com.xsyi.core.mybatis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 封装动态mybatis配置的sql
 * @author tangtao7481
 * @version $Id: MyBatisSql.java, v 0.1 Apr 2, 2013 1:25:26 PM tangtao7481 Exp $
 */
public class MyBatisSql {

    /** 
     * 运行期 sql 
     */  
    private String sql;  
      
    /** 
     * 参数 数组 
     */  
    private Object[] parameters;  
    
    public void setSql(String sql) {    
        this.sql = sql;    
    }    
    
    public String getSql() {    
        return sql;    
    }    
    
    public void setParameters(Object[] parameters) {    
        this.parameters = parameters;    
    }    
    
    public Object[] getParameters() {    
        return parameters;    
    }    
      
    @Override  
    public String toString() {  
        if(parameters == null || sql == null)  
        {  
            return "";  
        }  
        List<Object> parametersArray = Arrays.asList(parameters);  
        List<Object> list = new ArrayList<Object>(parametersArray);  
        while(sql.indexOf("?") != -1 && list.size() > 0 && parameters.length > 0)  
        {  
            sql = sql.replaceFirst("\\?", list.get(0).toString());  
            list.remove(0);  
        }  
        return sql.replaceAll("(\r?\n(\\s*\r?\n)+)", "\r\n");  
    } 
    
}