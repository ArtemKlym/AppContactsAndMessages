package challenge1;

public class Message {
    private String text;
    private int id;
    private String name;

    public Message(String text, int id, String name) {
        this.text = text;
        this.id = id;
        this.name = name;
    }

    public void getDetails(){
        System.out.println("Contact Name: "+ name+
                "\nMessage: "+text+""+
                "\nId: "+id);
    }
}
