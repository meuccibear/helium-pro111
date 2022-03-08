package io.renren;

import io.renren.common.gitUtils.exception.MsgException;
import io.renren.common.gitUtils.http.HttpResultData;
import io.renren.common.gitUtils.http.HttpUtils;
import org.apache.http.conn.HttpHostConnectException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @program: starsharks
 * @ClassName tests
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-03-03 10:23
 * @Version 1.0
 **/
public class tests {
    private static Logger logger = LoggerFactory.getLogger(tests.class);

    public static void main(String[] args) throws MsgException {

        // https://starsharks.com/go/api/market/sharks


        String headStr =
                "Connection: keep-alive\n" +
                        "sec-ch-ua: \" Not A;Brand\";v=\"99\", \"Chromium\";v=\"98\", \"Google Chrome\";v=\"98\"\n" +
                        "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2NDczNTg5MTksImp0aSI6IjB4ODI2NmIzYmIyNDI4YTU1NDlhOWM5MGI0OGY2ZTQxOTE3ZTg4MDQwMyIsInN1YiI6IndlYiJ9.VmliLhir_qMGXteMKya-1md2Rq0sg5I3vuELTv0TgSE\n" +
                        "Content-Type: application/json\n" +
                        "sec-ch-ua-mobile: ?0\n" +
                        "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/98.0.4758.102 Safari/537.36\n" +
                        "sec-ch-ua-platform: \"Windows\"\n" +
                        "Accept: */*\n" +
                        "Origin: https://starsharks.com\n" +
                        "Sec-Fetch-Site: same-origin\n" +
                        "Sec-Fetch-Mode: cors\n" +
                        "Sec-Fetch-Dest: empty\n" +
                        "Referer: https://starsharks.com/zh-Hant/market?tab=rent\n" +
                        "Accept-Language: zh-CN,zh;q=0.9\n" +
                        "Cookie: _ga=GA1.1.1524215088.1646148198; _ga_EKLPQL67GF=GS1.1.1646148198.1.1.1646151377.0";

        String data = "{\"class\":[],\"star\":0,\"pureness\":0,\"hp\":[0,200],\"speed\":[0,200],\"skill\":[0,200],\"morale\":[0,200],\"body\":[],\"parts\":[],\"rent_cyc\":0,\"rent_except_gain\":[0,0],\"skill_id\":[0,0,0,0],\"page\":2,\"filter\":\"rent\",\"sort\":\"PriceAsc\",\"page_size\":36}";
        try {
            Map<String, String> headres = HttpUtils.getHeadres(headStr);
            HttpUtils.setProxyAddr("127.0.0.1:8866");
            HttpResultData resultData = HttpUtils.post("https://starsharks.com/go/api/market/sharks", data, headres);

            System.out.println(resultData.getResult());
        } catch (MsgException e) {
            info(e.getMessage());
        } catch (HttpHostConnectException e) {
            info("Http主机连接异常!");
        }

    }

    static void info(String msg) {
        logger.info("msg:\t" + msg);
    }

}
