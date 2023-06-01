package net.chemi;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

import static net.chemi.FufuFun.CASSAVA_CROP_BLOCK;

@Environment(EnvType.CLIENT)
public class FufuFunClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), CASSAVA_CROP_BLOCK);
    }
}
