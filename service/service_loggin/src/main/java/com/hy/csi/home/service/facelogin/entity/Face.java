package com.hy.csi.home.service.facelogin.entity;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.io.FileUtil;
import com.baidu.aip.face.MatchRequest;
import com.baidu.aip.util.Base64Util;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import com.baidu.aip.face.AipFace;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 使用百度API进行人脸识别进行登录功能
 * </p>
 *
 * @author gyf
 * @since 2020-10-18
 */

public class Face {
    public Face() {
    }

    @Value("${baidu.face.appId}")
    public static String appId;
    @Value("${baidu.face.apiKey}")
    public static String apiKey;
    @Value("${baidu.face.secretKey}")
    public static String secretKey;

    private static Float threshold = 92f;

    //创建一个aipface对象
    private static AipFace client = new AipFace(appId, apiKey, secretKey);
    //创建单例的原因是避免多次获取sdk
    public static AipFace getClient(){
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        return client;
    }


    /**
     * 获取百度api返回的json中的匹配分数，并与设置的分数线比较。
     *
     * @param object
     * @param score
     * @return
     */
    public boolean verify(JSONObject object, float score) {
        return Float.parseFloat(getString(object, "score")) - score >= 0;
    }

    public boolean verify(JSONObject object) {
        return verify(object, threshold);
    }


    public boolean match(String imgStr1, String imgStr2, String imageType) {
        return match(imgStr1, imgStr2, imageType, threshold);
    }

    public String getString(JSONObject object, String field) {
        return String.valueOf(
                Optional.ofNullable(object)
                        .map(o -> o.has(field))
                        .map(b -> b ? object.get(field) : null));
    }

    /**
     * 使用百度api进行人脸图片比较
     *
     * @param imgStr1
     * @param imgStr2
     * @param imageType
     * @return
     */
    public boolean match(String imgStr1, String imgStr2, String imageType, float score) {
        MatchRequest req1 = new MatchRequest(imgStr1, imageType);
        MatchRequest req2 = new MatchRequest(imgStr2, imageType);

        List<MatchRequest> requests = new ArrayList<MatchRequest>();
        requests.add(req1);
        requests.add(req2);

        JSONObject res = client.match(requests);

        return verify(res, score);
    }

    /**
     * 向百度api添加人脸数据，即完成人脸注册。
     *
     * @param image_base64     图片数据经过Base64编码后的字符串
     * @param imageType  图片类型
     * @return 百度api返回的face_token
     */
    public JSONObject addFace(String image_base64, String imageType, String groupId, String userId, HashMap<String, String> options) {
        JSONObject res = client.addUser(image_base64, imageType, groupId, userId, options);
        return res;
    }




}
