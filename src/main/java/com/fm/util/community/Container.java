package com.fm.util.community;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("all")
public class Container {

    //全部已查询的活动信息容器
    private static List<Map<String, Object>> activityMaps = new ArrayList<>();
    //全部已查询并是正在进行的活动信息容器
    private static List<Map<String, Object>> underwayActivityMaps = new ArrayList<>();

    /**
     * 全部已查询的活动信息容器
     *
     * @param activityMap 单个活动map
     * @return 已查询的活动信息map
     */
    public static Map<String, Object> activityContainer(Map<String, Object> activityMap) {

        if (null != activityMap)
            activityMaps.add(activityMap);

        Map<String, Object> pageMap = new HashMap<>();
        pageMap.put("status", 0);
        if (0 != activityMaps.size()) {
            pageMap.put("status", 1);
            pageMap.put("activityList", activityMaps);
        }
        return pageMap;
    }

    /**
     * 全部已查询并是正在进行的活动信息容器
     *
     * @param underwayActivityMap 单个活动map
     * @return 已查询是正在进行的活动信息map
     */
    public static Map<String, Object> underwayActivityContainer(Map<String, Object> underwayActivityMap) {

        if (null != underwayActivityMap)
            underwayActivityMaps.add(underwayActivityMap);

        Map<String, Object> pageMap = new HashMap<>();
        pageMap.put("status", 0);
        if (0 != underwayActivityMaps.size()) {
            pageMap.put("status", 1);
            pageMap.put("activityList", underwayActivityMaps);
        }
        return pageMap;
    }

    /**
     * 清空数据
     */
    public static void clear() {
        activityMaps.clear();
        underwayActivityMaps.clear();
    }
}
