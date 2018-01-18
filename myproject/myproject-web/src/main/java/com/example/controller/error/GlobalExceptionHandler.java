package com.example.controller.error;

import com.example.entity.error.ErrorInfo;
import com.example.entity.error.ResultCode;
import com.example.util.exception.MyException;
import com.sun.net.httpserver.Authenticator;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by 01444966 on 2018/1/17.
 */
@ControllerAdvice
class GlobalExceptionHandler {

    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }

    /**
     * JSON格式的异常处理
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest req, MyException e) throws Exception {
        ErrorInfo<String> r = new ErrorInfo<String>();
        r.setMessage(e.getMessage());
        r.setCode(ErrorInfo.ERROR);
        r.setData("Some Data");
        r.setUrl(req.getRequestURL().toString());
        return r;
    }

    /**
     * 处理运行时异常
     * @param e
     * @param response
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    //@ExceptionHandler(value={RuntimeException.class,MyRuntimeException.class})
    // @ExceptionHandler//处理所有异常
    @ResponseBody //在返回自定义相应类的情况下必须有，这是@ControllerAdvice注解的规定
    public ErrorInfo<String> exceptionHandler(RuntimeException e, HttpServletResponse response) {
        ErrorInfo<String> resp = new ErrorInfo<String>();
         resp.setCode(300);
         resp.setMessage("exception-Handler");
         //response.setStatus(600);
         return resp;
    }

    /**
     * 参数不合法异常处理
     * @param e
     * @return
     */
    /*@ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorInfo<String> handleIllegalParamException(MethodArgumentNotValidException e) {
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        String tips = "参数不合法";
        if (errors.size() > 0) {
            tips = errors.get(0).getDefaultMessage();
        }
        return ResultCode.PARAMETER_ERROR, tips);
    }
*/
}