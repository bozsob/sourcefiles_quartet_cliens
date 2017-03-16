import java.io.Serializable;
import java.util.List;

/**
 * Created by trixi on 2017.03.16..
 */
public class Message implements Serializable{

    private boolean winner;
    private List<String> cardIDlist;
    private String clientResponse;

    public Message(boolean winner, List<String> cardIDlist) {
        this.winner = winner;
        this.cardIDlist = cardIDlist;
    }

    public Message(String clientResponse) {
        this.clientResponse = clientResponse;
    }

    public boolean isWinner() {
        return winner;
    }

    public List<String> getCardIDlist() {
        return cardIDlist;
    }

    public String getClientResponse() {
        return clientResponse;
    }
}
