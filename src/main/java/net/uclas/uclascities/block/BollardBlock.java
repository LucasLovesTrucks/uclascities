package net.uclas.uclascities.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class BollardBlock extends Block {

    // Matches the model's "from": [6.5, 0, 6.5], "to": [9.5, 16, 9.5]
    private static final VoxelShape SHAPE = Block.createCuboidShape(6.5, 0, 6.5, 9.5, 16, 9.5);

    public BollardBlock(Settings settings) {
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