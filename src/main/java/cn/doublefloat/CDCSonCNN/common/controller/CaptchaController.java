package cn.doublefloat.CDCSonCNN.common.controller;

import cn.doublefloat.CDCSonCNN.common.constant.Constants;
import cn.doublefloat.CDCSonCNN.common.utils.IdUtils;
import cn.doublefloat.CDCSonCNN.common.utils.VerifyCodeUtils;
import cn.doublefloat.CDCSonCNN.common.utils.sign.Base64;
import cn.doublefloat.CDCSonCNN.framework.redis.RedisCacheService;
import cn.doublefloat.CDCSonCNN.framework.web.domain.AjaxResult;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author 李广帅
 * @date 2020/7/21 5:57 下午
 */
@CrossOrigin
@Slf4j
@RestController
@Api(tags = "验证码接口")
public class CaptchaController {


    @Autowired
    private RedisCacheService redisCacheService;

    @Value("${captcha.width}")
    private Integer captchaCodeWidth;

    @Value("${captcha.height}")
    private Integer captchaCodeHeight;

    @Value("${captcha.length}")
    private Integer captchaCodeLength;

    @GetMapping("/captchaImage")
    public AjaxResult captcha() {
        String verifyCode = VerifyCodeUtils.generateVerifyCode(captchaCodeLength);

        // 唯一标识
        String uuid = IdUtils.simpleUUID();
        String verifyKey = Constants.CAPTCHA_CODE_KEY + uuid;

        log.debug("验证码: " + verifyCode);

        // 将验证码存入缓存
        redisCacheService.setCacheObject(verifyKey, verifyCode, 3, TimeUnit.MINUTES);

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        AjaxResult result = AjaxResult.success();
        try {
            VerifyCodeUtils.outputImage(captchaCodeWidth, captchaCodeHeight, stream, verifyCode);
            result.put("uuid", uuid);
            result.put("img", "data:image/jpg;base64," + Base64.encode(stream.toByteArray()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
