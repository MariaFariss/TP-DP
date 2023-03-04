package fr.ensim.dp.map.player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerImplTest {

    @Test
    public void TestAll() {
        IPlayer player = new PlayerImpl();

        //assertThrows( IllegalStateException.class, () -> player.play());

        player.pause();
        assertThrows( IllegalStateException.class, () -> player.pause());
        assertThrows( IllegalStateException.class, () -> player.forward());
        assertThrows( IllegalStateException.class, () -> player.backward());
        assertThrows( IllegalStateException.class, () -> player.stop());

        player.play();

        player.stop();
        assertThrows( IllegalStateException.class, () -> player.pause());
        assertThrows( IllegalStateException.class, () -> player.forward());
        assertThrows( IllegalStateException.class, () -> player.backward());
        assertThrows( IllegalStateException.class, () -> player.stop());

        player.play();

        player.backward();
        assertThrows( IllegalStateException.class, () -> player.pause());
        assertThrows( IllegalStateException.class, () -> player.play());
        assertThrows( IllegalStateException.class, () -> player.backward());

        player.forward();
        assertThrows( IllegalStateException.class, () -> player.pause());
        assertThrows( IllegalStateException.class, () -> player.play());
        assertThrows( IllegalStateException.class, () -> player.forward());
    }

}