package Bot_Discord;

import net.dv8tion.jda.core.events.Event;
import net.dv8tion.jda.core.hooks.EventListener;

public class Botlistener2 implements EventListener {

	@Override
    public void onEvent(Event event){
   // System.out.println("Status Logged in as: " + event.getJDA().getSelfUser().getName() );
    System.out.println(event.getClass().getSimpleName());
    }

}
