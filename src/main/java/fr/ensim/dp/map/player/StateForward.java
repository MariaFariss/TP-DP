package fr.ensim.dp.map.player;

public class StateForward implements IStatePlayer{
    @Override
    public void play(IPlayer player) {

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
        throw new IllegalStateException();
    }

    @Override
    public void backward(IPlayer player) {
        player.firechangeState(new StateBackward());

    }
}
