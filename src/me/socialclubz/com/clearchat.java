package me.socialclubz.com;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.event.Listener;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.plugin.PluginManager;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.MainLogger;
import java.io.File;
import java.util.LinkedHashMap;

public class clearchat
        extends PluginBase
        implements Listener
{
    public void onEnable()
    {
        getServer().getPluginManager().registerEvents(this, this);
        getDataFolder().mkdir();

        Config config = new Config(new File(
                getDataFolder(), "config.yml"), 2, new LinkedHashMap() {});
        config.save();
        getServer().getLogger().info("-----------------------");
        getServer().getLogger().info("|      Enabled!       |");
        getServer().getLogger().info("|   Social-ClearChat  |");
        getServer().getLogger().info("|         by          |");
        getServer().getLogger().info("|     SocialClubz     |");
        getServer().getLogger().info("-----------------------");
    }

    public void onDisable()
    {
        getServer().getLogger().info("-----------------------");
        getServer().getLogger().info("|      Disabled!      |");
        getServer().getLogger().info("|   Social-ClearChat  |");
        getServer().getLogger().info("|         by          |");
        getServer().getLogger().info("|     SocialClubz     |");
        getServer().getLogger().info("-----------------------");
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        Player player = null;
        if ((sender instanceof Player)) {
            player = (Player)sender;
        }
        if (cmd.getName().equalsIgnoreCase("scc"))
        {
            if (player == null)
            {
                sender.sendMessage("You have to be a Player");
                return true;
            }
            if (player != null)
            {
                if (player.hasPermission("social.scc"))
                {
                    for (int i = 0; i < 121; i++) {
                        Server.getInstance().broadcastMessage("");
                    }
                }
                Server.getInstance().broadcastMessage("Global Chat Cleared");
                return true;
            }
        }
        if (cmd.getName().equalsIgnoreCase("cc"))
        {
            if (player == null)
            {
                sender.sendMessage("You have to be a Player");
                return true;
            }
            if (player != null)
            {
                if (player.hasPermission("social.cc"))
                {
                    for (int i = 0; i < 121; i++) {
                        sender.sendMessage("");
                    }
                }
                sender.sendMessage("You Cleared Your Chat");
                return true;
            }
        }
        return false;
    }
}
