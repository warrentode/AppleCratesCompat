package com.github.warrentode.applecrates_compat;

import jackdaw.applecrates.api.AppleCrateAPI;
import jackdaw.applecrates.api.GeneralRegistry;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod(AppleCrates_Compat.MODID)
public class AppleCrates_Compat {
    public static final String MODID = "applecrates_compat";
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MODID);

    public AppleCrates_Compat() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);

        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        BLOCK_ENTITY_TYPES.register(modEventBus);

        String minecraft = "minecraft";
        String[] VANILLA_WOOD = new String[]{"mangrove"};

        String tconstruct = "tconstruct";
        String[] SLIME_WOOD = new String[] {
                "greenheart", "bloodshroom", "enderbark"
        };
        String[] TC_SKYROOT = new String[] {
                "skyroot"
        };

        String biomesoplenty = "biomesoplenty";
        String[] BIOMESOPLENTY_WOOD = new String[]{
                "cherry", "dead", "fir", "hellbark", "jacaranda", "magic", "mahogany", "palm", "redwood", "umbran", "willow"
        };

        String ecologics = "ecologics";
        String[] ECOLOGICS_WOOD = new String[]{
                "coconut", "walnut", "azalea", "flowering_azalea"
        };

        String phantasm = "phantasm";
        String[] PHANTASM_WOOD = new String[]{
                "pream", "ebony"
        };

        String unusualend = "unusualend";
        String[] UNUSUAL_WOOD = new String[]{
                "chorus_nest"
        };

        String domum_ornamentum = "domum_ornamentum";
        String[] CACTUS_WOOD = new String[]{
                "cactus_extra", "green_cactus_extra"
        };

        String tofucraft = "tofucraft";
        String[] TOFU_STEM = new String[]{
                "tofustem_planks"
        };

        String aether = "aether";
        String[] AETHER = new String[]{"skyroot"};

        for (String wood : VANILLA_WOOD) {
            new AppleCrateAPI.AppleCrateBuilder(minecraft, MODID, wood).register();
        }

        if (ModList.get().isLoaded("biomesoplenty")) {
            for (String wood : BIOMESOPLENTY_WOOD) {
                new AppleCrateAPI.AppleCrateBuilder(biomesoplenty, MODID, wood).register();
            }
        }
        if (ModList.get().isLoaded("ecologics")) {
            for (String wood : ECOLOGICS_WOOD) {
                new AppleCrateAPI.AppleCrateBuilder(ecologics, MODID, wood).register();
            }
        }
        if (ModList.get().isLoaded("phantasm")) {
            for (String wood : PHANTASM_WOOD) {
                new AppleCrateAPI.AppleCrateBuilder(phantasm, MODID, wood).withParentFolder("blocks/").register();
            }
        }
        if (ModList.get().isLoaded("unusualend")) {
            for (String wood : UNUSUAL_WOOD) {
                new AppleCrateAPI.AppleCrateBuilder(unusualend, MODID, wood).withParentFolder("blocks/").register();
            }
        }
        if (ModList.get().isLoaded("domum_ornamentum")) {
            for (String wood : CACTUS_WOOD) {
                new AppleCrateAPI.AppleCrateBuilder(domum_ornamentum, MODID, wood).withParentFolder("block/extra/").withSuffix("").register();
            }
        }
        if (ModList.get().isLoaded("tofucraft")) {
            for (String wood : TOFU_STEM) {
                new AppleCrateAPI.AppleCrateBuilder(tofucraft, MODID, wood).withSuffix("").register();
            }
        }
        if (ModList.get().isLoaded("aether")) {
            for (String wood : AETHER) {
                new AppleCrateAPI.AppleCrateBuilder(aether, MODID, wood)
                        .withParentFolder("block/construction/").register();
            }
        }
        if (ModList.get().isLoaded("tconstruct")) {
            for (String wood : SLIME_WOOD) {
                new AppleCrateAPI.AppleCrateBuilder(tconstruct, MODID, wood)
                        .withParentFolder("block/wood/")
                        .withTextureName(wood + "/planks")
                        .withSuffix("").register();
            }
            for (String wood : TC_SKYROOT) {
                new AppleCrateAPI.AppleCrateBuilder(tconstruct, MODID, "tc_skyroot")
                        .withBlock("skyroot_planks")
                        .withParentFolder("block/wood/")
                        .withTextureName("skyroot/planks")
                        .withSuffix("").register();
            }
        }

        GeneralRegistry.prepareForRegistry(MODID, BLOCKS, ITEMS, BLOCK_ENTITY_TYPES);
    }
}