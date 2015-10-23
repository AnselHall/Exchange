package com.tools.exchange.bean;

import java.io.Serializable;

/**
 * Created by user on 2015/10/23.
 */
public class RateResultItem implements Serializable{

    private static final long serialVersionUID = 1L;
    /**
     * code : CADGBP
     * currency : 加元英镑
     * closePri : 0.4965
     * diffPer : 0.12%
     * diffAmo : 0.0006
     * openPri : 0.4957
     * highPic : 0.4968
     * lowPic : 0.4952
     * past : 0.4959
     * updateTime : 2015-10-23 16:00
     */
    public String code;/*货币代码*/
    public String currency;/*货币名称*/
    public String closePri;/*最新价*/
    public String diffPer;/*涨跌%*/
    public String diffAmo;/*涨跌金额*/
    public String openPri;/*开盘价*/
    public String highPic;/*最高价*/
    public String lowPic;/*最低价*/
    public String past;
    public String updateTime;/*数据时间*/
}
