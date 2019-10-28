package com.system.design.systemdesign.chessv1;

public class Pawn extends Piece {
    public Pawn(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Board board, Box start, Box end) {
        return false;
    }
}
