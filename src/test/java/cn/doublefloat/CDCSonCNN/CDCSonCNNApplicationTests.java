package cn.doublefloat.CDCSonCNN;

import cn.papercheck.engine.CheckManager;
import cn.papercheck.exception.RegCodeInvalidException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

@SpringBootTest
class CDCSonCNNApplicationTests {

    @Test
    void contextLoads() throws RegCodeInvalidException {
        CheckManager.INSTANCE.setRegCode("MQIF2/Z4gytHOmrujH71SCsDEnYZUnkK2lwwvVJaTyXBm4mTapW5c238IQJhlzlGc+jmJaE0sDLxiNeE3w1yWOsKMaz9p7FuEQNDPuTskGckq7e0v5HQE6sobiMMcwWxJaJ6pvE3h/ibup37c9KakvIZkKRAcl2MgoT+SuNQxytmWK5a5Opsf32Jk24OBNX2F7/6zqkV78WdxfYKvLsX0ZRfaKX/gkp+W5AKwP0Il1P81eqBmJDxFlyA5brVg178GVQSJkdbC44CA+T5YSUiHFspvg9vYp4CeO9s9cCMXujaFmrt9J9ixOD/IsO/SZADuW+OG8YRbvKvLugPyUw63lJnGYo8MloI9uDZw69uLMrD/dGczrxXl1z7ebkFJ5db6Ln5XHyKeJSW2WX/sSNrDlp0ps3dkpjo4yiKR5b7HVQGhpYpYxDKOZbg+kq/8J6TsryNyGsY93gRYFWfwSo8Orzfj5cmpup4pK6WkrJTnhA=");
        System.out.println(CheckManager.INSTANCE.getMachineCode());
    }

}
