package commands;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.utils.PermissionUtil;

public class HelpCommand implements Command {
	
	private final String HELP = "/help";
	
	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {return true;}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		
		if(event.getAuthor().equals(event.getJDA().getSelfUser())) {
			return;
		}	
		
		long UserMessage = event.getMessage().getIdLong();
		event.getTextChannel().deleteMessageById(UserMessage).complete();
		
		if(!PermissionUtil.checkPermission(event.getMember(), Permission.MANAGE_ROLES)) {
			event.getTextChannel().sendMessage("/udead, /whoareyou, /pub").queue();
			return;
		}
		event.getTextChannel().sendMessage("/udead, /whoareyou, /pub, /startparty, /closeparty, /setgame + Yourgame, /count").queue();
		event.getGuild().getTextChannels();
		
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
