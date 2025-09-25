package com.github.warrentode.applecrates_compat;

import jackdaw.applecrates.api.CrateWoodType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static com.github.warrentode.applecrates_compat.AppleCrates_Compat.MODID;

public class CreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    @SuppressWarnings({"unused", "OptionalGetWithoutIsPresent"})
    public static final RegistryObject<CreativeModeTab> TBA_TAB =
            registerTab("tba_tab", () ->
                    CreativeModeTab.builder()
                            .title(Component.translatable("itemGroup.applecratescompat_tab"))
                            .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                            .icon(() -> new ItemStack(
                                    CrateWoodType.getBlock(CrateWoodType.values()
                                            .filter((crateWoodType) -> crateWoodType.name().equals("cherry"))
                                            .findFirst().get()))
                            )
                            .displayItems((parameters, output) ->
                                    AppleCrates_Compat.ITEMS.getEntries().stream()
                                    .map(RegistryObject::get)
                                    .filter(item -> {
                                        ResourceLocation location = ForgeRegistries.ITEMS.getKey(item);
                                        return location != null;
                                    })
                                    .forEach(output::accept))
                            .build()
            );

    @SuppressWarnings("SameParameterValue")
    private static RegistryObject<CreativeModeTab> registerTab(String name, Supplier<CreativeModeTab> supplier) {
        return CREATIVE_TABS.register(name, supplier);
    }
}