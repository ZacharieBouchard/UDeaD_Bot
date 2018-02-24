package Bot_Discord;

import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;


/**
 * Created by Zacha on 2017-01-21.
 */
public class BotListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        if(event.getMessage().getContentDisplay().startsWith("/") && event.getMessage().getAuthor().getId() != event.getJDA().getSelfUser().getId()) Main.handleCommand(Main.parser.parse(event.getMessage().getContentDisplay().toLowerCase(), event));

    }

        @Override
        public void onReady(ReadyEvent event){
        	System.out.println("Status Logged in as: " + event.getJDA().getSelfUser().getName() );

        }

}