package com.irelandken.chat.message;

public class MessageProtoConverterTest {
	
	public static void main(String[] args) {
		
		Message message = new Message();
		message.setType(Message.TYPE_TEXT);
		message.setFrom("jack");
		message.setTo("tom");
		message.setContent("hello");
		
		byte[] byte_array = MessageProtoConverter.toByteArray(message);
		       byte_array = MessageProtoConverter.toByteArray(message);
		
		Message message2 = MessageProtoConverter.parseFrom(byte_array);
		
	}

}
