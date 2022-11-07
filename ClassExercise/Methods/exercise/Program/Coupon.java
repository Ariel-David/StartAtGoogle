package startAtGoogle.Methods.exercise.Program;

import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

class Coupon {
    public int id;
    public LocalDate expiry_date;
    public final int value;
    generator g = new generator();

    public Coupon() {
      id = ThreadLocalRandom.current().nextInt(999999);
      expiry_date = LocalDate.now().plusDays(ThreadLocalRandom.current().nextInt(365));
      value = ThreadLocalRandom.current().nextInt(999);
    }
}
