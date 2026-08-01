package net.uclas.uclascities.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.uclas.uclascities.UclasCityMod;

public class ModBlocks {
    public static final Block FOOTPATH = registerBlock("footpath",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE)));
    public static final Block CRACKED_FOOTPATH = registerBlock("cracked_footpath",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(UclasCityMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block footpath) {
        return Registry.register((Registries.ITEM), new Identifier(UclasCityMod.MOD_ID, name),
                new BlockItem(footpath, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        UclasCityMod.LOGGER.info("Registering ModBlocks for " + UclasCityMod.MOD_ID);
    }
}
