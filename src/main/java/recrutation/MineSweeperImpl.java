package recrutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MineSweeperImpl implements MineSweeper {

    private List<List<String>> mineFieldArray = new ArrayList<>(new ArrayList<>());

    @Override
    public void setMineField(String mineField) throws IllegalArgumentException {
        String[] lines = mineField.split("\n");
        for (int i = 0; i < lines.length - 1; i++) {
            if (checkIfAllLinesHaveSameSize(lines, i)) {
                throw new IllegalArgumentException();
            }
        }
        for (String line : lines) {
            mineFieldArray.add(Arrays.asList(line.split("")));
        }

        // to delete
        for (List<String> line : mineFieldArray) {
            System.out.println(line.toString());
        }
    }

    private boolean checkIfAllLinesHaveSameSize(String[] lines, int i) {
        return lines[i].length() != lines[i+1].length();
    }

    @Override
    public String getHintField() throws IllegalStateException {
        return null;
    }
}
