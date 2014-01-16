package com.irelandken.chat.message;

import com.google.protobuf.InvalidProtocolBufferException;


/**
 *  Message ProtoBuf Converter
 *  
 *  @see https://developers.google.com/protocol-buffers/docs/javatutorial
 *  
 * @author kenzfliang
 */

public class MessageProtoConverter {
	
	private static MessageProtos.Message.Builder builder = MessageProtos.Message.newBuilder();
	
	/**
	 * Serialize message to byte array
	 * @param message
	 * @return
	 */
	public static byte[] toByteArray(Message message) {
		//Serialize----------------------------------------------
		builder.clear();
		
		builder.setType(message.getType());
		builder.setFrom(message.getFrom());
		builder.setTo(message.getTo());
		builder.setContent(message.getContent());
		
		MessageProtos.Message pb_message = builder.build();
		
		byte[] byte_array = pb_message.toByteArray();
		return byte_array;
	}
	
	/**
	 * Parse byte array to message
	 * @param data
	 * @return success : return Message
	 *         fail    : return null
	 */
	public static Message parseFrom(byte[] data) {
		//Parse---------------------------------------------------
		
		MessageProtos.Message pb_message = null;
		
		try {
			pb_message = MessageProtos.Message.parseFrom(data);
		} catch (InvalidProtocolBufferException e) {
			e.printStackTrace();
			return null;
		}
		
		Message message = new Message();
		message.setType((byte)pb_message.getType());
		message.setFrom(pb_message.getFrom());
		message.setTo(pb_message.getTo());
		message.setContent(pb_message.getContent());
		
		return message;
	}

}
