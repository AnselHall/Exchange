package com.tools.exchange;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.panwrona.downloadprogressbar.library.DownloadProgressBar;
import com.squareup.okhttp.Request;
import com.tools.exchange.bean.ItemDetail;
import com.tools.exchange.bean.RateResponse;
import com.tools.exchange.bean.RmbResponse;
import com.tools.exchange.net.OkHttpClientManager;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView tv_code, tv_name, tv_fBuyPri, tv_mBuyPri, tv_fSellPri,
            tv_mSellPri, tv_bankConversionPri, tv_updateTime;
    private String responseString;

    private ItemDetail testItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DownloadProgressBar downloadProgressBar = ((DownloadProgressBar) findViewById(R.id.dpv3));
        downloadProgressBar.setSuccessResultState();
        downloadProgressBar.setOnProgressUpdateListener(new DownloadProgressBar.OnProgressUpdateListener() {
            @Override
            public void onProgressUpdate(float v) {

            }

            @Override
            public void onAnimationStarted() {

            }

            @Override
            public void onAnimationEnded() {

            }

            @Override
            public void onAnimationSuccess() {

            }

            @Override
            public void onAnimationError() {

            }

            @Override
            public void onManualProgressStarted() {

            }

            @Override
            public void onManualProgressEnded() {

            }
        });
        initComponent();
        String rmbUrl = "http://apis.haoservice.com/lifeservice/exchange/rmbquot?key=fab86dbca92d49778e0e5ab3d61f8d29";
        String rateUrl = "http://apis.haoservice.com/lifeservice/exchange/rmbquot?key=fab86dbca92d49778e0e5ab3d61f8d29";

        //人民币牌价
        getRmbQuot(rmbUrl);


        //外汇汇率
        getRate(rateUrl);
    }

    private void getRate(String rateUrl) {
        OkHttpClientManager.getAsyn(rateUrl, new OkHttpClientManager.ResultCallback<RateResponse>() {

            @Override
            public void onError(Request request, Exception e) {

            }

            @Override
            public void onResponse(RateResponse response) {

            }
        });
    }
    private void getRmbQuot(String url) {
        OkHttpClientManager.getAsyn(url, new OkHttpClientManager.ResultCallback<RmbResponse>() {

            @Override
            public void onError(Request request, Exception e) {

            }

            @Override
            public void onResponse(RmbResponse beanByUrl) {
                if (beanByUrl != null) {
                    List<ItemDetail> result = beanByUrl.result;
                    for (int i = 0; i < result.size(); i++) {
                        ItemDetail itemDetail = result.get(i);
                        if ("美元".equals(itemDetail.name)) {
                            testItem = itemDetail;
                        }
                    }

                    tv_code.setText("货币代码:" + testItem.code);
                    tv_name.setText("货币名称:" + testItem.name);
                    tv_fBuyPri.setText("现钞买入价:" + testItem.fBuyPri);
                    tv_mBuyPri.setText("现汇买入价:" + testItem.mBuyPri);
                    tv_fSellPri.setText("现钞卖出价:" + testItem.fSellPri);
                    tv_mSellPri.setText("现汇卖出价:" + testItem.mSellPri);
                    tv_bankConversionPri.setText("中行折算价:" + testItem.bankConversionPri);
                    tv_updateTime.setText("发布时间:" + testItem.updateTime);
                }
            }
        });
    }

    private void initComponent() {
        tv_code = (TextView) findViewById(R.id.tv_code);
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_fBuyPri = (TextView) findViewById(R.id.tv_fBuyPri);
        tv_mBuyPri = (TextView) findViewById(R.id.tv_mBuyPri);
        tv_fSellPri = (TextView) findViewById(R.id.tv_fSellPri);
        tv_mSellPri = (TextView) findViewById(R.id.tv_mSellPri);
        tv_bankConversionPri = (TextView) findViewById(R.id.tv_bankConversionPri);
        tv_updateTime = (TextView) findViewById(R.id.tv_updateTime);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
