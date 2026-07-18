package net.pm.railed.references;

import net.minecraft.core.registries.Registries;
import net.minecraft.references.BlockItemId;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.pm.railed.Railed;

public class BlockItemIds {
    public static final BlockItemId SELF_POWERED_RAIL = createR("self_powered_rail");

    public static BlockItemId createR(final String name) {
        return new BlockItemId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Railed.MOD_ID, name)), ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Railed.MOD_ID, name)));
    }
}
