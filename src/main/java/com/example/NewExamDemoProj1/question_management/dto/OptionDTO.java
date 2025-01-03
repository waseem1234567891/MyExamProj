package com.example.NewExamDemoProj1.question_management.dto;

public class OptionDTO {
    private String optionText;
    private boolean isCorrect;

    // Getters and Setters
    public String getOptionText() {
        return optionText;
    }

    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }

    public boolean getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }
}
