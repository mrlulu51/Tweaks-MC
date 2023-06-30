package io.github.mrlulu51.tweaksmc.util.parser;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;
import net.minecraft.util.collection.DefaultedList;
import org.jetbrains.annotations.NotNull;

public class NbtParser {

    public static DefaultedList<ItemStack> readNbtToInventory(@NotNull NbtCompound nbt) {
        NbtList list = nbt.getList("Items", NbtElement.COMPOUND_TYPE);
        DefaultedList<ItemStack> stacks = DefaultedList.ofSize(27, ItemStack.EMPTY);

        for (int i = 0; i < list.size(); i++) {
            NbtCompound cmp = list.getCompound(i);
            int j = cmp.getByte("Slot") & 0xFF;
            if(j < 0 || j >= stacks.size()) continue;
            stacks.set(j, ItemStack.fromNbt(cmp));
        }

        return stacks;
    }
}
