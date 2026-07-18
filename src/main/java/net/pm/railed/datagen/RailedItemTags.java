package net.pm.railed.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import net.pm.railed.references.BlockItemIds;

import java.util.concurrent.CompletableFuture;

public class RailedItemTags extends FabricTagsProvider.ItemTagsProvider{
    public RailedItemTags(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ItemTags.RAILS)
                .add(BlockItemIds.SELF_POWERED_RAIL.item());
    }
}
