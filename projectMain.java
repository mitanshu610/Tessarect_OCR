package imagToText;
import java.io.PrintWriter;
public class projectMain 
{
	public static void main(String[] args) 
	{
		String input_file="C:\\Users\\NITASHA GUPTA\\Desktop\\TestFiles\\imag1.png";
		String output_file="C:\\Users\\NITASHA GUPTA\\Desktop\\TestFiles\\imag1";	
		String tesseract_install_path="D:\\Software\\Tesseract-OCR\\tesseract";
		String[] command =		//used to run the cmd prompt 
	    {
	        "cmd",		
	    };
	    Process p;	//basically interpreted as a process i.e an executing program that can throws nullpointer,securityException
		try 
		{
			p = Runtime.getRuntime().exec(command);		//class runtine allows the application to interface with the environment in which the application is running.
		    new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
	        new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
	        PrintWriter stdin = new PrintWriter(p.getOutputStream());
	        stdin.println("\""+tesseract_install_path+"\" \""+input_file+"\" \""+output_file+"\" -l eng");
	        stdin.close();
	        p.waitFor();	// Returns the exit code returned by the process.
	        System.out.println("\n\n\n");
	        System.out.println(ReadFile.read_a_file(output_file+".txt"));
	    } 
		catch(Exception e)
		{
	 		e.printStackTrace();
		}


	}

}
