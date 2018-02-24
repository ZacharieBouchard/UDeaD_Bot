package commands;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * Created by Zacha on 2017-01-21.
 */
public interface Command {
    
	public boolean called(String[] args, MessageReceivedEvent event);
    public void action (String[] args, MessageReceivedEvent event);
    public String help();
    public void executed(boolean success, MessageReceivedEvent event);
    public boolean send(String[] args, MessageReceivedEvent event);
    public void deleteMessage(Message message, String reason, MessageReceivedEvent event);


}