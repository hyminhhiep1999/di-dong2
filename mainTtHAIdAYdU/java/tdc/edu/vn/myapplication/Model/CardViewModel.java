package tdc.edu.vn.myapplication.Model;

public class CardViewModel {
    String cardName;
    //pizza 1 vaf 2 sinh ra tu` day
    int imageResourceId;

    public CardViewModel(String cardName, int imageResourceId) {
        this.cardName = cardName;
        this.imageResourceId = imageResourceId;
    }

    public CardViewModel() {
    }
    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }
}

