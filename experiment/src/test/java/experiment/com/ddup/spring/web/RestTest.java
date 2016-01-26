package experiment.com.ddup.spring.web;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class RestTest {
	
	@Test
	public void getUserList(){
		String url1 = "http://localhost:8080/nmp/photo/photo/create?uid";
		String url2 = "http://usr.iwhere.com:8888/frdsyst/www/app.php/frd/fOpt/checkout_frds/?uid=0fcac163dd6700e3e9805c87b5914afbe70b9757";
		
		/*
		Bean1 bean = new Bean1();
		bean.setRemark("这是测试照片113");
		bean.setAccess_token("fd757327d2ffd246a79cd1056b4d365589099073");
		bean.setFile("wsx/wsx/1.png");
		bean.setGroup("group1");
		
		HttpEntity<String> entity = new HttpEntity<String>(JSONObject.fromObject(bean).toString());
		RestTemplate template = new RestTemplate();
		ResponseEntity<MyUser> response = template.postForEntity(url1,
				entity, MyUser.class);
		MyUser myUser = response.getBody();*/
		
		RestTemplate template = new RestTemplate();
		ResponseEntity<JSONObject> response2 = template.postForEntity(url2,
				null, JSONObject.class);
		JSONObject json = response2.getBody();
		JSONArray array = (JSONArray)json.get("msg");
		for (int i = 0; i < array.size(); i++) {
			JSONObject tempJson = (JSONObject)array.get(i);
			Iterator keys = tempJson.keys();
			while (keys.hasNext()) {
				String key = (String)keys.next();
			}
		}
		
		System.out.println(json);
	}
}
