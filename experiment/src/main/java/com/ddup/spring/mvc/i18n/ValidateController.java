package com.ddup.spring.mvc.i18n;

import java.util.List;

import javax.validation.Valid;

import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ddup.spring.mvc.dto.TestReq;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@RestController
@RequestMapping(value = "/vali", produces="application/json;charset=UTF-8",method = {RequestMethod.GET,RequestMethod.PUT})
public class ValidateController {
    
    /**
     * 获取用户主页信息
     * @Title
     * @Description 
     * @param vo
     * @param errors
     * @return
     * @TestUrl
     */
    @RequestMapping(value = "/login")
    public String login(@Valid TestReq dtoReq, Errors errors){
        //1 数据校验
        if (errors.hasErrors()) {
            List<ObjectError> list = errors.getAllErrors();
            JSONArray errorArray = new JSONArray();
            JSONObject tempJson = null;
            FieldError fieldError = null;
            for (ObjectError objectError : list) {
                fieldError = (FieldError)objectError;
                tempJson = new JSONObject();
                tempJson.put("field", fieldError.getField());
                tempJson.put("errorMsg", fieldError.getDefaultMessage());
                errorArray.add(tempJson);
            }
        }
        return "";
        
    }   
}
