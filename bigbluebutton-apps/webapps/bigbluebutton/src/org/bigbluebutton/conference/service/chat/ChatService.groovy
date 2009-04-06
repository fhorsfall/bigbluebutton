package org.bigbluebutton.conference.service.chat

public class ChatService {
	
	protected static Logger log = LoggerFactory.getLogger( ChatService.class );
	
	private ChatApplication application

	public String getChatMessages() {
		String roomName = Red5.connectionLocal.scope.name
		return application.getChatMessages(roomName)
	}
	
	public void sendMessage(String message) {
		String roomName = Red5.connectionLocal.scope.name
		application.sendMessage(roomName, message)
	}
	public void setChatApplication(ChatApplication a) {
		log.debug("Setting Chat Applications")
		application = a
	}
}