package Party;

import Bot_Discord.Main;
import commands.Command;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.utils.PermissionUtil;

public class StatuspartyCommand implements Command {
	
	private final String HELP = "/statparty";
	private static String Emojie1 = "✅";
	private static String Emojie2 = "❌";
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
		
		if(Main.isOn) {
			event.getTextChannel().sendMessage("Ouvert").complete().addReaction(Emojie1);
		}else if (!Main.isOn) {
			event.getTextChannel().sendMessage("Fermer").complete().addReaction(Emojie2);
		}
		
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
