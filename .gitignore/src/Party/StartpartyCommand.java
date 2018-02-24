package Party;

import Bot_Discord.Main;
import commands.Command;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.utils.PermissionUtil;

public class StartpartyCommand implements Command {
	
	private final String HELP = "/startparty";
	private static String Emojie1 = "✅";
	public boolean Checkon = false;
	
	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		
		return true;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		
		/*if(event.getAuthor().equals(event.getJDA().getSelfUser())) {
			return;
		}*/
		
		if(!PermissionUtil.checkPermission(event.getMember(), Permission.MANAGE_ROLES)) {
			event.getTextChannel().sendMessage("Nan tu peux pas").complete();
			return;
		}
		long UserMessage = event.getMessage().getIdLong();
		event.getTextChannel().deleteMessageById(UserMessage).complete();
		event.getTextChannel().sendMessage("Êtes vous prêt??").complete().addReaction(Emojie1).complete();
		
		Main.isOn = true;
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
