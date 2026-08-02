package net.uclas.uclascities.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.PillarBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.uclas.uclascities.UclasCityMod;

import static net.minecraft.block.Blocks.register;

public class ModBlocks {
    public static final Block FOOTPATH = registerBlock("footpath",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE)));
    public static final Block CRACKED_FOOTPATH = registerBlock("cracked_footpath",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE)));
    public static final Block GANTRY_CENTRE = registerBlock("gantry_centre",
            new GantryCentreBlock(FabricBlockSettings.copyOf(Blocks.STONE).nonOpaque()));
    public static final Block GANTRY_TOP = registerBlock("gantry_top",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE).nonOpaque()));
    public static final Block GANTRY_VERTICAL = registerBlock("gantry_vertical",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE).nonOpaque()));
    public static final Block GANTRY_HORIZONTAL_END = registerBlock("gantry_horizontal_end",
            new GantryCentreBlock(FabricBlockSettings.copyOf(Blocks.STONE).nonOpaque()));
    public static final Block BOLLARD = registerBlock("bollard",
            new BollardBlock(FabricBlockSettings.copyOf(Blocks.STONE)));
    public static final Block ROAD_SIGN_POLE = registerBlock("road_sign_pole",
            new RoadSignPoleBlock(FabricBlockSettings.copyOf(Blocks.STONE)));
    public static final Block SCHOOL_ZONE_SIGN = registerBlock("school_zone_sign",
            new SchoolZoneSignBlock(FabricBlockSettings.copyOf(Blocks.STONE)));

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
