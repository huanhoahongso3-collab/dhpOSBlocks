package xyz.zekiu.wlodzimiers_blocks.items;

import eu.pb4.polymer.core.api.item.PolymerItem;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import xyz.nucleoid.packettweaker.PacketContext;
import xyz.zekiu.wlodzimiers_blocks.WlodzimiersBlocks;

public class SimpleCustomBlockItem extends BlockItem implements PolymerItem{
    private final Identifier polymerModel;

    public SimpleCustomBlockItem(Settings settings, Block block, String modelId) {
        super(block, settings);
        this.polymerModel = PolymerResourcePackUtils.getBridgedModelId(Identifier.of(WlodzimiersBlocks.MOD_ID, "item/" + modelId));
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, PacketContext player) {
        return Items.BARRIER;
    }

    @Override
    public @Nullable Identifier getPolymerItemModel(ItemStack stack, PacketContext context) {
        return this.polymerModel;
    }
}
