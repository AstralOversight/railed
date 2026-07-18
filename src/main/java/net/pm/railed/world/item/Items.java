package net.pm.railed.world.item;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.references.BlockItemId;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.pm.railed.references.BlockItemIds;
import net.pm.railed.world.level.block.Blocks;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Items {
    public static final Item SELF_POWERED_RAIL = registerBlock(BlockItemIds.SELF_POWERED_RAIL, Blocks.SELF_POWERED_RAIL);

    private static Item registerItem(final ResourceKey<Item> id, final Function<Item.Properties, Item> itemFactory, final Item.Properties properties) {
        Item item = itemFactory.apply(properties.setId(id));
        if (item instanceof BlockItem blockItem) {
            blockItem.registerBlocks(Item.BY_BLOCK, item);
        }

        return Registry.register(BuiltInRegistries.ITEM, id, item);
    }

    private static Item registerBlock(final BlockItemId id, final Block block) {
        return registerBlock(id, block, new Item.Properties());
    }

    private static Item registerBlock(final BlockItemId id, final Block block, final Item.Properties properties) {
        return registerBlock(id, block, BlockItem::new, properties);
    }

    private static Item registerBlock(final BlockItemId id, final Block block, final BiFunction<Block, Item.Properties, Item> itemFactory, final Item.Properties properties) {
        return registerItem(id.item(), (p) -> itemFactory.apply(block, p), properties.useBlockDescriptionPrefix().requiredFeatures(block.requiredFeatures()));
    }

    public static void initialize() {
    }
}
