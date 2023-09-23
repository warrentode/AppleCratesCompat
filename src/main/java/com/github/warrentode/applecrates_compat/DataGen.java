package com.github.warrentode.applecrates_compat;

import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.github.warrentode.applecrates_compat.AppleCrates_Compat.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGen {

    @SubscribeEvent
    public static void gen(GatherDataEvent event) {
        DataGenerators.generatedCrates(MODID, event);
    }
}