import org.junit.Test;

import static org.junit.Assert.*;

public class AppMainTest {
    @Test
    public void test() throws Exception {
      AppMain app = new AppMain();
      try {
        app.connectDB();
        app.executeDB();
        app.rollback();
        assertTrue(true);
      } catch (Exception e) {
        e.printStackTrace();
        fail(e.getMessage());
      }
    }
}
