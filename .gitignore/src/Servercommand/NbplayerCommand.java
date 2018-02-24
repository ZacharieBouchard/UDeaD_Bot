package Servercommand;

import java.util.List;

import commands.Command;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.utils.PermissionUtil;

public class NbplayerCommand implements Command {
	
	private final String HELP = "/mem";
	
	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		return true;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		
		long Nbjoueur =  event.getGuild().getMemberCache().size();
		List<Role> Bot = event.getGuild().getRolesByName("BOT", true);
		long NbBot = event.getGuild().getMembersWithRoles(Bot).size();
		if(event.getAuthor().equals(event.getJDA().getSelfUser())) {
			return;
		}	
		long UserMessage = event.getMessage().getIdLong();
		event.getTextChannel().deleteMessageById(UserMessage).complete();
		
		if(!PermissionUtil.checkPermission(event.getMember(), Permission.MANAGE_ROLES)) {
			event.getTextChannel().sendMessage("Nan tu peux pas").complete();
			return;
		}else {
			
			event.getTextChannel().sendMessage("Vous êtes __``" + (Nbjoueur - NbBot) + "``__ membres dans la UDeaD Community. Merci à vous tous!" ).complete();
			
		}
		
	}

    @Override
    public String help() {
        return HELP;
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {return;}

    @Override
    public boolean send(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void deleteMessage(Message message, String reason, MessageReceivedEvent event) {

    }


}
