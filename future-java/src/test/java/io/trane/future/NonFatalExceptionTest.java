package io.trane.future;

import static org.junit.Assert.*;

import org.junit.Test;

import io.trane.future.NonFatalException;

public class NonFatalExceptionTest {

  @Test(expected = VirtualMachineError.class)
  public void virtualMachineError() {
    NonFatalException.verify(new VirtualMachineError() {
      private static final long serialVersionUID = 1L;
    });
  }
  
  @Test(expected = ThreadDeath.class)
  public void threadDeath() {
    NonFatalException.verify(new ThreadDeath() {
      private static final long serialVersionUID = 1L;
    });
  }
  
  @Test(expected = LinkageError.class)
  public void linkageError() {
    NonFatalException.verify(new LinkageError() {
      private static final long serialVersionUID = 1L;
    });
  }
  
  @Test(expected = RuntimeException.class)
  public void interruptedException() {
    NonFatalException.verify(new InterruptedException());
  }
  
  @Test
  public void nonFatalException() {
    Throwable ex = new NullPointerException();
    Throwable result = NonFatalException.verify(ex);
    assertEquals(ex, result);
  }
}
