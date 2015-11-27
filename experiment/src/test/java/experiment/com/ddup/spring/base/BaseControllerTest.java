package experiment.com.ddup.spring.base;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Map;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * <br>
 * <strong>copyright</strong>： 2015, 北京都在哪网讯科技有限公司<br>
 * <strong>Time </strong>: 2015年11月27日<br>
 * <strong>History</strong>：<br>
 * Editor　　　version　　　Time　　　　　Operation　　　　　　　Description<br>
 *
 * @author dznzyx
 * @version : 1.0.0
 */
@WebAppConfiguration
@ContextConfiguration(locations = {"spring-context-i18n.xml"})
public class BaseControllerTest {
    
    @Autowired
    protected WebApplicationContext applicationContext;
    // mvc
    protected MockMvc mvc;
    // json 解析器
    protected ObjectMapper objectMapper;

    /**
     * 执行前方法
     */
    @Before
    public void before() {
        this.mvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
        this.objectMapper = new ObjectMapper();
    }


    // ------------------------------------------------ mock util ----------------------------------------------

    /**
     * mock 模拟请求
     *
     * @param uri   uri
     * @param param 参数
     * @return Json 字符串
     * @throws Exception
     */
    public String mockMvcJson(String uri, Map<String, String> param) throws Exception {
        // 构建请求
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post(uri).characterEncoding("UTF-8").accept(MediaType.APPLICATION_JSON);
        // 附加参数
        if (param != null) {
            for (Map.Entry<String, String> entry : param.entrySet()) {
                requestBuilder.param(entry.getKey(), entry.getValue());
            }
        }
        // mvc
        return this.mvc.perform(requestBuilder).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
    }
}
