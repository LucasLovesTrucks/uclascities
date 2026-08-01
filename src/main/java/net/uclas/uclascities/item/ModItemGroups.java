package net.uclas.uclascities.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.uclas.uclascities.UclasCityMod;
import net.uclas.uclascities.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup CITY_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(UclasCityMod.MOD_ID, "city"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.city"))
                    .icon(() -> new ItemStack(ModItems.LOGO)).entries((displayContext, entries) -> {
                        entries.add(ModItems.LOGO);

                        entries.add(ModBlocks.FOOTPATH);
                        entries.add(ModBlocks.CRACKED_FOOTPATH);
                        entries.add(ModBlocks.GANTRY_CENTRE);
                        entries.add(ModBlocks.GANTRY_TOP);
                        entries.add(ModBlocks.GANTRY_VERTICAL);
                        entries.add(ModBlocks.GANTRY_HORIZONTAL_END);


                    }).build());


    public static void registerItemGroups() {
        UclasCityMod.LOGGER.info("Registering Item Groups for " + UclasCityMod.MOD_ID );
    }
}
