package net.pm.railed.world.level.block;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.references.BlockItemId;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.pm.railed.references.BlockItemIds;

import java.util.function.Function;

public class Blocks {
    public static final Block SELF_POWERED_RAIL = register(BlockItemIds.SELF_POWERED_RAIL, SelfPoweredRailBlock::new, BlockBehaviour.Properties.ofFullCopy(net.minecraft.world.level.block.Blocks.POWERED_RAIL));

    private static Block register(BlockItemId blockId, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties properties) {
        //block
        Block block = blockFactory.apply(properties.setId(blockId.block()));

        return Registry.register(BuiltInRegistries.BLOCK, blockId.block(), block);
    }

    public static void initialize() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.REDSTONE_BLOCKS).register(content -> {
            content.insertAfter(net.minecraft.world.level.block.Blocks.POWERED_RAIL, SELF_POWERED_RAIL);
        });
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(content -> {
            content.insertAfter(net.minecraft.world.level.block.Blocks.POWERED_RAIL, SELF_POWERED_RAIL);
        });
    }
}
