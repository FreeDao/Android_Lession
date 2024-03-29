import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_17;
import org.java_websocket.handshake.ServerHandshake;

/** 
 * This example demonstrates how to create a websocket connection to a server. 
 * 
 * Only the most important callbacks are overloaded.
 *  
 */
class ExampleClient extends WebSocketClient {

	public ExampleClient( URI serverUri , Draft draft ) {
		super( serverUri, draft );
	}

	public ExampleClient( URI serverURI ) {
		super( serverURI );
	}

	@Override
	public void onOpen( ServerHandshake handshakedata ) {
		System.out.println( "opened connection" );
		// if you pan to refuse connection based on ip or httpfields overload: onWebsocketHandshakeReceivedAsClient
	}

	@Override
	public void onMessage( String message ) {
		System.out.println( "received : " + message );
		
		String msg = "Hello " + Math.random();
		
		send( msg );
		System.out.println( "send : " + msg );
	}
	
	@Override
	public void onMessage( ByteBuffer bytes ) {
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
}

public class WebSocketClientTest {

	public static void main( String[] args ) throws URISyntaxException, InterruptedException {
		ExampleClient c = new ExampleClient( new URI( "ws://10.66.117.59/" ), new Draft_17() ); // more about drafts here: http://github.com/TooTallNate/Java-WebSocket/wiki/Drafts
		c.connect();
		
		c.send( "Come in" );
		
		Thread.currentThread().sleep(1000000000);
	}
}