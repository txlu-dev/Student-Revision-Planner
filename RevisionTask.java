public class RevisionTask {

   
    private String title;
    private boolean completed;

    // Constructor to create a new RevisionTask
    public RevisionTask(String title) {
        this.title = title;
        this.completed = false;
    }
    
    
    // Mark task as complete
    public void markComplete() {
        completed = true;
    }
    
    // Returns the title of the task
    public String getTitle() {
        return title;
    }
    
    // Returns the completion state
    public boolean getComplete() {
        if (completed) {
        	return true;}
        else {
        	return false;}
    }
    
    
    
    
    
    
}