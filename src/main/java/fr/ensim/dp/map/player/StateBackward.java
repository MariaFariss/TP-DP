package fr.ensim.dp.map.player;

public class StateBackward implements IStatePlayer{
    @Override
    public void play(IPlayer player) {
        throw new IllegalStateException();
    }

    @Override
    public void stop(IPlayer player) {
        player.firechangeState(new StateStop());

    }

    @Override
    public void pause(IPlayer player) {
        throw new IllegalStateException();
    }

    @Override
    public void forward(IPlayer player) {
        player.firechangeState(new StateForward());

    }

    @Override
    public void backward(IPlayer player) {
        throw new IllegalStateException();
    }
}
