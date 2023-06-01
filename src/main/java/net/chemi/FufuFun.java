package net.chemi;

import net.chemi.blocks.CassavaCropBlock;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.CropBlock;
import net.minecraft.block.Material;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FufuFun implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("fufu-fun");

	public static final CropBlock CASSAVA_CROP_BLOCK = new CassavaCropBlock(AbstractBlock.Settings.of(Material.PLANT).nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP));

	public static final Item CASSAVA_STEM = new AliasedBlockItem(CASSAVA_CROP_BLOCK, new Item.Settings());

	public static final Item RAW_CASSAVA = Registry.register(Registries.ITEM, new Identifier("fufu-fun", "raw_cassava"), new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.2f).build())));
	public static final Item FUFU = Registry.register(Registries.ITEM, new Identifier("fufu-fun", "fufu"), new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(10).saturationModifier(12.8f).build())));

	@Override
	public void onInitialize() {
		Registry.register(Registries.BLOCK, new Identifier("fufu-fun","cassava_crop_block"), CASSAVA_CROP_BLOCK);
		Registry.register(Registries.ITEM, new Identifier("fufu-fun","cassava_stem"), CASSAVA_STEM);

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> entries.add(CASSAVA_STEM));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> entries.add(RAW_CASSAVA));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> entries.add(FUFU));
	}
}
