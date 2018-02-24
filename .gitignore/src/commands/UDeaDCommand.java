package commands;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class UDeaDCommand implements Command {
	
	private final String HELP = "/udead";
	
	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {return true;}
	
	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		
		long UserMessage = event.getMessage().getIdLong();
		event.getTextChannel().deleteMessageById(UserMessage).complete();
		
		if(event.getAuthor().equals(event.getJDA().getSelfUser())) {return;}
		
		event.getTextChannel().sendMessage("Fondateur: @[ArMaGeDoNx] et @[GaMeOnZ] pourquoi ne pas leurs dire un merci pour la communauté qu'ils ont créé "+ event.getAuthor().getAsMention()).queue();
		
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
