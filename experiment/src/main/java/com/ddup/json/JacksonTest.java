package com.ddup.json;

import java.io.File;
import java.io.IOException;

import com.ddup.json.model.User;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Jackson官网文档
 * http://wiki.fasterxml.com/JacksonDocumentation
 *
 * <br>
 * <strong>copyright</strong>： 2015, 北京都在哪网讯科技有限公司<br>
 * <strong>Time </strong>: 2015年12月3日<br>
 * <strong>History</strong>：<br>
 * Editor　　　version　　　Time　　　　　Operation　　　　　　　Description<br>
 *
 * @author dznzyx
 * @version : 1.0.0
 */
public class JacksonTest {

	/**
	 * @Title
	 * @Description
	 * @param args
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 * @TestUrl
	 */
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		
		//File
			//File使用相对路径，相对路径必须有参照路径，默认情况下是"用户启动jvm的目录"，在eclipse的项目中启动jvm，根目录就是项目名
			//System.getProperty("user.dir")标识当前用户目录
			//可以使用"."来代表当前用户目录
		
		//1 readJSON从json文件中读值绑定
		User user = mapper.readValue(new File("./target/classes/com/ddup/json/model/user.json"), User.class);
		
		//2 writeJSON从对象中读值写成json
		//mapper.writeValue(new File("./target/classes/com/ddup/json/model/user-writed.json"), user);
		System.out.println(mapper.writeValueAsString(user));
		
	}

}
