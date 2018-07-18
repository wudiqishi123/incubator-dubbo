package com.alibaba.dubbo.rpc;/**
 * Created by zxl on 2018/7/18.
 */

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;

/**
 * @description:
 * @author:zxl
 * @createTime:2018/7/18 11:24
 */
public class Protocol$Adaptive implements  Protocol{
    public void destroy() { 
        throw new UnsupportedOperationException("method public abstract void com.alibaba.dubbo.rpc.Protocol.destroy() of interface com.alibaba.dubbo.rpc.Protocol is not adaptive method!"); 
    } 
    public int getDefaultPort() { 
        throw new UnsupportedOperationException("method public abstract int com.alibaba.dubbo.rpc.Protocol.getDefaultPort() of interface com.alibaba.dubbo.rpc.Protocol is not adaptive method!"); 
    } 
    public   Invoker refer(Class arg0, URL arg1) throws com.alibaba.dubbo.rpc.RpcException { 
        if (arg1 == null) throw new IllegalArgumentException("url == null"); 
        URL url = arg1; 
        String extName = ( url.getProtocol() == null ? "dubbo" : url.getProtocol() ); 
        if(extName == null) 
        throw new IllegalStateException("Fail to get extension(com.alibaba.dubbo.rpc.Protocol) name from url(" + url.toString() +") use keys([protocol])");
        Protocol extension = (Protocol) ExtensionLoader.getExtensionLoader(Protocol.class).getExtension(extName); 
        return extension.refer(arg0, arg1); 
    } 
    public  Exporter export(Invoker arg0) throws com.alibaba.dubbo.rpc.RpcException { 
        if (arg0 == null) throw new IllegalArgumentException("com.alibaba.dubbo.rpc.Invoker argument == null"); 
        if (arg0.getUrl() == null) throw new IllegalArgumentException("com.alibaba.dubbo.rpc.Invoker argument getUrl() == null"); 
        URL url = arg0.getUrl();         String extName = ( url.getProtocol() == null ? "dubbo" : url.getProtocol() ); 
        if(extName == null) throw new IllegalStateException("Fail to get extension(com.alibaba.dubbo.rpc.Protocol) name rom url(" + 	url.toString() + ") use keys([protocol])"); 
        Protocol extension =(Protocol)ExtensionLoader.getExtensionLoader(Protocol.class).getExtension(extName); 
        return extension.export(arg0); 
    } 
}
