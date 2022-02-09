package web;

public class ConnectionThread 
{
	//static int a = 0;
    public static void loop() 
	{
		while(true)
		{
			//System.out.println(a++);
			DbConnection.createConnection();
			try 
			{
				java.util.concurrent.TimeUnit.MINUTES.sleep(15);
			} 
			catch (InterruptedException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
