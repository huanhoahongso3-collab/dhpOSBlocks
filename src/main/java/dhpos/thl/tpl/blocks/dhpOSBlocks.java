package dhpos.thl.tpl.blocks;

import eu.pb4.polymer.core.api.item.PolymerItemGroupUtils;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.fabricmc.api.ModInitializer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dhpos.thl.tpl.blocks.blocks.SimpleCustomBlock;

public class dhpOSBlocks implements ModInitializer {
    public static final String MOD_ID = "dhpos_blocks";
    public static final Logger LOGGER = LoggerFactory.getLogger("dhpOSBlocks");

    @Override
    public void onInitialize() {
        PolymerResourcePackUtils.addModAssets(MOD_ID);
        PolymerResourcePackUtils.markAsRequired();

        SimpleCustomBlock.registerBlocks();
        PolymerItemGroupUtils.registerPolymerItemGroup(
                Identifier.fromNamespaceAndPath(MOD_ID, MOD_ID),
                new CreativeModeTab.Builder(CreativeModeTab.Row.BOTTOM, -1)
                        .title(Component.translatable("itemgroup.dhpos_blocks"))
                        .icon(() -> new ItemStack(SimpleCustomBlock.items.get(0)))
                        .displayItems(((c, e) -> {
                            for (Item item : SimpleCustomBlock.items) e.accept(item);
                        }))
                        .build());
        LOGGER.info("dhpOS Blocks zostało załadowane miaał");
    }
}
