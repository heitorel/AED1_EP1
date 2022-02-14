package ep_aed1;

public class Pile {
	
	private Task pileHead = null;
	
	public Pile() {}
	
	public Pile(Task head) {
		this.pileHead = head;
	}
	
	public Task getHead() {
		return pileHead;
	}
	
	public void setHead(Task newHead) {
		this.pileHead = newHead;
	}
	
	public boolean isEmpty() {
		if(pileHead == null) {
			return true;
		}else {
			return false;
		}
	}

}
