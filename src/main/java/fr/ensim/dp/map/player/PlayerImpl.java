package fr.ensim.dp.map.player;

public class PlayerImpl implements IPlayer{

    private IStatePlayer state = new StatePlay();

    @Override
    public void play() {
        state.play(this);
    }

    @Override
    public void stop() {
        state.stop(this);
    }

    @Override
    public void pause() {
        state.pause(this);

    }

    @Override
    public void forward() {
        state.forward(this);

    }

    @Override
    public void backward() {
        state.backward(this);

    }

    @Override
    public void firechangeState(IStatePlayer state) {
        this.state = state;
    }
}
