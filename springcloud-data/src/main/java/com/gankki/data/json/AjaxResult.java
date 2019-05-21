package com.gankki.data.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Map;

/**
 * 
 * @author ningpengtao
 * @email ning.pengtao@trs.com
 * 
 *        <pre>
 *        Json结果封装类
 *        </pre>
 *
 */
@Getter
@EqualsAndHashCode(callSuper=false)
@ToString
@ApiModel(description="异步请求结果")
@JsonInclude(Include.NON_NULL)
@SuppressWarnings({"rawtypes","unchecked"})
public class AjaxResult<M,D> {
	private static final String OK = "ok";
	private static final String ERROR = "error";

	@ApiModelProperty(required=true,value="消息状态")
	private Meta<M> meta;
	@ApiModelProperty(value="数据结果")
	private D data;

	public AjaxResult<M,D> success() {
		this.meta = new Meta(true, OK);
		return this;
	}
	
	public AjaxResult<M,D> success(String message) {
		this.meta = new Meta(true, message);
		return this;
	}

	public AjaxResult<M,D> success(String message, D data) {
		this.meta = new Meta(true, message);
		this.data = data;
		return this;
	}

	public AjaxResult<M,D> failure() {
		this.meta = new Meta(false, ERROR);
		return this;
	}

	public AjaxResult<M,D> failure(String message) {
		this.meta = new Meta(false, message);
		return this;
	}
	
	public AjaxResult<M,D> failure(Map<String,String> message) {
		this.meta = new Meta(false, message);
		return this;
	}

	public AjaxResult<M,D> failure(String message,D data) {
		this.meta = new Meta(false, message);
		this.data = data;
		return this;
	}
	
	@Getter
	@ToString
	public class Meta<M1 extends M> {
		@ApiModelProperty(value="成功标志,true 表示成功 false表示失败")
		private boolean success;
		@ApiModelProperty(value="消息，表示相应的消息类型，成功、失败等。")
		private M1 message;
		public Meta(){}

		public Meta(boolean success) {
			this.success = success;
		}

		public Meta(boolean success, M1 message) {
			this.success = success;
			this.message = message;
		}
	}

}
