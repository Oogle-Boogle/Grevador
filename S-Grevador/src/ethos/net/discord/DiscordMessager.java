package ethos.net.discord;

import java.awt.Color;
import java.net.URI;

import org.json.JSONObject;


public class DiscordMessager extends JSONObject { 
	
	public static boolean active = false;
	
	private static String announcementhook = "https://discordapp.com/api/webhooks/655597955830775839/fS720a9UYqJ8lvXnEXtXFWBW8ydiQWqcjOnE3yotIvxvU9j1dZB4TrbRCNtMsqO6s-QW";
	private static String newplayers = "https://discordapp.com/api/webhooks/655594963895320594/Lk_4Nz7TR7QQ_RsAzbYpVGLJCUOLgB9UrJmiq7wbKUF8RFuQYnZ5JRjoeXXxgbUdEbtK";
	private static String lootations = "https://discordapp.com/api/webhooks/655594963895320594/Lk_4Nz7TR7QQ_RsAzbYpVGLJCUOLgB9UrJmiq7wbKUF8RFuQYnZ5JRjoeXXxgbUdEbtK"; 
	private static String staffhook = "https://discordapp.com/api/webhooks/655598219505434625/G1HS1AIyCuHeE5ulFjjcT8wbOVXCk5Q7CNA2v62a1l2THYbugTcxYlFIQ3XvebK-CjRX"; 
	private static String ingamehook = "https://discordapp.com/api/webhooks/655594963895320594/Lk_4Nz7TR7QQ_RsAzbYpVGLJCUOLgB9UrJmiq7wbKUF8RFuQYnZ5JRjoeXXxgbUdEbtK";
	private static String debughook = "https://discordapp.com/api/webhooks/655598104443093033/Qi6MRFAIzHVKYeUpBFlmXJtyaNszdHfWBeeTfiCa1TWsnwF-L5D7WXchf5qepxgQpr8D";
	private static String prestige = "https://discordapp.com/api/webhooks/655594963895320594/Lk_4Nz7TR7QQ_RsAzbYpVGLJCUOLgB9UrJmiq7wbKUF8RFuQYnZ5JRjoeXXxgbUdEbtK";
	
	
	public static void sendAnnouncement(String msg) {
		try {
			
			String webhook = announcementhook;
			
			WebhookClient client = new WebhookClientBuilder()
				    .withURI(new URI(webhook))
				    .build(); // Create the webhook client
			
			new DiscordEmbed.Builder()
				    .withTitle("Tojad") // The title of the embed element
				    .withURL("http://tojad.com/") // The URL of the embed element
				    .withColor(Color.GREEN) // The color of the embed. You can leave this at null for no color
				    .withDescription("Remember, you can mute any specific channel by clicking the bell in the top right of Discord.") // The description of the embed object
				    .build();
			
			DiscordMessage message = new DiscordMessage.Builder(Misc.stripIngameFormat(msg)) // The content of the message
				    //.withEmbed(embed) // Add our embed object
				    .withUsername("Announcement Bot") // Override the username of the bot
				    .build(); // Build the message
			
			client.sendPayload(message);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void sendPrestige(String msg) {
		try {
			
			String webhook = prestige;
			
			WebhookClient client = new WebhookClientBuilder()
				    .withURI(new URI(webhook))
				    .build(); // Create the webhook client
			
			new DiscordEmbed.Builder()
				    .withTitle("Tojad") // The title of the embed element
				    .withURL("http://tojad.com/") // The URL of the embed element
				    .withColor(Color.GREEN) // The color of the embed. You can leave this at null for no color
				    .withDescription("Remember, you can mute any specific channel by clicking the bell in the top right of Discord.") // The description of the embed object
				    .build();
			
			DiscordMessage message = new DiscordMessage.Builder(Misc.stripIngameFormat(msg)) // The content of the message
				    //.withEmbed(embed) // Add our embed object
				    .withUsername("Leveling Bot") // Override the username of the bot
				    .build(); // Build the message
			
			client.sendPayload(message);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void sendLootations(String msg) {
		try {
			
			String webhook = lootations;
			
			WebhookClient client = new WebhookClientBuilder()
				    .withURI(new URI(webhook))
				    .build(); // Create the webhook client
			
			new DiscordEmbed.Builder()
				    .withTitle("Tojad") // The title of the embed element
				    .withURL("http://tojad.com/") // The URL of the embed element
				    .withColor(Color.GREEN) // The color of the embed. You can leave this at null for no color
				    .withDescription("Remember, you can mute any specific channel by clicking the bell in the top right of Discord.") // The description of the embed object
				    .build();
			
			DiscordMessage message = new DiscordMessage.Builder(Misc.stripIngameFormat(msg)) // The content of the message
				    //.withEmbed(embed) // Add our embed object
				    .withUsername("Lootations Bot") // Override the username of the bot
				    .build(); // Build the message
			
			client.sendPayload(message);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void sendNewPlayers(String msg) {
		try {
			
			String webhook = newplayers;
			
			WebhookClient client = new WebhookClientBuilder()
				    .withURI(new URI(webhook))
				    .build(); // Create the webhook client
			
			new DiscordEmbed.Builder()
				    .withTitle("Tojad") // The title of the embed element
				    .withURL("http://tojad.com/") // The URL of the embed element
				    .withColor(Color.GREEN) // The color of the embed. You can leave this at null for no color
				    .withDescription("Remember, you can mute any specific channel by clicking the bell in the top right of Discord.") // The description of the embed object
				    .build();
			
			DiscordMessage message = new DiscordMessage.Builder(Misc.stripIngameFormat(msg)) // The content of the message
				    //.withEmbed(embed) // Add our embed object
				    .withUsername("New Players Bot") // Override the username of the bot
				    .build(); // Build the message
			
			client.sendPayload(message);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void sendStaffMessage(String msg) {
		try {
			
			String webhook = staffhook;
			
			WebhookClient client = new WebhookClientBuilder()
				    .withURI(new URI(webhook))
				    .build(); // Create the webhook client
			
			new DiscordEmbed.Builder()
				    //.withTitle("Necrotic - RSPS") // The title of the embed element
				    //.withURL("http://necrotic.org/") // The URL of the embed element
				    .withColor(Color.ORANGE) // The color of the embed. You can leave this at null for no color
				    .withDescription("Remember, you can mute any specific channel by clicking the bell in the top right of Discord.") // The description of the embed object
				    .build();
			
			DiscordMessage message = new DiscordMessage.Builder(Misc.stripIngameFormat(msg)) // The content of the message
				    //.withEmbed(embed) // Add our embed object
				    .withUsername("Staff Bot") // Override the username of the bot
				    .build(); // Build the message
			
			client.sendPayload(message);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void sendInGameMessage(String msg) {
		try {
			
			
			String webhook = ingamehook;
			
			WebhookClient client = new WebhookClientBuilder()
				    .withURI(new URI(webhook))
				    .build(); // Create the webhook client
			
			new DiscordEmbed.Builder()
				    //.withTitle("Necrotic - RSPS") // The title of the embed element
				    //.withURL("http://necrotic.org/") // The URL of the embed element
				    .withColor(Color.BLUE) // The color of the embed. You can leave this at null for no color
				    .withDescription("Remember, you can mute any specific channel by clicking the bell in the top right of Discord.") // The description of the embed object
				    .build();
			
			String msgToSend = Misc.stripIngameFormat(msg);
			
			DiscordMessage message = new DiscordMessage.Builder(msgToSend) // The content of the message
				    //.withEmbed(embed) // Add our embed object
				    .withUsername("In-Game Bot") // Override the username of the bot
				    .build(); // Build the message
			
			if (msgToSend.equalsIgnoreCase(":information_source:!")) {
				sendDebugMessage("Bad message from sendInGameMessage, \n"+msgToSend);
			} else {
				client.sendPayload(message);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void sendDebugMessage(String msg) {
		try {
			
			String webhook = debughook;
			
			WebhookClient client = new WebhookClientBuilder()
				    .withURI(new URI(webhook))
				    .build(); // Create the webhook client
			
			new DiscordEmbed.Builder()
				    .withTitle("Tojad") // The title of the embed element
				    .withURL("http://tojad.com/") // The URL of the embed element
				    .withColor(Color.MAGENTA) // The color of the embed. You can leave this at null for no color
				    .withDescription("Remember, you can mute any specific channel by clicking the bell in the top right of Discord.") // The description of the embed object
				    .build();
			
			//DiscordMessage message = new DiscordMessage.Builder(msg) 
			DiscordMessage message = new DiscordMessage.Builder(Misc.stripIngameFormat(msg)) // The content of the message
				    //.withEmbed(embed) // Add our embed object
				    .withUsername("Debug Bot") // Override the username of the bot
				    .build(); // Build the message
			
			client.sendPayload(message);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
