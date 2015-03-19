/**
 * 
 */
package org.quicky.websocket;

import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.BinaryWebSocketHandler;

/**
 * @author u329022
 *
 */
public class BinaryHandler extends BinaryWebSocketHandler {
	
	@Override
	public void handleBinaryMessage(WebSocketSession session, BinaryMessage message) {
		//
	}
}
