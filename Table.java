package fop.w11dining;

public class Table {

	int forks;
	int[] penguin = new int[4];

	public Table(int forks) {
		this.forks = forks;
	}

	public int getPenguinfork(int index) {
		return penguin[index - 1];
	}

	public int getForks() {
		return forks;
	}

	public boolean forkAvailable() {
		return forks > 0;
	}

	public void takeFork(int index) {
		forks--;
		penguin[index - 1] ++;
	}

	public void returnFork(int index) {
		forks++;
		penguin[index - 1]--;
	}

}