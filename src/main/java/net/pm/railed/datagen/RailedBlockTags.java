package net.pm.railed.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.pm.railed.references.BlockItemIds;

import java.util.concurrent.CompletableFuture;

public class RailedBlockTags extends FabricTagsProvider.BlockTagsProvider{
    public RailedBlockTags(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        tag(BlockTags.PREVENT_MOB_SPAWNING_INSIDE)
                .add(BlockItemIds.SELF_POWERED_RAIL.block());
        tag(BlockTags.RAILS)
                .add(BlockItemIds.SELF_POWERED_RAIL.block());
    }
}
