package io.github.randomusert.mods.randomuserts_utils.compat.refinedstorage.storage;

import com.refinedmods.refinedstorage.common.storage.StorageVariant;
import net.minecraft.world.item.Item;
import org.jspecify.annotations.Nullable;

public enum CustomItemstorageVariant implements StorageVariant {
    TIER_5(256),
    TIER_6(1024);

    private final Long capacity;
    private final String name;
    private final Long energyUsage;

    CustomItemstorageVariant(int capacity) {
        this.name = capacity + "k";
        this.capacity = capacity * 1000L;
        this.energyUsage = (long) ((this.ordinal() + 5) * 2);
    }

    @Override
    public @Nullable Long getCapacity() {
        return capacity;
    }

    @Override
    public @Nullable Item getStoragePart() {
        return null;
    }

    @Override
    public String getName() {
        return name;
    }
}
