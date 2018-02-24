package Servercommand;

import commands.Command;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.utils.PermissionUtil;

public class ChangeGameCommand implements Command {
	
	private String prefix = "/setgame" ;
	
	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {return true;}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		
		String GAMENAME = event.getMessage().getContentDisplay().toString();
		String GAMENAMEFINAL = GAMENAME.replace(prefix, ".");
		
		long UserMessage = event.getMessage().getIdLong();
		event.getTextChannel().deleteMessageById(UserMessage).complete();
		
		if(event.getAuthor().equals(event.getJDA().getSelfUser())) {
			return;
		}
		if(!PermissionUtil.checkPermission(event.getMember(), Permission.MANAGE_ROLES)) {
			event.getTextChannel().sendMessage("Nan tu peux pas").complete();
			return;
		}
		if(event.getMessage().getContentDisplay().endsWith(GAMENAME)){
			Game BOT = Game.playing(GAMENAMEFINAL);
    		event.getJDA().getPresence().setGame(BOT);
		}else{
		event.getTextChannel().sendMessage("/setgame + Nom du jeux").queue();
		}
	}

    @Override
    public String help() {return prefix;}
    @Override
    public void executed(boolean success, MessageReceivedEvent event) {return;}
    @Override
    public boolean send(String[] args, MessageReceivedEvent event) {return false;}
    @Override
    public void deleteMessage(Message message, String reason, MessageReceivedEvent event) {}
}
