package com.irelandken.chat.websocket;

import java.net.URI;
import java.nio.ByteBuffer;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.handshake.ServerHandshake;

import com.irelandken.chat.ApplicationContext;
import com.irelandken.chat.message.Message;
import com.irelandken.chat.message.MessageProtoConverter;

/**
 * @see http://java-websocket.org/ 
 * @author kenzfliang
 */

public class SimpleWebSocketClient extends WebSocketClient {

	public SimpleWebSocketClient(URI serverUri, Draft draft) {
		super(serverUri, draft);
	}

	@Override
	public void onOpen( ServerHandshake handshakedata ) {
		System.out.println( "opened connection" );
		// if you pan to refuse connection based on ip or httpfields overload: onWebsocketHandshakeReceivedAsClient
	}

	@Override
	public void onMessage( String content ) {
		System.out.println( "received : " + content );
	}
	
	/**
	 * ProtoBuf编码的消息
	 */
	@Override
	public void onMessage( ByteBuffer buffer ) {
		System.out.println( "ByteBuffer received : " + buffer );
		
		//解释ProtoBuf
		byte[] data = buffer.hasArray() ? buffer.array() : toArray(buffer);
		Message message = MessageProtoConverter.parseFrom(data);
		
		//分发消息给不同的Activity
		ApplicationContext.dispatchMessage(message);
	};

	@Override
	public void onClose( int code, String reason, boolean remote ) {
		// The codecodes are documented in class org.java_websocket.framing.CloseFrame
		System.out.println( "Connection closed by " + ( remote ? "remote peer" : "us" ) );
	}

	@Override
	public void onError( Exception ex ) {
		ex.printStackTrace();
		// if the error is fatal then onClose will be called additionally
	}
	
	/**
	 * Util Method, Convert ByteBuffer to byte[]
	 * @param buffer
	 * @return
	 */
	private static byte[] toArray(ByteBuffer buffer) {
		
		byte[] data = new byte[buffer.capacity()];
		
		int i = 0;
		while(buffer.hasRemaining()) {
			data[i++] = buffer.get();
		}
		return data;
	}
}
