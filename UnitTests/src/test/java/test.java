import org.example.Gender;
import org.example.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class test {
        private Player p;

        @Test
        void playerGenderTest1() {
            p = new Player();
            Assertions.assertEquals(p.gender, Gender.MALE);
        }

        @Test
        void playerGenderTest2() {
            p = new Player();
            Assertions.assertEquals(p.gender, Gender.FEMALE);
        }
    }


