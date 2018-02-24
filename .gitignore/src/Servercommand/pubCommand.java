package Servercommand;

import java.util.List;

import commands.Command;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.Role;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class pubCommand implements Command {
	
	private final String HELP = "/pub";
	
	
	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		return true;
	}
	
	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		long Nbjoueur =  event.getGuild().getMemberCache().size();
		List<Role> Bot = event.getGuild().getRolesByName("BOT", true);
		long NbBot = event.getGuild().getMembersWithRoles(Bot).size();
		long NBBefore = 200;
		long UserMessage = event.getMessage().getIdLong();
		event.getTextChannel().deleteMessageById(UserMessage).complete();
		
		if(event.getAuthor().equals(event.getJDA().getSelfUser())) {
			return;
		}	
		event.getTextChannel().sendMessage("╔═══════════════════╗\r\n" + 
				"        :crown: UDeaD Community :crown:\r\n" + 
				"╚═══════════════════╝\r\n" + 
				"https://discord.gg/v36Hwsd\r\n" + 
				"\r\n" + 
				"Serveur Discord avec une communautée active avec plus de __``" + (Nbjoueur- NbBot) + "``__`` MEMBRES" + "`` ainsi qu'un staff très réactif! Bienvenue à tous !!\r\n" + 
				"\r\n" + 
				":white_check_mark: Langues : Française et Anglaise\r\n" + 
				":white_check_mark: Avec salons Multi-Gaming\r\n" + 
				":white_check_mark: Des salons Pub !:small_blue_diamond: \r\n" + 
				":white_check_mark: Une communautée en pleine expension " + "(``+ ``__``" + "15" + "``__`` membres par jours!``)\r\n" + 
				":white_check_mark: Un serveur en amélioration constante !\r\n" + 
				":white_check_mark: __``" + (NBBefore - (Nbjoueur- NbBot)) + "``__ personnes avant d'atteindre " + NBBefore + " membres !!!" +
				"\r\n" +
				"\r\n" +
				"Lien : https://discord.gg/v36Hwsd").queue();
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
