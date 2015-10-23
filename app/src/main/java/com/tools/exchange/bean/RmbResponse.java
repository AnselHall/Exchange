package com.tools.exchange.bean;

import java.util.List;

/**
 * Created by user on 2015/10/23.
 */
public class RmbResponse {

    public String error_code;/*错误代码  0：成功  1：失败*/

    public String reason;/*成功或失败的原因*/

    public List<ItemDetail> result;/*请求成功的数据*/
}
