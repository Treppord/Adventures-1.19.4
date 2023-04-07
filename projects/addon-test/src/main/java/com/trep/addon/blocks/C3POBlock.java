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

public class C3POBlock extends Block {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public C3POBlock(Settings settings) {
        super(settings);
    }

    private static final VoxelShape SHAPE = Block.createCuboidShape(4, 0, 4, 12, 8, 12);
    private static final VoxelShape SHAPE_2 = Block.createCuboidShape(3.85, 0, 3.7, 12.05, 8, 7.35);
    
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.union(SHAPE, SHAPE_2);
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