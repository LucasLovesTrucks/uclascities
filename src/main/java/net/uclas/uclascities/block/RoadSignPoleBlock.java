package net.uclas.uclascities.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class RoadSignPoleBlock extends Block {

    private static final VoxelShape SHAPE = Block.createCuboidShape(7, 0, 7, 9, 16, 9);

    public RoadSignPoleBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
}