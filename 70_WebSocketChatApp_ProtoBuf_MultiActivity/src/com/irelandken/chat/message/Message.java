package com.irelandken.chat.message;

/**
 * 用于WebScoket中传输数据,并用于ProtoBuf编码的消息
 * PS: 属性值为null时, 且.proto里定义为optional时, 此属性值将不会被编码
 * @author kenzfliang
 */
public class Message {
	
	/**
	 * 文本信息
	 */
	public static byte TYPE_TEXT   = 0;
	
	/**
	 * 图片
	 */
	public static byte TYPE_IMAGE  = 1;
	
	/**
	 * 语音
	 */
	public static byte TYPE_VOICE  = 2;
	
	/**
	 * 登录
	 */
	public static byte TYPE_LOGIN  = 20;
	
	/**
	 * 类型
	 */
	private byte type;
	
	/**
	 * 发信人
	 * @optional
	 */
	private String from;
	
	/**
	 * 收信人
	 * @optional
	 */
	private String to;
	
	/**
	 * 内容
	 * @optional
	 */
	private String content;

	
	public byte getType() {
		return type;
	}

	public void setType(byte type) {
		this.type = type;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
