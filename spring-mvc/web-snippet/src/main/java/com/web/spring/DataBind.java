package com.web.spring.databind;

import com.web.spring.databind.domain.ResponseError;
import com.web.spring.databind.domain.SimpleUser;
import com.web.spring.databind.domain.ComplexUser;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.validation.Valid;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/7/9.
 */
@Controller
@RequestMapping(value = "/databind")
public class DataBind {

    // 返回带有http status code的响应体

    /**
     * TODO http://localhost:18080/databind/simpleObject?name=sun&age=27
     * 简单对象映射成对象中的字段,字段从url中的参数中读取
     */
    @GetMapping(value = "/simpleObject", produces = "application/json")
    public ResponseEntity getSimpleObject(@Valid SimpleUser user, BindingResult result) {
        if (result.hasErrors()) {
            ResponseError error = new ResponseError(result.getFieldError().getDefaultMessage());
            return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(user, HttpStatus.OK);
    }

    /**
     * TODO http://localhost:18080/databind/simpleObject?name=sun&age=27&contactInfo.phone=8888888
     * 复杂对象映射，成第一级对象的字段加第二级字段的{属性名.字段}
     */
    @GetMapping(value = "complexObject")
    public ResponseEntity getComplexObject(@Valid ComplexUser user, BindingResult result) {
        if (result.hasErrors()) {
            ResponseError error = new ResponseError(result.getFieldError().getDefaultMessage());
            return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(user, HttpStatus.OK);
    }

    // 指定responseBody的返回格式

    /**
     * TODO http://localhost:18080/databind/json?name=sunu&age=0015
     * 返回json数据
     */
    @GetMapping(value = "/json", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public SimpleUser writeJson(@Valid SimpleUser user, BindingResult result) {
        return new SimpleUser(user.getName(), user.getAge());
    }

    /**
     * TODO http://localhost:18080/databind/json
     * 请求体, 解析json请求体
     * {
     * "name": "sun",
     * "age": 15
     * }
     */
    @PostMapping(value = "/json", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public SimpleUser readJson(@Valid @RequestBody SimpleUser user, BindingResult result) {
        return new SimpleUser(user.getName(), user.getAge());
    }

    /**
     * 生成xml数据的模型, 需要使用注解去定义
     */
    @GetMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public SimpleUser writeXml(@Valid SimpleUser user, BindingResult result) {
        return user;
    }

    @PostMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public SimpleUser readXml(@Valid @RequestBody SimpleUser user, BindingResult result) {
        return user;
    }

    // 不指定responseBody的返回形式, 由客户端决定

    /**
     * Ref: http://www.baeldung.com/spring-httpmessageconverter-rest
     * TODO http://localhost:18080/databind/typeByClient?name=sunu&age=0015
     * TODO responseBody返回形式由client上报的header中的Accept决定
     * Spring 4中会默认开启注解进行httpMessageConverter
     */
    @GetMapping(value = "/typeByClient")
    @ResponseBody
    public SimpleUser writeByClient(@Valid SimpleUser user, BindingResult result) {
        return new SimpleUser(user.getName(), user.getAge());
    }

    // PropertyEditor 应用: 局部,　使用WebDataBinder绑定

    /**
     * TODO http://localhost:18080/databind/date?date=2017-07-09
     */
    @GetMapping(value = "/date")
    @ResponseBody
    public String getDate(Date date) {
        return date.toString();
    }

//    @InitBinder("date")
//    public void initDate(WebDataBinder binder) {
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
//    }


    // Formatter 应用: 全局/局部 可扩展, 可实现注解配置
    // spring 全局配置
//    <annotation-driven conversion-service="myDateFormatter">
//    </annotation-driven>
//
//    <beans:bean id="myDateFormatter"
//    class="org.springframework.format.support.FormattingConversionServiceFactoryBean">
//        <beans:property name="formatters">
//            <beans:set>
//                <beans:bean class="com.web.spring.databind.common.MyDateFormatter"></beans:bean>
//            </beans:set>
//        </beans:property>
//    </beans:bean>
    // TODO http://localhost:18080/databind/dateFormatter?date2=2017-07-09
    // 注意: 传入的参数只能为date2 与方法参数保持一致
    @GetMapping(value = "dateFormatter")
    @ResponseBody
    public String getFormatterDate(Date date2) {
        return date2.toString();
    }


    // Converter 应用：全局/局部 可扩展
    // TODO http://localhost:18080/databind/dateConverter?date=2017-07-09
    // 注意: 传入的参数只能为date2 与方法参数保持一致
    @GetMapping(value = "dateConverter")
    @ResponseBody
    public String getConverterDate(Date date) {
        return date.toString();
    }
}
