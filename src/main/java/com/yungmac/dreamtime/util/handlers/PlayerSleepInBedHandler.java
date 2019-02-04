package com.yungmac.dreamtime.util.handlers;

import net.minecraft.entity.player.EntityPlayer;
//import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class PlayerSleepInBedHandler {
//    @SubscribeEvent
//    public static void onPlayerSleepInBed(PlayerSleepInBedEvent event) {
//
//    }

    @SubscribeEvent
    public static void onPlayerWakeUp(PlayerWakeUpEvent event) {
        EntityPlayer player = event.getEntityPlayer();

        // Only the server should perform the teleportation
        if (player.world.isRemote) return;

        // Wait for the next tick before attempting to teleport?
        System.out.println("We would teleport player rn.");
        EntityPlayerMP playerMP = (EntityPlayerMP) player;
        System.out.println("Before: " + playerMP.getPosition());
        playerMP.setPositionAndUpdate(playerMP.posX + 25, playerMP.posY + 10, playerMP.posZ + 25);
        System.out.println("After: " + playerMP.getPosition());
    }
}
