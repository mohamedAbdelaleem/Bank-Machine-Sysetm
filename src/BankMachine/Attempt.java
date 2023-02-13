package BankMachine;

import java.time.LocalDateTime;

public class Attempt {
    private LocalDateTime date;
    private boolean status;

    public Attempt(LocalDateTime date){
        this.date = date;
    }

    public LocalDateTime getDate() {
        return this.date;
    }

    public void setStatus(boolean status){
        this.status = status;
    }

    public boolean isSuccessful(){
        return this.status;
    }
}
