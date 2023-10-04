package fop.w11dining;

public class Penguin implements Runnable {
	
	private String name;
	private Table table;
	private int index;

	public Penguin(String name, Table table, int index) {
		this.name =  name;
		this.table = table;
		this.index = index;
	}

	public void eat() {


		for(int i = 1; i <= 2; i++) {
			while(!table.forkAvailable()) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
		            System.out.println("Something went wrong. Interrupted!");
		            return;
		        }
	    	}

			if(table.getForks()%2 == 0 || table.getPenguinfork(index) > 0)
	    	table.takeFork(index);
	    	System.out.println(name + " takes fork #" + i);

	    	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
		        System.out.println("Something went wrong. Interrupted!");
		        return;
		    }
		    
    	}

    	System.out.println(name + " ate.");

		table.returnFork(index);
		table.returnFork(index);
	}

	@Override
	public void run() {
		eat();
	}

}