package com.joey.control;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.player.*;

import static com.joey.control.Control.controlMap;

public class ControlEvent implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        if (!controlMap.get("chat")) e.setCancelled(true);
    }

    @EventHandler
    public void onCommand(PlayerCommandSendEvent e) {
        e.getPlayer().sendMessage("Developinng...");
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        if (!controlMap.get("movement")) e.setCancelled(true);
    }

    @EventHandler
    public void onAttack(EntityDamageByEntityEvent e) {
        if (e.getDamager().getType() == EntityType.PLAYER) {
            if (!controlMap.get("attack")) e.setCancelled(true);
        }
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        if (e.getEntity().getType() == EntityType.PLAYER) {
            if (!controlMap.get("damage")) e.setCancelled(true);
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        if (!controlMap.get("interaction")) e.setCancelled(true);
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        if (!controlMap.get("breaking")) e.setCancelled(true);
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        if (!controlMap.get("placing")) e.setCancelled(true);
    }

    @EventHandler
    public void onCraft(CraftItemEvent e) {
        if (!controlMap.get("crafting")) e.setCancelled(true);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if (!controlMap.get("join-message")) e.setJoinMessage(null);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        if (!controlMap.get("quit-message")) e.setQuitMessage(null);
    }

    /*
        controlMap.put("chat", true);
        controlMap.put("command", true);
        controlMap.put("movement", true);
        controlMap.put("attack", true);
        controlMap.put("damage", true);
        controlMap.put("interaction", true);
        controlMap.put("breaking", true);
        controlMap.put("placement", true);
        controlMap.put("crafting", true);
        controlMap.put("join-message", true);
        controlMap.put("quit-message", true);
    */
}
