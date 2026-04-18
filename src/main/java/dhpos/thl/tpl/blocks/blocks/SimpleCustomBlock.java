package dhpos.thl.tpl.blocks.blocks;

import eu.pb4.polymer.blocks.api.BlockModelType;
import eu.pb4.polymer.blocks.api.PolymerBlockModel;
import eu.pb4.polymer.blocks.api.PolymerBlockResourceUtils;
import eu.pb4.polymer.blocks.api.PolymerTexturedBlock;
import eu.pb4.polymer.core.api.item.PolymerBlockItem;
import xyz.nucleoid.packettweaker.PacketContext;
import dhpos.thl.tpl.blocks.dhpOSBlocks;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class SimpleCustomBlock extends Block implements PolymerTexturedBlock {
    private final BlockState polymerBlockState;
    public static List<Item> items = new ArrayList<>();

    public SimpleCustomBlock(Properties settings, BlockModelType type, String modelId) {
        super(settings);
        this.polymerBlockState = PolymerBlockResourceUtils.requestBlock(type, PolymerBlockModel.of(Identifier.fromNamespaceAndPath(dhpOSBlocks.MOD_ID, "block/" + modelId)));
    }

    private static void register(String modelId, BlockModelType type, BlockBehaviour abstractBlock) {
        var id = Identifier.fromNamespaceAndPath(dhpOSBlocks.MOD_ID, modelId);
        var block = Registry.register(BuiltInRegistries.BLOCK, id,
                new SimpleCustomBlock(Properties.ofFullCopy(abstractBlock).setId(ResourceKey.create(Registries.BLOCK, id)), type, modelId));
        var item = new PolymerBlockItem(block, new Item.Properties().useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, id)), abstractBlock.asItem(), true);
        items.add(item);

        Registry.register(BuiltInRegistries.ITEM, id, item);
    }

    public static void registerBlocks() {
        register("chau", BlockModelType.FULL_BLOCK, Blocks.STONE);
        register("dangminh", BlockModelType.FULL_BLOCK, Blocks.STONE);
        register("danh", BlockModelType.FULL_BLOCK, Blocks.STONE);
        register("dat", BlockModelType.FULL_BLOCK, Blocks.STONE);
        register("diep", BlockModelType.FULL_BLOCK, Blocks.STONE);
        register("ducanh", BlockModelType.FULL_BLOCK, Blocks.STONE);
        register("duongminh", BlockModelType.FULL_BLOCK, Blocks.STONE);
        register("duong", BlockModelType.FULL_BLOCK, Blocks.STONE);
        register("giang", BlockModelType.FULL_BLOCK, Blocks.STONE);
        register("hai", BlockModelType.FULL_BLOCK, Blocks.STONE);
        register("haminh", BlockModelType.FULL_BLOCK, Blocks.STONE);
        register("hoaian", BlockModelType.FULL_BLOCK, Blocks.STONE);
        register("khanh", BlockModelType.FULL_BLOCK, Blocks.STONE);
        register("khanhs", BlockModelType.FULL_BLOCK, Blocks.STONE);
        register("kieuthao", BlockModelType.FULL_BLOCK, Blocks.STONE);
        register("lam", BlockModelType.FULL_BLOCK, Blocks.STONE);
        register("myan", BlockModelType.FULL_BLOCK, Blocks.STONE);
        register("ngan", BlockModelType.FULL_BLOCK, Blocks.STONE);
        register("ngocanh", BlockModelType.FULL_BLOCK, Blocks.STONE);
        register("nguyenlinh", BlockModelType.FULL_BLOCK, Blocks.STONE);
        register("nguyenminh", BlockModelType.FULL_BLOCK, Blocks.STONE);
        register("nguyenphuc", BlockModelType.FULL_BLOCK, Blocks.STONE);
        register("nhatminh", BlockModelType.FULL_BLOCK, Blocks.STONE);
        register("phuong", BlockModelType.FULL_BLOCK, Blocks.STONE);
        register("quynh", BlockModelType.FULL_BLOCK, Blocks.STONE);
        register("tai", BlockModelType.FULL_BLOCK, Blocks.STONE);
        register("thai", BlockModelType.FULL_BLOCK, Blocks.STONE);
        register("thanh", BlockModelType.FULL_BLOCK, Blocks.STONE);
        register("thlinh", BlockModelType.FULL_BLOCK, Blocks.STONE);
        register("tplinh", BlockModelType.FULL_BLOCK, Blocks.STONE);
        register("truc", BlockModelType.FULL_BLOCK, Blocks.STONE);
        register("uyen", BlockModelType.FULL_BLOCK, Blocks.STONE);
        register("vhlinh", BlockModelType.FULL_BLOCK, Blocks.STONE);
        register("vuthao", BlockModelType.FULL_BLOCK, Blocks.STONE);
    }

    @Override
    public BlockState getPolymerBlockState(BlockState state, PacketContext context) {
        return this.polymerBlockState;
    }
}
