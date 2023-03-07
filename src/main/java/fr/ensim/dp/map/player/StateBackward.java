package fr.ensim.dp.map.player;

public class StateBackward extends ALLELEGALSTATE {

    @Override
    public void stop(IPlayer player) {
        player.firechangeState(new StateStop());

    }

    @Override
    public void forward(IPlayer player) {
        player.firechangeState(new StateForward());

    }

}
