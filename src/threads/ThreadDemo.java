package threads;

//Lav et program med to tråde 
//De to tråde skal tilføje ord til den samme streng variabel
//Sørg for at de to tråde skiftes til at tilføje ord
//Sæt en beregning ind for at forsinke eksekveringen
//Brug synchronized til at sikre udelt adgang

class ThreadDemo extends Thread {
	   private Thread t;
	   private String threadName;
	   
	   ThreadDemo( String name) {
	      threadName = name;
	      System.out.println("Creating " +  threadName );
	   }
	   
	   public void run() {
	      System.out.println("Running " +  threadName );
	      try {
	         for(int i = 4; i > 0; i--) {
	        	 String str="Thread "+threadName+" was here. ";
	        	 SharedStringWriter(str);
	            // Let the thread sleep for a while.
	            Thread.sleep(50);
	         }
	      } catch (InterruptedException e) {
	         System.out.println("Thread " +  threadName + " interrupted.");
	      }
	      System.out.println("Thread " +  threadName + " exiting.");
	   }
	
	   private static String sharedString="";
		
	   public static void main(String args[]) {
		  
	      ThreadDemo T1 = new ThreadDemo( "Thread-1");
	      T1.start();
	      
	      ThreadDemo T2 = new ThreadDemo( "Thread-2");
	      T2.start();
	      try {
			T1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	      try {
			T2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	      System.out.println("Shared string is equal to:"+sharedString);
	   }
	   public synchronized void SharedStringWriter(String addWord){
		   sharedString+=addWord;	
	   }
}
	
	

