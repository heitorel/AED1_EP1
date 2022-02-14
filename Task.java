package ep_aed1;

public class Task {
	
	private String taskCode;
	private Task nextTask;
	
	public Task() {}
	
	public Task(String code) {
		this.taskCode = code;
	}
	
	public String getCode() {
		return this.taskCode;
	}
	
	public Task getNextTask() {
		return this.nextTask;
	}
	
	public void setCode(String code) {
		this.taskCode = code;
	}
	
	public void setNextTask(Task nextTask) {
		this.nextTask = nextTask;
	}

}
