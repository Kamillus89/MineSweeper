package recrutation;

public class App
{
    public static void main( String[] args ) {
        MineSweeper mineSweeper = new MineSweeperImpl();

        mineSweeper.setMineField("*...\n..*.\n....");
        System.out.println(mineSweeper.getHintField());
    }
}
