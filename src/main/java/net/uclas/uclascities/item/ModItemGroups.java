package net.uclas.uclascities.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.uclas.uclascities.UclasCityMod;

public class ModItemGroups {
    public static final ItemGroup CITY_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(UclasCityMod.MOD_ID, "city"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.city"))
                    .icon(() -> new ItemStack(ModItems.LOGO)).entries((displayContext, entries) -> {
                        entries.add(ModItems.LOGO);




                    }).build());


    public static void registerItemGroups() {
        UclasCityMod.LOGGER.info("Registering Item Groups for " + UclasCityMod.MOD_ID );
    }
}
