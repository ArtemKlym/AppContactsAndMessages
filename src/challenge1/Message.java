package challenge1;

public class Message {
    private String text;
    private int number;
    private String name;

    public Message(String text, int number, String name) {
        this.text = text;
        this.number = number;
        this.name = name;
    }

    public void getDetails(){
        System.out.println("Contact Name: "+ name+
                "\nMessage: "+text+""+
                "\nNumber: "+number);
    }

    public String getText() {
        return text;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }
}
