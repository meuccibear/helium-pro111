package io.renren;

import io.renren.business.HeliumDemo;
import io.renren.common.gitUtils.exception.MsgException;

/**
 * @program: starsharks
 * @ClassName Helium
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-03-02 15:48
 * @Version 1.0
 **/
public class Helium {

    public static void main(String[] args) throws MsgException {
//        exportGateway();

        HeliumDemo.getRandomLocations("data/Hexs.txt", "853109d7fffffff^8&");
    }

    /**
     * 导出 设备配置文件
     */
    public static void exportGateway() {
        String[] arr = new String[0];
        int userId = 1;
        int index = 0, groupIndex = 0;
        String groupName = "";

        switch (userId) {
            case 1:
                // 湖南陈总
                index = 130;
                groupIndex = 19;
                groupName = "hncz";

                arr = new String[]{
                        "192.168.37.39\n" +
                                "192.168.39.50\n" +
                                "192.168.38.49\n" +
                                "192.168.37.38\n" +
                                "192.168.39.48\n" +
                                "192.168.38.48\n" +
                                "192.168.37.37\n" +
                                "192.168.37.36\n"
                };
                break;
            case 2:
                // 成都李总
                index = 10;
                groupIndex = 2;
                groupName = "cdlz";

                arr = new String[]{
                        "192.168.37.39\n" +
                                "192.168.39.50\n" +
                                "192.168.38.49\n" +
                                "192.168.37.38\n" +
                                "192.168.39.48\n" +
                                "192.168.38.48\n" +
                                "192.168.37.37\n" +
                                "192.168.37.36\n"
                };
                break;
            case 3:
                // 深圳谢总
                index = 0;
                groupIndex = 0;
                groupName = "szxz";

                arr = new String[]{
                        "192.168.37.39\n" +
                                "192.168.39.50\n" +
                                "192.168.38.49\n" +
                                "192.168.37.38\n" +
                                "192.168.39.48\n" +
                                "192.168.38.48\n" +
                                "192.168.37.37\n" +
                                "192.168.37.36\n"
                };
                break;
            default:
                break;
        }

        new HeliumDemo().exportGateway(index, 1680, groupIndex, groupName, arr);
    }


}
