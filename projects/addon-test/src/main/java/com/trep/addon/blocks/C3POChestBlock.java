package com.trep.addon.blocks;

        import net.minecraft.block.*;
        import net.minecraft.item.ItemPlacementContext;
        import net.minecraft.state.StateManager;
        import net.minecraft.state.property.DirectionProperty;
        import net.minecraft.state.property.Properties;
        import net.minecraft.util.*;
        import net.minecraft.util.math.BlockPos;
        import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
        import org.jetbrains.annotations.Nullable;

public class C3POChestBlock extends Block {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public C3POChestBlock(Settings settings) {
        super(settings);
    }

    private static VoxelShape SHAPE = VoxelShapes.empty();

    static {
        SHAPE = VoxelShapes.union(
            SHAPE,
            Block.createCuboidShape(1, 4, 6, 4, 10, 10),
            Block.createCuboidShape(1, 11, 6, 4, 16, 10),
            Block.createCuboidShape(3, 10, 7, 9, 11, 9),
            Block.createCuboidShape(12, 4, 6, 15, 10, 10),
            Block.createCuboidShape(12, 11, 6, 15, 16, 10),
            Block.createCuboidShape(13, 10, 7, 14, 11, 9),
            Block.createCuboidShape(4, 8, 6, 12, 16, 10),
            Block.createCuboidShape(4, 0, 6, 12, 4, 10),
            Block.createCuboidShape(5, 11, 7, 11, 14, 10),
            Block.createCuboidShape(6, 10, 7, 10, 11, 9),
            Block.createCuboidShape(4, 5, 7, 5, 7, 10),
            Block.createCuboidShape(5, 7, 7, 11, 8, 10),
            Block.createCuboidShape(4, 4, 6, 12, 5, 10),
            Block.createCuboidShape(10, 5, 6, 12, 8, 10),
            Block.createCuboidShape(4, 5, 6, 5, 8, 10)
        );
    }
    
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerLookDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }


    /* BLOCK ENTITY */

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
}