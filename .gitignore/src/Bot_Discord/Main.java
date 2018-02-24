package Bot_Discord;

import java.util.HashMap;

import javax.security.auth.login.LoginException;

import Party.ClosePartyCommand;
import Party.ReadyPartyCommand;
import Party.StartpartyCommand;
import Party.StatuspartyCommand;
import Servercommand.ChangeGameCommand;
import Servercommand.CountDownCommand;
import Servercommand.NbplayerCommand;
import Servercommand.pubCommand;
import commands.Command;
import commands.HelpCommand;
import commands.PingCommand;
import commands.UDeaDCommand;
import commands.quituestCommand2;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import utils.CommandParser;

public class Main {
    public static JDA jda;
    public static HashMap<String, Command> commands = new HashMap<String, Command>();
    public static final CommandParser parser = new CommandParser();
    private static BotSettings botSettings;
    public static boolean isOn = false;
    public static int count = 0;
	public static void main(String[] args) {
		botSettings = new BotSettings();
		try {
			jda = new JDABuilder(AccountType.BOT).setToken(botSettings.getToken()).buildBlocking();
			jda.setAutoReconnect(true);
			jda.addEventListener(new BotListener());
			jda.addEventListener(new Botlistener2());
			System.out.println("Bot UDeaD: ON and connected");
		} catch (Exception e) {
			e.printStackTrace();
		}
		commands.put("help", new HelpCommand());
		commands.put("ping", new PingCommand());
		
		commands.put("setgame", new ChangeGameCommand());
		commands.put("mem", new NbplayerCommand());
		commands.put("pub", new pubCommand());
		commands.put("count", new CountDownCommand());
		
		commands.put("whoareyou", new quituestCommand2());
		commands.put("udead", new UDeaDCommand());
		
		commands.put("statparty", new StatuspartyCommand());
		commands.put("startparty", new StartpartyCommand());
		commands.put("closeparty", new ClosePartyCommand());
		commands.put("partyready", new ReadyPartyCommand());
		
	}
	
    public static void handleCommand(CommandParser.CommandContainer cmd){
        if(commands.containsKey(cmd.invoke)){
            boolean safe = commands.get(cmd.invoke).called(cmd.args, cmd.event);

            if(safe){
                commands.get(cmd.invoke).action(cmd.args, cmd.event);
                commands.get(cmd.invoke).executed(safe, cmd.event);
            }else {
                commands.get(cmd.invoke).executed(safe, cmd.event);

            }
        }

    }

}
