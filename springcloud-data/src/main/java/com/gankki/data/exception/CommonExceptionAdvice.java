package com.gankki.data.exception;


import com.gankki.data.json.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author ningpengtao
 * @email ning.pengtao@trs.com.cn
 * <pre>
 * 	通用异常处理
 * </pre>
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class CommonExceptionAdvice implements ResponseBodyAdvice {
  /**
   * 400 - Bad Request
   */
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MissingServletRequestParameterException.class)
  public AjaxResult<String,Object> handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
    log.error("缺少请求参数", e);
    return new AjaxResult<String,Object>().failure("required_parameter_is_not_present");
  }

  /**
   * 400 - Bad Request
   */
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(HttpMessageNotReadableException.class)
  public AjaxResult<String,Object> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
    log.error("参数解析失败", e);
    return new AjaxResult<String,Object>().failure("could_not_read_json");
  }

  /**
   * 400 - Bad Request
   */
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public AjaxResult<Object,Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
    log.error("参数验证失败", e);
    BindingResult result = e.getBindingResult();
    FieldError error = result.getFieldError();
    String field = error.getField();
    String code = error.getDefaultMessage();
    
    Map<String, String> errorMap = new HashMap<>();
    
    errorMap.put(field, code);

    return new AjaxResult<Object,Object>().failure(errorMap);
  }

  /**
   * 400 - Bad Request
   */
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(BindException.class)
  public AjaxResult<Object,Object> handleBindException(BindException e) {
    log.error("参数绑定失败", e);
    BindingResult result = e.getBindingResult();
    FieldError error = result.getFieldError();
    String field = error.getField();
    String code = error.getDefaultMessage();
    
    Map<String, String> errorMap = new HashMap<>();
    
    errorMap.put(field, code);

    return new AjaxResult<Object,Object>().failure(errorMap);
  }

  /**
   * 400 - Bad Request
   */
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(ConstraintViolationException.class)
  public AjaxResult<String,Object> handleServiceException(ConstraintViolationException e) {
    log.error("参数验证失败", e);
    Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
    ConstraintViolation<?> violation = violations.iterator().next();
    String message = violation.getMessage();

    return new AjaxResult<String,Object>().failure(message);
  }

  /**
   * 400 - Bad Request
   */
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(ValidationException.class)
  public AjaxResult<String,Object> handleValidationException(ValidationException e) {
    log.error("参数验证失败", e);
    return new AjaxResult<String,Object>().failure("validation_exception");
  }

  /**
   * 405 - Method Not Allowed
   */
  @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
  @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
  public AjaxResult<String,Object> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
    log.error("不支持当前请求方法", e);
    return new AjaxResult<String,Object>().failure("request_method_not_supported");
  }

  /**
   * 415 - Unsupported Media Type
   */
  @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
  @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
  public AjaxResult<String,Object> handleHttpMediaTypeNotSupportedException(Exception e) {
    log.error("不支持当前媒体类型", e);
    return new AjaxResult<String,Object>().failure("content_type_not_supported");
  }

  /**
   * 500 - Internal Server Error
   */
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(RuntimeException.class)
  public AjaxResult<String,Object> handleServiceException(RuntimeException e) {
    log.error("业务逻辑异常", e);
    return new AjaxResult<String,Object>().failure("业务逻辑异常：" + e.getMessage());
  }

  /**
   * 500 - Internal Server Error
   */
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(Exception.class)
  public AjaxResult<String,Object> handleException(Exception e) {
    log.error("通用异常", e);
    return new AjaxResult<String,Object>().failure(e.getMessage());
  }

  /**
   * 操作数据库出现异常:名称重复，外键关联
   */
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(DataIntegrityViolationException.class)
  public AjaxResult<String,Object> handleException(DataIntegrityViolationException e) {
    log.error("操作数据库出现异常:", e);
    return new AjaxResult<String,Object>().failure("操作数据库出现异常：字段重复、有外键关联等");
  }

  @Override
  public boolean supports(MethodParameter returnType, Class converterType) {

    return true;
  }

  @Override
  public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
    ServletServerHttpResponse sshr=(ServletServerHttpResponse) response;
    HttpServletResponse response1=   sshr.getServletResponse();
    int status = response1.getStatus();
    if(status == 500) {
		response1.setStatus(200);
	}
    return body;
  }
}