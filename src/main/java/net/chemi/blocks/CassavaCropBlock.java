package net.chemi.blocks;

import net.minecraft.block.*;
import net.minecraft.item.ItemConvertible;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

import static net.chemi.FufuFun.CASSAVA_STEM;

public class CassavaCropBlock extends CropBlock {
    public static final IntProperty AGE = IntProperty.of("age", 0, 7);

    private static final VoxelShape[] AGE_TO_SHAPE = new VoxelShape[]{
            Block.createCuboidShape(4.0D, 0.0D, 7.0D, 9.0D, 6.0D, 9.0D),
            Block.createCuboidShape(4.0D, 0.0D, 7.0D, 9.0D, 6.0D, 9.0D),
            Block.createCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 16.0D, 11.0D),
            Block.createCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 16.0D, 11.0D),
            Block.createCuboidShape(2.0D, 0.0D, 0.0D, 15.0D, 29.0D, 16.0D),
            Block.createCuboidShape(2.0D, 0.0D, 0.0D, 15.0D, 29.0D, 16.0D),
            Block.createCuboidShape(1.0D, 0.0D, 0.0D, 16.0D, 31.0D, 16.0D),
            Block.createCuboidShape(1.0D, 0.0D, 0.0D, 16.0D, 31.0D, 16.0D)
    };

    public CassavaCropBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return AGE_TO_SHAPE[state.get(this.getAgeProperty())];

    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return CASSAVA_STEM;
    }

    public int getMaxAge() {
        return 7;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}