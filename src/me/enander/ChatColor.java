package me.enander;

import me.enander.commands.AdminChatColorCommand;
import me.enander.commands.ChatColorCommand;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.cause.NamedCause;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.event.game.state.GamePreInitializationEvent;
import org.spongepowered.api.event.game.state.GameStoppingEvent;
import org.spongepowered.api.event.message.MessageChannelEvent;
import org.spongepowered.api.event.network.ClientConnectionEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.Text;

import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

@Plugin(id = "chatcolor", name = "Chat Color", version = "1.0")
public class ChatColor {

    public HashMap<UUID, String> colors = new HashMap<>();

    public static ChatColor instance;
    private CommandSpec chatColorCommand = CommandSpec.builder()
            .permission("pscolor.gui")
            .description(Text.of("Opens a GUI to choose chat color"))
            .executor(new ChatColorCommand())
            .build();

    private CommandSpec adminChatColorCommand = CommandSpec.builder()
            .executor(new AdminChatColorCommand())
            .description(Text.of("Changes any players chat color"))
            .permission("pscolor.coloradmin")
            .arguments(GenericArguments.player(Text.of("player")), GenericArguments.string(Text.of("color"))).build();

    @Listener
    public void preInit(GamePreInitializationEvent event) {
        instance = this;
    }

    @Listener
    public void init(GameInitializationEvent event) {
        Sponge.getCommandManager().register(this, chatColorCommand, "color", "colour");
        Sponge.getCommandManager().register(this, adminChatColorCommand, "coloradmin", "colouradmin");
    }

    @Listener
    public void onDisable(GameStoppingEvent event) {

    }

    @Listener
    public void onJoin(ClientConnectionEvent.Join event, @org.spongepowered.api.event.filter.Getter("getTargetEntity") Player player) {
        if (!colors.containsKey(player.getUniqueId())) {
            colors.put(player.getUniqueId(), "§r");
        }
    }

    @Listener
    public void onChat(MessageChannelEvent event) {
        Optional<Player> player = event.getCause().first(Player.class);
        if (!player.isPresent()) {
            return;
        }

        String msg = colors.get(player.get().getUniqueId()) + event.getFormatter().getBody().format().toPlain();
        event.getFormatter().setBody(Text.of(msg));
    }
}
