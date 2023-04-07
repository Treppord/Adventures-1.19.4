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

public class C3POLegsBlock extends Block {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public C3POLegsBlock(Settings settings) {
        super(settings);
    }

    private static final VoxelShape SHAPE = VoxelShapes.union(
        Block.createCuboidShape(6.3, 0, 6, 9.3, 6, 10),
        Block.createCuboidShape(6.3, 7, 6, 9.3, 12, 10),
        Block.createCuboidShape(7, 6, 6.5, 11, 7, 9.5),
        Block.createCuboidShape(3.3, 0, 6, 7.3, 6, 10),
        Block.createCuboidShape(3.3, 12, 6, 7.3, 16, 10),
        Block.createCuboidShape(6.3, 12, 6, 9.3, 16, 10),
        Block.createCuboidShape(3.3, 7, 6, 7.3, 12, 10),
        Block.createCuboidShape(4.6, 6, 6.5, 6.8, 7, 9.5)
    );
    
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