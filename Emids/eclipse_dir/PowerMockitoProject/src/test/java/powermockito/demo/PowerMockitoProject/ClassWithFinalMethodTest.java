package powermockito.demo.PowerMockitoProject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = "powermockito.demo.PowerMockitoProject.*")
public class ClassWithFinalMethodTest {

	@Test
	public void testFinalPrintMessage() throws Exception
	{
		String message = "Hello Powermockito";
		ClassWithFinalMethod mockObject = PowerMockito.mock(ClassWithFinalMethod.class);
		PowerMockito.whenNew(ClassWithFinalMethod.class).withNoArguments().thenReturn(mockObject);
		
		ClassWithFinalMethod object = new ClassWithFinalMethod();
		PowerMockito.verifyNew(ClassWithFinalMethod.class).withNoArguments();
		
		PowerMockito.when(object.printMessage(message)).thenReturn(message);
		String actualResult = object.printMessage(message);
		Mockito.verify(object).printMessage(message);
		Assert.assertEquals(message, actualResult);
		
	}
}
