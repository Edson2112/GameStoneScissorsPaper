package ua.edson.stonepaper;

public class MemorySaver extends Saver {

    private Integer savedNumber1;
    private Integer savedNumber2;

    @Override
    public void saveScore(Integer number1, Integer number2) {

        savedNumber1 = number1;
        savedNumber2 = number2;
    }

    @Override
    public Integer getScore(Integer number1, Integer number2) {
        return savedNumber1 + savedNumber2;
    }
}
