package fr.ensim.dp.map.player;

public class StateForward extends ALLELEGALSTATE{

    @Override
    public void stop(IPlayer player) {
        player.firechangeState(new StateStop());

    }

    @Override
    public void backward(IPlayer player) {
        player.firechangeState(new StateBackward());

    }
}
