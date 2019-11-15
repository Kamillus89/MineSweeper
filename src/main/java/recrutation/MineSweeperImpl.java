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
        StringBuilder hintField = new StringBuilder("");
        List<List<String>> hintFieldArray = new ArrayList<>(new ArrayList<>());

        for (List<String> stringList : mineFieldArray) {
            hintFieldArray.add(Arrays.asList(new String[mineFieldArray.get(0).size()]));
        }

        int mineCounter;

        for (int i = 0; i < mineFieldArray.size(); i++) {
            for (int j = 0; j < mineFieldArray.get(0).size(); j++) {
                mineCounter = 0;
                if (i > 0 && j > 0 && mineFieldArray.get(i - 1).get(j - 1).equals("*")) {
                    mineCounter++;
                }
                if (j > 0 && mineFieldArray.get(i).get(j - 1).equals("*")) {
                    mineCounter++;
                }
                if (i > 0 && mineFieldArray.get(i - 1).get(j).equals("*")) {
                    mineCounter++;
                }
                if (i < mineFieldArray.size() - 1 && mineFieldArray.get(i+1).get(j).equals("*")) {
                    mineCounter++;
                }
                if (j < mineFieldArray.size() -1 && mineFieldArray.get(i).get(j+1).equals("*")) {
                    mineCounter++;
                }
                if (i > 0 && j < mineFieldArray.size()-1 && mineFieldArray.get(i-1).get(j+1).equals("*")) {
                    mineCounter++;
                }
                if (i < mineFieldArray.size()-1 && j > 0 && mineFieldArray.get(i+1).get(j-1).equals("*")) {
                    mineCounter++;
                }
                if (i < mineFieldArray.size()-1 && j < mineFieldArray.size()-1 && mineFieldArray.get(i+1).get(j+1).equals("*")) {
                    mineCounter++;
                }
                if (!mineFieldArray.get(i).get(j).equals("*")) {
                    hintFieldArray.get(i).set(j,String.valueOf(mineCounter));
                } else if (mineFieldArray.get(i).get(j).equals("*")) {
                    hintFieldArray.get(i).set(j,"*");
                }
            }
        }

        for (List<String> stringList : hintFieldArray ) {
            for (String str : stringList) {
                hintField.append(str);
            }
            hintField.append(" \n");
        }

        return hintField.toString();
    }
}
