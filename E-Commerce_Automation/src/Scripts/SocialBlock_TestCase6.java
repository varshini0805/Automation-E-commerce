package Scripts;

import org.testng.annotations.Test;

import Generic.BaseTest;
import POM.SocialBlock;

public class SocialBlock_TestCase6 extends BaseTest {
	
	@Test
	public void testing() throws InterruptedException
	{
		SocialBlock sb = new SocialBlock(driver);
		//sb.facebook();
		sb.switchToChild();
	}

}
