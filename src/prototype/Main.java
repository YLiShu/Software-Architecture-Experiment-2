package prototype;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        input.input("C:\\Users\\yelishu\\Desktop\\test2\\src\\input.txt");
        Shift shift = new Shift(input.getLineTxt());
        shift.shift();
        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());
        alphabetizer.sort();
        Output output = new Output(alphabetizer.getKwicList());
        output.output("C:\\Users\\yelishu\\Desktop\\test2\\src\\output2.txt");

    }
}
