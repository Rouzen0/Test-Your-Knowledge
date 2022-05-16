

package test.your.knowladge;


public abstract class QandA {
    
    private final int numOfQuestion=4;
    
    public final void play(){
        for (int i = 0; i < numOfQuestion; i++) {
            questions();
            answer();         
        }
        result();
    }
    public abstract void questions();
    public abstract void answer();
    public abstract void result();

    public int getNumOfQuestion() {
        return numOfQuestion;
    }
    
    
    
}
