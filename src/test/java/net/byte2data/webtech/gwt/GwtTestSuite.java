package net.byte2data.webtech.gwt;

import net.byte2data.webtech.gwt.client.GwtTestTest;
import com.google.gwt.junit.tools.GWTTestSuite;
import junit.framework.Test;
import junit.framework.TestSuite;

public class GwtTestSuite extends GWTTestSuite {
  public static Test suite() {
    TestSuite suite = new TestSuite("Tests for GwtTest");
    suite.addTestSuite(GwtTestTest.class);
    return suite;
  }
}
