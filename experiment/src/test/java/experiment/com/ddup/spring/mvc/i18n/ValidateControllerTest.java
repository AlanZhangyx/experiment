package experiment.com.ddup.spring.mvc.i18n;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import experiment.com.ddup.spring.base.BaseControllerTest;

@RunWith(SpringJUnit4ClassRunner.class)
public class ValidateControllerTest extends BaseControllerTest{
	
	   @Test
	    public void testGetJsonResp() throws Exception {
	        /*String json = this.mockMvcJson("/iaddress/test/getJsonResp", null);
	        // Json 解析
	        TestResp resp = objectMapper.readValue(json, TestResp.class);
	        // 验证
	        assertEquals("返回状态正常", resp.getServer_status(), 200);
	        assertNotNull("list返回正常", resp.getList());
	        for (int i = 0; i < resp.getList().size(); i++){
	            assertEquals("子List正常", resp.getList().get(i).getPhotoId(), Long.valueOf(i));
	        }*/
	    }

	    @Test
	    public void testGetValiResp() throws Exception {
	    	String json = null;
	        // --------------------------- 测试普通后台验证 ---------------------------
	    	
	       /* String json = this.mockMvcJson("/experiment/vali/lgoin", null);
	        // Json 解析
	        BaseResp resp = objectMapper.readValue(json, BaseResp.class);
	        // 验证
	        assertEquals("验证异常", resp.getServer_status(), BaseResp.STATUS_ERROR_VALIDATE);*/

	        // --------------------------- 验证异常国际化 ---------------------------
	        Map<String, String> param = new HashMap<String, String>();
	        param.put("userName", "");
	        json = this.mockMvcJson("/experiment/vali/login", param);
	        // Json解析
	        // 验证
	        //assertEquals("国际化验证", json, "地址ID不能为空");

	    }

	    @Test
	    public void testGetYwException() throws Exception {

	    }

	    @Test
	    public void testGetI18n() throws Exception {
	    	
	    }

	    @Test
	    public void testGetI18n00() throws Exception {

	    }
}
