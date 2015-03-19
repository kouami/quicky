/**
 * 
 */
package org.quicky.websocket;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * @author u329022
 *
 */
public class TextHandler extends TextWebSocketHandler {
	
	protected void handleBinaryMessage(WebSocketSession session, TextMessage message) {
		
	}
}
