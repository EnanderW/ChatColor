package me.enander.commands;

import me.enander.ChatColor;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;

import java.util.Optional;

public class AdminChatColorCommand implements CommandExecutor {

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        if(src instanceof Player) {
            Player player = (Player) src;
            Optional<Player> optPlayer = args.<Player>getOne(Text.of("player"));
            if (optPlayer.isPresent()) {
                Optional<String> color = args.<String>getOne(Text.of("color"));
                if (color.isPresent()) {
                    ChatColor.instance.colors.put(optPlayer.get().getUniqueId(), color.get().replace("&", "§"));
                    player.sendMessage(Text.of("§aPlayers chat color has been set to " + color.get().replace("&", "§") + "this"));
                } else {
                    player.sendMessage(Text.of("§cYou need to specify a color"));
                }
            } else {
                player.sendMessage(Text.of("§cCould not find that player"));
            }
        }

        return CommandResult.success();
    }
}
