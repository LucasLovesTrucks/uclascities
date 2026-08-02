package net.uclas.uclascities.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class SchoolZoneSignBlock extends Block {

    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    // NORTH (default, matches original model coordinates)
    private static final VoxelShape SHAPE_NORTH = VoxelShapes.union(
            Block.createCuboidShape(7, 0, 7, 9, 29, 9),
            Block.createCuboidShape(-9, 0, 7, -7, 29, 9),
            Block.createCuboidShape(-16, 0, 6, 16, 29, 7)
    );

    // SOUTH (180°): x' = 16-x, z' = 16-z
    private static final VoxelShape SHAPE_SOUTH = VoxelShapes.union(
            Block.createCuboidShape(7, 0, 7, 9, 29, 9),
            Block.createCuboidShape(23, 0, 7, 25, 29, 9),
            Block.createCuboidShape(0, 0, 9, 32, 29, 10)
    );

    // EAST (90° clockwise from north): x' = 16-z, z' = x
    private static final VoxelShape SHAPE_EAST = VoxelShapes.union(
            Block.createCuboidShape(7, 0, 7, 9, 29, 9),
            Block.createCuboidShape(7, 0, -9, 9, 29, -7),
            Block.createCuboidShape(9, 0, -16, 10, 29, 16)
    );

    // WEST (270° / 90° counter-clockwise): x' = z, z' = 16-x
    private static final VoxelShape SHAPE_WEST = VoxelShapes.union(
            Block.createCuboidShape(7, 0, 7, 9, 29, 9),
            Block.createCuboidShape(7, 0, 23, 9, 29, 25),
            Block.createCuboidShape(6, 0, 0, 7, 29, 32)
    );

    public SchoolZoneSignBlock(Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(FACING, Direction.NORTH));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return getShapeForState(state);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return getShapeForState(state);
    }

    private VoxelShape getShapeForState(BlockState state) {
        Direction facing = state.get(FACING);
        return switch (facing) {
            case SOUTH -> SHAPE_SOUTH;
            case EAST -> SHAPE_EAST;
            case WEST -> SHAPE_WEST;
            default -> SHAPE_NORTH;
        };
    }
}