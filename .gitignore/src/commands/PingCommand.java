package commands;

import java.util.concurrent.TimeUnit;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.utils.PermissionUtil;

public class PingCommand implements Command {
	
	private final String HELP = "/ping";
	
	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {return true;}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {
				
		long UserMessage = event.getMessage().getIdLong();
		event.getTextChannel().deleteMessageById(UserMessage).complete();
		long ping = event.getJDA().getPing();
		
		event.getTextChannel().sendMessage(ping + " ping").complete();
		
	}

    @Override
    public String help() {return HELP;}
    @Override
    public void executed(boolean success, MessageReceivedEvent event) {return;}
    @Override
    public boolean send(String[] args, MessageReceivedEvent event) {return false;}
    @Override
    public void deleteMessage(Message message, String reason, MessageReceivedEvent event) {}


}
