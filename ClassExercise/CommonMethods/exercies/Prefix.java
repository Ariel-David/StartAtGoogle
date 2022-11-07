package startAtGoogle.CommonMethods.exercies;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Prefix {
   MR, MRS , MS;

   private static final List<Prefix> VALUES =
           Collections.unmodifiableList(Arrays.asList(values()));
   private static final int SIZE = VALUES.size();
   private static final Random RANDOM = new Random();

   public static Prefix randomPrefix()  {
      return VALUES.get(RANDOM.nextInt(SIZE));
   }
}
