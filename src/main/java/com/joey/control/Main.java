package com.joey.control;

import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.CommandPermission;
import dev.jorel.commandapi.arguments.*;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

import static com.joey.control.Control.controlMap;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        System.out.println(this.getName() + " is activated");

        getServer().getPluginManager().registerEvents(new ControlEvent(), this);

        List<Argument> arguments = new ArrayList<>();
        arguments.add(new StringArgument("type").overrideSuggestions(controlMap.keySet()));
        arguments.add(new BooleanArgument("value"));

        new CommandAPICommand("control")
                .withAliases("ctrl")
                .withArguments(arguments)
                .withPermission(CommandPermission.OP)
                .executesPlayer((player, args) -> {
                    String types = (String) args[0];
                    boolean value = (boolean) args[1];

                    controlMap.replace(types, value);

                    player.sendMessage("Set [" + types + "] to [" + ChatColor.GREEN + value + ChatColor.WHITE + "]");
                }).register();
    }

    @Override
    public void onDisable() {
        System.out.println(this.getName() + " is deactivated");
    }
}
