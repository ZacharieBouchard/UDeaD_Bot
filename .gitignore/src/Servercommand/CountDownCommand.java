package Servercommand;

import java.util.List;

import commands.Command;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.Role;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.utils.PermissionUtil;

public class CountDownCommand implements Command {
	
	private final String prefix = "/count";
	
	
	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		return true;
	}
	
	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		long Nbjoueur =  event.getGuild().getMemberCache().size();
		List<Role> Bot = event.getGuild().getRolesByName("BOT", true);
		List<Role> Every = event.getGuild().getRolesByName("everyone", true);
		long NbBot = event.getGuild().getMembersWithRoles(Bot).size();
		
		long UserMessage = event.getMessage().getIdLong();
		event.getTextChannel().deleteMessageById(UserMessage).complete();
		
		String HELPdis = event.getMessage().getContentDisplay().toString();
		String NBBeforeFINAL = HELPdis.replace(prefix, "");
		long NBBefore = 200;
		
		if(event.getAuthor().equals(event.getJDA().getSelfUser())) {
			return;
		}
		
		if(!PermissionUtil.checkPermission(event.getMember(), Permission.MANAGE_ROLES)) {
			event.getTextChannel().sendMessage("Nan tu peux pas").complete();
			return;
		}else {
			if(event.getMessage().getContentDisplay().endsWith(HELPdis)) {
				event.getTextChannel().sendMessage("Plus que __``"+ (NBBefore - (Nbjoueur - NbBot)) + "``__ personnes pour atteindre " + NBBefore + " membres sur le serveur !!!").queue();
			}
		}
		
	}

    @Override
    public String help() {
        return prefix;
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
